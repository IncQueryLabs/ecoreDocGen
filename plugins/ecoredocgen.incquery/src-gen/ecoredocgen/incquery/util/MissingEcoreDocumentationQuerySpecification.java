package ecoredocgen.incquery.util;

import ecoredocgen.incquery.MissingEcoreDocumentationMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate MissingEcoreDocumentationMatcher in a type-safe way.
 * 
 * @see MissingEcoreDocumentationMatcher
 * @see MissingEcoreDocumentationMatch
 * 
 */
@SuppressWarnings("all")
public final class MissingEcoreDocumentationQuerySpecification extends BaseGeneratedQuerySpecification<MissingEcoreDocumentationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MissingEcoreDocumentationQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected MissingEcoreDocumentationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MissingEcoreDocumentationMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "ecoredocgen.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "ecoredocgen.incquery.missingEcoreDocumentation";
    
  }
  
  private MissingEcoreDocumentationQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<MissingEcoreDocumentationQuerySpecification> {
    @Override
    public MissingEcoreDocumentationQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static MissingEcoreDocumentationQuerySpecification INSTANCE = make();
    
    public static MissingEcoreDocumentationQuerySpecification make() {
      try {
      	return new MissingEcoreDocumentationQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
