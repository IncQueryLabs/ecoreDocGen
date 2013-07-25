package ecoredocgen.incquery.util;

import ecoredocgen.incquery.TooShortEcoreGenDocumentationMatch;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the ecoredocgen.incquery.tooShortEcoreGenDocumentation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TooShortEcoreGenDocumentationProcessor implements IMatchProcessor<TooShortEcoreGenDocumentationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pHost the value of pattern parameter host in the currently processed match 
   * 
   */
  public abstract void process(final ENamedElement pHost);
  
  @Override
  public void process(final TooShortEcoreGenDocumentationMatch match) {
    process(match.getHost());
    
  }
}
