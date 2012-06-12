/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IBttResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.be.textbe.bttrace.resource.btt.IBttResourcePostProcessor getResourcePostProcessor();
	
}
