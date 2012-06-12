/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * A basic implementation of the
 * org.be.textbe.bttrace.resource.btt.IBttElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class BttElementMapping<ReferenceType> implements org.be.textbe.bttrace.resource.btt.IBttElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public BttElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
