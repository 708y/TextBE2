/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class BttPlaceholder extends org.be.textbe.bttrace.resource.btt.grammar.BttTerminal {
	
	private final String tokenName;
	
	public BttPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
