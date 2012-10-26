/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class BttExpectedStructuralFeature extends org.be.textbe.bttrace.resource.btt.mopp.BttAbstractExpectedElement {
	
	private org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder placeholder;
	
	public BttExpectedStructuralFeature(org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof BttExpectedStructuralFeature) {
			return getFeature().equals(((BttExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
