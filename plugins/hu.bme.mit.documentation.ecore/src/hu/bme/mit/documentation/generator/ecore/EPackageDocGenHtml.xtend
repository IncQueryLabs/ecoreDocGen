/* Copyright (c) 2010-2012, Abel Hegedus, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Abel Hegedus - initial structure
 *   Adam Horvath - HTML specifics
 *
 *******************************************************************************/
 package hu.bme.mit.documentation.generator.ecore

import java.io.Reader
import java.io.StringReader
import java.util.ArrayList
import java.util.GregorianCalendar
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
import hu.qgears.documentation.DocumentationFieldUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import java.util.stream.Collectors

/**
 * @author Abel Hegedus
 * @author Adam Horvath
 * 
 */
class EPackageDocGenHtml extends CoreDocGen implements IDocGenerator{
//        		if (!cls.ESuperTypes.empty){
//        			var List<EClass> list = new ArrayList;
//        			getAllSuperClassesRecursively(cls, list);
//        			list.sortBy[name].forEach[
//						val superCls = it as EClass
//	    				val id = escapeLabel(cls.EPackage.nsPrefix+"."+cls.name) + "."  + escapeLabel(superCls.EPackage.nsPrefix+"."+superCls.name);
//	    				'''<h6>'''.appendToBuilder    	
//	    				'''<b>Supertype:</b> <a href="#«escapeLabel(superCls.EPackage.nsPrefix+"."+superCls.name)»">«superCls.name»</a>'''.appendToBuilder    	
//    					''' <a id="«id».toggleButton" href="javascript:toggle('«id»', '«id».toggleButton');">[show]</a>'''.appendToBuilder
//	    				'''<div id="«id»" style="display: none" href="javascript:toggle();">'''.appendToBuilder				
//	    				'''«superCls.findGenModelDocumentation»'''.appendToBuilder
//	    				
//	    				if (!superCls.EAttributes.empty
//	    					|| !superCls.EReferences.empty
//    						|| !superCls.EOperations.empty
//	    				) {
//		    				superCls.documentEClass(id)      		
//	    				}
//	    				
//	    				'''</div>'''.appendToBuilder	
//	    				'''</h6>'''.appendToBuilder	
//					]	        		
//        		}

	override defineLT() {
		'''&lt;'''
	}
	
	override defineGT() {
		'''&gt;'''
	}

	override emitSuperTypeHeader(EClass cls, String plural) {
		'''<h4><b>Supertype«plural»:</b>'''.appendToBuilder    	
	}
	
	override emitSuperTypeTrailer() {
		'''</h4>'''.appendToBuilder	
	}
		
	override emitSubTypeHeader(EClass cls, String plural) {
		'''<h4><b>Subtype«plural»:</b>'''.appendToBuilder    	
	}
	
	override emitSubTypeTrailer() {
		'''</h4>'''.appendToBuilder	
	}
		
	override emitTblHeader(String title) {
		'''
		<table>
		<tr>
			<th colspan="3"><div class="tableHeader">«title»</div></th>
		</tr>
		<tr>
			<th><div class="columnHeader">Name</div></th>
			<th><div class="columnHeader">Properties</div></th>
			<th><div class="columnHeader">Documentation</div></th>
		</tr>
		'''.appendToBuilder
	}
	
	override emitTblTrailer(EClass cls, String title, String type) {
		'''
		</table>
		«anchorDef(cls.EPackage.nsPrefix+"."+cls.name+"." + type,"")»
		'''.appendToBuilder
	}
	
	override emitAttrTblRow(EAttribute attr, String id, String doc) {
		'''<tr>'''.appendToBuilder
		attr.documentEAttributeHeader(id).appendToBuilder
		''' </td> '''.appendToBuilder
		'''<td>'''.appendToBuilder
		doc.appendToBuilder
		'''</td>
		</tr>'''.appendToBuilder
	}
	
	override emitRefTblRow(EReference ref, String id, String doc) {
		'''<tr>'''.appendToBuilder
		ref.documentEReferenceHeader(id).appendToBuilder
		'''
		</td> 
		<td> '''.appendToBuilder
		doc.appendToBuilder
		'''</td>
		</tr>'''.appendToBuilder
	}
		
