/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

public class BttWhiteSpace extends org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement {
	
	private final int amount;
	
	public BttWhiteSpace(int amount, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
