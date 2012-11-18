/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt;

public interface IBttBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(org.be.textbe.bttrace.resource.btt.mopp.BttResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
