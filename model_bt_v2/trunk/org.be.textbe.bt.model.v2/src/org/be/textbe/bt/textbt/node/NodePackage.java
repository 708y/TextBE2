/**
 */
package org.be.textbe.bt.textbt.node;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.be.textbe.bt.textbt.node.NodeFactory
 * @model kind="package"
 * @generated
 */
public interface NodePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "node";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.be.textbe/textbt/node";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "node";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NodePackage eINSTANCE = org.be.textbe.bt.textbt.node.impl.NodePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.be.textbe.bt.textbt.node.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.be.textbe.bt.textbt.node.impl.NodeImpl
	 * @see org.be.textbe.bt.textbt.node.impl.NodePackageImpl#getNode()
	 * @generated
	 */
	int NODE = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PARENT = 1;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PARENTS = 2;

	/**
	 * The feature id for the '<em><b>Siblings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SIBLINGS = 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CHILDREN = 4;

	/**
	 * The feature id for the '<em><b>Descendants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DESCENDANTS = 5;

	/**
	 * The feature id for the '<em><b>Sibling Branches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SIBLING_BRANCHES = 6;

	/**
	 * The feature id for the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ROOT = 7;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LEAF = 8;

	/**
	 * The feature id for the '<em><b>Traceability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TRACEABILITY = 9;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.be.textbe.bt.textbt.node.impl.OperationNodeImpl <em>Operation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.be.textbe.bt.textbt.node.impl.OperationNodeImpl
	 * @see org.be.textbe.bt.textbt.node.impl.NodePackageImpl#getOperationNode()
	 * @generated
	 */
	int OPERATION_NODE = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__LABEL = NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__PARENT = NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__PARENTS = NODE__PARENTS;

	/**
	 * The feature id for the '<em><b>Siblings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__SIBLINGS = NODE__SIBLINGS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__CHILDREN = NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Descendants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__DESCENDANTS = NODE__DESCENDANTS;

	/**
	 * The feature id for the '<em><b>Sibling Branches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__SIBLING_BRANCHES = NODE__SIBLING_BRANCHES;

	/**
	 * The feature id for the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__ROOT = NODE__ROOT;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__LEAF = NODE__LEAF;

	/**
	 * The feature id for the '<em><b>Traceability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__TRACEABILITY = NODE__TRACEABILITY;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OPERATION = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.be.textbe.bt.textbt.node.impl.BehaviorNodeImpl <em>Behavior Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.be.textbe.bt.textbt.node.impl.BehaviorNodeImpl
	 * @see org.be.textbe.bt.textbt.node.impl.NodePackageImpl#getBehaviorNode()
	 * @generated
	 */
	int BEHAVIOR_NODE = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__LABEL = OPERATION_NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__PARENT = OPERATION_NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__PARENTS = OPERATION_NODE__PARENTS;

	/**
	 * The feature id for the '<em><b>Siblings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__SIBLINGS = OPERATION_NODE__SIBLINGS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__CHILDREN = OPERATION_NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Descendants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__DESCENDANTS = OPERATION_NODE__DESCENDANTS;

	/**
	 * The feature id for the '<em><b>Sibling Branches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__SIBLING_BRANCHES = OPERATION_NODE__SIBLING_BRANCHES;

	/**
	 * The feature id for the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__ROOT = OPERATION_NODE__ROOT;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__LEAF = OPERATION_NODE__LEAF;

	/**
	 * The feature id for the '<em><b>Traceability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__TRACEABILITY = OPERATION_NODE__TRACEABILITY;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__OPERATION = OPERATION_NODE__OPERATION;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__BEHAVIOR = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE__ACTOR = OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Behavior Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.be.textbe.bt.textbt.node.impl.LabelOnlyNodeImpl <em>Label Only Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.be.textbe.bt.textbt.node.impl.LabelOnlyNodeImpl
	 * @see org.be.textbe.bt.textbt.node.impl.NodePackageImpl#getLabelOnlyNode()
	 * @generated
	 */
	int LABEL_ONLY_NODE = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__LABEL = OPERATION_NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__PARENT = OPERATION_NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__PARENTS = OPERATION_NODE__PARENTS;

	/**
	 * The feature id for the '<em><b>Siblings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__SIBLINGS = OPERATION_NODE__SIBLINGS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__CHILDREN = OPERATION_NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Descendants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__DESCENDANTS = OPERATION_NODE__DESCENDANTS;

	/**
	 * The feature id for the '<em><b>Sibling Branches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__SIBLING_BRANCHES = OPERATION_NODE__SIBLING_BRANCHES;

	/**
	 * The feature id for the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__ROOT = OPERATION_NODE__ROOT;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__LEAF = OPERATION_NODE__LEAF;

	/**
	 * The feature id for the '<em><b>Traceability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__TRACEABILITY = OPERATION_NODE__TRACEABILITY;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE__OPERATION = OPERATION_NODE__OPERATION;

	/**
	 * The number of structural features of the '<em>Label Only Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ONLY_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.be.textbe.bt.textbt.node.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.node.Node#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#getLabel()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Label();

	/**
	 * Returns the meta object for the reference '{@link org.be.textbe.bt.textbt.node.Node#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#getParent()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.be.textbe.bt.textbt.node.Node#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parents</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#getParents()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Parents();

	/**
	 * Returns the meta object for the reference list '{@link org.be.textbe.bt.textbt.node.Node#getSiblings <em>Siblings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Siblings</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#getSiblings()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Siblings();

	/**
	 * Returns the meta object for the reference list '{@link org.be.textbe.bt.textbt.node.Node#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#getChildren()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Children();

	/**
	 * Returns the meta object for the reference '{@link org.be.textbe.bt.textbt.node.Node#getDescendants <em>Descendants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Descendants</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#getDescendants()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Descendants();

	/**
	 * Returns the meta object for the reference list '{@link org.be.textbe.bt.textbt.node.Node#getSiblingBranches <em>Sibling Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sibling Branches</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#getSiblingBranches()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_SiblingBranches();

	/**
	 * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.node.Node#isRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#isRoot()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Root();

	/**
	 * Returns the meta object for the attribute '{@link org.be.textbe.bt.textbt.node.Node#isLeaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leaf</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#isLeaf()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Leaf();

	/**
	 * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.node.Node#getTraceability <em>Traceability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Traceability</em>'.
	 * @see org.be.textbe.bt.textbt.node.Node#getTraceability()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Traceability();

	/**
	 * Returns the meta object for class '{@link org.be.textbe.bt.textbt.node.BehaviorNode <em>Behavior Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Node</em>'.
	 * @see org.be.textbe.bt.textbt.node.BehaviorNode
	 * @generated
	 */
	EClass getBehaviorNode();

	/**
	 * Returns the meta object for the reference '{@link org.be.textbe.bt.textbt.node.BehaviorNode#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavior</em>'.
	 * @see org.be.textbe.bt.textbt.node.BehaviorNode#getBehavior()
	 * @see #getBehaviorNode()
	 * @generated
	 */
	EReference getBehaviorNode_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.be.textbe.bt.textbt.node.BehaviorNode#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see org.be.textbe.bt.textbt.node.BehaviorNode#getActor()
	 * @see #getBehaviorNode()
	 * @generated
	 */
	EReference getBehaviorNode_Actor();

	/**
	 * Returns the meta object for class '{@link org.be.textbe.bt.textbt.node.LabelOnlyNode <em>Label Only Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label Only Node</em>'.
	 * @see org.be.textbe.bt.textbt.node.LabelOnlyNode
	 * @generated
	 */
	EClass getLabelOnlyNode();

	/**
	 * Returns the meta object for class '{@link org.be.textbe.bt.textbt.node.OperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Node</em>'.
	 * @see org.be.textbe.bt.textbt.node.OperationNode
	 * @generated
	 */
	EClass getOperationNode();

	/**
	 * Returns the meta object for the containment reference '{@link org.be.textbe.bt.textbt.node.OperationNode#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation</em>'.
	 * @see org.be.textbe.bt.textbt.node.OperationNode#getOperation()
	 * @see #getOperationNode()
	 * @generated
	 */
	EReference getOperationNode_Operation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NodeFactory getNodeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.be.textbe.bt.textbt.node.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.be.textbe.bt.textbt.node.impl.NodeImpl
		 * @see org.be.textbe.bt.textbt.node.impl.NodePackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__LABEL = eINSTANCE.getNode_Label();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PARENT = eINSTANCE.getNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PARENTS = eINSTANCE.getNode_Parents();

		/**
		 * The meta object literal for the '<em><b>Siblings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SIBLINGS = eINSTANCE.getNode_Siblings();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CHILDREN = eINSTANCE.getNode_Children();

		/**
		 * The meta object literal for the '<em><b>Descendants</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__DESCENDANTS = eINSTANCE.getNode_Descendants();

		/**
		 * The meta object literal for the '<em><b>Sibling Branches</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SIBLING_BRANCHES = eINSTANCE.getNode_SiblingBranches();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ROOT = eINSTANCE.getNode_Root();

		/**
		 * The meta object literal for the '<em><b>Leaf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__LEAF = eINSTANCE.getNode_Leaf();

		/**
		 * The meta object literal for the '<em><b>Traceability</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__TRACEABILITY = eINSTANCE.getNode_Traceability();

		/**
		 * The meta object literal for the '{@link org.be.textbe.bt.textbt.node.impl.BehaviorNodeImpl <em>Behavior Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.be.textbe.bt.textbt.node.impl.BehaviorNodeImpl
		 * @see org.be.textbe.bt.textbt.node.impl.NodePackageImpl#getBehaviorNode()
		 * @generated
		 */
		EClass BEHAVIOR_NODE = eINSTANCE.getBehaviorNode();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_NODE__BEHAVIOR = eINSTANCE.getBehaviorNode_Behavior();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_NODE__ACTOR = eINSTANCE.getBehaviorNode_Actor();

		/**
		 * The meta object literal for the '{@link org.be.textbe.bt.textbt.node.impl.LabelOnlyNodeImpl <em>Label Only Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.be.textbe.bt.textbt.node.impl.LabelOnlyNodeImpl
		 * @see org.be.textbe.bt.textbt.node.impl.NodePackageImpl#getLabelOnlyNode()
		 * @generated
		 */
		EClass LABEL_ONLY_NODE = eINSTANCE.getLabelOnlyNode();

		/**
		 * The meta object literal for the '{@link org.be.textbe.bt.textbt.node.impl.OperationNodeImpl <em>Operation Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.be.textbe.bt.textbt.node.impl.OperationNodeImpl
		 * @see org.be.textbe.bt.textbt.node.impl.NodePackageImpl#getOperationNode()
		 * @generated
		 */
		EClass OPERATION_NODE = eINSTANCE.getOperationNode();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_NODE__OPERATION = eINSTANCE.getOperationNode_Operation();

	}

} //NodePackage
