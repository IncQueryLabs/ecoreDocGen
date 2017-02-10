package ecoredocgen.incquery;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import org.eclipse.incquery.validation.core.api.Severity;
import org.eclipse.incquery.validation.core.api.IConstraintSpecification;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import ecoredocgen.incquery.util.ZeroLengthEcoreGenDocumentationQuerySpecification;

public class ZeroLengthEcoreGenDocumentationConstraint0 implements IConstraintSpecification {

    private ZeroLengthEcoreGenDocumentationQuerySpecification querySpecification;

    public ZeroLengthEcoreGenDocumentationConstraint0() throws IncQueryException {
        querySpecification = ZeroLengthEcoreGenDocumentationQuerySpecification.instance();
    }

    @Override
    public String getMessageFormat() {
        return "$host$ has an empty EcoreGen Documentation";
    }


    @Override
    public Map<String,Object> getKeyObjects(IPatternMatch signature) {
        Map<String,Object> map = ImmutableMap.of(
            "host",signature.get("host")
        );
        return map;
    }

    @Override
    public List<String> getKeyNames() {
        List<String> keyNames = ImmutableList.of(
            "host"
        );
        return keyNames;
    }

    @Override
    public List<String> getPropertyNames() {
        List<String> propertyNames = ImmutableList.of(
        );
        return propertyNames;
    }

    @Override
    public Set<List<String>> getSymmetricPropertyNames() {
        Set<List<String>> symmetricPropertyNamesSet = ImmutableSet.<List<String>>of(
        );
        return symmetricPropertyNamesSet;
    }

    @Override
    public Set<List<String>> getSymmetricKeyNames() {
        Set<List<String>> symmetricKeyNamesSet = ImmutableSet.<List<String>>of(
        );
        return symmetricKeyNamesSet;
    }

    @Override
    public Severity getSeverity() {
        return Severity.WARNING;
    }

    @Override
    public IQuerySpecification<? extends IncQueryMatcher<? extends IPatternMatch>> getQuerySpecification() {
        return querySpecification;
    }

}
