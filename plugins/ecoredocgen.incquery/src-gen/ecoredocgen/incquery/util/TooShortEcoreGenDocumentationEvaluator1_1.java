package ecoredocgen.incquery.util;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the ecoredocgen.incquery.tooShortEcoreGenDocumentation pattern.
 */
@SuppressWarnings("all")
public class TooShortEcoreGenDocumentationEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final String doc) {
    boolean _and = false;
    int _length = doc.length();
    boolean _greaterThan = (_length > 0);
    if (!_greaterThan) {
      _and = false;
    } else {
      int _length_1 = doc.length();
      boolean _lessThan = (_length_1 < 50);
      _and = (_greaterThan && _lessThan);
    }
    return Boolean.valueOf(_and);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int docPosition = tupleNameMap.get("doc");
    java.lang.String doc = (java.lang.String) tuple.get(docPosition);
    return evaluateXExpressionGenerated(doc);
  }
}
