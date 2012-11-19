/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * A basic implementation of the
 * org.be.textbe.bttrace.resource.btt.IBttReferenceResolveResult interface that
 * collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class BttReferenceResolveResult<ReferenceType> implements org.be.textbe.bttrace.resource.btt.IBttReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<org.be.textbe.bttrace.resource.btt.IBttQuickFix> quickFixes;
	
	public BttReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.be.textbe.bttrace.resource.btt.IBttQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.be.textbe.bttrace.resource.btt.IBttQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.be.textbe.bttrace.resource.btt.IBttQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.IBttReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.be.textbe.bttrace.resource.btt.mopp.BttElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.IBttReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.be.textbe.bttrace.resource.btt.mopp.BttURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
