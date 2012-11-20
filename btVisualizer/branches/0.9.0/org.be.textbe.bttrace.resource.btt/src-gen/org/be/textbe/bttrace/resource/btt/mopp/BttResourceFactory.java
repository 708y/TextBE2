/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public BttResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttResource(uri);
	}
	
}
