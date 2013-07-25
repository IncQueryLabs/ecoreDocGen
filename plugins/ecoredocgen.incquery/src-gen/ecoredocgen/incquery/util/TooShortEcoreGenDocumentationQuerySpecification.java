package ecoredocgen.incquery.util;

import ecoredocgen.incquery.TooShortEcoreGenDocumentationMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate TooShortEcoreGenDocumentationMatcher in a type-safe way.
 * 
 * @see TooShortEcoreGenDocumentationMatcher
 * @see TooShortEcoreGenDocumentationMatch
 * 
 */
@SuppressWarnings("all")
public final class TooShortEcoreGenDocumentationQuerySpecification extends BaseGeneratedQuerySpecification<TooShortEcoreGenDocumentationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TooShortEcoreGenDocumentationQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TooShortEcoreGenDocumentationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TooShortEcoreGenDocumentationMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "ecoredocgen.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "ecoredocgen.incquery.tooShortEcoreGenDocumentation";
    
  }
  
  private TooShortEcoreGenDocumentationQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<TooShortEcoreGenDocumentationQuerySpecification> {
    @Override
    public TooShortEcoreGenDocumentationQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static TooShortEcoreGenDocumentationQuerySpecification INSTANCE = make();
    
    public static TooShortEcoreGenDocumentationQuerySpecification make() {
      try {
      	return new TooShortEcoreGenDocumentationQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
