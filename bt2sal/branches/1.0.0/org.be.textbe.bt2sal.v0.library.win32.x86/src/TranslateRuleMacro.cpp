// File name: TranslateRuleMacro.cpp
// Author/s : Nisansala Yatapanage
// Date built: 24/7/2006
// Last updated: 19/6/2007
// Purpose: Implementation of the Macro rule (Rule 5).
//
// Algorithms used:
// Description of Algorithm#:
//


#include "TranslateRuleMacro.h"
#include "TranslateStep.h"
#include "GSEMethod.h"
#include "TranslateException.h"

CTranslateRuleMacro::CTranslateRuleMacro(void)
{
	m_iRuleID = 5;
}

CTranslateRuleMacro::~CTranslateRuleMacro(void)
{
}

bool CTranslateRuleMacro::applyBackwards(CTranslateSALMain& cMain, NList<int, int>& cLeafNodes, NList<int, int>& cAllNodes, int iFinalNode, NList<int, int>& cInitNodes, bool bConsiderIfBranching, NList<CTranslateParsingRule*, CTranslateParsingRule*>* plRules)
{
	bool bRuleMatched = false;
	NPosition cCurrentNodePosition;
	cCurrentNodePosition = cAllNodes.GetHeadPosition();
	while(cCurrentNodePosition.IsNotNull()){
		int iCurrentNode;
		iCurrentNode = cAllNodes.GetNext(cCurrentNodePosition);
		CTranslateNode* pcNode = cMain.GetNode(iCurrentNode);
		NString strComponent = pcNode->GetComponentName();
		NString strState = pcNode->GetStateName();
		int iType = pcNode->GetType();
		int iJumpType = pcNode->GetJumpType();
		if (iJumpType == 2){ // This is a go-to node.
			// Check that it is a leaf node.
			int iChildNum = pcNode->GetNumberOfChildren();
			if (iChildNum == 0){
				// Find the matching go-to point.

				int iMatchCount = 0;
				int iOtherGoto;
				NPosition cAllPosition;
				cAllPosition = cAllNodes.GetHeadPosition();

				// If there's already a jumpingToLabel use that node as the go-to point.
				NString strJumpingToLabel = pcNode->GetJumpingToLabel();
				if (strJumpingToLabel != ""){
					// Find the node with that label.
					while (cAllPosition.IsNotNull()){
						int iAllNode = cAllNodes.GetNext(cAllPosition);
						CTranslateNode* pcAllNode = cMain.GetNode(iAllNode);
						if (pcAllNode->GetLabel() == strJumpingToLabel){
							NString strNodeComp = pcAllNode->GetComponentName();
							NString strNodeState = pcAllNode->GetStateName();
							int iNodeType = pcAllNode->GetType();
							// Check if the nodes match and it is a different node to this one.
							if ((iAllNode != iCurrentNode) && (iNodeType == iType) && (strNodeComp == strComponent) && (strNodeState == strState) && (pcAllNode->GetJumpType() == 0)){
								iMatchCount++;
								iOtherGoto = iAllNode;
							}else{
								NString strMessage = "Reference node trying to jump to a non-matching node (due to its label): ";
								strMessage = strMessage + strComponent + " " + strState;
								CTranslateException cException(strMessage);
								throw cException;
							}
						}
					}
				}else{
								
					while (cAllPosition.IsNotNull()){
						int iAllNode = cAllNodes.GetNext(cAllPosition);
						CTranslateNode* pcAllNode = cMain.GetNode(iAllNode);
						NString strNodeComp = pcAllNode->GetComponentName();
						NString strNodeState = pcAllNode->GetStateName();
						int iNodeType = pcAllNode->GetType();
						// Check if the nodes match and it is a different node to this one.
						if ((iAllNode != iCurrentNode) && (iNodeType == iType) && (strNodeComp == strComponent) && (strNodeState == strState) && (pcAllNode->GetJumpType() == 0)){
							iMatchCount++;
							iOtherGoto = iAllNode;
						}
					}
				}
				if (cMain.UsingRandomBT()){ // This is a random BT.
					// For random BT's, if there are > 1 matching nodes, no error is thrown;
					// instead the last matching node is chosen. This is because for large
					// random BT's, this case happens too often and it is difficult to create
					// a random BT that can be translated without this error occurring.
			//		if (iMatchCount == 0){
			//			// The matching node was not found.
			//			NString strMessage = "Matching reference node not found for: ";
			//			strMessage = strMessage + strComponent + " " + strState;
			//			CTranslateException cException(strMessage);
			//			throw cException;
			//		}else{
			//			NList<int, int>* plEmptyList = new NList<int, int>;
			//			cMain.StoreTranslationStep(iCurrentNode, 5, iOtherGoto, plEmptyList);
			//			bRuleMatched = true;
			//		}
				}else{ // This is a normal BT (not random).
					if (iMatchCount == 0){
						// The matching node was not found.
						NString strMessage = "Matching reference node not found for: ";
						strMessage = strMessage + strComponent + " " + strState;
						CTranslateException cException(strMessage);
						throw cException;
					}else if (iMatchCount > 1){
						// Too many matching nodes found.
						NString strMessage = "Too many matching reference nodes found for: ";
						strMessage = strMessage + strComponent + " " + strState;
						strMessage = strMessage + "\r\nUse a label to distinguish between them.";
						CTranslateException cException(strMessage);
						throw cException;
					}else{
						NList<int, int>* plEmptyList = new NList<int, int>;
						cMain.StoreTranslationStep(iCurrentNode, 5, iOtherGoto, plEmptyList);
						bRuleMatched = true;
					}
				}
			}
		}
	}
	// Note that matched nodes are not removed from the list.
	return bRuleMatched;
}

