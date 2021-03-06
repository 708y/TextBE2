// File name: TranslateRuleAltBranching.h
// Author/s : Nisansala Yatapanage
// Date built: 21/7/2006
// Last updated: 24/7/2006
// Purpose: Implementation of Alternative branching rule.
//
// Algorithms used:
// Description of Algorithm#:
//
#pragma once
#include "TranslateParsingRule.h"
#include "TranslateParsingMethods.h"
#include "NString.h"

class CTranslateRuleAltBranching : public CTranslateParsingRule
{
public:
	CTranslateRuleAltBranching(void);
public:
	~CTranslateRuleAltBranching(void);
public:
	bool applyBackwards(CTranslateSALMain& cMain, NList<int, int>& cLeafNodes, NList<int, int>& cAllNodes, int iFinalNode, NList<int, int>& cInitNodes, bool bConsiderIfBranching, NList<CTranslateParsingRule*, CTranslateParsingRule*>* plRules);
	void translateToSAL(CTranslateSALMain& cMain, int iNode, int iOtherNode, NList<CTranslateParsingRule*, CTranslateParsingRule*>* plSecondaryRules);
//	void translateToUPPAAL(CTranslateUPPAAL& cMain, int iNode, int iOtherNode, NList<CTranslateParsingRule*, CTranslateParsingRule*>* plSecondaryRules);
	CTranslateParsingRule* FindRule(int iIndex, NList<CTranslateParsingRule*, CTranslateParsingRule*>* plSecondaryRules);
	CTranslateParsingMethods m_cParsingMethods;
};