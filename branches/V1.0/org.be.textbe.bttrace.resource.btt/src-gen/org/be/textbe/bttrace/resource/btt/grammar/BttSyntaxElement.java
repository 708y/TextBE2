/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class BttSyntaxElement {
	
	private BttSyntaxElement[] children;
	private BttSyntaxElement parent;
	private org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality;
	
	public BttSyntaxElement(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality, BttSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (BttSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	public void setParent(BttSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public BttSyntaxElement[] getChildren() {
		if (children == null) {
			return new BttSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.be.textbe.bttrace.resource.btt.grammar.BttCardinality getCardinality() {
		return cardinality;
	}
	
}
