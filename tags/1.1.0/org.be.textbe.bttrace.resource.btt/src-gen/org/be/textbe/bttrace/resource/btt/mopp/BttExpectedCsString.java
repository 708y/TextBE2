/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class BttExpectedCsString extends org.be.textbe.bttrace.resource.btt.mopp.BttAbstractExpectedElement {
	
	private org.be.textbe.bttrace.resource.btt.grammar.BttKeyword keyword;
	
	public BttExpectedCsString(org.be.textbe.bttrace.resource.btt.grammar.BttKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof BttExpectedCsString) {
			return getValue().equals(((BttExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
