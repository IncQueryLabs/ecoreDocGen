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

import com.google.common.collect.Lists
import java.io.Reader
import java.io.StringReader
import java.util.ArrayList
import java.util.GregorianCalendar
import java.util.List
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.tautua.markdownpapers.ast.Document
import org.tautua.markdownpapers.parser.Parser

/**
 * @author Abel Hegedus
 * @author Adam Horvath
 */
class EPackageDocGen implements IDocGenerator{
	private EPackage pckg
    private StringBuilder builder
    private List<String> filter
    private boolean floatTables
    
    override documentEPackage(StringBuilder sb, EPackage pckg, List<String> nameRefFilter, boolean genHeader){
    	this.floatTables = false;
        this.builder = sb
        this.pckg = pckg
        this.filter = Lists::newArrayList(nameRefFilter)
        
        val gc = new GregorianCalendar()
        val now = gc.getTime().toString()
        if(genHeader){
	        "% This file was created using the TeX documentation generator.\n".appendToBuilder
	        
	        val create = "% Creation date: " + now + "\n"
	        create.appendToBuilder
        }
        
        pckg.documentEPackageHeader.appendToBuilder
        
        //pckg.EClassifiers.sortBy[if(it instanceof EClass){(it as EClass).ESuperTypes.size} else {0}].forEach[
        pckg.EClassifiers.sortBy[name].forEach[


        	if(it instanceof EClass){
	        		
        		val cls = it as EClass

        		cls.documentEClassHeader.appendToBuilder
        		if(!cls.EAttributes.empty){
	        		//"textbf".documentHeader("Attributes", cls.EPackage.nsPrefix+"."+cls.name+".attr", null).appendToBuilder
	        		'''
					\begin{table}[«getTableFloat»]
					\footnotesize
					\begin{tabularx}{\textwidth}{|c| p{4 cm} | X |}
					\hline
					\multicolumn{3}{|c|}{\textbf{Attributes}} \\
					\hline
					Name & Properties & Documentation \\ \hline \hline
	        		'''.appendToBuilder
	        		cls.EAttributes.sortBy[name].forEach[
	        			documentEAttributeHeader.appendToBuilder
	        			''' & '''.appendToBuilder
	        			findGenModelDocumentation(derived).appendToBuilder
	        			'''\\ \hline
	        			'''.appendToBuilder
	        		]
	        		'''
					\end{tabularx}
					\caption{Attributes of the «escapeText(cls.name)» EClass}
					\label{«escapeLabel(cls.EPackage.nsPrefix+"."+cls.name+".attr")»}
					\end{table}
	        		'''.appendToBuilder
	        		
        		}
        		
        		
        		if(!cls.EReferences.empty){
	        		//"paragraph".documentHeader("References", cls.EPackage.nsPrefix+"."+cls.name+".ref", null).appendToBuilder
	        		'''
					\begin{table}[«getTableFloat»]
					\footnotesize
					\begin{tabularx}{\textwidth}{|c| p{4 cm} | X |}
					\hline
					\multicolumn{3}{|c|}{\textbf{References}} \\
					\hline
					Name & Properties & Documentation \\ \hline \hline
	        		'''.appendToBuilder
	        		cls.EReferences.sortBy[name].forEach[
	        			documentEReferenceHeader.appendToBuilder
	        			''' & '''.appendToBuilder
	        			findGenModelDocumentation(derived).appendToBuilder
	        			'''\\ \hline
	        			'''.appendToBuilder
	        		]
	        		'''
					\end{tabularx}
					\caption{References of the «escapeText(cls.name)» EClass}
					\label{«escapeLabel(cls.EPackage.nsPrefix+"."+cls.name+".ref")»}
					\end{table}
	        		'''.appendToBuilder
	        		
        		}
        		
        		if(!cls.EOperations.empty){
		        	//"paragraph".documentHeader("Operations", cls.EPackage.nsPrefix+"."+cls.name+".op", null).appendToBuilder
	        		'''
					\begin{table}[«getTableFloat»]
					\small
					\begin{tabularx}{\textwidth}{|c| p{4 cm} | X |}
					\hline
					\multicolumn{3}{|c|}{\textbf{Operations}} \\
					\hline
					Name & Properties & Documentation \\ \hline \hline
	        		'''.appendToBuilder
	        		cls.EOperations.sortBy[name].forEach[
	        			documentEOperationHeader.appendToBuilder
	        			''' & '''.appendToBuilder
	        			findGenModelDocumentation(false).appendToBuilder
	        			'''\\ \hline
	        			'''.appendToBuilder
	        		]
	        		'''
	        		\end{tabularx}
	        		\caption{Operations of the «escapeText(cls.name)» EClass}
	        		\label{«escapeLabel(cls.EPackage.nsPrefix+"."+cls.name+".op")»}
	        		\end{table}
	        		'''.appendToBuilder
	        		
        		}
        		
        		//if(cls.EOperations.size + cls.EStructuralFeatures.size > 2){
	       		//	'''\clearpage'''.appendToBuilder
	       		//}
        		
        	} else if(it instanceof EDataType){
        		if(it instanceof EEnum){
        			val eenum = it as EEnum
        			eenum.documentEEnumHeader.appendToBuilder
        		}
        	}
        	
        ]
        
    }
	def getTableFloat() { 
		if(floatTables){
			'''!ht'''
		}else{
			'''H'''
		}
	}

    
    def private appendToBuilder(CharSequence s){
    	builder.append(s)
    }
    
