/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

public class BttCompound extends org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement {
	
	public BttCompound(org.be.textbe.bttrace.resource.btt.grammar.BttChoice choice, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality) {
		super(cardinality, new org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
