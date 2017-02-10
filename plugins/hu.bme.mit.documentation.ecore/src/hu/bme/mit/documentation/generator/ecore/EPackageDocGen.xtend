/* Copyright (c) 2010-2012, Abel Hegedus, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Abel Hegedus - initial API and implementation
 * 	 Adam Horvath - Markdown support, escaping fixes
 *
 *******************************************************************************/
 package hu.bme.mit.documentation.generator.ecore

import java.io.Reader
import java.io.StringReader
import java.util.GregorianCalendar
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.tautua.markdownpapers.ast.Document
import org.tautua.markdownpapers.parser.Parser
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import java.util.List
import org.eclipse.emf.ecore.EGenericType

/**
 * @author Abel Hegedus
 * @author Adam Horvath
 */
class EPackageDocGen extends CoreDocGen implements IDocGenerator {
    private boolean floatTables = false  //is never changed, left there anyway.
    
	override defineLT() {
		'''<'''
	}
	
	override defineGT() {
		'''>'''
	}

	override emitSuperTypeHeader(EClass cls, String plural) {
		'''
		«IF cls.interface || cls.^abstract»
		\\
		«ENDIF»
		\textbf{Supertype«plural»: }'''.appendToBuilder    	
	}
	
	override emitSuperTypeElements(List<EGenericType> genTypes) {
	    '''
        \texttt{«super.emitSuperTypeElements(genTypes)»}
	    '''				
	}
	
	override emitSuperTypeTrailer() {
		''''''.appendToBuilder	
	}
	
	override emitSubTypeHeader(EClass cls, String plural) {
		'''
		«IF !cls.EGenericSuperTypes.empty»
		\\
		«ENDIF»
		\textbf{Subtype«plural»: }'''.appendToBuilder    	
	}
	
	override emitSubTypeElements(List<EClass> subTypes) {
	    '''
        \texttt{«super.emitSubTypeElements(subTypes)»}
	    '''				
	}
	
	override emitSubTypeTrailer() {
		''''''.appendToBuilder	
	}
		
	override emitTblHeader(String title) {
		'''
		\begin{table}[«getTableFloat»]
		\footnotesize
		\begin{tabularx}{\textwidth}{|c| p{4 cm} | X |}
		\hline
		\multicolumn{3}{|c|}{\textbf{«title»}} \\
		\hline
		Name & Properties & Documentation \\ \hline \hline
		'''.appendToBuilder
	}
	
	override emitTblTrailer(EClass cls, String title, String type) {
		'''
		\caption{«title» of the «escapeText(cls.name)» EClass}
		\end{tabularx}
		\label{«escapeLabel(cls.EPackage.nsPrefix+"."+cls.name+"." + type)»}
		\end{table}
		'''.appendToBuilder
	}

	override emitAttrTblRow(EAttribute attr, String id, String doc) {
		attr.documentEAttributeHeader(id).appendToBuilder
		''' & '''.appendToBuilder
		doc.appendToBuilder
		'''\\ \hline
		'''.appendToBuilder
	}
	
	override emitRefTblRow(EReference ref, String id, String doc) {
		ref.documentEReferenceHeader(id).appendToBuilder
		''' & '''.appendToBuilder
		doc.appendToBuilder
		'''\\ \hline
		'''.appendToBuilder
	}
		
	override emitOpTblRow(EOperation op, String id, String doc) {
		op.documentEOperationHeader(id).appendToBuilder
		''' & '''.appendToBuilder
		doc.appendToBuilder
		'''\\ \hline
		'''.appendToBuilder
	}

	//empty line in here is important!!	
    override documentEPackageHeader(EPackage pckg)
    	'''
    	«val packageName = ePackageFqName(pckg)»
		«val title = "The \\textsc{" + pckg.name + "} metamodel"»
		«documentHeader("section", title, packageName, pckg.nsPrefix, pckg)»
		\paragraph{EPackage properties:} \hspace{0pt} \\ \indent
		«documentProperty("Namespace Prefix", '''«escapeText(pckg.nsPrefix)»''')»
		
		«documentProperty("Namespace URI", '''«pckg.nsURI»''')»
        '''

    override documentEClassifierHeader(EClassifier cls)
	    '''
	    «documentHeader("subsection", emitClassRef(cls), cls.name, cls.EPackage.nsPrefix+"."+cls.name, cls)»
	    '''
    
