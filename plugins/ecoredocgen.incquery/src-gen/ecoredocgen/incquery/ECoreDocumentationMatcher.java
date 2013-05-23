package ecoredocgen.incquery;

import ecoredocgen.incquery.ECoreDocumentationMatch;
import ecoredocgen.incquery.util.ECoreDocumentationQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * Generated pattern matcher API of the ecoredocgen.incquery.eCoreDocumentation pattern, 
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)}, 
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ECoreDocumentationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern eCoreDocumentation(host:ENamedElement, ann:EAnnotation, doc:EString) 
 * {
 * 	ENamedElement.eAnnotations(host,ann);
 * 	EAnnotation.source(ann,"http://www.eclipse.org/emf/2002/GenModel");
 * 	EAnnotation.details(ann,mapEntry);
 * 	EStringToStringMapEntry.key(mapEntry,"documentation");
 * 	EStringToStringMapEntry.value(mapEntry,doc);
 * }
 * </pre></code>
 * 
 * @see ECoreDocumentationMatch
 * @see ECoreDocumentationProcessor
 * @see ECoreDocumentationQuerySpecification
 * 
 */
public class ECoreDocumentationMatcher extends BaseMatcher<ECoreDocumentationMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ECoreDocumentationMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ECoreDocumentationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ECoreDocumentationMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    } 	
    return matcher;
  }
  
  private final static int POSITION_HOST = 0;
  
  private final static int POSITION_ANN = 1;
  
  private final static int POSITION_DOC = 2;
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet). 
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so 
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public ECoreDocumentationMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public ECoreDocumentationMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pHost the fixed value of pattern parameter host, or null if not bound.
   * @param pAnn the fixed value of pattern parameter ann, or null if not bound.
   * @param pDoc the fixed value of pattern parameter doc, or null if not bound.
   * @return matches represented as a ECoreDocumentationMatch object.
   * 
   */
  public Collection<ECoreDocumentationMatch> getAllMatches(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc) {
    return rawGetAllMatches(new Object[]{pHost, pAnn, pDoc});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pHost the fixed value of pattern parameter host, or null if not bound.
   * @param pAnn the fixed value of pattern parameter ann, or null if not bound.
   * @param pDoc the fixed value of pattern parameter doc, or null if not bound.
   * @return a match represented as a ECoreDocumentationMatch object, or null if no match is found.
   * 
   */
  public ECoreDocumentationMatch getOneArbitraryMatch(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc) {
    return rawGetOneArbitraryMatch(new Object[]{pHost, pAnn, pDoc});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pHost the fixed value of pattern parameter host, or null if not bound.
   * @param pAnn the fixed value of pattern parameter ann, or null if not bound.
   * @param pDoc the fixed value of pattern parameter doc, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc) {
    return rawHasMatch(new Object[]{pHost, pAnn, pDoc});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pHost the fixed value of pattern parameter host, or null if not bound.
   * @param pAnn the fixed value of pattern parameter ann, or null if not bound.
   * @param pDoc the fixed value of pattern parameter doc, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc) {
    return rawCountMatches(new Object[]{pHost, pAnn, pDoc});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pHost the fixed value of pattern parameter host, or null if not bound.
   * @param pAnn the fixed value of pattern parameter ann, or null if not bound.
   * @param pDoc the fixed value of pattern parameter doc, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc, final IMatchProcessor<? super ECoreDocumentationMatch> processor) {
    rawForEachMatch(new Object[]{pHost, pAnn, pDoc}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pHost the fixed value of pattern parameter host, or null if not bound.
   * @param pAnn the fixed value of pattern parameter ann, or null if not bound.
   * @param pDoc the fixed value of pattern parameter doc, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc, final IMatchProcessor<? super ECoreDocumentationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pHost, pAnn, pDoc}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters. 
   * It can also be reset to track changes from a later point in time, 
   * and changes can even be acknowledged on an individual basis. 
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pHost the fixed value of pattern parameter host, or null if not bound.
   * @param pAnn the fixed value of pattern parameter ann, or null if not bound.
   * @param pDoc the fixed value of pattern parameter doc, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<ECoreDocumentationMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final ENamedElement pHost, final EAnnotation pAnn, final String pDoc) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pHost, pAnn, pDoc});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher. 
   * This can be used e.g. to call the matcher with a partial match. 
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pHost the fixed value of pattern parameter host, or null if not bound.
   * @param pAnn the fixed value of pattern parameter ann, or null if not bound.
   * @param pDoc the fixed value of pattern parameter doc, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ECoreDocumentationMatch newMatch(final ENamedElement pHost, final EAnnotation pAnn, final String pDoc) {
    return new ECoreDocumentationMatch.Immutable(pHost, pAnn, pDoc);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for host.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ENamedElement> rawAccumulateAllValuesOfhost(final Object[] parameters) {
    Set<ENamedElement> results = new HashSet<ENamedElement>();
    rawAccumulateAllValues(POSITION_HOST, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for host.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ENamedElement> getAllValuesOfhost() {
    return rawAccumulateAllValuesOfhost(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for host.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ENamedElement> getAllValuesOfhost(final ECoreDocumentationMatch partialMatch) {
    return rawAccumulateAllValuesOfhost(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for host.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ENamedElement> getAllValuesOfhost(final EAnnotation pAnn, final String pDoc) {
    return rawAccumulateAllValuesOfhost(new Object[]{null, pAnn, pDoc});
  }
  
  /**
   * Retrieve the set of values that occur in matches for ann.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EAnnotation> rawAccumulateAllValuesOfann(final Object[] parameters) {
    Set<EAnnotation> results = new HashSet<EAnnotation>();
    rawAccumulateAllValues(POSITION_ANN, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ann.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EAnnotation> getAllValuesOfann() {
    return rawAccumulateAllValuesOfann(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ann.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EAnnotation> getAllValuesOfann(final ECoreDocumentationMatch partialMatch) {
    return rawAccumulateAllValuesOfann(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ann.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EAnnotation> getAllValuesOfann(final ENamedElement pHost, final String pDoc) {
    return rawAccumulateAllValuesOfann(new Object[]{pHost, null, pDoc});
  }
  
  /**
   * Retrieve the set of values that occur in matches for doc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfdoc(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_DOC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for doc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfdoc() {
    return rawAccumulateAllValuesOfdoc(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for doc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfdoc(final ECoreDocumentationMatch partialMatch) {
    return rawAccumulateAllValuesOfdoc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for doc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfdoc(final ENamedElement pHost, final EAnnotation pAnn) {
    return rawAccumulateAllValuesOfdoc(new Object[]{pHost, pAnn, null});
  }
  
  @Override
  protected ECoreDocumentationMatch tupleToMatch(final Tuple t) {
    try {
    	return new ECoreDocumentationMatch.Immutable((org.eclipse.emf.ecore.ENamedElement) t.get(POSITION_HOST), (org.eclipse.emf.ecore.EAnnotation) t.get(POSITION_ANN), (java.lang.String) t.get(POSITION_DOC));	
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected ECoreDocumentationMatch arrayToMatch(final Object[] match) {
    try {
    	return new ECoreDocumentationMatch.Immutable((org.eclipse.emf.ecore.ENamedElement) match[POSITION_HOST], (org.eclipse.emf.ecore.EAnnotation) match[POSITION_ANN], (java.lang.String) match[POSITION_DOC]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected ECoreDocumentationMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new ECoreDocumentationMatch.Mutable((org.eclipse.emf.ecore.ENamedElement) match[POSITION_HOST], (org.eclipse.emf.ecore.EAnnotation) match[POSITION_ANN], (java.lang.String) match[POSITION_DOC]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ECoreDocumentationMatcher> querySpecification() throws IncQueryException {
    return ECoreDocumentationQuerySpecification.instance();
  }
}
