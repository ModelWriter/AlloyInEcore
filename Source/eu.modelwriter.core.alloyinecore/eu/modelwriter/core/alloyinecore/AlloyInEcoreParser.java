// Generated from /home/ferhat/git/AlloyInEcore/Source/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.7
package eu.modelwriter.core.alloyinecore;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

import eu.modelwriter.core.alloyinecore.structure.base.INamespace;
import eu.modelwriter.core.alloyinecore.structure.base.Repository;
import eu.modelwriter.core.alloyinecore.structure.base.Element;

import eu.modelwriter.core.alloyinecore.structure.model.ModelElement;
import eu.modelwriter.core.alloyinecore.structure.model.Annotation;
import eu.modelwriter.core.alloyinecore.structure.model.AnnotationDetail;
import eu.modelwriter.core.alloyinecore.structure.model.AnnotationReference;
import eu.modelwriter.core.alloyinecore.structure.model.NamedElement;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.structure.model.EcoreImport;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import eu.modelwriter.core.alloyinecore.structure.model.RootPackage;
import eu.modelwriter.core.alloyinecore.structure.model.Classifier;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Interface;
import eu.modelwriter.core.alloyinecore.structure.model.DataType;
import eu.modelwriter.core.alloyinecore.structure.model.Enum;
import eu.modelwriter.core.alloyinecore.structure.model.EnumLiteral;
import eu.modelwriter.core.alloyinecore.structure.model.StructuralFeature;
import eu.modelwriter.core.alloyinecore.structure.model.TypedElement;
import eu.modelwriter.core.alloyinecore.structure.model.Multiplicity;
import eu.modelwriter.core.alloyinecore.structure.model.Reference;
import eu.modelwriter.core.alloyinecore.structure.model.Attribute;
import eu.modelwriter.core.alloyinecore.structure.model.Operation;
import eu.modelwriter.core.alloyinecore.structure.model.Parameter;
import eu.modelwriter.core.alloyinecore.structure.model.GenericException;
import eu.modelwriter.core.alloyinecore.structure.model.TypeParameter;
import eu.modelwriter.core.alloyinecore.structure.model.GenericType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericTypeArgument;
import eu.modelwriter.core.alloyinecore.structure.model.GenericElementType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericSuperType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericWildcard;
import eu.modelwriter.core.alloyinecore.structure.model.PrimitiveType;
import eu.modelwriter.core.alloyinecore.structure.model.Invariant;
import eu.modelwriter.core.alloyinecore.structure.model.Derivation;
import eu.modelwriter.core.alloyinecore.structure.model.Body;
import eu.modelwriter.core.alloyinecore.structure.model.PostCondition;
import eu.modelwriter.core.alloyinecore.structure.model.PreCondition;
import eu.modelwriter.core.alloyinecore.structure.model.Initial;
import eu.modelwriter.core.alloyinecore.structure.model.Reason;

import eu.modelwriter.core.alloyinecore.structure.instance.ModelImport;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.instance.Slot;
import eu.modelwriter.core.alloyinecore.structure.instance.ObjectValue;
import eu.modelwriter.core.alloyinecore.structure.instance.EnumValue;
import eu.modelwriter.core.alloyinecore.structure.instance.IntegerValue;
import eu.modelwriter.core.alloyinecore.structure.instance.RealValue;
import eu.modelwriter.core.alloyinecore.structure.instance.BooleanValue;
import eu.modelwriter.core.alloyinecore.structure.instance.StringValue;
import eu.modelwriter.core.alloyinecore.structure.instance.NullValue;

import eu.modelwriter.core.alloyinecore.structure.constraints.Formula;
import eu.modelwriter.core.alloyinecore.structure.constraints.Expression;
import eu.modelwriter.core.alloyinecore.structure.constraints.IntExpression;
import eu.modelwriter.core.alloyinecore.structure.constraints.QuantifierDeclaration;
import eu.modelwriter.core.alloyinecore.structure.constraints.LetDeclaration;
import eu.modelwriter.core.alloyinecore.structure.constraints.ComprehensionDeclaration;
import eu.modelwriter.core.alloyinecore.structure.constraints.Variable;

