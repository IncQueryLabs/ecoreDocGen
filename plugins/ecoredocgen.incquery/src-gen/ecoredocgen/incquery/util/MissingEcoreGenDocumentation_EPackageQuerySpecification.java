package ecoredocgen.incquery.util;

import ecoredocgen.incquery.MissingEcoreGenDocumentation_EPackageMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate MissingEcoreGenDocumentation_EPackageMatcher in a type-safe way.
 * 
 * @see MissingEcoreGenDocumentation_EPackageMatcher
 * @see MissingEcoreGenDocumentation_EPackageMatch
 * 
 */
@SuppressWarnings("all")
public final class MissingEcoreGenDocumentation_EPackageQuerySpecification extends BaseGeneratedQuerySpecification<MissingEcoreGenDocumentation_EPackageMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MissingEcoreGenDocumentation_EPackageQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected MissingEcoreGenDocumentation_EPackageMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MissingEcoreGenDocumentation_EPackageMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "ecoredocgen.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "ecoredocgen.incquery.missingEcoreGenDocumentation_EPackage";
    
  }
  
  private MissingEcoreGenDocumentation_EPackageQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<MissingEcoreGenDocumentation_EPackageQuerySpecification> {
    @Override
    public MissingEcoreGenDocumentation_EPackageQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static MissingEcoreGenDocumentation_EPackageQuerySpecification INSTANCE = make();
    
    public static MissingEcoreGenDocumentation_EPackageQuerySpecification make() {
      try {
      	return new MissingEcoreGenDocumentation_EPackageQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