	override emitOpTblRow(EOperation op, String id, String doc) {
		'''<tr>'''.appendToBuilder
		op.documentEOperationHeader(id).appendToBuilder
		''' </td><td> '''.appendToBuilder
		doc.appendToBuilder
		'''</td>
		</tr>'''.appendToBuilder
	}
	
    override documentEPackageHeader(EPackage pckg)
    	'''
    	«val packageName = ePackageFqName(pckg)»
		«val title = "<span class=\"packageName\">" + packageName + "</span> package"»
		«documentHeader("h1", title, packageName, pckg.nsPrefix, pckg)»
		<div class="">EPackage properties:</div>
		«documentProperty("Namespace Prefix", '''«escapeText(pckg.nsPrefix)»''')»
		«documentProperty("Namespace URI", '''«pckg.nsURI»''')»
        '''

    override documentEClassifierHeader(EClassifier cls)
	    '''
	    «documentHeader("h2", emitClassRef(cls), cls.name, cls.EPackage.nsPrefix+"."+cls.name, cls)»
	    '''

    override documentGenClassifierHeader(GenClass gcls)
	    '''
	    «documentHeader("h2", emitClassRef(gcls.ecoreClass), gcls.name, gcls.ecoreClass.EPackage.nsPrefix+"."+gcls.name, gcls)»
	    '''
    
    def private documentEDataTypeHeader(EDataType dt)
	    '''
	    «dt.documentEClassifierHeader»
	    '''
    
    override documentEEnumHeader(EEnum eenum)
	    '''
		«eenum.documentEDataTypeHeader»
		<table>
		<tr>
			<th colspan="3"><div class="tableHeader">Literals</div></th>
		</tr>
		<tr>
			<th><div class="columnHeader">Name</div></th>
			<th><div class="columnHeader">Value</div></th>
			<th><div class="columnHeader">Documentation</div></th>
		</tr>
		«FOR literal : eenum.ELiterals»
		<tr>
			<td>
				<span class="teletype">«escapeText(literal.literal)»</span>
			</td>
			<td>
				«literal.value»
			</td>
			<td>
				«literal.findGenModelDocumentation(false)»
			</td>	
		</tr>
	    «ENDFOR»
		</table>
		«anchorDef(eenum.EPackage.nsPrefix+"."+eenum.name+".lit","")»
	    '''

    override documentEClassProperties(EClass cls){
	    val str = new ArrayList<String>
	    
	    if(cls.isInterface()){
	      	str.add('''<span class="label">Interface</span>''')
	    }
		    	
		if(cls.isAbstract()){
			str.add('''<span class="label">Abstract</span>''')			
		}
		
		if (!str.empty) {		
    		str.stream().collect(Collectors.joining(", ", 
    			'''<div class="eclassProps">EClass properties:<div class="eclassPropList">''', 
    			'''</div></div>''')).appendToBuilder
		}	    	
    }
    
    def private documentENamedElement(ENamedElement elem, String parentId, String color)
	    '''
	    <div id="«parentId+"."+elem.name»" class="teletype">«IF color != null»<div style="color:«color»">«ENDIF»«escapeText(elem.name)»«IF color != null»</div>«ENDIF»</div>
	    '''
    
    //(«typePckg.nsURI»)
    // <«typePckg.name»>
    def private documentETypedElement(ETypedElement elem, String parentId, String color)
	    '''
	    	<td>«elem.documentENamedElement(parentId, color)»</td>
	    	<td>«documentProperty("T", elem.preparePossibleReference)»
	    <div class="label">Cardinality: [«elem.lowerBound»..«IF elem.upperBound == -1»*«ELSE»«elem.upperBound»«ENDIF»]</div>
	    «IF !elem.ordered»
	    <div class="label">Unordered</div>
	    «ENDIF»
	    «IF !elem.unique»
	    <div class="label">Not unique</div>
	    «ENDIF»'''
    
