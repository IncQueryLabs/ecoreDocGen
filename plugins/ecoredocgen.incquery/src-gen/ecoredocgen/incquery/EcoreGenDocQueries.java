package ecoredocgen.incquery;

import ecoredocgen.incquery.ECoreDocumentationMatcher;
import ecoredocgen.incquery.MissingEcoreDocumentationMatcher;
import ecoredocgen.incquery.MissingEcoreDocumentation_EClassMatcher;
import ecoredocgen.incquery.MissingEcoreGenDocumentation_EPackageMatcher;
import ecoredocgen.incquery.TooShortEcoreGenDocumentationMatcher;
import ecoredocgen.incquery.ZeroLengthEcoreGenDocumentationMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in EcoreGenDocQueries.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare 
 * an EMF-IncQuery engine for matching all patterns originally defined in file EcoreGenDocQueries.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package ecoredocgen.incquery, the group contains the definition of the following patterns: <ul>
 * <li>eCorePackage</li>
 * <li>isInEcore</li>
 * <li>eCoreDocumentation</li>
 * <li>missingEcoreDocumentation</li>
 * <li>missingEcoreDocumentation_EClass</li>
 * <li>missingEcoreGenDocumentation_EPackage</li>
 * <li>zeroLengthEcoreGenDocumentation</li>
 * <li>tooShortEcoreGenDocumentation</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
public final class EcoreGenDocQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static EcoreGenDocQueries instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new EcoreGenDocQueries();
    }
    return INSTANCE;
    
  }
  
  private static EcoreGenDocQueries INSTANCE;
  
  private EcoreGenDocQueries() throws IncQueryException {
    querySpecifications.add(ZeroLengthEcoreGenDocumentationMatcher.querySpecification());
    querySpecifications.add(ECoreDocumentationMatcher.querySpecification());
    querySpecifications.add(MissingEcoreDocumentation_EClassMatcher.querySpecification());
    querySpecifications.add(TooShortEcoreGenDocumentationMatcher.querySpecification());
    querySpecifications.add(MissingEcoreDocumentationMatcher.querySpecification());
    querySpecifications.add(MissingEcoreGenDocumentation_EPackageMatcher.querySpecification());
    
  }
}
