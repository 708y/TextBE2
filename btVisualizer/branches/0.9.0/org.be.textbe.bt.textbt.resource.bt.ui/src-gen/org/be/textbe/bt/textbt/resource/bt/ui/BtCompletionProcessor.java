/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bt.textbt.resource.bt.ui;

public class BtCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.be.textbe.bt.textbt.resource.bt.IBtResourceProvider resourceProvider;
	private org.be.textbe.bt.textbt.resource.bt.ui.IBtBracketHandlerProvider bracketHandlerProvider;
	
	public BtCompletionProcessor(org.be.textbe.bt.textbt.resource.bt.IBtResourceProvider resourceProvider, org.be.textbe.bt.textbt.resource.bt.ui.IBtBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		org.be.textbe.bt.textbt.resource.bt.IBtTextResource textResource = resourceProvider.getResource();
		String content = viewer.getDocument().get();
		org.be.textbe.bt.textbt.resource.bt.ui.BtCodeCompletionHelper helper = new org.be.textbe.bt.textbt.resource.bt.ui.BtCodeCompletionHelper();
		org.be.textbe.bt.textbt.resource.bt.ui.BtCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.be.textbe.bt.textbt.resource.bt.ui.BtProposalPostProcessor proposalPostProcessor = new org.be.textbe.bt.textbt.resource.bt.ui.BtProposalPostProcessor();
		java.util.List<org.be.textbe.bt.textbt.resource.bt.ui.BtCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<org.be.textbe.bt.textbt.resource.bt.ui.BtCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<org.be.textbe.bt.textbt.resource.bt.ui.BtCompletionProposal> finalProposalList = new java.util.ArrayList<org.be.textbe.bt.textbt.resource.bt.ui.BtCompletionProposal>();
		for (org.be.textbe.bt.textbt.resource.bt.ui.BtCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.be.textbe.bt.textbt.resource.bt.ui.BtCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			org.be.textbe.bt.textbt.resource.bt.ui.IBtBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
