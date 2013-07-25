package ecoredocgen.incquery.util;

import ecoredocgen.incquery.MissingEcoreDocumentation_EClassMatch;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the ecoredocgen.incquery.missingEcoreDocumentation_EClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MissingEcoreDocumentation_EClassProcessor implements IMatchProcessor<MissingEcoreDocumentation_EClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pHost the value of pattern parameter host in the currently processed match 
   * 
   */
  public abstract void process(final EClass pHost);
  
  @Override
  public void process(final MissingEcoreDocumentation_EClassMatch match) {
    process(match.getHost());
    
  }
}
