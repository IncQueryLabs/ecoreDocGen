package ecoredocgen.incquery.util;

import ecoredocgen.incquery.MissingEcoreGenDocumentation_EPackageMatch;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the ecoredocgen.incquery.missingEcoreGenDocumentation_EPackage pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MissingEcoreGenDocumentation_EPackageProcessor implements IMatchProcessor<MissingEcoreGenDocumentation_EPackageMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pHost the value of pattern parameter host in the currently processed match 
   * 
   */
  public abstract void process(final EPackage pHost);
  
  @Override
  public void process(final MissingEcoreGenDocumentation_EPackageMatch match) {
    process(match.getHost());
    
  }
}
