/*******************************************************************************
 * Copyright (c) 2010-2013, Abel Hegedus, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Abel Hegedus - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.documentation.ecore.ui.handlers;

import hu.bme.mit.documentation.generator.ecore.IDocGenerator;
import hu.bme.mit.documentation.generator.ecore.UtilDocGenerator;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author Abel Hegedus, Adam Horvath
 * 
 */
public abstract class AbstractGenerateEcoreDoc extends AbstractHandler {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands. ExecutionEvent)
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection selection = HandlerUtil.getCurrentSelection(event);

        if (selection instanceof IStructuredSelection) {

            for (Object element : ((IStructuredSelection) selection).toList()) {
                if (element instanceof IFile) {
                    IFile file = (IFile) element;
                    if(file.getFileExtension().equals("ecore")){
                        URI ecoreURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
                        
                        String ecoreFileName = file.getName().substring(0,file.getName().indexOf("."));
                        String htmlFileName = ecoreFileName+".html";
                        String filterFileName = ecoreFileName+".docgen";
                        IFile outFile = null;
                        IFile filterFile = null;
                        
                        IContainer parent = file.getParent();
                        if(parent instanceof IProject){
                            IProject project = (IProject) parent;
                            outFile = project.getFile(htmlFileName);
                            filterFile = project.getFile(filterFileName);
                        } else if(parent instanceof IFolder) {
                            IFolder folder = (IFolder) parent;
                            outFile = folder.getFile(htmlFileName);
                            filterFile = folder.getFile(filterFileName);
                        }
                        IDocGenerator docGen = getCodeGenerator();
                        UtilDocGenerator.generateDocForEPackage(ecoreURI, 
                        		new File(outFile.getLocationURI()), 
                        		new File(filterFile.getLocationURI()),
                        		docGen);
                       
                    }
                }
            }
        }

        return null;
    }
    
    /**
	 * Should be overridden by subclasses to allow documentation generation in
	 * specific formats.
	 * 
	 * @return
	 */
	protected abstract IDocGenerator getCodeGenerator();

}
