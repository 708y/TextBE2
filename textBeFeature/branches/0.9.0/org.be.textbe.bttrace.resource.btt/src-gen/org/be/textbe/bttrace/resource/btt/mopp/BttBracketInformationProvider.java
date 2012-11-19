/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttBracketInformationProvider {
	
	public class BracketPair implements org.be.textbe.bttrace.resource.btt.IBttBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttBracketPair> getBracketPairs() {
		java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttBracketPair> result = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.IBttBracketPair>();
		result.add(new BracketPair("[", "]", true));
		return result;
	}
	
}
