// File name: TranslateSetAdd.h
// Author/s : Nisansala Yatapanage
// Date built: 2/11/2006
// Last updated: 2/11/2006
// Purpose: Implementation of the set rule for adding an
//		    element to a set.
// Algorithms used:
// Description of Algorithm#:
//

#pragma once
#include "TranslateParsingRule.h"
#include "TranslateParsingMethods.h"
#include "NString.h"

class CTranslateSetAdd : 
	public CTranslateParsingRule
{
public:
	CTranslateSetAdd(void);
public:
	~CTranslateSetAdd(void);
public:
	bool applyBackwards(CTranslateSALMain& cMain, NList<int, int>& cLeafNodes, NList<int, int>& cAllNodes, int iFinalNode, NList<int, int>& cInitNodes, bool bConsiderIfBranching, NList<CTranslateParsingRule*, CTranslateParsingRule*>* plRules);
	void translateToSAL(CTranslateSALMain& cMain, int iNode, int iOtherNode, NList<CTranslateParsingRule*, CTranslateParsingRule*>* plSecondaryRules);
	CTranslateParsingMethods m_cParsingMethods;
};
