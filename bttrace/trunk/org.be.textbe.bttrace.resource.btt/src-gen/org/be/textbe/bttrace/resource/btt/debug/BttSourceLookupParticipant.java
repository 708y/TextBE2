/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.debug;

public class BttSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof org.be.textbe.bttrace.resource.btt.debug.BttStackFrame) {
			org.be.textbe.bttrace.resource.btt.debug.BttStackFrame frame = (org.be.textbe.bttrace.resource.btt.debug.BttStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
