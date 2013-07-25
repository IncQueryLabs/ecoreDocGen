package ecoredocgen.incquery.util;

import ecoredocgen.incquery.MissingEcoreDocumentation_EClassMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;

/**
 * A pattern-specific query specification that can instantiate MissingEcoreDocumentation_EClassMatcher in a type-safe way.
 * 
 * @see MissingEcoreDocumentation_EClassMatcher
 * @see MissingEcoreDocumentation_EClassMatch
 * 
 */
@SuppressWarnings("all")
public final class MissingEcoreDocumentation_EClassQuerySpecification extends BaseGeneratedQuerySpecification<MissingEcoreDocumentation_EClassMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MissingEcoreDocumentation_EClassQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected MissingEcoreDocumentation_EClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MissingEcoreDocumentation_EClassMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "ecoredocgen.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "ecoredocgen.incquery.missingEcoreDocumentation_EClass";
    
  }
  
  private MissingEcoreDocumentation_EClassQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<MissingEcoreDocumentation_EClassQuerySpecification> {
    @Override
    public MissingEcoreDocumentation_EClassQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static MissingEcoreDocumentation_EClassQuerySpecification INSTANCE = make();
    
    public static MissingEcoreDocumentation_EClassQuerySpecification make() {
      try {
      	return new MissingEcoreDocumentation_EClassQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
