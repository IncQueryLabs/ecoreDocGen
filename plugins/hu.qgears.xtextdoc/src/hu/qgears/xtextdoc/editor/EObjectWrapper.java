package hu.qgears.xtextdoc.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * Wrapper class used in hover/content assist documentations. 
 * Holds more information about the object: the container's class type, the feature, the feature's class type.
 * Null value means the information has no usage.
 * 
 * @author glaseradam
 *
 */
public class EObjectWrapper extends EObjectImpl {
	
	private EClass eClass;
	private EStructuralFeature eFeature;
	private EClass eClassFeatureType;
	
	public EObjectWrapper(EClass eClass, EStructuralFeature eFeature, EClass eClassFeatureType) { 
		this.eClass = eClass;
		this.eFeature = eFeature;
		this.eClassFeatureType = eClassFeatureType;
	}
	
	public EStructuralFeature geteFeature() {
		return eFeature;
	}
	
	public void seteFeature(EStructuralFeature eFeature) {
		this.eFeature = eFeature;
	}
	
	public EClass geteClass() {
		return eClass;
	}
	
	public void seteClass(EClass eClass) {
		this.eClass = eClass;
	}

	public EClass geteClassFeatureType() {
		return eClassFeatureType;
	}

	public void seteClassFeatureType(EClass eClassFeatureType) {
		this.eClassFeatureType = eClassFeatureType;
	}

}
