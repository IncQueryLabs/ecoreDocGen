package ecoredocgen.incquery;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the ecoredocgen.incquery.eCoreDocumentation pattern, 
 * to be used in conjunction with {@link ECoreDocumentationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ECoreDocumentationMatcher
 * @see ECoreDocumentationProcessor
 * 
 */
public abstract class ECoreDocumentationMatch extends BasePatternMatch {
  private ENamedElement fHost;
  
  private EAnnotation fAnn;
  
  private String fDoc;
  
  private static List<String> parameterNames = makeImmutableList("host", "ann", "doc");
  
  private ECoreDocumentationMatch(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc) {
    this.fHost = pHost;
    this.fAnn = pAnn;
    this.fDoc = pDoc;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("host".equals(parameterName)) return this.fHost;
    if ("ann".equals(parameterName)) return this.fAnn;
    if ("doc".equals(parameterName)) return this.fDoc;
    return null;
    
  }
  
  public ENamedElement getHost() {
    return this.fHost;
    
  }
  
  public EAnnotation getAnn() {
    return this.fAnn;
    
  }
  
  public String getDoc() {
    return this.fDoc;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("host".equals(parameterName) ) {
    	this.fHost = (org.eclipse.emf.ecore.ENamedElement) newValue;
    	return true;
    }
    if ("ann".equals(parameterName) ) {
    	this.fAnn = (org.eclipse.emf.ecore.EAnnotation) newValue;
    	return true;
    }
    if ("doc".equals(parameterName) ) {
    	this.fDoc = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setHost(final ENamedElement pHost) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fHost = pHost;
    
  }
  
  public void setAnn(final EAnnotation pAnn) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAnn = pAnn;
    
  }
  
  public void setDoc(final String pDoc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fDoc = pDoc;
    
  }
  
  @Override
  public String patternName() {
    return "ecoredocgen.incquery.eCoreDocumentation";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ECoreDocumentationMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fHost, fAnn, fDoc};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"host\"=" + prettyPrintValue(fHost) + ", ");
    result.append("\"ann\"=" + prettyPrintValue(fAnn) + ", ");
    result.append("\"doc\"=" + prettyPrintValue(fDoc));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fHost == null) ? 0 : fHost.hashCode()); 
    result = prime * result + ((fAnn == null) ? 0 : fAnn.hashCode()); 
    result = prime * result + ((fDoc == null) ? 0 : fDoc.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ECoreDocumentationMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ECoreDocumentationMatch other = (ECoreDocumentationMatch) obj;
    if (fHost == null) {if (other.fHost != null) return false;}
    else if (!fHost.equals(other.fHost)) return false;
    if (fAnn == null) {if (other.fAnn != null) return false;}
    else if (!fAnn.equals(other.fAnn)) return false;
    if (fDoc == null) {if (other.fDoc != null) return false;}
    else if (!fDoc.equals(other.fDoc)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return ECoreDocumentationMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends ECoreDocumentationMatch {
    Mutable(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc) {
      super(pHost, pAnn, pDoc);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends ECoreDocumentationMatch {
    Immutable(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc) {
      super(pHost, pAnn, pDoc);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
