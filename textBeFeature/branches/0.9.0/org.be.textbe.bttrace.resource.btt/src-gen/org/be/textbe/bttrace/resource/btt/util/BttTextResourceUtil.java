/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.util;

/**
 * Class BttTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.be.textbe.bttrace.resource.btt.util.BttResourceUtil.
 */
public class BttTextResourceUtil {
	
	@Deprecated	
	public static org.be.textbe.bttrace.resource.btt.mopp.BttResource getResource(org.eclipse.core.resources.IFile file) {
		return org.be.textbe.bttrace.resource.btt.util.BttResourceUtil.getResource(file);
	}
	
	@Deprecated	
	public static org.be.textbe.bttrace.resource.btt.mopp.BttResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.be.textbe.bttrace.resource.btt.util.BttResourceUtil.getResource(file, options);
	}
	
	@Deprecated	
	public static org.be.textbe.bttrace.resource.btt.mopp.BttResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.be.textbe.bttrace.resource.btt.util.BttResourceUtil.getResource(uri);
	}
	
	@Deprecated	
	public static org.be.textbe.bttrace.resource.btt.mopp.BttResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.be.textbe.bttrace.resource.btt.util.BttResourceUtil.getResource(uri, options);
	}
	
}
