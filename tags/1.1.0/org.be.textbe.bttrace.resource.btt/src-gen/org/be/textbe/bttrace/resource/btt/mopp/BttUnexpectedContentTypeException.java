/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see org.be.textbe.bttrace.resource.btt.IBttOptions.RESOURCE_CONTENT_TYPE
 */
public class BttUnexpectedContentTypeException extends org.antlr.runtime3_3_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  BttUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
