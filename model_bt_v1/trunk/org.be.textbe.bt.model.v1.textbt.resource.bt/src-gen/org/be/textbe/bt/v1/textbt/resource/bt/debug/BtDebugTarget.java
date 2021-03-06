/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bt.v1.textbt.resource.bt.debug;

public class BtDebugTarget extends org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugElement implements org.eclipse.debug.core.model.IDebugTarget, org.be.textbe.bt.v1.textbt.resource.bt.debug.IBtDebugEventListener {
	
	/**
	 * associated system process
	 */
	private org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugProcess process;
	
	private java.net.Socket eventSocket;
	
	private java.io.BufferedReader eventReader;
	
	/**
	 * containing launch object
	 */
	private org.eclipse.debug.core.ILaunch launch;
	
	private org.eclipse.debug.core.model.IThread[] threads;
	
	private org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugThread thread;
	
	private boolean terminated = false;
	
	/**
	 * event dispatch job
	 */
	private DebugEventDispatcher eventDispatch;
	/**
	 * event listeners
	 */
	private java.util.List<org.be.textbe.bt.v1.textbt.resource.bt.debug.IBtDebugEventListener> eventListeners = new java.util.ArrayList<org.be.textbe.bt.v1.textbt.resource.bt.debug.IBtDebugEventListener>();
	
	private org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugProxy debugProxy;
	
	private class DebugEventDispatcher extends org.eclipse.core.runtime.jobs.Job {
		
		private org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugCommunicationHelper communicationHelper = new org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugCommunicationHelper();
		
		public DebugEventDispatcher() {
			super(new org.be.textbe.bt.v1.textbt.resource.bt.mopp.BtMetaInformation().getSyntaxName() + " Event Dispatch");
			setSystem(true);
		}
		
		protected org.eclipse.core.runtime.IStatus run(org.eclipse.core.runtime.IProgressMonitor monitor) {
			while (!isTerminated()) {
				org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugMessage message = communicationHelper.receive(eventReader);
				if (message != null) {
					notifyListeners(message);
				} else {
					terminated();
					break;
				}
			}
			return org.eclipse.core.runtime.Status.OK_STATUS;
		}
		
		private void notifyListeners(org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugMessage message) {
			Object[] listeners = eventListeners.toArray();
			for (int i = 0; i < listeners.length; i++) {
				((org.be.textbe.bt.v1.textbt.resource.bt.debug.IBtDebugEventListener) listeners[i]).handleMessage(message);
			}
		}
	}
	
	public BtDebugTarget(org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugProcess process, org.eclipse.debug.core.ILaunch launch, int requestPort, int eventPort) {
		super(launch.getDebugTarget());
		this.process = process;
		this.launch = launch;
		this.thread = new org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugThread(this);
		this.threads = new org.eclipse.debug.core.model.IThread[] {this.thread};
		
		// initialize debug proxy
		try {
			this.debugProxy = new org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugProxy(this, requestPort);
		} catch (java.net.UnknownHostException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		
		// initialize asynchronous event dispatcher
		try {
			// creating event client socket (trying to connect)...
			this.eventSocket = new java.net.Socket("localhost", eventPort);
			// creating event client socket - done (connected).
			this.eventReader = new java.io.BufferedReader(new java.io.InputStreamReader(this.eventSocket.getInputStream()));
		} catch (java.net.ConnectException e) {
			throw new RuntimeException("Can't create socket: " + e.getMessage());
		} catch (java.net.UnknownHostException e) {
			throw new RuntimeException("Can't create socket: " + e.getMessage());
		} catch (java.io.IOException e) {
			throw new RuntimeException("Can't create socket: " + e.getMessage());
		}
		
		this.eventDispatch = new DebugEventDispatcher();
		this.eventDispatch.schedule();
		
		addEventListener(this);
		addEventListener(this.thread);
		addEventListener(this.process);
		
		org.eclipse.debug.core.DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
	}
	
	/**
	 * Registers the given event listener. The listener will be notified of events in
	 * the program being interpreted. Has no effect if the listener is already
	 * registered.
	 * 
	 * @param listener event listener
	 */
	public void addEventListener(org.be.textbe.bt.v1.textbt.resource.bt.debug.IBtDebugEventListener listener) {
		if (!eventListeners.contains(listener)) {
			eventListeners.add(listener);
		}
	}
	
	/**
	 * Deregisters the given event listener. Has no effect if the listener is not
	 * currently registered.
	 * 
	 * @param listener event listener
	 */
	public void removeEventListener(org.be.textbe.bt.v1.textbt.resource.bt.debug.IBtDebugEventListener listener) {
		eventListeners.remove(listener);
	}
	
	public String getName() throws org.eclipse.debug.core.DebugException {
		return new org.be.textbe.bt.v1.textbt.resource.bt.mopp.BtMetaInformation().getSyntaxName() + " model";
	}
	
	public org.eclipse.debug.core.model.IDebugTarget getDebugTarget() {
		return this;
	}
	
	public org.eclipse.debug.core.model.IProcess getProcess() {
		return process;
	}
	
	public org.eclipse.debug.core.model.IThread[] getThreads() throws org.eclipse.debug.core.DebugException {
		return threads;
	}
	
	public boolean hasThreads() throws org.eclipse.debug.core.DebugException {
		return true;
	}
	
	public boolean supportsBreakpoint(org.eclipse.debug.core.model.IBreakpoint breakpoint) {
		return breakpoint.getModelIdentifier().equals(getModelIdentifier());
	}
	
	public org.eclipse.debug.core.ILaunch getLaunch() {
		return launch;
	}
	
	public boolean canTerminate() {
		return getProcess().canTerminate();
	}
	
	public boolean isTerminated() {
		return terminated || getProcess().isTerminated();
	}
	
	public void terminate() throws org.eclipse.debug.core.DebugException {
		getThread().terminate();
	}
	
	private synchronized void terminated() {
		terminated = true;
		threads = new org.eclipse.debug.core.model.IThread[0];
		fireTerminateEvent();
		removeEventListener(this);
		removeEventListener(this.thread);
		removeEventListener(this.process);
		org.eclipse.debug.core.DebugPlugin debugPlugin = org.eclipse.debug.core.DebugPlugin.getDefault();
		try {
			debugPlugin.getBreakpointManager().removeBreakpointListener(this);
		} catch (NullPointerException npe) {
			// this is a workaround for Eclipse bug 352315 (see
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=352315)
		}
		getDebugProxy().terminate();
	}
	