void CTranslateRuleMacro::translateToSAL(CTranslateSALMain& cMain, int iNode, int iOtherNode, NList<CTranslateParsingRule*, CTranslateParsingRule*>* plSecondaryRules) 
{
	NList<NString, NString>* plActions;
	if (!(cMain.UsingViews())){
		if (cMain.IsAtomic(iOtherNode)){
		//	// This is not allowed at present.
		//	// Throw an exception.
		//	CTranslateNode* pcNode = cMain.GetNode(iNode);
		//	NString strComponent = pcNode->GetComponentName();
		//	NString strState = pcNode->GetStateName();
		//	NString strMessage = "Jumping to an atomic node is not allowed: ";
		//	strMessage = strMessage + strComponent + " " + strState;
		//	CTranslateException cException(strMessage);
		//	throw cException;
			NList<CTranslateAtomicBlock*,CTranslateAtomicBlock*>* pcBlocks = cMain.GetAtomicBlocks(iOtherNode);
			CTranslateAtomicBlock* pcBlock = pcBlocks->GetHead();
			int iAtomicEnd = pcBlock->GetBottomNode();
			NList<NString, NString>* plTopActions = cMain.GetActions(iAtomicEnd);
			plActions = cMain.GetActions(iNode);

			// Copy all the top node's actions to the macro node.
			NPosition cTopPosition;
			cTopPosition = plTopActions->GetHeadPosition();
			while (cTopPosition.IsNotNull()){
				NString strAction = plTopActions->GetNext(cTopPosition);
				plActions->AddTail(strAction);
			}
			cMain.AddNodeAction(iNode,plActions);

		}else{
			NList<NString, NString>* plTopActions = cMain.GetActions(iOtherNode);
			plActions = cMain.GetActions(iNode);
			
			// Copy all the top node's actions to the macro node.
			NPosition cTopPosition;
			cTopPosition = plTopActions->GetHeadPosition();
			while (cTopPosition.IsNotNull()){
				NString strAction = plTopActions->GetNext(cTopPosition);
				plActions->AddTail(strAction);
			}
			cMain.AddNodeAction(iNode,plActions);
		}
			
	}else{  // Using failure views.
		// To be completed.
	}	
}

bool CTranslateRuleMacro::ContainsPCUpdate(NList<NString, NString>* plList, NString strPCName){
	NPosition cPosition;
	cPosition = plList->GetHeadPosition();
	while (cPosition.IsNotNull()){
		NString strAction = plList->GetNext(cPosition);
		int iIndex = strAction.Find(strPCName);
		if (iIndex != -1){
			return true;
		}
	}
	return false;
}
	
