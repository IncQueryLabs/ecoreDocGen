package hu.bme.mit.documentation.generator.ecore;

import java.util.Stack;

import org.tautua.markdownpapers.ast.CharRef;
import org.tautua.markdownpapers.ast.Code;
import org.tautua.markdownpapers.ast.CodeSpan;
import org.tautua.markdownpapers.ast.CodeText;
import org.tautua.markdownpapers.ast.Comment;
import org.tautua.markdownpapers.ast.Document;
import org.tautua.markdownpapers.ast.Emphasis;
import org.tautua.markdownpapers.ast.Header;
import org.tautua.markdownpapers.ast.Image;
import org.tautua.markdownpapers.ast.InlineUrl;
import org.tautua.markdownpapers.ast.Item;
import org.tautua.markdownpapers.ast.Line;
import org.tautua.markdownpapers.ast.LineBreak;
import org.tautua.markdownpapers.ast.Link;
import org.tautua.markdownpapers.ast.List;
import org.tautua.markdownpapers.ast.Paragraph;
import org.tautua.markdownpapers.ast.Quote;
import org.tautua.markdownpapers.ast.ResourceDefinition;
import org.tautua.markdownpapers.ast.Ruler;
import org.tautua.markdownpapers.ast.SimpleNode;
import org.tautua.markdownpapers.ast.Tag;
import org.tautua.markdownpapers.ast.Text;
import org.tautua.markdownpapers.ast.Visitor;

/**
 * Visitor that converts Markdown elements to Latex during the traversal of the
 * Markdown AST.
 * 
 * Call {@link #getLatexString()} to obtain the Latex representation.
 * 
 * TODO implement missing cases.
 *  
 * @author adam
 * 
 */
public class MarkdownToLatexVisitor implements Visitor {

	private static final String NEWLINE = "\n";
	private StringBuilder latexString = new StringBuilder();
	
	Stack<List> listStack = new Stack<List>();
	
	
	@Override
	public void visit(CharRef arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Code arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CodeSpan arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CodeText arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Comment arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Document arg0) {
		arg0.childrenAccept(this);
	}

	@Override
	public void visit(Emphasis arg0) {
		switch(arg0.getType()){
		case BOLD:
			latexString.append("\\textbf{");
			latexString.append(escape(arg0.getText()));
			latexString.append("}");
			break;
		case ITALIC:
			latexString.append("\\textit{");
			latexString.append(escape(arg0.getText()));
			latexString.append("}");
			break;
		case ITALIC_AND_BOLD:
			latexString.append("\\textbf{");
			latexString.append("\\textbf{");
			latexString.append(escape(arg0.getText()));
			latexString.append("}}");
			break;
		}
	}

	private String escape(String text) {
		return text.replaceAll("_", "\\\\_");
	}

	@Override
	public void visit(Header arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Image arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Line arg0) {
		arg0.childrenAccept(this);
	}

	@Override
	public void visit(LineBreak arg0) {
		latexString.append(NEWLINE);
		arg0.childrenAccept(this);
	}

	@Override
	public void visit(Link arg0) {
		String url = arg0.getReference();
		String text = arg0.getText();
		if(url!=null && !url.isEmpty()){
			latexString.append("\\href{"+escape(url)+"}");
		}
		if(text!=null && !text.isEmpty()){
			latexString.append("{"+escape(text)+"}");
		}
	}

	@Override
	public void visit(List arg0) {
		if(!listStack.isEmpty()){
			//we are already processing a list, so we need a newline before starting this one
			latexString.append(NEWLINE);
		}
		listStack.push(arg0);
		StringBuilder indent = new StringBuilder();
		for(int i = arg0.getIndentation(); i>0;i--){
			indent.append("\t");
		}
		latexString.append(indent);
		latexString.append("\\begin{itemize}"+NEWLINE);
		arg0.childrenAccept(this);
		latexString.append(indent);
		latexString.append("\\end{itemize}"+NEWLINE);
		listStack.pop();
	}

	@Override
	public void visit(Item arg0) {
		for(int i = arg0.getIndentation(); i>0;i--){
			latexString.append("\t");
		}
		latexString.append("\\item ");
		arg0.childrenAccept(this);
		latexString.append(NEWLINE);
	}

	@Override
	public void visit(InlineUrl arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void visit(Paragraph arg0) {
		arg0.childrenAccept(this);
	}

	@Override
	public void visit(Quote arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ResourceDefinition arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Ruler arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(SimpleNode arg0) {
		arg0.childrenAccept(this);
	}

	@Override
	public void visit(Tag arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Text arg0) {
		latexString.append(escape(arg0.getValue()));
	}

	public String getLatexString() {
		return latexString.toString();
	}

}
