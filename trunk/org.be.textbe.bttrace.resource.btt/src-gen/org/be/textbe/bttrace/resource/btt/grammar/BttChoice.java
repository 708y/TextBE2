/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

public class BttChoice extends org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement {
	
	public BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality, org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.be.textbe.bttrace.resource.btt.util.BttStringUtil.explode(getChildren(), "|");
	}
	
}
