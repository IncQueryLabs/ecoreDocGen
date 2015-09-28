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
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;

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
	private KeywordHelper keywordHelper;

	@Inject
	private IEObjectHover hover;

	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
	
		ICompletionProposal proposal = createCompletionProposal(keyword.getValue(), getKeywordDisplayString(keyword),
				getImage(keyword), contentAssistContext);
		
		if (proposal != null) {
			StringBuilder sb = new StringBuilder();
			
			if (keywordHelper.keywordIsType(keyword)) {
				EClass eClass = keywordHelper.getEClass(keyword);
				sb.append(UtilDoc.getEMFDocumentation(eClass));
			} else {
				Assignment nextAssignment = keywordHelper.getNextAssignment(keyword.eContainer());	
				if (nextAssignment != null) {
					EStructuralFeature feature = keywordHelper.getFeature(nextAssignment);
					sb.append(UtilDoc.getEMFDocumentation(feature));
				}
			}
			
			ConfigurableCompletionProposal configurableCompletionProposal = (ConfigurableCompletionProposal) proposal;
			configurableCompletionProposal.setProposalContextResource(contentAssistContext.getResource());
			configurableCompletionProposal.setAdditionalProposalInfo("<html>" + sb + "</html>");		
			configurableCompletionProposal.setHover(hover);
		}
		getPriorityHelper().adjustKeywordPriority(proposal, contentAssistContext.getPrefix());
		acceptor.accept(proposal);
	}
	


}
