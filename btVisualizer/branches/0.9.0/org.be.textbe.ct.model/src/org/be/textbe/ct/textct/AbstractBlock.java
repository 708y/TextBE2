/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.ct.textct;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.ct.textct.AbstractBlock#getChildNode <em>Child Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.ct.textct.TextctPackage#getAbstractBlock()
 * @model abstract="true"
 * @generated
 */
public interface AbstractBlock extends AbstractBlockOrNode {
	/**
   * Returns the value of the '<em><b>Child Node</b></em>' containment reference list.
   * The list contents are of type {@link org.be.textbe.ct.textct.AbstractBlockOrNode}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Child Node</em>' containment reference list.
   * @see org.be.textbe.ct.textct.TextctPackage#getAbstractBlock_ChildNode()
   * @model containment="true" lower="2"
   * @generated
   */
	EList<AbstractBlockOrNode> getChildNode();

} // AbstractBlock
