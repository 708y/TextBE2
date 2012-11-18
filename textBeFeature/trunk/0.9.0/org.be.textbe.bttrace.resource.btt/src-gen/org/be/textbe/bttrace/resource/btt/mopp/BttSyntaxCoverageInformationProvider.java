/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTextBTTrace(),
			org.be.textbe.bttrace.BttracePackage.eINSTANCE.getBT(),
			org.be.textbe.bttrace.BttracePackage.eINSTANCE.getDelay(),
			org.be.textbe.bttrace.BttracePackage.eINSTANCE.getActivate(),
			org.be.textbe.bttrace.BttracePackage.eINSTANCE.getInterleave(),
			org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTrace(),
			org.be.textbe.bttrace.BttracePackage.eINSTANCE.getNodeGroup(),
			org.be.textbe.bttrace.BttracePackage.eINSTANCE.getNode(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTextBTTrace(),
		};
	}
	
}
