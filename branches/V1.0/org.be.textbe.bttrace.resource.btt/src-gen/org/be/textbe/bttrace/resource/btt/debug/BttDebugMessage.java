/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class BttDebugMessage {
	
	private static final char DELIMITER = ':';
	private org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes messageType;
	private String[] arguments;
	
	public BttDebugMessage(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public BttDebugMessage(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return org.be.textbe.bttrace.resource.btt.util.BttStringUtil.encode(DELIMITER, parts);
	}
	
	public static BttDebugMessage deserialize(String response) {
		java.util.List<String> parts = org.be.textbe.bttrace.resource.btt.util.BttStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes type = org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes.valueOf(messageType);
		BttDebugMessage message = new BttDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(org.be.textbe.bttrace.resource.btt.debug.EBttDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + org.be.textbe.bttrace.resource.btt.util.BttStringUtil.explode(arguments, ", ") + "]";
	}
	
}