	override documentGenClassifierHeader(GenClass gcls) {
	    '''
	    «documentHeader("subsection", emitClassRef(gcls.ecoreClass), gcls.name, gcls.ecoreClass.EPackage.nsPrefix+"."+gcls.name, gcls)»
	    '''
	}

    def private documentEDataTypeHeader(EDataType dt)
	    '''
	    «dt.documentEClassifierHeader»
	    '''
    
    override documentEEnumHeader(EEnum eenum)
	    '''
		«eenum.documentEDataTypeHeader»
		\begin{table}[«getTableFloat»]
		\footnotesize
		\begin{tabularx}{\textwidth}{| c | c | X |}
		\hline
		\multicolumn{3}{|c|}{\textbf{Literals}} \\
		\hline
		Name & Value & Documentation \\ \hline \hline
		«FOR literal : eenum.ELiterals»
		\texttt{«escapeText(literal.literal)»} & «literal.value» &
		«literal.findGenModelDocumentation(false)» \\ \hline
	    «ENDFOR»
		\caption{Literals of the «escapeText(eenum.name)» EEnum}
		\end{tabularx}
		\label{«escapeLabel(eenum.EPackage.nsPrefix+"."+eenum.name+".lit")»}
		\end{table}
	    '''
    
	override documentEClassProperties(EClass cls) {
		'''
	    «IF cls.interface»
	      \paragraph{EClass properties:} \hspace{0pt} \\ \indent
	      \textbf{Interface}
	    «ENDIF»
	    «IF cls.^abstract»
	      «IF cls.interface»
	      , 
	      «ELSE»
	      \paragraph{EClass properties:} \hspace{0pt} \\ \indent
	      «ENDIF»
	      \textbf{Abstract}
	    «ENDIF»
	    '''.appendToBuilder		
	}
	
    def private documentENamedElement(ENamedElement elem, String parentId, String color)
	    '''
	    \texttt{«IF color != null»\color{«color»}{«ENDIF»«escapeText(elem.name)»«IF color != null»}«ENDIF»}
	    '''
    
    //(«typePckg.nsURI»)
    // <«typePckg.name»>
    def private documentETypedElement(ETypedElement elem, String parentId, String color)
	    '''
	    «elem.documentENamedElement(parentId, color)» & 
	    «documentProperty("T", elem.preparePossibleReference)»
	    \newline
	    \textbf{Cardinality:} [«elem.lowerBound»..«IF elem.upperBound == -1»*«ELSE»«elem.upperBound»«ENDIF»]
	    «IF !elem.ordered»
	    \newline
	    \textbf{Unordered}
	    «ENDIF»
	    «IF !elem.unique»
	    \newline
	    \textbf{Not unique}
	    «ENDIF»'''
    
    def private preparePossibleReference(ETypedElement elem){
    	if(elem.EGenericType != null){
	    	elem.EGenericType.preparePossibleReference
    	} else {
    		'''\textsc{\color{red}{MISSING TYPE!}}'''
    	}
    }
    
    def private documentEStructuralFeatureHeader(EStructuralFeature feat, String parentId)
	    '''
	    «IF feat.derived»
		    «feat.documentETypedElement(parentId, "blue")»
	    «ELSE»
	    	«feat.documentETypedElement(parentId, null)»
	    «ENDIF»
	    «IF !feat.changeable»
	    \newline
	    \textbf{Non-changeable}
	    «ENDIF»
	    «IF feat.volatile»
	    \newline
	    \textbf{Volatile}
	    «ENDIF»
	    «IF feat.transient»
	    \newline
	    \textbf{Transient}
	    «ENDIF»
	    «IF feat.unsettable»
	    \newline
	    \textbf{Unsettable}
	    «ENDIF»
	    «IF feat.defaultValueLiteral != null»
	    \newline
	    «documentProperty("Default", escapeText(feat.defaultValueLiteral))»
	    «ENDIF»
	    «IF feat.derived»
	    «val fqn = findAnnotation(feat, "org.eclipse.viatra2.emf.incquery.derived.feature", "patternFQN")»
	    \newline
	    \textbf{Derived}
	    «IF fqn != null»
	    %\newline
	    %(Query: «fqn.replace("hu.bme.mit.transima.models.","").replace(".",".\\allowbreak ")»)
	    «ELSE»
	    \newline
	    \textsc{\color{red}{MISSING DEFINITION!}}
	    «ENDIF»
	    «ENDIF»
	    '''
    
