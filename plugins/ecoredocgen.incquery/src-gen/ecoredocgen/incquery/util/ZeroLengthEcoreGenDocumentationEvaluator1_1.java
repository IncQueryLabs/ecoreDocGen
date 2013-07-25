package ecoredocgen.incquery.util;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the ecoredocgen.incquery.zeroLengthEcoreGenDocumentation pattern.
 */
@SuppressWarnings("all")
public class ZeroLengthEcoreGenDocumentationEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final String doc) {
    int _length = doc.length();
    boolean _equals = (_length == 0);
    return Boolean.valueOf(_equals);
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