/*void CTranslateRuleMacro::translateToUPPAAL(CTranslateUPPAAL& cMain, int iNode, int iOtherNode, NList<CTranslateParsingRule*, CTranslateParsingRule*>* plSecondaryRules)
{
	if (!(cMain.UsingViews())){
		if (cMain.IsAtomic(iOtherNode)){
			// This is not allowed at present.
			// Throw an exception.
			CTranslateNode* pcNode = cMain.GetNode(iNode);
			NString strComponent = pcNode->GetComponentName();
			NString strState = pcNode->GetStateName();
			NString strMessage = "Jumping to an atomic node is not allowed: ";
			strMessage = strMessage + strComponent + " " + strState;
			CTranslateException cException(strMessage);
			throw cException;

		//	// Get the process that this node belongs to.
		//	int iPC = cMain.GetPC(iNode);
		//	int iProcess = cMain.GetProcess(iPC);
		//	// Get the process that the other node belongs to.
		//	int iOtherPC = cMain.GetPC(iOtherNode);
		//	int iOtherProcess = cMain.GetProcess(iOtherPC);
		//	int iOtherPCValue = cMain.GetPCValueForNode(iOtherNode);
		//	int iNewValue = iOtherPCValue + 1;

		//	CTranslateUTrans* pcTransition = cMain.GetNodeTransition(iNode);

		//	// Copy all the labels of the other node.
		//	CTranslateAtomicBlock* pcBlock = cMain.GetAtomicBlock(iOtherNode);
		//	int iAtomicEnd = pcBlock->GetBottomNode();

		//	CTranslateUTrans* pcOtherTransition = cMain.GetNodeTransition(iAtomicEnd);
		//	NString strOtherGuard = pcOtherTransition->GetGuard();
		//	NString strOtherAssignment = pcOtherTransition->GetAssignment();
		//	NString strOtherSynch = pcOtherTransition->GetSynchronisation();
		//	if (strOtherGuard != ""){
		//		pcTransition->AddLabel(strOtherGuard, 2);
		//	}
		//	if (strOtherAssignment != ""){
		//		pcTransition->AddLabel(strOtherAssignment, 1);
		//	}
		//	if (strOtherSynch != ""){
		//		pcTransition->AddLabel(strOtherSynch, 3);
		//	}
			
		//	// Change the target location.
		//	if (iProcess == iOtherProcess){  // The node is jumping to a location in the same process.
		//		pcTransition->SetTarget(iOtherPC, iNewValue, 0);
		//		pcTransition->SetIsJumpNode(true);
		//	
		//	}else{  // The node is jumping to another process.
		//		// Revert back to the disabled state for this process.
		//		pcTransition->SetTarget(iPC, 0, 0);  // 0 for the value indicates the disabled state.
		//		
		//		// Add a label to send out a jump message.
		//		NString strJumpMessage = "jumpToPro";
		//		strJumpMessage.Format(strJumpMessage + "%d"), iOtherPC;
		//		strJumpMessage.Append("state");
		//		strJumpMessage.Format(strJumpMessage + "%d"), iOtherPCValue;
		//		bool bSynchAdded = cMain.AddSynchronisation(strJumpMessage);
		//		NString strLabel = strJumpMessage + "!";
		//		pcTransition->AddLabel(strLabel, 3);
		//		pcTransition->SetIsJumpNode(true);
		//		
		//		// Add a transition to the other process to jump from disabled to the other node.
		//		if (bSynchAdded){   // The disabled transition was not already added.
		//			CTranslateUTrans* pcDisabledTransition;
		//			pcDisabledTransition->SetSource(iOtherProcess, 0, 0); // The disabled state of the other process.
		//			pcDisabledTransition->SetTarget(iOtherPC, iNewValue, 0);
		//			pcDisabledTransition->SetIsJumpNode(true);
		//			NString strLabel2 = strJumpMessage + "?";
		//			pcDisabledTransition->AddLabel(strLabel2, 3);
		//			NList<CTranslateUTrans*, CTranslateUTrans*>* plOtherProcessTrans;
		//			plOtherProcessTrans = cMain.GetTransitions(iOtherProcess);
		//			plOtherProcessTrans->AddTail(pcDisabledTransition);
		//		}
		//	}


		}else{
			//////////UUUUUUU  Need to copy the clocks of the other transition.

			// Change the target location.
			// Get the process that this node belongs to.
			int iPC = cMain.GetPC(iNode);
			int iProcess = cMain.GetProcess(iPC);
			// Get the process that the other node belongs to.
			int iOtherPC = cMain.GetPC(iOtherNode);
			int iOtherProcess = cMain.GetProcess(iOtherPC);
			int iOtherPCValue = cMain.GetPCValueForNode(iOtherNode);
			int iNewValue = iOtherPCValue + 1;

			CTranslateUTrans* pcTransition = cMain.GetNodeTransition(iNode);
			if (iProcess == iOtherProcess){  // The node is jumping to a location in the same process.
				pcTransition->SetTarget(iOtherPC, iNewValue, 0);
				pcTransition->SetIsJumpNode(true);
			
			}else{  // The node is jumping to another process.
				// Revert back to the disabled state for this process.
				pcTransition->SetTarget(iPC, 0, 0);  // 0 for the value indicates the disabled state.
				
				// Add a label to send out a jump message.
				NString strJumpMessage = "jumpToPro";
				strJumpMessage.Format(strJumpMessage + "%d"), iOtherPC;
				strJumpMessage.Append("state");
				strJumpMessage.Format(strJumpMessage + "%d"), iOtherPCValue;
				bool bSynchAdded = cMain.AddSynchronisation(strJumpMessage);
				NString strLabel = strJumpMessage + "!";
				pcTransition->AddLabel(strLabel,3);
				pcTransition->SetIsJumpNode(true);
				
				// Add a transition to the other process to jump from disabled to the other node.
				if (bSynchAdded){   // The disabled transition was not already added.
					CTranslateUTrans* pcDisabledTransition = new CTranslateUTrans;
					pcDisabledTransition->SetSource(iOtherProcess, 0, 0); // The disabled state of the other process.
					pcDisabledTransition->SetTarget(iOtherPC, iNewValue, 0);
					NString strLabel2 = strJumpMessage + "?";
					pcDisabledTransition->AddLabel(strLabel2, 3);
					pcDisabledTransition->SetIsJumpNode(true);
					NList<CTranslateUTrans*, CTranslateUTrans*>* plOtherProcessTrans;
					plOtherProcessTrans = cMain.GetTransitions(iOtherProcess);
					plOtherProcessTrans->AddTail(pcDisabledTransition);
				}
			}
		}
			
	}else{  // Using failure views.
		// To be completed.
	}	
}*/