    def private documentEAttributeHeader(EAttribute attr, String parentId)
	    '''
	    «attr.documentEStructuralFeatureHeader(parentId)»
	    «IF attr.ID»
	    \newline
	    \textbf{Identifier}
	    «ENDIF»
	    '''
    
    def private documentEReferenceHeader(EReference ref, String parentId)
	    '''
	    «ref.documentEStructuralFeatureHeader(parentId)»
	    «IF ref.containment»
	    \newline
	    \textbf{Containment}
	    «ENDIF»
	    «IF ref.container»
	    \newline
	    \textbf{Container}
	    «ENDIF»
	    «IF ref.EOpposite != null»
	    \newline
	    «documentProperty("Op", ref.EOpposite.name)»
	    «ENDIF»
	    '''
	    //ref.EOpposite.EContainingClass.preparePossibleReference+".\\allowbreak "+
    
    def private documentEOperationHeader(EOperation op, String parentId)
	    '''
	    «op.documentETypedElement(parentId, null)»
	    «IF op.EType != null»
	    %\newline
	    %\textbf{Returns:}
	    %«op.preparePossibleReference»[«op.lowerBound»..«IF op.upperBound == ETypedElement::UNBOUNDED_MULTIPLICITY»*«ELSE»«op.upperBound»«ENDIF»]
	    «ENDIF»
	    «IF !op.EParameters.empty»
	    \newline
	    \textbf{Parameters:}
	    \begin{itemize}
	    «FOR param : op.EParameters»
	    	\item «param.preparePossibleReference»[«param.lowerBound»..«IF param.upperBound == ETypedElement::UNBOUNDED_MULTIPLICITY»*«ELSE»«param.upperBound»«ENDIF»] \texttt{«escapeText(param.name)»}
	    «ENDFOR»
	    \end{itemize}
	    «ENDIF»
	    '''

    def private documentProperty(CharSequence key, CharSequence value)
	    '''
	    \textbf{«key»:} \texttt{«value»}
	    '''
    
    override documentHeader(String sectionClass, String sectionTitle, String shortTitle, String label)
	    '''
	    \«sectionClass»[«escapeText(shortTitle)»]{«escapeText(sectionTitle)»}
	    \label{«escapeLabel(label)»}
	    '''    
    
    override escapeText(String text){
    	'''«text.replaceAll("_","\\\\_").replaceAll("%","\\\\%")»'''
    }
    
    override escapeLabel(String text){
    	'''«text.replaceAll("_","").replaceAll("\\.","")»'''
    }

	override emitDocumentation(String doc, boolean required){    
    	if(doc!=null){
    		val Reader docReader = new StringReader(doc)
    		val Parser parser = new Parser(docReader)
    	
    		val Document markdownDoc = parser.parse()
    		val latexVisitor = new MarkdownToLatexVisitor()
    		markdownDoc.accept(latexVisitor)
    		return latexVisitor.latexString
    	}
    	else {
    		if(optionActive(SHOW_MISSING_DOC) && required){
    			return '''\textsc{\color{red}{Missing Documentation!}}'''
    		} else {
		    	return ''''''
    		}
    	}
    }
    
	override emitBaseClassRef(EClassifier cls) {
    	'''«escapeLabel(cls.name)»'''
//    	'''\nameref{«escapeLabel(cls.EPackage.nsPrefix+ "." + cls.name)»}'''
	}
	
	override processHeader(URI pkgURI) {
        val gc = new GregorianCalendar()
        val now = gc.getTime().toString()
		
        "% This file was created using the TeX documentation generator.\n".appendToBuilder
        val create = "% Creation date: " + now + "\n"
        create.appendToBuilder

        '''
       	«IF optionActive(FULL_LATEX_DOC)»
\documentclass{article}
\usepackage[hypertex]{hyperref}
\usepackage{url}
\usepackage{times}
\usepackage{ltablex}
\usepackage{float}
\usepackage{courier}
\usepackage{color}
\usepackage{lmodern}

\title{Metamodel Documentation («pkgURI»)}
\date{«now»}
\author{«optionValue(AUTHOR_NAME)»}

\begin{document}
        «ENDIF»
        '''.appendToBuilder
	}
	
	override generateTail() {
		'''
	    «IF optionActive(FULL_LATEX_DOC)»
	    \end{document}
	    «ENDIF»
	    '''.appendToBuilder
	}
	
	def getTableFloat() { 
		if(floatTables){
			'''!ht'''
		}else{
			'''H'''
		}
	}
}
