/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.st.textst.resource.st.mopp;

public class StBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder {
	
	/**
	 * the ID of the default, generated builder
	 */
	public final static String BUILDER_ID = "org.be.textbe.st.textst.resource.st.builder";
	
	private org.be.textbe.st.textst.resource.st.IStBuilder builder = new org.be.textbe.st.textst.resource.st.mopp.StBuilder();
	
	public org.eclipse.core.resources.IProject[] build(int kind, @SuppressWarnings("rawtypes") java.util.Map args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		return build(kind, args, monitor, builder, getProject());
	}
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map<?,?> args, final org.eclipse.core.runtime.IProgressMonitor monitor, final org.be.textbe.st.textst.resource.st.IStBuilder builder, org.eclipse.core.resources.IProject project) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResourceDelta delta = getDelta(project);
		if (delta == null) {
			return null;
		}
		delta.accept(new org.eclipse.core.resources.IResourceDeltaVisitor() {
			public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
				if (delta.getKind() == org.eclipse.core.resources.IResourceDelta.REMOVED) {
					return false;
				}
				org.eclipse.core.resources.IResource resource = delta.getResource();
				if (resource instanceof org.eclipse.core.resources.IFile && resource.getName().endsWith("." + "st")) {
					org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					if (builder.isBuildingNeeded(uri)) {
						org.be.textbe.st.textst.resource.st.mopp.StResource customResource = (org.be.textbe.st.textst.resource.st.mopp.StResource) new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl().getResource(uri, true);
						org.be.textbe.st.textst.resource.st.mopp.StMarkerHelper.unmark(customResource, org.be.textbe.st.textst.resource.st.StEProblemType.BUILDER_ERROR);
						builder.build(customResource, monitor);
					}
					return false;
				}
				return true;
			}
		});
		return null;
	}
	
}
