/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private BttSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public BttSyntaxElementDecorator(org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement decoratedElement, BttSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public BttSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