import eu.modelwriter.core.alloyinecore.internal.AnnotationSources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import java.io.IOException;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlloyInEcoreParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, T__92=93, T__93=94, 
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, T__100=101, 
		T__101=102, T__102=103, T__103=104, T__104=105, T__105=106, T__106=107, 
		T__107=108, T__108=109, T__109=110, T__110=111, T__111=112, T__112=113, 
		T__113=114, T__114=115, T__115=116, T__116=117, T__117=118, T__118=119, 
		T__119=120, T__120=121, T__121=122, T__122=123, T__123=124, T__124=125, 
		T__125=126, T__126=127, T__127=128, T__128=129, T__129=130, T__130=131, 
		T__131=132, T__132=133, T__133=134, T__134=135, T__135=136, T__136=137, 
		T__137=138, T__138=139, T__139=140, T__140=141, T__141=142, T__142=143, 
		T__143=144, T__144=145, T__145=146, T__146=147, T__147=148, T__148=149, 
		T__149=150, T__150=151, T__151=152, INT=153, IDENTIFIER=154, DOUBLE_QUOTED_STRING=155, 
		SINGLE_QUOTED_STRING=156, ML_SINGLE_QUOTED_STRING=157, MULTILINE_COMMENT=158, 
		SINGLELINE_COMMENT=159, WS=160;
	public static final int
		RULE_options = 0, RULE_option = 1, RULE_instance = 2, RULE_modelImport = 3, 
		RULE_eObject = 4, RULE_slot = 5, RULE_dataValue = 6, RULE_multiValueData = 7, 
		RULE_eObjectValue = 8, RULE_literalValue = 9, RULE_enumValue = 10, RULE_booleanValue = 11, 
		RULE_integerValue = 12, RULE_realValue = 13, RULE_stringValue = 14, RULE_nullValue = 15, 
		RULE_model = 16, RULE_packageImport = 17, RULE_ePackage = 18, RULE_eClassifier = 19, 
		RULE_eClass = 20, RULE_eStructuralFeature = 21, RULE_eAttribute = 22, 
		RULE_eReference = 23, RULE_eOperation = 24, RULE_eGenericException = 25, 
		RULE_eGenericSuperType = 26, RULE_eParameter = 27, RULE_eMultiplicity = 28, 
		RULE_eDataType = 29, RULE_eEnum = 30, RULE_eEnumLiteral = 31, RULE_eAnnotation = 32, 
		RULE_eDetail = 33, RULE_eModelElement = 34, RULE_eNamedElement = 35, RULE_eTypedElement = 36, 
		RULE_eModelElementRef = 37, RULE_templateSignature = 38, RULE_eTypeParameter = 39, 
		RULE_eGenericTypeArgument = 40, RULE_eGenericType = 41, RULE_eGenericElementType = 42, 
		RULE_eGenericWildcard = 43, RULE_pathName = 44, RULE_segment = 45, RULE_ePrimitiveType = 46, 
		RULE_body = 47, RULE_invariant = 48, RULE_reason = 49, RULE_precondition = 50, 
		RULE_postcondition = 51, RULE_initial = 52, RULE_derivation = 53, RULE_visibilityKind = 54, 
		RULE_formula = 55, RULE_expression = 56, RULE_intExpression = 57, RULE_quantifierDeclarations = 58, 
		RULE_quantifierDeclaration = 59, RULE_letDeclarations = 60, RULE_letDeclaration = 61, 
		RULE_comprehensionDeclarations = 62, RULE_comprehensionDeclaration = 63, 
		RULE_relationId = 64, RULE_variable = 65, RULE_mult = 66, RULE_unrestrictedName = 67, 
		RULE_identifier = 68, RULE_upper = 69, RULE_lower = 70;
	public static final String[] ruleNames = {
		"options", "option", "instance", "modelImport", "eObject", "slot", "dataValue", 
		"multiValueData", "eObjectValue", "literalValue", "enumValue", "booleanValue", 
		"integerValue", "realValue", "stringValue", "nullValue", "model", "packageImport", 
		"ePackage", "eClassifier", "eClass", "eStructuralFeature", "eAttribute", 
		"eReference", "eOperation", "eGenericException", "eGenericSuperType", 
		"eParameter", "eMultiplicity", "eDataType", "eEnum", "eEnumLiteral", "eAnnotation", 
		"eDetail", "eModelElement", "eNamedElement", "eTypedElement", "eModelElementRef", 
		"templateSignature", "eTypeParameter", "eGenericTypeArgument", "eGenericType", 
		"eGenericElementType", "eGenericWildcard", "pathName", "segment", "ePrimitiveType", 
		"body", "invariant", "reason", "precondition", "postcondition", "initial", 
		"derivation", "visibilityKind", "formula", "expression", "intExpression", 
		"quantifierDeclarations", "quantifierDeclaration", "letDeclarations", 
		"letDeclaration", "comprehensionDeclarations", "comprehensionDeclaration", 
		"relationId", "variable", "mult", "unrestrictedName", "identifier", "upper", 
		"lower"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'options'", "'{'", "','", "'}'", "'symmetry_breaking'", "':'", 
		"'bit_width'", "'skolem_depth'", "'sharing'", "'instance'", "';'", "'model'", 
		"'['", "']'", "'true'", "'false'", "'+'", "'-'", "'.'", "'null'", "'import'", 
		"'package'", "'='", "'abstract'", "'class'", "'interface'", "'one'", "'lone'", 
		"'some'", "'no'", "'extends'", "'('", "')'", "'static'", "'ghost'", "'transient'", 
		"'volatile'", "'readonly'", "'attribute'", "'derived'", "'id'", "'ordered'", 
		"'!ordered'", "'unique'", "'!unique'", "'unsettable'", "'!unsettable'", 
		"'property'", "'#'", "'composes'", "'acyclic'", "'transitive'", "'reflexive'", 
		"'irreflexive'", "'symmetric'", "'asymmetric'", "'antisymmetric'", "'total'", 
		"'functional'", "'surjective'", "'injective'", "'bijective'", "'complete'", 
		"'bijection'", "'preorder'", "'equivalence'", "'partialorder'", "'totalorder'", 
		"'resolve'", "'!resolve'", "'key'", "'operation'", "'throws'", "'..'", 
		"'*'", "'?'", "'|?'", "'|1'", "'primitive'", "'datatype'", "'serializable'", 
		"'!serializable'", "'enum'", "'literal'", "'annotation'", "'reference'", 
		"'<'", "'>'", "'&'", "'super'", "'::'", "'@'", "'Boolean'", "'Integer'", 
		"'String'", "'Real'", "'UnlimitedNatural'", "'body'", "'callable'", "'invariant'", 
		"'reason'", "'precondition'", "'requires'", "'postcondition'", "'ensures'", 
		"'initial'", "'derivation'", "'public'", "'protected'", "'private'", "'!'", 
		"'not'", "'in'", "'<='", "'>='", "'sum'", "'|'", "'function'", "'->'", 
		"'ord'", "'&&'", "'and'", "'||'", "'or'", "'=>'", "'implies'", "'<=>'", 
		"'iff'", "'all'", "'let'", "'~'", "'^'", "'++'", "'if'", "'then'", "'else'", 
		"'iden'", "'none'", "'univ'", "'ints'", "'plus'", "'minus'", "'mul'", 
		"'/'", "'div'", "'%'", "'modulo'", "'disj'", "'set'", "'definition'", 
		"'ensure'", "'require'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "INT", "IDENTIFIER", 
		"DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", "ML_SINGLE_QUOTED_STRING", 
		"MULTILINE_COMMENT", "SINGLELINE_COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AlloyInEcore.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public Model model;
	public Instance instance;
	private boolean resolveImports = true;

	Repository repository = new Repository();


	URI uri;

	public AlloyInEcoreParser(TokenStream input, URI uri){
	    this(input);
	    this.uri = uri;
	    repository = new Repository(uri);
	}

	public AlloyInEcoreParser(TokenStream input, URI uri, boolean resolveImports){
	    this(input, uri);
	    this.resolveImports = resolveImports;
	}


	public void saveResource(String filename, String path){
	    model.printTree();
	    repository.printNamespaces();
	    if (model.getOwnedPackage() != null) {
	        ResourceSet metaResourceSet = new ResourceSetImpl();
	        metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());
	        Resource metaResource = metaResourceSet.createResource(URI.createURI(path + filename + ".ecore"));
	        metaResource.getContents().add(model.getOwnedPackage().getEObject());
	        try {
	            metaResource.save(null);
	        } catch (java.io.IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}

	private String getContextText(ParserRuleContext ctx){
	    return getTokenStream().getTokenSource().getInputStream().toString().substring(ctx.start.getStartIndex(),ctx.stop.getStopIndex()+1);
	}


	private EcoreFactory eFactory = EcoreFactory.eINSTANCE;

	private void signalParsingCompletion() {
	    //restoreReferences();
	    //checkConstraints();
	}

	private void createEAnnotation(EModelElement owner, final String source) {
	    if (owner.getEAnnotation(source) != null)
	        return;
	    final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
	    eAnnotation.setSource(source);
	    owner.getEAnnotations().add(eAnnotation);
	}

	public java.util.Stack<String> declarations = new java.util.Stack<String>();
	private int declareVariables(java.util.List<VariableContext> vars, int var) {
	    for (VariableContext vc : vars) {
	        String s = vc.getText(); declarations.add(s); var++;
	    }
	    return var;
	}


	public AlloyInEcoreParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class OptionsContext extends ParserRuleContext {
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public OptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionsContext options() throws RecognitionException {
		OptionsContext _localctx = new OptionsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__0);
			setState(143);
			match(T__1);
			setState(144);
			option();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(145);
				match(T__2);
				setState(146);
				option();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionContext extends ParserRuleContext {
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
	 
		public OptionContext() { }
		public void copyFrom(OptionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SymmetryBreakingContext extends OptionContext {
		public Token key;
		public Token value;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public SymmetryBreakingContext(OptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSymmetryBreaking(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSymmetryBreaking(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSymmetryBreaking(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitWidthContext extends OptionContext {
		public Token key;
		public Token value;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public BitWidthContext(OptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBitWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBitWidth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBitWidth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkolemDepthContext extends OptionContext {
		public Token key;
		public Token value;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public SkolemDepthContext(OptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSkolemDepth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSkolemDepth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSkolemDepth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SharingContext extends OptionContext {
		public Token key;
		public Token value;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public SharingContext(OptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSharing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSharing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSharing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_option);
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				((SymmetryBreakingContext)_localctx).key = match(T__4);
				setState(155);
				match(T__5);
				setState(156);
				((SymmetryBreakingContext)_localctx).value = match(INT);
				}
				break;
			case T__6:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				((BitWidthContext)_localctx).key = match(T__6);
				setState(158);
				match(T__5);
				setState(159);
				((BitWidthContext)_localctx).value = match(INT);
				}
				break;
			case T__7:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				((SkolemDepthContext)_localctx).key = match(T__7);
				setState(161);
				match(T__5);
				setState(162);
				((SkolemDepthContext)_localctx).value = match(INT);
				}
				break;
			case T__8:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				((SharingContext)_localctx).key = match(T__8);
				setState(164);
				match(T__5);
				setState(165);
				((SharingContext)_localctx).value = match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceContext extends ParserRuleContext {
		public Element owner;
		public Instance current;
		public IdentifierContext name;
		public EObjectContext rootObject;
		public ModelImportContext modelImport() {
			return getRuleContext(ModelImportContext.class,0);
		}
		public List<PackageImportContext> packageImport() {
			return getRuleContexts(PackageImportContext.class);
		}
		public PackageImportContext packageImport(int i) {
			return getRuleContext(PackageImportContext.class,i);
		}
		public EObjectContext eObject() {
			return getRuleContext(EObjectContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InstanceContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InstanceContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_instance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInstance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstanceContext instance(Element owner) throws RecognitionException {
		InstanceContext _localctx = new InstanceContext(_ctx, getState(), owner);
		enterRule(_localctx, 4, RULE_instance);
		((InstanceContext)_localctx).current =  new Instance(_localctx); instance= _localctx.current; if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(168);
				match(T__9);
				setState(169);
				((InstanceContext)_localctx).name = identifier();
				setState(170);
				match(T__10);
				}
			}

			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(174);
				packageImport(_localctx.current);
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
			modelImport(_localctx.current);
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__11:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__33:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__43:
			case T__45:
			case T__47:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__64:
			case T__65:
			case T__66:
			case T__67:
			case T__68:
			case T__70:
			case T__71:
			case T__72:
			case T__78:
			case T__79:
			case T__80:
			case T__82:
			case T__83:
			case T__84:
			case T__85:
			case T__97:
			case T__98:
			case T__99:
			case T__101:
			case T__103:
			case T__105:
			case T__106:
			case T__149:
			case T__150:
			case T__151:
			case IDENTIFIER:
				{
				setState(181);
				((InstanceContext)_localctx).rootObject = eObject(_localctx.current);
				}
				break;
			case T__10:
				{
				setState(182);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			instance.printTree();
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelImportContext extends ParserRuleContext {
		public Element owner;
		public ModelImport current;
		public EObject object;
		public UnrestrictedNameContext name;
		public Token ownedPathName;
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public ModelImportContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ModelImportContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_modelImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterModelImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitModelImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitModelImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelImportContext modelImport(Element owner) throws RecognitionException {
		ModelImportContext _localctx = new ModelImportContext(_ctx, getState(), owner);
		enterRule(_localctx, 6, RULE_modelImport);
		((ModelImportContext)_localctx).current =  new ModelImport(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(185);
			match(T__11);
			}
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (T__149 - 150)) | (1L << (T__150 - 150)) | (1L << (T__151 - 150)) | (1L << (IDENTIFIER - 150)))) != 0)) {
				{
				setState(186);
				((ModelImportContext)_localctx).name = unrestrictedName();
				setState(187);
				match(T__5);
				}
			}

			setState(191);
			((ModelImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(192);
			match(T__10);
			}
			_ctx.stop = _input.LT(-1);

			if (((ModelImportContext)_localctx).ownedPathName != null) {
			    String path = ((ModelImportContext)_localctx).ownedPathName.getText().replace("'", "");
			    if (path.equals(EcorePackage.eNS_URI)) {
			        notifyErrorListeners(((ModelImportContext)_localctx).ownedPathName, "You cannot create an instance of ECore Model! Instead, create a model in the model editor!", null);
			    } else {
			        Resource resource = repository.loadResource(path);
			        if (resource == null) {
			            notifyErrorListeners(((ModelImportContext)_localctx).ownedPathName, "Import could not be resolved!", null);
			        }
			        else {
			            ((ModelImportContext)_localctx).object =  repository.loadResource(path).getContents().get(0);
			            if (_localctx.object instanceof ENamedElement) {
			                _localctx.current.setEObject(_localctx.object);
			                repository.name2Import.put(_localctx.current.getKey(), _localctx.current);
			                _localctx.current.loadNamespace(repository);
			            } else {
			                notifyErrorListeners(((ModelImportContext)_localctx).ownedPathName, "This is an instance, cannot be used as a model!", null);
			            }
			        }
			    }
			}

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EObjectContext extends ParserRuleContext {
		public Element owner;
		public Object current;
		public PathNameContext name;
		public LiteralValueContext id;
		public SlotContext slot;
		public List<SlotContext> slots = new ArrayList<SlotContext>();
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public List<SlotContext> slot() {
			return getRuleContexts(SlotContext.class);
		}
		public SlotContext slot(int i) {
			return getRuleContext(SlotContext.class,i);
		}
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public EObjectContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EObjectContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EObjectContext eObject(Element owner) throws RecognitionException {
		EObjectContext _localctx = new EObjectContext(_ctx, getState(), owner);
		enterRule(_localctx, 8, RULE_eObject);
		((EObjectContext)_localctx).current =  new Object(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			((EObjectContext)_localctx).name = pathName(_localctx.current);

			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0) || ((((_la - 153)) & ~0x3f) == 0 && ((1L << (_la - 153)) & ((1L << (INT - 153)) | (1L << (IDENTIFIER - 153)) | (1L << (DOUBLE_QUOTED_STRING - 153)))) != 0)) {
				{
				setState(196);
				((EObjectContext)_localctx).id = literalValue(_localctx.owner);
				}
			}


			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(200);
				match(T__1);
				setState(201);
				((EObjectContext)_localctx).slot = slot(_localctx.current);
				((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(202);
					match(T__2);
					setState(203);
					((EObjectContext)_localctx).slot = slot(_localctx.current);
					((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(209);
				match(T__3);
				}
				break;
			case T__10:
				{
				setState(211);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SlotContext extends ParserRuleContext {
		public Element owner;
		public Slot current;
		public UnrestrictedNameContext name;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public List<EObjectValueContext> eObjectValue() {
			return getRuleContexts(EObjectValueContext.class);
		}
		public EObjectValueContext eObjectValue(int i) {
			return getRuleContext(EObjectValueContext.class,i);
		}
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
		}
		public List<EObjectContext> eObject() {
			return getRuleContexts(EObjectContext.class);
		}
		public EObjectContext eObject(int i) {
			return getRuleContext(EObjectContext.class,i);
		}
		public SlotContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SlotContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_slot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSlot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSlot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSlot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotContext slot(Element owner) throws RecognitionException {
		SlotContext _localctx = new SlotContext(_ctx, getState(), owner);
		enterRule(_localctx, 10, RULE_slot);
		((SlotContext)_localctx).current =  new Slot(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			((SlotContext)_localctx).name = unrestrictedName();

			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(216);
				match(T__5);
				setState(239);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(217);
					if (!(true)) throw new FailedPredicateException(this, "true");
					setState(218);
					match(T__1);
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (T__149 - 150)) | (1L << (T__150 - 150)) | (1L << (T__151 - 150)) | (1L << (IDENTIFIER - 150)))) != 0)) {
						{
						{
						setState(219);
						eObject(_localctx.current);
						}
						}
						setState(224);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(225);
					match(T__3);
					}
					break;
				case 2:
					{
					setState(226);
					eObjectValue(_localctx.current);
					}
					break;
				case 3:
					{
					setState(227);
					match(T__12);
					setState(228);
					eObjectValue(_localctx.current);
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(229);
						match(T__2);
						setState(230);
						eObjectValue(_localctx.current);
						}
						}
						setState(235);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(236);
					match(T__13);
					}
					break;
				case 4:
					{
					setState(238);
					dataValue(_localctx.current);
					}
					break;
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataValueContext extends ParserRuleContext {
		public Element owner;
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public MultiValueDataContext multiValueData() {
			return getRuleContext(MultiValueDataContext.class,0);
		}
		public DataValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public DataValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_dataValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDataValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDataValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDataValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataValueContext dataValue(Element owner) throws RecognitionException {
		DataValueContext _localctx = new DataValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 12, RULE_dataValue);
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case INT:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				literalValue(_localctx.owner);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				multiValueData(_localctx.owner);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiValueDataContext extends ParserRuleContext {
		public Element owner;
		public List<DataValueContext> dataValue() {
			return getRuleContexts(DataValueContext.class);
		}
		public DataValueContext dataValue(int i) {
			return getRuleContext(DataValueContext.class,i);
		}
		public MultiValueDataContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public MultiValueDataContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_multiValueData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterMultiValueData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitMultiValueData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitMultiValueData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiValueDataContext multiValueData(Element owner) throws RecognitionException {
		MultiValueDataContext _localctx = new MultiValueDataContext(_ctx, getState(), owner);
		enterRule(_localctx, 14, RULE_multiValueData);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__12);
			setState(248);
			dataValue(_localctx.owner);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(249);
				match(T__2);
				setState(250);
				dataValue(_localctx.owner);
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EObjectValueContext extends ParserRuleContext {
		public Element owner;
		public ObjectValue current;
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public EObjectValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EObjectValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eObjectValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEObjectValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEObjectValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEObjectValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EObjectValueContext eObjectValue(Element owner) throws RecognitionException {
		EObjectValueContext _localctx = new EObjectValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 16, RULE_eObjectValue);
		((EObjectValueContext)_localctx).current =  new ObjectValue(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			pathName(_localctx.current);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralValueContext extends ParserRuleContext {
		public Element owner;
		public Element current;
		public EnumValueContext enumValue() {
			return getRuleContext(EnumValueContext.class,0);
		}
		public IntegerValueContext integerValue() {
			return getRuleContext(IntegerValueContext.class,0);
		}
		public RealValueContext realValue() {
			return getRuleContext(RealValueContext.class,0);
		}
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public NullValueContext nullValue() {
			return getRuleContext(NullValueContext.class,0);
		}
		public LiteralValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public LiteralValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralValueContext literalValue(Element owner) throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 18, RULE_literalValue);
		if(_localctx.parent instanceof EObjectContext) {} else { ((LiteralValueContext)_localctx).current =  _localctx.owner;} 
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				enumValue(_localctx.current);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				integerValue(_localctx.current);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				realValue(_localctx.current);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(263);
				stringValue(_localctx.current);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(264);
				booleanValue(_localctx.current);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(265);
				nullValue(_localctx.current);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumValueContext extends ParserRuleContext {
		public Element owner;
		public EnumValue current;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EnumValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_enumValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEnumValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEnumValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEnumValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumValueContext enumValue(Element owner) throws RecognitionException {
		EnumValueContext _localctx = new EnumValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 20, RULE_enumValue);
		((EnumValueContext)_localctx).current =  new EnumValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueContext extends ParserRuleContext {
		public Element owner;
		public BooleanValue current;
		public BooleanValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue(Element owner) throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 22, RULE_booleanValue);
		((BooleanValueContext)_localctx).current =  new BooleanValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerValueContext extends ParserRuleContext {
		public Element owner;
		public IntegerValue current;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public IntegerValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IntegerValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_integerValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIntegerValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIntegerValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIntegerValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerValueContext integerValue(Element owner) throws RecognitionException {
		IntegerValueContext _localctx = new IntegerValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 24, RULE_integerValue);
		((IntegerValueContext)_localctx).current =  new IntegerValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16 || _la==T__17) {
				{
				setState(272);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(275);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RealValueContext extends ParserRuleContext {
		public Element owner;
		public RealValue current;
		public List<TerminalNode> INT() { return getTokens(AlloyInEcoreParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(AlloyInEcoreParser.INT, i);
		}
		public RealValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RealValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_realValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterRealValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitRealValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitRealValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealValueContext realValue(Element owner) throws RecognitionException {
		RealValueContext _localctx = new RealValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 26, RULE_realValue);
		((RealValueContext)_localctx).current =  new RealValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16 || _la==T__17) {
				{
				setState(277);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(280);
				match(INT);
				}
			}

			setState(283);
			match(T__18);
			setState(284);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringValueContext extends ParserRuleContext {
		public Element owner;
		public StringValue current;
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public StringValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StringValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_stringValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringValueContext stringValue(Element owner) throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 28, RULE_stringValue);
		((StringValueContext)_localctx).current =  new StringValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(DOUBLE_QUOTED_STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullValueContext extends ParserRuleContext {
		public Element owner;
		public NullValue current;
		public NullValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public NullValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_nullValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterNullValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitNullValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitNullValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullValueContext nullValue(Element owner) throws RecognitionException {
		NullValueContext _localctx = new NullValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 30, RULE_nullValue);
		((NullValueContext)_localctx).current =  new NullValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__19);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public IdentifierContext name;
		public PackageImportContext packageImport;
		public List<PackageImportContext> ownedPackageImport = new ArrayList<PackageImportContext>();
		public EPackageContext ownedPackage;
		public EPackageContext ePackage;
		public OptionsContext options() {
			return getRuleContext(OptionsContext.class,0);
		}
		public EPackageContext ePackage() {
			return getRuleContext(EPackageContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<PackageImportContext> packageImport() {
			return getRuleContexts(PackageImportContext.class);
		}
		public PackageImportContext packageImport(int i) {
			return getRuleContext(PackageImportContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ModelContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelContext model(Element owner) throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState(), owner);
		enterRule(_localctx, 32, RULE_model);
		model = new Model(_localctx); ((ModelContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.MODULE);
		if (_localctx.owner != null) owner.addOwnedElement(model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(290);
				options();
				}
			}


			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(294);
				match(T__11);
				setState(295);
				((ModelContext)_localctx).name = identifier();
				setState(296);
				match(T__10);
				}
			}

			_localctx.element.getDetails().put("name", (((ModelContext)_localctx).name!=null?_input.getText(((ModelContext)_localctx).name.start,((ModelContext)_localctx).name.stop):null));
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(301);
				((ModelContext)_localctx).packageImport = packageImport(model);
				((ModelContext)_localctx).ownedPackageImport.add(((ModelContext)_localctx).packageImport);
				}
				}
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(307);
			((ModelContext)_localctx).ownedPackage = ((ModelContext)_localctx).ePackage = ePackage(model);
			((ModelContext)_localctx).ePackage.element.getEAnnotations().add(_localctx.element);
			}
			for(PackageImportContext ctx: _localctx.ownedPackageImport) {((ModelContext)_localctx).ePackage.element.getEAnnotations().add(ctx.element);}
			}
			_ctx.stop = _input.LT(-1);
			signalParsingCompletion();
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageImportContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public EObject object;
		public IdentifierContext name;
		public Token ownedPathName;
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PackageImportContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PackageImportContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_packageImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPackageImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPackageImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPackageImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageImportContext packageImport(Element owner) throws RecognitionException {
		PackageImportContext _localctx = new PackageImportContext(_ctx, getState(), owner);
		enterRule(_localctx, 34, RULE_packageImport);
		((PackageImportContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.IMPORT);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(312);
			match(T__20);
			}
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(313);
				((PackageImportContext)_localctx).name = identifier();
				setState(314);
				match(T__5);
				}
			}

			setState(318);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(319);
			match(T__10);
			_localctx.element.getDetails().put((((PackageImportContext)_localctx).name!=null?_input.getText(((PackageImportContext)_localctx).name.start,((PackageImportContext)_localctx).name.stop):null), ((PackageImportContext)_localctx).ownedPathName != null ? ((PackageImportContext)_localctx).ownedPathName.getText().replace("'", "") : null);
			}
			_ctx.stop = _input.LT(-1);

			if (((PackageImportContext)_localctx).ownedPathName != null) {
			    String path = ((PackageImportContext)_localctx).ownedPathName.getText().replace("'", "");
			    Import imported = null;
			    if (path.equals(EcorePackage.eNS_URI)) {
			        ((PackageImportContext)_localctx).object =  EcorePackage.eINSTANCE;
			        imported = new EcoreImport(_localctx.object, _localctx);
			        _localctx.owner.addOwnedElement(imported);
			        repository.name2Import.put(imported.getKey(), imported);
			        if (resolveImports) imported.loadNamespace(repository);
			    } else {
			        Resource resource = repository.loadResource(path);
			        if (resource == null) {
			            notifyErrorListeners(((PackageImportContext)_localctx).ownedPathName, "Import could not be resolved!", null);

			        } else {
			            ((PackageImportContext)_localctx).object =  repository.loadResource(path).getContents().get(0);
			            imported = new Import(_localctx.object, _localctx);
			            _localctx.owner.addOwnedElement(imported);
			            repository.name2Import.put(imported.getKey(), imported);
			            if (resolveImports) imported.loadNamespace(repository);
			        }
			    }
			}

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EPackageContext extends ParserRuleContext {
		public Element owner;
		public EPackage element;
		public Package current;
		public VisibilityKindContext visibility;
		public UnrestrictedNameContext name;
		public IdentifierContext nsPrefix;
		public Token nsURI;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EPackageContext ePackage;
		public List<EPackageContext> eSubPackages = new ArrayList<EPackageContext>();
		public EClassifierContext eClassifier;
		public List<EClassifierContext> eClassifiers = new ArrayList<EClassifierContext>();
		public InvariantContext invariant;
		public List<InvariantContext> eConstraints = new ArrayList<InvariantContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<EPackageContext> ePackage() {
			return getRuleContexts(EPackageContext.class);
		}
		public EPackageContext ePackage(int i) {
			return getRuleContext(EPackageContext.class,i);
		}
		public List<EClassifierContext> eClassifier() {
			return getRuleContexts(EClassifierContext.class);
		}
		public EClassifierContext eClassifier(int i) {
			return getRuleContext(EClassifierContext.class,i);
		}
		public List<InvariantContext> invariant() {
			return getRuleContexts(InvariantContext.class);
		}
		public InvariantContext invariant(int i) {
			return getRuleContext(InvariantContext.class,i);
		}
		public EPackageContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EPackageContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_ePackage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEPackage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEPackage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEPackage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EPackageContext ePackage(Element owner) throws RecognitionException {
		EPackageContext _localctx = new EPackageContext(_ctx, getState(), owner);
		enterRule(_localctx, 36, RULE_ePackage);

		((EPackageContext)_localctx).element =  eFactory.createEPackage();
		if(_localctx.parent instanceof ModelContext) {((EPackageContext)_localctx).current =  new RootPackage(_localctx.element, _localctx);}
		else {((EPackageContext)_localctx).current =  new Package(_localctx.element, _localctx);}
		owner.addOwnedElement(_localctx.current);

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(322);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EPackageContext)_localctx).visibility.element);
			setState(326);
			match(T__21);
			setState(327);
			((EPackageContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null));
			if(_localctx.parent instanceof ModelContext) {repository.name2Import.put(((RootPackage)_localctx.current).getKey(), (RootPackage)_localctx.current);}
			{
			setState(330);
			match(T__5);
			setState(331);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(333);
			match(T__22);
			setState(334);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			_localctx.element.setNsPrefix((((EPackageContext)_localctx).nsPrefix!=null?_input.getText(((EPackageContext)_localctx).nsPrefix.start,((EPackageContext)_localctx).nsPrefix.stop):null)); if(((EPackageContext)_localctx).nsURI != null) _localctx.element.setNsURI(((EPackageContext)_localctx).nsURI.getText().replace("'", ""));
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(337);
				match(T__1);
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (T__78 - 79)) | (1L << (T__79 - 79)) | (1L << (T__82 - 79)) | (1L << (T__84 - 79)) | (1L << (T__98 - 79)) | (1L << (T__99 - 79)) | (1L << (T__107 - 79)) | (1L << (T__108 - 79)) | (1L << (T__109 - 79)))) != 0)) {
					{
					setState(350);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(338);
						((EPackageContext)_localctx).eAnnotation = ((EPackageContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(341);
						((EPackageContext)_localctx).ePackage = ((EPackageContext)_localctx).ePackage = ePackage(_localctx.current);
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						_localctx.element.getESubpackages().add(((EPackageContext)_localctx).ePackage.element);
						}
						break;
					case 3:
						{
						setState(344);
						((EPackageContext)_localctx).eClassifier = ((EPackageContext)_localctx).eClassifier = eClassifier(_localctx.current);
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						if (((EPackageContext)_localctx).eClassifier.element != null) _localctx.element.getEClassifiers().add(((EPackageContext)_localctx).eClassifier.element);
						}
						break;
					case 4:
						{
						setState(347);
						((EPackageContext)_localctx).invariant = ((EPackageContext)_localctx).invariant = invariant(_localctx.current);
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(354);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(355);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(356);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EClassifierContext extends ParserRuleContext {
		public Element owner;
		public EClassifier element;
		public EClassContext eClass;
		public EDataTypeContext eDataType;
		public EEnumContext eEnum;
		public EClassContext eClass() {
			return getRuleContext(EClassContext.class,0);
		}
		public EDataTypeContext eDataType() {
			return getRuleContext(EDataTypeContext.class,0);
		}
		public EEnumContext eEnum() {
			return getRuleContext(EEnumContext.class,0);
		}
		public EClassifierContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EClassifierContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eClassifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEClassifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEClassifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEClassifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EClassifierContext eClassifier(Element owner) throws RecognitionException {
		EClassifierContext _localctx = new EClassifierContext(_ctx, getState(), owner);
		enterRule(_localctx, 38, RULE_eClassifier);
		try {
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				((EClassifierContext)_localctx).eClass = eClass(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eClass.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				((EClassifierContext)_localctx).eDataType = eDataType(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eDataType.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(365);
				((EClassifierContext)_localctx).eEnum = eEnum(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eEnum.element;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EClassContext extends ParserRuleContext {
		public Element owner;
		public EClass element;
		public Class current;
		public VisibilityKindContext visibility;
		public Token isAbstract;
		public Token isClass;
		public Token isInterface;
		public Token multiplicity;
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public EGenericSuperTypeContext eGenericSuperType;
		public List<EGenericSuperTypeContext> eSuperTypes = new ArrayList<EGenericSuperTypeContext>();
		public Token instanceClassName;
		public Token lowerIncluded;
		public Token lowerScope;
		public Token upperScope;
		public Token upperIncluded;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EOperationContext eOperation;
		public List<EOperationContext> eOperations = new ArrayList<EOperationContext>();
		public EStructuralFeatureContext eStructuralFeature;
		public List<EStructuralFeatureContext> eStructuralFeatures = new ArrayList<EStructuralFeatureContext>();
		public InvariantContext invariant;
		public List<InvariantContext> eConstraints = new ArrayList<InvariantContext>();
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public List<EGenericSuperTypeContext> eGenericSuperType() {
			return getRuleContexts(EGenericSuperTypeContext.class);
		}
		public EGenericSuperTypeContext eGenericSuperType(int i) {
			return getRuleContext(EGenericSuperTypeContext.class,i);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public List<TerminalNode> INT() { return getTokens(AlloyInEcoreParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(AlloyInEcoreParser.INT, i);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<EOperationContext> eOperation() {
			return getRuleContexts(EOperationContext.class);
		}
		public EOperationContext eOperation(int i) {
			return getRuleContext(EOperationContext.class,i);
		}
		public List<EStructuralFeatureContext> eStructuralFeature() {
			return getRuleContexts(EStructuralFeatureContext.class);
		}
		public EStructuralFeatureContext eStructuralFeature(int i) {
			return getRuleContext(EStructuralFeatureContext.class,i);
		}
		public List<InvariantContext> invariant() {
			return getRuleContexts(InvariantContext.class);
		}
		public InvariantContext invariant(int i) {
			return getRuleContext(InvariantContext.class,i);
		}
		public EClassContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EClassContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EClassContext eClass(Element owner) throws RecognitionException {
		EClassContext _localctx = new EClassContext(_ctx, getState(), owner);
		enterRule(_localctx, 40, RULE_eClass);
		((EClassContext)_localctx).element =  eFactory.createEClass(); ((EClassContext)_localctx).current =  new Class(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(370);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).visibility.element);
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
				{
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(374);
					((EClassContext)_localctx).isAbstract = match(T__23);
					}
				}

				setState(377);
				((EClassContext)_localctx).isClass = match(T__24);
				}
				break;
			case T__25:
				{
				setState(378);
				((EClassContext)_localctx).isInterface = match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.element.setAbstract(((EClassContext)_localctx).isAbstract!=null); if (((EClassContext)_localctx).isInterface!=null) {_localctx.element.setInterface(true);_localctx.element.setAbstract(true);}
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(382);
				((EClassContext)_localctx).multiplicity = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
					((EClassContext)_localctx).multiplicity = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(385);
				((EClassContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			if (_localctx.name == null) {notifyErrorListeners("missing Class name");} else {_localctx.element.setName((((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null));}
			if (((EClassContext)_localctx).isInterface!=null) {owner.deleteOwnedElement(_localctx.current); ((EClassContext)_localctx).current =  new Interface(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);}
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__86) {
				{
				setState(390);
				((EClassContext)_localctx).ownedSignature = ((EClassContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EClassContext)_localctx).templateSignature.typeParameters);
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(394);
				match(T__30);
				setState(395);
				((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(396);
					match(T__2);
					setState(397);
					((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
					}
					}
					setState(402);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(406);
				match(T__5);
				setState(407);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EClassContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EClassContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__31) {
				{
				setState(413);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__12:
					{
					setState(411);
					((EClassContext)_localctx).lowerIncluded = match(T__12);
					}
					break;
				case T__31:
					{
					setState(412);
					match(T__31);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(415);
				((EClassContext)_localctx).lowerScope = match(INT);
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(416);
					match(T__2);
					setState(417);
					((EClassContext)_localctx).upperScope = match(INT);
					}
				}

				setState(422);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(420);
					((EClassContext)_localctx).upperIncluded = match(T__13);
					}
					break;
				case T__32:
					{
					setState(421);
					match(T__32);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}


			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(427);
				match(T__1);
				setState(442);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__47))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__84 - 72)) | (1L << (T__98 - 72)) | (1L << (T__99 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)))) != 0)) {
					{
					setState(440);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						setState(428);
						((EClassContext)_localctx).eAnnotation = ((EClassContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						if (((EClassContext)_localctx).eAnnotation.element != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(431);
						((EClassContext)_localctx).eOperation = ((EClassContext)_localctx).eOperation = eOperation(_localctx.current);
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						if (((EClassContext)_localctx).eOperation.element != null) _localctx.element.getEOperations().add(((EClassContext)_localctx).eOperation.element);
						}
						break;
					case 3:
						{
						setState(434);
						((EClassContext)_localctx).eStructuralFeature = ((EClassContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.current);
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						if (((EClassContext)_localctx).eStructuralFeature.element != null) _localctx.element.getEStructuralFeatures().add(((EClassContext)_localctx).eStructuralFeature.element);
						}
						break;
					case 4:
						{
						setState(437);
						((EClassContext)_localctx).invariant = ((EClassContext)_localctx).invariant = invariant(_localctx.current);
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						if (((EClassContext)_localctx).invariant.element != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(444);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(445);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(446);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EStructuralFeatureContext extends ParserRuleContext {
		public Element owner;
		public EStructuralFeature element;
		public EAttributeContext eAttribute;
		public EReferenceContext eReference;
		public EAttributeContext eAttribute() {
			return getRuleContext(EAttributeContext.class,0);
		}
		public EReferenceContext eReference() {
			return getRuleContext(EReferenceContext.class,0);
		}
		public EStructuralFeatureContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EStructuralFeatureContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eStructuralFeature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEStructuralFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEStructuralFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEStructuralFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EStructuralFeatureContext eStructuralFeature(Element owner) throws RecognitionException {
		EStructuralFeatureContext _localctx = new EStructuralFeatureContext(_ctx, getState(), owner);
		enterRule(_localctx, 42, RULE_eStructuralFeature);
		try {
			setState(455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				((EStructuralFeatureContext)_localctx).eAttribute = eAttribute(_localctx.owner);
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eAttribute.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				((EStructuralFeatureContext)_localctx).eReference = eReference(_localctx.owner);
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eReference.element;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EAttributeContext extends ParserRuleContext {
		public Element owner;
		public EAttribute element;
		public Attribute current;
		public VisibilityKindContext visibility;
		public Token s34;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s12;
		public Token s35;
		public Token s36;
		public Token s37;
		public Token s38;
		public Token cardinality;
		public UnrestrictedNameContext name;
		public EGenericElementTypeContext eAttributeType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s40;
		public Token s41;
		public Token s42;
		public Token s43;
		public Token s44;
		public Token s45;
		public Token s46;
		public Token s47;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public DerivationContext ownedDerivation;
		public DerivationContext derivation;
		public InitialContext ownedInitial;
		public InitialContext initial;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public EGenericElementTypeContext eGenericElementType() {
			return getRuleContext(EGenericElementTypeContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public DerivationContext derivation() {
			return getRuleContext(DerivationContext.class,0);
		}
		public InitialContext initial() {
			return getRuleContext(InitialContext.class,0);
		}
		public EAttributeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EAttributeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EAttributeContext eAttribute(Element owner) throws RecognitionException {
		EAttributeContext _localctx = new EAttributeContext(_ctx, getState(), owner);
		enterRule(_localctx, 44, RULE_eAttribute);
		((EAttributeContext)_localctx).element =  eFactory.createEAttribute(); ((EAttributeContext)_localctx).current =  new Attribute(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(457);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).visibility.element);
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(461);
				((EAttributeContext)_localctx).s34 = match(T__33);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s34);
				}
			}

			setState(466);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(464);
				((EAttributeContext)_localctx).s12 = match(T__11);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s12);
				}
				break;
			case T__34:
				{
				setState(465);
				((EAttributeContext)_localctx).s35 = match(T__34);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s35);
				}
				break;
			case T__35:
			case T__36:
			case T__37:
			case T__38:
				break;
			default:
				break;
			}
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(468);
				((EAttributeContext)_localctx).s36 = match(T__35);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s36);
				}
			}

			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(471);
				((EAttributeContext)_localctx).s37 = match(T__36);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s37);
				}
			}

			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__37) {
				{
				setState(474);
				((EAttributeContext)_localctx).s38 = match(T__37);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s38);
				}
			}

			setState(477);
			match(T__38);
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(478);
				((EAttributeContext)_localctx).cardinality = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
					((EAttributeContext)_localctx).cardinality = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(481);
			((EAttributeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EAttributeContext)_localctx).name!=null?_input.getText(((EAttributeContext)_localctx).name.start,((EAttributeContext)_localctx).name.stop):null));
			setState(483);
			match(T__5);
			setState(484);
			((EAttributeContext)_localctx).eAttributeType = eGenericElementType(_localctx.current);
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(485);
				((EAttributeContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement)_localctx.element);
				}
			}

			if(_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(489);
				match(T__22);
				setState(490);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EAttributeContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EAttributeContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(513);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(494);
				match(T__1);
				setState(508); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(503);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__39:
						{
						setState(495);
						((EAttributeContext)_localctx).s40 = match(T__39);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(496);
						((EAttributeContext)_localctx).s41 = match(T__40);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(497);
						((EAttributeContext)_localctx).s42 = match(T__41);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s42);
						}
						break;
					case T__42:
						{
						setState(498);
						((EAttributeContext)_localctx).s43 = match(T__42);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(499);
						((EAttributeContext)_localctx).s44 = match(T__43);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s44);
						}
						break;
					case T__44:
						{
						setState(500);
						((EAttributeContext)_localctx).s45 = match(T__44);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s45);
						}
						break;
					case T__45:
						{
						setState(501);
						((EAttributeContext)_localctx).s46 = match(T__45);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s46);
						}
						break;
					case T__46:
						{
						setState(502);
						((EAttributeContext)_localctx).s47 = match(T__46);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s47);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(506);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(505);
						match(T__2);
						}
					}

					}
					}
					setState(510); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0) );
				setState(512);
				match(T__3);
				}
				break;
			}
			setState(542);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(515);
				match(T__1);
				{
				setState(521);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(516);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(523);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				}
				setState(530);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__106:
					{
					setState(524);
					((EAttributeContext)_localctx).ownedDerivation = ((EAttributeContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).derivation.element);
					}
					break;
				case T__105:
					{
					setState(527);
					((EAttributeContext)_localctx).ownedInitial = ((EAttributeContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__84:
					break;
				default:
					break;
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__84) {
					{
					{
					setState(532);
					((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
					}
					}
					setState(539);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(540);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(541);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EAttributeContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "static":     createEAnnotation(_localctx.element, AnnotationSources.STATIC); break;
			            case "model":      createEAnnotation(_localctx.element, AnnotationSources.MODEL); break;
			            case "ghost":      createEAnnotation(_localctx.element, AnnotationSources.GHOST); break;
			            case "transient":  _localctx.element.setTransient(true); break;
			            case "volatile":   _localctx.element.setVolatile(true); break;
			            case "readonly":   _localctx.element.setChangeable(false); break;
			            case "derived":    _localctx.element.setDerived(true); break;
			            case "ordered":    int u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setOrdered(true); break;
			            case "!unique":    u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setUnique(false); break;
			            case "unsettable": _localctx.element.setUnsettable(true); break;
			            case "id":         _localctx.element.setID(true); break;}}
			    
			}
			_ctx.stop = _input.LT(-1);

			if (_localctx.eAttributeType != null) {
			    EObject genericElementType = _localctx.eAttributeType.element;
			    if (genericElementType instanceof EClassifier) { _localctx.element.setEType((EClassifier) genericElementType);}
			    else if (genericElementType instanceof EGenericType) { _localctx.element.setEGenericType((EGenericType) genericElementType);}
			}

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EReferenceContext extends ParserRuleContext {
		public Element owner;
		public EReference element;
		public Reference current;
		public VisibilityKindContext visibility;
		public Token s34;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s12;
		public Token s35;
		public Token s36;
		public Token s37;
		public Token s38;
		public Token cardinality;
		public UnrestrictedNameContext name;
		public UnrestrictedNameContext eOpposite;
		public EGenericElementTypeContext eReferenceType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s50;
		public Token s40;
		public Token s51;
		public Token s52;
		public Token s53;
		public Token s54;
		public Token s55;
		public Token s56;
		public Token s57;
		public Token s58;
		public Token s59;
		public Token s60;
		public Token s61;
		public Token s62;
		public Token s63;
		public Token s64;
		public Token s65;
		public Token s66;
		public Token s67;
		public Token s68;
		public Token s42;
		public Token s43;
		public Token s44;
		public Token s45;
		public Token s69;
		public Token s70;
		public Token s46;
		public Token s47;
		public UnrestrictedNameContext unrestrictedName;
		public List<UnrestrictedNameContext> referredKeys = new ArrayList<UnrestrictedNameContext>();
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public DerivationContext ownedDerivation;
		public DerivationContext derivation;
		public InitialContext ownedInitial;
		public InitialContext initial;
		public ReasonContext reason;
		public List<UnrestrictedNameContext> unrestrictedName() {
			return getRuleContexts(UnrestrictedNameContext.class);
		}
		public UnrestrictedNameContext unrestrictedName(int i) {
			return getRuleContext(UnrestrictedNameContext.class,i);
		}
		public EGenericElementTypeContext eGenericElementType() {
			return getRuleContext(EGenericElementTypeContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public ReasonContext reason() {
			return getRuleContext(ReasonContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public DerivationContext derivation() {
			return getRuleContext(DerivationContext.class,0);
		}
		public InitialContext initial() {
			return getRuleContext(InitialContext.class,0);
		}
		public EReferenceContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EReferenceContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EReferenceContext eReference(Element owner) throws RecognitionException {
		EReferenceContext _localctx = new EReferenceContext(_ctx, getState(), owner);
		enterRule(_localctx, 46, RULE_eReference);
		((EReferenceContext)_localctx).element =  eFactory.createEReference(); ((EReferenceContext)_localctx).current =  new Reference(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(546);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).visibility.element);
			setState(551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(550);
				((EReferenceContext)_localctx).s34 = match(T__33);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s34);
				}
			}

			setState(555);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(553);
				((EReferenceContext)_localctx).s12 = match(T__11);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s12);
				}
				break;
			case T__34:
				{
				setState(554);
				((EReferenceContext)_localctx).s35 = match(T__34);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s35);
				}
				break;
			case T__35:
			case T__36:
			case T__37:
			case T__47:
				break;
			default:
				break;
			}
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(557);
				((EReferenceContext)_localctx).s36 = match(T__35);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s36);
				}
			}

			setState(561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(560);
				((EReferenceContext)_localctx).s37 = match(T__36);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
				}
			}

			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__37) {
				{
				setState(563);
				((EReferenceContext)_localctx).s38 = match(T__37);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
				}
			}

			setState(566);
			match(T__47);
			setState(568);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(567);
				((EReferenceContext)_localctx).cardinality = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
					((EReferenceContext)_localctx).cardinality = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(570);
			((EReferenceContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null));
			setState(574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__48) {
				{
				setState(572);
				match(T__48);
				setState(573);
				((EReferenceContext)_localctx).eOpposite = unrestrictedName();
				}
			}


			{
			setState(577);
			match(T__5);
			setState(578);
			((EReferenceContext)_localctx).eReferenceType = eGenericElementType(_localctx.current);
			setState(580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(579);
				((EReferenceContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			}
			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(583);
				match(T__22);
				setState(584);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EReferenceContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EReferenceContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(627);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(588);
				match(T__1);
				setState(622); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(617);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__49:
						{
						setState(589);
						((EReferenceContext)_localctx).s50 = match(T__49);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s50);
						}
						break;
					case T__39:
						{
						setState(590);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					case T__50:
						{
						setState(591);
						((EReferenceContext)_localctx).s51 = match(T__50);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s51);
						}
						break;
					case T__51:
						{
						setState(592);
						((EReferenceContext)_localctx).s52 = match(T__51);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s52);
						}
						break;
					case T__52:
						{
						setState(593);
						((EReferenceContext)_localctx).s53 = match(T__52);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s53);
						}
						break;
					case T__53:
						{
						setState(594);
						((EReferenceContext)_localctx).s54 = match(T__53);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s54);
						}
						break;
					case T__54:
						{
						setState(595);
						((EReferenceContext)_localctx).s55 = match(T__54);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s55);
						}
						break;
					case T__55:
						{
						setState(596);
						((EReferenceContext)_localctx).s56 = match(T__55);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s56);
						}
						break;
					case T__56:
						{
						setState(597);
						((EReferenceContext)_localctx).s57 = match(T__56);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s57);
						}
						break;
					case T__57:
						{
						setState(598);
						((EReferenceContext)_localctx).s58 = match(T__57);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s58);
						}
						break;
					case T__58:
						{
						setState(599);
						((EReferenceContext)_localctx).s59 = match(T__58);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s59);
						}
						break;
					case T__59:
						{
						setState(600);
						((EReferenceContext)_localctx).s60 = match(T__59);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s60);
						}
						break;
					case T__60:
						{
						setState(601);
						((EReferenceContext)_localctx).s61 = match(T__60);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s61);
						}
						break;
					case T__61:
						{
						setState(602);
						((EReferenceContext)_localctx).s62 = match(T__61);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s62);
						}
						break;
					case T__62:
						{
						setState(603);
						((EReferenceContext)_localctx).s63 = match(T__62);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s63);
						}
						break;
					case T__63:
						{
						setState(604);
						((EReferenceContext)_localctx).s64 = match(T__63);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s64);
						}
						break;
					case T__64:
						{
						setState(605);
						((EReferenceContext)_localctx).s65 = match(T__64);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s65);
						}
						break;
					case T__65:
						{
						setState(606);
						((EReferenceContext)_localctx).s66 = match(T__65);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s66);
						}
						break;
					case T__66:
						{
						setState(607);
						((EReferenceContext)_localctx).s67 = match(T__66);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s67);
						}
						break;
					case T__67:
						{
						setState(608);
						((EReferenceContext)_localctx).s68 = match(T__67);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s68);
						}
						break;
					case T__41:
						{
						setState(609);
						((EReferenceContext)_localctx).s42 = match(T__41);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s42);
						}
						break;
					case T__42:
						{
						setState(610);
						((EReferenceContext)_localctx).s43 = match(T__42);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(611);
						((EReferenceContext)_localctx).s44 = match(T__43);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s44);
						}
						break;
					case T__44:
						{
						setState(612);
						((EReferenceContext)_localctx).s45 = match(T__44);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s45);
						}
						break;
					case T__68:
						{
						setState(613);
						((EReferenceContext)_localctx).s69 = match(T__68);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s69);
						}
						break;
					case T__69:
						{
						setState(614);
						((EReferenceContext)_localctx).s70 = match(T__69);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s70);
						}
						break;
					case T__45:
						{
						setState(615);
						((EReferenceContext)_localctx).s46 = match(T__45);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s46);
						}
						break;
					case T__46:
						{
						setState(616);
						((EReferenceContext)_localctx).s47 = match(T__46);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s47);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(620);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(619);
						match(T__2);
						}
					}

					}
					}
					setState(624); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (T__39 - 40)) | (1L << (T__41 - 40)) | (1L << (T__42 - 40)) | (1L << (T__43 - 40)) | (1L << (T__44 - 40)) | (1L << (T__45 - 40)) | (1L << (T__46 - 40)) | (1L << (T__49 - 40)) | (1L << (T__50 - 40)) | (1L << (T__51 - 40)) | (1L << (T__52 - 40)) | (1L << (T__53 - 40)) | (1L << (T__54 - 40)) | (1L << (T__55 - 40)) | (1L << (T__56 - 40)) | (1L << (T__57 - 40)) | (1L << (T__58 - 40)) | (1L << (T__59 - 40)) | (1L << (T__60 - 40)) | (1L << (T__61 - 40)) | (1L << (T__62 - 40)) | (1L << (T__63 - 40)) | (1L << (T__64 - 40)) | (1L << (T__65 - 40)) | (1L << (T__66 - 40)) | (1L << (T__67 - 40)) | (1L << (T__68 - 40)) | (1L << (T__69 - 40)))) != 0) );
				setState(626);
				match(T__3);
				}
				break;
			}
			setState(674);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(629);
				match(T__1);
				setState(641);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__70) {
					{
					setState(630);
					match(T__70);
					setState(631);
					((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
					setState(636);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(632);
						match(T__2);
						setState(633);
						((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
						}
						}
						setState(638);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(639);
					match(T__10);
					}
				}

				{
				setState(648);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(643);
						((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(650);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				}
				setState(657);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__106:
					{
					setState(651);
					((EReferenceContext)_localctx).ownedDerivation = ((EReferenceContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).derivation.element);
					}
					break;
				case T__105:
					{
					setState(654);
					((EReferenceContext)_localctx).ownedInitial = ((EReferenceContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__84:
				case T__100:
					break;
				default:
					break;
				}
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__84) {
					{
					{
					setState(659);
					((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
					}
					}
					setState(666);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__100) {
					{
					setState(667);
					((EReferenceContext)_localctx).reason = reason(_localctx.current);
					if (((EReferenceContext)_localctx).reason.element != null) _localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).reason.element);
					}
				}

				setState(672);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(673);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EReferenceContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "static":    createEAnnotation(_localctx.element, AnnotationSources.STATIC); break;
			            case "model":     createEAnnotation(_localctx.element, AnnotationSources.MODEL); break;
			            case "ghost":     createEAnnotation(_localctx.element, AnnotationSources.GHOST); break;
			            case "acyclic":   createEAnnotation(_localctx.element, AnnotationSources.ACYCLIC); break;
			            case "transitive":   createEAnnotation(_localctx.element, AnnotationSources.TRANSITIVE); break;
			            case "reflexive":   createEAnnotation(_localctx.element, AnnotationSources.REFLEXIVE); break;
			            case "irreflexive":   createEAnnotation(_localctx.element, AnnotationSources.IRREFLEXIVE); break;
			            case "symmetric":   createEAnnotation(_localctx.element, AnnotationSources.SYMMETRIC); break;
			            case "asymmetric":   createEAnnotation(_localctx.element, AnnotationSources.ASYMMETRIC); break;
			            case "antisymmetric":   createEAnnotation(_localctx.element, AnnotationSources.ANTISYMMETRIC); break;
			            case "total":   createEAnnotation(_localctx.element, AnnotationSources.TOTAL); break;
			            case "functional":   createEAnnotation(_localctx.element, AnnotationSources.FUNCTIONAL); break;
			            case "surjective":   createEAnnotation(_localctx.element, AnnotationSources.SURJECTIVE); break;
			            case "injective":   createEAnnotation(_localctx.element, AnnotationSources.INJECTIVE); break;
			            case "bijective":   createEAnnotation(_localctx.element, AnnotationSources.BIJECTIVE); break;
			            case "complete":   createEAnnotation(_localctx.element, AnnotationSources.COMPLETE); break;
			            case "bijection":   createEAnnotation(_localctx.element, AnnotationSources.BIJECTION); break;
			            case "preorder":   createEAnnotation(_localctx.element, AnnotationSources.PREORDER); break;
			            case "equivalence":   createEAnnotation(_localctx.element, AnnotationSources.EQUIVALENCE); break;
			            case "partialorder":   createEAnnotation(_localctx.element, AnnotationSources.PARTIALORDER); break;
			            case "totalorder":   createEAnnotation(_localctx.element, AnnotationSources.TOTALORDER); break;
			            case "transient": _localctx.element.setTransient(true); break;
			            case "volatile":  _localctx.element.setVolatile(true); break;
			            case "readonly":  _localctx.element.setChangeable(false); break;
			            case "unsettable":_localctx.element.setUnsettable(true); break;
			            case "derived":   _localctx.element.setDerived(true); break;
			            case "ordered":   int u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setOrdered(true); break;
			            case "!unique":   u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setUnique(false); break;
			            case "composes":  _localctx.element.setContainment(true); break;
			            case "!resolve":  _localctx.element.setResolveProxies(false); break;
			            default: break;}}
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EOperationContext extends ParserRuleContext {
		public Element owner;
		public EOperation element;
		public Operation current;
		public VisibilityKindContext visibility;
		public Token s34;
		public List<Token> qualifier = new ArrayList<Token>();
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public UnrestrictedNameContext name;
		public EParameterContext eParameter;
		public List<EParameterContext> eParameters = new ArrayList<EParameterContext>();
		public EGenericElementTypeContext eReturnType;
		public EGenericElementTypeContext eGenericElementType;
		public EMultiplicityContext ownedMultiplicity;
		public EGenericExceptionContext eGenericException;
		public List<EGenericExceptionContext> ownedException = new ArrayList<EGenericExceptionContext>();
		public Token s42;
		public Token s43;
		public Token s44;
		public Token s45;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public PreconditionContext precondition;
		public List<PreconditionContext> ownedPreconditions = new ArrayList<PreconditionContext>();
		public BodyContext body;
		public List<BodyContext> ownedBodyExpression = new ArrayList<BodyContext>();
		public PostconditionContext postcondition;
		public List<PostconditionContext> ownedPostconditions = new ArrayList<PostconditionContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public EGenericElementTypeContext eGenericElementType() {
			return getRuleContext(EGenericElementTypeContext.class,0);
		}
		public List<EGenericExceptionContext> eGenericException() {
			return getRuleContexts(EGenericExceptionContext.class);
		}
		public EGenericExceptionContext eGenericException(int i) {
			return getRuleContext(EGenericExceptionContext.class,i);
		}
		public List<EParameterContext> eParameter() {
			return getRuleContexts(EParameterContext.class);
		}
		public EParameterContext eParameter(int i) {
			return getRuleContext(EParameterContext.class,i);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<PreconditionContext> precondition() {
			return getRuleContexts(PreconditionContext.class);
		}
		public PreconditionContext precondition(int i) {
			return getRuleContext(PreconditionContext.class,i);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public List<PostconditionContext> postcondition() {
			return getRuleContexts(PostconditionContext.class);
		}
		public PostconditionContext postcondition(int i) {
			return getRuleContext(PostconditionContext.class,i);
		}
		public EOperationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EOperationContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EOperationContext eOperation(Element owner) throws RecognitionException {
		EOperationContext _localctx = new EOperationContext(_ctx, getState(), owner);
		enterRule(_localctx, 48, RULE_eOperation);
		((EOperationContext)_localctx).element =  eFactory.createEOperation(); ((EOperationContext)_localctx).current =  new Operation(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(678);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EOperationContext)_localctx).visibility.element);
			setState(683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(682);
				((EOperationContext)_localctx).s34 = match(T__33);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s34);
				}
			}

			setState(685);
			match(T__71);
			setState(687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__86) {
				{
				setState(686);
				((EOperationContext)_localctx).ownedSignature = ((EOperationContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EOperationContext)_localctx).templateSignature.typeParameters);
			setState(690);
			((EOperationContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null));
			{
			setState(692);
			match(T__31);
			setState(701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (T__149 - 150)) | (1L << (T__150 - 150)) | (1L << (T__151 - 150)) | (1L << (IDENTIFIER - 150)))) != 0)) {
				{
				setState(693);
				((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(694);
					match(T__2);
					setState(695);
					((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(700);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(703);
			match(T__32);
			}
			for (EParameterContext ctx: ((EOperationContext)_localctx).eParameters){_localctx.element.getEParameters().add(ctx.element);}
			setState(711);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(706);
				match(T__5);
				setState(707);
				((EOperationContext)_localctx).eReturnType = ((EOperationContext)_localctx).eGenericElementType = eGenericElementType(_localctx.current);
				setState(709);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(708);
					((EOperationContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
					}
				}

				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			 if (_localctx.eReturnType != null) _localctx.element.setEGenericType(((EOperationContext)_localctx).eGenericElementType.element);
			setState(724);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__72) {
				{
				setState(715);
				match(T__72);
				setState(716);
				((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(717);
					match(T__2);
					setState(718);
					((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
					}
					}
					setState(723);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 for(EGenericExceptionContext e: ((EOperationContext)_localctx).ownedException) _localctx.element.getEGenericExceptions().add(e.element);
			setState(742);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				{
				setState(727);
				match(T__1);
				setState(737); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(732);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__41:
						{
						setState(728);
						((EOperationContext)_localctx).s42 = match(T__41);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s42);
						}
						break;
					case T__42:
						{
						setState(729);
						((EOperationContext)_localctx).s43 = match(T__42);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(730);
						((EOperationContext)_localctx).s44 = match(T__43);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s44);
						}
						break;
					case T__44:
						{
						setState(731);
						((EOperationContext)_localctx).s45 = match(T__44);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s45);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(735);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(734);
						match(T__2);
						}
					}

					}
					}
					setState(739); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) );
				setState(741);
				match(T__3);
				}
				break;
			}
			setState(764);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(744);
				match(T__1);
				setState(759);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__97 - 85)) | (1L << (T__101 - 85)) | (1L << (T__102 - 85)) | (1L << (T__103 - 85)) | (1L << (T__104 - 85)))) != 0)) {
					{
					setState(757);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__84:
						{
						setState(745);
						((EOperationContext)_localctx).eAnnotation = ((EOperationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).eAnnotation.element);
						}
						break;
					case T__101:
					case T__102:
						{
						setState(748);
						((EOperationContext)_localctx).precondition = ((EOperationContext)_localctx).precondition = precondition(_localctx.current);
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).precondition.element);
						}
						break;
					case T__97:
						{
						setState(751);
						((EOperationContext)_localctx).body = ((EOperationContext)_localctx).body = body(_localctx.current);
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).body.element);
						}
						break;
					case T__103:
					case T__104:
						{
						setState(754);
						((EOperationContext)_localctx).postcondition = ((EOperationContext)_localctx).postcondition = postcondition(_localctx.current);
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).postcondition.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(761);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(762);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(763);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EOperationContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "static":   createEAnnotation(_localctx.element, AnnotationSources.STATIC); break;
			            case "ordered":  int u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setOrdered(true); break;
			            case "!unique":  u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setUnique(false); break;}}
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericExceptionContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericException current;
		public EGenericTypeContext eGenericType;
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericExceptionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericExceptionContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericException; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericException(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericException(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericException(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericExceptionContext eGenericException(Element owner) throws RecognitionException {
		EGenericExceptionContext _localctx = new EGenericExceptionContext(_ctx, getState(), owner);
		enterRule(_localctx, 50, RULE_eGenericException);
		((EGenericExceptionContext)_localctx).current =  new GenericException(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			((EGenericExceptionContext)_localctx).eGenericType = eGenericType(_localctx.current);
			((EGenericExceptionContext)_localctx).element =  ((EGenericExceptionContext)_localctx).eGenericType.element; _localctx.current.setEObject(_localctx.element);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericSuperTypeContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericSuperType current;
		public EGenericTypeContext eGenericType;
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericSuperTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericSuperTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericSuperType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericSuperType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericSuperType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericSuperType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericSuperTypeContext eGenericSuperType(Element owner) throws RecognitionException {
		EGenericSuperTypeContext _localctx = new EGenericSuperTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 52, RULE_eGenericSuperType);
		((EGenericSuperTypeContext)_localctx).current =  new GenericSuperType(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(771);
			((EGenericSuperTypeContext)_localctx).eGenericType = eGenericType(_localctx.current);
			((EGenericSuperTypeContext)_localctx).element =  ((EGenericSuperTypeContext)_localctx).eGenericType.element; _localctx.current.setEObject(_localctx.element);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EParameterContext extends ParserRuleContext {
		public Element owner;
		public EParameter element;
		public Parameter current;
		public UnrestrictedNameContext name;
		public EGenericElementTypeContext eParameterType;
		public EMultiplicityContext ownedMultiplicity;
		public Token s42;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s43;
		public Token s44;
		public Token s45;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public EGenericElementTypeContext eGenericElementType() {
			return getRuleContext(EGenericElementTypeContext.class,0);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public EParameterContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EParameterContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EParameterContext eParameter(Element owner) throws RecognitionException {
		EParameterContext _localctx = new EParameterContext(_ctx, getState(), owner);
		enterRule(_localctx, 54, RULE_eParameter);
		((EParameterContext)_localctx).element =  eFactory.createEParameter(); ((EParameterContext)_localctx).current =  new Parameter(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
			((EParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null));
			setState(776);
			match(T__5);
			setState(777);
			((EParameterContext)_localctx).eParameterType = eGenericElementType(_localctx.current);
			setState(779);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(778);
				((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(797);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(782);
				match(T__1);
				setState(792); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(787);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__41:
						{
						setState(783);
						((EParameterContext)_localctx).s42 = match(T__41);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s42);
						}
						break;
					case T__42:
						{
						setState(784);
						((EParameterContext)_localctx).s43 = match(T__42);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(785);
						((EParameterContext)_localctx).s44 = match(T__43);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s44);
						}
						break;
					case T__44:
						{
						setState(786);
						((EParameterContext)_localctx).s45 = match(T__44);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s45);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(790);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(789);
						match(T__2);
						}
					}

					}
					}
					setState(794); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) );
				setState(796);
				match(T__3);
				}
				break;
			}
			setState(808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(799);
				match(T__1);
				setState(803);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__84) {
					{
					{
					setState(800);
					((EParameterContext)_localctx).eAnnotation = ((EParameterContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(805);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EParameterContext)_localctx).eAnnotation.element);
				setState(807);
				match(T__3);
				}
			}

			for(String s: ((EParameterContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "ordered":  int u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setOrdered(true);break;
			            case "!unique":  u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setUnique(false);break;}}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EMultiplicityContext extends ParserRuleContext {
		public Element owner;
		public ETypedElement element;
		public int l = 1;
		public int u = 1;
		public LowerContext lowerBound;
		public UpperContext upperBound;
		public Token stringBound;
		public Token nullable;
		public LowerContext lower() {
			return getRuleContext(LowerContext.class,0);
		}
		public UpperContext upper() {
			return getRuleContext(UpperContext.class,0);
		}
		public EMultiplicityContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EMultiplicityContext(ParserRuleContext parent, int invokingState, Element owner, ETypedElement element) {
			super(parent, invokingState);
			this.owner = owner;
			this.element = element;
		}
		@Override public int getRuleIndex() { return RULE_eMultiplicity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEMultiplicity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEMultiplicity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEMultiplicity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EMultiplicityContext eMultiplicity(Element owner,ETypedElement element) throws RecognitionException {
		EMultiplicityContext _localctx = new EMultiplicityContext(_ctx, getState(), owner, element);
		enterRule(_localctx, 56, RULE_eMultiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(812);
			match(T__12);
			setState(819);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(813);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(816);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__73) {
					{
					setState(814);
					match(T__73);
					setState(815);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__16:
			case T__74:
			case T__75:
				{
				setState(818);
				((EMultiplicityContext)_localctx).stringBound = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)))) != 0)) ) {
					((EMultiplicityContext)_localctx).stringBound = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(823);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__76:
				{
				setState(821);
				((EMultiplicityContext)_localctx).nullable = match(T__76);
				}
				break;
			case T__77:
				{
				setState(822);
				match(T__77);
				}
				break;
			case T__13:
				break;
			default:
				break;
			}
			setState(825);
			match(T__13);

				if (_localctx.stringBound != null) {
				    switch (_localctx.stringBound.getText()) {
			            case "*": ((EMultiplicityContext)_localctx).l =  0; ((EMultiplicityContext)_localctx).u =  -1; break;
			            case "+": ((EMultiplicityContext)_localctx).l =  1; ((EMultiplicityContext)_localctx).u =  -1; break;
			            case "?": ((EMultiplicityContext)_localctx).l =  0; ((EMultiplicityContext)_localctx).u =   1; break;
			            default: break;
			        }
			    } else {
			        try { ((EMultiplicityContext)_localctx).l =  Integer.valueOf((((EMultiplicityContext)_localctx).lowerBound!=null?_input.getText(((EMultiplicityContext)_localctx).lowerBound.start,((EMultiplicityContext)_localctx).lowerBound.stop):null)); } catch (NumberFormatException ex) {System.out.println(Arrays.toString(ex.getStackTrace()));}
			        if (_localctx.upperBound != null) {
			            if (_localctx.upperBound.getText().equals("*")) ((EMultiplicityContext)_localctx).u =  -1;
			            else try {((EMultiplicityContext)_localctx).u =  Integer.valueOf((((EMultiplicityContext)_localctx).upperBound!=null?_input.getText(((EMultiplicityContext)_localctx).upperBound.start,((EMultiplicityContext)_localctx).upperBound.stop):null));} catch (NumberFormatException ex){System.out.println(Arrays.toString(ex.getStackTrace()));}
			        } else { ((EMultiplicityContext)_localctx).u =  _localctx.l;}
			    }
			    if ((_localctx.u > 1 || _localctx.u == -1) && _localctx.nullable != null) createEAnnotation(_localctx.element, AnnotationSources.NULLABLE);
				
			}
			_ctx.stop = _input.LT(-1);
			_localctx.element.setLowerBound(_localctx.l); _localctx.element.setUpperBound(_localctx.u); if (owner!=null) _localctx.owner.addOwnedElement(new Multiplicity(_localctx));
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EDataTypeContext extends ParserRuleContext {
		public Element owner;
		public EDataType element;
		public DataType current;
		public VisibilityKindContext visibility;
		public Token s79;
		public List<Token> qualifier = new ArrayList<Token>();
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public Token instanceClassName;
		public Token s81;
		public Token s82;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public InvariantContext invariant;
		public List<InvariantContext> ownedConstraints = new ArrayList<InvariantContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<InvariantContext> invariant() {
			return getRuleContexts(InvariantContext.class);
		}
		public InvariantContext invariant(int i) {
			return getRuleContext(InvariantContext.class,i);
		}
		public EDataTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EDataTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eDataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EDataTypeContext eDataType(Element owner) throws RecognitionException {
		EDataTypeContext _localctx = new EDataTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 58, RULE_eDataType);
		((EDataTypeContext)_localctx).element =  eFactory.createEDataType(); ((EDataTypeContext)_localctx).current =  new DataType(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(829);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(828);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).visibility.element);
			setState(833);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__78) {
				{
				setState(832);
				((EDataTypeContext)_localctx).s79 = match(T__78);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s79);
				}
			}

			setState(835);
			match(T__79);
			setState(836);
			((EDataTypeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null));
			setState(839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__86) {
				{
				setState(838);
				((EDataTypeContext)_localctx).ownedSignature = ((EDataTypeContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EDataTypeContext)_localctx).templateSignature.typeParameters);
			setState(844);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(842);
				match(T__5);
				setState(843);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EDataTypeContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EDataTypeContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(853);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(847);
				match(T__1);
				setState(850);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__80:
					{
					setState(848);
					((EDataTypeContext)_localctx).s81 = match(T__80);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s81);
					}
					break;
				case T__81:
					{
					setState(849);
					((EDataTypeContext)_localctx).s82 = match(T__81);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s82);
					}
					break;
				case T__3:
					break;
				default:
					break;
				}
				setState(852);
				match(T__3);
				}
				break;
			}
			setState(869);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(855);
				match(T__1);
				setState(864);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__98 - 85)) | (1L << (T__99 - 85)))) != 0)) {
					{
					setState(862);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__84:
						{
						setState(856);
						((EDataTypeContext)_localctx).eAnnotation = ((EDataTypeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).eAnnotation.element);
						}
						break;
					case T__98:
					case T__99:
						{
						setState(859);
						((EDataTypeContext)_localctx).invariant = ((EDataTypeContext)_localctx).invariant = invariant(_localctx.current);
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).invariant.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(866);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(867);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(868);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EDataTypeContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "primitive":     createEAnnotation(_localctx.element, AnnotationSources.DATATYPE_PRIMITIVE);break;
			            case "!serializable": _localctx.element.setSerializable(false); break; }}
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EEnumContext extends ParserRuleContext {
		public Element owner;
		public EEnum element;
		public Enum current;
		public VisibilityKindContext visibility;
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public Token instanceClassName;
		public Token s81;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s82;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EEnumLiteralContext eEnumLiteral;
		public List<EEnumLiteralContext> ownedLiteral = new ArrayList<EEnumLiteralContext>();
		public InvariantContext invariant;
		public List<InvariantContext> ownedConstraint = new ArrayList<InvariantContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<EEnumLiteralContext> eEnumLiteral() {
			return getRuleContexts(EEnumLiteralContext.class);
		}
		public EEnumLiteralContext eEnumLiteral(int i) {
			return getRuleContext(EEnumLiteralContext.class,i);
		}
		public List<InvariantContext> invariant() {
			return getRuleContexts(InvariantContext.class);
		}
		public InvariantContext invariant(int i) {
			return getRuleContext(InvariantContext.class,i);
		}
		public EEnumContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EEnumContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eEnum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEEnum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEEnum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEEnum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EEnumContext eEnum(Element owner) throws RecognitionException {
		EEnumContext _localctx = new EEnumContext(_ctx, getState(), owner);
		enterRule(_localctx, 60, RULE_eEnum);
		((EEnumContext)_localctx).element =  eFactory.createEEnum(); ((EEnumContext)_localctx).current =  new Enum(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(873);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EEnumContext)_localctx).visibility.element);
			setState(877);
			match(T__82);
			setState(878);
			((EEnumContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null));
			setState(881);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__86) {
				{
				setState(880);
				((EEnumContext)_localctx).ownedSignature = ((EEnumContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EEnumContext)_localctx).templateSignature.typeParameters);
			setState(886);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(884);
				match(T__5);
				setState(885);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EEnumContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EEnumContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(895);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				{
				setState(889);
				match(T__1);
				setState(892);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__80:
					{
					setState(890);
					((EEnumContext)_localctx).s81 = match(T__80);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s81);
					}
					break;
				case T__81:
					{
					setState(891);
					((EEnumContext)_localctx).s82 = match(T__81);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s82);
					}
					break;
				case T__3:
					break;
				default:
					break;
				}
				setState(894);
				match(T__3);
				}
				break;
			}
			setState(914);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(897);
				match(T__1);
				setState(909);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (T__149 - 150)) | (1L << (T__150 - 150)) | (1L << (T__151 - 150)) | (1L << (IDENTIFIER - 150)))) != 0)) {
					{
					setState(907);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
					case 1:
						{
						setState(898);
						((EEnumContext)_localctx).eAnnotation = ((EEnumContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(901);
						((EEnumContext)_localctx).eEnumLiteral = ((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.current);
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						_localctx.element.getELiterals().add(((EEnumContext)_localctx).eEnumLiteral.element);
						}
						break;
					case 3:
						{
						setState(904);
						((EEnumContext)_localctx).invariant = ((EEnumContext)_localctx).invariant = invariant(_localctx.current);
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(911);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(912);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(913);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EEnumContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "!serializable": _localctx.element.setSerializable(false); break;}}
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EEnumLiteralContext extends ParserRuleContext {
		public Element owner;
		public EEnumLiteral element;
		public EnumLiteral current;
		public UnrestrictedNameContext name;
		public Token value;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public EEnumLiteralContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EEnumLiteralContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eEnumLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEEnumLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEEnumLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEEnumLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EEnumLiteralContext eEnumLiteral(Element owner) throws RecognitionException {
		EEnumLiteralContext _localctx = new EEnumLiteralContext(_ctx, getState(), owner);
		enterRule(_localctx, 62, RULE_eEnumLiteral);
		((EEnumLiteralContext)_localctx).element =  eFactory.createEEnumLiteral(); ((EEnumLiteralContext)_localctx).current =  new EnumLiteral(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(921);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				{
				{
				setState(918);
				match(T__83);
				setState(919);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(920);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			_localctx.element.setName((((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null));
			setState(926);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(924);
				match(T__22);
				setState(925);
				((EEnumLiteralContext)_localctx).value = match(INT);
				}
			}

			 
			setState(939);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(929);
				match(T__1);
				setState(933);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__84) {
					{
					{
					setState(930);
					((EEnumLiteralContext)_localctx).eAnnotation = ((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(935);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EEnumLiteralContext)_localctx).eAnnotation.element);
				setState(937);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(938);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EAnnotationContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public Annotation current;
		public Token source;
		public EDetailContext eDetail;
		public List<EDetailContext> ownedDetails = new ArrayList<EDetailContext>();
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EModelElementContext eModelElement;
		public List<EModelElementContext> ownedContents = new ArrayList<EModelElementContext>();
		public EModelElementRefContext eModelElementRef;
		public List<EModelElementRefContext> ownedReferences = new ArrayList<EModelElementRefContext>();
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public List<EDetailContext> eDetail() {
			return getRuleContexts(EDetailContext.class);
		}
		public EDetailContext eDetail(int i) {
			return getRuleContext(EDetailContext.class,i);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<EModelElementContext> eModelElement() {
			return getRuleContexts(EModelElementContext.class);
		}
		public EModelElementContext eModelElement(int i) {
			return getRuleContext(EModelElementContext.class,i);
		}
		public List<EModelElementRefContext> eModelElementRef() {
			return getRuleContexts(EModelElementRefContext.class);
		}
		public EModelElementRefContext eModelElementRef(int i) {
			return getRuleContext(EModelElementRefContext.class,i);
		}
		public EAnnotationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EAnnotationContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EAnnotationContext eAnnotation(Element owner) throws RecognitionException {
		EAnnotationContext _localctx = new EAnnotationContext(_ctx, getState(), owner);
		enterRule(_localctx, 64, RULE_eAnnotation);
		((EAnnotationContext)_localctx).element =  eFactory.createEAnnotation(); ((EAnnotationContext)_localctx).current =  new Annotation(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
			match(T__84);
			setState(943);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(942);
				((EAnnotationContext)_localctx).source = match(SINGLE_QUOTED_STRING);
				}
			}

			_localctx.element.setSource(((EAnnotationContext)_localctx).source != null ? ((EAnnotationContext)_localctx).source.getText().replace("'", "") : null);
			setState(957);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(946);
				match(T__31);
				setState(947);
				((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(952);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(948);
					match(T__2);
					setState(949);
					((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(954);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(955);
				match(T__32);
				}
			}

			for (EDetailContext ctx: ((EAnnotationContext)_localctx).ownedDetails) _localctx.element.getDetails().put(ctx.k, ctx.v);
			setState(977);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(960);
				match(T__1);
				setState(970); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(970);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
					case 1:
						{
						setState(961);
						((EAnnotationContext)_localctx).eAnnotation = ((EAnnotationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						if(((EAnnotationContext)_localctx).eAnnotation.element != null) _localctx.element.getEAnnotations().add(((EAnnotationContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(964);
						((EAnnotationContext)_localctx).eModelElement = ((EAnnotationContext)_localctx).eModelElement = eModelElement(_localctx.current);
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						if(((EAnnotationContext)_localctx).eModelElement.element != null) _localctx.element.getContents().add(((EAnnotationContext)_localctx).eModelElement.element);
						}
						break;
					case 3:
						{
						setState(967);
						((EAnnotationContext)_localctx).eModelElementRef = ((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef(_localctx.current);
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						if(((EAnnotationContext)_localctx).eModelElementRef.element != null) _localctx.element.getReferences().add(((EAnnotationContext)_localctx).eModelElementRef.element);
						}
						break;
					}
					}
					setState(972); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (T__149 - 150)) | (1L << (T__150 - 150)) | (1L << (T__151 - 150)) | (1L << (IDENTIFIER - 150)))) != 0) );
				setState(974);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(976);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EDetailContext extends ParserRuleContext {
		public Element owner;
		public String k;
		public String v;
		public AnnotationDetail current;
		public Token key;
		public Token value;
		public List<TerminalNode> SINGLE_QUOTED_STRING() { return getTokens(AlloyInEcoreParser.SINGLE_QUOTED_STRING); }
		public TerminalNode SINGLE_QUOTED_STRING(int i) {
			return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, i);
		}
		public TerminalNode ML_SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.ML_SINGLE_QUOTED_STRING, 0); }
		public EDetailContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EDetailContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eDetail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEDetail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEDetail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEDetail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EDetailContext eDetail(Element owner) throws RecognitionException {
		EDetailContext _localctx = new EDetailContext(_ctx, getState(), owner);
		enterRule(_localctx, 66, RULE_eDetail);
		((EDetailContext)_localctx).current =  new AnnotationDetail(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(980);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(979);
				((EDetailContext)_localctx).key = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(982);
			match(T__22);
			setState(984);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) {
				{
				setState(983);
				((EDetailContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) ) {
					((EDetailContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			((EDetailContext)_localctx).k =  ((EDetailContext)_localctx).key != null ? ((EDetailContext)_localctx).key.getText().replace("'", "") : null; ((EDetailContext)_localctx).v =  ((EDetailContext)_localctx).value != null ? ((EDetailContext)_localctx).value.getText().replace("'", "") : null; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EModelElementContext extends ParserRuleContext {
		public Element owner;
		public EModelElement element;
		public EAnnotationContext eAnnotation;
		public ENamedElementContext eNamedElement;
		public EAnnotationContext eAnnotation() {
			return getRuleContext(EAnnotationContext.class,0);
		}
		public ENamedElementContext eNamedElement() {
			return getRuleContext(ENamedElementContext.class,0);
		}
		public EModelElementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EModelElementContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eModelElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEModelElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEModelElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEModelElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EModelElementContext eModelElement(Element owner) throws RecognitionException {
		EModelElementContext _localctx = new EModelElementContext(_ctx, getState(), owner);
		enterRule(_localctx, 68, RULE_eModelElement);
		try {
			setState(994);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(988);
				((EModelElementContext)_localctx).eAnnotation = eAnnotation(_localctx.owner);
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eAnnotation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(991);
				((EModelElementContext)_localctx).eNamedElement = eNamedElement(_localctx.owner);
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eNamedElement.element;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ENamedElementContext extends ParserRuleContext {
		public Element owner;
		public ENamedElement element;
		public ETypedElementContext eTypedElement;
		public EClassifierContext eClassifier;
		public EPackageContext ePackage;
		public EEnumLiteralContext eEnumLiteral;
		public ETypedElementContext eTypedElement() {
			return getRuleContext(ETypedElementContext.class,0);
		}
		public EClassifierContext eClassifier() {
			return getRuleContext(EClassifierContext.class,0);
		}
		public EPackageContext ePackage() {
			return getRuleContext(EPackageContext.class,0);
		}
		public EEnumLiteralContext eEnumLiteral() {
			return getRuleContext(EEnumLiteralContext.class,0);
		}
		public ENamedElementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ENamedElementContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eNamedElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterENamedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitENamedElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitENamedElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ENamedElementContext eNamedElement(Element owner) throws RecognitionException {
		ENamedElementContext _localctx = new ENamedElementContext(_ctx, getState(), owner);
		enterRule(_localctx, 70, RULE_eNamedElement);
		try {
			setState(1008);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(996);
				((ENamedElementContext)_localctx).eTypedElement = eTypedElement(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eTypedElement.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(999);
				((ENamedElementContext)_localctx).eClassifier = eClassifier(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eClassifier.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1002);
				((ENamedElementContext)_localctx).ePackage = ePackage(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).ePackage.element;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1005);
				((ENamedElementContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eEnumLiteral.element;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ETypedElementContext extends ParserRuleContext {
		public Element owner;
		public ETypedElement element;
		public EOperationContext eOperation;
		public EParameterContext eParameter;
		public EStructuralFeatureContext eStructuralFeature;
		public EOperationContext eOperation() {
			return getRuleContext(EOperationContext.class,0);
		}
		public EParameterContext eParameter() {
			return getRuleContext(EParameterContext.class,0);
		}
		public EStructuralFeatureContext eStructuralFeature() {
			return getRuleContext(EStructuralFeatureContext.class,0);
		}
		public ETypedElementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ETypedElementContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eTypedElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterETypedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitETypedElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitETypedElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ETypedElementContext eTypedElement(Element owner) throws RecognitionException {
		ETypedElementContext _localctx = new ETypedElementContext(_ctx, getState(), owner);
		enterRule(_localctx, 72, RULE_eTypedElement);
		try {
			setState(1019);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1010);
				((ETypedElementContext)_localctx).eOperation = eOperation(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eOperation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1013);
				((ETypedElementContext)_localctx).eParameter = eParameter(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eParameter.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1016);
				((ETypedElementContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eStructuralFeature.element;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EModelElementRefContext extends ParserRuleContext {
		public Element owner;
		public EObject element;
		public AnnotationReference current;
		public PathNameContext ownedPathName;
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public EModelElementRefContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EModelElementRefContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eModelElementRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEModelElementRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEModelElementRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEModelElementRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EModelElementRefContext eModelElementRef(Element owner) throws RecognitionException {
		EModelElementRefContext _localctx = new EModelElementRefContext(_ctx, getState(), owner);
		enterRule(_localctx, 74, RULE_eModelElementRef);
		((EModelElementRefContext)_localctx).current =  new AnnotationReference(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1021);
			match(T__85);
			setState(1022);
			((EModelElementRefContext)_localctx).ownedPathName = pathName(_localctx.current);
			if (((EModelElementRefContext)_localctx).ownedPathName.element != null) _localctx.current.setEObject(((EModelElementRefContext)_localctx).element =  ((EModelElementRefContext)_localctx).ownedPathName.element);
			setState(1024);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateSignatureContext extends ParserRuleContext {
		public Element owner;
		public List<ETypeParameter> typeParameters;
		public ETypeParameterContext eTypeParameter;
		public List<ETypeParameterContext> ownedTypeParameters = new ArrayList<ETypeParameterContext>();
		public List<ETypeParameterContext> eTypeParameter() {
			return getRuleContexts(ETypeParameterContext.class);
		}
		public ETypeParameterContext eTypeParameter(int i) {
			return getRuleContext(ETypeParameterContext.class,i);
		}
		public TemplateSignatureContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TemplateSignatureContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_templateSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTemplateSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTemplateSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTemplateSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateSignatureContext templateSignature(Element owner) throws RecognitionException {
		TemplateSignatureContext _localctx = new TemplateSignatureContext(_ctx, getState(), owner);
		enterRule(_localctx, 76, RULE_templateSignature);
		((TemplateSignatureContext)_localctx).typeParameters =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1026);
			match(T__86);
			setState(1027);
			((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
			((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
			setState(1032);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1028);
				match(T__2);
				setState(1029);
				((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
				((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
				}
				}
				setState(1034);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1035);
			match(T__87);
			}
			_ctx.stop = _input.LT(-1);
			for(ETypeParameterContext ctx: ((TemplateSignatureContext)_localctx).ownedTypeParameters) _localctx.typeParameters.add(ctx.element);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ETypeParameterContext extends ParserRuleContext {
		public Element owner;
		public ETypeParameter element;
		public TypeParameter current;
		public UnrestrictedNameContext name;
		public EGenericTypeContext eGenericType;
		public List<EGenericTypeContext> ownedEBounds = new ArrayList<EGenericTypeContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public List<EGenericTypeContext> eGenericType() {
			return getRuleContexts(EGenericTypeContext.class);
		}
		public EGenericTypeContext eGenericType(int i) {
			return getRuleContext(EGenericTypeContext.class,i);
		}
		public ETypeParameterContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ETypeParameterContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eTypeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterETypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitETypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitETypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ETypeParameterContext eTypeParameter(Element owner) throws RecognitionException {
		ETypeParameterContext _localctx = new ETypeParameterContext(_ctx, getState(), owner);
		enterRule(_localctx, 78, RULE_eTypeParameter);
		((ETypeParameterContext)_localctx).element =  eFactory.createETypeParameter(); ((ETypeParameterContext)_localctx).current =  new TypeParameter(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1037);
			((ETypeParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((ETypeParameterContext)_localctx).name!=null?_input.getText(((ETypeParameterContext)_localctx).name.start,((ETypeParameterContext)_localctx).name.stop):null));
			setState(1048);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(1039);
				match(T__30);
				setState(1040);
				((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
				setState(1045);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__88) {
					{
					{
					setState(1041);
					match(T__88);
					setState(1042);
					((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
					((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
					}
					}
					setState(1047);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			for(EGenericTypeContext ctx: ((ETypeParameterContext)_localctx).ownedEBounds) _localctx.element.getEBounds().add(ctx.element);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericTypeArgumentContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericTypeArgument current;
		public EGenericTypeContext eGenericType;
		public EGenericWildcardContext eGenericWildcard;
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericWildcardContext eGenericWildcard() {
			return getRuleContext(EGenericWildcardContext.class,0);
		}
		public EGenericTypeArgumentContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericTypeArgumentContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericTypeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericTypeArgumentContext eGenericTypeArgument(Element owner) throws RecognitionException {
		EGenericTypeArgumentContext _localctx = new EGenericTypeArgumentContext(_ctx, getState(), owner);
		enterRule(_localctx, 80, RULE_eGenericTypeArgument);
		((EGenericTypeArgumentContext)_localctx).current =  new GenericTypeArgument(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			setState(1058);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__11:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__33:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__43:
			case T__45:
			case T__47:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__64:
			case T__65:
			case T__66:
			case T__67:
			case T__68:
			case T__70:
			case T__71:
			case T__72:
			case T__78:
			case T__79:
			case T__80:
			case T__82:
			case T__83:
			case T__84:
			case T__85:
			case T__97:
			case T__98:
			case T__99:
			case T__101:
			case T__103:
			case T__105:
			case T__106:
			case T__149:
			case T__150:
			case T__151:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1052);
				((EGenericTypeArgumentContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((EGenericTypeArgumentContext)_localctx).element =  ((EGenericTypeArgumentContext)_localctx).eGenericType.element; _localctx.current.setEObject(_localctx.element);
				}
				break;
			case T__75:
				enterOuterAlt(_localctx, 2);
				{
				setState(1055);
				((EGenericTypeArgumentContext)_localctx).eGenericWildcard = eGenericWildcard(_localctx.current);
				((EGenericTypeArgumentContext)_localctx).element =  ((EGenericTypeArgumentContext)_localctx).eGenericWildcard.element; _localctx.current.setEObject(_localctx.element);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericTypeContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public Element current;
		public PathNameContext ownedPathName;
		public EGenericTypeArgumentContext eGenericTypeArgument;
		public List<EGenericTypeArgumentContext> ownedETypeArguments = new ArrayList<EGenericTypeArgumentContext>();
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public List<EGenericTypeArgumentContext> eGenericTypeArgument() {
			return getRuleContexts(EGenericTypeArgumentContext.class);
		}
		public EGenericTypeArgumentContext eGenericTypeArgument(int i) {
			return getRuleContext(EGenericTypeArgumentContext.class,i);
		}
		public EGenericTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericTypeContext eGenericType(Element owner) throws RecognitionException {
		EGenericTypeContext _localctx = new EGenericTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 82, RULE_eGenericType);

		((EGenericTypeContext)_localctx).element =  eFactory.createEGenericType();
		if (_localctx.parent instanceof ETypeParameterContext) {((EGenericTypeContext)_localctx).current =  new GenericType(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);}
		else {((EGenericTypeContext)_localctx).current =  _localctx.owner;}

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1060);
			((EGenericTypeContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(1072);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__86) {
				{
				setState(1061);
				match(T__86);
				setState(1062);
				((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
				((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
				setState(1067);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1063);
					match(T__2);
					setState(1064);
					((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
					((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
					}
					}
					setState(1069);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1070);
				match(T__87);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericElementTypeContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericElementType current;
		public EPrimitiveTypeContext ePrimitiveType;
		public EGenericTypeContext eGenericType;
		public EPrimitiveTypeContext ePrimitiveType() {
			return getRuleContext(EPrimitiveTypeContext.class,0);
		}
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericElementTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericElementTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericElementType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericElementType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericElementType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericElementType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericElementTypeContext eGenericElementType(Element owner) throws RecognitionException {
		EGenericElementTypeContext _localctx = new EGenericElementTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 84, RULE_eGenericElementType);
		((EGenericElementTypeContext)_localctx).current =  new GenericElementType(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			setState(1080);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__92:
			case T__93:
			case T__94:
			case T__95:
			case T__96:
				enterOuterAlt(_localctx, 1);
				{
				setState(1074);
				((EGenericElementTypeContext)_localctx).ePrimitiveType = ePrimitiveType(_localctx.current);
				((EGenericElementTypeContext)_localctx).element =  ((EGenericElementTypeContext)_localctx).ePrimitiveType.element; _localctx.current.setEObject(_localctx.element);
				}
				break;
			case T__9:
			case T__11:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__33:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__43:
			case T__45:
			case T__47:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__64:
			case T__65:
			case T__66:
			case T__67:
			case T__68:
			case T__70:
			case T__71:
			case T__72:
			case T__78:
			case T__79:
			case T__80:
			case T__82:
			case T__83:
			case T__84:
			case T__85:
			case T__97:
			case T__98:
			case T__99:
			case T__101:
			case T__103:
			case T__105:
			case T__106:
			case T__149:
			case T__150:
			case T__151:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1077);
				((EGenericElementTypeContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((EGenericElementTypeContext)_localctx).element =  ((EGenericElementTypeContext)_localctx).eGenericType.element; _localctx.current.setEObject(_localctx.element);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericWildcardContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericWildcard current;
		public Token bound;
		public EGenericTypeContext ownedExtend;
		public EGenericTypeContext eGenericType;
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericWildcardContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericWildcardContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericWildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericWildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericWildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericWildcardContext eGenericWildcard(Element owner) throws RecognitionException {
		EGenericWildcardContext _localctx = new EGenericWildcardContext(_ctx, getState(), owner);
		enterRule(_localctx, 86, RULE_eGenericWildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1082);
			match(T__75);
			((EGenericWildcardContext)_localctx).element =  eFactory.createEGenericType();
			setState(1089);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30 || _la==T__89) {
				{
				setState(1084);
				((EGenericWildcardContext)_localctx).bound = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__89) ) {
					((EGenericWildcardContext)_localctx).bound = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((EGenericWildcardContext)_localctx).current =  new GenericWildcard(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
				setState(1086);
				((EGenericWildcardContext)_localctx).ownedExtend = ((EGenericWildcardContext)_localctx).eGenericType = eGenericType(_localctx.current);
				if (((EGenericWildcardContext)_localctx).bound.equals("extends")) _localctx.element.setEUpperBound(((EGenericWildcardContext)_localctx).eGenericType.element); else _localctx.element.setELowerBound(((EGenericWildcardContext)_localctx).eGenericType.element);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathNameContext extends ParserRuleContext {
		public Element owner;
		public EObject element;
		public UnrestrictedNameContext firstSegment;
		public Token index;
		public SegmentContext segment;
		public List<SegmentContext> midSegments = new ArrayList<SegmentContext>();
		public SegmentContext lastSegment;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public PathNameContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PathNameContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_pathName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPathName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPathName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPathName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathNameContext pathName(Element owner) throws RecognitionException {
		PathNameContext _localctx = new PathNameContext(_ctx, getState(), owner);
		enterRule(_localctx, 88, RULE_pathName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1091);
			((PathNameContext)_localctx).firstSegment = unrestrictedName();
			setState(1094);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
			case 1:
				{
				setState(1092);
				match(T__18);
				setState(1093);
				((PathNameContext)_localctx).index = match(INT);
				}
				break;
			}
			setState(1103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				{
				setState(1099);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1096);
						((PathNameContext)_localctx).segment = segment();
						((PathNameContext)_localctx).midSegments.add(((PathNameContext)_localctx).segment);
						}
						} 
					}
					setState(1101);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
				}
				setState(1102);
				((PathNameContext)_localctx).lastSegment = segment();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SegmentContext extends ParserRuleContext {
		public UnrestrictedNameContext name;
		public Token index;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public SegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SegmentContext segment() throws RecognitionException {
		SegmentContext _localctx = new SegmentContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_segment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1105);
			match(T__90);
			setState(1107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__91) {
				{
				setState(1106);
				match(T__91);
				}
			}

			setState(1109);
			((SegmentContext)_localctx).name = unrestrictedName();
			setState(1112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
			case 1:
				{
				setState(1110);
				match(T__18);
				setState(1111);
				((SegmentContext)_localctx).index = match(INT);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EPrimitiveTypeContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public PrimitiveType current;
		public EPrimitiveTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EPrimitiveTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_ePrimitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EPrimitiveTypeContext ePrimitiveType(Element owner) throws RecognitionException {
		EPrimitiveTypeContext _localctx = new EPrimitiveTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 92, RULE_ePrimitiveType);
		try {
			setState(1124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__92:
				enterOuterAlt(_localctx, 1);
				{
				setState(1114);
				match(T__92);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBoolean());
				}
				break;
			case T__93:
				enterOuterAlt(_localctx, 2);
				{
				setState(1116);
				match(T__93);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEInt());
				}
				break;
			case T__94:
				enterOuterAlt(_localctx, 3);
				{
				setState(1118);
				match(T__94);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEString());
				}
				break;
			case T__95:
				enterOuterAlt(_localctx, 4);
				{
				setState(1120);
				match(T__95);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBigDecimal());
				}
				break;
			case T__96:
				enterOuterAlt(_localctx, 5);
				{
				setState(1122);
				match(T__96);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBigInteger());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			((EPrimitiveTypeContext)_localctx).current =  new PrimitiveType(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public Body current;
		public IdentifierContext name;
		public ExpressionContext ownedExpression;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BodyContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body(Element owner) throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState(), owner);
		enterRule(_localctx, 94, RULE_body);
		((BodyContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.BODY); ((BodyContext)_localctx).current =  new Body(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1126);
			match(T__97);
			setState(1128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1127);
				((BodyContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((BodyContext)_localctx).name!=null?_input.getText(((BodyContext)_localctx).name.start,((BodyContext)_localctx).name.stop):null)); 
			setState(1137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1131);
				match(T__5);
				setState(1133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (T__130 - 131)) | (1L << (T__131 - 131)) | (1L << (T__133 - 131)) | (1L << (T__136 - 131)) | (1L << (T__137 - 131)) | (1L << (T__138 - 131)) | (1L << (T__139 - 131)) | (1L << (T__149 - 131)) | (1L << (T__150 - 131)) | (1L << (T__151 - 131)) | (1L << (IDENTIFIER - 131)))) != 0)) {
					{
					setState(1132);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1135);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1136);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedExpression!=null) {_localctx.element.getDetails().put("expression", getContextText(_localctx.expression())); _localctx.current.addOwnedElement(((BodyContext)_localctx).ownedExpression.element);}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvariantContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public Invariant current;
		public Token isCallable;
		public IdentifierContext name;
		public Token message;
		public FormulaContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public InvariantContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InvariantContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_invariant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInvariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInvariant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInvariant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvariantContext invariant(Element owner) throws RecognitionException {
		InvariantContext _localctx = new InvariantContext(_ctx, getState(), owner);
		enterRule(_localctx, 96, RULE_invariant);
		((InvariantContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INVARIANT); ((InvariantContext)_localctx).current =  new Invariant(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__98) {
				{
				setState(1141);
				((InvariantContext)_localctx).isCallable = match(T__98);
				}
			}

			_localctx.element.getDetails().put("callable", ((InvariantContext)_localctx).isCallable != null ? "true" : "false");
			setState(1145);
			match(T__99);
			setState(1152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1146);
				((InvariantContext)_localctx).name = identifier();
				setState(1150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(1147);
					match(T__31);
					setState(1148);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1149);
					match(T__32);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InvariantContext)_localctx).name!=null?_input.getText(((InvariantContext)_localctx).name.start,((InvariantContext)_localctx).name.stop):null)); if(((InvariantContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((InvariantContext)_localctx).message!=null?((InvariantContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1155);
				match(T__5);
				setState(1157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
					{
					setState(1156);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1159);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1160);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedSpecification!=null) {_localctx.element.getDetails().put("formula", getContextText(_localctx.formula())); _localctx.current.addOwnedElement(((InvariantContext)_localctx).ownedSpecification.element);}
			}
			_ctx.stop = _input.LT(-1);
			declarations.clear();
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReasonContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public Reason current;
		public FormulaContext ownedSpecification;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ReasonContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ReasonContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_reason; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterReason(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitReason(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitReason(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReasonContext reason(Element owner) throws RecognitionException {
		ReasonContext _localctx = new ReasonContext(_ctx, getState(), owner);
		enterRule(_localctx, 98, RULE_reason);
		((ReasonContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.REASON); ((ReasonContext)_localctx).current =  new Reason(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1165);
			match(T__100);
			setState(1172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1166);
				match(T__5);
				setState(1168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
					{
					setState(1167);
					((ReasonContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1170);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1171);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedSpecification!=null) {_localctx.element.getDetails().put("formula", getContextText(_localctx.formula())); _localctx.current.addOwnedElement(((ReasonContext)_localctx).ownedSpecification.element);}
			}
			_ctx.stop = _input.LT(-1);
			declarations.clear();
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreconditionContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public PreCondition current;
		public IdentifierContext name;
		public Token message;
		public FormulaContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public PreconditionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PreconditionContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_precondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPrecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPrecondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPrecondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreconditionContext precondition(Element owner) throws RecognitionException {
		PreconditionContext _localctx = new PreconditionContext(_ctx, getState(), owner);
		enterRule(_localctx, 100, RULE_precondition);
		((PreconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.PRECONDITION); ((PreconditionContext)_localctx).current =  new PreCondition(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1176);
			_la = _input.LA(1);
			if ( !(_la==T__101 || _la==T__102) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1177);
				((PreconditionContext)_localctx).name = identifier();
				setState(1181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(1178);
					match(T__31);
					setState(1179);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1180);
					match(T__32);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PreconditionContext)_localctx).name!=null?_input.getText(((PreconditionContext)_localctx).name.start,((PreconditionContext)_localctx).name.stop):null)); if(((PreconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PreconditionContext)_localctx).message!=null?((PreconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1186);
				match(T__5);
				setState(1188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
					{
					setState(1187);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1190);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1191);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedSpecification!=null) _localctx.element.getDetails().put("formula", getContextText(_localctx.formula())); _localctx.current.addOwnedElement(((PreconditionContext)_localctx).ownedSpecification.element);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostconditionContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public PostCondition current;
		public IdentifierContext name;
		public Token message;
		public FormulaContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public PostconditionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PostconditionContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_postcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPostcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPostcondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPostcondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostconditionContext postcondition(Element owner) throws RecognitionException {
		PostconditionContext _localctx = new PostconditionContext(_ctx, getState(), owner);
		enterRule(_localctx, 102, RULE_postcondition);
		((PostconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.POSTCONDITION); ((PostconditionContext)_localctx).current =  new PostCondition(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1196);
			_la = _input.LA(1);
			if ( !(_la==T__103 || _la==T__104) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1197);
				((PostconditionContext)_localctx).name = identifier();
				setState(1201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(1198);
					match(T__31);
					setState(1199);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1200);
					match(T__32);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PostconditionContext)_localctx).name!=null?_input.getText(((PostconditionContext)_localctx).name.start,((PostconditionContext)_localctx).name.stop):null)); if(((PostconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PostconditionContext)_localctx).message!=null?((PostconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1206);
				match(T__5);
				setState(1208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
					{
					setState(1207);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1210);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1211);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedSpecification!=null) _localctx.element.getDetails().put("formula", getContextText(_localctx.formula())); _localctx.current.addOwnedElement(((PostconditionContext)_localctx).ownedSpecification.element);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitialContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public Initial current;
		public IdentifierContext name;
		public ExpressionContext ownedExpression;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitialContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InitialContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_initial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInitial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInitial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInitial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialContext initial(Element owner) throws RecognitionException {
		InitialContext _localctx = new InitialContext(_ctx, getState(), owner);
		enterRule(_localctx, 104, RULE_initial);
		((InitialContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INITIAL); ((InitialContext)_localctx).current =  new Initial(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1216);
			match(T__105);
			setState(1218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1217);
				((InitialContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InitialContext)_localctx).name!=null?_input.getText(((InitialContext)_localctx).name.start,((InitialContext)_localctx).name.stop):null));
			setState(1227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1221);
				match(T__5);
				setState(1223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (T__130 - 131)) | (1L << (T__131 - 131)) | (1L << (T__133 - 131)) | (1L << (T__136 - 131)) | (1L << (T__137 - 131)) | (1L << (T__138 - 131)) | (1L << (T__139 - 131)) | (1L << (T__149 - 131)) | (1L << (T__150 - 131)) | (1L << (T__151 - 131)) | (1L << (IDENTIFIER - 131)))) != 0)) {
					{
					setState(1222);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1225);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1226);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedExpression!=null) {_localctx.element.getDetails().put("expression", getContextText(_localctx.expression())); _localctx.current.addOwnedElement(((InitialContext)_localctx).ownedExpression.element);} 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DerivationContext extends ParserRuleContext {
		public Element owner;
		public EAnnotation element;
		public Derivation current;
		public IdentifierContext name;
		public ExpressionContext ownedExpression;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DerivationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public DerivationContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_derivation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDerivation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDerivation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDerivation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DerivationContext derivation(Element owner) throws RecognitionException {
		DerivationContext _localctx = new DerivationContext(_ctx, getState(), owner);
		enterRule(_localctx, 106, RULE_derivation);
		((DerivationContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.DERIVATION); ((DerivationContext)_localctx).current =  new Derivation(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1231);
			match(T__106);
			setState(1233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1232);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((DerivationContext)_localctx).name!=null?_input.getText(((DerivationContext)_localctx).name.start,((DerivationContext)_localctx).name.stop):null));
			setState(1242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1236);
				match(T__5);
				setState(1238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (T__130 - 131)) | (1L << (T__131 - 131)) | (1L << (T__133 - 131)) | (1L << (T__136 - 131)) | (1L << (T__137 - 131)) | (1L << (T__138 - 131)) | (1L << (T__139 - 131)) | (1L << (T__149 - 131)) | (1L << (T__150 - 131)) | (1L << (T__151 - 131)) | (1L << (IDENTIFIER - 131)))) != 0)) {
					{
					setState(1237);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1240);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1241);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedExpression!=null) {_localctx.element.getDetails().put("expression", getContextText(_localctx.expression())); _localctx.current.addOwnedElement(((DerivationContext)_localctx).ownedExpression.element);} 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VisibilityKindContext extends ParserRuleContext {
		public EAnnotation element;
		public Token qualifier;
		public VisibilityKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibilityKind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterVisibilityKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitVisibilityKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitVisibilityKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisibilityKindContext visibilityKind() throws RecognitionException {
		VisibilityKindContext _localctx = new VisibilityKindContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_visibilityKind);
		((VisibilityKindContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.VISIBILITY);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__107:
				{
				setState(1246);
				((VisibilityKindContext)_localctx).qualifier = match(T__107);
				}
				break;
			case T__108:
				{
				setState(1247);
				((VisibilityKindContext)_localctx).qualifier = match(T__108);
				}
				break;
			case T__109:
				{
				setState(1248);
				((VisibilityKindContext)_localctx).qualifier = match(T__109);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.element.getDetails().put("visibility", (((VisibilityKindContext)_localctx).qualifier!=null?((VisibilityKindContext)_localctx).qualifier.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public Formula element;
		public List<Variable> variables;
		public int var = 0;
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
			this.element = ctx.element;
			this.variables = ctx.variables;
			this.var = ctx.var;
		}
	}
	public static class Reflexive_Context extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public Reflexive_Context(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterReflexive_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitReflexive_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitReflexive_(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoContext extends FormulaContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NoContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterNo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitNo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitNo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomeContext extends FormulaContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SomeContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSome(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionalContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public FunctionalContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterFunctional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitFunctional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitFunctional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForOneContext extends FormulaContext {
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForOneContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForOne(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IrreflexiveContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public IrreflexiveContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIrreflexive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIrreflexive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIrreflexive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumDeclarationContext extends FormulaContext {
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
		}
		public IntExpressionContext intExpression() {
			return getRuleContext(IntExpressionContext.class,0);
		}
		public SumDeclarationContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSumDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSumDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForAllContext extends FormulaContext {
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForAllContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoneContext extends FormulaContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoneContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtContext extends FormulaContext {
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public LtContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InjectiveContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public InjectiveContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInjective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInjective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInjective(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SymmetricContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public SymmetricContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSymmetric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSymmetric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSymmetric(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForSomeContext extends FormulaContext {
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForSomeContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForSome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForSome(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BijectionContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public BijectionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBijection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBijection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBijection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TotalContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public TotalContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTotal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTotal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTotal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends FormulaContext {
		public Token op;
		public FormulaContext formula;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NotContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class F_paranthesisContext extends FormulaContext {
		public FormulaContext formula;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public F_paranthesisContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterF_paranthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitF_paranthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitF_paranthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends FormulaContext {
		public FormulaContext fleft;
		public Token op;
		public FormulaContext fright;
		public FormulaContext formula;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public AndContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionContext extends FormulaContext {
		public RelationIdContext rel;
		public ExpressionContext domain;
		public Token partial;
		public ExpressionContext range;
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GteContext extends FormulaContext {
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public GteContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterGte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitGte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitGte(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AcyclicContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public AcyclicContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterAcyclic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitAcyclic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitAcyclic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetContext extends FormulaContext {
		public FormulaContext formula;
		public LetDeclarationsContext letDeclarations() {
			return getRuleContext(LetDeclarationsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public LetContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LteContext extends FormulaContext {
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public LteContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLte(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TransitiveContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public TransitiveContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTransitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTransitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTransitive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TotalorderContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public TotalorderContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTotalorder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTotalorder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTotalorder(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BijectiveContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public BijectiveContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBijective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBijective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBijective(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AntisymmetricContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public AntisymmetricContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterAntisymmetric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitAntisymmetric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitAntisymmetric(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EquivalenceContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public EquivalenceContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEquivalence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEquivalence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEquivalence(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends FormulaContext {
		public FormulaContext fleft;
		public Token op;
		public FormulaContext fright;
		public FormulaContext formula;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public OrContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InContext extends FormulaContext {
		public ExpressionContext left;
		public Token not;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PartialorderContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public PartialorderContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPartialorder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPartialorder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPartialorder(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OneContext extends FormulaContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OneContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOne(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends FormulaContext {
		public FalseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IffContext extends FormulaContext {
		public FormulaContext fleft;
		public Token op;
		public FormulaContext fright;
		public FormulaContext formula;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public IffContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqContext extends FormulaContext {
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public EqContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GtContext extends FormulaContext {
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public GtContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitGt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitGt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualContext extends FormulaContext {
		public ExpressionContext left;
		public Token not;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForLoneContext extends FormulaContext {
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForLoneContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForLone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForLone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForLone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TotalOrderContext extends FormulaContext {
		public RelationIdContext rel;
		public RelationIdContext ordered;
		public RelationIdContext first;
		public RelationIdContext last;
		public List<RelationIdContext> relationId() {
			return getRuleContexts(RelationIdContext.class);
		}
		public RelationIdContext relationId(int i) {
			return getRuleContext(RelationIdContext.class,i);
		}
		public TotalOrderContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTotalOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTotalOrder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTotalOrder(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends FormulaContext {
		public TrueContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsymmetricContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public AsymmetricContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterAsymmetric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitAsymmetric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitAsymmetric(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForNoContext extends FormulaContext {
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForNoContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForNo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForNo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForNo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompleteContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public CompleteContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterComplete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitComplete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitComplete(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImpliesContext extends FormulaContext {
		public FormulaContext fleft;
		public Token op;
		public FormulaContext fright;
		public FormulaContext formula;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ImpliesContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitImplies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitImplies(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SurjectiveContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public SurjectiveContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSurjective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSurjective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSurjective(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreorderContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public PreorderContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPreorder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPreorder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPreorder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 110;
		enterRecursionRule(_localctx, 110, RULE_formula, _p);
		if(_localctx.getParent() instanceof FormulaContext) ((FormulaContext)_localctx).variables =  ((FormulaContext)getInvokingContext(55)).variables ; else ((FormulaContext)_localctx).variables =  _localctx.variables = new ArrayList<>();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1644);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1254);
				match(T__29);
				setState(1255);
				expression(0);
				((NoContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1258);
				match(T__27);
				setState(1259);
				expression(0);
				((LoneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1262);
				match(T__26);
				setState(1263);
				expression(0);
				((OneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1266);
				match(T__28);
				setState(1267);
				expression(0);
				((SomeContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1270);
				((InContext)_localctx).left = expression(0);
				setState(1272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1271);
					((InContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__110 || _la==T__111) ) {
						((InContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1274);
				match(T__112);
				setState(1275);
				((InContext)_localctx).right = expression(0);
				((InContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1278);
				((EqualContext)_localctx).left = expression(0);
				setState(1280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1279);
					((EqualContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__110 || _la==T__111) ) {
						((EqualContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1282);
				match(T__22);
				setState(1283);
				((EqualContext)_localctx).right = expression(0);
				((EqualContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1286);
				((EqContext)_localctx).ileft = intExpression(0);
				setState(1288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1287);
					((EqContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__110 || _la==T__111) ) {
						((EqContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1290);
				match(T__22);
				setState(1291);
				((EqContext)_localctx).iright = intExpression(0);
				((EqContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1294);
				((LtContext)_localctx).ileft = intExpression(0);
				setState(1296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1295);
					((LtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__110 || _la==T__111) ) {
						((LtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1298);
				match(T__86);
				setState(1299);
				((LtContext)_localctx).iright = intExpression(0);
				((LtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1302);
				((LteContext)_localctx).ileft = intExpression(0);
				setState(1304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1303);
					((LteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__110 || _la==T__111) ) {
						((LteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1306);
				match(T__113);
				setState(1307);
				((LteContext)_localctx).iright = intExpression(0);
				((LteContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1310);
				((GtContext)_localctx).ileft = intExpression(0);
				setState(1312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1311);
					((GtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__110 || _la==T__111) ) {
						((GtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1314);
				match(T__87);
				setState(1315);
				((GtContext)_localctx).iright = intExpression(0);
				((GtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1318);
				((GteContext)_localctx).ileft = intExpression(0);
				setState(1320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1319);
					((GteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__110 || _la==T__111) ) {
						((GteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1322);
				match(T__114);
				setState(1323);
				((GteContext)_localctx).iright = intExpression(0);
				((GteContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 12:
				{
				_localctx = new SumDeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(1326);
				match(T__115);
				setState(1327);
				quantifierDeclarations();
				setState(1328);
				match(T__116);
				setState(1329);
				intExpression(0);
				}
				((SumDeclarationContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 13:
				{
				_localctx = new AcyclicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1333);
				match(T__50);
				setState(1334);
				match(T__12);
				setState(1335);
				relationId();
				setState(1336);
				match(T__13);
				((AcyclicContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 14:
				{
				_localctx = new TransitiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1339);
				match(T__51);
				setState(1340);
				match(T__12);
				setState(1341);
				relationId();
				setState(1342);
				match(T__13);
				((TransitiveContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 15:
				{
				_localctx = new Reflexive_Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1345);
				match(T__52);
				setState(1346);
				match(T__12);
				setState(1347);
				relationId();
				setState(1348);
				match(T__13);
				((Reflexive_Context)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 16:
				{
				_localctx = new IrreflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1351);
				match(T__53);
				setState(1352);
				match(T__12);
				setState(1353);
				relationId();
				setState(1354);
				match(T__13);
				((IrreflexiveContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 17:
				{
				_localctx = new SymmetricContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1357);
				match(T__54);
				setState(1358);
				match(T__12);
				setState(1359);
				relationId();
				setState(1360);
				match(T__13);
				((SymmetricContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 18:
				{
				_localctx = new AsymmetricContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1363);
				match(T__55);
				setState(1364);
				match(T__12);
				setState(1365);
				relationId();
				setState(1366);
				match(T__13);
				((AsymmetricContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 19:
				{
				_localctx = new AntisymmetricContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1369);
				match(T__56);
				setState(1370);
				match(T__12);
				setState(1371);
				relationId();
				setState(1372);
				match(T__13);
				((AntisymmetricContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 20:
				{
				_localctx = new TotalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1375);
				match(T__57);
				setState(1376);
				match(T__12);
				setState(1377);
				relationId();
				setState(1378);
				match(T__13);
				((TotalContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 21:
				{
				_localctx = new FunctionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1381);
				match(T__58);
				setState(1382);
				match(T__12);
				setState(1383);
				relationId();
				setState(1384);
				match(T__13);
				((FunctionalContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 22:
				{
				_localctx = new SurjectiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1387);
				match(T__59);
				setState(1388);
				match(T__12);
				setState(1389);
				relationId();
				setState(1390);
				match(T__13);
				((SurjectiveContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 23:
				{
				_localctx = new InjectiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1393);
				match(T__60);
				setState(1394);
				match(T__12);
				setState(1395);
				relationId();
				setState(1396);
				match(T__13);
				((InjectiveContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 24:
				{
				_localctx = new BijectiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1399);
				match(T__61);
				setState(1400);
				match(T__12);
				setState(1401);
				relationId();
				setState(1402);
				match(T__13);
				((BijectiveContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 25:
				{
				_localctx = new CompleteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1405);
				match(T__62);
				setState(1406);
				match(T__12);
				setState(1407);
				relationId();
				setState(1408);
				match(T__13);
				((CompleteContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 26:
				{
				_localctx = new BijectionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1411);
				match(T__63);
				setState(1412);
				match(T__12);
				setState(1413);
				relationId();
				setState(1414);
				match(T__13);
				((BijectionContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 27:
				{
				_localctx = new PreorderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1417);
				match(T__64);
				setState(1418);
				match(T__12);
				setState(1419);
				relationId();
				setState(1420);
				match(T__13);
				((PreorderContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 28:
				{
				_localctx = new EquivalenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1423);
				match(T__65);
				setState(1424);
				match(T__12);
				setState(1425);
				relationId();
				setState(1426);
				match(T__13);
				((EquivalenceContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 29:
				{
				_localctx = new PartialorderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1429);
				match(T__66);
				setState(1430);
				match(T__12);
				setState(1431);
				relationId();
				setState(1432);
				match(T__13);
				((PartialorderContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 30:
				{
				_localctx = new TotalorderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1435);
				match(T__67);
				setState(1436);
				match(T__12);
				setState(1437);
				relationId();
				setState(1438);
				match(T__13);
				((TotalorderContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 31:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1441);
				match(T__117);
				setState(1442);
				match(T__12);
				setState(1443);
				((FunctionContext)_localctx).rel = relationId();
				setState(1444);
				match(T__5);
				setState(1445);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1446);
				match(T__118);
				setState(1451);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
				case 1:
					{
					setState(1448);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
					case 1:
						{
						setState(1447);
						match(T__26);
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(1450);
					((FunctionContext)_localctx).partial = match(T__27);
					}
					break;
				}
				setState(1453);
				((FunctionContext)_localctx).range = expression(0);
				setState(1454);
				match(T__13);
				((FunctionContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 32:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1457);
				match(T__119);
				setState(1458);
				match(T__12);
				setState(1459);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1460);
				match(T__2);
				setState(1461);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1462);
				match(T__2);
				setState(1463);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1464);
				match(T__2);
				setState(1465);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1466);
				match(T__13);
				((TotalOrderContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 33:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1469);
				((NotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__110 || _la==T__111) ) {
					((NotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1470);
				((NotContext)_localctx).formula = formula(14);
				((NotContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 34:
				{
				_localctx = new ForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1474);
				match(T__128);
				setState(1475);
				quantifierDeclarations();
				setState(1496);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1476);
					match(T__116);
					setState(1486);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
					case 1:
						{
						setState(1477);
						((ForAllContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1478);
						match(T__1);
						setState(1482);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
							{
							{
							setState(1479);
							((ForAllContext)_localctx).formula = formula(0);
							}
							}
							setState(1484);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1485);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1488);
					match(T__1);
					setState(1492);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
						{
						{
						setState(1489);
						((ForAllContext)_localctx).formula = formula(0);
						}
						}
						setState(1494);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1495);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForAllContext)_localctx).element =  Formula.create(_localctx); for (int i = 0; i < ((FormulaContext)getInvokingContext(55)).var; i++) declarations.pop();
				}
				break;
			case 35:
				{
				_localctx = new ForSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1501);
				match(T__28);
				setState(1502);
				quantifierDeclarations();
				setState(1523);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1503);
					match(T__116);
					setState(1513);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
					case 1:
						{
						setState(1504);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1505);
						match(T__1);
						setState(1509);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
							{
							{
							setState(1506);
							((ForSomeContext)_localctx).formula = formula(0);
							}
							}
							setState(1511);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1512);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1515);
					match(T__1);
					setState(1519);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
						{
						{
						setState(1516);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						}
						setState(1521);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1522);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForSomeContext)_localctx).element =  Formula.create(_localctx); for (int i = 0; i < ((FormulaContext)getInvokingContext(55)).var; i++) declarations.pop();
				}
				break;
			case 36:
				{
				_localctx = new ForNoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1528);
				match(T__29);
				setState(1529);
				quantifierDeclarations();
				setState(1550);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1530);
					match(T__116);
					setState(1540);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
					case 1:
						{
						setState(1531);
						((ForNoContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1532);
						match(T__1);
						setState(1536);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
							{
							{
							setState(1533);
							((ForNoContext)_localctx).formula = formula(0);
							}
							}
							setState(1538);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1539);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1542);
					match(T__1);
					setState(1546);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
						{
						{
						setState(1543);
						((ForNoContext)_localctx).formula = formula(0);
						}
						}
						setState(1548);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1549);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForNoContext)_localctx).element =  Formula.create(_localctx); for (int i = 0; i < ((FormulaContext)getInvokingContext(55)).var; i++) declarations.pop();
				}
				break;
			case 37:
				{
				_localctx = new ForOneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1555);
				match(T__26);
				setState(1556);
				quantifierDeclarations();
				setState(1577);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1557);
					match(T__116);
					setState(1567);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
					case 1:
						{
						setState(1558);
						((ForOneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1559);
						match(T__1);
						setState(1563);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
							{
							{
							setState(1560);
							((ForOneContext)_localctx).formula = formula(0);
							}
							}
							setState(1565);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1566);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1569);
					match(T__1);
					setState(1573);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
						{
						{
						setState(1570);
						((ForOneContext)_localctx).formula = formula(0);
						}
						}
						setState(1575);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1576);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForOneContext)_localctx).element =  Formula.create(_localctx); for (int i = 0; i < ((FormulaContext)getInvokingContext(55)).var; i++) declarations.pop();
				}
				break;
			case 38:
				{
				_localctx = new ForLoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1582);
				match(T__27);
				setState(1583);
				quantifierDeclarations();
				setState(1604);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1584);
					match(T__116);
					setState(1594);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
					case 1:
						{
						setState(1585);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1586);
						match(T__1);
						setState(1590);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
							{
							{
							setState(1587);
							((ForLoneContext)_localctx).formula = formula(0);
							}
							}
							setState(1592);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1593);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1596);
					match(T__1);
					setState(1600);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
						{
						{
						setState(1597);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						}
						setState(1602);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1603);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForLoneContext)_localctx).element =  Formula.create(_localctx); for (int i = 0; i < ((FormulaContext)getInvokingContext(55)).var; i++) declarations.pop();
				}
				break;
			case 39:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1609);
				match(T__129);
				setState(1610);
				letDeclarations();
				setState(1631);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1611);
					match(T__116);
					setState(1621);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
					case 1:
						{
						setState(1612);
						((LetContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1613);
						match(T__1);
						setState(1617);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
							{
							{
							setState(1614);
							((LetContext)_localctx).formula = formula(0);
							}
							}
							setState(1619);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1620);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1623);
					match(T__1);
					setState(1627);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__133 - 129)) | (1L << (T__136 - 129)) | (1L << (T__137 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__149 - 129)) | (1L << (T__150 - 129)) | (1L << (T__151 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)))) != 0)) {
						{
						{
						setState(1624);
						((LetContext)_localctx).formula = formula(0);
						}
						}
						setState(1629);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1630);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((LetContext)_localctx).element =  Formula.create(_localctx); for (int i = 0; i < ((FormulaContext)getInvokingContext(55)).var; i++) declarations.pop();
				}
				break;
			case 40:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1635);
				match(T__14);
				((TrueContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 41:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1637);
				match(T__15);
				((FalseContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 42:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1639);
				match(T__31);
				setState(1640);
				((F_paranthesisContext)_localctx).formula = formula(0);
				setState(1641);
				match(T__32);
				((F_paranthesisContext)_localctx).element =  ((F_paranthesisContext)_localctx).formula.element;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1668);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1666);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1646);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1647);
						((AndContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__120 || _la==T__121) ) {
							((AndContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1648);
						((AndContext)_localctx).fright = ((AndContext)_localctx).formula = formula(14);
						((AndContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1651);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1652);
						((OrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__122 || _la==T__123) ) {
							((OrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1653);
						((OrContext)_localctx).fright = ((OrContext)_localctx).formula = formula(13);
						((OrContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1656);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1657);
						((ImpliesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__124 || _la==T__125) ) {
							((ImpliesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1658);
						((ImpliesContext)_localctx).fright = ((ImpliesContext)_localctx).formula = formula(11);
						((ImpliesContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1661);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1662);
						((IffContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__126 || _la==T__127) ) {
							((IffContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1663);
						((IffContext)_localctx).fright = ((IffContext)_localctx).formula = formula(10);
						((IffContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1670);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression element;
		public Stack<String> decls;
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this.element = ctx.element;
			this.decls = ctx.decls;
		}
	}
	public static class ProductContext extends ExpressionContext {
		public ExpressionContext left;
		public MultContext leftMult;
		public MultContext rightMult;
		public ExpressionContext right;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<MultContext> mult() {
			return getRuleContexts(MultContext.class);
		}
		public MultContext mult(int i) {
			return getRuleContext(MultContext.class,i);
		}
		public ProductContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoneContext extends ExpressionContext {
		public NoneContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitNone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnionContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public UnionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComprehensionContext extends ExpressionContext {
		public ComprehensionDeclarationsContext comprehensionDeclarations() {
			return getRuleContext(ComprehensionDeclarationsContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ComprehensionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterComprehension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitComprehension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitComprehension(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnivContext extends ExpressionContext {
		public UnivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterUniv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitUniv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUniv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReflexiveContext extends ExpressionContext {
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReflexiveContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterReflexive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitReflexive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitReflexive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class E_paranthesisContext extends ExpressionContext {
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public E_paranthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterE_paranthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitE_paranthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitE_paranthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdenContext extends ExpressionContext {
		public IdenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIden(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIden(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIden(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntsContext extends ExpressionContext {
		public IntsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInts(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntersectionContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IntersectionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIntersection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIntersection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIntersection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DifferenceContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DifferenceContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDifference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TransposeContext extends ExpressionContext {
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TransposeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTranspose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTranspose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTranspose(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JoinContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public JoinContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OverrideContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OverrideContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOverride(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOverride(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOverride(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfExpressionContext extends ExpressionContext {
		public FormulaContext condition;
		public ExpressionContext thenExpr;
		public ExpressionContext expression;
		public ExpressionContext elseExpr;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIfExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClosureContext extends ExpressionContext {
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClosureContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterClosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitClosure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitClosure(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeRefContext extends ExpressionContext {
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public TypeRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTypeRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoxJoinContext extends ExpressionContext {
		public ExpressionContext right;
		public ExpressionContext left;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BoxJoinContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBoxJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBoxJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBoxJoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_expression, _p);
		((ExpressionContext)getInvokingContext(56)).decls =  declarations;
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1716);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__130:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1672);
				match(T__130);
				setState(1673);
				((TransposeContext)_localctx).expression = expression(18);
				((TransposeContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__131:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1676);
				match(T__131);
				setState(1677);
				((ClosureContext)_localctx).expression = expression(17);
				((ClosureContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__74:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1680);
				match(T__74);
				setState(1681);
				((ReflexiveContext)_localctx).expression = expression(16);
				((ReflexiveContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__1:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				setState(1685);
				match(T__1);
				setState(1686);
				comprehensionDeclarations();
				setState(1687);
				match(T__116);
				setState(1688);
				formula(0);
				setState(1689);
				match(T__3);
				((ComprehensionContext)_localctx).element =  Expression.create(_localctx); for (int i = 0; i < ((FormulaContext)getInvokingContext(55)).var; i++) declarations.pop();
				}
				break;
			case T__133:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1692);
				match(T__133);
				setState(1693);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1694);
				match(T__134);
				setState(1695);
				((IfExpressionContext)_localctx).thenExpr = ((IfExpressionContext)_localctx).expression = expression(0);
				setState(1696);
				match(T__135);
				setState(1697);
				((IfExpressionContext)_localctx).elseExpr = ((IfExpressionContext)_localctx).expression = expression(7);
				((IfExpressionContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__136:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1700);
				match(T__136);
				((IdenContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__137:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1702);
				match(T__137);
				((NoneContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__138:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1704);
				match(T__138);
				((UnivContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__139:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1706);
				match(T__139);
				((IntsContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__31:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1708);
				match(T__31);
				setState(1709);
				((E_paranthesisContext)_localctx).expression = expression(0);
				setState(1710);
				match(T__32);
				((E_paranthesisContext)_localctx).element =  ((E_paranthesisContext)_localctx).expression.element;
				}
				break;
			case T__9:
			case T__11:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__33:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__43:
			case T__45:
			case T__47:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__64:
			case T__65:
			case T__66:
			case T__67:
			case T__68:
			case T__70:
			case T__71:
			case T__72:
			case T__78:
			case T__79:
			case T__80:
			case T__82:
			case T__83:
			case T__84:
			case T__85:
			case T__97:
			case T__98:
			case T__99:
			case T__101:
			case T__103:
			case T__105:
			case T__106:
			case T__149:
			case T__150:
			case T__151:
			case IDENTIFIER:
				{
				_localctx = new TypeRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1713);
				pathName(_localctx.element);
				((TypeRefContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1762);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,220,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1760);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1718);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1719);
						match(T__16);
						setState(1720);
						((UnionContext)_localctx).right = ((UnionContext)_localctx).expression = expression(16);
						((UnionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1723);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1724);
						match(T__88);
						setState(1725);
						((IntersectionContext)_localctx).right = ((IntersectionContext)_localctx).expression = expression(15);
						((IntersectionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1728);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1729);
						match(T__17);
						setState(1730);
						((DifferenceContext)_localctx).right = ((DifferenceContext)_localctx).expression = expression(14);
						((DifferenceContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1733);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1734);
						match(T__18);
						setState(1735);
						((JoinContext)_localctx).right = ((JoinContext)_localctx).expression = expression(13);
						((JoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1738);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1740);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0) || _la==T__148) {
							{
							setState(1739);
							((ProductContext)_localctx).leftMult = mult();
							}
						}

						setState(1742);
						match(T__118);
						setState(1744);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
						case 1:
							{
							setState(1743);
							((ProductContext)_localctx).rightMult = mult();
							}
							break;
						}
						setState(1746);
						((ProductContext)_localctx).right = ((ProductContext)_localctx).expression = expression(10);
						((ProductContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1749);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1750);
						match(T__132);
						setState(1751);
						((OverrideContext)_localctx).right = ((OverrideContext)_localctx).expression = expression(10);
						((OverrideContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 7:
						{
						_localctx = new BoxJoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxJoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1754);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1755);
						match(T__12);
						setState(1756);
						((BoxJoinContext)_localctx).left = ((BoxJoinContext)_localctx).expression = expression(0);
						setState(1757);
						match(T__13);
						((BoxJoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1764);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,220,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IntExpressionContext extends ParserRuleContext {
		public IntExpression element;
		public IntExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intExpression; }
	 
		public IntExpressionContext() { }
		public void copyFrom(IntExpressionContext ctx) {
			super.copyFrom(ctx);
			this.element = ctx.element;
		}
	}
	public static class MinusContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public MinusContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntConstantContext extends IntExpressionContext {
		public Token sign;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public IntConstantContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIntConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIntConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIntConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class I_paranthesisContext extends IntExpressionContext {
		public IntExpressionContext intExpression;
		public IntExpressionContext intExpression() {
			return getRuleContext(IntExpressionContext.class,0);
		}
		public I_paranthesisContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterI_paranthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitI_paranthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitI_paranthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfIntExpressionContext extends IntExpressionContext {
		public FormulaContext condition;
		public IntExpressionContext thenExpr;
		public IntExpressionContext intExpression;
		public IntExpressionContext elseExpr;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public IfIntExpressionContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIfIntExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIfIntExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIfIntExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CountContext extends IntExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CountContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitCount(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitCount(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumContext extends IntExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SumContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivideContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public DivideContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public MultiplyContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModuloContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public ModuloContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterModulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitModulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitModulo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public PlusContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntExpressionContext intExpression() throws RecognitionException {
		return intExpression(0);
	}

	private IntExpressionContext intExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IntExpressionContext _localctx = new IntExpressionContext(_ctx, _parentState);
		IntExpressionContext _prevctx = _localctx;
		int _startState = 114;
		enterRecursionRule(_localctx, 114, RULE_intExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1792);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__133:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1766);
				match(T__133);
				setState(1767);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1768);
				match(T__134);
				setState(1769);
				((IfIntExpressionContext)_localctx).thenExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(0);
				setState(1770);
				match(T__135);
				setState(1771);
				((IfIntExpressionContext)_localctx).elseExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(10);
				((IfIntExpressionContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__115:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1774);
				match(T__115);
				setState(1775);
				expression(0);
				((SumContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__48:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1778);
				match(T__48);
				setState(1779);
				expression(0);
				((CountContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__17:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1783);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(1782);
					((IntConstantContext)_localctx).sign = match(T__17);
					}
				}

				setState(1785);
				match(INT);
				((IntConstantContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__31:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1787);
				match(T__31);
				setState(1788);
				((I_paranthesisContext)_localctx).intExpression = intExpression(0);
				setState(1789);
				match(T__32);
				((I_paranthesisContext)_localctx).element =  ((I_paranthesisContext)_localctx).intExpression.element;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1821);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,224,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1819);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntExpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1794);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1795);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__140) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1796);
						((PlusContext)_localctx).iright = ((PlusContext)_localctx).intExpression = intExpression(8);
						((PlusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntExpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1799);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1800);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__141) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1801);
						((MinusContext)_localctx).iright = ((MinusContext)_localctx).intExpression = intExpression(7);
						((MinusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntExpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1804);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1805);
						_la = _input.LA(1);
						if ( !(_la==T__74 || _la==T__142) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1806);
						((MultiplyContext)_localctx).iright = ((MultiplyContext)_localctx).intExpression = intExpression(6);
						((MultiplyContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntExpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1809);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1810);
						_la = _input.LA(1);
						if ( !(_la==T__143 || _la==T__144) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1811);
						((DivideContext)_localctx).iright = ((DivideContext)_localctx).intExpression = intExpression(5);
						((DivideContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntExpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1814);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1815);
						_la = _input.LA(1);
						if ( !(_la==T__145 || _la==T__146) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1816);
						((ModuloContext)_localctx).iright = ((ModuloContext)_localctx).intExpression = intExpression(4);
						((ModuloContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1823);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,224,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class QuantifierDeclarationsContext extends ParserRuleContext {
		public List<QuantifierDeclaration> elements;
		public List<QuantifierDeclarationContext> quantifierDeclaration() {
			return getRuleContexts(QuantifierDeclarationContext.class);
		}
		public QuantifierDeclarationContext quantifierDeclaration(int i) {
			return getRuleContext(QuantifierDeclarationContext.class,i);
		}
		public QuantifierDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifierDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterQuantifierDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitQuantifierDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitQuantifierDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierDeclarationsContext quantifierDeclarations() throws RecognitionException {
		QuantifierDeclarationsContext _localctx = new QuantifierDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_quantifierDeclarations);
		((QuantifierDeclarationsContext)_localctx).elements =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824);
			quantifierDeclaration();
			setState(1829);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1825);
				match(T__2);
				setState(1826);
				quantifierDeclaration();
				}
				}
				setState(1831);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);
			for(QuantifierDeclarationContext ctx: _localctx.quantifierDeclaration()) _localctx.elements.add(ctx.element);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierDeclarationContext extends ParserRuleContext {
		public QuantifierDeclaration element;
		public QuantifierDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifierDeclaration; }
	 
		public QuantifierDeclarationContext() { }
		public void copyFrom(QuantifierDeclarationContext ctx) {
			super.copyFrom(ctx);
			this.element = ctx.element;
		}
	}
	public static class OneOfContext extends QuantifierDeclarationContext {
		public Token disj;
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public OneOfContext(QuantifierDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOneOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOneOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOneOf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomeOfContext extends QuantifierDeclarationContext {
		public Token disj;
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public SomeOfContext(QuantifierDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSomeOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSomeOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSomeOf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoneOfContext extends QuantifierDeclarationContext {
		public Token disj;
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public LoneOfContext(QuantifierDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLoneOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLoneOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLoneOf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetOfContext extends QuantifierDeclarationContext {
		public Token disj;
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public SetOfContext(QuantifierDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSetOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSetOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSetOf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierDeclarationContext quantifierDeclaration() throws RecognitionException {
		QuantifierDeclarationContext _localctx = new QuantifierDeclarationContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_quantifierDeclaration);
		int _la;
		try {
			setState(1898);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1833);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__147) {
					{
					setState(1832);
					((OneOfContext)_localctx).disj = match(T__147);
					}
				}

				setState(1835);
				((OneOfContext)_localctx).variable = variable();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
				setState(1840);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1836);
					match(T__2);
					setState(1837);
					((OneOfContext)_localctx).variable = variable();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
					}
					}
					setState(1842);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1843);
				match(T__5);
				setState(1845);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
				case 1:
					{
					setState(1844);
					match(T__26);
					}
					break;
				}
				setState(1847);
				expression(0);
				((OneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx); ((FormulaContext)getInvokingContext(55)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(55)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1851);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__147) {
					{
					setState(1850);
					((LoneOfContext)_localctx).disj = match(T__147);
					}
				}

				setState(1853);
				((LoneOfContext)_localctx).variable = variable();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
				setState(1858);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1854);
					match(T__2);
					setState(1855);
					((LoneOfContext)_localctx).variable = variable();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
					}
					}
					setState(1860);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1861);
				match(T__5);
				setState(1862);
				match(T__27);
				setState(1863);
				expression(0);
				((LoneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx); ((FormulaContext)getInvokingContext(55)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(55)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1867);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__147) {
					{
					setState(1866);
					((SomeOfContext)_localctx).disj = match(T__147);
					}
				}

				setState(1869);
				((SomeOfContext)_localctx).variable = variable();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
				setState(1874);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1870);
					match(T__2);
					setState(1871);
					((SomeOfContext)_localctx).variable = variable();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
					}
					}
					setState(1876);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1877);
				match(T__5);
				setState(1878);
				match(T__28);
				setState(1879);
				expression(0);
				((SomeOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx); ((FormulaContext)getInvokingContext(55)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(55)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1883);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__147) {
					{
					setState(1882);
					((SetOfContext)_localctx).disj = match(T__147);
					}
				}

				setState(1885);
				((SetOfContext)_localctx).variable = variable();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
				setState(1890);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1886);
					match(T__2);
					setState(1887);
					((SetOfContext)_localctx).variable = variable();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
					}
					}
					setState(1892);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1893);
				match(T__5);
				setState(1894);
				match(T__148);
				setState(1895);
				expression(0);
				((SetOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx); ((FormulaContext)getInvokingContext(55)).var =  declareVariables(((SetOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(55)).var);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetDeclarationsContext extends ParserRuleContext {
		public List<LetDeclaration> elements;
		public List<LetDeclarationContext> letDeclaration() {
			return getRuleContexts(LetDeclarationContext.class);
		}
		public LetDeclarationContext letDeclaration(int i) {
			return getRuleContext(LetDeclarationContext.class,i);
		}
		public LetDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLetDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLetDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLetDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetDeclarationsContext letDeclarations() throws RecognitionException {
		LetDeclarationsContext _localctx = new LetDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_letDeclarations);
		((LetDeclarationsContext)_localctx).elements =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1900);
			letDeclaration();
			setState(1905);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1901);
				match(T__2);
				setState(1902);
				letDeclaration();
				}
				}
				setState(1907);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);
			for(LetDeclarationContext ctx: _localctx.letDeclaration()) _localctx.elements.add(ctx.element);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetDeclarationContext extends ParserRuleContext {
		public LetDeclaration element;
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public LetDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLetDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLetDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLetDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetDeclarationContext letDeclaration() throws RecognitionException {
		LetDeclarationContext _localctx = new LetDeclarationContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_letDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1908);
			((LetDeclarationContext)_localctx).variable = variable();
			((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
			setState(1913);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1909);
				match(T__2);
				setState(1910);
				((LetDeclarationContext)_localctx).variable = variable();
				((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
				}
				}
				setState(1915);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1916);
			match(T__22);
			setState(1917);
			((LetDeclarationContext)_localctx).expression = expression(0);
			((LetDeclarationContext)_localctx).element =  new LetDeclaration(_localctx);  for(VariableContext ctx: _localctx.variable()) _localctx.element.addOwnedElements(ctx.element);  _localctx.element.addOwnedElements(((LetDeclarationContext)_localctx).expression.element); ((FormulaContext)getInvokingContext(55)).var =  declareVariables(((LetDeclarationContext)_localctx).vars, ((FormulaContext)getInvokingContext(55)).var);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComprehensionDeclarationsContext extends ParserRuleContext {
		public List<ComprehensionDeclaration> elements;
		public List<ComprehensionDeclarationContext> comprehensionDeclaration() {
			return getRuleContexts(ComprehensionDeclarationContext.class);
		}
		public ComprehensionDeclarationContext comprehensionDeclaration(int i) {
			return getRuleContext(ComprehensionDeclarationContext.class,i);
		}
		public ComprehensionDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comprehensionDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterComprehensionDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitComprehensionDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitComprehensionDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComprehensionDeclarationsContext comprehensionDeclarations() throws RecognitionException {
		ComprehensionDeclarationsContext _localctx = new ComprehensionDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_comprehensionDeclarations);
		((ComprehensionDeclarationsContext)_localctx).elements =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1920);
			comprehensionDeclaration();
			setState(1925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1921);
				match(T__2);
				setState(1922);
				comprehensionDeclaration();
				}
				}
				setState(1927);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);
			for(ComprehensionDeclarationContext ctx: _localctx.comprehensionDeclaration()) _localctx.elements.add(ctx.element);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComprehensionDeclarationContext extends ParserRuleContext {
		public ComprehensionDeclaration element;
		public Token disj;
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ComprehensionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comprehensionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterComprehensionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitComprehensionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitComprehensionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComprehensionDeclarationContext comprehensionDeclaration() throws RecognitionException {
		ComprehensionDeclarationContext _localctx = new ComprehensionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_comprehensionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1929);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__147) {
				{
				setState(1928);
				((ComprehensionDeclarationContext)_localctx).disj = match(T__147);
				}
			}

			{
			setState(1931);
			((ComprehensionDeclarationContext)_localctx).variable = variable();
			((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
			setState(1936);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1932);
				match(T__2);
				setState(1933);
				((ComprehensionDeclarationContext)_localctx).variable = variable();
				((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
				}
				}
				setState(1938);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1939);
			match(T__5);
			setState(1941);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
			case 1:
				{
				setState(1940);
				match(T__26);
				}
				break;
			}
			setState(1943);
			((ComprehensionDeclarationContext)_localctx).expression = expression(0);
			}
			((ComprehensionDeclarationContext)_localctx).element =  new ComprehensionDeclaration(_localctx); for(VariableContext ctx: _localctx.variable()) _localctx.element.addOwnedElements(ctx.element); _localctx.element.addOwnedElements(((ComprehensionDeclarationContext)_localctx).expression.element); ((FormulaContext)getInvokingContext(55)).var =  declareVariables(((ComprehensionDeclarationContext)_localctx).vars, ((FormulaContext)getInvokingContext(55)).var);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationIdContext extends ParserRuleContext {
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public RelationIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterRelationId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitRelationId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitRelationId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationIdContext relationId() throws RecognitionException {
		RelationIdContext _localctx = new RelationIdContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_relationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1947);
			unrestrictedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public Variable element;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1949);
			unrestrictedName();
			((VariableContext)_localctx).element =  new Variable(_localctx);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultContext extends ParserRuleContext {
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_mult);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1952);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0) || _la==T__148) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnrestrictedNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UnrestrictedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unrestrictedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterUnrestrictedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitUnrestrictedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUnrestrictedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnrestrictedNameContext unrestrictedName() throws RecognitionException {
		UnrestrictedNameContext _localctx = new UnrestrictedNameContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_unrestrictedName);
		try {
			setState(2019);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1954);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1955);
				match(T__23);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1956);
				match(T__38);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1957);
				match(T__97);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1958);
				match(T__98);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1959);
				match(T__24);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1960);
				match(T__49);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1961);
				match(T__79);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1962);
				match(T__149);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1963);
				match(T__106);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1964);
				match(T__39);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1965);
				match(T__82);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1966);
				match(T__150);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1967);
				match(T__30);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1968);
				match(T__40);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1969);
				match(T__20);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1970);
				match(T__105);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1971);
				match(T__25);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1972);
				match(T__70);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(1973);
				match(T__11);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(1974);
				match(T__71);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(1975);
				match(T__41);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(1976);
				match(T__21);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(1977);
				match(T__103);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(1978);
				match(T__101);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(1979);
				match(T__78);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(1980);
				match(T__47);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(1981);
				match(T__37);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(1982);
				match(T__85);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(1983);
				match(T__151);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(1984);
				match(T__68);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(1985);
				match(T__33);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(1986);
				match(T__72);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(1987);
				match(T__35);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(1988);
				match(T__43);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(1989);
				match(T__45);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(1990);
				match(T__36);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(1991);
				match(T__99);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(1992);
				match(T__83);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(1993);
				match(T__80);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(1994);
				match(T__84);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(1995);
				match(T__11);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 43);
				{
				setState(1996);
				match(T__9);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 44);
				{
				setState(1997);
				match(T__26);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 45);
				{
				setState(1998);
				match(T__27);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 46);
				{
				setState(1999);
				match(T__28);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 47);
				{
				setState(2000);
				match(T__29);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 48);
				{
				setState(2001);
				match(T__50);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 49);
				{
				setState(2002);
				match(T__51);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 50);
				{
				setState(2003);
				match(T__52);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 51);
				{
				setState(2004);
				match(T__53);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 52);
				{
				setState(2005);
				match(T__54);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 53);
				{
				setState(2006);
				match(T__55);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 54);
				{
				setState(2007);
				match(T__56);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 55);
				{
				setState(2008);
				match(T__57);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 56);
				{
				setState(2009);
				match(T__58);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 57);
				{
				setState(2010);
				match(T__59);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 58);
				{
				setState(2011);
				match(T__60);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 59);
				{
				setState(2012);
				match(T__61);
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 60);
				{
				setState(2013);
				match(T__62);
				}
				break;
			case 61:
				enterOuterAlt(_localctx, 61);
				{
				setState(2014);
				match(T__63);
				}
				break;
			case 62:
				enterOuterAlt(_localctx, 62);
				{
				setState(2015);
				match(T__64);
				}
				break;
			case 63:
				enterOuterAlt(_localctx, 63);
				{
				setState(2016);
				match(T__65);
				}
				break;
			case 64:
				enterOuterAlt(_localctx, 64);
				{
				setState(2017);
				match(T__66);
				}
				break;
			case 65:
				enterOuterAlt(_localctx, 65);
				{
				setState(2018);
				match(T__67);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AlloyInEcoreParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2021);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpperContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public UpperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterUpper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitUpper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUpper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpperContext upper() throws RecognitionException {
		UpperContext _localctx = new UpperContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2023);
			_la = _input.LA(1);
			if ( !(_la==T__74 || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LowerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public LowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lower; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerContext lower() throws RecognitionException {
		LowerContext _localctx = new LowerContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2025);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return slot_sempred((SlotContext)_localctx, predIndex);
		case 55:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 56:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 57:
			return intExpression_sempred((IntExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean slot_sempred(SlotContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return true;
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 10);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 11);
		}
		return true;
	}
	private boolean intExpression_sempred(IntExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 7);
		case 13:
			return precpred(_ctx, 6);
		case 14:
			return precpred(_ctx, 5);
		case 15:
			return precpred(_ctx, 4);
		case 16:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00a2\u07ee\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2"+
		"\3\2\3\2\3\2\3\2\7\2\u0096\n\2\f\2\16\2\u0099\13\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00a9\n\3\3\4\3\4\3\4\3\4\5\4"+
		"\u00af\n\4\3\4\7\4\u00b2\n\4\f\4\16\4\u00b5\13\4\3\4\3\4\3\4\5\4\u00ba"+
		"\n\4\3\5\3\5\3\5\3\5\5\5\u00c0\n\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6\u00c8\n"+
		"\6\3\6\3\6\3\6\3\6\3\6\7\6\u00cf\n\6\f\6\16\6\u00d2\13\6\3\6\3\6\3\6\5"+
		"\6\u00d7\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00df\n\7\f\7\16\7\u00e2\13\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00ea\n\7\f\7\16\7\u00ed\13\7\3\7\3\7\3\7"+
		"\5\7\u00f2\n\7\5\7\u00f4\n\7\3\b\3\b\5\b\u00f8\n\b\3\t\3\t\3\t\3\t\7\t"+
		"\u00fe\n\t\f\t\16\t\u0101\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u010d\n\13\3\f\3\f\3\r\3\r\3\16\5\16\u0114\n\16\3\16\3\16\3"+
		"\17\5\17\u0119\n\17\3\17\5\17\u011c\n\17\3\17\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\5\22\u0126\n\22\3\22\3\22\3\22\3\22\3\22\5\22\u012d\n\22\3"+
		"\22\3\22\7\22\u0131\n\22\f\22\16\22\u0134\13\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\5\23\u013f\n\23\3\23\3\23\3\23\3\23\3\24\5\24"+
		"\u0146\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u0161\n\24\f\24\16\24\u0164\13\24\3\24\3\24\5\24\u0168\n\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0173\n\25\3\26\5\26\u0176\n"+
		"\26\3\26\3\26\5\26\u017a\n\26\3\26\3\26\5\26\u017e\n\26\3\26\3\26\5\26"+
		"\u0182\n\26\3\26\5\26\u0185\n\26\3\26\3\26\3\26\5\26\u018a\n\26\3\26\3"+
		"\26\3\26\3\26\3\26\7\26\u0191\n\26\f\26\16\26\u0194\13\26\5\26\u0196\n"+
		"\26\3\26\3\26\3\26\5\26\u019b\n\26\3\26\3\26\3\26\5\26\u01a0\n\26\3\26"+
		"\3\26\3\26\5\26\u01a5\n\26\3\26\3\26\5\26\u01a9\n\26\5\26\u01ab\n\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7"+
		"\26\u01bb\n\26\f\26\16\26\u01be\13\26\3\26\3\26\5\26\u01c2\n\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\5\27\u01ca\n\27\3\30\5\30\u01cd\n\30\3\30\3\30"+
		"\5\30\u01d1\n\30\3\30\3\30\5\30\u01d5\n\30\3\30\5\30\u01d8\n\30\3\30\5"+
		"\30\u01db\n\30\3\30\5\30\u01de\n\30\3\30\3\30\5\30\u01e2\n\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u01e9\n\30\3\30\3\30\3\30\5\30\u01ee\n\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01fa\n\30\3\30\5\30"+
		"\u01fd\n\30\6\30\u01ff\n\30\r\30\16\30\u0200\3\30\5\30\u0204\n\30\3\30"+
		"\3\30\3\30\3\30\7\30\u020a\n\30\f\30\16\30\u020d\13\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u0215\n\30\3\30\3\30\3\30\7\30\u021a\n\30\f\30\16"+
		"\30\u021d\13\30\3\30\3\30\5\30\u0221\n\30\3\30\3\30\3\31\5\31\u0226\n"+
		"\31\3\31\3\31\5\31\u022a\n\31\3\31\3\31\5\31\u022e\n\31\3\31\5\31\u0231"+
		"\n\31\3\31\5\31\u0234\n\31\3\31\5\31\u0237\n\31\3\31\3\31\5\31\u023b\n"+
		"\31\3\31\3\31\3\31\3\31\5\31\u0241\n\31\3\31\3\31\3\31\3\31\5\31\u0247"+
		"\n\31\3\31\3\31\3\31\5\31\u024c\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u026c\n\31\3\31\5\31"+
		"\u026f\n\31\6\31\u0271\n\31\r\31\16\31\u0272\3\31\5\31\u0276\n\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u027d\n\31\f\31\16\31\u0280\13\31\3\31\3\31"+
		"\5\31\u0284\n\31\3\31\3\31\3\31\7\31\u0289\n\31\f\31\16\31\u028c\13\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0294\n\31\3\31\3\31\3\31\7\31\u0299"+
		"\n\31\f\31\16\31\u029c\13\31\3\31\3\31\3\31\5\31\u02a1\n\31\3\31\3\31"+
		"\5\31\u02a5\n\31\3\31\3\31\3\32\5\32\u02aa\n\32\3\32\3\32\5\32\u02ae\n"+
		"\32\3\32\3\32\5\32\u02b2\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32"+
		"\u02bb\n\32\f\32\16\32\u02be\13\32\5\32\u02c0\n\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u02c8\n\32\5\32\u02ca\n\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\7\32\u02d2\n\32\f\32\16\32\u02d5\13\32\5\32\u02d7\n\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u02df\n\32\3\32\5\32\u02e2\n\32\6\32\u02e4\n\32"+
		"\r\32\16\32\u02e5\3\32\5\32\u02e9\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u02f8\n\32\f\32\16\32\u02fb\13"+
		"\32\3\32\3\32\5\32\u02ff\n\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u030e\n\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u0316\n\35\3\35\5\35\u0319\n\35\6\35\u031b\n\35\r\35\16\35\u031c"+
		"\3\35\5\35\u0320\n\35\3\35\3\35\7\35\u0324\n\35\f\35\16\35\u0327\13\35"+
		"\3\35\3\35\5\35\u032b\n\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u0333\n"+
		"\36\3\36\5\36\u0336\n\36\3\36\3\36\5\36\u033a\n\36\3\36\3\36\3\36\3\37"+
		"\5\37\u0340\n\37\3\37\3\37\5\37\u0344\n\37\3\37\3\37\3\37\3\37\5\37\u034a"+
		"\n\37\3\37\3\37\3\37\5\37\u034f\n\37\3\37\3\37\3\37\3\37\5\37\u0355\n"+
		"\37\3\37\5\37\u0358\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0361"+
		"\n\37\f\37\16\37\u0364\13\37\3\37\3\37\5\37\u0368\n\37\3\37\3\37\3 \5"+
		" \u036d\n \3 \3 \3 \3 \3 \5 \u0374\n \3 \3 \3 \5 \u0379\n \3 \3 \3 \3"+
		" \5 \u037f\n \3 \5 \u0382\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u038e\n"+
		" \f \16 \u0391\13 \3 \3 \5 \u0395\n \3 \3 \3!\3!\3!\5!\u039c\n!\3!\3!"+
		"\3!\5!\u03a1\n!\3!\3!\3!\7!\u03a6\n!\f!\16!\u03a9\13!\3!\3!\3!\5!\u03ae"+
		"\n!\3\"\3\"\5\"\u03b2\n\"\3\"\3\"\3\"\3\"\3\"\7\"\u03b9\n\"\f\"\16\"\u03bc"+
		"\13\"\3\"\3\"\5\"\u03c0\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\6\"\u03cd\n\"\r\"\16\"\u03ce\3\"\3\"\3\"\5\"\u03d4\n\"\3#\5#\u03d7"+
		"\n#\3#\3#\5#\u03db\n#\3#\3#\3$\3$\3$\3$\3$\3$\5$\u03e5\n$\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\5%\u03f3\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u03fe"+
		"\n&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u0409\n(\f(\16(\u040c\13(\3(\3"+
		"(\3)\3)\3)\3)\3)\3)\7)\u0416\n)\f)\16)\u0419\13)\5)\u041b\n)\3)\3)\3*"+
		"\3*\3*\3*\3*\3*\5*\u0425\n*\3+\3+\3+\3+\3+\7+\u042c\n+\f+\16+\u042f\13"+
		"+\3+\3+\5+\u0433\n+\3,\3,\3,\3,\3,\3,\5,\u043b\n,\3-\3-\3-\3-\3-\3-\3"+
		"-\5-\u0444\n-\3.\3.\3.\5.\u0449\n.\3.\7.\u044c\n.\f.\16.\u044f\13.\3."+
		"\5.\u0452\n.\3/\3/\5/\u0456\n/\3/\3/\3/\5/\u045b\n/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0467\n\60\3\61\3\61\5\61\u046b\n"+
		"\61\3\61\3\61\3\61\5\61\u0470\n\61\3\61\3\61\5\61\u0474\n\61\3\61\3\61"+
		"\3\62\5\62\u0479\n\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0481\n\62\5"+
		"\62\u0483\n\62\3\62\3\62\3\62\5\62\u0488\n\62\3\62\3\62\5\62\u048c\n\62"+
		"\3\62\3\62\3\63\3\63\3\63\5\63\u0493\n\63\3\63\3\63\5\63\u0497\n\63\3"+
		"\63\3\63\3\64\3\64\3\64\3\64\3\64\5\64\u04a0\n\64\5\64\u04a2\n\64\3\64"+
		"\3\64\3\64\5\64\u04a7\n\64\3\64\3\64\5\64\u04ab\n\64\3\64\3\64\3\65\3"+
		"\65\3\65\3\65\3\65\5\65\u04b4\n\65\5\65\u04b6\n\65\3\65\3\65\3\65\5\65"+
		"\u04bb\n\65\3\65\3\65\5\65\u04bf\n\65\3\65\3\65\3\66\3\66\5\66\u04c5\n"+
		"\66\3\66\3\66\3\66\5\66\u04ca\n\66\3\66\3\66\5\66\u04ce\n\66\3\66\3\66"+
		"\3\67\3\67\5\67\u04d4\n\67\3\67\3\67\3\67\5\67\u04d9\n\67\3\67\3\67\5"+
		"\67\u04dd\n\67\3\67\3\67\38\38\38\58\u04e4\n8\38\38\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\59\u04fb\n9\39\39\39\39\39\39"+
		"\59\u0503\n9\39\39\39\39\39\39\59\u050b\n9\39\39\39\39\39\39\59\u0513"+
		"\n9\39\39\39\39\39\39\59\u051b\n9\39\39\39\39\39\39\59\u0523\n9\39\39"+
		"\39\39\39\39\59\u052b\n9\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\59\u05ab\n9"+
		"\39\59\u05ae\n9\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\79\u05cb\n9\f9\169\u05ce\139\39\59\u05d1\n"+
		"9\39\39\79\u05d5\n9\f9\169\u05d8\139\39\59\u05db\n9\39\39\39\39\39\39"+
		"\39\39\39\79\u05e6\n9\f9\169\u05e9\139\39\59\u05ec\n9\39\39\79\u05f0\n"+
		"9\f9\169\u05f3\139\39\59\u05f6\n9\39\39\39\39\39\39\39\39\39\79\u0601"+
		"\n9\f9\169\u0604\139\39\59\u0607\n9\39\39\79\u060b\n9\f9\169\u060e\13"+
		"9\39\59\u0611\n9\39\39\39\39\39\39\39\39\39\79\u061c\n9\f9\169\u061f\13"+
		"9\39\59\u0622\n9\39\39\79\u0626\n9\f9\169\u0629\139\39\59\u062c\n9\39"+
		"\39\39\39\39\39\39\39\39\79\u0637\n9\f9\169\u063a\139\39\59\u063d\n9\3"+
		"9\39\79\u0641\n9\f9\169\u0644\139\39\59\u0647\n9\39\39\39\39\39\39\39"+
		"\39\39\79\u0652\n9\f9\169\u0655\139\39\59\u0658\n9\39\39\79\u065c\n9\f"+
		"9\169\u065f\139\39\59\u0662\n9\39\39\39\39\39\39\39\39\39\39\39\59\u066f"+
		"\n9\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\79\u0685"+
		"\n9\f9\169\u0688\139\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\5:\u06b7\n:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\5:\u06cf\n:\3:\3:\5:\u06d3\n:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\7:\u06e3\n:\f:\16:\u06e6\13:\3;\3;\3;\3;"+
		"\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u06fa\n;\3;\3;\3;\3;\3;"+
		"\3;\3;\5;\u0703\n;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;"+
		"\3;\3;\3;\3;\3;\3;\3;\3;\7;\u071e\n;\f;\16;\u0721\13;\3<\3<\3<\7<\u0726"+
		"\n<\f<\16<\u0729\13<\3=\5=\u072c\n=\3=\3=\3=\7=\u0731\n=\f=\16=\u0734"+
		"\13=\3=\3=\5=\u0738\n=\3=\3=\3=\3=\5=\u073e\n=\3=\3=\3=\7=\u0743\n=\f"+
		"=\16=\u0746\13=\3=\3=\3=\3=\3=\3=\5=\u074e\n=\3=\3=\3=\7=\u0753\n=\f="+
		"\16=\u0756\13=\3=\3=\3=\3=\3=\3=\5=\u075e\n=\3=\3=\3=\7=\u0763\n=\f=\16"+
		"=\u0766\13=\3=\3=\3=\3=\3=\5=\u076d\n=\3>\3>\3>\7>\u0772\n>\f>\16>\u0775"+
		"\13>\3?\3?\3?\7?\u077a\n?\f?\16?\u077d\13?\3?\3?\3?\3?\3@\3@\3@\7@\u0786"+
		"\n@\f@\16@\u0789\13@\3A\5A\u078c\nA\3A\3A\3A\7A\u0791\nA\fA\16A\u0794"+
		"\13A\3A\3A\5A\u0798\nA\3A\3A\3A\3A\3B\3B\3C\3C\3C\3D\3D\3E\3E\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\5E\u07e6\nE\3F\3F\3G\3G\3"+
		"H\3H\3H\2\5prtI\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\2\26\3\2\21\22\3\2\23\24\3\2\35 \4\2\23\23MN\3\2\u009e"+
		"\u009f\4\2!!\\\\\3\2hi\3\2jk\3\2qr\3\2{|\3\2}~\3\2\177\u0080\3\2\u0081"+
		"\u0082\4\2\23\23\u008f\u008f\4\2\24\24\u0090\u0090\4\2MM\u0091\u0091\3"+
		"\2\u0092\u0093\3\2\u0094\u0095\4\2\35\37\u0097\u0097\4\2MM\u009b\u009b"+
		"\2\u095b\2\u0090\3\2\2\2\4\u00a8\3\2\2\2\6\u00ae\3\2\2\2\b\u00bb\3\2\2"+
		"\2\n\u00c4\3\2\2\2\f\u00d8\3\2\2\2\16\u00f7\3\2\2\2\20\u00f9\3\2\2\2\22"+
		"\u0104\3\2\2\2\24\u010c\3\2\2\2\26\u010e\3\2\2\2\30\u0110\3\2\2\2\32\u0113"+
		"\3\2\2\2\34\u0118\3\2\2\2\36\u0120\3\2\2\2 \u0122\3\2\2\2\"\u0125\3\2"+
		"\2\2$\u013a\3\2\2\2&\u0145\3\2\2\2(\u0172\3\2\2\2*\u0175\3\2\2\2,\u01c9"+
		"\3\2\2\2.\u01cc\3\2\2\2\60\u0225\3\2\2\2\62\u02a9\3\2\2\2\64\u0302\3\2"+
		"\2\2\66\u0305\3\2\2\28\u0308\3\2\2\2:\u032e\3\2\2\2<\u033f\3\2\2\2>\u036c"+
		"\3\2\2\2@\u039b\3\2\2\2B\u03af\3\2\2\2D\u03d6\3\2\2\2F\u03e4\3\2\2\2H"+
		"\u03f2\3\2\2\2J\u03fd\3\2\2\2L\u03ff\3\2\2\2N\u0404\3\2\2\2P\u040f\3\2"+
		"\2\2R\u0424\3\2\2\2T\u0426\3\2\2\2V\u043a\3\2\2\2X\u043c\3\2\2\2Z\u0445"+
		"\3\2\2\2\\\u0453\3\2\2\2^\u0466\3\2\2\2`\u0468\3\2\2\2b\u0478\3\2\2\2"+
		"d\u048f\3\2\2\2f\u049a\3\2\2\2h\u04ae\3\2\2\2j\u04c2\3\2\2\2l\u04d1\3"+
		"\2\2\2n\u04e3\3\2\2\2p\u066e\3\2\2\2r\u06b6\3\2\2\2t\u0702\3\2\2\2v\u0722"+
		"\3\2\2\2x\u076c\3\2\2\2z\u076e\3\2\2\2|\u0776\3\2\2\2~\u0782\3\2\2\2\u0080"+
		"\u078b\3\2\2\2\u0082\u079d\3\2\2\2\u0084\u079f\3\2\2\2\u0086\u07a2\3\2"+
		"\2\2\u0088\u07e5\3\2\2\2\u008a\u07e7\3\2\2\2\u008c\u07e9\3\2\2\2\u008e"+
		"\u07eb\3\2\2\2\u0090\u0091\7\3\2\2\u0091\u0092\7\4\2\2\u0092\u0097\5\4"+
		"\3\2\u0093\u0094\7\5\2\2\u0094\u0096\5\4\3\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\6\2\2\u009b\3\3\2\2\2\u009c\u009d"+
		"\7\7\2\2\u009d\u009e\7\b\2\2\u009e\u00a9\7\u009b\2\2\u009f\u00a0\7\t\2"+
		"\2\u00a0\u00a1\7\b\2\2\u00a1\u00a9\7\u009b\2\2\u00a2\u00a3\7\n\2\2\u00a3"+
		"\u00a4\7\b\2\2\u00a4\u00a9\7\u009b\2\2\u00a5\u00a6\7\13\2\2\u00a6\u00a7"+
		"\7\b\2\2\u00a7\u00a9\7\u009b\2\2\u00a8\u009c\3\2\2\2\u00a8\u009f\3\2\2"+
		"\2\u00a8\u00a2\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a9\5\3\2\2\2\u00aa\u00ab"+
		"\7\f\2\2\u00ab\u00ac\5\u008aF\2\u00ac\u00ad\7\r\2\2\u00ad\u00af\3\2\2"+
		"\2\u00ae\u00aa\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b3\3\2\2\2\u00b0\u00b2"+
		"\5$\23\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\5\b"+
		"\5\2\u00b7\u00ba\5\n\6\2\u00b8\u00ba\7\r\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00b8\3\2\2\2\u00ba\7\3\2\2\2\u00bb\u00bf\7\16\2\2\u00bc\u00bd\5\u0088"+
		"E\2\u00bd\u00be\7\b\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\u009e\2\2\u00c2\u00c3"+
		"\7\r\2\2\u00c3\t\3\2\2\2\u00c4\u00c5\5Z.\2\u00c5\u00c7\b\6\1\2\u00c6\u00c8"+
		"\5\24\13\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2"+
		"\u00c9\u00d6\b\6\1\2\u00ca\u00cb\7\4\2\2\u00cb\u00d0\5\f\7\2\u00cc\u00cd"+
		"\7\5\2\2\u00cd\u00cf\5\f\7\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d3\u00d4\7\6\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d7\7\r\2\2\u00d6"+
		"\u00ca\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\13\3\2\2\2\u00d8\u00d9\5\u0088"+
		"E\2\u00d9\u00f3\b\7\1\2\u00da\u00f1\7\b\2\2\u00db\u00dc\6\7\2\2\u00dc"+
		"\u00e0\7\4\2\2\u00dd\u00df\5\n\6\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00f2\7\6\2\2\u00e4\u00f2\5\22\n\2\u00e5\u00e6\7"+
		"\17\2\2\u00e6\u00eb\5\22\n\2\u00e7\u00e8\7\5\2\2\u00e8\u00ea\5\22\n\2"+
		"\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7\20\2\2"+
		"\u00ef\u00f2\3\2\2\2\u00f0\u00f2\5\16\b\2\u00f1\u00db\3\2\2\2\u00f1\u00e4"+
		"\3\2\2\2\u00f1\u00e5\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3"+
		"\u00da\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\r\3\2\2\2\u00f5\u00f8\5\24\13"+
		"\2\u00f6\u00f8\5\20\t\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8"+
		"\17\3\2\2\2\u00f9\u00fa\7\17\2\2\u00fa\u00ff\5\16\b\2\u00fb\u00fc\7\5"+
		"\2\2\u00fc\u00fe\5\16\b\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0102\u0103\7\20\2\2\u0103\21\3\2\2\2\u0104\u0105\5Z.\2\u0105\23"+
		"\3\2\2\2\u0106\u010d\5\26\f\2\u0107\u010d\5\32\16\2\u0108\u010d\5\34\17"+
		"\2\u0109\u010d\5\36\20\2\u010a\u010d\5\30\r\2\u010b\u010d\5 \21\2\u010c"+
		"\u0106\3\2\2\2\u010c\u0107\3\2\2\2\u010c\u0108\3\2\2\2\u010c\u0109\3\2"+
		"\2\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d\25\3\2\2\2\u010e\u010f"+
		"\5\u008aF\2\u010f\27\3\2\2\2\u0110\u0111\t\2\2\2\u0111\31\3\2\2\2\u0112"+
		"\u0114\t\3\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\u0116\7\u009b\2\2\u0116\33\3\2\2\2\u0117\u0119\t\3\2\2\u0118"+
		"\u0117\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u011c\7\u009b"+
		"\2\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011e\7\25\2\2\u011e\u011f\7\u009b\2\2\u011f\35\3\2\2\2\u0120\u0121\7"+
		"\u009d\2\2\u0121\37\3\2\2\2\u0122\u0123\7\26\2\2\u0123!\3\2\2\2\u0124"+
		"\u0126\5\2\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2"+
		"\2\2\u0127\u012c\b\22\1\2\u0128\u0129\7\16\2\2\u0129\u012a\5\u008aF\2"+
		"\u012a\u012b\7\r\2\2\u012b\u012d\3\2\2\2\u012c\u0128\3\2\2\2\u012c\u012d"+
		"\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0132\b\22\1\2\u012f\u0131\5$\23\2"+
		"\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\5&\24\2\u0136"+
		"\u0137\b\22\1\2\u0137\u0138\3\2\2\2\u0138\u0139\b\22\1\2\u0139#\3\2\2"+
		"\2\u013a\u013e\7\27\2\2\u013b\u013c\5\u008aF\2\u013c\u013d\7\b\2\2\u013d"+
		"\u013f\3\2\2\2\u013e\u013b\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2"+
		"\2\2\u0140\u0141\7\u009e\2\2\u0141\u0142\7\r\2\2\u0142\u0143\b\23\1\2"+
		"\u0143%\3\2\2\2\u0144\u0146\5n8\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0147\3\2\2\2\u0147\u0148\b\24\1\2\u0148\u0149\7\30\2\2\u0149"+
		"\u014a\5\u0088E\2\u014a\u014b\b\24\1\2\u014b\u014c\b\24\1\2\u014c\u014d"+
		"\7\b\2\2\u014d\u014e\5\u008aF\2\u014e\u014f\3\2\2\2\u014f\u0150\7\31\2"+
		"\2\u0150\u0151\7\u009e\2\2\u0151\u0152\3\2\2\2\u0152\u0167\b\24\1\2\u0153"+
		"\u0162\7\4\2\2\u0154\u0155\5B\"\2\u0155\u0156\b\24\1\2\u0156\u0161\3\2"+
		"\2\2\u0157\u0158\5&\24\2\u0158\u0159\b\24\1\2\u0159\u0161\3\2\2\2\u015a"+
		"\u015b\5(\25\2\u015b\u015c\b\24\1\2\u015c\u0161\3\2\2\2\u015d\u015e\5"+
		"b\62\2\u015e\u015f\b\24\1\2\u015f\u0161\3\2\2\2\u0160\u0154\3\2\2\2\u0160"+
		"\u0157\3\2\2\2\u0160\u015a\3\2\2\2\u0160\u015d\3\2\2\2\u0161\u0164\3\2"+
		"\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164"+
		"\u0162\3\2\2\2\u0165\u0168\7\6\2\2\u0166\u0168\7\r\2\2\u0167\u0153\3\2"+
		"\2\2\u0167\u0166\3\2\2\2\u0168\'\3\2\2\2\u0169\u016a\5*\26\2\u016a\u016b"+
		"\b\25\1\2\u016b\u0173\3\2\2\2\u016c\u016d\5<\37\2\u016d\u016e\b\25\1\2"+
		"\u016e\u0173\3\2\2\2\u016f\u0170\5> \2\u0170\u0171\b\25\1\2\u0171\u0173"+
		"\3\2\2\2\u0172\u0169\3\2\2\2\u0172\u016c\3\2\2\2\u0172\u016f\3\2\2\2\u0173"+
		")\3\2\2\2\u0174\u0176\5n8\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u017d\b\26\1\2\u0178\u017a\7\32\2\2\u0179\u0178\3"+
		"\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017e\7\33\2\2\u017c"+
		"\u017e\7\34\2\2\u017d\u0179\3\2\2\2\u017d\u017c\3\2\2\2\u017e\u017f\3"+
		"\2\2\2\u017f\u0181\b\26\1\2\u0180\u0182\t\4\2\2\u0181\u0180\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183\u0185\5\u0088E\2\u0184\u0183"+
		"\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\b\26\1\2"+
		"\u0187\u0189\b\26\1\2\u0188\u018a\5N(\2\u0189\u0188\3\2\2\2\u0189\u018a"+
		"\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u0195\b\26\1\2\u018c\u018d\7!\2\2\u018d"+
		"\u0192\5\66\34\2\u018e\u018f\7\5\2\2\u018f\u0191\5\66\34\2\u0190\u018e"+
		"\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u018c\3\2\2\2\u0195\u0196\3\2"+
		"\2\2\u0196\u0197\3\2\2\2\u0197\u019a\b\26\1\2\u0198\u0199\7\b\2\2\u0199"+
		"\u019b\7\u009e\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c"+
		"\3\2\2\2\u019c\u01aa\b\26\1\2\u019d\u01a0\7\17\2\2\u019e\u01a0\7\"\2\2"+
		"\u019f\u019d\3\2\2\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a4"+
		"\7\u009b\2\2\u01a2\u01a3\7\5\2\2\u01a3\u01a5\7\u009b\2\2\u01a4\u01a2\3"+
		"\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a8\3\2\2\2\u01a6\u01a9\7\20\2\2\u01a7"+
		"\u01a9\7#\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9\u01ab\3\2"+
		"\2\2\u01aa\u019f\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac"+
		"\u01c1\b\26\1\2\u01ad\u01bc\7\4\2\2\u01ae\u01af\5B\"\2\u01af\u01b0\b\26"+
		"\1\2\u01b0\u01bb\3\2\2\2\u01b1\u01b2\5\62\32\2\u01b2\u01b3\b\26\1\2\u01b3"+
		"\u01bb\3\2\2\2\u01b4\u01b5\5,\27\2\u01b5\u01b6\b\26\1\2\u01b6\u01bb\3"+
		"\2\2\2\u01b7\u01b8\5b\62\2\u01b8\u01b9\b\26\1\2\u01b9\u01bb\3\2\2\2\u01ba"+
		"\u01ae\3\2\2\2\u01ba\u01b1\3\2\2\2\u01ba\u01b4\3\2\2\2\u01ba\u01b7\3\2"+
		"\2\2\u01bb\u01be\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd"+
		"\u01bf\3\2\2\2\u01be\u01bc\3\2\2\2\u01bf\u01c2\7\6\2\2\u01c0\u01c2\7\r"+
		"\2\2\u01c1\u01ad\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2+\3\2\2\2\u01c3\u01c4"+
		"\5.\30\2\u01c4\u01c5\b\27\1\2\u01c5\u01ca\3\2\2\2\u01c6\u01c7\5\60\31"+
		"\2\u01c7\u01c8\b\27\1\2\u01c8\u01ca\3\2\2\2\u01c9\u01c3\3\2\2\2\u01c9"+
		"\u01c6\3\2\2\2\u01ca-\3\2\2\2\u01cb\u01cd\5n8\2\u01cc\u01cb\3\2\2\2\u01cc"+
		"\u01cd\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\b\30\1\2\u01cf\u01d1\7"+
		"$\2\2\u01d0\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2"+
		"\u01d5\7\16\2\2\u01d3\u01d5\7%\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d3\3\2"+
		"\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d8\7&\2\2\u01d7"+
		"\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9\u01db\7\'"+
		"\2\2\u01da\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dd\3\2\2\2\u01dc"+
		"\u01de\7(\2\2\u01dd\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\3\2"+
		"\2\2\u01df\u01e1\7)\2\2\u01e0\u01e2\t\4\2\2\u01e1\u01e0\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\5\u0088E\2\u01e4\u01e5"+
		"\b\30\1\2\u01e5\u01e6\7\b\2\2\u01e6\u01e8\5V,\2\u01e7\u01e9\5:\36\2\u01e8"+
		"\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ed\b\30"+
		"\1\2\u01eb\u01ec\7\31\2\2\u01ec\u01ee\7\u009e\2\2\u01ed\u01eb\3\2\2\2"+
		"\u01ed\u01ee\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u0203\b\30\1\2\u01f0\u01fe"+
		"\7\4\2\2\u01f1\u01fa\7*\2\2\u01f2\u01fa\7+\2\2\u01f3\u01fa\7,\2\2\u01f4"+
		"\u01fa\7-\2\2\u01f5\u01fa\7.\2\2\u01f6\u01fa\7/\2\2\u01f7\u01fa\7\60\2"+
		"\2\u01f8\u01fa\7\61\2\2\u01f9\u01f1\3\2\2\2\u01f9\u01f2\3\2\2\2\u01f9"+
		"\u01f3\3\2\2\2\u01f9\u01f4\3\2\2\2\u01f9\u01f5\3\2\2\2\u01f9\u01f6\3\2"+
		"\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01f8\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb"+
		"\u01fd\7\5\2\2\u01fc\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01ff\3\2"+
		"\2\2\u01fe\u01f9\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u01fe\3\2\2\2\u0200"+
		"\u0201\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0204\7\6\2\2\u0203\u01f0\3\2"+
		"\2\2\u0203\u0204\3\2\2\2\u0204\u0220\3\2\2\2\u0205\u020b\7\4\2\2\u0206"+
		"\u0207\5B\"\2\u0207\u0208\b\30\1\2\u0208\u020a\3\2\2\2\u0209\u0206\3\2"+
		"\2\2\u020a\u020d\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c"+
		"\u0214\3\2\2\2\u020d\u020b\3\2\2\2\u020e\u020f\5l\67\2\u020f\u0210\b\30"+
		"\1\2\u0210\u0215\3\2\2\2\u0211\u0212\5j\66\2\u0212\u0213\b\30\1\2\u0213"+
		"\u0215\3\2\2\2\u0214\u020e\3\2\2\2\u0214\u0211\3\2\2\2\u0214\u0215\3\2"+
		"\2\2\u0215\u021b\3\2\2\2\u0216\u0217\5B\"\2\u0217\u0218\b\30\1\2\u0218"+
		"\u021a\3\2\2\2\u0219\u0216\3\2\2\2\u021a\u021d\3\2\2\2\u021b\u0219\3\2"+
		"\2\2\u021b\u021c\3\2\2\2\u021c\u021e\3\2\2\2\u021d\u021b\3\2\2\2\u021e"+
		"\u0221\7\6\2\2\u021f\u0221\7\r\2\2\u0220\u0205\3\2\2\2\u0220\u021f\3\2"+
		"\2\2\u0221\u0222\3\2\2\2\u0222\u0223\b\30\1\2\u0223/\3\2\2\2\u0224\u0226"+
		"\5n8\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2\2\2\u0227"+
		"\u0229\b\31\1\2\u0228\u022a\7$\2\2\u0229\u0228\3\2\2\2\u0229\u022a\3\2"+
		"\2\2\u022a\u022d\3\2\2\2\u022b\u022e\7\16\2\2\u022c\u022e\7%\2\2\u022d"+
		"\u022b\3\2\2\2\u022d\u022c\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0230\3\2"+
		"\2\2\u022f\u0231\7&\2\2\u0230\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231"+
		"\u0233\3\2\2\2\u0232\u0234\7\'\2\2\u0233\u0232\3\2\2\2\u0233\u0234\3\2"+
		"\2\2\u0234\u0236\3\2\2\2\u0235\u0237\7(\2\2\u0236\u0235\3\2\2\2\u0236"+
		"\u0237\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u023a\7\62\2\2\u0239\u023b\t"+
		"\4\2\2\u023a\u0239\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3\2\2\2\u023c"+
		"\u023d\5\u0088E\2\u023d\u0240\b\31\1\2\u023e\u023f\7\63\2\2\u023f\u0241"+
		"\5\u0088E\2\u0240\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\3\2\2"+
		"\2\u0242\u0243\b\31\1\2\u0243\u0244\7\b\2\2\u0244\u0246\5V,\2\u0245\u0247"+
		"\5:\36\2\u0246\u0245\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248\3\2\2\2\u0248"+
		"\u024b\b\31\1\2\u0249\u024a\7\31\2\2\u024a\u024c\7\u009e\2\2\u024b\u0249"+
		"\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u0275\b\31\1\2"+
		"\u024e\u0270\7\4\2\2\u024f\u026c\7\64\2\2\u0250\u026c\7*\2\2\u0251\u026c"+
		"\7\65\2\2\u0252\u026c\7\66\2\2\u0253\u026c\7\67\2\2\u0254\u026c\78\2\2"+
		"\u0255\u026c\79\2\2\u0256\u026c\7:\2\2\u0257\u026c\7;\2\2\u0258\u026c"+
		"\7<\2\2\u0259\u026c\7=\2\2\u025a\u026c\7>\2\2\u025b\u026c\7?\2\2\u025c"+
		"\u026c\7@\2\2\u025d\u026c\7A\2\2\u025e\u026c\7B\2\2\u025f\u026c\7C\2\2"+
		"\u0260\u026c\7D\2\2\u0261\u026c\7E\2\2\u0262\u026c\7F\2\2\u0263\u026c"+
		"\7,\2\2\u0264\u026c\7-\2\2\u0265\u026c\7.\2\2\u0266\u026c\7/\2\2\u0267"+
		"\u026c\7G\2\2\u0268\u026c\7H\2\2\u0269\u026c\7\60\2\2\u026a\u026c\7\61"+
		"\2\2\u026b\u024f\3\2\2\2\u026b\u0250\3\2\2\2\u026b\u0251\3\2\2\2\u026b"+
		"\u0252\3\2\2\2\u026b\u0253\3\2\2\2\u026b\u0254\3\2\2\2\u026b\u0255\3\2"+
		"\2\2\u026b\u0256\3\2\2\2\u026b\u0257\3\2\2\2\u026b\u0258\3\2\2\2\u026b"+
		"\u0259\3\2\2\2\u026b\u025a\3\2\2\2\u026b\u025b\3\2\2\2\u026b\u025c\3\2"+
		"\2\2\u026b\u025d\3\2\2\2\u026b\u025e\3\2\2\2\u026b\u025f\3\2\2\2\u026b"+
		"\u0260\3\2\2\2\u026b\u0261\3\2\2\2\u026b\u0262\3\2\2\2\u026b\u0263\3\2"+
		"\2\2\u026b\u0264\3\2\2\2\u026b\u0265\3\2\2\2\u026b\u0266\3\2\2\2\u026b"+
		"\u0267\3\2\2\2\u026b\u0268\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026a\3\2"+
		"\2\2\u026c\u026e\3\2\2\2\u026d\u026f\7\5\2\2\u026e\u026d\3\2\2\2\u026e"+
		"\u026f\3\2\2\2\u026f\u0271\3\2\2\2\u0270\u026b\3\2\2\2\u0271\u0272\3\2"+
		"\2\2\u0272\u0270\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0274\3\2\2\2\u0274"+
		"\u0276\7\6\2\2\u0275\u024e\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u02a4\3\2"+
		"\2\2\u0277\u0283\7\4\2\2\u0278\u0279\7I\2\2\u0279\u027e\5\u0088E\2\u027a"+
		"\u027b\7\5\2\2\u027b\u027d\5\u0088E\2\u027c\u027a\3\2\2\2\u027d\u0280"+
		"\3\2\2\2\u027e\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0281\3\2\2\2\u0280"+
		"\u027e\3\2\2\2\u0281\u0282\7\r\2\2\u0282\u0284\3\2\2\2\u0283\u0278\3\2"+
		"\2\2\u0283\u0284\3\2\2\2\u0284\u028a\3\2\2\2\u0285\u0286\5B\"\2\u0286"+
		"\u0287\b\31\1\2\u0287\u0289\3\2\2\2\u0288\u0285\3\2\2\2\u0289\u028c\3"+
		"\2\2\2\u028a\u0288\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u0293\3\2\2\2\u028c"+
		"\u028a\3\2\2\2\u028d\u028e\5l\67\2\u028e\u028f\b\31\1\2\u028f\u0294\3"+
		"\2\2\2\u0290\u0291\5j\66\2\u0291\u0292\b\31\1\2\u0292\u0294\3\2\2\2\u0293"+
		"\u028d\3\2\2\2\u0293\u0290\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u029a\3\2"+
		"\2\2\u0295\u0296\5B\"\2\u0296\u0297\b\31\1\2\u0297\u0299\3\2\2\2\u0298"+
		"\u0295\3\2\2\2\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2"+
		"\2\2\u029b\u02a0\3\2\2\2\u029c\u029a\3\2\2\2\u029d\u029e\5d\63\2\u029e"+
		"\u029f\b\31\1\2\u029f\u02a1\3\2\2\2\u02a0\u029d\3\2\2\2\u02a0\u02a1\3"+
		"\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a5\7\6\2\2\u02a3\u02a5\7\r\2\2\u02a4"+
		"\u0277\3\2\2\2\u02a4\u02a3\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a7\b\31"+
		"\1\2\u02a7\61\3\2\2\2\u02a8\u02aa\5n8\2\u02a9\u02a8\3\2\2\2\u02a9\u02aa"+
		"\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ad\b\32\1\2\u02ac\u02ae\7$\2\2\u02ad"+
		"\u02ac\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b1\7J"+
		"\2\2\u02b0\u02b2\5N(\2\u02b1\u02b0\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b3"+
		"\3\2\2\2\u02b3\u02b4\b\32\1\2\u02b4\u02b5\5\u0088E\2\u02b5\u02b6\b\32"+
		"\1\2\u02b6\u02bf\7\"\2\2\u02b7\u02bc\58\35\2\u02b8\u02b9\7\5\2\2\u02b9"+
		"\u02bb\58\35\2\u02ba\u02b8\3\2\2\2\u02bb\u02be\3\2\2\2\u02bc\u02ba\3\2"+
		"\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02c0\3\2\2\2\u02be\u02bc\3\2\2\2\u02bf"+
		"\u02b7\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\7#"+
		"\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c9\b\32\1\2\u02c4\u02c5\7\b\2\2\u02c5"+
		"\u02c7\5V,\2\u02c6\u02c8\5:\36\2\u02c7\u02c6\3\2\2\2\u02c7\u02c8\3\2\2"+
		"\2\u02c8\u02ca\3\2\2\2\u02c9\u02c4\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb"+
		"\3\2\2\2\u02cb\u02cc\b\32\1\2\u02cc\u02d6\b\32\1\2\u02cd\u02ce\7K\2\2"+
		"\u02ce\u02d3\5\64\33\2\u02cf\u02d0\7\5\2\2\u02d0\u02d2\5\64\33\2\u02d1"+
		"\u02cf\3\2\2\2\u02d2\u02d5\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2"+
		"\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d6\u02cd\3\2\2\2\u02d6"+
		"\u02d7\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02e8\b\32\1\2\u02d9\u02e3\7"+
		"\4\2\2\u02da\u02df\7,\2\2\u02db\u02df\7-\2\2\u02dc\u02df\7.\2\2\u02dd"+
		"\u02df\7/\2\2\u02de\u02da\3\2\2\2\u02de\u02db\3\2\2\2\u02de\u02dc\3\2"+
		"\2\2\u02de\u02dd\3\2\2\2\u02df\u02e1\3\2\2\2\u02e0\u02e2\7\5\2\2\u02e1"+
		"\u02e0\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e4\3\2\2\2\u02e3\u02de\3\2"+
		"\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6"+
		"\u02e7\3\2\2\2\u02e7\u02e9\7\6\2\2\u02e8\u02d9\3\2\2\2\u02e8\u02e9\3\2"+
		"\2\2\u02e9\u02fe\3\2\2\2\u02ea\u02f9\7\4\2\2\u02eb\u02ec\5B\"\2\u02ec"+
		"\u02ed\b\32\1\2\u02ed\u02f8\3\2\2\2\u02ee\u02ef\5f\64\2\u02ef\u02f0\b"+
		"\32\1\2\u02f0\u02f8\3\2\2\2\u02f1\u02f2\5`\61\2\u02f2\u02f3\b\32\1\2\u02f3"+
		"\u02f8\3\2\2\2\u02f4\u02f5\5h\65\2\u02f5\u02f6\b\32\1\2\u02f6\u02f8\3"+
		"\2\2\2\u02f7\u02eb\3\2\2\2\u02f7\u02ee\3\2\2\2\u02f7\u02f1\3\2\2\2\u02f7"+
		"\u02f4\3\2\2\2\u02f8\u02fb\3\2\2\2\u02f9\u02f7\3\2\2\2\u02f9\u02fa\3\2"+
		"\2\2\u02fa\u02fc\3\2\2\2\u02fb\u02f9\3\2\2\2\u02fc\u02ff\7\6\2\2\u02fd"+
		"\u02ff\7\r\2\2\u02fe\u02ea\3\2\2\2\u02fe\u02fd\3\2\2\2\u02ff\u0300\3\2"+
		"\2\2\u0300\u0301\b\32\1\2\u0301\63\3\2\2\2\u0302\u0303\5T+\2\u0303\u0304"+
		"\b\33\1\2\u0304\65\3\2\2\2\u0305\u0306\5T+\2\u0306\u0307\b\34\1\2\u0307"+
		"\67\3\2\2\2\u0308\u0309\5\u0088E\2\u0309\u030a\b\35\1\2\u030a\u030b\7"+
		"\b\2\2\u030b\u030d\5V,\2\u030c\u030e\5:\36\2\u030d\u030c\3\2\2\2\u030d"+
		"\u030e\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u031f\b\35\1\2\u0310\u031a\7"+
		"\4\2\2\u0311\u0316\7,\2\2\u0312\u0316\7-\2\2\u0313\u0316\7.\2\2\u0314"+
		"\u0316\7/\2\2\u0315\u0311\3\2\2\2\u0315\u0312\3\2\2\2\u0315\u0313\3\2"+
		"\2\2\u0315\u0314\3\2\2\2\u0316\u0318\3\2\2\2\u0317\u0319\7\5\2\2\u0318"+
		"\u0317\3\2\2\2\u0318\u0319\3\2\2\2\u0319\u031b\3\2\2\2\u031a\u0315\3\2"+
		"\2\2\u031b\u031c\3\2\2\2\u031c\u031a\3\2\2\2\u031c\u031d\3\2\2\2\u031d"+
		"\u031e\3\2\2\2\u031e\u0320\7\6\2\2\u031f\u0310\3\2\2\2\u031f\u0320\3\2"+
		"\2\2\u0320\u032a\3\2\2\2\u0321\u0325\7\4\2\2\u0322\u0324\5B\"\2\u0323"+
		"\u0322\3\2\2\2\u0324\u0327\3\2\2\2\u0325\u0323\3\2\2\2\u0325\u0326\3\2"+
		"\2\2\u0326\u0328\3\2\2\2\u0327\u0325\3\2\2\2\u0328\u0329\b\35\1\2\u0329"+
		"\u032b\7\6\2\2\u032a\u0321\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032c\3\2"+
		"\2\2\u032c\u032d\b\35\1\2\u032d9\3\2\2\2\u032e\u0335\7\17\2\2\u032f\u0332"+
		"\5\u008eH\2\u0330\u0331\7L\2\2\u0331\u0333\5\u008cG\2\u0332\u0330\3\2"+
		"\2\2\u0332\u0333\3\2\2\2\u0333\u0336\3\2\2\2\u0334\u0336\t\5\2\2\u0335"+
		"\u032f\3\2\2\2\u0335\u0334\3\2\2\2\u0336\u0339\3\2\2\2\u0337\u033a\7O"+
		"\2\2\u0338\u033a\7P\2\2\u0339\u0337\3\2\2\2\u0339\u0338\3\2\2\2\u0339"+
		"\u033a\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u033c\7\20\2\2\u033c\u033d\b"+
		"\36\1\2\u033d;\3\2\2\2\u033e\u0340\5n8\2\u033f\u033e\3\2\2\2\u033f\u0340"+
		"\3\2\2\2\u0340\u0341\3\2\2\2\u0341\u0343\b\37\1\2\u0342\u0344\7Q\2\2\u0343"+
		"\u0342\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0346\7R"+
		"\2\2\u0346\u0347\5\u0088E\2\u0347\u0349\b\37\1\2\u0348\u034a\5N(\2\u0349"+
		"\u0348\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034e\b\37"+
		"\1\2\u034c\u034d\7\b\2\2\u034d\u034f\7\u009e\2\2\u034e\u034c\3\2\2\2\u034e"+
		"\u034f\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u0357\b\37\1\2\u0351\u0354\7"+
		"\4\2\2\u0352\u0355\7S\2\2\u0353\u0355\7T\2\2\u0354\u0352\3\2\2\2\u0354"+
		"\u0353\3\2\2\2\u0354\u0355\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u0358\7\6"+
		"\2\2\u0357\u0351\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u0367\3\2\2\2\u0359"+
		"\u0362\7\4\2\2\u035a\u035b\5B\"\2\u035b\u035c\b\37\1\2\u035c\u0361\3\2"+
		"\2\2\u035d\u035e\5b\62\2\u035e\u035f\b\37\1\2\u035f\u0361\3\2\2\2\u0360"+
		"\u035a\3\2\2\2\u0360\u035d\3\2\2\2\u0361\u0364\3\2\2\2\u0362\u0360\3\2"+
		"\2\2\u0362\u0363\3\2\2\2\u0363\u0365\3\2\2\2\u0364\u0362\3\2\2\2\u0365"+
		"\u0368\7\6\2\2\u0366\u0368\7\r\2\2\u0367\u0359\3\2\2\2\u0367\u0366\3\2"+
		"\2\2\u0368\u0369\3\2\2\2\u0369\u036a\b\37\1\2\u036a=\3\2\2\2\u036b\u036d"+
		"\5n8\2\u036c\u036b\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u036e\3\2\2\2\u036e"+
		"\u036f\b \1\2\u036f\u0370\7U\2\2\u0370\u0371\5\u0088E\2\u0371\u0373\b"+
		" \1\2\u0372\u0374\5N(\2\u0373\u0372\3\2\2\2\u0373\u0374\3\2\2\2\u0374"+
		"\u0375\3\2\2\2\u0375\u0378\b \1\2\u0376\u0377\7\b\2\2\u0377\u0379\7\u009e"+
		"\2\2\u0378\u0376\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037a\3\2\2\2\u037a"+
		"\u0381\b \1\2\u037b\u037e\7\4\2\2\u037c\u037f\7S\2\2\u037d\u037f\7T\2"+
		"\2\u037e\u037c\3\2\2\2\u037e\u037d\3\2\2\2\u037e\u037f\3\2\2\2\u037f\u0380"+
		"\3\2\2\2\u0380\u0382\7\6\2\2\u0381\u037b\3\2\2\2\u0381\u0382\3\2\2\2\u0382"+
		"\u0394\3\2\2\2\u0383\u038f\7\4\2\2\u0384\u0385\5B\"\2\u0385\u0386\b \1"+
		"\2\u0386\u038e\3\2\2\2\u0387\u0388\5@!\2\u0388\u0389\b \1\2\u0389\u038e"+
		"\3\2\2\2\u038a\u038b\5b\62\2\u038b\u038c\b \1\2\u038c\u038e\3\2\2\2\u038d"+
		"\u0384\3\2\2\2\u038d\u0387\3\2\2\2\u038d\u038a\3\2\2\2\u038e\u0391\3\2"+
		"\2\2\u038f\u038d\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u0392\3\2\2\2\u0391"+
		"\u038f\3\2\2\2\u0392\u0395\7\6\2\2\u0393\u0395\7\r\2\2\u0394\u0383\3\2"+
		"\2\2\u0394\u0393\3\2\2\2\u0395\u0396\3\2\2\2\u0396\u0397\b \1\2\u0397"+
		"?\3\2\2\2\u0398\u0399\7V\2\2\u0399\u039c\5\u0088E\2\u039a\u039c\5\u0088"+
		"E\2\u039b\u0398\3\2\2\2\u039b\u039a\3\2\2\2\u039c\u039d\3\2\2\2\u039d"+
		"\u03a0\b!\1\2\u039e\u039f\7\31\2\2\u039f\u03a1\7\u009b\2\2\u03a0\u039e"+
		"\3\2\2\2\u03a0\u03a1\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03ad\b!\1\2\u03a3"+
		"\u03a7\7\4\2\2\u03a4\u03a6\5B\"\2\u03a5\u03a4\3\2\2\2\u03a6\u03a9\3\2"+
		"\2\2\u03a7\u03a5\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03aa\3\2\2\2\u03a9"+
		"\u03a7\3\2\2\2\u03aa\u03ab\b!\1\2\u03ab\u03ae\7\6\2\2\u03ac\u03ae\7\r"+
		"\2\2\u03ad\u03a3\3\2\2\2\u03ad\u03ac\3\2\2\2\u03aeA\3\2\2\2\u03af\u03b1"+
		"\7W\2\2\u03b0\u03b2\7\u009e\2\2\u03b1\u03b0\3\2\2\2\u03b1\u03b2\3\2\2"+
		"\2\u03b2\u03b3\3\2\2\2\u03b3\u03bf\b\"\1\2\u03b4\u03b5\7\"\2\2\u03b5\u03ba"+
		"\5D#\2\u03b6\u03b7\7\5\2\2\u03b7\u03b9\5D#\2\u03b8\u03b6\3\2\2\2\u03b9"+
		"\u03bc\3\2\2\2\u03ba\u03b8\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03bd\3\2"+
		"\2\2\u03bc\u03ba\3\2\2\2\u03bd\u03be\7#\2\2\u03be\u03c0\3\2\2\2\u03bf"+
		"\u03b4\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03d3\b\""+
		"\1\2\u03c2\u03cc\7\4\2\2\u03c3\u03c4\5B\"\2\u03c4\u03c5\b\"\1\2\u03c5"+
		"\u03cd\3\2\2\2\u03c6\u03c7\5F$\2\u03c7\u03c8\b\"\1\2\u03c8\u03cd\3\2\2"+
		"\2\u03c9\u03ca\5L\'\2\u03ca\u03cb\b\"\1\2\u03cb\u03cd\3\2\2\2\u03cc\u03c3"+
		"\3\2\2\2\u03cc\u03c6\3\2\2\2\u03cc\u03c9\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce"+
		"\u03cc\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03d1\7\6"+
		"\2\2\u03d1\u03d4\3\2\2\2\u03d2\u03d4\7\r\2\2\u03d3\u03c2\3\2\2\2\u03d3"+
		"\u03d2\3\2\2\2\u03d4C\3\2\2\2\u03d5\u03d7\7\u009e\2\2\u03d6\u03d5\3\2"+
		"\2\2\u03d6\u03d7\3\2\2\2\u03d7\u03d8\3\2\2\2\u03d8\u03da\7\31\2\2\u03d9"+
		"\u03db\t\6\2\2\u03da\u03d9\3\2\2\2\u03da\u03db\3\2\2\2\u03db\u03dc\3\2"+
		"\2\2\u03dc\u03dd\b#\1\2\u03ddE\3\2\2\2\u03de\u03df\5B\"\2\u03df\u03e0"+
		"\b$\1\2\u03e0\u03e5\3\2\2\2\u03e1\u03e2\5H%\2\u03e2\u03e3\b$\1\2\u03e3"+
		"\u03e5\3\2\2\2\u03e4\u03de\3\2\2\2\u03e4\u03e1\3\2\2\2\u03e5G\3\2\2\2"+
		"\u03e6\u03e7\5J&\2\u03e7\u03e8\b%\1\2\u03e8\u03f3\3\2\2\2\u03e9\u03ea"+
		"\5(\25\2\u03ea\u03eb\b%\1\2\u03eb\u03f3\3\2\2\2\u03ec\u03ed\5&\24\2\u03ed"+
		"\u03ee\b%\1\2\u03ee\u03f3\3\2\2\2\u03ef\u03f0\5@!\2\u03f0\u03f1\b%\1\2"+
		"\u03f1\u03f3\3\2\2\2\u03f2\u03e6\3\2\2\2\u03f2\u03e9\3\2\2\2\u03f2\u03ec"+
		"\3\2\2\2\u03f2\u03ef\3\2\2\2\u03f3I\3\2\2\2\u03f4\u03f5\5\62\32\2\u03f5"+
		"\u03f6\b&\1\2\u03f6\u03fe\3\2\2\2\u03f7\u03f8\58\35\2\u03f8\u03f9\b&\1"+
		"\2\u03f9\u03fe\3\2\2\2\u03fa\u03fb\5,\27\2\u03fb\u03fc\b&\1\2\u03fc\u03fe"+
		"\3\2\2\2\u03fd\u03f4\3\2\2\2\u03fd\u03f7\3\2\2\2\u03fd\u03fa\3\2\2\2\u03fe"+
		"K\3\2\2\2\u03ff\u0400\7X\2\2\u0400\u0401\5Z.\2\u0401\u0402\b\'\1\2\u0402"+
		"\u0403\7\r\2\2\u0403M\3\2\2\2\u0404\u0405\7Y\2\2\u0405\u040a\5P)\2\u0406"+
		"\u0407\7\5\2\2\u0407\u0409\5P)\2\u0408\u0406\3\2\2\2\u0409\u040c\3\2\2"+
		"\2\u040a\u0408\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u040d\3\2\2\2\u040c\u040a"+
		"\3\2\2\2\u040d\u040e\7Z\2\2\u040eO\3\2\2\2\u040f\u0410\5\u0088E\2\u0410"+
		"\u041a\b)\1\2\u0411\u0412\7!\2\2\u0412\u0417\5T+\2\u0413\u0414\7[\2\2"+
		"\u0414\u0416\5T+\2\u0415\u0413\3\2\2\2\u0416\u0419\3\2\2\2\u0417\u0415"+
		"\3\2\2\2\u0417\u0418\3\2\2\2\u0418\u041b\3\2\2\2\u0419\u0417\3\2\2\2\u041a"+
		"\u0411\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041c\3\2\2\2\u041c\u041d\b)"+
		"\1\2\u041dQ\3\2\2\2\u041e\u041f\5T+\2\u041f\u0420\b*\1\2\u0420\u0425\3"+
		"\2\2\2\u0421\u0422\5X-\2\u0422\u0423\b*\1\2\u0423\u0425\3\2\2\2\u0424"+
		"\u041e\3\2\2\2\u0424\u0421\3\2\2\2\u0425S\3\2\2\2\u0426\u0432\5Z.\2\u0427"+
		"\u0428\7Y\2\2\u0428\u042d\5R*\2\u0429\u042a\7\5\2\2\u042a\u042c\5R*\2"+
		"\u042b\u0429\3\2\2\2\u042c\u042f\3\2\2\2\u042d\u042b\3\2\2\2\u042d\u042e"+
		"\3\2\2\2\u042e\u0430\3\2\2\2\u042f\u042d\3\2\2\2\u0430\u0431\7Z\2\2\u0431"+
		"\u0433\3\2\2\2\u0432\u0427\3\2\2\2\u0432\u0433\3\2\2\2\u0433U\3\2\2\2"+
		"\u0434\u0435\5^\60\2\u0435\u0436\b,\1\2\u0436\u043b\3\2\2\2\u0437\u0438"+
		"\5T+\2\u0438\u0439\b,\1\2\u0439\u043b\3\2\2\2\u043a\u0434\3\2\2\2\u043a"+
		"\u0437\3\2\2\2\u043bW\3\2\2\2\u043c\u043d\7N\2\2\u043d\u0443\b-\1\2\u043e"+
		"\u043f\t\7\2\2\u043f\u0440\b-\1\2\u0440\u0441\5T+\2\u0441\u0442\b-\1\2"+
		"\u0442\u0444\3\2\2\2\u0443\u043e\3\2\2\2\u0443\u0444\3\2\2\2\u0444Y\3"+
		"\2\2\2\u0445\u0448\5\u0088E\2\u0446\u0447\7\25\2\2\u0447\u0449\7\u009b"+
		"\2\2\u0448\u0446\3\2\2\2\u0448\u0449\3\2\2\2\u0449\u0451\3\2\2\2\u044a"+
		"\u044c\5\\/\2\u044b\u044a\3\2\2\2\u044c\u044f\3\2\2\2\u044d\u044b\3\2"+
		"\2\2\u044d\u044e\3\2\2\2\u044e\u0450\3\2\2\2\u044f\u044d\3\2\2\2\u0450"+
		"\u0452\5\\/\2\u0451\u044d\3\2\2\2\u0451\u0452\3\2\2\2\u0452[\3\2\2\2\u0453"+
		"\u0455\7]\2\2\u0454\u0456\7^\2\2\u0455\u0454\3\2\2\2\u0455\u0456\3\2\2"+
		"\2\u0456\u0457\3\2\2\2\u0457\u045a\5\u0088E\2\u0458\u0459\7\25\2\2\u0459"+
		"\u045b\7\u009b\2\2\u045a\u0458\3\2\2\2\u045a\u045b\3\2\2\2\u045b]\3\2"+
		"\2\2\u045c\u045d\7_\2\2\u045d\u0467\b\60\1\2\u045e\u045f\7`\2\2\u045f"+
		"\u0467\b\60\1\2\u0460\u0461\7a\2\2\u0461\u0467\b\60\1\2\u0462\u0463\7"+
		"b\2\2\u0463\u0467\b\60\1\2\u0464\u0465\7c\2\2\u0465\u0467\b\60\1\2\u0466"+
		"\u045c\3\2\2\2\u0466\u045e\3\2\2\2\u0466\u0460\3\2\2\2\u0466\u0462\3\2"+
		"\2\2\u0466\u0464\3\2\2\2\u0467_\3\2\2\2\u0468\u046a\7d\2\2\u0469\u046b"+
		"\5\u008aF\2\u046a\u0469\3\2\2\2\u046a\u046b\3\2\2\2\u046b\u046c\3\2\2"+
		"\2\u046c\u0473\b\61\1\2\u046d\u046f\7\b\2\2\u046e\u0470\5r:\2\u046f\u046e"+
		"\3\2\2\2\u046f\u0470\3\2\2\2\u0470\u0471\3\2\2\2\u0471\u0474\7\r\2\2\u0472"+
		"\u0474\7\r\2\2\u0473\u046d\3\2\2\2\u0473\u0472\3\2\2\2\u0474\u0475\3\2"+
		"\2\2\u0475\u0476\b\61\1\2\u0476a\3\2\2\2\u0477\u0479\7e\2\2\u0478\u0477"+
		"\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u047a\3\2\2\2\u047a\u047b\b\62\1\2"+
		"\u047b\u0482\7f\2\2\u047c\u0480\5\u008aF\2\u047d\u047e\7\"\2\2\u047e\u047f"+
		"\7\u009d\2\2\u047f\u0481\7#\2\2\u0480\u047d\3\2\2\2\u0480\u0481\3\2\2"+
		"\2\u0481\u0483\3\2\2\2\u0482\u047c\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u0484"+
		"\3\2\2\2\u0484\u048b\b\62\1\2\u0485\u0487\7\b\2\2\u0486\u0488\5p9\2\u0487"+
		"\u0486\3\2\2\2\u0487\u0488\3\2\2\2\u0488\u0489\3\2\2\2\u0489\u048c\7\r"+
		"\2\2\u048a\u048c\7\r\2\2\u048b\u0485\3\2\2\2\u048b\u048a\3\2\2\2\u048c"+
		"\u048d\3\2\2\2\u048d\u048e\b\62\1\2\u048ec\3\2\2\2\u048f\u0496\7g\2\2"+
		"\u0490\u0492\7\b\2\2\u0491\u0493\5p9\2\u0492\u0491\3\2\2\2\u0492\u0493"+
		"\3\2\2\2\u0493\u0494\3\2\2\2\u0494\u0497\7\r\2\2\u0495\u0497\7\r\2\2\u0496"+
		"\u0490\3\2\2\2\u0496\u0495\3\2\2\2\u0497\u0498\3\2\2\2\u0498\u0499\b\63"+
		"\1\2\u0499e\3\2\2\2\u049a\u04a1\t\b\2\2\u049b\u049f\5\u008aF\2\u049c\u049d"+
		"\7\"\2\2\u049d\u049e\7\u009d\2\2\u049e\u04a0\7#\2\2\u049f\u049c\3\2\2"+
		"\2\u049f\u04a0\3\2\2\2\u04a0\u04a2\3\2\2\2\u04a1\u049b\3\2\2\2\u04a1\u04a2"+
		"\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04aa\b\64\1\2\u04a4\u04a6\7\b\2\2"+
		"\u04a5\u04a7\5p9\2\u04a6\u04a5\3\2\2\2\u04a6\u04a7\3\2\2\2\u04a7\u04a8"+
		"\3\2\2\2\u04a8\u04ab\7\r\2\2\u04a9\u04ab\7\r\2\2\u04aa\u04a4\3\2\2\2\u04aa"+
		"\u04a9\3\2\2\2\u04ab\u04ac\3\2\2\2\u04ac\u04ad\b\64\1\2\u04adg\3\2\2\2"+
		"\u04ae\u04b5\t\t\2\2\u04af\u04b3\5\u008aF\2\u04b0\u04b1\7\"\2\2\u04b1"+
		"\u04b2\7\u009d\2\2\u04b2\u04b4\7#\2\2\u04b3\u04b0\3\2\2\2\u04b3\u04b4"+
		"\3\2\2\2\u04b4\u04b6\3\2\2\2\u04b5\u04af\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6"+
		"\u04b7\3\2\2\2\u04b7\u04be\b\65\1\2\u04b8\u04ba\7\b\2\2\u04b9\u04bb\5"+
		"p9\2\u04ba\u04b9\3\2\2\2\u04ba\u04bb\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc"+
		"\u04bf\7\r\2\2\u04bd\u04bf\7\r\2\2\u04be\u04b8\3\2\2\2\u04be\u04bd\3\2"+
		"\2\2\u04bf\u04c0\3\2\2\2\u04c0\u04c1\b\65\1\2\u04c1i\3\2\2\2\u04c2\u04c4"+
		"\7l\2\2\u04c3\u04c5\5\u008aF\2\u04c4\u04c3\3\2\2\2\u04c4\u04c5\3\2\2\2"+
		"\u04c5\u04c6\3\2\2\2\u04c6\u04cd\b\66\1\2\u04c7\u04c9\7\b\2\2\u04c8\u04ca"+
		"\5r:\2\u04c9\u04c8\3\2\2\2\u04c9\u04ca\3\2\2\2\u04ca\u04cb\3\2\2\2\u04cb"+
		"\u04ce\7\r\2\2\u04cc\u04ce\7\r\2\2\u04cd\u04c7\3\2\2\2\u04cd\u04cc\3\2"+
		"\2\2\u04ce\u04cf\3\2\2\2\u04cf\u04d0\b\66\1\2\u04d0k\3\2\2\2\u04d1\u04d3"+
		"\7m\2\2\u04d2\u04d4\5\u008aF\2\u04d3\u04d2\3\2\2\2\u04d3\u04d4\3\2\2\2"+
		"\u04d4\u04d5\3\2\2\2\u04d5\u04dc\b\67\1\2\u04d6\u04d8\7\b\2\2\u04d7\u04d9"+
		"\5r:\2\u04d8\u04d7\3\2\2\2\u04d8\u04d9\3\2\2\2\u04d9\u04da\3\2\2\2\u04da"+
		"\u04dd\7\r\2\2\u04db\u04dd\7\r\2\2\u04dc\u04d6\3\2\2\2\u04dc\u04db\3\2"+
		"\2\2\u04dd\u04de\3\2\2\2\u04de\u04df\b\67\1\2\u04dfm\3\2\2\2\u04e0\u04e4"+
		"\7n\2\2\u04e1\u04e4\7o\2\2\u04e2\u04e4\7p\2\2\u04e3\u04e0\3\2\2\2\u04e3"+
		"\u04e1\3\2\2\2\u04e3\u04e2\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04e6\b8"+
		"\1\2\u04e6o\3\2\2\2\u04e7\u04e8\b9\1\2\u04e8\u04e9\7 \2\2\u04e9\u04ea"+
		"\5r:\2\u04ea\u04eb\b9\1\2\u04eb\u066f\3\2\2\2\u04ec\u04ed\7\36\2\2\u04ed"+
		"\u04ee\5r:\2\u04ee\u04ef\b9\1\2\u04ef\u066f\3\2\2\2\u04f0\u04f1\7\35\2"+
		"\2\u04f1\u04f2\5r:\2\u04f2\u04f3\b9\1\2\u04f3\u066f\3\2\2\2\u04f4\u04f5"+
		"\7\37\2\2\u04f5\u04f6\5r:\2\u04f6\u04f7\b9\1\2\u04f7\u066f\3\2\2\2\u04f8"+
		"\u04fa\5r:\2\u04f9\u04fb\t\n\2\2\u04fa\u04f9\3\2\2\2\u04fa\u04fb\3\2\2"+
		"\2\u04fb\u04fc\3\2\2\2\u04fc\u04fd\7s\2\2\u04fd\u04fe\5r:\2\u04fe\u04ff"+
		"\b9\1\2\u04ff\u066f\3\2\2\2\u0500\u0502\5r:\2\u0501\u0503\t\n\2\2\u0502"+
		"\u0501\3\2\2\2\u0502\u0503\3\2\2\2\u0503\u0504\3\2\2\2\u0504\u0505\7\31"+
		"\2\2\u0505\u0506\5r:\2\u0506\u0507\b9\1\2\u0507\u066f\3\2\2\2\u0508\u050a"+
		"\5t;\2\u0509\u050b\t\n\2\2\u050a\u0509\3\2\2\2\u050a\u050b\3\2\2\2\u050b"+
		"\u050c\3\2\2\2\u050c\u050d\7\31\2\2\u050d\u050e\5t;\2\u050e\u050f\b9\1"+
		"\2\u050f\u066f\3\2\2\2\u0510\u0512\5t;\2\u0511\u0513\t\n\2\2\u0512\u0511"+
		"\3\2\2\2\u0512\u0513\3\2\2\2\u0513\u0514\3\2\2\2\u0514\u0515\7Y\2\2\u0515"+
		"\u0516\5t;\2\u0516\u0517\b9\1\2\u0517\u066f\3\2\2\2\u0518\u051a\5t;\2"+
		"\u0519\u051b\t\n\2\2\u051a\u0519\3\2\2\2\u051a\u051b\3\2\2\2\u051b\u051c"+
		"\3\2\2\2\u051c\u051d\7t\2\2\u051d\u051e\5t;\2\u051e\u051f\b9\1\2\u051f"+
		"\u066f\3\2\2\2\u0520\u0522\5t;\2\u0521\u0523\t\n\2\2\u0522\u0521\3\2\2"+
		"\2\u0522\u0523\3\2\2\2\u0523\u0524\3\2\2\2\u0524\u0525\7Z\2\2\u0525\u0526"+
		"\5t;\2\u0526\u0527\b9\1\2\u0527\u066f\3\2\2\2\u0528\u052a\5t;\2\u0529"+
		"\u052b\t\n\2\2\u052a\u0529\3\2\2\2\u052a\u052b\3\2\2\2\u052b\u052c\3\2"+
		"\2\2\u052c\u052d\7u\2\2\u052d\u052e\5t;\2\u052e\u052f\b9\1\2\u052f\u066f"+
		"\3\2\2\2\u0530\u0531\7v\2\2\u0531\u0532\5v<\2\u0532\u0533\7w\2\2\u0533"+
		"\u0534\5t;\2\u0534\u0535\3\2\2\2\u0535\u0536\b9\1\2\u0536\u066f\3\2\2"+
		"\2\u0537\u0538\7\65\2\2\u0538\u0539\7\17\2\2\u0539\u053a\5\u0082B\2\u053a"+
		"\u053b\7\20\2\2\u053b\u053c\b9\1\2\u053c\u066f\3\2\2\2\u053d\u053e\7\66"+
		"\2\2\u053e\u053f\7\17\2\2\u053f\u0540\5\u0082B\2\u0540\u0541\7\20\2\2"+
		"\u0541\u0542\b9\1\2\u0542\u066f\3\2\2\2\u0543\u0544\7\67\2\2\u0544\u0545"+
		"\7\17\2\2\u0545\u0546\5\u0082B\2\u0546\u0547\7\20\2\2\u0547\u0548\b9\1"+
		"\2\u0548\u066f\3\2\2\2\u0549\u054a\78\2\2\u054a\u054b\7\17\2\2\u054b\u054c"+
		"\5\u0082B\2\u054c\u054d\7\20\2\2\u054d\u054e\b9\1\2\u054e\u066f\3\2\2"+
		"\2\u054f\u0550\79\2\2\u0550\u0551\7\17\2\2\u0551\u0552\5\u0082B\2\u0552"+
		"\u0553\7\20\2\2\u0553\u0554\b9\1\2\u0554\u066f\3\2\2\2\u0555\u0556\7:"+
		"\2\2\u0556\u0557\7\17\2\2\u0557\u0558\5\u0082B\2\u0558\u0559\7\20\2\2"+
		"\u0559\u055a\b9\1\2\u055a\u066f\3\2\2\2\u055b\u055c\7;\2\2\u055c\u055d"+
		"\7\17\2\2\u055d\u055e\5\u0082B\2\u055e\u055f\7\20\2\2\u055f\u0560\b9\1"+
		"\2\u0560\u066f\3\2\2\2\u0561\u0562\7<\2\2\u0562\u0563\7\17\2\2\u0563\u0564"+
		"\5\u0082B\2\u0564\u0565\7\20\2\2\u0565\u0566\b9\1\2\u0566\u066f\3\2\2"+
		"\2\u0567\u0568\7=\2\2\u0568\u0569\7\17\2\2\u0569\u056a\5\u0082B\2\u056a"+
		"\u056b\7\20\2\2\u056b\u056c\b9\1\2\u056c\u066f\3\2\2\2\u056d\u056e\7>"+
		"\2\2\u056e\u056f\7\17\2\2\u056f\u0570\5\u0082B\2\u0570\u0571\7\20\2\2"+
		"\u0571\u0572\b9\1\2\u0572\u066f\3\2\2\2\u0573\u0574\7?\2\2\u0574\u0575"+
		"\7\17\2\2\u0575\u0576\5\u0082B\2\u0576\u0577\7\20\2\2\u0577\u0578\b9\1"+
		"\2\u0578\u066f\3\2\2\2\u0579\u057a\7@\2\2\u057a\u057b\7\17\2\2\u057b\u057c"+
		"\5\u0082B\2\u057c\u057d\7\20\2\2\u057d\u057e\b9\1\2\u057e\u066f\3\2\2"+
		"\2\u057f\u0580\7A\2\2\u0580\u0581\7\17\2\2\u0581\u0582\5\u0082B\2\u0582"+
		"\u0583\7\20\2\2\u0583\u0584\b9\1\2\u0584\u066f\3\2\2\2\u0585\u0586\7B"+
		"\2\2\u0586\u0587\7\17\2\2\u0587\u0588\5\u0082B\2\u0588\u0589\7\20\2\2"+
		"\u0589\u058a\b9\1\2\u058a\u066f\3\2\2\2\u058b\u058c\7C\2\2\u058c\u058d"+
		"\7\17\2\2\u058d\u058e\5\u0082B\2\u058e\u058f\7\20\2\2\u058f\u0590\b9\1"+
		"\2\u0590\u066f\3\2\2\2\u0591\u0592\7D\2\2\u0592\u0593\7\17\2\2\u0593\u0594"+
		"\5\u0082B\2\u0594\u0595\7\20\2\2\u0595\u0596\b9\1\2\u0596\u066f\3\2\2"+
		"\2\u0597\u0598\7E\2\2\u0598\u0599\7\17\2\2\u0599\u059a\5\u0082B\2\u059a"+
		"\u059b\7\20\2\2\u059b\u059c\b9\1\2\u059c\u066f\3\2\2\2\u059d\u059e\7F"+
		"\2\2\u059e\u059f\7\17\2\2\u059f\u05a0\5\u0082B\2\u05a0\u05a1\7\20\2\2"+
		"\u05a1\u05a2\b9\1\2\u05a2\u066f\3\2\2\2\u05a3\u05a4\7x\2\2\u05a4\u05a5"+
		"\7\17\2\2\u05a5\u05a6\5\u0082B\2\u05a6\u05a7\7\b\2\2\u05a7\u05a8\5r:\2"+
		"\u05a8\u05ad\7y\2\2\u05a9\u05ab\7\35\2\2\u05aa\u05a9\3\2\2\2\u05aa\u05ab"+
		"\3\2\2\2\u05ab\u05ae\3\2\2\2\u05ac\u05ae\7\36\2\2\u05ad\u05aa\3\2\2\2"+
		"\u05ad\u05ac\3\2\2\2\u05ae\u05af\3\2\2\2\u05af\u05b0\5r:\2\u05b0\u05b1"+
		"\7\20\2\2\u05b1\u05b2\b9\1\2\u05b2\u066f\3\2\2\2\u05b3\u05b4\7z\2\2\u05b4"+
		"\u05b5\7\17\2\2\u05b5\u05b6\5\u0082B\2\u05b6\u05b7\7\5\2\2\u05b7\u05b8"+
		"\5\u0082B\2\u05b8\u05b9\7\5\2\2\u05b9\u05ba\5\u0082B\2\u05ba\u05bb\7\5"+
		"\2\2\u05bb\u05bc\5\u0082B\2\u05bc\u05bd\7\20\2\2\u05bd\u05be\b9\1\2\u05be"+
		"\u066f\3\2\2\2\u05bf\u05c0\t\n\2\2\u05c0\u05c1\5p9\20\u05c1\u05c2\b9\1"+
		"\2\u05c2\u066f\3\2\2\2\u05c3\u05c4\b9\1\2\u05c4\u05c5\7\u0083\2\2\u05c5"+
		"\u05da\5v<\2\u05c6\u05d0\7w\2\2\u05c7\u05d1\5p9\2\u05c8\u05cc\7\4\2\2"+
		"\u05c9\u05cb\5p9\2\u05ca\u05c9\3\2\2\2\u05cb\u05ce\3\2\2\2\u05cc\u05ca"+
		"\3\2\2\2\u05cc\u05cd\3\2\2\2\u05cd\u05cf\3\2\2\2\u05ce\u05cc\3\2\2\2\u05cf"+
		"\u05d1\7\6\2\2\u05d0\u05c7\3\2\2\2\u05d0\u05c8\3\2\2\2\u05d1\u05db\3\2"+
		"\2\2\u05d2\u05d6\7\4\2\2\u05d3\u05d5\5p9\2\u05d4\u05d3\3\2\2\2\u05d5\u05d8"+
		"\3\2\2\2\u05d6\u05d4\3\2\2\2\u05d6\u05d7\3\2\2\2\u05d7\u05d9\3\2\2\2\u05d8"+
		"\u05d6\3\2\2\2\u05d9\u05db\7\6\2\2\u05da\u05c6\3\2\2\2\u05da\u05d2\3\2"+
		"\2\2\u05db\u05dc\3\2\2\2\u05dc\u05dd\b9\1\2\u05dd\u066f\3\2\2\2\u05de"+
		"\u05df\b9\1\2\u05df\u05e0\7\37\2\2\u05e0\u05f5\5v<\2\u05e1\u05eb\7w\2"+
		"\2\u05e2\u05ec\5p9\2\u05e3\u05e7\7\4\2\2\u05e4\u05e6\5p9\2\u05e5\u05e4"+
		"\3\2\2\2\u05e6\u05e9\3\2\2\2\u05e7\u05e5\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8"+
		"\u05ea\3\2\2\2\u05e9\u05e7\3\2\2\2\u05ea\u05ec\7\6\2\2\u05eb\u05e2\3\2"+
		"\2\2\u05eb\u05e3\3\2\2\2\u05ec\u05f6\3\2\2\2\u05ed\u05f1\7\4\2\2\u05ee"+
		"\u05f0\5p9\2\u05ef\u05ee\3\2\2\2\u05f0\u05f3\3\2\2\2\u05f1\u05ef\3\2\2"+
		"\2\u05f1\u05f2\3\2\2\2\u05f2\u05f4\3\2\2\2\u05f3\u05f1\3\2\2\2\u05f4\u05f6"+
		"\7\6\2\2\u05f5\u05e1\3\2\2\2\u05f5\u05ed\3\2\2\2\u05f6\u05f7\3\2\2\2\u05f7"+
		"\u05f8\b9\1\2\u05f8\u066f\3\2\2\2\u05f9\u05fa\b9\1\2\u05fa\u05fb\7 \2"+
		"\2\u05fb\u0610\5v<\2\u05fc\u0606\7w\2\2\u05fd\u0607\5p9\2\u05fe\u0602"+
		"\7\4\2\2\u05ff\u0601\5p9\2\u0600\u05ff\3\2\2\2\u0601\u0604\3\2\2\2\u0602"+
		"\u0600\3\2\2\2\u0602\u0603\3\2\2\2\u0603\u0605\3\2\2\2\u0604\u0602\3\2"+
		"\2\2\u0605\u0607\7\6\2\2\u0606\u05fd\3\2\2\2\u0606\u05fe\3\2\2\2\u0607"+
		"\u0611\3\2\2\2\u0608\u060c\7\4\2\2\u0609\u060b\5p9\2\u060a\u0609\3\2\2"+
		"\2\u060b\u060e\3\2\2\2\u060c\u060a\3\2\2\2\u060c\u060d\3\2\2\2\u060d\u060f"+
		"\3\2\2\2\u060e\u060c\3\2\2\2\u060f\u0611\7\6\2\2\u0610\u05fc\3\2\2\2\u0610"+
		"\u0608\3\2\2\2\u0611\u0612\3\2\2\2\u0612\u0613\b9\1\2\u0613\u066f\3\2"+
		"\2\2\u0614\u0615\b9\1\2\u0615\u0616\7\35\2\2\u0616\u062b\5v<\2\u0617\u0621"+
		"\7w\2\2\u0618\u0622\5p9\2\u0619\u061d\7\4\2\2\u061a\u061c\5p9\2\u061b"+
		"\u061a\3\2\2\2\u061c\u061f\3\2\2\2\u061d\u061b\3\2\2\2\u061d\u061e\3\2"+
		"\2\2\u061e\u0620\3\2\2\2\u061f\u061d\3\2\2\2\u0620\u0622\7\6\2\2\u0621"+
		"\u0618\3\2\2\2\u0621\u0619\3\2\2\2\u0622\u062c\3\2\2\2\u0623\u0627\7\4"+
		"\2\2\u0624\u0626\5p9\2\u0625\u0624\3\2\2\2\u0626\u0629\3\2\2\2\u0627\u0625"+
		"\3\2\2\2\u0627\u0628\3\2\2\2\u0628\u062a\3\2\2\2\u0629\u0627\3\2\2\2\u062a"+
		"\u062c\7\6\2\2\u062b\u0617\3\2\2\2\u062b\u0623\3\2\2\2\u062c\u062d\3\2"+
		"\2\2\u062d\u062e\b9\1\2\u062e\u066f\3\2\2\2\u062f\u0630\b9\1\2\u0630\u0631"+
		"\7\36\2\2\u0631\u0646\5v<\2\u0632\u063c\7w\2\2\u0633\u063d\5p9\2\u0634"+
		"\u0638\7\4\2\2\u0635\u0637\5p9\2\u0636\u0635\3\2\2\2\u0637\u063a\3\2\2"+
		"\2\u0638\u0636\3\2\2\2\u0638\u0639\3\2\2\2\u0639\u063b\3\2\2\2\u063a\u0638"+
		"\3\2\2\2\u063b\u063d\7\6\2\2\u063c\u0633\3\2\2\2\u063c\u0634\3\2\2\2\u063d"+
		"\u0647\3\2\2\2\u063e\u0642\7\4\2\2\u063f\u0641\5p9\2\u0640\u063f\3\2\2"+
		"\2\u0641\u0644\3\2\2\2\u0642\u0640\3\2\2\2\u0642\u0643\3\2\2\2\u0643\u0645"+
		"\3\2\2\2\u0644\u0642\3\2\2\2\u0645\u0647\7\6\2\2\u0646\u0632\3\2\2\2\u0646"+
		"\u063e\3\2\2\2\u0647\u0648\3\2\2\2\u0648\u0649\b9\1\2\u0649\u066f\3\2"+
		"\2\2\u064a\u064b\b9\1\2\u064b\u064c\7\u0084\2\2\u064c\u0661\5z>\2\u064d"+
		"\u0657\7w\2\2\u064e\u0658\5p9\2\u064f\u0653\7\4\2\2\u0650\u0652\5p9\2"+
		"\u0651\u0650\3\2\2\2\u0652\u0655\3\2\2\2\u0653\u0651\3\2\2\2\u0653\u0654"+
		"\3\2\2\2\u0654\u0656\3\2\2\2\u0655\u0653\3\2\2\2\u0656\u0658\7\6\2\2\u0657"+
		"\u064e\3\2\2\2\u0657\u064f\3\2\2\2\u0658\u0662\3\2\2\2\u0659\u065d\7\4"+
		"\2\2\u065a\u065c\5p9\2\u065b\u065a\3\2\2\2\u065c\u065f\3\2\2\2\u065d\u065b"+
		"\3\2\2\2\u065d\u065e\3\2\2\2\u065e\u0660\3\2\2\2\u065f\u065d\3\2\2\2\u0660"+
		"\u0662\7\6\2\2\u0661\u064d\3\2\2\2\u0661\u0659\3\2\2\2\u0662\u0663\3\2"+
		"\2\2\u0663\u0664\b9\1\2\u0664\u066f\3\2\2\2\u0665\u0666\7\21\2\2\u0666"+
		"\u066f\b9\1\2\u0667\u0668\7\22\2\2\u0668\u066f\b9\1\2\u0669\u066a\7\""+
		"\2\2\u066a\u066b\5p9\2\u066b\u066c\7#\2\2\u066c\u066d\b9\1\2\u066d\u066f"+
		"\3\2\2\2\u066e\u04e7\3\2\2\2\u066e\u04ec\3\2\2\2\u066e\u04f0\3\2\2\2\u066e"+
		"\u04f4\3\2\2\2\u066e\u04f8\3\2\2\2\u066e\u0500\3\2\2\2\u066e\u0508\3\2"+
		"\2\2\u066e\u0510\3\2\2\2\u066e\u0518\3\2\2\2\u066e\u0520\3\2\2\2\u066e"+
		"\u0528\3\2\2\2\u066e\u0530\3\2\2\2\u066e\u0537\3\2\2\2\u066e\u053d\3\2"+
		"\2\2\u066e\u0543\3\2\2\2\u066e\u0549\3\2\2\2\u066e\u054f\3\2\2\2\u066e"+
		"\u0555\3\2\2\2\u066e\u055b\3\2\2\2\u066e\u0561\3\2\2\2\u066e\u0567\3\2"+
		"\2\2\u066e\u056d\3\2\2\2\u066e\u0573\3\2\2\2\u066e\u0579\3\2\2\2\u066e"+
		"\u057f\3\2\2\2\u066e\u0585\3\2\2\2\u066e\u058b\3\2\2\2\u066e\u0591\3\2"+
		"\2\2\u066e\u0597\3\2\2\2\u066e\u059d\3\2\2\2\u066e\u05a3\3\2\2\2\u066e"+
		"\u05b3\3\2\2\2\u066e\u05bf\3\2\2\2\u066e\u05c3\3\2\2\2\u066e\u05de\3\2"+
		"\2\2\u066e\u05f9\3\2\2\2\u066e\u0614\3\2\2\2\u066e\u062f\3\2\2\2\u066e"+
		"\u064a\3\2\2\2\u066e\u0665\3\2\2\2\u066e\u0667\3\2\2\2\u066e\u0669\3\2"+
		"\2\2\u066f\u0686\3\2\2\2\u0670\u0671\f\17\2\2\u0671\u0672\t\13\2\2\u0672"+
		"\u0673\5p9\20\u0673\u0674\b9\1\2\u0674\u0685\3\2\2\2\u0675\u0676\f\16"+
		"\2\2\u0676\u0677\t\f\2\2\u0677\u0678\5p9\17\u0678\u0679\b9\1\2\u0679\u0685"+
		"\3\2\2\2\u067a\u067b\f\r\2\2\u067b\u067c\t\r\2\2\u067c\u067d\5p9\r\u067d"+
		"\u067e\b9\1\2\u067e\u0685\3\2\2\2\u067f\u0680\f\f\2\2\u0680\u0681\t\16"+
		"\2\2\u0681\u0682\5p9\f\u0682\u0683\b9\1\2\u0683\u0685\3\2\2\2\u0684\u0670"+
		"\3\2\2\2\u0684\u0675\3\2\2\2\u0684\u067a\3\2\2\2\u0684\u067f\3\2\2\2\u0685"+
		"\u0688\3\2\2\2\u0686\u0684\3\2\2\2\u0686\u0687\3\2\2\2\u0687q\3\2\2\2"+
		"\u0688\u0686\3\2\2\2\u0689\u068a\b:\1\2\u068a\u068b\7\u0085\2\2\u068b"+
		"\u068c\5r:\24\u068c\u068d\b:\1\2\u068d\u06b7\3\2\2\2\u068e\u068f\7\u0086"+
		"\2\2\u068f\u0690\5r:\23\u0690\u0691\b:\1\2\u0691\u06b7\3\2\2\2\u0692\u0693"+
		"\7M\2\2\u0693\u0694\5r:\22\u0694\u0695\b:\1\2\u0695\u06b7\3\2\2\2\u0696"+
		"\u0697\b:\1\2\u0697\u0698\7\4\2\2\u0698\u0699\5~@\2\u0699\u069a\7w\2\2"+
		"\u069a\u069b\5p9\2\u069b\u069c\7\6\2\2\u069c\u069d\b:\1\2\u069d\u06b7"+
		"\3\2\2\2\u069e\u069f\7\u0088\2\2\u069f\u06a0\5p9\2\u06a0\u06a1\7\u0089"+
		"\2\2\u06a1\u06a2\5r:\2\u06a2\u06a3\7\u008a\2\2\u06a3\u06a4\5r:\t\u06a4"+
		"\u06a5\b:\1\2\u06a5\u06b7\3\2\2\2\u06a6\u06a7\7\u008b\2\2\u06a7\u06b7"+
		"\b:\1\2\u06a8\u06a9\7\u008c\2\2\u06a9\u06b7\b:\1\2\u06aa\u06ab\7\u008d"+
		"\2\2\u06ab\u06b7\b:\1\2\u06ac\u06ad\7\u008e\2\2\u06ad\u06b7\b:\1\2\u06ae"+
		"\u06af\7\"\2\2\u06af\u06b0\5r:\2\u06b0\u06b1\7#\2\2\u06b1\u06b2\b:\1\2"+
		"\u06b2\u06b7\3\2\2\2\u06b3\u06b4\5Z.\2\u06b4\u06b5\b:\1\2\u06b5\u06b7"+
		"\3\2\2\2\u06b6\u0689\3\2\2\2\u06b6\u068e\3\2\2\2\u06b6\u0692\3\2\2\2\u06b6"+
		"\u0696\3\2\2\2\u06b6\u069e\3\2\2\2\u06b6\u06a6\3\2\2\2\u06b6\u06a8\3\2"+
		"\2\2\u06b6\u06aa\3\2\2\2\u06b6\u06ac\3\2\2\2\u06b6\u06ae\3\2\2\2\u06b6"+
		"\u06b3\3\2\2\2\u06b7\u06e4\3\2\2\2\u06b8\u06b9\f\21\2\2\u06b9\u06ba\7"+
		"\23\2\2\u06ba\u06bb\5r:\22\u06bb\u06bc\b:\1\2\u06bc\u06e3\3\2\2\2\u06bd"+
		"\u06be\f\20\2\2\u06be\u06bf\7[\2\2\u06bf\u06c0\5r:\21\u06c0\u06c1\b:\1"+
		"\2\u06c1\u06e3\3\2\2\2\u06c2\u06c3\f\17\2\2\u06c3\u06c4\7\24\2\2\u06c4"+
		"\u06c5\5r:\20\u06c5\u06c6\b:\1\2\u06c6\u06e3\3\2\2\2\u06c7\u06c8\f\16"+
		"\2\2\u06c8\u06c9\7\25\2\2\u06c9\u06ca\5r:\17\u06ca\u06cb\b:\1\2\u06cb"+
		"\u06e3\3\2\2\2\u06cc\u06ce\f\f\2\2\u06cd\u06cf\5\u0086D\2\u06ce\u06cd"+
		"\3\2\2\2\u06ce\u06cf\3\2\2\2\u06cf\u06d0\3\2\2\2\u06d0\u06d2\7y\2\2\u06d1"+
		"\u06d3\5\u0086D\2\u06d2\u06d1\3\2\2\2\u06d2\u06d3\3\2\2\2\u06d3\u06d4"+
		"\3\2\2\2\u06d4\u06d5\5r:\f\u06d5\u06d6\b:\1\2\u06d6\u06e3\3\2\2\2\u06d7"+
		"\u06d8\f\13\2\2\u06d8\u06d9\7\u0087\2\2\u06d9\u06da\5r:\f\u06da\u06db"+
		"\b:\1\2\u06db\u06e3\3\2\2\2\u06dc\u06dd\f\r\2\2\u06dd\u06de\7\17\2\2\u06de"+
		"\u06df\5r:\2\u06df\u06e0\7\20\2\2\u06e0\u06e1\b:\1\2\u06e1\u06e3\3\2\2"+
		"\2\u06e2\u06b8\3\2\2\2\u06e2\u06bd\3\2\2\2\u06e2\u06c2\3\2\2\2\u06e2\u06c7"+
		"\3\2\2\2\u06e2\u06cc\3\2\2\2\u06e2\u06d7\3\2\2\2\u06e2\u06dc\3\2\2\2\u06e3"+
		"\u06e6\3\2\2\2\u06e4\u06e2\3\2\2\2\u06e4\u06e5\3\2\2\2\u06e5s\3\2\2\2"+
		"\u06e6\u06e4\3\2\2\2\u06e7\u06e8\b;\1\2\u06e8\u06e9\7\u0088\2\2\u06e9"+
		"\u06ea\5p9\2\u06ea\u06eb\7\u0089\2\2\u06eb\u06ec\5t;\2\u06ec\u06ed\7\u008a"+
		"\2\2\u06ed\u06ee\5t;\f\u06ee\u06ef\b;\1\2\u06ef\u0703\3\2\2\2\u06f0\u06f1"+
		"\7v\2\2\u06f1\u06f2\5r:\2\u06f2\u06f3\b;\1\2\u06f3\u0703\3\2\2\2\u06f4"+
		"\u06f5\7\63\2\2\u06f5\u06f6\5r:\2\u06f6\u06f7\b;\1\2\u06f7\u0703\3\2\2"+
		"\2\u06f8\u06fa\7\24\2\2\u06f9\u06f8\3\2\2\2\u06f9\u06fa\3\2\2\2\u06fa"+
		"\u06fb\3\2\2\2\u06fb\u06fc\7\u009b\2\2\u06fc\u0703\b;\1\2\u06fd\u06fe"+
		"\7\"\2\2\u06fe\u06ff\5t;\2\u06ff\u0700\7#\2\2\u0700\u0701\b;\1\2\u0701"+
		"\u0703\3\2\2\2\u0702\u06e7\3\2\2\2\u0702\u06f0\3\2\2\2\u0702\u06f4\3\2"+
		"\2\2\u0702\u06f9\3\2\2\2\u0702\u06fd\3\2\2\2\u0703\u071f\3\2\2\2\u0704"+
		"\u0705\f\t\2\2\u0705\u0706\t\17\2\2\u0706\u0707\5t;\n\u0707\u0708\b;\1"+
		"\2\u0708\u071e\3\2\2\2\u0709\u070a\f\b\2\2\u070a\u070b\t\20\2\2\u070b"+
		"\u070c\5t;\t\u070c\u070d\b;\1\2\u070d\u071e\3\2\2\2\u070e\u070f\f\7\2"+
		"\2\u070f\u0710\t\21\2\2\u0710\u0711\5t;\b\u0711\u0712\b;\1\2\u0712\u071e"+
		"\3\2\2\2\u0713\u0714\f\6\2\2\u0714\u0715\t\22\2\2\u0715\u0716\5t;\7\u0716"+
		"\u0717\b;\1\2\u0717\u071e\3\2\2\2\u0718\u0719\f\5\2\2\u0719\u071a\t\23"+
		"\2\2\u071a\u071b\5t;\6\u071b\u071c\b;\1\2\u071c\u071e\3\2\2\2\u071d\u0704"+
		"\3\2\2\2\u071d\u0709\3\2\2\2\u071d\u070e\3\2\2\2\u071d\u0713\3\2\2\2\u071d"+
		"\u0718\3\2\2\2\u071e\u0721\3\2\2\2\u071f\u071d\3\2\2\2\u071f\u0720\3\2"+
		"\2\2\u0720u\3\2\2\2\u0721\u071f\3\2\2\2\u0722\u0727\5x=\2\u0723\u0724"+
		"\7\5\2\2\u0724\u0726\5x=\2\u0725\u0723\3\2\2\2\u0726\u0729\3\2\2\2\u0727"+
		"\u0725\3\2\2\2\u0727\u0728\3\2\2\2\u0728w\3\2\2\2\u0729\u0727\3\2\2\2"+
		"\u072a\u072c\7\u0096\2\2\u072b\u072a\3\2\2\2\u072b\u072c\3\2\2\2\u072c"+
		"\u072d\3\2\2\2\u072d\u0732\5\u0084C\2\u072e\u072f\7\5\2\2\u072f\u0731"+
		"\5\u0084C\2\u0730\u072e\3\2\2\2\u0731\u0734\3\2\2\2\u0732\u0730\3\2\2"+
		"\2\u0732\u0733\3\2\2\2\u0733\u0735\3\2\2\2\u0734\u0732\3\2\2\2\u0735\u0737"+
		"\7\b\2\2\u0736\u0738\7\35\2\2\u0737\u0736\3\2\2\2\u0737\u0738\3\2\2\2"+
		"\u0738\u0739\3\2\2\2\u0739\u073a\5r:\2\u073a\u073b\b=\1\2\u073b\u076d"+
		"\3\2\2\2\u073c\u073e\7\u0096\2\2\u073d\u073c\3\2\2\2\u073d\u073e\3\2\2"+
		"\2\u073e\u073f\3\2\2\2\u073f\u0744\5\u0084C\2\u0740\u0741\7\5\2\2\u0741"+
		"\u0743\5\u0084C\2\u0742\u0740\3\2\2\2\u0743\u0746\3\2\2\2\u0744\u0742"+
		"\3\2\2\2\u0744\u0745\3\2\2\2\u0745\u0747\3\2\2\2\u0746\u0744\3\2\2\2\u0747"+
		"\u0748\7\b\2\2\u0748\u0749\7\36\2\2\u0749\u074a\5r:\2\u074a\u074b\b=\1"+
		"\2\u074b\u076d\3\2\2\2\u074c\u074e\7\u0096\2\2\u074d\u074c\3\2\2\2\u074d"+
		"\u074e\3\2\2\2\u074e\u074f\3\2\2\2\u074f\u0754\5\u0084C\2\u0750\u0751"+
		"\7\5\2\2\u0751\u0753\5\u0084C\2\u0752\u0750\3\2\2\2\u0753\u0756\3\2\2"+
		"\2\u0754\u0752\3\2\2\2\u0754\u0755\3\2\2\2\u0755\u0757\3\2\2\2\u0756\u0754"+
		"\3\2\2\2\u0757\u0758\7\b\2\2\u0758\u0759\7\37\2\2\u0759\u075a\5r:\2\u075a"+
		"\u075b\b=\1\2\u075b\u076d\3\2\2\2\u075c\u075e\7\u0096\2\2\u075d\u075c"+
		"\3\2\2\2\u075d\u075e\3\2\2\2\u075e\u075f\3\2\2\2\u075f\u0764\5\u0084C"+
		"\2\u0760\u0761\7\5\2\2\u0761\u0763\5\u0084C\2\u0762\u0760\3\2\2\2\u0763"+
		"\u0766\3\2\2\2\u0764\u0762\3\2\2\2\u0764\u0765\3\2\2\2\u0765\u0767\3\2"+
		"\2\2\u0766\u0764\3\2\2\2\u0767\u0768\7\b\2\2\u0768\u0769\7\u0097\2\2\u0769"+
		"\u076a\5r:\2\u076a\u076b\b=\1\2\u076b\u076d\3\2\2\2\u076c\u072b\3\2\2"+
		"\2\u076c\u073d\3\2\2\2\u076c\u074d\3\2\2\2\u076c\u075d\3\2\2\2\u076dy"+
		"\3\2\2\2\u076e\u0773\5|?\2\u076f\u0770\7\5\2\2\u0770\u0772\5|?\2\u0771"+
		"\u076f\3\2\2\2\u0772\u0775\3\2\2\2\u0773\u0771\3\2\2\2\u0773\u0774\3\2"+
		"\2\2\u0774{\3\2\2\2\u0775\u0773\3\2\2\2\u0776\u077b\5\u0084C\2\u0777\u0778"+
		"\7\5\2\2\u0778\u077a\5\u0084C\2\u0779\u0777\3\2\2\2\u077a\u077d\3\2\2"+
		"\2\u077b\u0779\3\2\2\2\u077b\u077c\3\2\2\2\u077c\u077e\3\2\2\2\u077d\u077b"+
		"\3\2\2\2\u077e\u077f\7\31\2\2\u077f\u0780\5r:\2\u0780\u0781\b?\1\2\u0781"+
		"}\3\2\2\2\u0782\u0787\5\u0080A\2\u0783\u0784\7\5\2\2\u0784\u0786\5\u0080"+
		"A\2\u0785\u0783\3\2\2\2\u0786\u0789\3\2\2\2\u0787\u0785\3\2\2\2\u0787"+
		"\u0788\3\2\2\2\u0788\177\3\2\2\2\u0789\u0787\3\2\2\2\u078a\u078c\7\u0096"+
		"\2\2\u078b\u078a\3\2\2\2\u078b\u078c\3\2\2\2\u078c\u078d\3\2\2\2\u078d"+
		"\u0792\5\u0084C\2\u078e\u078f\7\5\2\2\u078f\u0791\5\u0084C\2\u0790\u078e"+
		"\3\2\2\2\u0791\u0794\3\2\2\2\u0792\u0790\3\2\2\2\u0792\u0793\3\2\2\2\u0793"+
		"\u0795\3\2\2\2\u0794\u0792\3\2\2\2\u0795\u0797\7\b\2\2\u0796\u0798\7\35"+
		"\2\2\u0797\u0796\3\2\2\2\u0797\u0798\3\2\2\2\u0798\u0799\3\2\2\2\u0799"+
		"\u079a\5r:\2\u079a\u079b\3\2\2\2\u079b\u079c\bA\1\2\u079c\u0081\3\2\2"+
		"\2\u079d\u079e\5\u0088E\2\u079e\u0083\3\2\2\2\u079f\u07a0\5\u0088E\2\u07a0"+
		"\u07a1\bC\1\2\u07a1\u0085\3\2\2\2\u07a2\u07a3\t\24\2\2\u07a3\u0087\3\2"+
		"\2\2\u07a4\u07e6\5\u008aF\2\u07a5\u07e6\7\32\2\2\u07a6\u07e6\7)\2\2\u07a7"+
		"\u07e6\7d\2\2\u07a8\u07e6\7e\2\2\u07a9\u07e6\7\33\2\2\u07aa\u07e6\7\64"+
		"\2\2\u07ab\u07e6\7R\2\2\u07ac\u07e6\7\u0098\2\2\u07ad\u07e6\7m\2\2\u07ae"+
		"\u07e6\7*\2\2\u07af\u07e6\7U\2\2\u07b0\u07e6\7\u0099\2\2\u07b1\u07e6\7"+
		"!\2\2\u07b2\u07e6\7+\2\2\u07b3\u07e6\7\27\2\2\u07b4\u07e6\7l\2\2\u07b5"+
		"\u07e6\7\34\2\2\u07b6\u07e6\7I\2\2\u07b7\u07e6\7\16\2\2\u07b8\u07e6\7"+
		"J\2\2\u07b9\u07e6\7,\2\2\u07ba\u07e6\7\30\2\2\u07bb\u07e6\7j\2\2\u07bc"+
		"\u07e6\7h\2\2\u07bd\u07e6\7Q\2\2\u07be\u07e6\7\62\2\2\u07bf\u07e6\7(\2"+
		"\2\u07c0\u07e6\7X\2\2\u07c1\u07e6\7\u009a\2\2\u07c2\u07e6\7G\2\2\u07c3"+
		"\u07e6\7$\2\2\u07c4\u07e6\7K\2\2\u07c5\u07e6\7&\2\2\u07c6\u07e6\7.\2\2"+
		"\u07c7\u07e6\7\60\2\2\u07c8\u07e6\7\'\2\2\u07c9\u07e6\7f\2\2\u07ca\u07e6"+
		"\7V\2\2\u07cb\u07e6\7S\2\2\u07cc\u07e6\7W\2\2\u07cd\u07e6\7\16\2\2\u07ce"+
		"\u07e6\7\f\2\2\u07cf\u07e6\7\35\2\2\u07d0\u07e6\7\36\2\2\u07d1\u07e6\7"+
		"\37\2\2\u07d2\u07e6\7 \2\2\u07d3\u07e6\7\65\2\2\u07d4\u07e6\7\66\2\2\u07d5"+
		"\u07e6\7\67\2\2\u07d6\u07e6\78\2\2\u07d7\u07e6\79\2\2\u07d8\u07e6\7:\2"+
		"\2\u07d9\u07e6\7;\2\2\u07da\u07e6\7<\2\2\u07db\u07e6\7=\2\2\u07dc\u07e6"+
		"\7>\2\2\u07dd\u07e6\7?\2\2\u07de\u07e6\7@\2\2\u07df\u07e6\7A\2\2\u07e0"+
		"\u07e6\7B\2\2\u07e1\u07e6\7C\2\2\u07e2\u07e6\7D\2\2\u07e3\u07e6\7E\2\2"+
		"\u07e4\u07e6\7F\2\2\u07e5\u07a4\3\2\2\2\u07e5\u07a5\3\2\2\2\u07e5\u07a6"+
		"\3\2\2\2\u07e5\u07a7\3\2\2\2\u07e5\u07a8\3\2\2\2\u07e5\u07a9\3\2\2\2\u07e5"+
		"\u07aa\3\2\2\2\u07e5\u07ab\3\2\2\2\u07e5\u07ac\3\2\2\2\u07e5\u07ad\3\2"+
		"\2\2\u07e5\u07ae\3\2\2\2\u07e5\u07af\3\2\2\2\u07e5\u07b0\3\2\2\2\u07e5"+
		"\u07b1\3\2\2\2\u07e5\u07b2\3\2\2\2\u07e5\u07b3\3\2\2\2\u07e5\u07b4\3\2"+
		"\2\2\u07e5\u07b5\3\2\2\2\u07e5\u07b6\3\2\2\2\u07e5\u07b7\3\2\2\2\u07e5"+
		"\u07b8\3\2\2\2\u07e5\u07b9\3\2\2\2\u07e5\u07ba\3\2\2\2\u07e5\u07bb\3\2"+
		"\2\2\u07e5\u07bc\3\2\2\2\u07e5\u07bd\3\2\2\2\u07e5\u07be\3\2\2\2\u07e5"+
		"\u07bf\3\2\2\2\u07e5\u07c0\3\2\2\2\u07e5\u07c1\3\2\2\2\u07e5\u07c2\3\2"+
		"\2\2\u07e5\u07c3\3\2\2\2\u07e5\u07c4\3\2\2\2\u07e5\u07c5\3\2\2\2\u07e5"+
		"\u07c6\3\2\2\2\u07e5\u07c7\3\2\2\2\u07e5\u07c8\3\2\2\2\u07e5\u07c9\3\2"+
		"\2\2\u07e5\u07ca\3\2\2\2\u07e5\u07cb\3\2\2\2\u07e5\u07cc\3\2\2\2\u07e5"+
		"\u07cd\3\2\2\2\u07e5\u07ce\3\2\2\2\u07e5\u07cf\3\2\2\2\u07e5\u07d0\3\2"+
		"\2\2\u07e5\u07d1\3\2\2\2\u07e5\u07d2\3\2\2\2\u07e5\u07d3\3\2\2\2\u07e5"+
		"\u07d4\3\2\2\2\u07e5\u07d5\3\2\2\2\u07e5\u07d6\3\2\2\2\u07e5\u07d7\3\2"+
		"\2\2\u07e5\u07d8\3\2\2\2\u07e5\u07d9\3\2\2\2\u07e5\u07da\3\2\2\2\u07e5"+
		"\u07db\3\2\2\2\u07e5\u07dc\3\2\2\2\u07e5\u07dd\3\2\2\2\u07e5\u07de\3\2"+
		"\2\2\u07e5\u07df\3\2\2\2\u07e5\u07e0\3\2\2\2\u07e5\u07e1\3\2\2\2\u07e5"+
		"\u07e2\3\2\2\2\u07e5\u07e3\3\2\2\2\u07e5\u07e4\3\2\2\2\u07e6\u0089\3\2"+
		"\2\2\u07e7\u07e8\7\u009c\2\2\u07e8\u008b\3\2\2\2\u07e9\u07ea\t\25\2\2"+
		"\u07ea\u008d\3\2\2\2\u07eb\u07ec\7\u009b\2\2\u07ec\u008f\3\2\2\2\u00f5"+
		"\u0097\u00a8\u00ae\u00b3\u00b9\u00bf\u00c7\u00d0\u00d6\u00e0\u00eb\u00f1"+
		"\u00f3\u00f7\u00ff\u010c\u0113\u0118\u011b\u0125\u012c\u0132\u013e\u0145"+
		"\u0160\u0162\u0167\u0172\u0175\u0179\u017d\u0181\u0184\u0189\u0192\u0195"+
		"\u019a\u019f\u01a4\u01a8\u01aa\u01ba\u01bc\u01c1\u01c9\u01cc\u01d0\u01d4"+
		"\u01d7\u01da\u01dd\u01e1\u01e8\u01ed\u01f9\u01fc\u0200\u0203\u020b\u0214"+
		"\u021b\u0220\u0225\u0229\u022d\u0230\u0233\u0236\u023a\u0240\u0246\u024b"+
		"\u026b\u026e\u0272\u0275\u027e\u0283\u028a\u0293\u029a\u02a0\u02a4\u02a9"+
		"\u02ad\u02b1\u02bc\u02bf\u02c7\u02c9\u02d3\u02d6\u02de\u02e1\u02e5\u02e8"+
		"\u02f7\u02f9\u02fe\u030d\u0315\u0318\u031c\u031f\u0325\u032a\u0332\u0335"+
		"\u0339\u033f\u0343\u0349\u034e\u0354\u0357\u0360\u0362\u0367\u036c\u0373"+
		"\u0378\u037e\u0381\u038d\u038f\u0394\u039b\u03a0\u03a7\u03ad\u03b1\u03ba"+
		"\u03bf\u03cc\u03ce\u03d3\u03d6\u03da\u03e4\u03f2\u03fd\u040a\u0417\u041a"+
		"\u0424\u042d\u0432\u043a\u0443\u0448\u044d\u0451\u0455\u045a\u0466\u046a"+
		"\u046f\u0473\u0478\u0480\u0482\u0487\u048b\u0492\u0496\u049f\u04a1\u04a6"+
		"\u04aa\u04b3\u04b5\u04ba\u04be\u04c4\u04c9\u04cd\u04d3\u04d8\u04dc\u04e3"+
		"\u04fa\u0502\u050a\u0512\u051a\u0522\u052a\u05aa\u05ad\u05cc\u05d0\u05d6"+
		"\u05da\u05e7\u05eb\u05f1\u05f5\u0602\u0606\u060c\u0610\u061d\u0621\u0627"+
		"\u062b\u0638\u063c\u0642\u0646\u0653\u0657\u065d\u0661\u066e\u0684\u0686"+
		"\u06b6\u06ce\u06d2\u06e2\u06e4\u06f9\u0702\u071d\u071f\u0727\u072b\u0732"+
		"\u0737\u073d\u0744\u074d\u0754\u075d\u0764\u076c\u0773\u077b\u0787\u078b"+
		"\u0792\u0797\u07e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}