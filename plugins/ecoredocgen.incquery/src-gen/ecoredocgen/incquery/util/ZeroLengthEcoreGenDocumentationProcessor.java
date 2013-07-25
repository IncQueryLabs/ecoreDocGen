package ecoredocgen.incquery.util;

import ecoredocgen.incquery.ZeroLengthEcoreGenDocumentationMatch;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the ecoredocgen.incquery.zeroLengthEcoreGenDocumentation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ZeroLengthEcoreGenDocumentationProcessor implements IMatchProcessor<ZeroLengthEcoreGenDocumentationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pHost the value of pattern parameter host in the currently processed match 
   * 
   */
  public abstract void process(final ENamedElement pHost);
  
  @Override
  public void process(final ZeroLengthEcoreGenDocumentationMatch match) {
    process(match.getHost());
    
  }
}
