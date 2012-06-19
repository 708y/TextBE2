/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IBttResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public org.be.textbe.bttrace.resource.btt.IBttTextResource getResource();
	
}
