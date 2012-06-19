/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.analysis;

public class BttCOLORSTokenResolver implements org.be.textbe.bttrace.resource.btt.IBttTokenResolver {
	
	private org.be.textbe.bttrace.resource.btt.analysis.BttDefaultTokenResolver defaultTokenResolver = new org.be.textbe.bttrace.resource.btt.analysis.BttDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.be.textbe.bttrace.resource.btt.IBttTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
