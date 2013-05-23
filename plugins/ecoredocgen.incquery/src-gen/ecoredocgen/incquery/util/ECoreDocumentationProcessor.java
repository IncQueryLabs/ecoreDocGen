package ecoredocgen.incquery.util;

import ecoredocgen.incquery.ECoreDocumentationMatch;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the ecoredocgen.incquery.eCoreDocumentation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class ECoreDocumentationProcessor implements IMatchProcessor<ECoreDocumentationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pHost the value of pattern parameter host in the currently processed match 
   * @param pAnn the value of pattern parameter ann in the currently processed match 
   * @param pDoc the value of pattern parameter doc in the currently processed match 
   * 
   */
  public abstract void process(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc);
  
  @Override
  public void process(final ECoreDocumentationMatch match) {
    process(match.getHost(), match.getAnn(), match.getDoc());  				
    
  }
}
