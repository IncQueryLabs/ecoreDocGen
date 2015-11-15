package org.xtext.example.mydsl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Biography'", "'Mystery'", "'ScienceFiction'", "'library'", "'{'", "'}'", "'book'", "'author'", "'name'", "'title'", "'page'", "'category'"
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
    public String getGrammarFileName() { return "../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g"; }


     
     	private MyDslGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(MyDslGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleDomainModel"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:60:1: entryRuleDomainModel : ruleDomainModel EOF ;
    public final void entryRuleDomainModel() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:61:1: ( ruleDomainModel EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:62:1: ruleDomainModel EOF
            {
             before(grammarAccess.getDomainModelRule()); 
            pushFollow(FOLLOW_ruleDomainModel_in_entryRuleDomainModel61);
            ruleDomainModel();

            state._fsp--;

             after(grammarAccess.getDomainModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomainModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDomainModel"


    // $ANTLR start "ruleDomainModel"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:69:1: ruleDomainModel : ( ( rule__DomainModel__ElementsAssignment )* ) ;
    public final void ruleDomainModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:73:2: ( ( ( rule__DomainModel__ElementsAssignment )* ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:74:1: ( ( rule__DomainModel__ElementsAssignment )* )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:74:1: ( ( rule__DomainModel__ElementsAssignment )* )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:75:1: ( rule__DomainModel__ElementsAssignment )*
            {
             before(grammarAccess.getDomainModelAccess().getElementsAssignment()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:76:1: ( rule__DomainModel__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14||(LA1_0>=17 && LA1_0<=18)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:76:2: rule__DomainModel__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__DomainModel__ElementsAssignment_in_ruleDomainModel94);
            	    rule__DomainModel__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getDomainModelAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDomainModel"


    // $ANTLR start "entryRuleModelElement"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:88:1: entryRuleModelElement : ruleModelElement EOF ;
    public final void entryRuleModelElement() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:89:1: ( ruleModelElement EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:90:1: ruleModelElement EOF
            {
             before(grammarAccess.getModelElementRule()); 
            pushFollow(FOLLOW_ruleModelElement_in_entryRuleModelElement122);
            ruleModelElement();

            state._fsp--;

             after(grammarAccess.getModelElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElement129); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:97:1: ruleModelElement : ( ( rule__ModelElement__Alternatives ) ) ;
    public final void ruleModelElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:101:2: ( ( ( rule__ModelElement__Alternatives ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:102:1: ( ( rule__ModelElement__Alternatives ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:102:1: ( ( rule__ModelElement__Alternatives ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:103:1: ( rule__ModelElement__Alternatives )
            {
             before(grammarAccess.getModelElementAccess().getAlternatives()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:104:1: ( rule__ModelElement__Alternatives )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:104:2: rule__ModelElement__Alternatives
            {
            pushFollow(FOLLOW_rule__ModelElement__Alternatives_in_ruleModelElement155);
            rule__ModelElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleLibrary"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:116:1: entryRuleLibrary : ruleLibrary EOF ;
    public final void entryRuleLibrary() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:117:1: ( ruleLibrary EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:118:1: ruleLibrary EOF
            {
             before(grammarAccess.getLibraryRule()); 
            pushFollow(FOLLOW_ruleLibrary_in_entryRuleLibrary182);
            ruleLibrary();

            state._fsp--;

             after(grammarAccess.getLibraryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLibrary189); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLibrary"


    // $ANTLR start "ruleLibrary"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:125:1: ruleLibrary : ( ( rule__Library__Group__0 ) ) ;
    public final void ruleLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:129:2: ( ( ( rule__Library__Group__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:130:1: ( ( rule__Library__Group__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:130:1: ( ( rule__Library__Group__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:131:1: ( rule__Library__Group__0 )
            {
             before(grammarAccess.getLibraryAccess().getGroup()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:132:1: ( rule__Library__Group__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:132:2: rule__Library__Group__0
            {
            pushFollow(FOLLOW_rule__Library__Group__0_in_ruleLibrary215);
            rule__Library__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLibraryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLibrary"


    // $ANTLR start "entryRuleAuthor"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:144:1: entryRuleAuthor : ruleAuthor EOF ;
    public final void entryRuleAuthor() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:145:1: ( ruleAuthor EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:146:1: ruleAuthor EOF
            {
             before(grammarAccess.getAuthorRule()); 
            pushFollow(FOLLOW_ruleAuthor_in_entryRuleAuthor242);
            ruleAuthor();

            state._fsp--;

             after(grammarAccess.getAuthorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAuthor249); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAuthor"


    // $ANTLR start "ruleAuthor"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:153:1: ruleAuthor : ( ( rule__Author__Group__0 ) ) ;
    public final void ruleAuthor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:157:2: ( ( ( rule__Author__Group__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:158:1: ( ( rule__Author__Group__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:158:1: ( ( rule__Author__Group__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:159:1: ( rule__Author__Group__0 )
            {
             before(grammarAccess.getAuthorAccess().getGroup()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:160:1: ( rule__Author__Group__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:160:2: rule__Author__Group__0
            {
            pushFollow(FOLLOW_rule__Author__Group__0_in_ruleAuthor275);
            rule__Author__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAuthorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAuthor"


    // $ANTLR start "entryRuleBook"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:172:1: entryRuleBook : ruleBook EOF ;
    public final void entryRuleBook() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:173:1: ( ruleBook EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:174:1: ruleBook EOF
            {
             before(grammarAccess.getBookRule()); 
            pushFollow(FOLLOW_ruleBook_in_entryRuleBook302);
            ruleBook();

            state._fsp--;

             after(grammarAccess.getBookRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBook309); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBook"


    // $ANTLR start "ruleBook"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:181:1: ruleBook : ( ( rule__Book__Group__0 ) ) ;
    public final void ruleBook() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:185:2: ( ( ( rule__Book__Group__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:186:1: ( ( rule__Book__Group__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:186:1: ( ( rule__Book__Group__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:187:1: ( rule__Book__Group__0 )
            {
             before(grammarAccess.getBookAccess().getGroup()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:188:1: ( rule__Book__Group__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:188:2: rule__Book__Group__0
            {
            pushFollow(FOLLOW_rule__Book__Group__0_in_ruleBook335);
            rule__Book__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBookAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBook"


    // $ANTLR start "ruleBookCategory"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:201:1: ruleBookCategory : ( ( rule__BookCategory__Alternatives ) ) ;
    public final void ruleBookCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:205:1: ( ( ( rule__BookCategory__Alternatives ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:206:1: ( ( rule__BookCategory__Alternatives ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:206:1: ( ( rule__BookCategory__Alternatives ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:207:1: ( rule__BookCategory__Alternatives )
            {
             before(grammarAccess.getBookCategoryAccess().getAlternatives()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:208:1: ( rule__BookCategory__Alternatives )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:208:2: rule__BookCategory__Alternatives
            {
            pushFollow(FOLLOW_rule__BookCategory__Alternatives_in_ruleBookCategory372);
            rule__BookCategory__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBookCategoryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBookCategory"


    // $ANTLR start "rule__ModelElement__Alternatives"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:219:1: rule__ModelElement__Alternatives : ( ( ruleLibrary ) | ( ruleAuthor ) | ( ruleBook ) );
    public final void rule__ModelElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:223:1: ( ( ruleLibrary ) | ( ruleAuthor ) | ( ruleBook ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 17:
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
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:224:1: ( ruleLibrary )
                    {
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:224:1: ( ruleLibrary )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:225:1: ruleLibrary
                    {
                     before(grammarAccess.getModelElementAccess().getLibraryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLibrary_in_rule__ModelElement__Alternatives407);
                    ruleLibrary();

                    state._fsp--;

                     after(grammarAccess.getModelElementAccess().getLibraryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:230:6: ( ruleAuthor )
                    {
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:230:6: ( ruleAuthor )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:231:1: ruleAuthor
                    {
                     before(grammarAccess.getModelElementAccess().getAuthorParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleAuthor_in_rule__ModelElement__Alternatives424);
                    ruleAuthor();

                    state._fsp--;

                     after(grammarAccess.getModelElementAccess().getAuthorParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:236:6: ( ruleBook )
                    {
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:236:6: ( ruleBook )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:237:1: ruleBook
                    {
                     before(grammarAccess.getModelElementAccess().getBookParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleBook_in_rule__ModelElement__Alternatives441);
                    ruleBook();

                    state._fsp--;

                     after(grammarAccess.getModelElementAccess().getBookParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElement__Alternatives"


    // $ANTLR start "rule__BookCategory__Alternatives"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:247:1: rule__BookCategory__Alternatives : ( ( ( 'Biography' ) ) | ( ( 'Mystery' ) ) | ( ( 'ScienceFiction' ) ) );
    public final void rule__BookCategory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:251:1: ( ( ( 'Biography' ) ) | ( ( 'Mystery' ) ) | ( ( 'ScienceFiction' ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:252:1: ( ( 'Biography' ) )
                    {
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:252:1: ( ( 'Biography' ) )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:253:1: ( 'Biography' )
                    {
                     before(grammarAccess.getBookCategoryAccess().getBiographyEnumLiteralDeclaration_0()); 
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:254:1: ( 'Biography' )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:254:3: 'Biography'
                    {
                    match(input,11,FOLLOW_11_in_rule__BookCategory__Alternatives474); 

                    }

                     after(grammarAccess.getBookCategoryAccess().getBiographyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:259:6: ( ( 'Mystery' ) )
                    {
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:259:6: ( ( 'Mystery' ) )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:260:1: ( 'Mystery' )
                    {
                     before(grammarAccess.getBookCategoryAccess().getMysteryEnumLiteralDeclaration_1()); 
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:261:1: ( 'Mystery' )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:261:3: 'Mystery'
                    {
                    match(input,12,FOLLOW_12_in_rule__BookCategory__Alternatives495); 

                    }

                     after(grammarAccess.getBookCategoryAccess().getMysteryEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:266:6: ( ( 'ScienceFiction' ) )
                    {
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:266:6: ( ( 'ScienceFiction' ) )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:267:1: ( 'ScienceFiction' )
                    {
                     before(grammarAccess.getBookCategoryAccess().getScienceFictionEnumLiteralDeclaration_2()); 
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:268:1: ( 'ScienceFiction' )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:268:3: 'ScienceFiction'
                    {
                    match(input,13,FOLLOW_13_in_rule__BookCategory__Alternatives516); 

                    }

                     after(grammarAccess.getBookCategoryAccess().getScienceFictionEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BookCategory__Alternatives"


    // $ANTLR start "rule__Library__Group__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:280:1: rule__Library__Group__0 : rule__Library__Group__0__Impl rule__Library__Group__1 ;
    public final void rule__Library__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:284:1: ( rule__Library__Group__0__Impl rule__Library__Group__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:285:2: rule__Library__Group__0__Impl rule__Library__Group__1
            {
            pushFollow(FOLLOW_rule__Library__Group__0__Impl_in_rule__Library__Group__0549);
            rule__Library__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Library__Group__1_in_rule__Library__Group__0552);
            rule__Library__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__0"


    // $ANTLR start "rule__Library__Group__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:292:1: rule__Library__Group__0__Impl : ( 'library' ) ;
    public final void rule__Library__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:296:1: ( ( 'library' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:297:1: ( 'library' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:297:1: ( 'library' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:298:1: 'library'
            {
             before(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__Library__Group__0__Impl580); 
             after(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__0__Impl"


    // $ANTLR start "rule__Library__Group__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:311:1: rule__Library__Group__1 : rule__Library__Group__1__Impl rule__Library__Group__2 ;
    public final void rule__Library__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:315:1: ( rule__Library__Group__1__Impl rule__Library__Group__2 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:316:2: rule__Library__Group__1__Impl rule__Library__Group__2
            {
            pushFollow(FOLLOW_rule__Library__Group__1__Impl_in_rule__Library__Group__1611);
            rule__Library__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Library__Group__2_in_rule__Library__Group__1614);
            rule__Library__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__1"


    // $ANTLR start "rule__Library__Group__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:323:1: rule__Library__Group__1__Impl : ( ( rule__Library__NameAssignment_1 ) ) ;
    public final void rule__Library__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:327:1: ( ( ( rule__Library__NameAssignment_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:328:1: ( ( rule__Library__NameAssignment_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:328:1: ( ( rule__Library__NameAssignment_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:329:1: ( rule__Library__NameAssignment_1 )
            {
             before(grammarAccess.getLibraryAccess().getNameAssignment_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:330:1: ( rule__Library__NameAssignment_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:330:2: rule__Library__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__1__Impl641);
            rule__Library__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLibraryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__1__Impl"


    // $ANTLR start "rule__Library__Group__2"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:340:1: rule__Library__Group__2 : rule__Library__Group__2__Impl rule__Library__Group__3 ;
    public final void rule__Library__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:344:1: ( rule__Library__Group__2__Impl rule__Library__Group__3 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:345:2: rule__Library__Group__2__Impl rule__Library__Group__3
            {
            pushFollow(FOLLOW_rule__Library__Group__2__Impl_in_rule__Library__Group__2671);
            rule__Library__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Library__Group__3_in_rule__Library__Group__2674);
            rule__Library__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__2"


    // $ANTLR start "rule__Library__Group__2__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:352:1: rule__Library__Group__2__Impl : ( '{' ) ;
    public final void rule__Library__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:356:1: ( ( '{' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:357:1: ( '{' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:357:1: ( '{' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:358:1: '{'
            {
             before(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__Library__Group__2__Impl702); 
             after(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__2__Impl"


    // $ANTLR start "rule__Library__Group__3"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:371:1: rule__Library__Group__3 : rule__Library__Group__3__Impl rule__Library__Group__4 ;
    public final void rule__Library__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:375:1: ( rule__Library__Group__3__Impl rule__Library__Group__4 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:376:2: rule__Library__Group__3__Impl rule__Library__Group__4
            {
            pushFollow(FOLLOW_rule__Library__Group__3__Impl_in_rule__Library__Group__3733);
            rule__Library__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Library__Group__4_in_rule__Library__Group__3736);
            rule__Library__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__3"


    // $ANTLR start "rule__Library__Group__3__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:383:1: rule__Library__Group__3__Impl : ( ( rule__Library__Group_3__0 ) ) ;
    public final void rule__Library__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:387:1: ( ( ( rule__Library__Group_3__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:388:1: ( ( rule__Library__Group_3__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:388:1: ( ( rule__Library__Group_3__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:389:1: ( rule__Library__Group_3__0 )
            {
             before(grammarAccess.getLibraryAccess().getGroup_3()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:390:1: ( rule__Library__Group_3__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:390:2: rule__Library__Group_3__0
            {
            pushFollow(FOLLOW_rule__Library__Group_3__0_in_rule__Library__Group__3__Impl763);
            rule__Library__Group_3__0();

            state._fsp--;


            }

             after(grammarAccess.getLibraryAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__3__Impl"


    // $ANTLR start "rule__Library__Group__4"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:400:1: rule__Library__Group__4 : rule__Library__Group__4__Impl ;
    public final void rule__Library__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:404:1: ( rule__Library__Group__4__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:405:2: rule__Library__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Library__Group__4__Impl_in_rule__Library__Group__4793);
            rule__Library__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__4"


    // $ANTLR start "rule__Library__Group__4__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:411:1: rule__Library__Group__4__Impl : ( '}' ) ;
    public final void rule__Library__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:415:1: ( ( '}' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:416:1: ( '}' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:416:1: ( '}' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:417:1: '}'
            {
             before(grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_4()); 
            match(input,16,FOLLOW_16_in_rule__Library__Group__4__Impl821); 
             after(grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group__4__Impl"


    // $ANTLR start "rule__Library__Group_3__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:440:1: rule__Library__Group_3__0 : rule__Library__Group_3__0__Impl rule__Library__Group_3__1 ;
    public final void rule__Library__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:444:1: ( rule__Library__Group_3__0__Impl rule__Library__Group_3__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:445:2: rule__Library__Group_3__0__Impl rule__Library__Group_3__1
            {
            pushFollow(FOLLOW_rule__Library__Group_3__0__Impl_in_rule__Library__Group_3__0862);
            rule__Library__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Library__Group_3__1_in_rule__Library__Group_3__0865);
            rule__Library__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3__0"


    // $ANTLR start "rule__Library__Group_3__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:452:1: rule__Library__Group_3__0__Impl : ( ( rule__Library__Group_3_0__0 )* ) ;
    public final void rule__Library__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:456:1: ( ( ( rule__Library__Group_3_0__0 )* ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:457:1: ( ( rule__Library__Group_3_0__0 )* )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:457:1: ( ( rule__Library__Group_3_0__0 )* )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:458:1: ( rule__Library__Group_3_0__0 )*
            {
             before(grammarAccess.getLibraryAccess().getGroup_3_0()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:459:1: ( rule__Library__Group_3_0__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:459:2: rule__Library__Group_3_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Library__Group_3_0__0_in_rule__Library__Group_3__0__Impl892);
            	    rule__Library__Group_3_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getLibraryAccess().getGroup_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3__0__Impl"


    // $ANTLR start "rule__Library__Group_3__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:469:1: rule__Library__Group_3__1 : rule__Library__Group_3__1__Impl ;
    public final void rule__Library__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:473:1: ( rule__Library__Group_3__1__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:474:2: rule__Library__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Library__Group_3__1__Impl_in_rule__Library__Group_3__1923);
            rule__Library__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3__1"


    // $ANTLR start "rule__Library__Group_3__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:480:1: rule__Library__Group_3__1__Impl : ( ( rule__Library__Group_3_1__0 )* ) ;
    public final void rule__Library__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:484:1: ( ( ( rule__Library__Group_3_1__0 )* ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:485:1: ( ( rule__Library__Group_3_1__0 )* )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:485:1: ( ( rule__Library__Group_3_1__0 )* )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:486:1: ( rule__Library__Group_3_1__0 )*
            {
             before(grammarAccess.getLibraryAccess().getGroup_3_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:487:1: ( rule__Library__Group_3_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:487:2: rule__Library__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Library__Group_3_1__0_in_rule__Library__Group_3__1__Impl950);
            	    rule__Library__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getLibraryAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3__1__Impl"


    // $ANTLR start "rule__Library__Group_3_0__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:501:1: rule__Library__Group_3_0__0 : rule__Library__Group_3_0__0__Impl rule__Library__Group_3_0__1 ;
    public final void rule__Library__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:505:1: ( rule__Library__Group_3_0__0__Impl rule__Library__Group_3_0__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:506:2: rule__Library__Group_3_0__0__Impl rule__Library__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__Library__Group_3_0__0__Impl_in_rule__Library__Group_3_0__0985);
            rule__Library__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Library__Group_3_0__1_in_rule__Library__Group_3_0__0988);
            rule__Library__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3_0__0"


    // $ANTLR start "rule__Library__Group_3_0__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:513:1: rule__Library__Group_3_0__0__Impl : ( 'book' ) ;
    public final void rule__Library__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:517:1: ( ( 'book' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:518:1: ( 'book' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:518:1: ( 'book' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:519:1: 'book'
            {
             before(grammarAccess.getLibraryAccess().getBookKeyword_3_0_0()); 
            match(input,17,FOLLOW_17_in_rule__Library__Group_3_0__0__Impl1016); 
             after(grammarAccess.getLibraryAccess().getBookKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3_0__0__Impl"


    // $ANTLR start "rule__Library__Group_3_0__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:532:1: rule__Library__Group_3_0__1 : rule__Library__Group_3_0__1__Impl ;
    public final void rule__Library__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:536:1: ( rule__Library__Group_3_0__1__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:537:2: rule__Library__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Library__Group_3_0__1__Impl_in_rule__Library__Group_3_0__11047);
            rule__Library__Group_3_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3_0__1"


    // $ANTLR start "rule__Library__Group_3_0__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:543:1: rule__Library__Group_3_0__1__Impl : ( ( rule__Library__BooksAssignment_3_0_1 ) ) ;
    public final void rule__Library__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:547:1: ( ( ( rule__Library__BooksAssignment_3_0_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:548:1: ( ( rule__Library__BooksAssignment_3_0_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:548:1: ( ( rule__Library__BooksAssignment_3_0_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:549:1: ( rule__Library__BooksAssignment_3_0_1 )
            {
             before(grammarAccess.getLibraryAccess().getBooksAssignment_3_0_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:550:1: ( rule__Library__BooksAssignment_3_0_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:550:2: rule__Library__BooksAssignment_3_0_1
            {
            pushFollow(FOLLOW_rule__Library__BooksAssignment_3_0_1_in_rule__Library__Group_3_0__1__Impl1074);
            rule__Library__BooksAssignment_3_0_1();

            state._fsp--;


            }

             after(grammarAccess.getLibraryAccess().getBooksAssignment_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3_0__1__Impl"


    // $ANTLR start "rule__Library__Group_3_1__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:564:1: rule__Library__Group_3_1__0 : rule__Library__Group_3_1__0__Impl rule__Library__Group_3_1__1 ;
    public final void rule__Library__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:568:1: ( rule__Library__Group_3_1__0__Impl rule__Library__Group_3_1__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:569:2: rule__Library__Group_3_1__0__Impl rule__Library__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Library__Group_3_1__0__Impl_in_rule__Library__Group_3_1__01108);
            rule__Library__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Library__Group_3_1__1_in_rule__Library__Group_3_1__01111);
            rule__Library__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3_1__0"


    // $ANTLR start "rule__Library__Group_3_1__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:576:1: rule__Library__Group_3_1__0__Impl : ( 'author' ) ;
    public final void rule__Library__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:580:1: ( ( 'author' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:581:1: ( 'author' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:581:1: ( 'author' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:582:1: 'author'
            {
             before(grammarAccess.getLibraryAccess().getAuthorKeyword_3_1_0()); 
            match(input,18,FOLLOW_18_in_rule__Library__Group_3_1__0__Impl1139); 
             after(grammarAccess.getLibraryAccess().getAuthorKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3_1__0__Impl"


    // $ANTLR start "rule__Library__Group_3_1__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:595:1: rule__Library__Group_3_1__1 : rule__Library__Group_3_1__1__Impl ;
    public final void rule__Library__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:599:1: ( rule__Library__Group_3_1__1__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:600:2: rule__Library__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Library__Group_3_1__1__Impl_in_rule__Library__Group_3_1__11170);
            rule__Library__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3_1__1"


    // $ANTLR start "rule__Library__Group_3_1__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:606:1: rule__Library__Group_3_1__1__Impl : ( ( rule__Library__AuthorsAssignment_3_1_1 ) ) ;
    public final void rule__Library__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:610:1: ( ( ( rule__Library__AuthorsAssignment_3_1_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:611:1: ( ( rule__Library__AuthorsAssignment_3_1_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:611:1: ( ( rule__Library__AuthorsAssignment_3_1_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:612:1: ( rule__Library__AuthorsAssignment_3_1_1 )
            {
             before(grammarAccess.getLibraryAccess().getAuthorsAssignment_3_1_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:613:1: ( rule__Library__AuthorsAssignment_3_1_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:613:2: rule__Library__AuthorsAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__Library__AuthorsAssignment_3_1_1_in_rule__Library__Group_3_1__1__Impl1197);
            rule__Library__AuthorsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLibraryAccess().getAuthorsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__Group_3_1__1__Impl"


    // $ANTLR start "rule__Author__Group__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:627:1: rule__Author__Group__0 : rule__Author__Group__0__Impl rule__Author__Group__1 ;
    public final void rule__Author__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:631:1: ( rule__Author__Group__0__Impl rule__Author__Group__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:632:2: rule__Author__Group__0__Impl rule__Author__Group__1
            {
            pushFollow(FOLLOW_rule__Author__Group__0__Impl_in_rule__Author__Group__01231);
            rule__Author__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Author__Group__1_in_rule__Author__Group__01234);
            rule__Author__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__0"


    // $ANTLR start "rule__Author__Group__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:639:1: rule__Author__Group__0__Impl : ( 'author' ) ;
    public final void rule__Author__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:643:1: ( ( 'author' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:644:1: ( 'author' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:644:1: ( 'author' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:645:1: 'author'
            {
             before(grammarAccess.getAuthorAccess().getAuthorKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__Author__Group__0__Impl1262); 
             after(grammarAccess.getAuthorAccess().getAuthorKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__0__Impl"


    // $ANTLR start "rule__Author__Group__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:658:1: rule__Author__Group__1 : rule__Author__Group__1__Impl rule__Author__Group__2 ;
    public final void rule__Author__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:662:1: ( rule__Author__Group__1__Impl rule__Author__Group__2 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:663:2: rule__Author__Group__1__Impl rule__Author__Group__2
            {
            pushFollow(FOLLOW_rule__Author__Group__1__Impl_in_rule__Author__Group__11293);
            rule__Author__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Author__Group__2_in_rule__Author__Group__11296);
            rule__Author__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__1"


    // $ANTLR start "rule__Author__Group__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:670:1: rule__Author__Group__1__Impl : ( ( rule__Author__NameAssignment_1 ) ) ;
    public final void rule__Author__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:674:1: ( ( ( rule__Author__NameAssignment_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:675:1: ( ( rule__Author__NameAssignment_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:675:1: ( ( rule__Author__NameAssignment_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:676:1: ( rule__Author__NameAssignment_1 )
            {
             before(grammarAccess.getAuthorAccess().getNameAssignment_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:677:1: ( rule__Author__NameAssignment_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:677:2: rule__Author__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Author__NameAssignment_1_in_rule__Author__Group__1__Impl1323);
            rule__Author__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAuthorAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__1__Impl"


    // $ANTLR start "rule__Author__Group__2"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:687:1: rule__Author__Group__2 : rule__Author__Group__2__Impl rule__Author__Group__3 ;
    public final void rule__Author__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:691:1: ( rule__Author__Group__2__Impl rule__Author__Group__3 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:692:2: rule__Author__Group__2__Impl rule__Author__Group__3
            {
            pushFollow(FOLLOW_rule__Author__Group__2__Impl_in_rule__Author__Group__21353);
            rule__Author__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Author__Group__3_in_rule__Author__Group__21356);
            rule__Author__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__2"


    // $ANTLR start "rule__Author__Group__2__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:699:1: rule__Author__Group__2__Impl : ( '{' ) ;
    public final void rule__Author__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:703:1: ( ( '{' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:704:1: ( '{' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:704:1: ( '{' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:705:1: '{'
            {
             before(grammarAccess.getAuthorAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__Author__Group__2__Impl1384); 
             after(grammarAccess.getAuthorAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__2__Impl"


    // $ANTLR start "rule__Author__Group__3"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:718:1: rule__Author__Group__3 : rule__Author__Group__3__Impl rule__Author__Group__4 ;
    public final void rule__Author__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:722:1: ( rule__Author__Group__3__Impl rule__Author__Group__4 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:723:2: rule__Author__Group__3__Impl rule__Author__Group__4
            {
            pushFollow(FOLLOW_rule__Author__Group__3__Impl_in_rule__Author__Group__31415);
            rule__Author__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Author__Group__4_in_rule__Author__Group__31418);
            rule__Author__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__3"


    // $ANTLR start "rule__Author__Group__3__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:730:1: rule__Author__Group__3__Impl : ( ( rule__Author__Group_3__0 ) ) ;
    public final void rule__Author__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:734:1: ( ( ( rule__Author__Group_3__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:735:1: ( ( rule__Author__Group_3__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:735:1: ( ( rule__Author__Group_3__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:736:1: ( rule__Author__Group_3__0 )
            {
             before(grammarAccess.getAuthorAccess().getGroup_3()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:737:1: ( rule__Author__Group_3__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:737:2: rule__Author__Group_3__0
            {
            pushFollow(FOLLOW_rule__Author__Group_3__0_in_rule__Author__Group__3__Impl1445);
            rule__Author__Group_3__0();

            state._fsp--;


            }

             after(grammarAccess.getAuthorAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__3__Impl"


    // $ANTLR start "rule__Author__Group__4"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:747:1: rule__Author__Group__4 : rule__Author__Group__4__Impl ;
    public final void rule__Author__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:751:1: ( rule__Author__Group__4__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:752:2: rule__Author__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Author__Group__4__Impl_in_rule__Author__Group__41475);
            rule__Author__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__4"


    // $ANTLR start "rule__Author__Group__4__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:758:1: rule__Author__Group__4__Impl : ( '}' ) ;
    public final void rule__Author__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:762:1: ( ( '}' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:763:1: ( '}' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:763:1: ( '}' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:764:1: '}'
            {
             before(grammarAccess.getAuthorAccess().getRightCurlyBracketKeyword_4()); 
            match(input,16,FOLLOW_16_in_rule__Author__Group__4__Impl1503); 
             after(grammarAccess.getAuthorAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group__4__Impl"


    // $ANTLR start "rule__Author__Group_3__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:787:1: rule__Author__Group_3__0 : rule__Author__Group_3__0__Impl rule__Author__Group_3__1 ;
    public final void rule__Author__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:791:1: ( rule__Author__Group_3__0__Impl rule__Author__Group_3__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:792:2: rule__Author__Group_3__0__Impl rule__Author__Group_3__1
            {
            pushFollow(FOLLOW_rule__Author__Group_3__0__Impl_in_rule__Author__Group_3__01544);
            rule__Author__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Author__Group_3__1_in_rule__Author__Group_3__01547);
            rule__Author__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3__0"


    // $ANTLR start "rule__Author__Group_3__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:799:1: rule__Author__Group_3__0__Impl : ( 'name' ) ;
    public final void rule__Author__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:803:1: ( ( 'name' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:804:1: ( 'name' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:804:1: ( 'name' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:805:1: 'name'
            {
             before(grammarAccess.getAuthorAccess().getNameKeyword_3_0()); 
            match(input,19,FOLLOW_19_in_rule__Author__Group_3__0__Impl1575); 
             after(grammarAccess.getAuthorAccess().getNameKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3__0__Impl"


    // $ANTLR start "rule__Author__Group_3__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:818:1: rule__Author__Group_3__1 : rule__Author__Group_3__1__Impl rule__Author__Group_3__2 ;
    public final void rule__Author__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:822:1: ( rule__Author__Group_3__1__Impl rule__Author__Group_3__2 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:823:2: rule__Author__Group_3__1__Impl rule__Author__Group_3__2
            {
            pushFollow(FOLLOW_rule__Author__Group_3__1__Impl_in_rule__Author__Group_3__11606);
            rule__Author__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Author__Group_3__2_in_rule__Author__Group_3__11609);
            rule__Author__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3__1"


    // $ANTLR start "rule__Author__Group_3__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:830:1: rule__Author__Group_3__1__Impl : ( ( rule__Author__FullNameAssignment_3_1 ) ) ;
    public final void rule__Author__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:834:1: ( ( ( rule__Author__FullNameAssignment_3_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:835:1: ( ( rule__Author__FullNameAssignment_3_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:835:1: ( ( rule__Author__FullNameAssignment_3_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:836:1: ( rule__Author__FullNameAssignment_3_1 )
            {
             before(grammarAccess.getAuthorAccess().getFullNameAssignment_3_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:837:1: ( rule__Author__FullNameAssignment_3_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:837:2: rule__Author__FullNameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Author__FullNameAssignment_3_1_in_rule__Author__Group_3__1__Impl1636);
            rule__Author__FullNameAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getAuthorAccess().getFullNameAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3__1__Impl"


    // $ANTLR start "rule__Author__Group_3__2"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:847:1: rule__Author__Group_3__2 : rule__Author__Group_3__2__Impl ;
    public final void rule__Author__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:851:1: ( rule__Author__Group_3__2__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:852:2: rule__Author__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Author__Group_3__2__Impl_in_rule__Author__Group_3__21666);
            rule__Author__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3__2"


    // $ANTLR start "rule__Author__Group_3__2__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:858:1: rule__Author__Group_3__2__Impl : ( ( rule__Author__Group_3_2__0 )* ) ;
    public final void rule__Author__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:862:1: ( ( ( rule__Author__Group_3_2__0 )* ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:863:1: ( ( rule__Author__Group_3_2__0 )* )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:863:1: ( ( rule__Author__Group_3_2__0 )* )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:864:1: ( rule__Author__Group_3_2__0 )*
            {
             before(grammarAccess.getAuthorAccess().getGroup_3_2()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:865:1: ( rule__Author__Group_3_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:865:2: rule__Author__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Author__Group_3_2__0_in_rule__Author__Group_3__2__Impl1693);
            	    rule__Author__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getAuthorAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3__2__Impl"


    // $ANTLR start "rule__Author__Group_3_2__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:881:1: rule__Author__Group_3_2__0 : rule__Author__Group_3_2__0__Impl rule__Author__Group_3_2__1 ;
    public final void rule__Author__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:885:1: ( rule__Author__Group_3_2__0__Impl rule__Author__Group_3_2__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:886:2: rule__Author__Group_3_2__0__Impl rule__Author__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__Author__Group_3_2__0__Impl_in_rule__Author__Group_3_2__01730);
            rule__Author__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Author__Group_3_2__1_in_rule__Author__Group_3_2__01733);
            rule__Author__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3_2__0"


    // $ANTLR start "rule__Author__Group_3_2__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:893:1: rule__Author__Group_3_2__0__Impl : ( 'book' ) ;
    public final void rule__Author__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:897:1: ( ( 'book' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:898:1: ( 'book' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:898:1: ( 'book' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:899:1: 'book'
            {
             before(grammarAccess.getAuthorAccess().getBookKeyword_3_2_0()); 
            match(input,17,FOLLOW_17_in_rule__Author__Group_3_2__0__Impl1761); 
             after(grammarAccess.getAuthorAccess().getBookKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3_2__0__Impl"


    // $ANTLR start "rule__Author__Group_3_2__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:912:1: rule__Author__Group_3_2__1 : rule__Author__Group_3_2__1__Impl ;
    public final void rule__Author__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:916:1: ( rule__Author__Group_3_2__1__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:917:2: rule__Author__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Author__Group_3_2__1__Impl_in_rule__Author__Group_3_2__11792);
            rule__Author__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3_2__1"


    // $ANTLR start "rule__Author__Group_3_2__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:923:1: rule__Author__Group_3_2__1__Impl : ( ( rule__Author__BooksAssignment_3_2_1 ) ) ;
    public final void rule__Author__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:927:1: ( ( ( rule__Author__BooksAssignment_3_2_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:928:1: ( ( rule__Author__BooksAssignment_3_2_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:928:1: ( ( rule__Author__BooksAssignment_3_2_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:929:1: ( rule__Author__BooksAssignment_3_2_1 )
            {
             before(grammarAccess.getAuthorAccess().getBooksAssignment_3_2_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:930:1: ( rule__Author__BooksAssignment_3_2_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:930:2: rule__Author__BooksAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__Author__BooksAssignment_3_2_1_in_rule__Author__Group_3_2__1__Impl1819);
            rule__Author__BooksAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAuthorAccess().getBooksAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__Group_3_2__1__Impl"


    // $ANTLR start "rule__Book__Group__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:944:1: rule__Book__Group__0 : rule__Book__Group__0__Impl rule__Book__Group__1 ;
    public final void rule__Book__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:948:1: ( rule__Book__Group__0__Impl rule__Book__Group__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:949:2: rule__Book__Group__0__Impl rule__Book__Group__1
            {
            pushFollow(FOLLOW_rule__Book__Group__0__Impl_in_rule__Book__Group__01853);
            rule__Book__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group__1_in_rule__Book__Group__01856);
            rule__Book__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__0"


    // $ANTLR start "rule__Book__Group__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:956:1: rule__Book__Group__0__Impl : ( 'book' ) ;
    public final void rule__Book__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:960:1: ( ( 'book' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:961:1: ( 'book' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:961:1: ( 'book' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:962:1: 'book'
            {
             before(grammarAccess.getBookAccess().getBookKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Book__Group__0__Impl1884); 
             after(grammarAccess.getBookAccess().getBookKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__0__Impl"


    // $ANTLR start "rule__Book__Group__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:975:1: rule__Book__Group__1 : rule__Book__Group__1__Impl rule__Book__Group__2 ;
    public final void rule__Book__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:979:1: ( rule__Book__Group__1__Impl rule__Book__Group__2 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:980:2: rule__Book__Group__1__Impl rule__Book__Group__2
            {
            pushFollow(FOLLOW_rule__Book__Group__1__Impl_in_rule__Book__Group__11915);
            rule__Book__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group__2_in_rule__Book__Group__11918);
            rule__Book__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__1"


    // $ANTLR start "rule__Book__Group__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:987:1: rule__Book__Group__1__Impl : ( ( rule__Book__NameAssignment_1 ) ) ;
    public final void rule__Book__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:991:1: ( ( ( rule__Book__NameAssignment_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:992:1: ( ( rule__Book__NameAssignment_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:992:1: ( ( rule__Book__NameAssignment_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:993:1: ( rule__Book__NameAssignment_1 )
            {
             before(grammarAccess.getBookAccess().getNameAssignment_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:994:1: ( rule__Book__NameAssignment_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:994:2: rule__Book__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Book__NameAssignment_1_in_rule__Book__Group__1__Impl1945);
            rule__Book__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBookAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__1__Impl"


    // $ANTLR start "rule__Book__Group__2"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1004:1: rule__Book__Group__2 : rule__Book__Group__2__Impl rule__Book__Group__3 ;
    public final void rule__Book__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1008:1: ( rule__Book__Group__2__Impl rule__Book__Group__3 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1009:2: rule__Book__Group__2__Impl rule__Book__Group__3
            {
            pushFollow(FOLLOW_rule__Book__Group__2__Impl_in_rule__Book__Group__21975);
            rule__Book__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group__3_in_rule__Book__Group__21978);
            rule__Book__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__2"


    // $ANTLR start "rule__Book__Group__2__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1016:1: rule__Book__Group__2__Impl : ( '{' ) ;
    public final void rule__Book__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1020:1: ( ( '{' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1021:1: ( '{' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1021:1: ( '{' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1022:1: '{'
            {
             before(grammarAccess.getBookAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__Book__Group__2__Impl2006); 
             after(grammarAccess.getBookAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__2__Impl"


    // $ANTLR start "rule__Book__Group__3"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1035:1: rule__Book__Group__3 : rule__Book__Group__3__Impl rule__Book__Group__4 ;
    public final void rule__Book__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1039:1: ( rule__Book__Group__3__Impl rule__Book__Group__4 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1040:2: rule__Book__Group__3__Impl rule__Book__Group__4
            {
            pushFollow(FOLLOW_rule__Book__Group__3__Impl_in_rule__Book__Group__32037);
            rule__Book__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group__4_in_rule__Book__Group__32040);
            rule__Book__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__3"


    // $ANTLR start "rule__Book__Group__3__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1047:1: rule__Book__Group__3__Impl : ( ( rule__Book__Group_3__0 ) ) ;
    public final void rule__Book__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1051:1: ( ( ( rule__Book__Group_3__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1052:1: ( ( rule__Book__Group_3__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1052:1: ( ( rule__Book__Group_3__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1053:1: ( rule__Book__Group_3__0 )
            {
             before(grammarAccess.getBookAccess().getGroup_3()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1054:1: ( rule__Book__Group_3__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1054:2: rule__Book__Group_3__0
            {
            pushFollow(FOLLOW_rule__Book__Group_3__0_in_rule__Book__Group__3__Impl2067);
            rule__Book__Group_3__0();

            state._fsp--;


            }

             after(grammarAccess.getBookAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__3__Impl"


    // $ANTLR start "rule__Book__Group__4"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1064:1: rule__Book__Group__4 : rule__Book__Group__4__Impl ;
    public final void rule__Book__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1068:1: ( rule__Book__Group__4__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1069:2: rule__Book__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Book__Group__4__Impl_in_rule__Book__Group__42097);
            rule__Book__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__4"


    // $ANTLR start "rule__Book__Group__4__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1075:1: rule__Book__Group__4__Impl : ( '}' ) ;
    public final void rule__Book__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1079:1: ( ( '}' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1080:1: ( '}' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1080:1: ( '}' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1081:1: '}'
            {
             before(grammarAccess.getBookAccess().getRightCurlyBracketKeyword_4()); 
            match(input,16,FOLLOW_16_in_rule__Book__Group__4__Impl2125); 
             after(grammarAccess.getBookAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group__4__Impl"


    // $ANTLR start "rule__Book__Group_3__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1104:1: rule__Book__Group_3__0 : rule__Book__Group_3__0__Impl rule__Book__Group_3__1 ;
    public final void rule__Book__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1108:1: ( rule__Book__Group_3__0__Impl rule__Book__Group_3__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1109:2: rule__Book__Group_3__0__Impl rule__Book__Group_3__1
            {
            pushFollow(FOLLOW_rule__Book__Group_3__0__Impl_in_rule__Book__Group_3__02166);
            rule__Book__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group_3__1_in_rule__Book__Group_3__02169);
            rule__Book__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__0"


    // $ANTLR start "rule__Book__Group_3__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1116:1: rule__Book__Group_3__0__Impl : ( 'title' ) ;
    public final void rule__Book__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1120:1: ( ( 'title' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1121:1: ( 'title' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1121:1: ( 'title' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1122:1: 'title'
            {
             before(grammarAccess.getBookAccess().getTitleKeyword_3_0()); 
            match(input,20,FOLLOW_20_in_rule__Book__Group_3__0__Impl2197); 
             after(grammarAccess.getBookAccess().getTitleKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__0__Impl"


    // $ANTLR start "rule__Book__Group_3__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1135:1: rule__Book__Group_3__1 : rule__Book__Group_3__1__Impl rule__Book__Group_3__2 ;
    public final void rule__Book__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1139:1: ( rule__Book__Group_3__1__Impl rule__Book__Group_3__2 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1140:2: rule__Book__Group_3__1__Impl rule__Book__Group_3__2
            {
            pushFollow(FOLLOW_rule__Book__Group_3__1__Impl_in_rule__Book__Group_3__12228);
            rule__Book__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group_3__2_in_rule__Book__Group_3__12231);
            rule__Book__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__1"


    // $ANTLR start "rule__Book__Group_3__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1147:1: rule__Book__Group_3__1__Impl : ( ( rule__Book__TitleAssignment_3_1 ) ) ;
    public final void rule__Book__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1151:1: ( ( ( rule__Book__TitleAssignment_3_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1152:1: ( ( rule__Book__TitleAssignment_3_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1152:1: ( ( rule__Book__TitleAssignment_3_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1153:1: ( rule__Book__TitleAssignment_3_1 )
            {
             before(grammarAccess.getBookAccess().getTitleAssignment_3_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1154:1: ( rule__Book__TitleAssignment_3_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1154:2: rule__Book__TitleAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Book__TitleAssignment_3_1_in_rule__Book__Group_3__1__Impl2258);
            rule__Book__TitleAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getBookAccess().getTitleAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__1__Impl"


    // $ANTLR start "rule__Book__Group_3__2"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1164:1: rule__Book__Group_3__2 : rule__Book__Group_3__2__Impl rule__Book__Group_3__3 ;
    public final void rule__Book__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1168:1: ( rule__Book__Group_3__2__Impl rule__Book__Group_3__3 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1169:2: rule__Book__Group_3__2__Impl rule__Book__Group_3__3
            {
            pushFollow(FOLLOW_rule__Book__Group_3__2__Impl_in_rule__Book__Group_3__22288);
            rule__Book__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group_3__3_in_rule__Book__Group_3__22291);
            rule__Book__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__2"


    // $ANTLR start "rule__Book__Group_3__2__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1176:1: rule__Book__Group_3__2__Impl : ( ( rule__Book__Group_3_2__0 )? ) ;
    public final void rule__Book__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1180:1: ( ( ( rule__Book__Group_3_2__0 )? ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1181:1: ( ( rule__Book__Group_3_2__0 )? )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1181:1: ( ( rule__Book__Group_3_2__0 )? )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1182:1: ( rule__Book__Group_3_2__0 )?
            {
             before(grammarAccess.getBookAccess().getGroup_3_2()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1183:1: ( rule__Book__Group_3_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1183:2: rule__Book__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__Book__Group_3_2__0_in_rule__Book__Group_3__2__Impl2318);
                    rule__Book__Group_3_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBookAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__2__Impl"


    // $ANTLR start "rule__Book__Group_3__3"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1193:1: rule__Book__Group_3__3 : rule__Book__Group_3__3__Impl rule__Book__Group_3__4 ;
    public final void rule__Book__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1197:1: ( rule__Book__Group_3__3__Impl rule__Book__Group_3__4 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1198:2: rule__Book__Group_3__3__Impl rule__Book__Group_3__4
            {
            pushFollow(FOLLOW_rule__Book__Group_3__3__Impl_in_rule__Book__Group_3__32349);
            rule__Book__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group_3__4_in_rule__Book__Group_3__32352);
            rule__Book__Group_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__3"


    // $ANTLR start "rule__Book__Group_3__3__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1205:1: rule__Book__Group_3__3__Impl : ( ( rule__Book__Group_3_3__0 )? ) ;
    public final void rule__Book__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1209:1: ( ( ( rule__Book__Group_3_3__0 )? ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1210:1: ( ( rule__Book__Group_3_3__0 )? )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1210:1: ( ( rule__Book__Group_3_3__0 )? )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1211:1: ( rule__Book__Group_3_3__0 )?
            {
             before(grammarAccess.getBookAccess().getGroup_3_3()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1212:1: ( rule__Book__Group_3_3__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1212:2: rule__Book__Group_3_3__0
                    {
                    pushFollow(FOLLOW_rule__Book__Group_3_3__0_in_rule__Book__Group_3__3__Impl2379);
                    rule__Book__Group_3_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBookAccess().getGroup_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__3__Impl"


    // $ANTLR start "rule__Book__Group_3__4"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1222:1: rule__Book__Group_3__4 : rule__Book__Group_3__4__Impl ;
    public final void rule__Book__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1226:1: ( rule__Book__Group_3__4__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1227:2: rule__Book__Group_3__4__Impl
            {
            pushFollow(FOLLOW_rule__Book__Group_3__4__Impl_in_rule__Book__Group_3__42410);
            rule__Book__Group_3__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__4"


    // $ANTLR start "rule__Book__Group_3__4__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1233:1: rule__Book__Group_3__4__Impl : ( ( rule__Book__Group_3_4__0 )* ) ;
    public final void rule__Book__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1237:1: ( ( ( rule__Book__Group_3_4__0 )* ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1238:1: ( ( rule__Book__Group_3_4__0 )* )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1238:1: ( ( rule__Book__Group_3_4__0 )* )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1239:1: ( rule__Book__Group_3_4__0 )*
            {
             before(grammarAccess.getBookAccess().getGroup_3_4()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1240:1: ( rule__Book__Group_3_4__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1240:2: rule__Book__Group_3_4__0
            	    {
            	    pushFollow(FOLLOW_rule__Book__Group_3_4__0_in_rule__Book__Group_3__4__Impl2437);
            	    rule__Book__Group_3_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getBookAccess().getGroup_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3__4__Impl"


    // $ANTLR start "rule__Book__Group_3_2__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1260:1: rule__Book__Group_3_2__0 : rule__Book__Group_3_2__0__Impl rule__Book__Group_3_2__1 ;
    public final void rule__Book__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1264:1: ( rule__Book__Group_3_2__0__Impl rule__Book__Group_3_2__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1265:2: rule__Book__Group_3_2__0__Impl rule__Book__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__Book__Group_3_2__0__Impl_in_rule__Book__Group_3_2__02478);
            rule__Book__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group_3_2__1_in_rule__Book__Group_3_2__02481);
            rule__Book__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_2__0"


    // $ANTLR start "rule__Book__Group_3_2__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1272:1: rule__Book__Group_3_2__0__Impl : ( 'page' ) ;
    public final void rule__Book__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1276:1: ( ( 'page' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1277:1: ( 'page' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1277:1: ( 'page' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1278:1: 'page'
            {
             before(grammarAccess.getBookAccess().getPageKeyword_3_2_0()); 
            match(input,21,FOLLOW_21_in_rule__Book__Group_3_2__0__Impl2509); 
             after(grammarAccess.getBookAccess().getPageKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_2__0__Impl"


    // $ANTLR start "rule__Book__Group_3_2__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1291:1: rule__Book__Group_3_2__1 : rule__Book__Group_3_2__1__Impl ;
    public final void rule__Book__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1295:1: ( rule__Book__Group_3_2__1__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1296:2: rule__Book__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Book__Group_3_2__1__Impl_in_rule__Book__Group_3_2__12540);
            rule__Book__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_2__1"


    // $ANTLR start "rule__Book__Group_3_2__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1302:1: rule__Book__Group_3_2__1__Impl : ( ( rule__Book__PagesAssignment_3_2_1 ) ) ;
    public final void rule__Book__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1306:1: ( ( ( rule__Book__PagesAssignment_3_2_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1307:1: ( ( rule__Book__PagesAssignment_3_2_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1307:1: ( ( rule__Book__PagesAssignment_3_2_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1308:1: ( rule__Book__PagesAssignment_3_2_1 )
            {
             before(grammarAccess.getBookAccess().getPagesAssignment_3_2_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1309:1: ( rule__Book__PagesAssignment_3_2_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1309:2: rule__Book__PagesAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__Book__PagesAssignment_3_2_1_in_rule__Book__Group_3_2__1__Impl2567);
            rule__Book__PagesAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getBookAccess().getPagesAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_2__1__Impl"


    // $ANTLR start "rule__Book__Group_3_3__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1323:1: rule__Book__Group_3_3__0 : rule__Book__Group_3_3__0__Impl rule__Book__Group_3_3__1 ;
    public final void rule__Book__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1327:1: ( rule__Book__Group_3_3__0__Impl rule__Book__Group_3_3__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1328:2: rule__Book__Group_3_3__0__Impl rule__Book__Group_3_3__1
            {
            pushFollow(FOLLOW_rule__Book__Group_3_3__0__Impl_in_rule__Book__Group_3_3__02601);
            rule__Book__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group_3_3__1_in_rule__Book__Group_3_3__02604);
            rule__Book__Group_3_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_3__0"


    // $ANTLR start "rule__Book__Group_3_3__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1335:1: rule__Book__Group_3_3__0__Impl : ( 'category' ) ;
    public final void rule__Book__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1339:1: ( ( 'category' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1340:1: ( 'category' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1340:1: ( 'category' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1341:1: 'category'
            {
             before(grammarAccess.getBookAccess().getCategoryKeyword_3_3_0()); 
            match(input,22,FOLLOW_22_in_rule__Book__Group_3_3__0__Impl2632); 
             after(grammarAccess.getBookAccess().getCategoryKeyword_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_3__0__Impl"


    // $ANTLR start "rule__Book__Group_3_3__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1354:1: rule__Book__Group_3_3__1 : rule__Book__Group_3_3__1__Impl ;
    public final void rule__Book__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1358:1: ( rule__Book__Group_3_3__1__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1359:2: rule__Book__Group_3_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Book__Group_3_3__1__Impl_in_rule__Book__Group_3_3__12663);
            rule__Book__Group_3_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_3__1"


    // $ANTLR start "rule__Book__Group_3_3__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1365:1: rule__Book__Group_3_3__1__Impl : ( ( rule__Book__CategoryAssignment_3_3_1 ) ) ;
    public final void rule__Book__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1369:1: ( ( ( rule__Book__CategoryAssignment_3_3_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1370:1: ( ( rule__Book__CategoryAssignment_3_3_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1370:1: ( ( rule__Book__CategoryAssignment_3_3_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1371:1: ( rule__Book__CategoryAssignment_3_3_1 )
            {
             before(grammarAccess.getBookAccess().getCategoryAssignment_3_3_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1372:1: ( rule__Book__CategoryAssignment_3_3_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1372:2: rule__Book__CategoryAssignment_3_3_1
            {
            pushFollow(FOLLOW_rule__Book__CategoryAssignment_3_3_1_in_rule__Book__Group_3_3__1__Impl2690);
            rule__Book__CategoryAssignment_3_3_1();

            state._fsp--;


            }

             after(grammarAccess.getBookAccess().getCategoryAssignment_3_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_3__1__Impl"


    // $ANTLR start "rule__Book__Group_3_4__0"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1386:1: rule__Book__Group_3_4__0 : rule__Book__Group_3_4__0__Impl rule__Book__Group_3_4__1 ;
    public final void rule__Book__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1390:1: ( rule__Book__Group_3_4__0__Impl rule__Book__Group_3_4__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1391:2: rule__Book__Group_3_4__0__Impl rule__Book__Group_3_4__1
            {
            pushFollow(FOLLOW_rule__Book__Group_3_4__0__Impl_in_rule__Book__Group_3_4__02724);
            rule__Book__Group_3_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Book__Group_3_4__1_in_rule__Book__Group_3_4__02727);
            rule__Book__Group_3_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_4__0"


    // $ANTLR start "rule__Book__Group_3_4__0__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1398:1: rule__Book__Group_3_4__0__Impl : ( 'author' ) ;
    public final void rule__Book__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1402:1: ( ( 'author' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1403:1: ( 'author' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1403:1: ( 'author' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1404:1: 'author'
            {
             before(grammarAccess.getBookAccess().getAuthorKeyword_3_4_0()); 
            match(input,18,FOLLOW_18_in_rule__Book__Group_3_4__0__Impl2755); 
             after(grammarAccess.getBookAccess().getAuthorKeyword_3_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_4__0__Impl"


    // $ANTLR start "rule__Book__Group_3_4__1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1417:1: rule__Book__Group_3_4__1 : rule__Book__Group_3_4__1__Impl ;
    public final void rule__Book__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1421:1: ( rule__Book__Group_3_4__1__Impl )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1422:2: rule__Book__Group_3_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Book__Group_3_4__1__Impl_in_rule__Book__Group_3_4__12786);
            rule__Book__Group_3_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_4__1"


    // $ANTLR start "rule__Book__Group_3_4__1__Impl"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1428:1: rule__Book__Group_3_4__1__Impl : ( ( rule__Book__AuthorsAssignment_3_4_1 ) ) ;
    public final void rule__Book__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1432:1: ( ( ( rule__Book__AuthorsAssignment_3_4_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1433:1: ( ( rule__Book__AuthorsAssignment_3_4_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1433:1: ( ( rule__Book__AuthorsAssignment_3_4_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1434:1: ( rule__Book__AuthorsAssignment_3_4_1 )
            {
             before(grammarAccess.getBookAccess().getAuthorsAssignment_3_4_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1435:1: ( rule__Book__AuthorsAssignment_3_4_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1435:2: rule__Book__AuthorsAssignment_3_4_1
            {
            pushFollow(FOLLOW_rule__Book__AuthorsAssignment_3_4_1_in_rule__Book__Group_3_4__1__Impl2813);
            rule__Book__AuthorsAssignment_3_4_1();

            state._fsp--;


            }

             after(grammarAccess.getBookAccess().getAuthorsAssignment_3_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__Group_3_4__1__Impl"


    // $ANTLR start "rule__DomainModel__ElementsAssignment"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1450:1: rule__DomainModel__ElementsAssignment : ( ruleModelElement ) ;
    public final void rule__DomainModel__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1454:1: ( ( ruleModelElement ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1455:1: ( ruleModelElement )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1455:1: ( ruleModelElement )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1456:1: ruleModelElement
            {
             before(grammarAccess.getDomainModelAccess().getElementsModelElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleModelElement_in_rule__DomainModel__ElementsAssignment2852);
            ruleModelElement();

            state._fsp--;

             after(grammarAccess.getDomainModelAccess().getElementsModelElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DomainModel__ElementsAssignment"


    // $ANTLR start "rule__Library__NameAssignment_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1465:1: rule__Library__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Library__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1469:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1470:1: ( RULE_ID )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1470:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1471:1: RULE_ID
            {
             before(grammarAccess.getLibraryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Library__NameAssignment_12883); 
             after(grammarAccess.getLibraryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__NameAssignment_1"


    // $ANTLR start "rule__Library__BooksAssignment_3_0_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1480:1: rule__Library__BooksAssignment_3_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Library__BooksAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1484:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1485:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1485:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1486:1: ( RULE_ID )
            {
             before(grammarAccess.getLibraryAccess().getBooksBookCrossReference_3_0_1_0()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1487:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1488:1: RULE_ID
            {
             before(grammarAccess.getLibraryAccess().getBooksBookIDTerminalRuleCall_3_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Library__BooksAssignment_3_0_12918); 
             after(grammarAccess.getLibraryAccess().getBooksBookIDTerminalRuleCall_3_0_1_0_1()); 

            }

             after(grammarAccess.getLibraryAccess().getBooksBookCrossReference_3_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__BooksAssignment_3_0_1"


    // $ANTLR start "rule__Library__AuthorsAssignment_3_1_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1499:1: rule__Library__AuthorsAssignment_3_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Library__AuthorsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1503:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1504:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1504:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1505:1: ( RULE_ID )
            {
             before(grammarAccess.getLibraryAccess().getAuthorsAuthorCrossReference_3_1_1_0()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1506:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1507:1: RULE_ID
            {
             before(grammarAccess.getLibraryAccess().getAuthorsAuthorIDTerminalRuleCall_3_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Library__AuthorsAssignment_3_1_12957); 
             after(grammarAccess.getLibraryAccess().getAuthorsAuthorIDTerminalRuleCall_3_1_1_0_1()); 

            }

             after(grammarAccess.getLibraryAccess().getAuthorsAuthorCrossReference_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Library__AuthorsAssignment_3_1_1"


    // $ANTLR start "rule__Author__NameAssignment_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1518:1: rule__Author__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Author__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1522:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1523:1: ( RULE_ID )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1523:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1524:1: RULE_ID
            {
             before(grammarAccess.getAuthorAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Author__NameAssignment_12992); 
             after(grammarAccess.getAuthorAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__NameAssignment_1"


    // $ANTLR start "rule__Author__FullNameAssignment_3_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1533:1: rule__Author__FullNameAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Author__FullNameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1537:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1538:1: ( RULE_STRING )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1538:1: ( RULE_STRING )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1539:1: RULE_STRING
            {
             before(grammarAccess.getAuthorAccess().getFullNameSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Author__FullNameAssignment_3_13023); 
             after(grammarAccess.getAuthorAccess().getFullNameSTRINGTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__FullNameAssignment_3_1"


    // $ANTLR start "rule__Author__BooksAssignment_3_2_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1548:1: rule__Author__BooksAssignment_3_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Author__BooksAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1552:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1553:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1553:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1554:1: ( RULE_ID )
            {
             before(grammarAccess.getAuthorAccess().getBooksBookCrossReference_3_2_1_0()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1555:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1556:1: RULE_ID
            {
             before(grammarAccess.getAuthorAccess().getBooksBookIDTerminalRuleCall_3_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Author__BooksAssignment_3_2_13058); 
             after(grammarAccess.getAuthorAccess().getBooksBookIDTerminalRuleCall_3_2_1_0_1()); 

            }

             after(grammarAccess.getAuthorAccess().getBooksBookCrossReference_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Author__BooksAssignment_3_2_1"


    // $ANTLR start "rule__Book__NameAssignment_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1567:1: rule__Book__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Book__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1571:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1572:1: ( RULE_ID )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1572:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1573:1: RULE_ID
            {
             before(grammarAccess.getBookAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Book__NameAssignment_13093); 
             after(grammarAccess.getBookAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__NameAssignment_1"


    // $ANTLR start "rule__Book__TitleAssignment_3_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1582:1: rule__Book__TitleAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Book__TitleAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1586:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1587:1: ( RULE_STRING )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1587:1: ( RULE_STRING )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1588:1: RULE_STRING
            {
             before(grammarAccess.getBookAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Book__TitleAssignment_3_13124); 
             after(grammarAccess.getBookAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__TitleAssignment_3_1"


    // $ANTLR start "rule__Book__PagesAssignment_3_2_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1597:1: rule__Book__PagesAssignment_3_2_1 : ( RULE_INT ) ;
    public final void rule__Book__PagesAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1601:1: ( ( RULE_INT ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1602:1: ( RULE_INT )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1602:1: ( RULE_INT )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1603:1: RULE_INT
            {
             before(grammarAccess.getBookAccess().getPagesINTTerminalRuleCall_3_2_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Book__PagesAssignment_3_2_13155); 
             after(grammarAccess.getBookAccess().getPagesINTTerminalRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__PagesAssignment_3_2_1"


    // $ANTLR start "rule__Book__CategoryAssignment_3_3_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1612:1: rule__Book__CategoryAssignment_3_3_1 : ( ruleBookCategory ) ;
    public final void rule__Book__CategoryAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1616:1: ( ( ruleBookCategory ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1617:1: ( ruleBookCategory )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1617:1: ( ruleBookCategory )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1618:1: ruleBookCategory
            {
             before(grammarAccess.getBookAccess().getCategoryBookCategoryEnumRuleCall_3_3_1_0()); 
            pushFollow(FOLLOW_ruleBookCategory_in_rule__Book__CategoryAssignment_3_3_13186);
            ruleBookCategory();

            state._fsp--;

             after(grammarAccess.getBookAccess().getCategoryBookCategoryEnumRuleCall_3_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__CategoryAssignment_3_3_1"


    // $ANTLR start "rule__Book__AuthorsAssignment_3_4_1"
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1627:1: rule__Book__AuthorsAssignment_3_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Book__AuthorsAssignment_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1631:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1632:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1632:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1633:1: ( RULE_ID )
            {
             before(grammarAccess.getBookAccess().getAuthorsAuthorCrossReference_3_4_1_0()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1634:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalMyDsl.g:1635:1: RULE_ID
            {
             before(grammarAccess.getBookAccess().getAuthorsAuthorIDTerminalRuleCall_3_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Book__AuthorsAssignment_3_4_13221); 
             after(grammarAccess.getBookAccess().getAuthorsAuthorIDTerminalRuleCall_3_4_1_0_1()); 

            }

             after(grammarAccess.getBookAccess().getAuthorsAuthorCrossReference_3_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Book__AuthorsAssignment_3_4_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleDomainModel_in_entryRuleDomainModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomainModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DomainModel__ElementsAssignment_in_ruleDomainModel94 = new BitSet(new long[]{0x0000000000064002L});
    public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElement129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElement__Alternatives_in_ruleModelElement155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLibrary_in_entryRuleLibrary182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLibrary189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group__0_in_ruleLibrary215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAuthor_in_entryRuleAuthor242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAuthor249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group__0_in_ruleAuthor275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBook_in_entryRuleBook302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBook309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group__0_in_ruleBook335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BookCategory__Alternatives_in_ruleBookCategory372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLibrary_in_rule__ModelElement__Alternatives407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAuthor_in_rule__ModelElement__Alternatives424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBook_in_rule__ModelElement__Alternatives441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BookCategory__Alternatives474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BookCategory__Alternatives495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__BookCategory__Alternatives516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group__0__Impl_in_rule__Library__Group__0549 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Library__Group__1_in_rule__Library__Group__0552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Library__Group__0__Impl580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group__1__Impl_in_rule__Library__Group__1611 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Library__Group__2_in_rule__Library__Group__1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__1__Impl641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group__2__Impl_in_rule__Library__Group__2671 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__Library__Group__3_in_rule__Library__Group__2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Library__Group__2__Impl702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group__3__Impl_in_rule__Library__Group__3733 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Library__Group__4_in_rule__Library__Group__3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group_3__0_in_rule__Library__Group__3__Impl763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group__4__Impl_in_rule__Library__Group__4793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Library__Group__4__Impl821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group_3__0__Impl_in_rule__Library__Group_3__0862 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__Library__Group_3__1_in_rule__Library__Group_3__0865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group_3_0__0_in_rule__Library__Group_3__0__Impl892 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Library__Group_3__1__Impl_in_rule__Library__Group_3__1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group_3_1__0_in_rule__Library__Group_3__1__Impl950 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Library__Group_3_0__0__Impl_in_rule__Library__Group_3_0__0985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Library__Group_3_0__1_in_rule__Library__Group_3_0__0988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Library__Group_3_0__0__Impl1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group_3_0__1__Impl_in_rule__Library__Group_3_0__11047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__BooksAssignment_3_0_1_in_rule__Library__Group_3_0__1__Impl1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group_3_1__0__Impl_in_rule__Library__Group_3_1__01108 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Library__Group_3_1__1_in_rule__Library__Group_3_1__01111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Library__Group_3_1__0__Impl1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__Group_3_1__1__Impl_in_rule__Library__Group_3_1__11170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Library__AuthorsAssignment_3_1_1_in_rule__Library__Group_3_1__1__Impl1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group__0__Impl_in_rule__Author__Group__01231 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Author__Group__1_in_rule__Author__Group__01234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Author__Group__0__Impl1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group__1__Impl_in_rule__Author__Group__11293 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Author__Group__2_in_rule__Author__Group__11296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__NameAssignment_1_in_rule__Author__Group__1__Impl1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group__2__Impl_in_rule__Author__Group__21353 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Author__Group__3_in_rule__Author__Group__21356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Author__Group__2__Impl1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group__3__Impl_in_rule__Author__Group__31415 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Author__Group__4_in_rule__Author__Group__31418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group_3__0_in_rule__Author__Group__3__Impl1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group__4__Impl_in_rule__Author__Group__41475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Author__Group__4__Impl1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group_3__0__Impl_in_rule__Author__Group_3__01544 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Author__Group_3__1_in_rule__Author__Group_3__01547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Author__Group_3__0__Impl1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group_3__1__Impl_in_rule__Author__Group_3__11606 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Author__Group_3__2_in_rule__Author__Group_3__11609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__FullNameAssignment_3_1_in_rule__Author__Group_3__1__Impl1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group_3__2__Impl_in_rule__Author__Group_3__21666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group_3_2__0_in_rule__Author__Group_3__2__Impl1693 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Author__Group_3_2__0__Impl_in_rule__Author__Group_3_2__01730 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Author__Group_3_2__1_in_rule__Author__Group_3_2__01733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Author__Group_3_2__0__Impl1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__Group_3_2__1__Impl_in_rule__Author__Group_3_2__11792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Author__BooksAssignment_3_2_1_in_rule__Author__Group_3_2__1__Impl1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group__0__Impl_in_rule__Book__Group__01853 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Book__Group__1_in_rule__Book__Group__01856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Book__Group__0__Impl1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group__1__Impl_in_rule__Book__Group__11915 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Book__Group__2_in_rule__Book__Group__11918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__NameAssignment_1_in_rule__Book__Group__1__Impl1945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group__2__Impl_in_rule__Book__Group__21975 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Book__Group__3_in_rule__Book__Group__21978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Book__Group__2__Impl2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group__3__Impl_in_rule__Book__Group__32037 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Book__Group__4_in_rule__Book__Group__32040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3__0_in_rule__Book__Group__3__Impl2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group__4__Impl_in_rule__Book__Group__42097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Book__Group__4__Impl2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3__0__Impl_in_rule__Book__Group_3__02166 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Book__Group_3__1_in_rule__Book__Group_3__02169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Book__Group_3__0__Impl2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3__1__Impl_in_rule__Book__Group_3__12228 = new BitSet(new long[]{0x0000000000640000L});
    public static final BitSet FOLLOW_rule__Book__Group_3__2_in_rule__Book__Group_3__12231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__TitleAssignment_3_1_in_rule__Book__Group_3__1__Impl2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3__2__Impl_in_rule__Book__Group_3__22288 = new BitSet(new long[]{0x0000000000640000L});
    public static final BitSet FOLLOW_rule__Book__Group_3__3_in_rule__Book__Group_3__22291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3_2__0_in_rule__Book__Group_3__2__Impl2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3__3__Impl_in_rule__Book__Group_3__32349 = new BitSet(new long[]{0x0000000000640000L});
    public static final BitSet FOLLOW_rule__Book__Group_3__4_in_rule__Book__Group_3__32352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3_3__0_in_rule__Book__Group_3__3__Impl2379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3__4__Impl_in_rule__Book__Group_3__42410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3_4__0_in_rule__Book__Group_3__4__Impl2437 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Book__Group_3_2__0__Impl_in_rule__Book__Group_3_2__02478 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Book__Group_3_2__1_in_rule__Book__Group_3_2__02481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Book__Group_3_2__0__Impl2509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3_2__1__Impl_in_rule__Book__Group_3_2__12540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__PagesAssignment_3_2_1_in_rule__Book__Group_3_2__1__Impl2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3_3__0__Impl_in_rule__Book__Group_3_3__02601 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__Book__Group_3_3__1_in_rule__Book__Group_3_3__02604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Book__Group_3_3__0__Impl2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3_3__1__Impl_in_rule__Book__Group_3_3__12663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__CategoryAssignment_3_3_1_in_rule__Book__Group_3_3__1__Impl2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3_4__0__Impl_in_rule__Book__Group_3_4__02724 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Book__Group_3_4__1_in_rule__Book__Group_3_4__02727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Book__Group_3_4__0__Impl2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__Group_3_4__1__Impl_in_rule__Book__Group_3_4__12786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Book__AuthorsAssignment_3_4_1_in_rule__Book__Group_3_4__1__Impl2813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElement_in_rule__DomainModel__ElementsAssignment2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Library__NameAssignment_12883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Library__BooksAssignment_3_0_12918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Library__AuthorsAssignment_3_1_12957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Author__NameAssignment_12992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Author__FullNameAssignment_3_13023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Author__BooksAssignment_3_2_13058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Book__NameAssignment_13093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Book__TitleAssignment_3_13124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Book__PagesAssignment_3_2_13155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBookCategory_in_rule__Book__CategoryAssignment_3_3_13186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Book__AuthorsAssignment_3_4_13221 = new BitSet(new long[]{0x0000000000000002L});

}