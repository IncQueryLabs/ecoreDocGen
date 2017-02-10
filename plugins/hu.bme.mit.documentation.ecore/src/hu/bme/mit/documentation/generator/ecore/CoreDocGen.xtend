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
import java.util.ArrayList
import java.util.List
import java.util.Properties
import java.util.stream.Collectors
import org.eclipse.emf.codegen.ecore.genmodel.GenBase
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EGenericType
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.ETypeParameter

/**
 * @author Abel Hegedus
 * @author Adam Horvath
 */
abstract class CoreDocGen extends DocGenUtil implements IDocGenerator{
	
	public static final String GEN_MODEL_PACKAGE_NS_URI = "http://www.eclipse.org/emf/2002/GenModel";
	
	public static final String SKIP_OP = "skipOperations"
	public static final String RECURSE_SUPER = "includeRecursiveSupertypes"
	public static final String INC_SUBTYPES = "includeSubtypes"
	public static final String INC_USED_PKG = "includeUsedPackages"
	public static final String SKIP_HEADER = "skipHeaderGeneration"
	public static final String FULL_LATEX_DOC = "fullLatexDocument"
	public static final String FILTERED_TYPES = "filteredTypes"
	public static final String FILTERED_SUBTYPES = "filteredSubtypes"
	public static final String FILTERED_USED_PKG = "filteredUsedPackages"
	public static final String AUTHOR_NAME = "authorName"
	public static final String INC_GENTYPE = "includeGenericTypes"
	public static final String SHOW_MISSING_DOC = "showMissingDoc"
	
	private static String LT
	private static String GT
	
	protected EPackage pckg
	protected GenPackage genPkg
    protected StringBuilder builder
    protected List<String> filter
    protected Properties options

	override generateDocument(StringBuilder sb, EObject root, List<String> filters, Properties options) {
        this.builder = sb
        this.filter = Lists::newArrayList(filters)
        this.options = options
        
        init
		
		if (root instanceof GenModel) {
			documentGenmodel(root as GenModel)
		}
		else {
			documentAllEPackages(root as EPackage)
		}
		
		generateTail()
	}
	
	def private init(){
		LT = defineLT
		GT = defineGT
	}

    def private documentGenmodel(GenModel genmodel) {
    	var genPkg = genmodel.getGenPackages().get(0)
    	
    	genPkg.eResource.URI.processHeader
		genPkg.documentGenPackages
		
		if(optionActive(INC_USED_PKG)){
        	genmodel.usedGenPackages.forEach[
	        	if(!isFiltered(optionValue(FILTERED_USED_PKG))){
	        		documentGenPackages
	        	}
        	]
        }
    }
    
    def private void documentGenPackages(GenPackage genPkg) {
		if(!genPkg.getGenClasses().isEmpty()){
			genPkg.documentGenPackage
		}
		
		genPkg.nestedGenPackages.forEach[
			documentGenPackage
		]
    }
	
	def private documentAllEPackages(EPackage pckg){
		pckg.eResource.URI.processHeader
		pckg.documentEPackages        
	}

	def private void documentEPackages(EPackage pckg){
		if(!pckg.getEClassifiers().isEmpty()){
			pckg.documentEPackage
		}
		pckg.getESubpackages.forEach[
			documentEPackage
		]
	}
	
    def private documentEPackage(EPackage pckg){
        this.pckg = pckg
        
        pckg.documentEPackageHeader.appendToBuilder
                		
        pckg.EClassifiers.sortBy[name].forEach[
        	if(it instanceof EClass){
        		val cls = it as EClass
        		cls.documentEClassHeader
				cls.emitSuperTypes        		
				cls.emitSubTypes
        		cls.documentEClass("" + escapeLabel(cls.EPackage.nsPrefix+"."+cls.name))
        	} 
        	else if(it instanceof EDataType && it instanceof EEnum){
    			val eenum = it as EEnum
    			eenum.documentEEnumHeader.appendToBuilder
        	}
        ]
    }

	def private documentGenPackage(GenPackage genPkg) {
        this.genPkg = genPkg
        
        pckg = genPkg.getEcorePackage
        pckg.documentEPackageHeader.appendToBuilder
        
        genPkg.genClassifiers.sortBy[name].forEach[
        	if(it instanceof GenClass){
        		val gcls = it as GenClass
        		val cls = gcls.ecoreClass as EClass
        		
        		if (!isFiltered(cls, optionValue(FILTERED_TYPES))) {
					gcls.documentGenClassHeader
					cls.emitSuperTypes        		
					cls.emitSubTypes
	        		gcls.documentGenClass("" + escapeLabel(cls.EPackage.nsPrefix+"."+cls.name))
        		}
        	} 
        	else if(it instanceof GenDataType && it instanceof GenEnum){
    			val gen = it as GenEnum
    			val eenum = gen.ecoreEnum as EEnum
    			eenum.documentEEnumHeader.appendToBuilder
        	}
        ]
	}
	