    def private documentEPackageHeader(EPackage pckg)
    	'''
    	«val packageName = ePackageFqName(pckg)»
		«val title = "The \\textsc{" + pckg.name + "} metamodel"»
		«documentHeader("section", title, packageName, pckg.nsPrefix, pckg)»
		\paragraph{EPackage properties:} \hspace{0pt} \\ \indent
		«documentProperty("Namespace Prefix", '''«escapeText(pckg.nsPrefix)»''')»
		
		«documentProperty("Namespace URI", '''«pckg.nsURI»''')»
		
        '''

    def private String ePackageFqName(EPackage pckg)
	{
		var current = pckg;
		var List<String> list = new ArrayList;
		var ret = new StringBuilder;
		while(current!=null){
			list.add(0,current.name);
			current = current.eContainer as EPackage;
		}
		var i = 0;
		val len = list.size;
		for(String pElement:list){
			ret.append(pElement);
			if(i < len - 1 ){
				ret.append(".");
			}
			i = i + 1;
		}
		ret.toString();
	}    
    def private documentEClassifierHeader(EClassifier cls)
    '''
    «documentHeader("subsection", cls.name, cls.name, cls.EPackage.nsPrefix+"."+cls.name, cls)»
    '''
    
    def private documentEDataTypeHeader(EDataType dt)
    '''
    «dt.documentEClassifierHeader»
    '''
    
    def private documentEEnumHeader(EEnum eenum)
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
	\end{tabularx}
	\caption{Literals of the «escapeText(eenum.name)» EEnum}
	\label{«escapeLabel(eenum.EPackage.nsPrefix+"."+eenum.name+".lit")»}
	\end{table}
    '''
    
    def private documentEClassHeader(EClass cls)
    '''
    «cls.documentEClassifierHeader»
     
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
    «IF !cls.ESuperTypes.empty»
      «IF cls.interface || cls.^abstract»
      \\ \indent
      «ELSE»
      \paragraph{EClass properties:} \hspace{0pt} \\ \indent
      «ENDIF»
      \textbf{Supertypes: }
      «FOR st : cls.ESuperTypes SEPARATOR ", "»
        \texttt{«st.preparePossibleReference»}
      «ENDFOR»
    «ENDIF»
    '''
    
    def private documentENamedElement(ENamedElement elem, String color)
    '''
    \texttt{«IF color != null»\color{«color»}{«ENDIF»«escapeText(elem.name)»«IF color != null»}«ENDIF»}
    '''
    
    //(«typePckg.nsURI»)
    // <«typePckg.name»>
    def private documentETypedElement(ETypedElement elem, String color)
    '''
    «elem.documentENamedElement(color)» & 
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
	    	elem.EGenericType.EClassifier.preparePossibleReference
    	} else {
    		'''\textsc{\color{red}{MISSING TYPE!}}'''
    	}
    }
    
    def private preparePossibleReference(EClassifier cls){
    	val typePckg = cls.EPackage
    	val typeName = cls.name
    	
    	if(filter.findFirst[typePckg.nsURI.contains(it)] != null){
    		'''\nameref{«escapeLabel(typePckg.nsPrefix+ "." + typeName)»}'''
    	} else {
    		'''«typeName»'''
    	}
    }
    
    def private documentEStructuralFeatureHeader(EStructuralFeature feat)
    '''
    «IF feat.derived»
	    «feat.documentETypedElement("blue")»
    «ELSE»
    	«feat.documentETypedElement(null)»
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
    
    def private documentEAttributeHeader(EAttribute attr)
    '''
    «attr.documentEStructuralFeatureHeader»
    «IF attr.ID»
    \newline
    \textbf{Identifier}
    «ENDIF»
    '''
    
    def private documentEReferenceHeader(EReference ref)
    '''
    «ref.documentEStructuralFeatureHeader»
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
    
    def private documentEOperationHeader(EOperation op)
    '''
    «op.documentETypedElement(null)»
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
    
    def private documentHeader(String sectionClass, String sectionTitle, String shortTitle, String label, EModelElement element)
    '''
    \«sectionClass»[«escapeText(shortTitle)»]{«escapeText(sectionTitle)»}
    \label{«escapeLabel(label)»}
    
    «IF element != null»
    «element.findGenModelDocumentation»
    «ENDIF»
    '''
    
    def private escapeText(String text){
    	'''«text.replaceAll("_","\\\\_").replaceAll("%","\\\\%")»'''
    }
    
    def private escapeLabel(String text){
    	'''«text.replaceAll("_","").replaceAll("\\.","")»'''
    }
    
    def private findGenModelDocumentation(EModelElement element){
    	element.findGenModelDocumentation(true)
    }
    
    def private findGenModelDocumentation(EModelElement element, boolean required){
    	val doc = findAnnotation(element, "http://www.eclipse.org/emf/2002/GenModel", "documentation")
    	if(doc!=null){
    		val Reader docReader = new StringReader(doc);
    		val Parser parser = new Parser(docReader);
    	
    		val Document markdownDoc = parser.parse();
    		val latexVisitor = new MarkdownToLatexVisitor();
    		markdownDoc.accept(latexVisitor);
    		return latexVisitor.latexString;
    	}
    	else {
    		if(required){
    			return '''\textsc{\color{red}{Missing Documentation!}}'''
    		} else {
		    	return ''''''
    		}
    	}
    }
    
    def private findAnnotation(EModelElement elem, String source, String key){
    	val annotations = elem.EAnnotations
    	if(annotations != null){
	    	val ann = annotations.findFirst[it.source == source]
	    	if(ann != null){
	    		val det = ann.details
	    		if(det != null){
	    			return det.get(key)
	    		}
	    	}
    	}
    }
    
	override generateTail() {
		//not required for latex documents
	}
	
}
