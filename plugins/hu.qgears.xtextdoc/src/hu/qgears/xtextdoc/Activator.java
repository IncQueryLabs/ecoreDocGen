package hu.qgears.xtextdoc;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EValidator.Registry;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import hu.qgears.xtextdoc.validator.EcoreDocumentationValidator;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "hu.qgears.xtextdoc"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private EValidator oldRegister;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		registerCustomValidatorForEcorePackage();
		plugin = this;
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

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		removeCustomValidatorForEcorePackage();
		plugin = null;
		super.stop(context);
	}

	private void removeCustomValidatorForEcorePackage() {
		try {
			Registry reg = EValidator.Registry.INSTANCE;
			reg.put(EcorePackage.eINSTANCE, oldRegister);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
