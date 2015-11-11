package hu.qgears.xtextdoc.editor;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.AbstractEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;

/**
 * This class is for adding mouse hover for keywords.
 * 
 * Bind with [LanguageName]UiModule.bindIEObjectHover().
 * 
 * @author glaseradam
 *
 */
public class MyEObjectHover extends AbstractEObjectHover {

	IInformationControlCreatorProvider lastCreatorProvider = null;

	@Inject
	KeywordHelper keywordHelper;

	@Inject
	IEObjectHoverProvider hoverProvider;

	@Inject
	private IGlobalServiceProvider serviceProvider;

	public Object getDefaultHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
		IEObjectHoverProvider hoverProvider = serviceProvider.findService(first, IEObjectHoverProvider.class);
		if (hoverProvider == null)
			return null;
		IInformationControlCreatorProvider creatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
		if (creatorProvider == null)
			return null;
		this.lastCreatorProvider = creatorProvider;
		return lastCreatorProvider.getInfo();
	}

	@Override
	public Object getHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
		if (first instanceof EObjectWrapper) {
			lastCreatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
			return lastCreatorProvider == null ? null : lastCreatorProvider.getInfo();
		}
		lastCreatorProvider = null;
		return getDefaultHoverInfo(first, textViewer, hoverRegion);
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		return this.lastCreatorProvider == null ? super.getHoverControlCreator()
				: lastCreatorProvider.getHoverControlCreator();
	}

	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, final int offset) {
		ILeafNode leafNodeAt = keywordHelper.getLeafNodeAt(resource, offset);
		Pair<EObject, IRegion> result = Tuples.create(keywordHelper.getEObjectAt(leafNodeAt),
				(IRegion) new Region(leafNodeAt.getOffset(), leafNodeAt.getLength()));
		if (result.getFirst() == null) {
			result = super.getXtextElementAt(resource, offset);
		}
		return result;
	}

}
