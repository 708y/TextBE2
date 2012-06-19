/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class BttRule extends org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public BttRule(org.eclipse.emf.ecore.EClass metaclass, org.be.textbe.bttrace.resource.btt.grammar.BttChoice choice, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality) {
		super(cardinality, new org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.be.textbe.bttrace.resource.btt.grammar.BttChoice getDefinition() {
		return (org.be.textbe.bttrace.resource.btt.grammar.BttChoice) getChildren()[0];
	}
	
}

