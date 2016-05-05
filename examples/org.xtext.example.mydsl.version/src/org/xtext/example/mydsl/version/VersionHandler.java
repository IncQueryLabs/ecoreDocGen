package org.xtext.example.mydsl.version;

public class VersionHandler {
	
	public static int getLimit() {
		return Activator.getDefault().getPreferenceStore().getInt("version");
	}

}
