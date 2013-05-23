package ecoredocgen.incquery;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the ecoredocgen.incquery.zeroLengthEcoreGenDocumentation pattern, 
 * to be used in conjunction with {@link ZeroLengthEcoreGenDocumentationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ZeroLengthEcoreGenDocumentationMatcher
 * @see ZeroLengthEcoreGenDocumentationProcessor
 * 
 */
public abstract class ZeroLengthEcoreGenDocumentationMatch extends BasePatternMatch {
  private ENamedElement fHost;
  
  private static List<String> parameterNames = makeImmutableList("host");
  
  private ZeroLengthEcoreGenDocumentationMatch(final ENamedElement pHost) {
    this.fHost = pHost;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("host".equals(parameterName)) return this.fHost;
    return null;
    
  }
  
  public ENamedElement getHost() {
    return this.fHost;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("host".equals(parameterName) ) {
    	this.fHost = (org.eclipse.emf.ecore.ENamedElement) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setHost(final ENamedElement pHost) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fHost = pHost;
    
  }
  
  @Override
  public String patternName() {
    return "ecoredocgen.incquery.zeroLengthEcoreGenDocumentation";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ZeroLengthEcoreGenDocumentationMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fHost};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"host\"=" + prettyPrintValue(fHost));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fHost == null) ? 0 : fHost.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ZeroLengthEcoreGenDocumentationMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ZeroLengthEcoreGenDocumentationMatch other = (ZeroLengthEcoreGenDocumentationMatch) obj;
    if (fHost == null) {if (other.fHost != null) return false;}
    else if (!fHost.equals(other.fHost)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return ZeroLengthEcoreGenDocumentationMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends ZeroLengthEcoreGenDocumentationMatch {
    Mutable(final ENamedElement pHost) {
      super(pHost);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends ZeroLengthEcoreGenDocumentationMatch {
    Immutable(final ENamedElement pHost) {
      super(pHost);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