    def private documentEClassHeader(EClass cls){
	    '''«cls.documentEClassifierHeader»'''.appendToBuilder
	    cls.documentEClassProperties
    }
    
    def private documentGenClassHeader(GenClass gcls){
    	val cls = gcls.ecoreClass as EClass
	    '''«gcls.documentGenClassifierHeader»'''.appendToBuilder
	    cls.documentEClassProperties
    }
    
	def private documentEClass(EClass cls, String id) {
		if(!cls.EAttributes.empty){
			emitTblHeader("Attributes")
			cls.EAttributes.sortBy[name].forEach[
				emitAttrTblRow(id, findGenModelDocumentation(derived))
			]
			emitTblTrailer(cls, "Attributes", "attr")
		}
		
		if(!cls.EReferences.empty){
			//"paragraph".documentHeader("References", cls.EPackage.nsPrefix+"."+cls.name+".ref", null).appendToBuilder
			emitTblHeader("References") 
			cls.EReferences.sortBy[name].forEach[
				emitRefTblRow(id, findGenModelDocumentation(derived))
			]
			emitTblTrailer(cls, "References", "ref")
		}
		
		if(!cls.EOperations.empty){
			emitTblHeader("Operations") 
			cls.EOperations.sortBy[name].forEach[
				emitOpTblRow(id, findGenModelDocumentation(false))
			]
			emitTblTrailer(cls, "Operations", "op")
		}
	}
	
	def private documentGenClass(GenClass gcls, String id) {
        val cls = gcls.ecoreClass as EClass
        		
		if(!cls.EAttributes.empty){
			emitTblHeader("Attributes")
			
			gcls.genFeatures.filter[ecoreFeature instanceof EAttribute].sortBy[name].forEach[
				emitAttrTblRow(ecoreFeature as EAttribute, id, findGenModelDocumentation(derived))
			]
			emitTblTrailer(cls, "Attributes", "attr")
		}
		
		if(!cls.EReferences.empty){
			emitTblHeader("References")
			gcls.genFeatures.filter[ecoreFeature instanceof EReference].sortBy[name].forEach[
				emitRefTblRow(ecoreFeature as EReference, id, findGenModelDocumentation(derived))
			]
			emitTblTrailer(cls, "References", "ref")
		}
		
		if(optionActive(SKIP_OP) && !cls.EOperations.empty){
			emitTblHeader("Operations")
			gcls.genOperations.sortBy[name].forEach[
				val eop = ecoreOperation as EOperation
				emitOpTblRow(eop, id, eop.findGenModelDocumentation(false))
			]
			emitTblTrailer(cls, "Operations", "op")
		}
	}
	
	def private emitSuperTypes(EClass cls) {        		
		if (!cls.EGenericSuperTypes.empty){
			var List<EGenericType> list = new ArrayList
			cls.getAllSuperClasses(list)
			
			if (!list.empty){
				val plural = if (list.size > 1) '''s''' else ''''''
				cls.emitSuperTypeHeader(plural)
				emitSuperTypeElements(list).appendToBuilder
				emitSuperTypeTrailer	
			}	
		}
	}
	
	def protected emitSuperTypeElements(List<EGenericType> genTypes) {
		genTypes.emitGenTypeListRef
	}
	
	def private emitSubTypes(EClass cls) {        		
		if(optionActive(INC_SUBTYPES) && !isFiltered(cls, optionValue(FILTERED_SUBTYPES))){ 
    		val subTypes = getSubTypes(pckg, cls, true)
    		if (!subTypes.empty){
    			val plural = if (subTypes.size > 1) '''s''' else ''''''
				cls.emitSubTypeHeader(plural)
				emitSubTypeElements(subTypes).appendToBuilder
				emitSubTypeTrailer	
    		}
		}
	}
	
	def protected emitSubTypeElements(List<EClass> subTypes) {
		subTypes.emitClassListRef
	}
	
    def protected documentHeader(String sectionClass, String sectionTitle, String shortTitle, String label, EModelElement element)
	    '''
	    «documentHeader(sectionClass, sectionTitle, shortTitle, label)»
	    
	    «IF element != null»
	    «element.findGenModelDocumentation»
	    «ENDIF»
	    '''

