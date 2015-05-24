package de.netallied.functionblock.codeeditor.st;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class STCompletionProcessor implements IContentAssistProcessor {

	protected final static String[] myProposals = { "myTag", "html","form" };

	/* (non-Javadoc)
	 * Method declared on IContentAssistProcessor
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,int documentOffset) 
  {
		ICompletionProposal[] result =new ICompletionProposal[myProposals.length];
		for (int i = 0; i < myProposals.length; i++) 
    {
			result[i] = new CompletionProposal(myProposals[i],documentOffset, 0, myProposals[i].length());
		}
		return result;
	}

	/* (non-Javadoc)
	 * Method declared on IContentAssistProcessor
	 */
	public char[] getCompletionProposalAutoActivationCharacters() 
  {
		return new char[] { '<' };
	}

	/* (non-Javadoc)
	 * Method declared on IContentAssistProcessor
	 */
	public char[] getContextInformationAutoActivationCharacters() 
  {
		return null;
	}

	// For Context information 
	/* (non-Javadoc)
	 * Method declared on IContentAssistProcessor
	 */
	public IContextInformationValidator getContextInformationValidator() 
  {
		return null;
	}

	/* (non-Javadoc)
	 * Method declared on IContentAssistProcessor
	 */
	public IContextInformation[] computeContextInformation(	ITextViewer viewer,	int documentOffset) 
  {
		return null;
	}

	/* (non-Javadoc)
	 * Method declared on IContentAssistProcessor
	 */
	public String getErrorMessage() 
  {
		return null;
	}
}