    def private preparePossibleReference(ETypedElement elem){
    	if(elem.EGenericType != null){
    		elem.EGenericType.preparePossibleReference
    	} else {
    		'''<div class="alert">MISSING TYPE elem!</div>'''
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
	    <div class="label">Non-changeable</div>
	    «ENDIF»
	    «IF feat.volatile»
	    <div class="label">Volatile</div>
	    «ENDIF»
	    «IF feat.transient»
	    <div class="label">Transient</div>
	    «ENDIF»
	    «IF feat.unsettable»
	    <div class="label">Unsettable</div>
	    «ENDIF»
	    «IF feat.defaultValueLiteral != null»
	    «documentProperty("Default", feat.defaultValueLiteral.escapeText)»
	    «ENDIF»
	    «IF feat.derived»
	    <div class="label">Derived</div>
	    «ENDIF»
	    '''
    
    def private documentEAttributeHeader(EAttribute attr, String parentId)
	    '''
	    «attr.documentEStructuralFeatureHeader(parentId)»
	    «IF attr.ID»
	    <div class="label">Identifier</div>
	    «ENDIF»
	    '''
    
    def private documentEReferenceHeader(EReference ref, String parentId)
	    '''
	    «ref.documentEStructuralFeatureHeader(parentId)»
	    «IF ref.containment»
	    <div class="label">Containment</div>
	    «ENDIF»
	    «IF ref.container»
	    <div class="label">Container</div>
	    «ENDIF»
	    «IF ref.EOpposite != null»
	    «documentProperty("Op", ref.EOpposite.name)»
	    «ENDIF»
	    '''
	    //ref.EOpposite.EContainingClass.preparePossibleReference+".\\allowbreak "+
    
    def private documentEOperationHeader(EOperation op, String parentId)
	    '''
	    «op.documentETypedElement(parentId, null)»
	    «IF op.EType != null»
	    <div class="label">Returns:</div>
	    «op.preparePossibleReference»[«op.lowerBound»..«IF op.upperBound == ETypedElement::UNBOUNDED_MULTIPLICITY»*«ELSE»«op.upperBound»«ENDIF»]
	    «ENDIF»
	    «IF !op.EParameters.empty»
	    <div class="label">Parameters:
	    <ul>
	    «FOR param : op.EParameters»
	    	<li>«param.preparePossibleReference»[«param.lowerBound»..«IF param.upperBound == ETypedElement::UNBOUNDED_MULTIPLICITY»*«ELSE»«param.upperBound»«ENDIF»] <span class="teletype>"«escapeText(param.name)»</span></li>
	    «ENDFOR»
	    </ul>
	    «ENDIF»
	    '''
    
    def private documentProperty(CharSequence key, CharSequence value)
	    '''
	    <div class="keyValue"><span class="label">«key»: </span><span class="teletype">«value»</span></div>
	    '''
    
    override documentHeader(String sectionClass, String sectionTitle, String shortTitle, String label) {
    	documentHeader(sectionClass, anchorDef(escapeLabel(label), sectionTitle).toString, label)
    }
    
    private def documentHeader(String sectionClass, String sectionAnchor, String label)
	    '''
	    <«sectionClass» id="«escapeLabel(label)»">«sectionAnchor»</«sectionClass»>
	    '''
    
    override escapeText(String text){
    	'''«text.replaceAll("&","&amp;").replaceAll("<","&lt;")»'''
    }
    
    override escapeLabel(String text){
    	'''«text.replaceAll("_","").replaceAll("\\.","")»'''
    }
    
    override findGenModelDocumentation(EModelElement element, boolean required){
    	var doc = super.findGenModelDocumentation(element, required)
		val builder = new StringBuilder();
    	val documentationFields = DocumentationFieldUtils.getDocumentationFields(element);
    	
    	builder.append(doc)
		documentationFields.forEach[
			val value = getValue;
			if (value != null) {
				builder.append(getKey + ": " + value);
				builder.append("<br>");
			}
		]	
    	return builder.toString;
    }
    
    override emitDocumentation(String doc, boolean required){
    	if(doc!=null){
    		val Reader docReader = new StringReader(doc);
    		val Parser parser = new Parser(docReader);
    	
    		val Document markdownDoc = parser.parse();
    		val builder = new StringBuilder();
    		val latexVisitor = new FixedHtmlEmitter(builder);
    		markdownDoc.accept(latexVisitor);
    		return builder.toString;
    	}
    	else {
    		if(optionActive(SHOW_MISSING_DOC) && required){
    			return '''<div class="alert">Missing Documentation!</div>'''
    		} else {
		    	return ''''''
    		}
    	} 
    }
    
    override String emitBaseClassRef(EClassifier cls) {
    	'''<a href="#«escapeLabel(cls.EPackage.nsPrefix+"."+cls.name)»">«cls.name»</a>'''
    }

	override processHeader(URI pkgURI) {
        val gc = new GregorianCalendar()
        val now = gc.getTime().toString()
		
        "<!-- This file was created using the HTML documentation generator. -->\n".appendToBuilder
        
        val create = "<!-- Creation date: " + now + "-->\n"
        create.appendToBuilder
        '''
			<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
			<html xmlns="http://www.w3.org/1999/xhtml">
				<head>
			      	<title>Metamodel Documentation («pkgURI»)</title>
			    	<script type="text/javascript">
<![CDATA[				    	
// TOC script based on code taken from http://www.quirksmode.org/dom/toc.html
function makeTOC() {
				
				var toc = document.createElement('div')				
				toc.id = "toc";
				toc.innerHTML = "Table of Contents"				
				document.body.appendChild(toc);
							
				var innertocDiv = createTOC()				
				toc.appendChild(innertocDiv);
}


function createTOC() {
				var y = document.createElement('div');
				y.id = 'innertoc';
				//var a = y.appendChild(document.createElement('span'));
				//a.onclick = showhideTOC;
				//a.id = 'contentheader';
				//a.innerHTML = 'Show Table of Contents';
				var z = y.appendChild(document.createElement('div'));
				//z.onclick = showhideTOC;
				var toBeTOCced = getElementsByTagNames('h1,h2,h3');
				if (toBeTOCced.length < 2) return false;
				var hCount = 0;
				var hhCount = 0;
				var hhhCount = 0;
				for (var i=0;i<toBeTOCced.length;i++) {
				var tmp = document.createElement('a');
				tmp.className = 'page';
				var text;
				var textPre;
				if (toBeTOCced[i].nodeName == 'h2'){
					tmp.className += ' indent';
					textPre = hCount + "."+ ++hhCount + ". "; 
				}
				else if (toBeTOCced[i].nodeName == 'h3'){
					tmp.className += ' extraindent';
					textPre = hCount + "."+ hhCount + "."+ ++hhhCount +". "; 
				}
				else {
					textPre = ++hCount + ". "; 
					hhCount = 0;
					hhhCount = 0;
				}
				text = textPre + toBeTOCced[i].textContent;
				toBeTOCced[i].innerHTML = textPre + toBeTOCced[i].innerHTML;
				
				tmp.innerHTML = text; 
				z.appendChild(tmp);
				var headerId = toBeTOCced[i].id || 'link' + i;
				tmp.href = '#' + headerId;
				toBeTOCced[i].id = headerId;
				}
				return y;
}

function getElementsByTagNames(list,obj) {
				if (!obj) var obj = document;
				var tagNames = list.split(',');
				var resultArray = new Array();
				for (var i=0;i<tagNames.length;i++) {
					var tags = obj.getElementsByTagName(tagNames[i]);
					for (var j=0;j<tags.length;j++) {
						resultArray.push(tags[j]);
					}
				}
				var testNode = resultArray[0];
				if (!testNode) return [];
				if (testNode.sourceIndex) {
					resultArray.sort(function (a,b) {
							return a.sourceIndex - b.sourceIndex;
					});
				}
				else if (testNode.compareDocumentPosition) {
					resultArray.sort(function (a,b) {
							return 3 - (a.compareDocumentPosition(b) & 6);
					});
				}
				return resultArray;
}
				    	
]]>				    	
				    	</script>
				    	<link rel="stylesheet" type="text/css" href="https://raw.github.com/necolas/normalize.css/master/normalize.css" /> 
				    	<style>
#toc {
				position: fixed;
				  right: 0;
				  top: 0;
				  background-color:#eee;
				  overflow: scroll;
				  border: 1px dashed;
}

#toc #innertoc { 
				display: none;
				height: 500px;
} /* Hide the full TOC by default */

#toc:hover #innertoc{
				display: block; /* Show it on hover */
}
				td {
				border: 1px solid;
				}
				.page{
				display:table-row;
				}
				.indent {
				text-indent:12pt;
				}
				.extraindent {
				text-indent:14pt;
				}

				    	</style>
				    	<link rel="stylesheet" type="text/css" href="style.css" />
				</head>
				<body onload="makeTOC();">
	        '''.appendToBuilder
	}

	override generateTail() {
		'''
	    </body>
	    </html>
	    '''.appendToBuilder
	}
	
    private def anchorDef(CharSequence id, CharSequence text){
    	'''<a href="#«id»">«text»</a>'''
    }
}
