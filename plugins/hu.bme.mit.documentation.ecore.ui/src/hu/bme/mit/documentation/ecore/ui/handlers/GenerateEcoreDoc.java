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

import hu.bme.mit.documentation.generator.ecore.EPackageDocGen;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author Abel Hegedus
 * 
 */
public class GenerateEcoreDoc extends AbstractHandler {

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
                        String texFileName = ecoreFileName+".tex";
                        String filterFileName = ecoreFileName+".docgen";
                        IFile outFile = null;
                        IFile filterFile = null;
                        
                        IContainer parent = file.getParent();
                        if(parent instanceof IProject){
                            IProject project = (IProject) parent;
                            outFile = project.getFile(texFileName);
                            filterFile = project.getFile(filterFileName);
                        } else if(parent instanceof IFolder) {
                            IFolder folder = (IFolder) parent;
                            outFile = folder.getFile(texFileName);
                            filterFile = folder.getFile(filterFileName);
                        }
                        generateDocForEPackage(ecoreURI, outFile, filterFile);
                       
                    }
                }
            }
        }

        return null;
    }
    
    private void generateDocForEPackage(URI ecorePath, IFile outputFile, IFile filterFile) {
        EPackageDocGen docGen = new EPackageDocGen();
        ResourceSet rs = new ResourceSetImpl();
        Resource resource = rs.getResource(ecorePath, true);

        if (resource.getContents() != null) {
            if (resource.getContents().size() > 0) {
                StringBuilder sb = new StringBuilder();

                try {
                    ArrayList<String> filter = new ArrayList<String>();
                    if(filterFile.exists()){
                        // Reading the configuration file
                        PropertyResourceBundle bundle = null;
                        InputStream fis = filterFile.getContents();
                        bundle = new PropertyResourceBundle(fis);
                        fis.close();
                        
                        // Additional filters
                        String [] filterArray = bundle.getString("filters").split("\\|");
                        for (int i = 0; i < filterArray.length; i++) {
                            String filterEntry = filterArray[i];
                            if(filterEntry != null && !filterEntry.isEmpty()){
                                filter.add(filterEntry);
                            }
                        }
                    }
                    EPackage pckg = (EPackage) resource.getContents().get(0);
                    docGen.documentEPackageToLatex(sb, pckg, filter,true);
                    doGenerateAllSubpackages(docGen,sb,pckg,filter);
                    
                    
                    InputStream source = new ByteArrayInputStream(sb.toString().getBytes());
                    if (outputFile.exists()) {
                        outputFile.setContents(source, IFile.FORCE, new NullProgressMonitor());
                    } else {
                        outputFile.create(source, true, new NullProgressMonitor());
                    }
                    outputFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
                } catch (CoreException e) {
                    Logger.getLogger(GenerateEcoreDoc.class).error("Exception occurred when generating ecore doc",e);
                } catch (IOException e) {
                    Logger.getLogger(GenerateEcoreDoc.class).error("Exception occurred when generating ecore doc",e);
                }
            }
        }
    }

	private void doGenerateAllSubpackages(EPackageDocGen docGen, StringBuilder sb, EPackage pckg,
			ArrayList<String> filter) {
		for (EPackage subpck : pckg.getESubpackages()) {
			if(!subpck.getEClassifiers().isEmpty()){
				docGen.documentEPackageToLatex(sb, subpck, filter,false);
			}
		}
		for (EPackage subpck : pckg.getESubpackages()) {
			doGenerateAllSubpackages(docGen, sb, subpck, filter);
		}
		
	}
}
