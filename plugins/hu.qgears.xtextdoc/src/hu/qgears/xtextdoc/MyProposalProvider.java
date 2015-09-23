package hu.qgears.xtextdoc;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.ui.contentassist.TerminalsProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.inject.Inject;

import hu.qgears.xtextdoc.util.UtilDoc;

/**
 * This class is for adding documentation in content assist for keywords.
 * 
 * This class must be copied and it must extend the generated Abstract[LanguageName]ProposalProvider class!
 * 
 * Bind with Abstract[LanguageName]UiModule.bindIContentProposalProvider(). 
 * 
 * @author glaseradam
 *
 */
public class MyProposalProvider extends TerminalsProposalProvider {

	@Inject
	KeywordHelper keywordHelper;
	
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		ICompletionProposal proposal = createCompletionProposal(keyword.getValue(), getKeywordDisplayString(keyword),
				getImage(keyword), contentAssistContext);
		if (proposal != null) {
			StringBuilder sb = new StringBuilder();
			Assignment nextAssignment = keywordHelper.getNextAssignment(keyword.eContainer());	
			if (nextAssignment != null) {
				EStructuralFeature feature = keywordHelper.getFeature(nextAssignment);
				sb.append(UtilDoc.getEMFDocumentation(feature));
			}
			EClass eClass = keywordHelper.getEClass(keyword);
			if (eClass != null) {
				sb.append("\n\nOwner class - " + eClass.getName() + ": " + UtilDoc.getEMFDocumentation(eClass));
			}
			((ConfigurableCompletionProposal) proposal).setAdditionalProposalInfo(sb);
		}
		getPriorityHelper().adjustKeywordPriority(proposal, contentAssistContext.getPrefix());
		acceptor.accept(proposal);
	}
}
