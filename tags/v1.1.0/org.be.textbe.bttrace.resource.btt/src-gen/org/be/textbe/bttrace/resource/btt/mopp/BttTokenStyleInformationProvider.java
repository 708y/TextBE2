/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttTokenStyleInformationProvider {
	
	public org.be.textbe.bttrace.resource.btt.IBttTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("COLORS".equals(tokenName)) {
			return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenStyle(new int[] {0x22, 0x3D, 0xD8}, null, false, false, false, false);
		}
		if ("INTEGER".equals(tokenName)) {
			return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenStyle(new int[] {0x61, 0xA5, 0x27}, null, false, false, false, false);
		}
		if ("BT".equals(tokenName)) {
			return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("DELAY".equals(tokenName)) {
			return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("ACTIVATE".equals(tokenName)) {
			return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("INTERLEAVE".equals(tokenName)) {
			return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("TRACE".equals(tokenName)) {
			return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("LOOP".equals(tokenName)) {
			return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		return null;
	}
	
}
