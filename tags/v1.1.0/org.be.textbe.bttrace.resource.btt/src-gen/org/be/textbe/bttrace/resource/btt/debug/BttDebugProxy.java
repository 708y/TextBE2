/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class BttDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private org.be.textbe.bttrace.resource.btt.debug.BttDebugTarget debugTarget;
	
	private org.be.textbe.bttrace.resource.btt.debug.BttDebugCommunicationHelper communicationHelper = new org.be.textbe.bttrace.resource.btt.debug.BttDebugCommunicationHelper();
	
	public BttDebugProxy(org.be.textbe.bttrace.resource.btt.debug.BttDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		// creating client proxy socket (trying to connect)...
		java.net.Socket client = new java.net.Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			java.io.BufferedInputStream input = new java.io.BufferedInputStream(client.getInputStream());
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			output = new java.io.PrintStream(client.getOutputStream());
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.EXIT);
	}
	
	public org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage getStack() {
		return sendCommandAndRead(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage message = new org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage message = new org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage response = sendCommandAndRead(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage response = sendCommandAndRead(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		org.be.textbe.bttrace.resource.btt.debug.BttDebugVariable[] variables  = new org.be.textbe.bttrace.resource.btt.debug.BttDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = org.be.textbe.bttrace.resource.btt.util.BttStringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			java.util.Map<String, Long> childVariables = new java.util.TreeMap<String, Long>(new java.util.Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			org.eclipse.debug.core.model.IValue value = new org.be.textbe.bttrace.resource.btt.debug.BttDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			org.be.textbe.bttrace.resource.btt.debug.BttDebugVariable variable = new org.be.textbe.bttrace.resource.btt.debug.BttDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes command, String... parameters) {
		org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage message = new org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage sendCommandAndRead(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes command, String... parameters) {
		org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage message = new org.be.textbe.bttrace.resource.btt.debug.BttDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
