/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.bt.textbt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.bt.textbt.Node#getChildNode <em>Child Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.bt.textbt.TextbtPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends AbstractNode
{
  /**
   * Returns the value of the '<em><b>Child Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child Node</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child Node</em>' containment reference.
   * @see #setChildNode(AbstractBlockOrNode)
   * @see org.be.textbe.bt.textbt.TextbtPackage#getNode_ChildNode()
   * @model containment="true"
   * @generated
   */
  AbstractBlockOrNode getChildNode();

  /**
   * Sets the value of the '{@link org.be.textbe.bt.textbt.Node#getChildNode <em>Child Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child Node</em>' containment reference.
   * @see #getChildNode()
   * @generated
   */
  void setChildNode(AbstractBlockOrNode value);

} // Node
