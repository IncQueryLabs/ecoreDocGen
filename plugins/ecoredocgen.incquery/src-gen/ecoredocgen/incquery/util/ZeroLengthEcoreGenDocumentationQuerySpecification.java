package ecoredocgen.incquery.util;

import ecoredocgen.incquery.ZeroLengthEcoreGenDocumentationMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate ZeroLengthEcoreGenDocumentationMatcher in a type-safe way.
 * 
 * @see ZeroLengthEcoreGenDocumentationMatcher
 * @see ZeroLengthEcoreGenDocumentationMatch
 * 
 */
@SuppressWarnings("all")
public final class ZeroLengthEcoreGenDocumentationQuerySpecification extends BaseGeneratedQuerySpecification<ZeroLengthEcoreGenDocumentationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ZeroLengthEcoreGenDocumentationQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected ZeroLengthEcoreGenDocumentationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ZeroLengthEcoreGenDocumentationMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "ecoredocgen.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "ecoredocgen.incquery.zeroLengthEcoreGenDocumentation";
    
  }
  
  private ZeroLengthEcoreGenDocumentationQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<ZeroLengthEcoreGenDocumentationQuerySpecification> {
    @Override
    public ZeroLengthEcoreGenDocumentationQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static ZeroLengthEcoreGenDocumentationQuerySpecification INSTANCE = make();
    
    public static ZeroLengthEcoreGenDocumentationQuerySpecification make() {
      try {
      	return new ZeroLengthEcoreGenDocumentationQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
