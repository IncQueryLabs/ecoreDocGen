package hu.qgears.documentation;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EValidator.Registry;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	
	private EValidator oldRegister;
	
	// The shared instance
	private static Activator plugin;
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		registerCustomValidatorForEcorePackage();
		plugin = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		removeCustomValidatorForEcorePackage();
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	private void registerCustomValidatorForEcorePackage() {
		try {
			Registry reg = EValidator.Registry.INSTANCE;
			oldRegister = reg.getEValidator(EcorePackage.eINSTANCE);
			reg.put(EcorePackage.eINSTANCE, new EValidator.Descriptor() {
				public EValidator getEValidator() {
					return EcoreDocumentationValidator.INSTANCE;
				}
			});
		} catch (Exception e){
			e.printStackTrace();
		} 
	}
	
	private void removeCustomValidatorForEcorePackage() {
		try {
			Registry reg = EValidator.Registry.INSTANCE;
			reg.put(EcorePackage.eINSTANCE, oldRegister);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
}