package org.xtext.example.mydsl.version;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class VersionPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Version max limit for xtext instance classes.");
	}

	@Override
	protected void createFieldEditors() {
		addField(new StringFieldEditor("version", "Version limit:",getFieldEditorParent()));
	}

}
