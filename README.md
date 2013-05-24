Ecore to HTML/LaTeX documentation generator
======================================

This is a small utility for generating HTML or LaTeX documentation from Eclipse Modeling Framework metamodels (Ecore files).

The generator uses the structure of the metamodel and the values of the GenModelDoc annotation for creating content. 

The generated text will include a section for the main package in the metamodel and subsections for the classifiers, datatypes and enumerations. 


Usage
-----

Once you installed the two plugins into your Eclipse (or started a runtime Eclipse with them included),
 just right-click on any .ecore file in your workspace and select "Generate Latex Documentation" or "Generate HTML Documentation" from the menu. As a result a .tex or .html file will be created in the same folder.

To add documentation to your metamodel, you can either use the Ecore Diagram Editor and input the textual descriptions into the "GenModel Doc"
 field that can be found on the Properties view, or simply add an EAnnotation to any element with the *source* attribute set
 to *http://www.eclipse.org/emf/2002/GenModel* and add a *details* entry with the *key* set to *documentation* and the value 
 containing your description.
 
Alternatively, you can activate the "Ecore Documentation" view, and enter content directly through that (to use it, first select an Ecore element in the editor, and then click into the view).

We also provide validators based on EMF-IncQuery (http://eclipse.org/incquery) that provide auto-refresh validator for missing/zero-length documentation fields, gradually guiding you to complete documentation nirvana :) See the annotated screenshot below for details.

![EcoreDocGen screenshot](ecoredocgen_school.png?raw=true)

## Additional syntax

### For the HTML Case

The generator supports documentation formatted in Markdown syntax. You can use any Markdown element you like.

### For the LaTex Case

The generator supports a subset of Markdown syntax:
* building lists
* emphasis of text elements (bold/italic/underline)
* hyperlinks to remote URLs

## Output

### HTML
The output format is customizable via CSS. The style-sheet is assumed to be in the same directory as the generated HTML file, and is assumed to be called style.css. An example CSS file can be found in the resources folder of the repository.

### LaTex
At least the following packages need to be imported in your LaTex document for the documentation to be valid:

	\usepackage{color}
	\usepackage{hyperref}
	\usepackage{tabularx}
	\usepackage{float}



Structure
---------

The following is a short description of the structure used in documenting the metamodels. 

### EPackage
The documentation section of each metamodel begins with a short introduction explaining the rationale
 behind the given metamodel and lists the main concepts that are identified and represented by the elements in the metamodel.
 This introduction is stored in the main EPackage that contains the elements of the metamodel.
 Finally, the namespace prefix and URI used when persisting instance models of the metamodel are listed.

### Elements
After the metamodel introduction, each element in the Package has a subsection which starts with the description of the element,
 followed by various element properties and tables depending on the type of the element.

#### EClass
There are two properties and three tables that can appear for an EClass element.
 The __Abstract__ property specifies that instance models cannot contain EObjects that are instances of this EClass,
 instead subtypes should be used. The __Interface__ property specifies that no implementation is generated for the EClass.
 Finally, the list of __Supertypes__ is given.

The tables list the (i) __attributes__, (ii) __references__ and (iii) __operations__ of the EClass,
 if there are any. Each table has three columns, the first contains the name of the element (colored __blue__ if derived),
 the second a list of properties and the third any documentation that is given. Apart from clarifications and rationale,
 this documentation part can also include validation rules that should be satisfied by instance models (with violations
 appearing as either errors or warnings).

Some properties are common to the tables, these are the __Type (T)__ and the __Cardinality__ of the element
 and whether the values are __Unordered__ or __Not unique__ (the default values __Ordered__ and __Unique__ are not shown).
 In the case of operations, the type and cardinality refers to the return value. 

The properties specific to features (attributes and references) are __Non-change\-able__ (cannot be modified directly),
 __Volatile__ (value not stored in a field), __Transient__ (value not persisted), __Unsettable__ (has *Unset* value)
 and __Derived__ (value is computed), again, only non-default values are listed.

The property specific to attributes is __Identifier__, which is true if the value of the attribute identifies the EObject.

The reference-specific properties are __Opposite (Op)__ (the name of the reference in the target that will refer back to the source),
 __Containment__ (true, if target EObject of this reference is persisted inside source) and __Container__ 
 (Containment is true for opposite of reference). Finally, the property specific to operations is __Parameters__
 (any number of parameters with type and cardinality).

#### EEnum
There is only one table that appears additionally to the element description.
 The table lists the __literals__ of the EEnum and contains three columns, the name, value and documentation of the literal. 
 
Copyright
---------
All code in this repository is available under the Eclipse Public License v1.0: http://www.eclipse.org/legal/epl-v10.html
