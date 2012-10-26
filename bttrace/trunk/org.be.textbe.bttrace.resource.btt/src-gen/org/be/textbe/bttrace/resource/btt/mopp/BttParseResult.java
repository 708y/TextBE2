/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttParseResult implements org.be.textbe.bttrace.resource.btt.IBttParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource>> commands = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource>>();
	
	public BttParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
