/*
* generated by Xtext
*/
package org.be.textbe.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.be.textbe.services.ExpressionsGrammarAccess;

public class ExpressionsParser extends AbstractContentAssistParser {
	
	@Inject
	private ExpressionsGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.be.textbe.ui.contentassist.antlr.internal.InternalExpressionsParser createParser() {
		org.be.textbe.ui.contentassist.antlr.internal.InternalExpressionsParser result = new org.be.textbe.ui.contentassist.antlr.internal.InternalExpressionsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getNodeAccess().getAlternatives(), "rule__Node__Alternatives");
					put(grammarAccess.getBehaviorAccess().getAlternatives(), "rule__Behavior__Alternatives");
					put(grammarAccess.getComponentInstantiationNodeAccess().getAlternatives(), "rule__ComponentInstantiationNode__Alternatives");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getBinarySymbolAccess().getAlternatives(), "rule__BinarySymbol__Alternatives");
					put(grammarAccess.getBinaryOperatorAccess().getAlternatives(), "rule__BinaryOperator__Alternatives");
					put(grammarAccess.getBehaviorNodeAccess().getGroup(), "rule__BehaviorNode__Group__0");
					put(grammarAccess.getStateRealisationAccess().getGroup(), "rule__StateRealisation__Group__0");
					put(grammarAccess.getAttributeRealisationAccess().getGroup(), "rule__AttributeRealisation__Group__0");
					put(grammarAccess.getSelectionAccess().getGroup(), "rule__Selection__Group__0");
					put(grammarAccess.getEventAccess().getGroup(), "rule__Event__Group__0");
					put(grammarAccess.getGuardAccess().getGroup(), "rule__Guard__Group__0");
					put(grammarAccess.getInternalOutputEventAccess().getGroup(), "rule__InternalOutputEvent__Group__0");
					put(grammarAccess.getInternalInputEventAccess().getGroup(), "rule__InternalInputEvent__Group__0");
					put(grammarAccess.getExternalOutputEventAccess().getGroup(), "rule__ExternalOutputEvent__Group__0");
					put(grammarAccess.getExternalInputEventAccess().getGroup(), "rule__ExternalInputEvent__Group__0");
					put(grammarAccess.getForAllAccess().getGroup(), "rule__ForAll__Group__0");
					put(grammarAccess.getForSomeAccess().getGroup(), "rule__ForSome__Group__0");
					put(grammarAccess.getAtLeastOneAccess().getGroup(), "rule__AtLeastOne__Group__0");
					put(grammarAccess.getForOneArbitraryAccess().getGroup(), "rule__ForOneArbitrary__Group__0");
					put(grammarAccess.getComponentInstantiationAccess().getGroup(), "rule__ComponentInstantiation__Group__0");
					put(grammarAccess.getBinaryRelationAccess().getGroup(), "rule__BinaryRelation__Group__0");
					put(grammarAccess.getBinaryRelationAccess().getGroup_2(), "rule__BinaryRelation__Group_2__0");
					put(grammarAccess.getBinaryExpressionAccess().getGroup(), "rule__BinaryExpression__Group__0");
					put(grammarAccess.getBinaryExpressionAccess().getGroup_1(), "rule__BinaryExpression__Group_1__0");
					put(grammarAccess.getIdentifierAccess().getGroup(), "rule__Identifier__Group__0");
					put(grammarAccess.getIdentifierAccess().getGroup_1(), "rule__Identifier__Group_1__0");
					put(grammarAccess.getFunctionApplicationAccess().getGroup(), "rule__FunctionApplication__Group__0");
					put(grammarAccess.getBracketedExpressionAccess().getGroup(), "rule__BracketedExpression__Group__0");
					put(grammarAccess.getCardinalityAccess().getGroup(), "rule__Cardinality__Group__0");
					put(grammarAccess.getEnumeratedSetAccess().getGroup(), "rule__EnumeratedSet__Group__0");
					put(grammarAccess.getFuzzyExpAccess().getGroup(), "rule__FuzzyExp__Group__0");
					put(grammarAccess.getBehaviorNodeAccess().getComponentAssignment_0(), "rule__BehaviorNode__ComponentAssignment_0");
					put(grammarAccess.getBehaviorNodeAccess().getBehaviorAssignment_1(), "rule__BehaviorNode__BehaviorAssignment_1");
					put(grammarAccess.getStateRealisationAccess().getStateAssignment_1(), "rule__StateRealisation__StateAssignment_1");
					put(grammarAccess.getAttributeRealisationAccess().getAttributeAssignment_1(), "rule__AttributeRealisation__AttributeAssignment_1");
					put(grammarAccess.getAttributeRealisationAccess().getValueAssignment_3(), "rule__AttributeRealisation__ValueAssignment_3");
					put(grammarAccess.getGuardAccess().getStateAssignment_1(), "rule__Guard__StateAssignment_1");
					put(grammarAccess.getComponentInstantiationAccess().getComponentAssignment_0(), "rule__ComponentInstantiation__ComponentAssignment_0");
					put(grammarAccess.getComponentInstantiationAccess().getComponentSetAssignment_3(), "rule__ComponentInstantiation__ComponentSetAssignment_3");
					put(grammarAccess.getBinaryRelationAccess().getLeftAssignment_1(), "rule__BinaryRelation__LeftAssignment_1");
					put(grammarAccess.getBinaryRelationAccess().getOperatorAssignment_2_0(), "rule__BinaryRelation__OperatorAssignment_2_0");
					put(grammarAccess.getBinaryRelationAccess().getRightAssignment_2_1(), "rule__BinaryRelation__RightAssignment_2_1");
					put(grammarAccess.getBinaryExpressionAccess().getLeftExpressionAssignment_0(), "rule__BinaryExpression__LeftExpressionAssignment_0");
					put(grammarAccess.getBinaryExpressionAccess().getOperatorAssignment_1_0(), "rule__BinaryExpression__OperatorAssignment_1_0");
					put(grammarAccess.getBinaryExpressionAccess().getRightExpressionAssignment_1_1(), "rule__BinaryExpression__RightExpressionAssignment_1_1");
					put(grammarAccess.getReferenceAccess().getObjectAssignment(), "rule__Reference__ObjectAssignment");
					put(grammarAccess.getNumberAccess().getValueAssignment(), "rule__Number__ValueAssignment");
					put(grammarAccess.getFunctionApplicationAccess().getFunctionNameAssignment_0(), "rule__FunctionApplication__FunctionNameAssignment_0");
					put(grammarAccess.getFunctionApplicationAccess().getParameterAssignment_2(), "rule__FunctionApplication__ParameterAssignment_2");
					put(grammarAccess.getBracketedExpressionAccess().getExpressionAssignment_1(), "rule__BracketedExpression__ExpressionAssignment_1");
					put(grammarAccess.getCardinalityAccess().getExpressionAssignment_1(), "rule__Cardinality__ExpressionAssignment_1");
					put(grammarAccess.getEnumeratedSetAccess().getExpressionsAssignment_1(), "rule__EnumeratedSet__ExpressionsAssignment_1");
					put(grammarAccess.getFuzzyExpAccess().getExpressionAssignment_1(), "rule__FuzzyExp__ExpressionAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.be.textbe.ui.contentassist.antlr.internal.InternalExpressionsParser typedParser = (org.be.textbe.ui.contentassist.antlr.internal.InternalExpressionsParser) parser;
			typedParser.entryRuleNode();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ExpressionsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ExpressionsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}