    def protected documentHeader(String sectionClass, String sectionTitle, String shortTitle, String label, GenBase element)
	    '''
	    «documentHeader(sectionClass, sectionTitle, shortTitle, label)»
	    
	    «IF element != null»
	    «element.findGenModelDocumentation»
	    «ENDIF»
	    '''

    def protected preparePossibleReference(EGenericType genType){
    	val cls = genType.EClassifier
    	if(cls==null) {
    		return genType.emitGenTypeInfo
    	}
    	val typePckg = cls.EPackage
    	val typeName = cls.name
    	if(typePckg != null && filter.findFirst[typePckg.nsURI.contains(it)] == null){
    		cls.emitBaseClassRef
    	} 
    	else {
    		'''«typeName»'''
    	}
    }
    
    def private emitClassListRef(List<EClass> classes) {
    	val str = new ArrayList<String>
		classes.sortBy[name].forEach[
			str.add(emitClassRef)
		]
		
    	str.stream().collect(Collectors.joining(", "))
    }
    
    def private String emitGenTypeListRef(List<EGenericType> genTypes) {
    	val str = new ArrayList<String>
		genTypes.sortBy[EClassifier.name].forEach[
			str.add(emitGenTypeRef)
		]
    	
    	str.stream().collect(Collectors.joining(", "))
    }
    
    def protected String emitClassRef(EClassifier cls) {
    	var typeInfo = emitBaseClassRef(cls)

		if (optionActive(INC_GENTYPE) && !cls.ETypeParameters.empty){
			typeInfo += emitTypeParamInfo(cls)
		}
		return typeInfo
    }

    def private String emitGenTypeInfo(EGenericType genType) {
    	val str = new ArrayList<String>

		if (!genType.ETypeArguments.empty) {
			genType.ETypeArguments.forEach[
				if (EClassifier != null && EClassifier instanceof EClass) {
					str.add(EClassifier.emitClassRef)
				}
				else if (EClassifier != null && EClassifier instanceof EDataType) {
					val dataType = EClassifier as EDataType
					str.add('''«dataType.name»''')
				}
				else if (ETypeParameter != null) {
					str.add(ETypeParameter.emitTypeParamRef)
				}
			]
		}
		else if (genType.ETypeParameter != null) {
			str.add(genType.ETypeParameter.emitTypeParamRef)
		}
		else {
			val sb = new StringBuilder
			sb.append('?')

			if (genType.ELowerBound != null) {
				sb.append(" super ")
				sb.append(genType.ELowerBound.emitGenTypeRef)
			}
			else if (genType.EUpperBound != null) {
				sb.append(" extends ")
				sb.append(genType.EUpperBound.emitGenTypeRef)
			}
			
			str.add('''«sb.toString»''')
		}    	
		str.stream().collect(Collectors.joining(", ", LT, GT))  					
    }

    def private emitTypeParamInfo(EClassifier cls) {
    	val str = new ArrayList<String>

		cls.ETypeParameters.forEach[
			str.add(emitTypeParamRef)
		]
		str.stream().collect(Collectors.joining(", ", LT, GT)) 					
    }
    
    def private emitGenTypeRef(EGenericType genType){
		var typeInfo = genType.EClassifier.emitBaseClassRef
		    	
		if (optionActive(INC_GENTYPE) && !genType.ETypeArguments.empty){
			typeInfo += genType.emitGenTypeInfo
		}
		return typeInfo
    }
    
    def private emitTypeParamRef(ETypeParameter typeParam) {
    	val str = new ArrayList<String>

		if (typeParam instanceof EClassifier) {
			str.add(emitClassRef(typeParam as EClassifier))
		}
		else {
			str.add('''«typeParam.name»''')
		}    	
		
		if (!typeParam.EBounds.empty){
			str.add("extends " + typeParam.EBounds.emitGenTypeListRef)
		}
		
		str.stream().collect(Collectors.joining(" "))		    					
    }
    
    def protected optionActive(String option){
    	var optVal = "" 
    	if (options != null && options.containsKey(option)) {
    		optVal = options.getProperty(option)
    	}
   		optVal.trim.equals("true")
    }
    
    def protected optionValue(String option){
    	var optVal = "" 
    	if (options != null && options.containsKey(option)) {
    		optVal = options.getProperty(option)
    	}
    	return optVal
    }
    
    def protected isFiltered(EClass cls, String key){
    	val cname = cls.name
    	getOptionValues(key).stream.anyMatch[cname.matches(key)]
    }
    
