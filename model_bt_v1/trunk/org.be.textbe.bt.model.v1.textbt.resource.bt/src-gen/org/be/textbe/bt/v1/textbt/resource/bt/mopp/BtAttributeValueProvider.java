/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bt.v1.textbt.resource.bt.mopp;

/**
 * This class provides sets of values for attributes. It is used by the code
 * completion processor.
 */
public class BtAttributeValueProvider {
	
	public Object[] getDefaultValues(org.eclipse.emf.ecore.EAttribute attribute) {
		String typeName = attribute.getEType().getName();
		if ("EString".equals(typeName)) {
			return new Object[] {"some" + org.be.textbe.bt.v1.textbt.resource.bt.util.BtStringUtil.capitalize(attribute.getName())};
		}
		if ("EBoolean".equals(typeName)) {
			return new Object[] {Boolean.TRUE, Boolean.FALSE};
		}
		return new Object[] {attribute.getDefaultValue()};
	}
	
}
