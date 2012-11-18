/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

public class BttLineBreak extends org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement {
	
	private final int tabs;
	
	public BttLineBreak(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
