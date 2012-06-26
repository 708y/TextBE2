/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class BttContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.be.textbe.bttrace.resource.btt.IBttContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.be.textbe.bttrace.resource.btt.IBttReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public BttContextDependentURIFragmentFactory(org.be.textbe.bttrace.resource.btt.IBttReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.be.textbe.bttrace.resource.btt.mopp.BttContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.be.textbe.bttrace.resource.btt.IBttReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
