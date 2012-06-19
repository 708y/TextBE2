/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttProblem implements org.be.textbe.bttrace.resource.btt.IBttProblem {
	
	private String message;
	private org.be.textbe.bttrace.resource.btt.BttEProblemType type;
	private org.be.textbe.bttrace.resource.btt.BttEProblemSeverity severity;
	private java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttQuickFix> quickFixes;
	
	public BttProblem(String message, org.be.textbe.bttrace.resource.btt.BttEProblemType type, org.be.textbe.bttrace.resource.btt.BttEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.be.textbe.bttrace.resource.btt.IBttQuickFix>emptySet());
	}
	
	public BttProblem(String message, org.be.textbe.bttrace.resource.btt.BttEProblemType type, org.be.textbe.bttrace.resource.btt.BttEProblemSeverity severity, org.be.textbe.bttrace.resource.btt.IBttQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public BttProblem(String message, org.be.textbe.bttrace.resource.btt.BttEProblemType type, org.be.textbe.bttrace.resource.btt.BttEProblemSeverity severity, java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.be.textbe.bttrace.resource.btt.IBttQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.be.textbe.bttrace.resource.btt.BttEProblemType getType() {
		return type;
	}
	
	public org.be.textbe.bttrace.resource.btt.BttEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
