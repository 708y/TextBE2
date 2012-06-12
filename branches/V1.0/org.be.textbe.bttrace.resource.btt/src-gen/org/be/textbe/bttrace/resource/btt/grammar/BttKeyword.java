/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class BttKeyword extends org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement {
	
	private final String value;
	
	public BttKeyword(String value, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
