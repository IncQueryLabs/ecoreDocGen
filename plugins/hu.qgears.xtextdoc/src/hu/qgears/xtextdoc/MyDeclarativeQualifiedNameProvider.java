package hu.qgears.xtextdoc;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * This class is for adding QualifiedName for {@link EObjectWrapper} type.
 * Without this no hovers are created for the EObject.
 * 
 * Bind with Abstract[LanguageName]RuntimeModule.bindIQualifiedNameProvider().
 * 
 * @author glaseradam
 *
 */
public class MyDeclarativeQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof EObjectWrapper) {
			return QualifiedName.create(((EObjectWrapper) obj).toString());
		}
		return super.getFullyQualifiedName(obj);
	}

}
