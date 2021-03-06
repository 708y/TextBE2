package org.be.textbe.bt2sal2.xtext.sal.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.be.textbe.bt2sal2.xtext.sal.services.SalGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SalSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SalGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Assignments_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_Definitions_SemicolonKeyword_1_q;
	protected AbstractElementAlias match_InitDecl_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_Lhs_ApostropheKeyword_1_q;
	protected AbstractElementAlias match_ScalarType_CommaKeyword_1_1_q;
	protected AbstractElementAlias match_TransDecl_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_VarDecl_CommaKeyword_0_1_q;
	protected AbstractElementAlias match_VarDecls_CommaKeyword_1_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SalGrammarAccess) access;
		match_Assignments_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getAssignmentsAccess().getSemicolonKeyword_2());
		match_Definitions_SemicolonKeyword_1_q = new TokenAlias(false, true, grammarAccess.getDefinitionsAccess().getSemicolonKeyword_1());
		match_InitDecl_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getInitDeclAccess().getSemicolonKeyword_1_1());
		match_Lhs_ApostropheKeyword_1_q = new TokenAlias(false, true, grammarAccess.getLhsAccess().getApostropheKeyword_1());
		match_ScalarType_CommaKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getScalarTypeAccess().getCommaKeyword_1_1());
		match_TransDecl_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getTransDeclAccess().getSemicolonKeyword_1_1());
		match_VarDecl_CommaKeyword_0_1_q = new TokenAlias(false, true, grammarAccess.getVarDeclAccess().getCommaKeyword_0_1());
		match_VarDecls_CommaKeyword_1_q = new TokenAlias(false, true, grammarAccess.getVarDeclsAccess().getCommaKeyword_1());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getIDENTIFIERSRule())
			return getIDENTIFIERSToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal IDENTIFIERS:
	 * 	('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'?'|'_')*
	 * 	| ( '+' | '-' | '*' | '/' | "=" )+
	 * ;
	 */
	protected String getIDENTIFIERSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Assignments_SemicolonKeyword_2_q.equals(syntax))
				emit_Assignments_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Definitions_SemicolonKeyword_1_q.equals(syntax))
				emit_Definitions_SemicolonKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_InitDecl_SemicolonKeyword_1_1_q.equals(syntax))
				emit_InitDecl_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Lhs_ApostropheKeyword_1_q.equals(syntax))
				emit_Lhs_ApostropheKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ScalarType_CommaKeyword_1_1_q.equals(syntax))
				emit_ScalarType_CommaKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TransDecl_SemicolonKeyword_1_1_q.equals(syntax))
				emit_TransDecl_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VarDecl_CommaKeyword_0_1_q.equals(syntax))
				emit_VarDecl_CommaKeyword_0_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VarDecls_CommaKeyword_1_q.equals(syntax))
				emit_VarDecls_CommaKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_Assignments_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_Definitions_SemicolonKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_InitDecl_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '''?
	 */
	protected void emit_Lhs_ApostropheKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_ScalarType_CommaKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_TransDecl_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_VarDecl_CommaKeyword_0_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_VarDecls_CommaKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
