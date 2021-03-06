/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bt.v1.textbt.resource.bt.analysis;

public class NodeBehaviorReferenceResolver implements org.be.textbe.bt.v1.textbt.resource.bt.IBtReferenceResolver<org.be.textbe.bt.v1.textbt.Node, org.be.textbe.bt.v1.textbt.Behavior> {
	
	private org.be.textbe.bt.v1.textbt.resource.bt.analysis.BtDefaultResolverDelegate<org.be.textbe.bt.v1.textbt.Node, org.be.textbe.bt.v1.textbt.Behavior> delegate = new org.be.textbe.bt.v1.textbt.resource.bt.analysis.BtDefaultResolverDelegate<org.be.textbe.bt.v1.textbt.Node, org.be.textbe.bt.v1.textbt.Behavior>();
	
	public void resolve(String identifier, org.be.textbe.bt.v1.textbt.Node container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.be.textbe.bt.v1.textbt.resource.bt.IBtReferenceResolveResult<org.be.textbe.bt.v1.textbt.Behavior> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.be.textbe.bt.v1.textbt.Behavior element, org.be.textbe.bt.v1.textbt.Node container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
