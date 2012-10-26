/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.grammar;

public class BttGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static BttGrammarInformationProvider INSTANCE = new BttGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_0_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTextBTTrace().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__BT), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_0_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTextBTTrace().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__DELAY), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.QUESTIONMARK, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_0_0_0_2 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTextBTTrace().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__ACTIVATE), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.QUESTIONMARK, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_0_0_0_3 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTextBTTrace().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__INTERLEAVE), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.QUESTIONMARK, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_0_0_0_4 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTextBTTrace().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__TRACE), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_0_0_0_0, BTT_0_0_0_1, BTT_0_0_0_2, BTT_0_0_0_3, BTT_0_0_0_4);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttRule BTT_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttRule(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTextBTTrace(), BTT_0_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_1_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("BT", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder BTT_1_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getBT().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.BT__VALUE), "FILE", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_1_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_1_0_0_0, BTT_1_0_0_1);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_1_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_1_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttRule BTT_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttRule(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getBT(), BTT_1_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_2_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("DELAY", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder BTT_2_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getDelay().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.DELAY__VALUE), "INTEGER", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_2_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_2_0_0_0, BTT_2_0_0_1);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_2_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_2_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttRule BTT_2 = new org.be.textbe.bttrace.resource.btt.grammar.BttRule(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getDelay(), BTT_2_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_3_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("ACTIVATE", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder BTT_3_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getActivate().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.ACTIVATE__COLOR), "COLORS", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_3_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_3_0_0_0, BTT_3_0_0_1);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_3_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_3_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttRule BTT_3 = new org.be.textbe.bttrace.resource.btt.grammar.BttRule(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getActivate(), BTT_3_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_4_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("INTERLEAVE", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder BTT_4_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getInterleave().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.INTERLEAVE__COLOR), "COLORS", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_4_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_4_0_0_0, BTT_4_0_0_1);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_4_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_4_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttRule BTT_4 = new org.be.textbe.bttrace.resource.btt.grammar.BttRule(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getInterleave(), BTT_4_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_5_0_0_0_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("TRACE", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_5_0_0_0_0_0_1_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTrace().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__NODE_GROUP), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_0_0_0_0_1_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_0_0_0_0_1_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_5_0_0_0_0_0_1_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_0_0_0_0_1_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttCompound BTT_5_0_0_0_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttCompound(BTT_5_0_0_0_0_0_1_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.PLUS);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_0_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_0_0_0_0_0, BTT_5_0_0_0_0_0_1);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_5_0_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_0_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttCompound BTT_5_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttCompound(BTT_5_0_0_0_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_5_0_1_0_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("LOOP", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_5_0_1_0_0_0_1_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTrace().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__LOOP_NODE_GROUP), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_1_0_0_0_1_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_1_0_0_0_1_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_5_0_1_0_0_0_1_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_1_0_0_0_1_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttCompound BTT_5_0_1_0_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttCompound(BTT_5_0_1_0_0_0_1_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.PLUS);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_1_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_1_0_0_0_0, BTT_5_0_1_0_0_0_1);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_5_0_1_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_1_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttCompound BTT_5_0_1_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttCompound(BTT_5_0_1_0_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_1_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_5_0_2_0_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("TRACE", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_5_0_2_0_0_0_1_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTrace().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__NODE_GROUP), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_2_0_0_0_1_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_2_0_0_0_1_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_5_0_2_0_0_0_1_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_2_0_0_0_1_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttCompound BTT_5_0_2_0_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttCompound(BTT_5_0_2_0_0_0_1_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.PLUS);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_5_0_2_0_0_0_2 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("LOOP", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_5_0_2_0_0_0_3_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTrace().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__LOOP_NODE_GROUP), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_2_0_0_0_3_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_2_0_0_0_3_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_5_0_2_0_0_0_3_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_2_0_0_0_3_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttCompound BTT_5_0_2_0_0_0_3 = new org.be.textbe.bttrace.resource.btt.grammar.BttCompound(BTT_5_0_2_0_0_0_3_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.PLUS);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_2_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_2_0_0_0_0, BTT_5_0_2_0_0_0_1, BTT_5_0_2_0_0_0_2, BTT_5_0_2_0_0_0_3);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_5_0_2_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_2_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttCompound BTT_5_0_2_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttCompound(BTT_5_0_2_0_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_5_0_2 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_2_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_5_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_5_0_0, BTT_5_0_1, BTT_5_0_2);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttRule BTT_5 = new org.be.textbe.bttrace.resource.btt.grammar.BttRule(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getTrace(), BTT_5_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_6_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("[", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_6_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getNodeGroup().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE_GROUP__ACTIVE_NODE), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_6_0_0_2_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword(",", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttContainment BTT_6_0_0_2_0_0_1 = new org.be.textbe.bttrace.resource.btt.grammar.BttContainment(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getNodeGroup().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE_GROUP__INTERLEAVE_NODE), org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_6_0_0_2_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_6_0_0_2_0_0_0, BTT_6_0_0_2_0_0_1);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_6_0_0_2_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_6_0_0_2_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttCompound BTT_6_0_0_2 = new org.be.textbe.bttrace.resource.btt.grammar.BttCompound(BTT_6_0_0_2_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.STAR);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttKeyword BTT_6_0_0_3 = new org.be.textbe.bttrace.resource.btt.grammar.BttKeyword("]", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_6_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_6_0_0_0, BTT_6_0_0_1, BTT_6_0_0_2, BTT_6_0_0_3);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_6_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_6_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttRule BTT_6 = new org.be.textbe.bttrace.resource.btt.grammar.BttRule(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getNodeGroup(), BTT_6_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder BTT_7_0_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getNode().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE__VALUE), "INTEGER", org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, 0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttSequence BTT_7_0_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttSequence(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_7_0_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttChoice BTT_7_0 = new org.be.textbe.bttrace.resource.btt.grammar.BttChoice(org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE, BTT_7_0_0);
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttRule BTT_7 = new org.be.textbe.bttrace.resource.btt.grammar.BttRule(org.be.textbe.bttrace.BttracePackage.eINSTANCE.getNode(), BTT_7_0, org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE);
	
	public final static org.be.textbe.bttrace.resource.btt.grammar.BttRule[] RULES = new org.be.textbe.bttrace.resource.btt.grammar.BttRule[] {
		BTT_0,
		BTT_1,
		BTT_2,
		BTT_3,
		BTT_4,
		BTT_5,
		BTT_6,
		BTT_7,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.be.textbe.bttrace.resource.btt.grammar.BttRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.be.textbe.bttrace.resource.btt.grammar.BttKeyword) {
			keywords.add(((org.be.textbe.bttrace.resource.btt.grammar.BttKeyword) element).getValue());
		} else if (element instanceof org.be.textbe.bttrace.resource.btt.grammar.BttBooleanTerminal) {
			keywords.add(((org.be.textbe.bttrace.resource.btt.grammar.BttBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.be.textbe.bttrace.resource.btt.grammar.BttBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal) {
			org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal terminal = (org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
