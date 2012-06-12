/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class BttExpectedEnumerationTerminal extends org.be.textbe.bttrace.resource.btt.mopp.BttAbstractExpectedElement {
	
	private org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal enumerationTerminal;
	
	public BttExpectedEnumerationTerminal(org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
}
