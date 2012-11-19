/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class BttAbstractExpectedElement implements org.be.textbe.bttrace.resource.btt.IBttExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	private java.util.Set<org.be.textbe.bttrace.resource.btt.util.BttPair<org.be.textbe.bttrace.resource.btt.IBttExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> followers = new java.util.LinkedHashSet<org.be.textbe.bttrace.resource.btt.util.BttPair<org.be.textbe.bttrace.resource.btt.IBttExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>>();
	
	public BttAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.be.textbe.bttrace.resource.btt.IBttExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path) {
		followers.add(new org.be.textbe.bttrace.resource.btt.util.BttPair<org.be.textbe.bttrace.resource.btt.IBttExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.be.textbe.bttrace.resource.btt.util.BttPair<org.be.textbe.bttrace.resource.btt.IBttExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers() {
		return followers;
	}
	
}
