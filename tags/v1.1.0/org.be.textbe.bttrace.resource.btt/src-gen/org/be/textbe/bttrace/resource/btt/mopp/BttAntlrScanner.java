/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttAntlrScanner implements org.be.textbe.bttrace.resource.btt.IBttTextScanner {
	
	private org.antlr.runtime3_3_0.Lexer antlrLexer;
	
	public BttAntlrScanner(org.antlr.runtime3_3_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_3_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.be.textbe.bttrace.resource.btt.IBttTextToken result = new org.be.textbe.bttrace.resource.btt.mopp.BttTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_3_0.ANTLRStringStream(text));
	}
	
}
