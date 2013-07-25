package ecoredocgen.incquery.util;

import ecoredocgen.incquery.ECoreDocumentationMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate ECoreDocumentationMatcher in a type-safe way.
 * 
 * @see ECoreDocumentationMatcher
 * @see ECoreDocumentationMatch
 * 
 */
@SuppressWarnings("all")
public final class ECoreDocumentationQuerySpecification extends BaseGeneratedQuerySpecification<ECoreDocumentationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ECoreDocumentationQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected ECoreDocumentationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ECoreDocumentationMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "ecoredocgen.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "ecoredocgen.incquery.eCoreDocumentation";
    
  }
  
  private ECoreDocumentationQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<ECoreDocumentationQuerySpecification> {
    @Override
    public ECoreDocumentationQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static ECoreDocumentationQuerySpecification INSTANCE = make();
    
    public static ECoreDocumentationQuerySpecification make() {
      try {
      	return new ECoreDocumentationQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