	public boolean canResume() {
		return getThread().canResume();
	}
	
	public boolean canSuspend() {
		return getThread().canSuspend() && !isTerminated();
	}
	
	public boolean isSuspended() {
		return getThread().isSuspended();
	}
	
	public void resume() throws org.eclipse.debug.core.DebugException {
		getThread().resume();
	}
	
	public org.eclipse.debug.core.model.IThread getThread() {
		return thread;
	}
	
	public void suspend() throws org.eclipse.debug.core.DebugException {
		getThread().suspend();
	}
	
	public void breakpointAdded(org.eclipse.debug.core.model.IBreakpoint breakpoint) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if ((breakpoint.isEnabled() && getBreakpointManager().isEnabled()) || !breakpoint.isRegistered()) {
					org.be.textbe.bt.v1.textbt.resource.bt.debug.BtLineBreakpoint lineBreakpoint = (org.be.textbe.bt.v1.textbt.resource.bt.debug.BtLineBreakpoint) breakpoint;
					lineBreakpoint.install(this);
				}
			} catch (org.eclipse.core.runtime.CoreException e) {
			}
		}
	}
	
	public void breakpointRemoved(org.eclipse.debug.core.model.IBreakpoint breakpoint, org.eclipse.core.resources.IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if ((breakpoint.isEnabled() && getBreakpointManager().isEnabled()) || !breakpoint.isRegistered()) {
					org.be.textbe.bt.v1.textbt.resource.bt.debug.BtLineBreakpoint lineBreakpoint = (org.be.textbe.bt.v1.textbt.resource.bt.debug.BtLineBreakpoint) breakpoint;
					lineBreakpoint.remove(this);
				}
			} catch (org.eclipse.core.runtime.CoreException e) {
			}
		}
	}
	
	public void breakpointChanged(org.eclipse.debug.core.model.IBreakpoint breakpoint, org.eclipse.core.resources.IMarkerDelta delta) {
	}
	
	public boolean canDisconnect() {
		// not supported
		return false;
	}
	
	public void disconnect() throws org.eclipse.debug.core.DebugException {
	}
	
	public boolean isDisconnected() {
		return false;
	}
	
	public org.eclipse.debug.core.model.IMemoryBlock getMemoryBlock(long startAddress, long length) throws org.eclipse.debug.core.DebugException {
		return null;
	}
	
	public boolean supportsStorageRetrieval() {
		return false;
	}
	
	/**
	 * Notification we have connected to the VM and it has started. Resume the VM.
	 */
	private void started() {
		fireCreationEvent();
		installDeferredBreakpoints();
		try {
			resume();
		} catch (org.eclipse.debug.core.DebugException e) {
		}
	}
	
	/**
	 * Install breakpoints that are already registered with the breakpoint manager.
	 */
	private void installDeferredBreakpoints() {
		org.eclipse.debug.core.model.IBreakpoint[] breakpoints = getBreakpointManager().getBreakpoints(getModelIdentifier());
		for (int i = 0; i < breakpoints.length; i++) {
			breakpointAdded(breakpoints[i]);
		}
	}
	
	public void handleMessage(org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugMessage message) {
		try {
			if (message.hasType(org.be.textbe.bt.v1.textbt.resource.bt.debug.EBtDebugMessageTypes.STARTED)) {
				started();
			} else if (message.hasType(org.be.textbe.bt.v1.textbt.resource.bt.debug.EBtDebugMessageTypes.SUSPENDED)) {
				suspend();
			} else if (message.hasType(org.be.textbe.bt.v1.textbt.resource.bt.debug.EBtDebugMessageTypes.TERMINATED)) {
				terminated();
			} else if (message.hasType(org.be.textbe.bt.v1.textbt.resource.bt.debug.EBtDebugMessageTypes.RESUMED)) {
				// ignore, this event is handled by the debug thread
			} else {
				System.out.println("ERROR in " + this.getClass().getName() + ".handleMessage(): unknown event " + message);
			}
		} catch (org.eclipse.debug.core.DebugException e) {
			e.printStackTrace();
		}
	}
	
	public org.be.textbe.bt.v1.textbt.resource.bt.debug.BtDebugProxy getDebugProxy() {
		return this.debugProxy;
	}
	
}
