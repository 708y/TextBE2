/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

public class BttSequence extends org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement {
	
	public BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality, org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.be.textbe.bttrace.resource.btt.util.BttStringUtil.explode(getChildren(), " ");
	}
	
}
