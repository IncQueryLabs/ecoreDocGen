package org.xtext.example.mydsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'library'", "'{'", "'book'", "'author'", "'}'", "'name'", "'title'", "'page'", "'category'", "'Biography'", "'Mystery'", "'ScienceFiction'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;
     	
        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "DomainModel";	
       	}
       	
       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleDomainModel"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:68:1: entryRuleDomainModel returns [EObject current=null] : iv_ruleDomainModel= ruleDomainModel EOF ;
    public final EObject entryRuleDomainModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainModel = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:69:2: (iv_ruleDomainModel= ruleDomainModel EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:70:2: iv_ruleDomainModel= ruleDomainModel EOF
            {
             newCompositeNode(grammarAccess.getDomainModelRule()); 
            pushFollow(FOLLOW_ruleDomainModel_in_entryRuleDomainModel75);
            iv_ruleDomainModel=ruleDomainModel();

            state._fsp--;

             current =iv_ruleDomainModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomainModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainModel"


    // $ANTLR start "ruleDomainModel"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:77:1: ruleDomainModel returns [EObject current=null] : ( (lv_elements_0_0= ruleModelElement ) )* ;
    public final EObject ruleDomainModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:28: ( ( (lv_elements_0_0= ruleModelElement ) )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:81:1: ( (lv_elements_0_0= ruleModelElement ) )*
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:81:1: ( (lv_elements_0_0= ruleModelElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||(LA1_0>=13 && LA1_0<=14)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:82:1: (lv_elements_0_0= ruleModelElement )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:82:1: (lv_elements_0_0= ruleModelElement )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:83:3: lv_elements_0_0= ruleModelElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDomainModelAccess().getElementsModelElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModelElement_in_ruleDomainModel130);
            	    lv_elements_0_0=ruleModelElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDomainModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"ModelElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainModel"


    // $ANTLR start "entryRuleModelElement"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:107:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:108:2: (iv_ruleModelElement= ruleModelElement EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:109:2: iv_ruleModelElement= ruleModelElement EOF
            {
             newCompositeNode(grammarAccess.getModelElementRule()); 
            pushFollow(FOLLOW_ruleModelElement_in_entryRuleModelElement166);
            iv_ruleModelElement=ruleModelElement();

            state._fsp--;

             current =iv_ruleModelElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElement176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:116:1: ruleModelElement returns [EObject current=null] : (this_Library_0= ruleLibrary | this_Author_1= ruleAuthor | this_Book_2= ruleBook ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        EObject this_Library_0 = null;

        EObject this_Author_1 = null;

        EObject this_Book_2 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:119:28: ( (this_Library_0= ruleLibrary | this_Author_1= ruleAuthor | this_Book_2= ruleBook ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:120:1: (this_Library_0= ruleLibrary | this_Author_1= ruleAuthor | this_Book_2= ruleBook )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:120:1: (this_Library_0= ruleLibrary | this_Author_1= ruleAuthor | this_Book_2= ruleBook )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:121:5: this_Library_0= ruleLibrary
                    {
                     
                            newCompositeNode(grammarAccess.getModelElementAccess().getLibraryParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLibrary_in_ruleModelElement223);
                    this_Library_0=ruleLibrary();

                    state._fsp--;

                     
                            current = this_Library_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:131:5: this_Author_1= ruleAuthor
                    {
                     
                            newCompositeNode(grammarAccess.getModelElementAccess().getAuthorParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAuthor_in_ruleModelElement250);
                    this_Author_1=ruleAuthor();

                    state._fsp--;

                     
                            current = this_Author_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:141:5: this_Book_2= ruleBook
                    {
                     
                            newCompositeNode(grammarAccess.getModelElementAccess().getBookParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBook_in_ruleModelElement277);
                    this_Book_2=ruleBook();

                    state._fsp--;

                     
                            current = this_Book_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleLibrary"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:157:1: entryRuleLibrary returns [EObject current=null] : iv_ruleLibrary= ruleLibrary EOF ;
    public final EObject entryRuleLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibrary = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:158:2: (iv_ruleLibrary= ruleLibrary EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:159:2: iv_ruleLibrary= ruleLibrary EOF
            {
             newCompositeNode(grammarAccess.getLibraryRule()); 
            pushFollow(FOLLOW_ruleLibrary_in_entryRuleLibrary312);
            iv_ruleLibrary=ruleLibrary();

            state._fsp--;

             current =iv_ruleLibrary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLibrary322); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLibrary"


    // $ANTLR start "ruleLibrary"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:166:1: ruleLibrary returns [EObject current=null] : (otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'book' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'author' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}' ) ;
    public final EObject ruleLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:169:28: ( (otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'book' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'author' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:170:1: (otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'book' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'author' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:170:1: (otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'book' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'author' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:170:3: otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'book' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'author' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleLibrary359); 

                	newLeafNode(otherlv_0, grammarAccess.getLibraryAccess().getLibraryKeyword_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:174:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:175:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:175:1: (lv_name_1_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:176:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLibrary376); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLibraryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLibraryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleLibrary393); 

                	newLeafNode(otherlv_2, grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:196:1: ( (otherlv_3= 'book' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'author' ( (otherlv_6= RULE_ID ) ) )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:196:2: (otherlv_3= 'book' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'author' ( (otherlv_6= RULE_ID ) ) )*
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:196:2: (otherlv_3= 'book' ( (otherlv_4= RULE_ID ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:196:4: otherlv_3= 'book' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleLibrary407); 

            	        	newLeafNode(otherlv_3, grammarAccess.getLibraryAccess().getBookKeyword_3_0_0());
            	        
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:200:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:201:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:201:1: (otherlv_4= RULE_ID )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:202:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLibraryRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLibrary427); 

            	    		newLeafNode(otherlv_4, grammarAccess.getLibraryAccess().getBooksBookCrossReference_3_0_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:213:4: (otherlv_5= 'author' ( (otherlv_6= RULE_ID ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:213:6: otherlv_5= 'author' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleLibrary442); 

            	        	newLeafNode(otherlv_5, grammarAccess.getLibraryAccess().getAuthorKeyword_3_1_0());
            	        
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:217:1: ( (otherlv_6= RULE_ID ) )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:218:1: (otherlv_6= RULE_ID )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:218:1: (otherlv_6= RULE_ID )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:219:3: otherlv_6= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLibraryRule());
            	    	        }
            	            
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLibrary462); 

            	    		newLeafNode(otherlv_6, grammarAccess.getLibraryAccess().getAuthorsAuthorCrossReference_3_1_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleLibrary477); 

                	newLeafNode(otherlv_7, grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLibrary"


    // $ANTLR start "entryRuleAuthor"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:242:1: entryRuleAuthor returns [EObject current=null] : iv_ruleAuthor= ruleAuthor EOF ;
    public final EObject entryRuleAuthor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthor = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:243:2: (iv_ruleAuthor= ruleAuthor EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:244:2: iv_ruleAuthor= ruleAuthor EOF
            {
             newCompositeNode(grammarAccess.getAuthorRule()); 
            pushFollow(FOLLOW_ruleAuthor_in_entryRuleAuthor513);
            iv_ruleAuthor=ruleAuthor();

            state._fsp--;

             current =iv_ruleAuthor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAuthor523); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAuthor"


    // $ANTLR start "ruleAuthor"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:251:1: ruleAuthor returns [EObject current=null] : (otherlv_0= 'author' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'name' ( (lv_fullName_4_0= RULE_STRING ) ) (otherlv_5= 'book' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}' ) ;
    public final EObject ruleAuthor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_fullName_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:254:28: ( (otherlv_0= 'author' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'name' ( (lv_fullName_4_0= RULE_STRING ) ) (otherlv_5= 'book' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:255:1: (otherlv_0= 'author' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'name' ( (lv_fullName_4_0= RULE_STRING ) ) (otherlv_5= 'book' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:255:1: (otherlv_0= 'author' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'name' ( (lv_fullName_4_0= RULE_STRING ) ) (otherlv_5= 'book' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:255:3: otherlv_0= 'author' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'name' ( (lv_fullName_4_0= RULE_STRING ) ) (otherlv_5= 'book' ( (otherlv_6= RULE_ID ) ) )* ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleAuthor560); 

                	newLeafNode(otherlv_0, grammarAccess.getAuthorAccess().getAuthorKeyword_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:259:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:260:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:260:1: (lv_name_1_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:261:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAuthor577); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAuthorAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAuthorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleAuthor594); 

                	newLeafNode(otherlv_2, grammarAccess.getAuthorAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:281:1: (otherlv_3= 'name' ( (lv_fullName_4_0= RULE_STRING ) ) (otherlv_5= 'book' ( (otherlv_6= RULE_ID ) ) )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:281:3: otherlv_3= 'name' ( (lv_fullName_4_0= RULE_STRING ) ) (otherlv_5= 'book' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleAuthor607); 

                	newLeafNode(otherlv_3, grammarAccess.getAuthorAccess().getNameKeyword_3_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:285:1: ( (lv_fullName_4_0= RULE_STRING ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:286:1: (lv_fullName_4_0= RULE_STRING )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:286:1: (lv_fullName_4_0= RULE_STRING )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:287:3: lv_fullName_4_0= RULE_STRING
            {
            lv_fullName_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAuthor624); 

            			newLeafNode(lv_fullName_4_0, grammarAccess.getAuthorAccess().getFullNameSTRINGTerminalRuleCall_3_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAuthorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fullName",
                    		lv_fullName_4_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:303:2: (otherlv_5= 'book' ( (otherlv_6= RULE_ID ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:303:4: otherlv_5= 'book' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleAuthor642); 

            	        	newLeafNode(otherlv_5, grammarAccess.getAuthorAccess().getBookKeyword_3_2_0());
            	        
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:307:1: ( (otherlv_6= RULE_ID ) )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:308:1: (otherlv_6= RULE_ID )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:308:1: (otherlv_6= RULE_ID )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:309:3: otherlv_6= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAuthorRule());
            	    	        }
            	            
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAuthor662); 

            	    		newLeafNode(otherlv_6, grammarAccess.getAuthorAccess().getBooksBookCrossReference_3_2_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAuthor677); 

                	newLeafNode(otherlv_7, grammarAccess.getAuthorAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAuthor"


    // $ANTLR start "entryRuleBook"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:332:1: entryRuleBook returns [EObject current=null] : iv_ruleBook= ruleBook EOF ;
    public final EObject entryRuleBook() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBook = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:333:2: (iv_ruleBook= ruleBook EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:334:2: iv_ruleBook= ruleBook EOF
            {
             newCompositeNode(grammarAccess.getBookRule()); 
            pushFollow(FOLLOW_ruleBook_in_entryRuleBook713);
            iv_ruleBook=ruleBook();

            state._fsp--;

             current =iv_ruleBook; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBook723); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBook"


    // $ANTLR start "ruleBook"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:341:1: ruleBook returns [EObject current=null] : (otherlv_0= 'book' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'title' ( (lv_title_4_0= RULE_STRING ) ) (otherlv_5= 'page' ( (lv_pages_6_0= RULE_INT ) ) )? (otherlv_7= 'category' ( (lv_category_8_0= ruleBookCategory ) ) )? (otherlv_9= 'author' ( (otherlv_10= RULE_ID ) ) )* ) otherlv_11= '}' ) ;
    public final EObject ruleBook() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_title_4_0=null;
        Token otherlv_5=null;
        Token lv_pages_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Enumerator lv_category_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:344:28: ( (otherlv_0= 'book' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'title' ( (lv_title_4_0= RULE_STRING ) ) (otherlv_5= 'page' ( (lv_pages_6_0= RULE_INT ) ) )? (otherlv_7= 'category' ( (lv_category_8_0= ruleBookCategory ) ) )? (otherlv_9= 'author' ( (otherlv_10= RULE_ID ) ) )* ) otherlv_11= '}' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:345:1: (otherlv_0= 'book' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'title' ( (lv_title_4_0= RULE_STRING ) ) (otherlv_5= 'page' ( (lv_pages_6_0= RULE_INT ) ) )? (otherlv_7= 'category' ( (lv_category_8_0= ruleBookCategory ) ) )? (otherlv_9= 'author' ( (otherlv_10= RULE_ID ) ) )* ) otherlv_11= '}' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:345:1: (otherlv_0= 'book' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'title' ( (lv_title_4_0= RULE_STRING ) ) (otherlv_5= 'page' ( (lv_pages_6_0= RULE_INT ) ) )? (otherlv_7= 'category' ( (lv_category_8_0= ruleBookCategory ) ) )? (otherlv_9= 'author' ( (otherlv_10= RULE_ID ) ) )* ) otherlv_11= '}' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:345:3: otherlv_0= 'book' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'title' ( (lv_title_4_0= RULE_STRING ) ) (otherlv_5= 'page' ( (lv_pages_6_0= RULE_INT ) ) )? (otherlv_7= 'category' ( (lv_category_8_0= ruleBookCategory ) ) )? (otherlv_9= 'author' ( (otherlv_10= RULE_ID ) ) )* ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleBook760); 

                	newLeafNode(otherlv_0, grammarAccess.getBookAccess().getBookKeyword_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:349:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:350:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:350:1: (lv_name_1_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:351:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBook777); 

            			newLeafNode(lv_name_1_0, grammarAccess.getBookAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBookRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleBook794); 

                	newLeafNode(otherlv_2, grammarAccess.getBookAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:371:1: (otherlv_3= 'title' ( (lv_title_4_0= RULE_STRING ) ) (otherlv_5= 'page' ( (lv_pages_6_0= RULE_INT ) ) )? (otherlv_7= 'category' ( (lv_category_8_0= ruleBookCategory ) ) )? (otherlv_9= 'author' ( (otherlv_10= RULE_ID ) ) )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:371:3: otherlv_3= 'title' ( (lv_title_4_0= RULE_STRING ) ) (otherlv_5= 'page' ( (lv_pages_6_0= RULE_INT ) ) )? (otherlv_7= 'category' ( (lv_category_8_0= ruleBookCategory ) ) )? (otherlv_9= 'author' ( (otherlv_10= RULE_ID ) ) )*
            {
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleBook807); 

                	newLeafNode(otherlv_3, grammarAccess.getBookAccess().getTitleKeyword_3_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:375:1: ( (lv_title_4_0= RULE_STRING ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:376:1: (lv_title_4_0= RULE_STRING )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:376:1: (lv_title_4_0= RULE_STRING )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:377:3: lv_title_4_0= RULE_STRING
            {
            lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleBook824); 

            			newLeafNode(lv_title_4_0, grammarAccess.getBookAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBookRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"title",
                    		lv_title_4_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:393:2: (otherlv_5= 'page' ( (lv_pages_6_0= RULE_INT ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:393:4: otherlv_5= 'page' ( (lv_pages_6_0= RULE_INT ) )
                    {
                    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleBook842); 

                        	newLeafNode(otherlv_5, grammarAccess.getBookAccess().getPageKeyword_3_2_0());
                        
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:397:1: ( (lv_pages_6_0= RULE_INT ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:398:1: (lv_pages_6_0= RULE_INT )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:398:1: (lv_pages_6_0= RULE_INT )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:399:3: lv_pages_6_0= RULE_INT
                    {
                    lv_pages_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleBook859); 

                    			newLeafNode(lv_pages_6_0, grammarAccess.getBookAccess().getPagesINTTerminalRuleCall_3_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBookRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"pages",
                            		lv_pages_6_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:415:4: (otherlv_7= 'category' ( (lv_category_8_0= ruleBookCategory ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:415:6: otherlv_7= 'category' ( (lv_category_8_0= ruleBookCategory ) )
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleBook879); 

                        	newLeafNode(otherlv_7, grammarAccess.getBookAccess().getCategoryKeyword_3_3_0());
                        
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:419:1: ( (lv_category_8_0= ruleBookCategory ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:420:1: (lv_category_8_0= ruleBookCategory )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:420:1: (lv_category_8_0= ruleBookCategory )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:421:3: lv_category_8_0= ruleBookCategory
                    {
                     
                    	        newCompositeNode(grammarAccess.getBookAccess().getCategoryBookCategoryEnumRuleCall_3_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBookCategory_in_ruleBook900);
                    lv_category_8_0=ruleBookCategory();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBookRule());
                    	        }
                           		set(
                           			current, 
                           			"category",
                            		lv_category_8_0, 
                            		"BookCategory");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:437:4: (otherlv_9= 'author' ( (otherlv_10= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==14) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:437:6: otherlv_9= 'author' ( (otherlv_10= RULE_ID ) )
            	    {
            	    otherlv_9=(Token)match(input,14,FOLLOW_14_in_ruleBook915); 

            	        	newLeafNode(otherlv_9, grammarAccess.getBookAccess().getAuthorKeyword_3_4_0());
            	        
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:441:1: ( (otherlv_10= RULE_ID ) )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:442:1: (otherlv_10= RULE_ID )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:442:1: (otherlv_10= RULE_ID )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:443:3: otherlv_10= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getBookRule());
            	    	        }
            	            
            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBook935); 

            	    		newLeafNode(otherlv_10, grammarAccess.getBookAccess().getAuthorsAuthorCrossReference_3_4_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_ruleBook950); 

                	newLeafNode(otherlv_11, grammarAccess.getBookAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBook"


    // $ANTLR start "ruleBookCategory"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:466:1: ruleBookCategory returns [Enumerator current=null] : ( (enumLiteral_0= 'Biography' ) | (enumLiteral_1= 'Mystery' ) | (enumLiteral_2= 'ScienceFiction' ) ) ;
    public final Enumerator ruleBookCategory() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:468:28: ( ( (enumLiteral_0= 'Biography' ) | (enumLiteral_1= 'Mystery' ) | (enumLiteral_2= 'ScienceFiction' ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:469:1: ( (enumLiteral_0= 'Biography' ) | (enumLiteral_1= 'Mystery' ) | (enumLiteral_2= 'ScienceFiction' ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:469:1: ( (enumLiteral_0= 'Biography' ) | (enumLiteral_1= 'Mystery' ) | (enumLiteral_2= 'ScienceFiction' ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt9=1;
                }
                break;
            case 21:
                {
                alt9=2;
                }
                break;
            case 22:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:469:2: (enumLiteral_0= 'Biography' )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:469:2: (enumLiteral_0= 'Biography' )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:469:4: enumLiteral_0= 'Biography'
                    {
                    enumLiteral_0=(Token)match(input,20,FOLLOW_20_in_ruleBookCategory1000); 

                            current = grammarAccess.getBookCategoryAccess().getBiographyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getBookCategoryAccess().getBiographyEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:475:6: (enumLiteral_1= 'Mystery' )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:475:6: (enumLiteral_1= 'Mystery' )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:475:8: enumLiteral_1= 'Mystery'
                    {
                    enumLiteral_1=(Token)match(input,21,FOLLOW_21_in_ruleBookCategory1017); 

                            current = grammarAccess.getBookCategoryAccess().getMysteryEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getBookCategoryAccess().getMysteryEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:481:6: (enumLiteral_2= 'ScienceFiction' )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:481:6: (enumLiteral_2= 'ScienceFiction' )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:481:8: enumLiteral_2= 'ScienceFiction'
                    {
                    enumLiteral_2=(Token)match(input,22,FOLLOW_22_in_ruleBookCategory1034); 

                            current = grammarAccess.getBookCategoryAccess().getScienceFictionEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getBookCategoryAccess().getScienceFictionEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBookCategory"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleDomainModel_in_entryRuleDomainModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomainModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElement_in_ruleDomainModel130 = new BitSet(new long[]{0x0000000000006802L});
    public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElement176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLibrary_in_ruleModelElement223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAuthor_in_ruleModelElement250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBook_in_ruleModelElement277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLibrary_in_entryRuleLibrary312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLibrary322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleLibrary359 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLibrary376 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLibrary393 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_13_in_ruleLibrary407 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLibrary427 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_14_in_ruleLibrary442 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLibrary462 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleLibrary477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAuthor_in_entryRuleAuthor513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAuthor523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleAuthor560 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAuthor577 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAuthor594 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAuthor607 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAuthor624 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_13_in_ruleAuthor642 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAuthor662 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_15_in_ruleAuthor677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBook_in_entryRuleBook713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBook723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleBook760 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBook777 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleBook794 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleBook807 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleBook824 = new BitSet(new long[]{0x00000000000CC000L});
    public static final BitSet FOLLOW_18_in_ruleBook842 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleBook859 = new BitSet(new long[]{0x000000000008C000L});
    public static final BitSet FOLLOW_19_in_ruleBook879 = new BitSet(new long[]{0x0000000000700000L});
    public static final BitSet FOLLOW_ruleBookCategory_in_ruleBook900 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleBook915 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBook935 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleBook950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleBookCategory1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleBookCategory1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleBookCategory1034 = new BitSet(new long[]{0x0000000000000002L});

}