/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IBttCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
