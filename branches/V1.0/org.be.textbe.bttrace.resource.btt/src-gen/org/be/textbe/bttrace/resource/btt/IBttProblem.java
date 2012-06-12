/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt;

public interface IBttProblem {
	public String getMessage();
	public org.be.textbe.bttrace.resource.btt.BttEProblemSeverity getSeverity();
	public org.be.textbe.bttrace.resource.btt.BttEProblemType getType();
	public java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttQuickFix> getQuickFixes();
}
