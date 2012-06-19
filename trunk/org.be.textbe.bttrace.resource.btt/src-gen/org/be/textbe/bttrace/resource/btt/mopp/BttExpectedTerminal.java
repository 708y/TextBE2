/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * A representation for a range in a document where a terminal (i.e., a
 * placeholder or a keyword) is expected. The range is expressed using two
 * integers denoting the start of the range including hidden tokens (e.g.,
 * whitespace) and excluding those token (i.e., the part of the document
 * containing the relevant characters).
 */
public class BttExpectedTerminal {
	
	private int followSetID;
	private org.be.textbe.bttrace.resource.btt.IBttExpectedElement terminal;
	private int startIncludingHiddenTokens;
	private int startExcludingHiddenTokens;
	private String prefix;
	private org.eclipse.emf.ecore.EStructuralFeature[] containmentTrace;
	
	public BttExpectedTerminal(org.be.textbe.bttrace.resource.btt.IBttExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
		super();
		this.terminal = terminal;
		this.followSetID = followSetID;
		this.containmentTrace = containmentTrace;
	}
	
	public int getFollowSetID() {
		return followSetID;
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttExpectedElement getTerminal() {
		return terminal;
	}
	
	public String toString() {
		return terminal == null ? "null" : terminal.toString();
	}
	
	public boolean equals(Object o) {
		return this.terminal.equals(((BttExpectedTerminal) o).terminal);
	}
	
	public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens) {
		assert startExcludingHiddenTokens <= startExcludingHiddenTokens;
		assert startIncludingHiddenTokens <= startExcludingHiddenTokens;
		this.startIncludingHiddenTokens = startIncludingHiddenTokens;
		this.startExcludingHiddenTokens = startExcludingHiddenTokens;
	}
	
	public int getStartIncludingHiddenTokens() {
		return startIncludingHiddenTokens;
	}
	
	public int getStartExcludingHiddenTokens() {
		return startExcludingHiddenTokens;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature[] getContainmentTrace() {
		return containmentTrace;
	}
	
}
