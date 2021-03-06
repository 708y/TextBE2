/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.be.textbe.ct.textct;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.be.textbe.ct.textct.OptionList#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.be.textbe.ct.textct.TextctPackage#getOptionList()
 * @model
 * @generated
 */
public interface OptionList extends EObject {
	/**
   * Returns the value of the '<em><b>Options</b></em>' containment reference list.
   * The list contents are of type {@link org.be.textbe.ct.textct.Option}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Options</em>' containment reference list.
   * @see org.be.textbe.ct.textct.TextctPackage#getOptionList_Options()
   * @model containment="true"
   * @generated
   */
	EList<Option> getOptions();

} // OptionList
