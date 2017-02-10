package hu.bme.mit.documentation.generator.ecore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public class DocGenUtil {
	public static List<EClass> getSubTypes(final EPackage pkg, final EClass supertype, 
			boolean concreteTypesOnly) {
		EPackage rootPkg = getRootPackage(pkg);
		List<EClass> eClasses = new ArrayList<>(getAllEclasses(rootPkg));
		final List<EClass> result = eClasses.stream()
			.filter(eClass -> supertype.isSuperTypeOf(eClass) && 
					eClass != supertype &&
					(!concreteTypesOnly || (!eClass.isAbstract() && !eClass.isInterface())))
			.collect(Collectors.toList());
		return result;
	}

	public static List<EClass> getAllEclasses(final EPackage rootPkg) {
		List<EClass> eClasses = new ArrayList<>();
		for (final EPackage pkg : rootPkg.getESubpackages()) {
			eClasses.addAll(getEclasses(pkg));
			eClasses.addAll(getAllEclasses(pkg));
		}
	
		return eClasses;
	}
	
	public static List<EClass> getEclasses(final EPackage pkg) {
		return pkg.getEClassifiers().stream()
			.filter(c -> c instanceof EClass)
			.map(c -> (EClass)c)
			.collect(Collectors.toList());
	}
	
	public static EPackage getRootPackage(final EPackage pkg) {
		EPackage superPkg = pkg;
		
		while (superPkg.getESuperPackage() != null) {
			superPkg =  superPkg.getESuperPackage();
		}
		
		return superPkg;
	}
	
	public static List<String> getOptionValues(String key) {
	    List<String> values = new ArrayList<>();
	    
	    if(key!=null){
	        String [] array = key.split("\\|");
	        for (int i = 0; i < array.length; i++) {
	            String value = array[i];
	            if(value != null && !value.isEmpty()){
	                values.add(value);
	            }
	        }
	    }
	    
	    return values;
    }
}
