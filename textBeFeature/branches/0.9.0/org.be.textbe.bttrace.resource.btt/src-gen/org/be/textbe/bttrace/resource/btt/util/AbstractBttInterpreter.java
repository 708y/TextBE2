/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractBttInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.be.textbe.bttrace.resource.btt.IBttInterpreterListener> listeners = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.IBttInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.be.textbe.bttrace.Node) {
			result = interprete_org_be_textbe_bttrace_Node((org.be.textbe.bttrace.Node) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.be.textbe.bttrace.NodeGroup) {
			result = interprete_org_be_textbe_bttrace_NodeGroup((org.be.textbe.bttrace.NodeGroup) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.be.textbe.bttrace.Trace) {
			result = interprete_org_be_textbe_bttrace_Trace((org.be.textbe.bttrace.Trace) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.be.textbe.bttrace.Interleave) {
			result = interprete_org_be_textbe_bttrace_Interleave((org.be.textbe.bttrace.Interleave) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.be.textbe.bttrace.Activate) {
			result = interprete_org_be_textbe_bttrace_Activate((org.be.textbe.bttrace.Activate) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.be.textbe.bttrace.Delay) {
			result = interprete_org_be_textbe_bttrace_Delay((org.be.textbe.bttrace.Delay) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.be.textbe.bttrace.BT) {
			result = interprete_org_be_textbe_bttrace_BT((org.be.textbe.bttrace.BT) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.be.textbe.bttrace.TextBTTrace) {
			result = interprete_org_be_textbe_bttrace_TextBTTrace((org.be.textbe.bttrace.TextBTTrace) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_be_textbe_bttrace_TextBTTrace(org.be.textbe.bttrace.TextBTTrace object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_be_textbe_bttrace_BT(org.be.textbe.bttrace.BT object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_be_textbe_bttrace_Delay(org.be.textbe.bttrace.Delay object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_be_textbe_bttrace_Activate(org.be.textbe.bttrace.Activate object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_be_textbe_bttrace_Interleave(org.be.textbe.bttrace.Interleave object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_be_textbe_bttrace_Trace(org.be.textbe.bttrace.Trace object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_be_textbe_bttrace_NodeGroup(org.be.textbe.bttrace.NodeGroup object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_be_textbe_bttrace_Node(org.be.textbe.bttrace.Node object, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.be.textbe.bttrace.resource.btt.IBttInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.be.textbe.bttrace.resource.btt.IBttInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.be.textbe.bttrace.resource.btt.IBttInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