    def protected isFiltered(GenPackage pkg, String key){
    	val pname = pkg.getEcorePackage.name
    	getOptionValues(key).stream.anyMatch[pname.matches(key)]
    }
	
    def protected findAnnotation(EModelElement elem, String source, String key){
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
    
    def protected findAnnotation(GenBase elem, String source, String key){
    	val annotations = elem.genAnnotations
    	if(annotations != null && annotations.size > 0){
	    	val ann = annotations.findFirst[source == source && details.containsKey(key)]
	    	if(ann != null){
	    		val det = ann.details
	    		if(det != null){
	    			return det.get(key)
	    		}
	    	}
    	}
    }
    
    def protected findGenModelDocumentation(EModelElement element){
    	element.findGenModelDocumentation(true)
    }
    
    def protected findGenModelDocumentation(EModelElement element, boolean required){
    	var doc = findAnnotation(element, GEN_MODEL_PACKAGE_NS_URI, "documentation")
    	emitDocumentation(doc, required)
    }
    
	def protected findGenModelDocumentation(GenFeature element){
    	element.findGenModelDocumentation(true)
    }
    
    def protected findGenModelDocumentation(GenFeature element, boolean required){
    	var doc = element.propertyDescription
    	if (doc == null || doc.empty) {
    		doc = findAnnotation(element, GEN_MODEL_PACKAGE_NS_URI, "documentation")
    	}
    	
    	emitDocumentation(doc, required)
    }
    
    def protected findGenModelDocumentation(GenBase element){
    	element.findGenModelDocumentation(true)
    }
    
    def protected findGenModelDocumentation(GenBase element, boolean required){
    	findGenModelDocumentation(element, "documentation", required)
    }
    
    def protected findGenModelInternalDoc(GenBase element, boolean required){
    	findGenModelDocumentation(element, "internaldoc", required)
    }
    
    def protected findGenModelDocumentation(GenBase element, String key, boolean required){
    	val doc = findAnnotation(element, GEN_MODEL_PACKAGE_NS_URI, key)
    	emitDocumentation(doc, required)
    }
    
    def protected String ePackageFqName(EPackage pckg){
		var current = pckg
		var List<String> list = new ArrayList
		var ret = new StringBuilder
		while(current!=null){
			list.add(0,current.name)
			current = current.eContainer as EPackage
		}
		var i = 0
		val len = list.size
		for(String pElement:list){
			ret.append(pElement)
			if(i < len - 1 ){
				ret.append(".")
			}
			i = i + 1
		}
		ret.toString()
	}
	    
	def protected void getAllSuperClasses(EClass cls, List<EGenericType> list) {
		for (EGenericType superCls : cls.EGenericSuperTypes) {
			if (!superCls.eIsProxy && !contains(list, superCls)) {
				list.add(superCls)
				if (optionActive(RECURSE_SUPER)) {
					getAllSuperClasses(superCls.EClassifier as EClass, list)
				}
			}
		}
	}
	
	//needed since generic type instances are all different
	def private contains(List<EGenericType> list, EGenericType type) {
		list.stream().anyMatch[EClassifier.equals(type.EClassifier)]
	}
    
    def protected appendToBuilder(CharSequence s){
    	builder.append(s)
    }
    
    def String defineLT()
    def String defineGT()

	def CharSequence documentEPackageHeader(EPackage pckg)
	def CharSequence documentEClassProperties(EClass cls)
    def CharSequence documentEClassifierHeader(EClassifier cls)
    def CharSequence documentGenClassifierHeader(GenClass gcls)
	def CharSequence documentEEnumHeader(EEnum eenum)	
	
	def String emitBaseClassRef(EClassifier cls)
	def void emitTblHeader(String title)
	def void emitAttrTblRow(EAttribute attr, String id, String doc)
	def void emitRefTblRow(EReference ref, String id, String doc)
	def void emitOpTblRow(EOperation op, String id, String doc)
	def void emitTblTrailer(EClass cls, String title, String type)
	def void emitSuperTypeHeader(EClass cls, String plural)
	def void emitSuperTypeTrailer()
	def void emitSubTypeHeader(EClass cls, String plural)
	def void emitSubTypeTrailer()
	def CharSequence documentHeader(String sectionClass, String sectionTitle, String shortTitle, String label)	
	
	def CharSequence escapeText(String text)
    def CharSequence escapeLabel(String text)
	def String emitDocumentation(String doc, boolean required)
	     
	def void generateTail()
		
	def void processHeader(URI pkgURI) 	
}
