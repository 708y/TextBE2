/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

public class BttContainment extends org.be.textbe.bttrace.resource.btt.grammar.BttTerminal {
	
	public BttContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
	}
	
	public String toString() {
		return getFeature().getName();
	}
	
}
