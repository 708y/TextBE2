/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package textst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link textst.ComponentList#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see textst.TextstPackage#getComponentList()
 * @model
 * @generated
 */
public interface ComponentList extends EObject
{
  /**
   * Returns the value of the '<em><b>Components</b></em>' containment reference list.
   * The list contents are of type {@link textst.Component}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Components</em>' containment reference list.
   * @see textst.TextstPackage#getComponentList_Components()
   * @model type="textst.Component" containment="true"
   * @generated
   */
  EList getComponents();

} // ComponentList
