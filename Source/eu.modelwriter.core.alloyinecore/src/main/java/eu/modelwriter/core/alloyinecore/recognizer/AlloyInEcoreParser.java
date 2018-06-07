// Generated from /home/ferhat/git/AlloyInEcore/Source/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.7
package eu.modelwriter.core.alloyinecore.recognizer;


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
		T__149=150, T__150=151, T__151=152, T__152=153, T__153=154, INT=155, IDENTIFIER=156, 
		DOUBLE_QUOTED_STRING=157, SINGLE_QUOTED_STRING=158, ML_SINGLE_QUOTED_STRING=159, 
		MULTILINE_COMMENT=160, SINGLELINE_COMMENT=161, WS=162;
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
		RULE_singleton = 68, RULE_identifier = 69, RULE_upper = 70, RULE_lower = 71;
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
		"relationId", "variable", "mult", "unrestrictedName", "singleton", "identifier", 
		"upper", "lower"
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
		"'iff'", "'all'", "'let'", "'~'", "'^'", "'<:'", "':>'", "'++'", "'if'", 
		"'then'", "'else'", "'iden'", "'none'", "'univ'", "'ints'", "'plus'", 
		"'minus'", "'mul'", "'/'", "'div'", "'%'", "'modulo'", "'disj'", "'set'", 
		"'definition'", "'ensure'", "'require'"
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
		null, null, null, null, null, null, null, null, null, null, null, "INT", 
		"IDENTIFIER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", "ML_SINGLE_QUOTED_STRING", 
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
			setState(144);
			match(T__0);
			setState(145);
			match(T__1);
			setState(146);
			option();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(147);
				match(T__2);
				setState(148);
				option();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
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
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				((SymmetryBreakingContext)_localctx).key = match(T__4);
				setState(157);
				match(T__5);
				setState(158);
				((SymmetryBreakingContext)_localctx).value = match(INT);
				}
				break;
			case T__6:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				((BitWidthContext)_localctx).key = match(T__6);
				setState(160);
				match(T__5);
				setState(161);
				((BitWidthContext)_localctx).value = match(INT);
				}
				break;
			case T__7:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				((SkolemDepthContext)_localctx).key = match(T__7);
				setState(163);
				match(T__5);
				setState(164);
				((SkolemDepthContext)_localctx).value = match(INT);
				}
				break;
			case T__8:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				((SharingContext)_localctx).key = match(T__8);
				setState(166);
				match(T__5);
				setState(167);
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
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(170);
				match(T__9);
				setState(171);
				((InstanceContext)_localctx).name = identifier();
				setState(172);
				match(T__10);
				}
			}

			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(176);
				packageImport(_localctx.current);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
			modelImport(_localctx.current);
			setState(185);
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
			case T__151:
			case T__152:
			case T__153:
			case IDENTIFIER:
				{
				setState(183);
				((InstanceContext)_localctx).rootObject = eObject(_localctx.current);
				}
				break;
			case T__10:
				{
				setState(184);
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
			setState(187);
			match(T__11);
			}
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__151 - 152)) | (1L << (T__152 - 152)) | (1L << (T__153 - 152)) | (1L << (IDENTIFIER - 152)))) != 0)) {
				{
				setState(188);
				((ModelImportContext)_localctx).name = unrestrictedName();
				setState(189);
				match(T__5);
				}
			}

			setState(193);
			((ModelImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(194);
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
			setState(196);
			((EObjectContext)_localctx).name = pathName(_localctx.current);

			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0) || ((((_la - 155)) & ~0x3f) == 0 && ((1L << (_la - 155)) & ((1L << (INT - 155)) | (1L << (IDENTIFIER - 155)) | (1L << (DOUBLE_QUOTED_STRING - 155)))) != 0)) {
				{
				setState(198);
				((EObjectContext)_localctx).id = literalValue(_localctx.owner);
				}
			}


			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(202);
				match(T__1);
				setState(203);
				((EObjectContext)_localctx).slot = slot(_localctx.current);
				((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(204);
					match(T__2);
					setState(205);
					((EObjectContext)_localctx).slot = slot(_localctx.current);
					((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(211);
				match(T__3);
				}
				break;
			case T__10:
				{
				setState(213);
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
			setState(216);
			((SlotContext)_localctx).name = unrestrictedName();

			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(218);
				match(T__5);
				setState(241);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(219);
					if (!(true)) throw new FailedPredicateException(this, "true");
					setState(220);
					match(T__1);
					setState(224);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__151 - 152)) | (1L << (T__152 - 152)) | (1L << (T__153 - 152)) | (1L << (IDENTIFIER - 152)))) != 0)) {
						{
						{
						setState(221);
						eObject(_localctx.current);
						}
						}
						setState(226);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(227);
					match(T__3);
					}
					break;
				case 2:
					{
					setState(228);
					eObjectValue(_localctx.current);
					}
					break;
				case 3:
					{
					setState(229);
					match(T__12);
					setState(230);
					eObjectValue(_localctx.current);
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(231);
						match(T__2);
						setState(232);
						eObjectValue(_localctx.current);
						}
						}
						setState(237);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(238);
					match(T__13);
					}
					break;
				case 4:
					{
					setState(240);
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
			setState(247);
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
				setState(245);
				literalValue(_localctx.owner);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
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
			setState(249);
			match(T__12);
			setState(250);
			dataValue(_localctx.owner);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(251);
				match(T__2);
				setState(252);
				dataValue(_localctx.owner);
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
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
			setState(260);
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
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				enumValue(_localctx.current);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				integerValue(_localctx.current);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				realValue(_localctx.current);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(265);
				stringValue(_localctx.current);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(266);
				booleanValue(_localctx.current);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(267);
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
			setState(270);
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
			setState(272);
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
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16 || _la==T__17) {
				{
				setState(274);
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

			setState(277);
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
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16 || _la==T__17) {
				{
				setState(279);
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

			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(282);
				match(INT);
				}
			}

			setState(285);
			match(T__18);
			setState(286);
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
			setState(288);
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
			setState(290);
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
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(292);
				options();
				}
			}


			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(296);
				match(T__11);
				setState(297);
				((ModelContext)_localctx).name = identifier();
				setState(298);
				match(T__10);
				}
			}

			_localctx.element.getDetails().put("name", (((ModelContext)_localctx).name!=null?_input.getText(((ModelContext)_localctx).name.start,((ModelContext)_localctx).name.stop):null));
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(303);
				((ModelContext)_localctx).packageImport = packageImport(model);
				((ModelContext)_localctx).ownedPackageImport.add(((ModelContext)_localctx).packageImport);
				}
				}
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(309);
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
			setState(314);
			match(T__20);
			}
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(315);
				((PackageImportContext)_localctx).name = identifier();
				setState(316);
				match(T__5);
				}
			}

			setState(320);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(321);
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
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(324);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EPackageContext)_localctx).visibility.element);
			setState(328);
			match(T__21);
			setState(329);
			((EPackageContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null));
			if(_localctx.parent instanceof ModelContext) {repository.name2Import.put(((RootPackage)_localctx.current).getKey(), (RootPackage)_localctx.current);}
			{
			setState(332);
			match(T__5);
			setState(333);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(335);
			match(T__22);
			setState(336);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			_localctx.element.setNsPrefix((((EPackageContext)_localctx).nsPrefix!=null?_input.getText(((EPackageContext)_localctx).nsPrefix.start,((EPackageContext)_localctx).nsPrefix.stop):null)); if(((EPackageContext)_localctx).nsURI != null) _localctx.element.setNsURI(((EPackageContext)_localctx).nsURI.getText().replace("'", ""));
			setState(359);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(339);
				match(T__1);
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (T__78 - 79)) | (1L << (T__79 - 79)) | (1L << (T__82 - 79)) | (1L << (T__84 - 79)) | (1L << (T__98 - 79)) | (1L << (T__99 - 79)) | (1L << (T__107 - 79)) | (1L << (T__108 - 79)) | (1L << (T__109 - 79)))) != 0)) {
					{
					setState(352);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(340);
						((EPackageContext)_localctx).eAnnotation = ((EPackageContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(343);
						((EPackageContext)_localctx).ePackage = ((EPackageContext)_localctx).ePackage = ePackage(_localctx.current);
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						_localctx.element.getESubpackages().add(((EPackageContext)_localctx).ePackage.element);
						}
						break;
					case 3:
						{
						setState(346);
						((EPackageContext)_localctx).eClassifier = ((EPackageContext)_localctx).eClassifier = eClassifier(_localctx.current);
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						if (((EPackageContext)_localctx).eClassifier.element != null) _localctx.element.getEClassifiers().add(((EPackageContext)_localctx).eClassifier.element);
						}
						break;
					case 4:
						{
						setState(349);
						((EPackageContext)_localctx).invariant = ((EPackageContext)_localctx).invariant = invariant(_localctx.current);
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(356);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(357);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(358);
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
			setState(370);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				((EClassifierContext)_localctx).eClass = eClass(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eClass.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				((EClassifierContext)_localctx).eDataType = eDataType(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eDataType.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(367);
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
		public Token cardinality;
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
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(372);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).visibility.element);
			setState(381);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
				{
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(376);
					((EClassContext)_localctx).isAbstract = match(T__23);
					}
				}

				setState(379);
				((EClassContext)_localctx).isClass = match(T__24);
				}
				break;
			case T__25:
				{
				setState(380);
				((EClassContext)_localctx).isInterface = match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.element.setAbstract(((EClassContext)_localctx).isAbstract!=null); if (((EClassContext)_localctx).isInterface!=null) {_localctx.element.setInterface(true);_localctx.element.setAbstract(true);}
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(384);
				((EClassContext)_localctx).cardinality = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
					((EClassContext)_localctx).cardinality = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(387);
				((EClassContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			if (_localctx.name == null) {notifyErrorListeners("missing Class name");} else {_localctx.element.setName((((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null));}
			if (((EClassContext)_localctx).isInterface!=null) {owner.deleteOwnedElement(_localctx.current); ((EClassContext)_localctx).current =  new Interface(_localctx.element, _localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);}
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__86) {
				{
				setState(392);
				((EClassContext)_localctx).ownedSignature = ((EClassContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EClassContext)_localctx).templateSignature.typeParameters);
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(396);
				match(T__30);
				setState(397);
				((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(398);
					match(T__2);
					setState(399);
					((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
					}
					}
					setState(404);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(408);
				match(T__5);
				setState(409);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EClassContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EClassContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__31) {
				{
				setState(415);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__12:
					{
					setState(413);
					((EClassContext)_localctx).lowerIncluded = match(T__12);
					}
					break;
				case T__31:
					{
					setState(414);
					match(T__31);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(417);
				((EClassContext)_localctx).lowerScope = match(INT);
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(418);
					match(T__2);
					setState(419);
					((EClassContext)_localctx).upperScope = match(INT);
					}
				}

				setState(424);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(422);
					((EClassContext)_localctx).upperIncluded = match(T__13);
					}
					break;
				case T__32:
					{
					setState(423);
					match(T__32);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}


			setState(449);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(429);
				match(T__1);
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__47))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__84 - 72)) | (1L << (T__98 - 72)) | (1L << (T__99 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)))) != 0)) {
					{
					setState(442);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						setState(430);
						((EClassContext)_localctx).eAnnotation = ((EClassContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						if (((EClassContext)_localctx).eAnnotation.element != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(433);
						((EClassContext)_localctx).eOperation = ((EClassContext)_localctx).eOperation = eOperation(_localctx.current);
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						if (((EClassContext)_localctx).eOperation.element != null) _localctx.element.getEOperations().add(((EClassContext)_localctx).eOperation.element);
						}
						break;
					case 3:
						{
						setState(436);
						((EClassContext)_localctx).eStructuralFeature = ((EClassContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.current);
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						if (((EClassContext)_localctx).eStructuralFeature.element != null) _localctx.element.getEStructuralFeatures().add(((EClassContext)_localctx).eStructuralFeature.element);
						}
						break;
					case 4:
						{
						setState(439);
						((EClassContext)_localctx).invariant = ((EClassContext)_localctx).invariant = invariant(_localctx.current);
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						if (((EClassContext)_localctx).invariant.element != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(447);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(448);
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
			setState(457);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(451);
				((EStructuralFeatureContext)_localctx).eAttribute = eAttribute(_localctx.owner);
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eAttribute.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(454);
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
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(459);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).visibility.element);
			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(463);
				((EAttributeContext)_localctx).s34 = match(T__33);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s34);
				}
			}

			setState(468);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(466);
				((EAttributeContext)_localctx).s12 = match(T__11);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s12);
				}
				break;
			case T__34:
				{
				setState(467);
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
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(470);
				((EAttributeContext)_localctx).s36 = match(T__35);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s36);
				}
			}

			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(473);
				((EAttributeContext)_localctx).s37 = match(T__36);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s37);
				}
			}

			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__37) {
				{
				setState(476);
				((EAttributeContext)_localctx).s38 = match(T__37);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s38);
				}
			}

			setState(479);
			match(T__38);
			setState(481);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(480);
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
			setState(483);
			((EAttributeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EAttributeContext)_localctx).name!=null?_input.getText(((EAttributeContext)_localctx).name.start,((EAttributeContext)_localctx).name.stop):null));
			setState(485);
			match(T__5);
			setState(486);
			((EAttributeContext)_localctx).eAttributeType = eGenericElementType(_localctx.current);
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(487);
				((EAttributeContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement)_localctx.element);
				}
			}

			if(_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(491);
				match(T__22);
				setState(492);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EAttributeContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EAttributeContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(515);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(496);
				match(T__1);
				setState(510); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(505);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__39:
						{
						setState(497);
						((EAttributeContext)_localctx).s40 = match(T__39);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(498);
						((EAttributeContext)_localctx).s41 = match(T__40);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(499);
						((EAttributeContext)_localctx).s42 = match(T__41);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s42);
						}
						break;
					case T__42:
						{
						setState(500);
						((EAttributeContext)_localctx).s43 = match(T__42);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(501);
						((EAttributeContext)_localctx).s44 = match(T__43);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s44);
						}
						break;
					case T__44:
						{
						setState(502);
						((EAttributeContext)_localctx).s45 = match(T__44);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s45);
						}
						break;
					case T__45:
						{
						setState(503);
						((EAttributeContext)_localctx).s46 = match(T__45);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s46);
						}
						break;
					case T__46:
						{
						setState(504);
						((EAttributeContext)_localctx).s47 = match(T__46);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s47);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(508);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(507);
						match(T__2);
						}
					}

					}
					}
					setState(512); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0) );
				setState(514);
				match(T__3);
				}
				break;
			}
			setState(544);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(517);
				match(T__1);
				{
				setState(523);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(518);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(525);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				}
				setState(532);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__106:
					{
					setState(526);
					((EAttributeContext)_localctx).ownedDerivation = ((EAttributeContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).derivation.element);
					}
					break;
				case T__105:
					{
					setState(529);
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
				setState(539);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__84) {
					{
					{
					setState(534);
					((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
					}
					}
					setState(541);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(542);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(543);
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
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(548);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).visibility.element);
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(552);
				((EReferenceContext)_localctx).s34 = match(T__33);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s34);
				}
			}

			setState(557);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(555);
				((EReferenceContext)_localctx).s12 = match(T__11);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s12);
				}
				break;
			case T__34:
				{
				setState(556);
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
			setState(560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(559);
				((EReferenceContext)_localctx).s36 = match(T__35);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s36);
				}
			}

			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(562);
				((EReferenceContext)_localctx).s37 = match(T__36);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
				}
			}

			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__37) {
				{
				setState(565);
				((EReferenceContext)_localctx).s38 = match(T__37);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
				}
			}

			setState(568);
			match(T__47);
			setState(570);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(569);
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
			setState(572);
			((EReferenceContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null));
			setState(576);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__48) {
				{
				setState(574);
				match(T__48);
				setState(575);
				((EReferenceContext)_localctx).eOpposite = unrestrictedName();
				}
			}


			{
			setState(579);
			match(T__5);
			setState(580);
			((EReferenceContext)_localctx).eReferenceType = eGenericElementType(_localctx.current);
			setState(582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(581);
				((EReferenceContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			}
			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(585);
				match(T__22);
				setState(586);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EReferenceContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EReferenceContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(629);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(590);
				match(T__1);
				setState(624); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(619);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__49:
						{
						setState(591);
						((EReferenceContext)_localctx).s50 = match(T__49);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s50);
						}
						break;
					case T__39:
						{
						setState(592);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					case T__50:
						{
						setState(593);
						((EReferenceContext)_localctx).s51 = match(T__50);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s51);
						}
						break;
					case T__51:
						{
						setState(594);
						((EReferenceContext)_localctx).s52 = match(T__51);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s52);
						}
						break;
					case T__52:
						{
						setState(595);
						((EReferenceContext)_localctx).s53 = match(T__52);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s53);
						}
						break;
					case T__53:
						{
						setState(596);
						((EReferenceContext)_localctx).s54 = match(T__53);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s54);
						}
						break;
					case T__54:
						{
						setState(597);
						((EReferenceContext)_localctx).s55 = match(T__54);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s55);
						}
						break;
					case T__55:
						{
						setState(598);
						((EReferenceContext)_localctx).s56 = match(T__55);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s56);
						}
						break;
					case T__56:
						{
						setState(599);
						((EReferenceContext)_localctx).s57 = match(T__56);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s57);
						}
						break;
					case T__57:
						{
						setState(600);
						((EReferenceContext)_localctx).s58 = match(T__57);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s58);
						}
						break;
					case T__58:
						{
						setState(601);
						((EReferenceContext)_localctx).s59 = match(T__58);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s59);
						}
						break;
					case T__59:
						{
						setState(602);
						((EReferenceContext)_localctx).s60 = match(T__59);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s60);
						}
						break;
					case T__60:
						{
						setState(603);
						((EReferenceContext)_localctx).s61 = match(T__60);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s61);
						}
						break;
					case T__61:
						{
						setState(604);
						((EReferenceContext)_localctx).s62 = match(T__61);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s62);
						}
						break;
					case T__62:
						{
						setState(605);
						((EReferenceContext)_localctx).s63 = match(T__62);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s63);
						}
						break;
					case T__63:
						{
						setState(606);
						((EReferenceContext)_localctx).s64 = match(T__63);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s64);
						}
						break;
					case T__64:
						{
						setState(607);
						((EReferenceContext)_localctx).s65 = match(T__64);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s65);
						}
						break;
					case T__65:
						{
						setState(608);
						((EReferenceContext)_localctx).s66 = match(T__65);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s66);
						}
						break;
					case T__66:
						{
						setState(609);
						((EReferenceContext)_localctx).s67 = match(T__66);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s67);
						}
						break;
					case T__67:
						{
						setState(610);
						((EReferenceContext)_localctx).s68 = match(T__67);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s68);
						}
						break;
					case T__41:
						{
						setState(611);
						((EReferenceContext)_localctx).s42 = match(T__41);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s42);
						}
						break;
					case T__42:
						{
						setState(612);
						((EReferenceContext)_localctx).s43 = match(T__42);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(613);
						((EReferenceContext)_localctx).s44 = match(T__43);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s44);
						}
						break;
					case T__44:
						{
						setState(614);
						((EReferenceContext)_localctx).s45 = match(T__44);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s45);
						}
						break;
					case T__68:
						{
						setState(615);
						((EReferenceContext)_localctx).s69 = match(T__68);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s69);
						}
						break;
					case T__69:
						{
						setState(616);
						((EReferenceContext)_localctx).s70 = match(T__69);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s70);
						}
						break;
					case T__45:
						{
						setState(617);
						((EReferenceContext)_localctx).s46 = match(T__45);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s46);
						}
						break;
					case T__46:
						{
						setState(618);
						((EReferenceContext)_localctx).s47 = match(T__46);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s47);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(622);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(621);
						match(T__2);
						}
					}

					}
					}
					setState(626); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (T__39 - 40)) | (1L << (T__41 - 40)) | (1L << (T__42 - 40)) | (1L << (T__43 - 40)) | (1L << (T__44 - 40)) | (1L << (T__45 - 40)) | (1L << (T__46 - 40)) | (1L << (T__49 - 40)) | (1L << (T__50 - 40)) | (1L << (T__51 - 40)) | (1L << (T__52 - 40)) | (1L << (T__53 - 40)) | (1L << (T__54 - 40)) | (1L << (T__55 - 40)) | (1L << (T__56 - 40)) | (1L << (T__57 - 40)) | (1L << (T__58 - 40)) | (1L << (T__59 - 40)) | (1L << (T__60 - 40)) | (1L << (T__61 - 40)) | (1L << (T__62 - 40)) | (1L << (T__63 - 40)) | (1L << (T__64 - 40)) | (1L << (T__65 - 40)) | (1L << (T__66 - 40)) | (1L << (T__67 - 40)) | (1L << (T__68 - 40)) | (1L << (T__69 - 40)))) != 0) );
				setState(628);
				match(T__3);
				}
				break;
			}
			setState(676);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(631);
				match(T__1);
				setState(643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__70) {
					{
					setState(632);
					match(T__70);
					setState(633);
					((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
					setState(638);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(634);
						match(T__2);
						setState(635);
						((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
						}
						}
						setState(640);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(641);
					match(T__10);
					}
				}

				{
				setState(650);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(645);
						((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(652);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				}
				setState(659);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__106:
					{
					setState(653);
					((EReferenceContext)_localctx).ownedDerivation = ((EReferenceContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).derivation.element);
					}
					break;
				case T__105:
					{
					setState(656);
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
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__84) {
					{
					{
					setState(661);
					((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
					}
					}
					setState(668);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__100) {
					{
					setState(669);
					((EReferenceContext)_localctx).reason = reason(_localctx.current);
					if (((EReferenceContext)_localctx).reason.element != null) _localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).reason.element);
					}
				}

				setState(674);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(675);
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
			setState(681);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(680);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EOperationContext)_localctx).visibility.element);
			setState(685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(684);
				((EOperationContext)_localctx).s34 = match(T__33);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s34);
				}
			}

			setState(687);
			match(T__71);
			setState(689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__86) {
				{
				setState(688);
				((EOperationContext)_localctx).ownedSignature = ((EOperationContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EOperationContext)_localctx).templateSignature.typeParameters);
			setState(692);
			((EOperationContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null));
			{
			setState(694);
			match(T__31);
			setState(703);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__151 - 152)) | (1L << (T__152 - 152)) | (1L << (T__153 - 152)) | (1L << (IDENTIFIER - 152)))) != 0)) {
				{
				setState(695);
				((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(696);
					match(T__2);
					setState(697);
					((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(702);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(705);
			match(T__32);
			}
			for (EParameterContext ctx: ((EOperationContext)_localctx).eParameters){_localctx.element.getEParameters().add(ctx.element);}
			setState(713);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(708);
				match(T__5);
				setState(709);
				((EOperationContext)_localctx).eReturnType = ((EOperationContext)_localctx).eGenericElementType = eGenericElementType(_localctx.current);
				setState(711);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(710);
					((EOperationContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
					}
				}

				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			 if (_localctx.eReturnType != null) _localctx.element.setEGenericType(((EOperationContext)_localctx).eGenericElementType.element);
			setState(726);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__72) {
				{
				setState(717);
				match(T__72);
				setState(718);
				((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(719);
					match(T__2);
					setState(720);
					((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
					}
					}
					setState(725);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 for(EGenericExceptionContext e: ((EOperationContext)_localctx).ownedException) _localctx.element.getEGenericExceptions().add(e.element);
			setState(744);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				{
				setState(729);
				match(T__1);
				setState(739); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(734);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__41:
						{
						setState(730);
						((EOperationContext)_localctx).s42 = match(T__41);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s42);
						}
						break;
					case T__42:
						{
						setState(731);
						((EOperationContext)_localctx).s43 = match(T__42);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(732);
						((EOperationContext)_localctx).s44 = match(T__43);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s44);
						}
						break;
					case T__44:
						{
						setState(733);
						((EOperationContext)_localctx).s45 = match(T__44);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s45);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(737);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(736);
						match(T__2);
						}
					}

					}
					}
					setState(741); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) );
				setState(743);
				match(T__3);
				}
				break;
			}
			setState(766);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(746);
				match(T__1);
				setState(761);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__97 - 85)) | (1L << (T__101 - 85)) | (1L << (T__102 - 85)) | (1L << (T__103 - 85)) | (1L << (T__104 - 85)))) != 0)) {
					{
					setState(759);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__84:
						{
						setState(747);
						((EOperationContext)_localctx).eAnnotation = ((EOperationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).eAnnotation.element);
						}
						break;
					case T__101:
					case T__102:
						{
						setState(750);
						((EOperationContext)_localctx).precondition = ((EOperationContext)_localctx).precondition = precondition(_localctx.current);
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).precondition.element);
						}
						break;
					case T__97:
						{
						setState(753);
						((EOperationContext)_localctx).body = ((EOperationContext)_localctx).body = body(_localctx.current);
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).body.element);
						}
						break;
					case T__103:
					case T__104:
						{
						setState(756);
						((EOperationContext)_localctx).postcondition = ((EOperationContext)_localctx).postcondition = postcondition(_localctx.current);
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).postcondition.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(763);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(764);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(765);
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
			setState(770);
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
			setState(773);
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
			setState(776);
			((EParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null));
			setState(778);
			match(T__5);
			setState(779);
			((EParameterContext)_localctx).eParameterType = eGenericElementType(_localctx.current);
			setState(781);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(780);
				((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(799);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(784);
				match(T__1);
				setState(794); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(789);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__41:
						{
						setState(785);
						((EParameterContext)_localctx).s42 = match(T__41);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s42);
						}
						break;
					case T__42:
						{
						setState(786);
						((EParameterContext)_localctx).s43 = match(T__42);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(787);
						((EParameterContext)_localctx).s44 = match(T__43);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s44);
						}
						break;
					case T__44:
						{
						setState(788);
						((EParameterContext)_localctx).s45 = match(T__44);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s45);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(792);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(791);
						match(T__2);
						}
					}

					}
					}
					setState(796); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) );
				setState(798);
				match(T__3);
				}
				break;
			}
			setState(810);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(801);
				match(T__1);
				setState(805);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__84) {
					{
					{
					setState(802);
					((EParameterContext)_localctx).eAnnotation = ((EParameterContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(807);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EParameterContext)_localctx).eAnnotation.element);
				setState(809);
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
			setState(814);
			match(T__12);
			setState(821);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(815);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(818);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__73) {
					{
					setState(816);
					match(T__73);
					setState(817);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__16:
			case T__74:
			case T__75:
				{
				setState(820);
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
			setState(825);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__76:
				{
				setState(823);
				((EMultiplicityContext)_localctx).nullable = match(T__76);
				}
				break;
			case T__77:
				{
				setState(824);
				match(T__77);
				}
				break;
			case T__13:
				break;
			default:
				break;
			}
			setState(827);
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
			setState(831);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(830);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).visibility.element);
			setState(835);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__78) {
				{
				setState(834);
				((EDataTypeContext)_localctx).s79 = match(T__78);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s79);
				}
			}

			setState(837);
			match(T__79);
			setState(838);
			((EDataTypeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null));
			setState(841);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__86) {
				{
				setState(840);
				((EDataTypeContext)_localctx).ownedSignature = ((EDataTypeContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EDataTypeContext)_localctx).templateSignature.typeParameters);
			setState(846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(844);
				match(T__5);
				setState(845);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EDataTypeContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EDataTypeContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(855);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(849);
				match(T__1);
				setState(852);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__80:
					{
					setState(850);
					((EDataTypeContext)_localctx).s81 = match(T__80);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s81);
					}
					break;
				case T__81:
					{
					setState(851);
					((EDataTypeContext)_localctx).s82 = match(T__81);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s82);
					}
					break;
				case T__3:
					break;
				default:
					break;
				}
				setState(854);
				match(T__3);
				}
				break;
			}
			setState(871);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(857);
				match(T__1);
				setState(866);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__98 - 85)) | (1L << (T__99 - 85)))) != 0)) {
					{
					setState(864);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__84:
						{
						setState(858);
						((EDataTypeContext)_localctx).eAnnotation = ((EDataTypeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).eAnnotation.element);
						}
						break;
					case T__98:
					case T__99:
						{
						setState(861);
						((EDataTypeContext)_localctx).invariant = ((EDataTypeContext)_localctx).invariant = invariant(_localctx.current);
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).invariant.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(868);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(869);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(870);
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
			setState(876);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)))) != 0)) {
				{
				setState(875);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EEnumContext)_localctx).visibility.element);
			setState(879);
			match(T__82);
			setState(880);
			((EEnumContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null));
			setState(883);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__86) {
				{
				setState(882);
				((EEnumContext)_localctx).ownedSignature = ((EEnumContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EEnumContext)_localctx).templateSignature.typeParameters);
			setState(888);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(886);
				match(T__5);
				setState(887);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EEnumContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EEnumContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(897);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				{
				setState(891);
				match(T__1);
				setState(894);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__80:
					{
					setState(892);
					((EEnumContext)_localctx).s81 = match(T__80);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s81);
					}
					break;
				case T__81:
					{
					setState(893);
					((EEnumContext)_localctx).s82 = match(T__81);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s82);
					}
					break;
				case T__3:
					break;
				default:
					break;
				}
				setState(896);
				match(T__3);
				}
				break;
			}
			setState(916);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(899);
				match(T__1);
				setState(911);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__151 - 152)) | (1L << (T__152 - 152)) | (1L << (T__153 - 152)) | (1L << (IDENTIFIER - 152)))) != 0)) {
					{
					setState(909);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
					case 1:
						{
						setState(900);
						((EEnumContext)_localctx).eAnnotation = ((EEnumContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(903);
						((EEnumContext)_localctx).eEnumLiteral = ((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.current);
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						_localctx.element.getELiterals().add(((EEnumContext)_localctx).eEnumLiteral.element);
						}
						break;
					case 3:
						{
						setState(906);
						((EEnumContext)_localctx).invariant = ((EEnumContext)_localctx).invariant = invariant(_localctx.current);
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(913);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(914);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(915);
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
			setState(923);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				{
				{
				setState(920);
				match(T__83);
				setState(921);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(922);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			_localctx.element.setName((((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null));
			setState(928);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(926);
				match(T__22);
				setState(927);
				((EEnumLiteralContext)_localctx).value = match(INT);
				}
			}

			 
			setState(941);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(931);
				match(T__1);
				setState(935);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__84) {
					{
					{
					setState(932);
					((EEnumLiteralContext)_localctx).eAnnotation = ((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(937);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EEnumLiteralContext)_localctx).eAnnotation.element);
				setState(939);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(940);
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
			setState(943);
			match(T__84);
			setState(945);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(944);
				((EAnnotationContext)_localctx).source = match(SINGLE_QUOTED_STRING);
				}
			}

			_localctx.element.setSource(((EAnnotationContext)_localctx).source != null ? ((EAnnotationContext)_localctx).source.getText().replace("'", "") : null);
			setState(959);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(948);
				match(T__31);
				setState(949);
				((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(950);
					match(T__2);
					setState(951);
					((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(956);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(957);
				match(T__32);
				}
			}

			for (EDetailContext ctx: ((EAnnotationContext)_localctx).ownedDetails) _localctx.element.getDetails().put(ctx.k, ctx.v);
			setState(979);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(962);
				match(T__1);
				setState(972); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(972);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
					case 1:
						{
						setState(963);
						((EAnnotationContext)_localctx).eAnnotation = ((EAnnotationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						if(((EAnnotationContext)_localctx).eAnnotation.element != null) _localctx.element.getEAnnotations().add(((EAnnotationContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(966);
						((EAnnotationContext)_localctx).eModelElement = ((EAnnotationContext)_localctx).eModelElement = eModelElement(_localctx.current);
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						if(((EAnnotationContext)_localctx).eModelElement.element != null) _localctx.element.getContents().add(((EAnnotationContext)_localctx).eModelElement.element);
						}
						break;
					case 3:
						{
						setState(969);
						((EAnnotationContext)_localctx).eModelElementRef = ((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef(_localctx.current);
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						if(((EAnnotationContext)_localctx).eModelElementRef.element != null) _localctx.element.getReferences().add(((EAnnotationContext)_localctx).eModelElementRef.element);
						}
						break;
					}
					}
					setState(974); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__151 - 152)) | (1L << (T__152 - 152)) | (1L << (T__153 - 152)) | (1L << (IDENTIFIER - 152)))) != 0) );
				setState(976);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(978);
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
			setState(982);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(981);
				((EDetailContext)_localctx).key = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(984);
			match(T__22);
			setState(986);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) {
				{
				setState(985);
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
			setState(996);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(990);
				((EModelElementContext)_localctx).eAnnotation = eAnnotation(_localctx.owner);
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eAnnotation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(993);
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
			setState(1010);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(998);
				((ENamedElementContext)_localctx).eTypedElement = eTypedElement(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eTypedElement.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1001);
				((ENamedElementContext)_localctx).eClassifier = eClassifier(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eClassifier.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1004);
				((ENamedElementContext)_localctx).ePackage = ePackage(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).ePackage.element;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1007);
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
			setState(1021);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1012);
				((ETypedElementContext)_localctx).eOperation = eOperation(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eOperation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1015);
				((ETypedElementContext)_localctx).eParameter = eParameter(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eParameter.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1018);
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
			setState(1023);
			match(T__85);
			setState(1024);
			((EModelElementRefContext)_localctx).ownedPathName = pathName(_localctx.current);
			if (((EModelElementRefContext)_localctx).ownedPathName.element != null) _localctx.current.setEObject(((EModelElementRefContext)_localctx).element =  ((EModelElementRefContext)_localctx).ownedPathName.element);
			setState(1026);
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
			setState(1028);
			match(T__86);
			setState(1029);
			((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
			((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
			setState(1034);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1030);
				match(T__2);
				setState(1031);
				((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
				((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
				}
				}
				setState(1036);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1037);
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
			setState(1039);
			((ETypeParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((ETypeParameterContext)_localctx).name!=null?_input.getText(((ETypeParameterContext)_localctx).name.start,((ETypeParameterContext)_localctx).name.stop):null));
			setState(1050);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(1041);
				match(T__30);
				setState(1042);
				((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
				setState(1047);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__88) {
					{
					{
					setState(1043);
					match(T__88);
					setState(1044);
					((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
					((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
					}
					}
					setState(1049);
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
			setState(1060);
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
			case T__151:
			case T__152:
			case T__153:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1054);
				((EGenericTypeArgumentContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((EGenericTypeArgumentContext)_localctx).element =  ((EGenericTypeArgumentContext)_localctx).eGenericType.element; _localctx.current.setEObject(_localctx.element);
				}
				break;
			case T__75:
				enterOuterAlt(_localctx, 2);
				{
				setState(1057);
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

		if (owner instanceof Expression.Relation) {((EGenericTypeContext)_localctx).current =  new GenericType(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);}
		else{
		((EGenericTypeContext)_localctx).element =  eFactory.createEGenericType();
		if (_localctx.parent instanceof ETypeParameterContext) {((EGenericTypeContext)_localctx).current =  new GenericType(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);}
		else {((EGenericTypeContext)_localctx).current =  _localctx.owner;}
		}

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062);
			((EGenericTypeContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(1074);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
			case 1:
				{
				setState(1063);
				match(T__86);
				setState(1064);
				((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
				((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
				setState(1069);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1065);
					match(T__2);
					setState(1066);
					((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
					((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
					}
					}
					setState(1071);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1072);
				match(T__87);
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
			setState(1082);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__92:
			case T__93:
			case T__94:
			case T__95:
			case T__96:
				enterOuterAlt(_localctx, 1);
				{
				setState(1076);
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
			case T__151:
			case T__152:
			case T__153:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1079);
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
			setState(1084);
			match(T__75);
			((EGenericWildcardContext)_localctx).element =  eFactory.createEGenericType();
			setState(1091);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30 || _la==T__89) {
				{
				setState(1086);
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
				setState(1088);
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
			setState(1093);
			((PathNameContext)_localctx).firstSegment = unrestrictedName();
			setState(1096);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
			case 1:
				{
				setState(1094);
				match(T__18);
				setState(1095);
				((PathNameContext)_localctx).index = match(INT);
				}
				break;
			}
			setState(1105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				{
				setState(1101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1098);
						((PathNameContext)_localctx).segment = segment();
						((PathNameContext)_localctx).midSegments.add(((PathNameContext)_localctx).segment);
						}
						} 
					}
					setState(1103);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
				}
				setState(1104);
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
			setState(1107);
			match(T__90);
			setState(1109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__91) {
				{
				setState(1108);
				match(T__91);
				}
			}

			setState(1111);
			((SegmentContext)_localctx).name = unrestrictedName();
			setState(1114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
			case 1:
				{
				setState(1112);
				match(T__18);
				setState(1113);
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
			setState(1126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__92:
				enterOuterAlt(_localctx, 1);
				{
				setState(1116);
				match(T__92);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBoolean());
				}
				break;
			case T__93:
				enterOuterAlt(_localctx, 2);
				{
				setState(1118);
				match(T__93);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEInt());
				}
				break;
			case T__94:
				enterOuterAlt(_localctx, 3);
				{
				setState(1120);
				match(T__94);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEString());
				}
				break;
			case T__95:
				enterOuterAlt(_localctx, 4);
				{
				setState(1122);
				match(T__95);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBigDecimal());
				}
				break;
			case T__96:
				enterOuterAlt(_localctx, 5);
				{
				setState(1124);
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
			setState(1128);
			match(T__97);
			setState(1130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1129);
				((BodyContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((BodyContext)_localctx).name!=null?_input.getText(((BodyContext)_localctx).name.start,((BodyContext)_localctx).name.stop):null)); 
			setState(1139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1133);
				match(T__5);
				setState(1135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (T__130 - 131)) | (1L << (T__131 - 131)) | (1L << (T__135 - 131)) | (1L << (T__138 - 131)) | (1L << (T__139 - 131)) | (1L << (T__140 - 131)) | (1L << (T__141 - 131)) | (1L << (T__151 - 131)) | (1L << (T__152 - 131)) | (1L << (T__153 - 131)) | (1L << (IDENTIFIER - 131)) | (1L << (DOUBLE_QUOTED_STRING - 131)))) != 0)) {
					{
					setState(1134);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1137);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1138);
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
			setState(1144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__98) {
				{
				setState(1143);
				((InvariantContext)_localctx).isCallable = match(T__98);
				}
			}

			_localctx.element.getDetails().put("callable", ((InvariantContext)_localctx).isCallable != null ? "true" : "false");
			setState(1147);
			match(T__99);
			setState(1154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1148);
				((InvariantContext)_localctx).name = identifier();
				setState(1152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(1149);
					match(T__31);
					setState(1150);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1151);
					match(T__32);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InvariantContext)_localctx).name!=null?_input.getText(((InvariantContext)_localctx).name.start,((InvariantContext)_localctx).name.stop):null)); if(((InvariantContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((InvariantContext)_localctx).message!=null?((InvariantContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1157);
				match(T__5);
				setState(1159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
					{
					setState(1158);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1161);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1162);
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
			setState(1167);
			match(T__100);
			setState(1174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1168);
				match(T__5);
				setState(1170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
					{
					setState(1169);
					((ReasonContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1172);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1173);
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
			setState(1178);
			_la = _input.LA(1);
			if ( !(_la==T__101 || _la==T__102) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1179);
				((PreconditionContext)_localctx).name = identifier();
				setState(1183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(1180);
					match(T__31);
					setState(1181);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1182);
					match(T__32);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PreconditionContext)_localctx).name!=null?_input.getText(((PreconditionContext)_localctx).name.start,((PreconditionContext)_localctx).name.stop):null)); if(((PreconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PreconditionContext)_localctx).message!=null?((PreconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1188);
				match(T__5);
				setState(1190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
					{
					setState(1189);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1192);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1193);
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
			setState(1198);
			_la = _input.LA(1);
			if ( !(_la==T__103 || _la==T__104) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1199);
				((PostconditionContext)_localctx).name = identifier();
				setState(1203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(1200);
					match(T__31);
					setState(1201);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1202);
					match(T__32);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PostconditionContext)_localctx).name!=null?_input.getText(((PostconditionContext)_localctx).name.start,((PostconditionContext)_localctx).name.stop):null)); if(((PostconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PostconditionContext)_localctx).message!=null?((PostconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1208);
				match(T__5);
				setState(1210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
					{
					setState(1209);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1212);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1213);
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
			setState(1218);
			match(T__105);
			setState(1220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1219);
				((InitialContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InitialContext)_localctx).name!=null?_input.getText(((InitialContext)_localctx).name.start,((InitialContext)_localctx).name.stop):null));
			setState(1229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1223);
				match(T__5);
				setState(1225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (T__130 - 131)) | (1L << (T__131 - 131)) | (1L << (T__135 - 131)) | (1L << (T__138 - 131)) | (1L << (T__139 - 131)) | (1L << (T__140 - 131)) | (1L << (T__141 - 131)) | (1L << (T__151 - 131)) | (1L << (T__152 - 131)) | (1L << (T__153 - 131)) | (1L << (IDENTIFIER - 131)) | (1L << (DOUBLE_QUOTED_STRING - 131)))) != 0)) {
					{
					setState(1224);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1227);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1228);
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
			setState(1233);
			match(T__106);
			setState(1235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1234);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((DerivationContext)_localctx).name!=null?_input.getText(((DerivationContext)_localctx).name.start,((DerivationContext)_localctx).name.stop):null));
			setState(1244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1238);
				match(T__5);
				setState(1240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (T__130 - 131)) | (1L << (T__131 - 131)) | (1L << (T__135 - 131)) | (1L << (T__138 - 131)) | (1L << (T__139 - 131)) | (1L << (T__140 - 131)) | (1L << (T__141 - 131)) | (1L << (T__151 - 131)) | (1L << (T__152 - 131)) | (1L << (T__153 - 131)) | (1L << (IDENTIFIER - 131)) | (1L << (DOUBLE_QUOTED_STRING - 131)))) != 0)) {
					{
					setState(1239);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1242);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1243);
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
			setState(1251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__107:
				{
				setState(1248);
				((VisibilityKindContext)_localctx).qualifier = match(T__107);
				}
				break;
			case T__108:
				{
				setState(1249);
				((VisibilityKindContext)_localctx).qualifier = match(T__108);
				}
				break;
			case T__109:
				{
				setState(1250);
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
			setState(1544);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1256);
				match(T__29);
				setState(1257);
				expression(0);
				((NoContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1260);
				match(T__27);
				setState(1261);
				expression(0);
				((LoneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1264);
				match(T__26);
				setState(1265);
				expression(0);
				((OneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1268);
				match(T__28);
				setState(1269);
				expression(0);
				((SomeContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1272);
				((InContext)_localctx).left = expression(0);
				setState(1274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1273);
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

				setState(1276);
				match(T__112);
				setState(1277);
				((InContext)_localctx).right = expression(0);
				((InContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1280);
				((EqualContext)_localctx).left = expression(0);
				setState(1282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1281);
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

				setState(1284);
				match(T__22);
				setState(1285);
				((EqualContext)_localctx).right = expression(0);
				((EqualContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1288);
				((EqContext)_localctx).ileft = intExpression(0);
				setState(1290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1289);
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

				setState(1292);
				match(T__22);
				setState(1293);
				((EqContext)_localctx).iright = intExpression(0);
				((EqContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1296);
				((LtContext)_localctx).ileft = intExpression(0);
				setState(1298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1297);
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

				setState(1300);
				match(T__86);
				setState(1301);
				((LtContext)_localctx).iright = intExpression(0);
				((LtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1304);
				((LteContext)_localctx).ileft = intExpression(0);
				setState(1306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1305);
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

				setState(1308);
				match(T__113);
				setState(1309);
				((LteContext)_localctx).iright = intExpression(0);
				((LteContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1312);
				((GtContext)_localctx).ileft = intExpression(0);
				setState(1314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1313);
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

				setState(1316);
				match(T__87);
				setState(1317);
				((GtContext)_localctx).iright = intExpression(0);
				((GtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1320);
				((GteContext)_localctx).ileft = intExpression(0);
				setState(1322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__110 || _la==T__111) {
					{
					setState(1321);
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

				setState(1324);
				match(T__114);
				setState(1325);
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
				setState(1328);
				match(T__115);
				setState(1329);
				quantifierDeclarations();
				setState(1330);
				match(T__116);
				setState(1331);
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
				setState(1335);
				match(T__50);
				setState(1336);
				match(T__12);
				setState(1337);
				relationId();
				setState(1338);
				match(T__13);
				((AcyclicContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1341);
				match(T__117);
				setState(1342);
				match(T__12);
				setState(1343);
				((FunctionContext)_localctx).rel = relationId();
				setState(1344);
				match(T__5);
				setState(1345);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1346);
				match(T__118);
				setState(1351);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
				case 1:
					{
					setState(1348);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
					case 1:
						{
						setState(1347);
						match(T__26);
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(1350);
					((FunctionContext)_localctx).partial = match(T__27);
					}
					break;
				}
				setState(1353);
				((FunctionContext)_localctx).range = expression(0);
				setState(1354);
				match(T__13);
				((FunctionContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1357);
				match(T__119);
				setState(1358);
				match(T__12);
				setState(1359);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1360);
				match(T__2);
				setState(1361);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1362);
				match(T__2);
				setState(1363);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1364);
				match(T__2);
				setState(1365);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1366);
				match(T__13);
				((TotalOrderContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 16:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1369);
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
				setState(1370);
				((NotContext)_localctx).formula = formula(14);
				((NotContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 17:
				{
				_localctx = new ForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1374);
				match(T__128);
				setState(1375);
				quantifierDeclarations();
				setState(1396);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1376);
					match(T__116);
					setState(1386);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
					case 1:
						{
						setState(1377);
						((ForAllContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1378);
						match(T__1);
						setState(1382);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
							{
							{
							setState(1379);
							((ForAllContext)_localctx).formula = formula(0);
							}
							}
							setState(1384);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1385);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1388);
					match(T__1);
					setState(1392);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
						{
						{
						setState(1389);
						((ForAllContext)_localctx).formula = formula(0);
						}
						}
						setState(1394);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1395);
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
			case 18:
				{
				_localctx = new ForSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1401);
				match(T__28);
				setState(1402);
				quantifierDeclarations();
				setState(1423);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1403);
					match(T__116);
					setState(1413);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
					case 1:
						{
						setState(1404);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1405);
						match(T__1);
						setState(1409);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
							{
							{
							setState(1406);
							((ForSomeContext)_localctx).formula = formula(0);
							}
							}
							setState(1411);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1412);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1415);
					match(T__1);
					setState(1419);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
						{
						{
						setState(1416);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						}
						setState(1421);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1422);
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
			case 19:
				{
				_localctx = new ForNoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1428);
				match(T__29);
				setState(1429);
				quantifierDeclarations();
				setState(1450);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1430);
					match(T__116);
					setState(1440);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
					case 1:
						{
						setState(1431);
						((ForNoContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1432);
						match(T__1);
						setState(1436);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
							{
							{
							setState(1433);
							((ForNoContext)_localctx).formula = formula(0);
							}
							}
							setState(1438);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1439);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1442);
					match(T__1);
					setState(1446);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
						{
						{
						setState(1443);
						((ForNoContext)_localctx).formula = formula(0);
						}
						}
						setState(1448);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1449);
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
			case 20:
				{
				_localctx = new ForOneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1455);
				match(T__26);
				setState(1456);
				quantifierDeclarations();
				setState(1477);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1457);
					match(T__116);
					setState(1467);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
					case 1:
						{
						setState(1458);
						((ForOneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1459);
						match(T__1);
						setState(1463);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
							{
							{
							setState(1460);
							((ForOneContext)_localctx).formula = formula(0);
							}
							}
							setState(1465);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1466);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1469);
					match(T__1);
					setState(1473);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
						{
						{
						setState(1470);
						((ForOneContext)_localctx).formula = formula(0);
						}
						}
						setState(1475);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1476);
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
			case 21:
				{
				_localctx = new ForLoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1482);
				match(T__27);
				setState(1483);
				quantifierDeclarations();
				setState(1504);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1484);
					match(T__116);
					setState(1494);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
					case 1:
						{
						setState(1485);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1486);
						match(T__1);
						setState(1490);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
							{
							{
							setState(1487);
							((ForLoneContext)_localctx).formula = formula(0);
							}
							}
							setState(1492);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1493);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1496);
					match(T__1);
					setState(1500);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
						{
						{
						setState(1497);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						}
						setState(1502);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1503);
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
			case 22:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				{
				setState(1509);
				match(T__129);
				setState(1510);
				letDeclarations();
				setState(1531);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__116:
					{
					setState(1511);
					match(T__116);
					setState(1521);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
					case 1:
						{
						setState(1512);
						((LetContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1513);
						match(T__1);
						setState(1517);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
							{
							{
							setState(1514);
							((LetContext)_localctx).formula = formula(0);
							}
							}
							setState(1519);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1520);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1523);
					match(T__1);
					setState(1527);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__74 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__101 - 64)) | (1L << (T__103 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__115 - 64)) | (1L << (T__117 - 64)) | (1L << (T__119 - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (T__128 - 129)) | (1L << (T__129 - 129)) | (1L << (T__130 - 129)) | (1L << (T__131 - 129)) | (1L << (T__135 - 129)) | (1L << (T__138 - 129)) | (1L << (T__139 - 129)) | (1L << (T__140 - 129)) | (1L << (T__141 - 129)) | (1L << (T__151 - 129)) | (1L << (T__152 - 129)) | (1L << (T__153 - 129)) | (1L << (INT - 129)) | (1L << (IDENTIFIER - 129)) | (1L << (DOUBLE_QUOTED_STRING - 129)))) != 0)) {
						{
						{
						setState(1524);
						((LetContext)_localctx).formula = formula(0);
						}
						}
						setState(1529);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1530);
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
			case 23:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1535);
				match(T__14);
				((TrueContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1537);
				match(T__15);
				((FalseContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1539);
				match(T__31);
				setState(1540);
				((F_paranthesisContext)_localctx).formula = formula(0);
				setState(1541);
				match(T__32);
				((F_paranthesisContext)_localctx).element =  ((F_paranthesisContext)_localctx).formula.element;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1568);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1566);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1546);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1547);
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
						setState(1548);
						((AndContext)_localctx).fright = ((AndContext)_localctx).formula = formula(14);
						((AndContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1551);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1552);
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
						setState(1553);
						((OrContext)_localctx).fright = ((OrContext)_localctx).formula = formula(13);
						((OrContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1556);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1557);
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
						setState(1558);
						((ImpliesContext)_localctx).fright = ((ImpliesContext)_localctx).formula = formula(11);
						((ImpliesContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1561);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1562);
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
						setState(1563);
						((IffContext)_localctx).fright = ((IffContext)_localctx).formula = formula(10);
						((IffContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1570);
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
	public static class DomainRestrictionContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DomainRestrictionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDomainRestriction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDomainRestriction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDomainRestriction(this);
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
		public SingletonContext singleton() {
			return getRuleContext(SingletonContext.class,0);
		}
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
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
	public static class RangeRestrictionContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RangeRestrictionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterRangeRestriction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitRangeRestriction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitRangeRestriction(this);
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
			setState(1619);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__130:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1572);
				match(T__130);
				setState(1573);
				((TransposeContext)_localctx).expression = expression(20);
				((TransposeContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__131:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1576);
				match(T__131);
				setState(1577);
				((ClosureContext)_localctx).expression = expression(19);
				((ClosureContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__74:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1580);
				match(T__74);
				setState(1581);
				((ReflexiveContext)_localctx).expression = expression(18);
				((ReflexiveContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__1:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(55)).var =  0;
				setState(1585);
				match(T__1);
				setState(1586);
				comprehensionDeclarations();
				setState(1587);
				match(T__116);
				setState(1588);
				formula(0);
				setState(1589);
				match(T__3);
				((ComprehensionContext)_localctx).element =  Expression.create(_localctx); for (int i = 0; i < ((FormulaContext)getInvokingContext(55)).var; i++) declarations.pop();
				}
				break;
			case T__135:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1592);
				match(T__135);
				setState(1593);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1594);
				match(T__136);
				setState(1595);
				((IfExpressionContext)_localctx).thenExpr = ((IfExpressionContext)_localctx).expression = expression(0);
				setState(1596);
				match(T__137);
				setState(1597);
				((IfExpressionContext)_localctx).elseExpr = ((IfExpressionContext)_localctx).expression = expression(7);
				((IfExpressionContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__138:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1600);
				match(T__138);
				((IdenContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__139:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1602);
				match(T__139);
				((NoneContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__140:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1604);
				match(T__140);
				((UnivContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__141:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1606);
				match(T__141);
				((IntsContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__31:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1608);
				match(T__31);
				setState(1609);
				((E_paranthesisContext)_localctx).expression = expression(0);
				setState(1610);
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
			case T__151:
			case T__152:
			case T__153:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
				{
				_localctx = new TypeRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1615);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOUBLE_QUOTED_STRING:
					{
					setState(1613);
					singleton();
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
				case T__151:
				case T__152:
				case T__153:
				case IDENTIFIER:
					{
					setState(1614);
					eGenericType(_localctx.element);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				((TypeRefContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1675);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,221,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1673);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
					case 1:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1621);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(1622);
						match(T__18);
						setState(1623);
						((JoinContext)_localctx).right = ((JoinContext)_localctx).expression = expression(18);
						((JoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new DomainRestrictionContext(new ExpressionContext(_parentctx, _parentState));
						((DomainRestrictionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1626);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1627);
						match(T__132);
						setState(1628);
						((DomainRestrictionContext)_localctx).right = ((DomainRestrictionContext)_localctx).expression = expression(16);
						((DomainRestrictionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new RangeRestrictionContext(new ExpressionContext(_parentctx, _parentState));
						((RangeRestrictionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1631);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1632);
						match(T__133);
						setState(1633);
						((RangeRestrictionContext)_localctx).right = ((RangeRestrictionContext)_localctx).expression = expression(15);
						((RangeRestrictionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1636);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1638);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0) || _la==T__150) {
							{
							setState(1637);
							((ProductContext)_localctx).leftMult = mult();
							}
						}

						setState(1640);
						match(T__118);
						setState(1642);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
						case 1:
							{
							setState(1641);
							((ProductContext)_localctx).rightMult = mult();
							}
							break;
						}
						setState(1644);
						((ProductContext)_localctx).right = ((ProductContext)_localctx).expression = expression(13);
						((ProductContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1647);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1648);
						match(T__88);
						setState(1649);
						((IntersectionContext)_localctx).right = ((IntersectionContext)_localctx).expression = expression(13);
						((IntersectionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 6:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1652);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1653);
						match(T__16);
						setState(1654);
						((UnionContext)_localctx).right = ((UnionContext)_localctx).expression = expression(12);
						((UnionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 7:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1657);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1658);
						match(T__17);
						setState(1659);
						((DifferenceContext)_localctx).right = ((DifferenceContext)_localctx).expression = expression(11);
						((DifferenceContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 8:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1662);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1663);
						match(T__134);
						setState(1664);
						((OverrideContext)_localctx).right = ((OverrideContext)_localctx).expression = expression(10);
						((OverrideContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 9:
						{
						_localctx = new BoxJoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxJoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1667);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1668);
						match(T__12);
						setState(1669);
						((BoxJoinContext)_localctx).left = ((BoxJoinContext)_localctx).expression = expression(0);
						setState(1670);
						match(T__13);
						((BoxJoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1677);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,221,_ctx);
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
	public static class ExprContext extends IntExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprContext(IntExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitExpr(this);
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
			setState(1708);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1679);
				match(T__135);
				setState(1680);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1681);
				match(T__136);
				setState(1682);
				((IfIntExpressionContext)_localctx).thenExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(0);
				setState(1683);
				match(T__137);
				setState(1684);
				((IfIntExpressionContext)_localctx).elseExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(11);
				((IfIntExpressionContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case 2:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1687);
				match(T__115);
				setState(1688);
				expression(0);
				((SumContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case 3:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1691);
				match(T__48);
				setState(1692);
				expression(0);
				((CountContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case 4:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1696);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(1695);
					((IntConstantContext)_localctx).sign = match(T__17);
					}
				}

				setState(1698);
				match(INT);
				((IntConstantContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case 5:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1700);
				match(T__31);
				setState(1701);
				((I_paranthesisContext)_localctx).intExpression = intExpression(0);
				setState(1702);
				match(T__32);
				((I_paranthesisContext)_localctx).element =  ((I_paranthesisContext)_localctx).intExpression.element;
				}
				break;
			case 6:
				{
				_localctx = new ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1705);
				expression(0);
				((ExprContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1737);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1735);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,224,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntExpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1710);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1711);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__142) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1712);
						((PlusContext)_localctx).iright = ((PlusContext)_localctx).intExpression = intExpression(9);
						((PlusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntExpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1715);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1716);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__143) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1717);
						((MinusContext)_localctx).iright = ((MinusContext)_localctx).intExpression = intExpression(8);
						((MinusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntExpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1720);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1721);
						_la = _input.LA(1);
						if ( !(_la==T__74 || _la==T__144) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1722);
						((MultiplyContext)_localctx).iright = ((MultiplyContext)_localctx).intExpression = intExpression(7);
						((MultiplyContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntExpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1725);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1726);
						_la = _input.LA(1);
						if ( !(_la==T__145 || _la==T__146) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1727);
						((DivideContext)_localctx).iright = ((DivideContext)_localctx).intExpression = intExpression(6);
						((DivideContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntExpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1730);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1731);
						_la = _input.LA(1);
						if ( !(_la==T__147 || _la==T__148) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1732);
						((ModuloContext)_localctx).iright = ((ModuloContext)_localctx).intExpression = intExpression(5);
						((ModuloContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1739);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
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
			setState(1740);
			quantifierDeclaration();
			setState(1745);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1741);
				match(T__2);
				setState(1742);
				quantifierDeclaration();
				}
				}
				setState(1747);
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
			setState(1814);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1749);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__149) {
					{
					setState(1748);
					((OneOfContext)_localctx).disj = match(T__149);
					}
				}

				setState(1751);
				((OneOfContext)_localctx).variable = variable();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
				setState(1756);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1752);
					match(T__2);
					setState(1753);
					((OneOfContext)_localctx).variable = variable();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
					}
					}
					setState(1758);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1759);
				match(T__5);
				setState(1761);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
				case 1:
					{
					setState(1760);
					match(T__26);
					}
					break;
				}
				setState(1763);
				expression(0);
				((OneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx); ((FormulaContext)getInvokingContext(55)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(55)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1767);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__149) {
					{
					setState(1766);
					((LoneOfContext)_localctx).disj = match(T__149);
					}
				}

				setState(1769);
				((LoneOfContext)_localctx).variable = variable();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
				setState(1774);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1770);
					match(T__2);
					setState(1771);
					((LoneOfContext)_localctx).variable = variable();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
					}
					}
					setState(1776);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1777);
				match(T__5);
				setState(1778);
				match(T__27);
				setState(1779);
				expression(0);
				((LoneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx); ((FormulaContext)getInvokingContext(55)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(55)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1783);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__149) {
					{
					setState(1782);
					((SomeOfContext)_localctx).disj = match(T__149);
					}
				}

				setState(1785);
				((SomeOfContext)_localctx).variable = variable();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
				setState(1790);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1786);
					match(T__2);
					setState(1787);
					((SomeOfContext)_localctx).variable = variable();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
					}
					}
					setState(1792);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1793);
				match(T__5);
				setState(1794);
				match(T__28);
				setState(1795);
				expression(0);
				((SomeOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx); ((FormulaContext)getInvokingContext(55)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(55)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1799);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__149) {
					{
					setState(1798);
					((SetOfContext)_localctx).disj = match(T__149);
					}
				}

				setState(1801);
				((SetOfContext)_localctx).variable = variable();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
				setState(1806);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1802);
					match(T__2);
					setState(1803);
					((SetOfContext)_localctx).variable = variable();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
					}
					}
					setState(1808);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1809);
				match(T__5);
				setState(1810);
				match(T__150);
				setState(1811);
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
			setState(1816);
			letDeclaration();
			setState(1821);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1817);
				match(T__2);
				setState(1818);
				letDeclaration();
				}
				}
				setState(1823);
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
			setState(1824);
			((LetDeclarationContext)_localctx).variable = variable();
			((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
			setState(1829);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1825);
				match(T__2);
				setState(1826);
				((LetDeclarationContext)_localctx).variable = variable();
				((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
				}
				}
				setState(1831);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1832);
			match(T__22);
			setState(1833);
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
			setState(1836);
			comprehensionDeclaration();
			setState(1841);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1837);
				match(T__2);
				setState(1838);
				comprehensionDeclaration();
				}
				}
				setState(1843);
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
			setState(1845);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__149) {
				{
				setState(1844);
				((ComprehensionDeclarationContext)_localctx).disj = match(T__149);
				}
			}

			{
			setState(1847);
			((ComprehensionDeclarationContext)_localctx).variable = variable();
			((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
			setState(1852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1848);
				match(T__2);
				setState(1849);
				((ComprehensionDeclarationContext)_localctx).variable = variable();
				((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
				}
				}
				setState(1854);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1855);
			match(T__5);
			setState(1857);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
			case 1:
				{
				setState(1856);
				match(T__26);
				}
				break;
			}
			setState(1859);
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
			setState(1863);
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
			setState(1865);
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
			setState(1868);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0) || _la==T__150) ) {
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
			setState(1935);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1870);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1871);
				match(T__23);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1872);
				match(T__38);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1873);
				match(T__97);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1874);
				match(T__98);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1875);
				match(T__24);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1876);
				match(T__49);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1877);
				match(T__79);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1878);
				match(T__151);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1879);
				match(T__106);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1880);
				match(T__39);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1881);
				match(T__82);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1882);
				match(T__152);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1883);
				match(T__30);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1884);
				match(T__40);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1885);
				match(T__20);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1886);
				match(T__105);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1887);
				match(T__25);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1888);
				match(T__70);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(1889);
				match(T__11);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(1890);
				match(T__71);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(1891);
				match(T__41);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(1892);
				match(T__21);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(1893);
				match(T__103);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(1894);
				match(T__101);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(1895);
				match(T__78);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(1896);
				match(T__47);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(1897);
				match(T__37);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(1898);
				match(T__85);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(1899);
				match(T__153);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(1900);
				match(T__68);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(1901);
				match(T__33);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(1902);
				match(T__72);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(1903);
				match(T__35);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(1904);
				match(T__43);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(1905);
				match(T__45);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(1906);
				match(T__36);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(1907);
				match(T__99);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(1908);
				match(T__83);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(1909);
				match(T__80);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(1910);
				match(T__84);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(1911);
				match(T__11);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 43);
				{
				setState(1912);
				match(T__9);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 44);
				{
				setState(1913);
				match(T__26);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 45);
				{
				setState(1914);
				match(T__27);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 46);
				{
				setState(1915);
				match(T__28);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 47);
				{
				setState(1916);
				match(T__29);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 48);
				{
				setState(1917);
				match(T__50);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 49);
				{
				setState(1918);
				match(T__51);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 50);
				{
				setState(1919);
				match(T__52);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 51);
				{
				setState(1920);
				match(T__53);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 52);
				{
				setState(1921);
				match(T__54);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 53);
				{
				setState(1922);
				match(T__55);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 54);
				{
				setState(1923);
				match(T__56);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 55);
				{
				setState(1924);
				match(T__57);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 56);
				{
				setState(1925);
				match(T__58);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 57);
				{
				setState(1926);
				match(T__59);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 58);
				{
				setState(1927);
				match(T__60);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 59);
				{
				setState(1928);
				match(T__61);
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 60);
				{
				setState(1929);
				match(T__62);
				}
				break;
			case 61:
				enterOuterAlt(_localctx, 61);
				{
				setState(1930);
				match(T__63);
				}
				break;
			case 62:
				enterOuterAlt(_localctx, 62);
				{
				setState(1931);
				match(T__64);
				}
				break;
			case 63:
				enterOuterAlt(_localctx, 63);
				{
				setState(1932);
				match(T__65);
				}
				break;
			case 64:
				enterOuterAlt(_localctx, 64);
				{
				setState(1933);
				match(T__66);
				}
				break;
			case 65:
				enterOuterAlt(_localctx, 65);
				{
				setState(1934);
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

	public static class SingletonContext extends ParserRuleContext {
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public SingletonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleton; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSingleton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSingleton(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSingleton(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingletonContext singleton() throws RecognitionException {
		SingletonContext _localctx = new SingletonContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_singleton);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1937);
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
		enterRule(_localctx, 138, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1939);
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
		enterRule(_localctx, 140, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1941);
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
		enterRule(_localctx, 142, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1943);
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
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 15);
		case 7:
			return precpred(_ctx, 14);
		case 8:
			return precpred(_ctx, 13);
		case 9:
			return precpred(_ctx, 12);
		case 10:
			return precpred(_ctx, 11);
		case 11:
			return precpred(_ctx, 10);
		case 12:
			return precpred(_ctx, 9);
		case 13:
			return precpred(_ctx, 16);
		}
		return true;
	}
	private boolean intExpression_sempred(IntExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 8);
		case 15:
			return precpred(_ctx, 7);
		case 16:
			return precpred(_ctx, 6);
		case 17:
			return precpred(_ctx, 5);
		case 18:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00a4\u079c\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\3\2\3\2\3\2\3\2\3\2\7\2\u0098\n\2\f\2\16\2\u009b\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00ab\n\3\3\4\3\4\3\4"+
		"\3\4\5\4\u00b1\n\4\3\4\7\4\u00b4\n\4\f\4\16\4\u00b7\13\4\3\4\3\4\3\4\5"+
		"\4\u00bc\n\4\3\5\3\5\3\5\3\5\5\5\u00c2\n\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6"+
		"\u00ca\n\6\3\6\3\6\3\6\3\6\3\6\7\6\u00d1\n\6\f\6\16\6\u00d4\13\6\3\6\3"+
		"\6\3\6\5\6\u00d9\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00e1\n\7\f\7\16\7\u00e4"+
		"\13\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00ec\n\7\f\7\16\7\u00ef\13\7\3\7\3"+
		"\7\3\7\5\7\u00f4\n\7\5\7\u00f6\n\7\3\b\3\b\5\b\u00fa\n\b\3\t\3\t\3\t\3"+
		"\t\7\t\u0100\n\t\f\t\16\t\u0103\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u010f\n\13\3\f\3\f\3\r\3\r\3\16\5\16\u0116\n\16\3\16"+
		"\3\16\3\17\5\17\u011b\n\17\3\17\5\17\u011e\n\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\5\22\u0128\n\22\3\22\3\22\3\22\3\22\3\22\5\22\u012f"+
		"\n\22\3\22\3\22\7\22\u0133\n\22\f\22\16\22\u0136\13\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u0141\n\23\3\23\3\23\3\23\3\23\3\24"+
		"\5\24\u0148\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\7\24\u0163\n\24\f\24\16\24\u0166\13\24\3\24\3\24\5\24\u016a\n\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0175\n\25\3\26\5\26\u0178"+
		"\n\26\3\26\3\26\5\26\u017c\n\26\3\26\3\26\5\26\u0180\n\26\3\26\3\26\5"+
		"\26\u0184\n\26\3\26\5\26\u0187\n\26\3\26\3\26\3\26\5\26\u018c\n\26\3\26"+
		"\3\26\3\26\3\26\3\26\7\26\u0193\n\26\f\26\16\26\u0196\13\26\5\26\u0198"+
		"\n\26\3\26\3\26\3\26\5\26\u019d\n\26\3\26\3\26\3\26\5\26\u01a2\n\26\3"+
		"\26\3\26\3\26\5\26\u01a7\n\26\3\26\3\26\5\26\u01ab\n\26\5\26\u01ad\n\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\7\26\u01bd\n\26\f\26\16\26\u01c0\13\26\3\26\3\26\5\26\u01c4\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u01cc\n\27\3\30\5\30\u01cf\n\30\3\30\3"+
		"\30\5\30\u01d3\n\30\3\30\3\30\5\30\u01d7\n\30\3\30\5\30\u01da\n\30\3\30"+
		"\5\30\u01dd\n\30\3\30\5\30\u01e0\n\30\3\30\3\30\5\30\u01e4\n\30\3\30\3"+
		"\30\3\30\3\30\3\30\5\30\u01eb\n\30\3\30\3\30\3\30\5\30\u01f0\n\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01fc\n\30\3\30\5\30"+
		"\u01ff\n\30\6\30\u0201\n\30\r\30\16\30\u0202\3\30\5\30\u0206\n\30\3\30"+
		"\3\30\3\30\3\30\7\30\u020c\n\30\f\30\16\30\u020f\13\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u0217\n\30\3\30\3\30\3\30\7\30\u021c\n\30\f\30\16"+
		"\30\u021f\13\30\3\30\3\30\5\30\u0223\n\30\3\30\3\30\3\31\5\31\u0228\n"+
		"\31\3\31\3\31\5\31\u022c\n\31\3\31\3\31\5\31\u0230\n\31\3\31\5\31\u0233"+
		"\n\31\3\31\5\31\u0236\n\31\3\31\5\31\u0239\n\31\3\31\3\31\5\31\u023d\n"+
		"\31\3\31\3\31\3\31\3\31\5\31\u0243\n\31\3\31\3\31\3\31\3\31\5\31\u0249"+
		"\n\31\3\31\3\31\3\31\5\31\u024e\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u026e\n\31\3\31\5\31"+
		"\u0271\n\31\6\31\u0273\n\31\r\31\16\31\u0274\3\31\5\31\u0278\n\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u027f\n\31\f\31\16\31\u0282\13\31\3\31\3\31"+
		"\5\31\u0286\n\31\3\31\3\31\3\31\7\31\u028b\n\31\f\31\16\31\u028e\13\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0296\n\31\3\31\3\31\3\31\7\31\u029b"+
		"\n\31\f\31\16\31\u029e\13\31\3\31\3\31\3\31\5\31\u02a3\n\31\3\31\3\31"+
		"\5\31\u02a7\n\31\3\31\3\31\3\32\5\32\u02ac\n\32\3\32\3\32\5\32\u02b0\n"+
		"\32\3\32\3\32\5\32\u02b4\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32"+
		"\u02bd\n\32\f\32\16\32\u02c0\13\32\5\32\u02c2\n\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u02ca\n\32\5\32\u02cc\n\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\7\32\u02d4\n\32\f\32\16\32\u02d7\13\32\5\32\u02d9\n\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u02e1\n\32\3\32\5\32\u02e4\n\32\6\32\u02e6\n\32"+
		"\r\32\16\32\u02e7\3\32\5\32\u02eb\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u02fa\n\32\f\32\16\32\u02fd\13"+
		"\32\3\32\3\32\5\32\u0301\n\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u0310\n\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u0318\n\35\3\35\5\35\u031b\n\35\6\35\u031d\n\35\r\35\16\35\u031e"+
		"\3\35\5\35\u0322\n\35\3\35\3\35\7\35\u0326\n\35\f\35\16\35\u0329\13\35"+
		"\3\35\3\35\5\35\u032d\n\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u0335\n"+
		"\36\3\36\5\36\u0338\n\36\3\36\3\36\5\36\u033c\n\36\3\36\3\36\3\36\3\37"+
		"\5\37\u0342\n\37\3\37\3\37\5\37\u0346\n\37\3\37\3\37\3\37\3\37\5\37\u034c"+
		"\n\37\3\37\3\37\3\37\5\37\u0351\n\37\3\37\3\37\3\37\3\37\5\37\u0357\n"+
		"\37\3\37\5\37\u035a\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0363"+
		"\n\37\f\37\16\37\u0366\13\37\3\37\3\37\5\37\u036a\n\37\3\37\3\37\3 \5"+
		" \u036f\n \3 \3 \3 \3 \3 \5 \u0376\n \3 \3 \3 \5 \u037b\n \3 \3 \3 \3"+
		" \5 \u0381\n \3 \5 \u0384\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u0390\n"+
		" \f \16 \u0393\13 \3 \3 \5 \u0397\n \3 \3 \3!\3!\3!\5!\u039e\n!\3!\3!"+
		"\3!\5!\u03a3\n!\3!\3!\3!\7!\u03a8\n!\f!\16!\u03ab\13!\3!\3!\3!\5!\u03b0"+
		"\n!\3\"\3\"\5\"\u03b4\n\"\3\"\3\"\3\"\3\"\3\"\7\"\u03bb\n\"\f\"\16\"\u03be"+
		"\13\"\3\"\3\"\5\"\u03c2\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\6\"\u03cf\n\"\r\"\16\"\u03d0\3\"\3\"\3\"\5\"\u03d6\n\"\3#\5#\u03d9"+
		"\n#\3#\3#\5#\u03dd\n#\3#\3#\3$\3$\3$\3$\3$\3$\5$\u03e7\n$\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\5%\u03f5\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0400"+
		"\n&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u040b\n(\f(\16(\u040e\13(\3(\3"+
		"(\3)\3)\3)\3)\3)\3)\7)\u0418\n)\f)\16)\u041b\13)\5)\u041d\n)\3)\3)\3*"+
		"\3*\3*\3*\3*\3*\5*\u0427\n*\3+\3+\3+\3+\3+\7+\u042e\n+\f+\16+\u0431\13"+
		"+\3+\3+\5+\u0435\n+\3,\3,\3,\3,\3,\3,\5,\u043d\n,\3-\3-\3-\3-\3-\3-\3"+
		"-\5-\u0446\n-\3.\3.\3.\5.\u044b\n.\3.\7.\u044e\n.\f.\16.\u0451\13.\3."+
		"\5.\u0454\n.\3/\3/\5/\u0458\n/\3/\3/\3/\5/\u045d\n/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0469\n\60\3\61\3\61\5\61\u046d\n"+
		"\61\3\61\3\61\3\61\5\61\u0472\n\61\3\61\3\61\5\61\u0476\n\61\3\61\3\61"+
		"\3\62\5\62\u047b\n\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0483\n\62\5"+
		"\62\u0485\n\62\3\62\3\62\3\62\5\62\u048a\n\62\3\62\3\62\5\62\u048e\n\62"+
		"\3\62\3\62\3\63\3\63\3\63\5\63\u0495\n\63\3\63\3\63\5\63\u0499\n\63\3"+
		"\63\3\63\3\64\3\64\3\64\3\64\3\64\5\64\u04a2\n\64\5\64\u04a4\n\64\3\64"+
		"\3\64\3\64\5\64\u04a9\n\64\3\64\3\64\5\64\u04ad\n\64\3\64\3\64\3\65\3"+
		"\65\3\65\3\65\3\65\5\65\u04b6\n\65\5\65\u04b8\n\65\3\65\3\65\3\65\5\65"+
		"\u04bd\n\65\3\65\3\65\5\65\u04c1\n\65\3\65\3\65\3\66\3\66\5\66\u04c7\n"+
		"\66\3\66\3\66\3\66\5\66\u04cc\n\66\3\66\3\66\5\66\u04d0\n\66\3\66\3\66"+
		"\3\67\3\67\5\67\u04d6\n\67\3\67\3\67\3\67\5\67\u04db\n\67\3\67\3\67\5"+
		"\67\u04df\n\67\3\67\3\67\38\38\38\58\u04e6\n8\38\38\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\59\u04fd\n9\39\39\39\39\39\39"+
		"\59\u0505\n9\39\39\39\39\39\39\59\u050d\n9\39\39\39\39\39\39\59\u0515"+
		"\n9\39\39\39\39\39\39\59\u051d\n9\39\39\39\39\39\39\59\u0525\n9\39\39"+
		"\39\39\39\39\59\u052d\n9\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\59\u0547\n9\39\59\u054a\n9\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\79"+
		"\u0567\n9\f9\169\u056a\139\39\59\u056d\n9\39\39\79\u0571\n9\f9\169\u0574"+
		"\139\39\59\u0577\n9\39\39\39\39\39\39\39\39\39\79\u0582\n9\f9\169\u0585"+
		"\139\39\59\u0588\n9\39\39\79\u058c\n9\f9\169\u058f\139\39\59\u0592\n9"+
		"\39\39\39\39\39\39\39\39\39\79\u059d\n9\f9\169\u05a0\139\39\59\u05a3\n"+
		"9\39\39\79\u05a7\n9\f9\169\u05aa\139\39\59\u05ad\n9\39\39\39\39\39\39"+
		"\39\39\39\79\u05b8\n9\f9\169\u05bb\139\39\59\u05be\n9\39\39\79\u05c2\n"+
		"9\f9\169\u05c5\139\39\59\u05c8\n9\39\39\39\39\39\39\39\39\39\79\u05d3"+
		"\n9\f9\169\u05d6\139\39\59\u05d9\n9\39\39\79\u05dd\n9\f9\169\u05e0\13"+
		"9\39\59\u05e3\n9\39\39\39\39\39\39\39\39\39\79\u05ee\n9\f9\169\u05f1\13"+
		"9\39\59\u05f4\n9\39\39\79\u05f8\n9\f9\169\u05fb\139\39\59\u05fe\n9\39"+
		"\39\39\39\39\39\39\39\39\39\39\59\u060b\n9\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\79\u0621\n9\f9\169\u0624\139\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u0652\n:\3"+
		":\3:\5:\u0656\n:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5"+
		":\u0669\n:\3:\3:\5:\u066d\n:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\7:\u068c\n:\f:\16:\u068f"+
		"\13:\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u06a3\n"+
		";\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u06af\n;\3;\3;\3;\3;\3;\3;\3;\3;\3"+
		";\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\7;\u06ca\n;\f;\16;\u06cd"+
		"\13;\3<\3<\3<\7<\u06d2\n<\f<\16<\u06d5\13<\3=\5=\u06d8\n=\3=\3=\3=\7="+
		"\u06dd\n=\f=\16=\u06e0\13=\3=\3=\5=\u06e4\n=\3=\3=\3=\3=\5=\u06ea\n=\3"+
		"=\3=\3=\7=\u06ef\n=\f=\16=\u06f2\13=\3=\3=\3=\3=\3=\3=\5=\u06fa\n=\3="+
		"\3=\3=\7=\u06ff\n=\f=\16=\u0702\13=\3=\3=\3=\3=\3=\3=\5=\u070a\n=\3=\3"+
		"=\3=\7=\u070f\n=\f=\16=\u0712\13=\3=\3=\3=\3=\3=\5=\u0719\n=\3>\3>\3>"+
		"\7>\u071e\n>\f>\16>\u0721\13>\3?\3?\3?\7?\u0726\n?\f?\16?\u0729\13?\3"+
		"?\3?\3?\3?\3@\3@\3@\7@\u0732\n@\f@\16@\u0735\13@\3A\5A\u0738\nA\3A\3A"+
		"\3A\7A\u073d\nA\fA\16A\u0740\13A\3A\3A\5A\u0744\nA\3A\3A\3A\3A\3B\3B\3"+
		"C\3C\3C\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"E\5E\u0792\nE\3F\3F\3G\3G\3H\3H\3I\3I\3I\2\5prtJ\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnp"+
		"rtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\2\26\3\2"+
		"\21\22\3\2\23\24\3\2\35 \4\2\23\23MN\3\2\u00a0\u00a1\4\2!!\\\\\3\2hi\3"+
		"\2jk\3\2qr\3\2{|\3\2}~\3\2\177\u0080\3\2\u0081\u0082\4\2\23\23\u0091\u0091"+
		"\4\2\24\24\u0092\u0092\4\2MM\u0093\u0093\3\2\u0094\u0095\3\2\u0096\u0097"+
		"\4\2\35\37\u0099\u0099\4\2MM\u009d\u009d\2\u08fb\2\u0092\3\2\2\2\4\u00aa"+
		"\3\2\2\2\6\u00b0\3\2\2\2\b\u00bd\3\2\2\2\n\u00c6\3\2\2\2\f\u00da\3\2\2"+
		"\2\16\u00f9\3\2\2\2\20\u00fb\3\2\2\2\22\u0106\3\2\2\2\24\u010e\3\2\2\2"+
		"\26\u0110\3\2\2\2\30\u0112\3\2\2\2\32\u0115\3\2\2\2\34\u011a\3\2\2\2\36"+
		"\u0122\3\2\2\2 \u0124\3\2\2\2\"\u0127\3\2\2\2$\u013c\3\2\2\2&\u0147\3"+
		"\2\2\2(\u0174\3\2\2\2*\u0177\3\2\2\2,\u01cb\3\2\2\2.\u01ce\3\2\2\2\60"+
		"\u0227\3\2\2\2\62\u02ab\3\2\2\2\64\u0304\3\2\2\2\66\u0307\3\2\2\28\u030a"+
		"\3\2\2\2:\u0330\3\2\2\2<\u0341\3\2\2\2>\u036e\3\2\2\2@\u039d\3\2\2\2B"+
		"\u03b1\3\2\2\2D\u03d8\3\2\2\2F\u03e6\3\2\2\2H\u03f4\3\2\2\2J\u03ff\3\2"+
		"\2\2L\u0401\3\2\2\2N\u0406\3\2\2\2P\u0411\3\2\2\2R\u0426\3\2\2\2T\u0428"+
		"\3\2\2\2V\u043c\3\2\2\2X\u043e\3\2\2\2Z\u0447\3\2\2\2\\\u0455\3\2\2\2"+
		"^\u0468\3\2\2\2`\u046a\3\2\2\2b\u047a\3\2\2\2d\u0491\3\2\2\2f\u049c\3"+
		"\2\2\2h\u04b0\3\2\2\2j\u04c4\3\2\2\2l\u04d3\3\2\2\2n\u04e5\3\2\2\2p\u060a"+
		"\3\2\2\2r\u0655\3\2\2\2t\u06ae\3\2\2\2v\u06ce\3\2\2\2x\u0718\3\2\2\2z"+
		"\u071a\3\2\2\2|\u0722\3\2\2\2~\u072e\3\2\2\2\u0080\u0737\3\2\2\2\u0082"+
		"\u0749\3\2\2\2\u0084\u074b\3\2\2\2\u0086\u074e\3\2\2\2\u0088\u0791\3\2"+
		"\2\2\u008a\u0793\3\2\2\2\u008c\u0795\3\2\2\2\u008e\u0797\3\2\2\2\u0090"+
		"\u0799\3\2\2\2\u0092\u0093\7\3\2\2\u0093\u0094\7\4\2\2\u0094\u0099\5\4"+
		"\3\2\u0095\u0096\7\5\2\2\u0096\u0098\5\4\3\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\6\2\2\u009d\3\3\2\2\2\u009e\u009f"+
		"\7\7\2\2\u009f\u00a0\7\b\2\2\u00a0\u00ab\7\u009d\2\2\u00a1\u00a2\7\t\2"+
		"\2\u00a2\u00a3\7\b\2\2\u00a3\u00ab\7\u009d\2\2\u00a4\u00a5\7\n\2\2\u00a5"+
		"\u00a6\7\b\2\2\u00a6\u00ab\7\u009d\2\2\u00a7\u00a8\7\13\2\2\u00a8\u00a9"+
		"\7\b\2\2\u00a9\u00ab\7\u009d\2\2\u00aa\u009e\3\2\2\2\u00aa\u00a1\3\2\2"+
		"\2\u00aa\u00a4\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\5\3\2\2\2\u00ac\u00ad"+
		"\7\f\2\2\u00ad\u00ae\5\u008cG\2\u00ae\u00af\7\r\2\2\u00af\u00b1\3\2\2"+
		"\2\u00b0\u00ac\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b5\3\2\2\2\u00b2\u00b4"+
		"\5$\23\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\5\b"+
		"\5\2\u00b9\u00bc\5\n\6\2\u00ba\u00bc\7\r\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00ba\3\2\2\2\u00bc\7\3\2\2\2\u00bd\u00c1\7\16\2\2\u00be\u00bf\5\u0088"+
		"E\2\u00bf\u00c0\7\b\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00be\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\u00a0\2\2\u00c4\u00c5"+
		"\7\r\2\2\u00c5\t\3\2\2\2\u00c6\u00c7\5Z.\2\u00c7\u00c9\b\6\1\2\u00c8\u00ca"+
		"\5\24\13\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2"+
		"\u00cb\u00d8\b\6\1\2\u00cc\u00cd\7\4\2\2\u00cd\u00d2\5\f\7\2\u00ce\u00cf"+
		"\7\5\2\2\u00cf\u00d1\5\f\7\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d5\u00d6\7\6\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d9\7\r\2\2\u00d8"+
		"\u00cc\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\13\3\2\2\2\u00da\u00db\5\u0088"+
		"E\2\u00db\u00f5\b\7\1\2\u00dc\u00f3\7\b\2\2\u00dd\u00de\6\7\2\2\u00de"+
		"\u00e2\7\4\2\2\u00df\u00e1\5\n\6\2\u00e0\u00df\3\2\2\2\u00e1\u00e4\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e5\u00f4\7\6\2\2\u00e6\u00f4\5\22\n\2\u00e7\u00e8\7"+
		"\17\2\2\u00e8\u00ed\5\22\n\2\u00e9\u00ea\7\5\2\2\u00ea\u00ec\5\22\n\2"+
		"\u00eb\u00e9\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\7\20\2\2"+
		"\u00f1\u00f4\3\2\2\2\u00f2\u00f4\5\16\b\2\u00f3\u00dd\3\2\2\2\u00f3\u00e6"+
		"\3\2\2\2\u00f3\u00e7\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5"+
		"\u00dc\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\r\3\2\2\2\u00f7\u00fa\5\24\13"+
		"\2\u00f8\u00fa\5\20\t\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa"+
		"\17\3\2\2\2\u00fb\u00fc\7\17\2\2\u00fc\u0101\5\16\b\2\u00fd\u00fe\7\5"+
		"\2\2\u00fe\u0100\5\16\b\2\u00ff\u00fd\3\2\2\2\u0100\u0103\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2"+
		"\2\2\u0104\u0105\7\20\2\2\u0105\21\3\2\2\2\u0106\u0107\5Z.\2\u0107\23"+
		"\3\2\2\2\u0108\u010f\5\26\f\2\u0109\u010f\5\32\16\2\u010a\u010f\5\34\17"+
		"\2\u010b\u010f\5\36\20\2\u010c\u010f\5\30\r\2\u010d\u010f\5 \21\2\u010e"+
		"\u0108\3\2\2\2\u010e\u0109\3\2\2\2\u010e\u010a\3\2\2\2\u010e\u010b\3\2"+
		"\2\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2\u010f\25\3\2\2\2\u0110\u0111"+
		"\5\u008cG\2\u0111\27\3\2\2\2\u0112\u0113\t\2\2\2\u0113\31\3\2\2\2\u0114"+
		"\u0116\t\3\2\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u0118\7\u009d\2\2\u0118\33\3\2\2\2\u0119\u011b\t\3\2\2\u011a"+
		"\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011e\7\u009d"+
		"\2\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0120\7\25\2\2\u0120\u0121\7\u009d\2\2\u0121\35\3\2\2\2\u0122\u0123\7"+
		"\u009f\2\2\u0123\37\3\2\2\2\u0124\u0125\7\26\2\2\u0125!\3\2\2\2\u0126"+
		"\u0128\5\2\2\2\u0127\u0126\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u012e\b\22\1\2\u012a\u012b\7\16\2\2\u012b\u012c\5\u008cG\2"+
		"\u012c\u012d\7\r\2\2\u012d\u012f\3\2\2\2\u012e\u012a\3\2\2\2\u012e\u012f"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0134\b\22\1\2\u0131\u0133\5$\23\2"+
		"\u0132\u0131\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135"+
		"\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138\5&\24\2\u0138"+
		"\u0139\b\22\1\2\u0139\u013a\3\2\2\2\u013a\u013b\b\22\1\2\u013b#\3\2\2"+
		"\2\u013c\u0140\7\27\2\2\u013d\u013e\5\u008cG\2\u013e\u013f\7\b\2\2\u013f"+
		"\u0141\3\2\2\2\u0140\u013d\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0143\7\u00a0\2\2\u0143\u0144\7\r\2\2\u0144\u0145\b\23\1\2"+
		"\u0145%\3\2\2\2\u0146\u0148\5n8\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148\u0149\3\2\2\2\u0149\u014a\b\24\1\2\u014a\u014b\7\30\2\2\u014b"+
		"\u014c\5\u0088E\2\u014c\u014d\b\24\1\2\u014d\u014e\b\24\1\2\u014e\u014f"+
		"\7\b\2\2\u014f\u0150\5\u008cG\2\u0150\u0151\3\2\2\2\u0151\u0152\7\31\2"+
		"\2\u0152\u0153\7\u00a0\2\2\u0153\u0154\3\2\2\2\u0154\u0169\b\24\1\2\u0155"+
		"\u0164\7\4\2\2\u0156\u0157\5B\"\2\u0157\u0158\b\24\1\2\u0158\u0163\3\2"+
		"\2\2\u0159\u015a\5&\24\2\u015a\u015b\b\24\1\2\u015b\u0163\3\2\2\2\u015c"+
		"\u015d\5(\25\2\u015d\u015e\b\24\1\2\u015e\u0163\3\2\2\2\u015f\u0160\5"+
		"b\62\2\u0160\u0161\b\24\1\2\u0161\u0163\3\2\2\2\u0162\u0156\3\2\2\2\u0162"+
		"\u0159\3\2\2\2\u0162\u015c\3\2\2\2\u0162\u015f\3\2\2\2\u0163\u0166\3\2"+
		"\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3\2\2\2\u0166"+
		"\u0164\3\2\2\2\u0167\u016a\7\6\2\2\u0168\u016a\7\r\2\2\u0169\u0155\3\2"+
		"\2\2\u0169\u0168\3\2\2\2\u016a\'\3\2\2\2\u016b\u016c\5*\26\2\u016c\u016d"+
		"\b\25\1\2\u016d\u0175\3\2\2\2\u016e\u016f\5<\37\2\u016f\u0170\b\25\1\2"+
		"\u0170\u0175\3\2\2\2\u0171\u0172\5> \2\u0172\u0173\b\25\1\2\u0173\u0175"+
		"\3\2\2\2\u0174\u016b\3\2\2\2\u0174\u016e\3\2\2\2\u0174\u0171\3\2\2\2\u0175"+
		")\3\2\2\2\u0176\u0178\5n8\2\u0177\u0176\3\2\2\2\u0177\u0178\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u017f\b\26\1\2\u017a\u017c\7\32\2\2\u017b\u017a\3"+
		"\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0180\7\33\2\2\u017e"+
		"\u0180\7\34\2\2\u017f\u017b\3\2\2\2\u017f\u017e\3\2\2\2\u0180\u0181\3"+
		"\2\2\2\u0181\u0183\b\26\1\2\u0182\u0184\t\4\2\2\u0183\u0182\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0187\5\u0088E\2\u0186\u0185"+
		"\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\b\26\1\2"+
		"\u0189\u018b\b\26\1\2\u018a\u018c\5N(\2\u018b\u018a\3\2\2\2\u018b\u018c"+
		"\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u0197\b\26\1\2\u018e\u018f\7!\2\2\u018f"+
		"\u0194\5\66\34\2\u0190\u0191\7\5\2\2\u0191\u0193\5\66\34\2\u0192\u0190"+
		"\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u018e\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u0199\3\2\2\2\u0199\u019c\b\26\1\2\u019a\u019b\7\b\2\2\u019b"+
		"\u019d\7\u00a0\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e"+
		"\3\2\2\2\u019e\u01ac\b\26\1\2\u019f\u01a2\7\17\2\2\u01a0\u01a2\7\"\2\2"+
		"\u01a1\u019f\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a6"+
		"\7\u009d\2\2\u01a4\u01a5\7\5\2\2\u01a5\u01a7\7\u009d\2\2\u01a6\u01a4\3"+
		"\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01ab\7\20\2\2\u01a9"+
		"\u01ab\7#\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2\2\2\u01ab\u01ad\3\2"+
		"\2\2\u01ac\u01a1\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"\u01c3\b\26\1\2\u01af\u01be\7\4\2\2\u01b0\u01b1\5B\"\2\u01b1\u01b2\b\26"+
		"\1\2\u01b2\u01bd\3\2\2\2\u01b3\u01b4\5\62\32\2\u01b4\u01b5\b\26\1\2\u01b5"+
		"\u01bd\3\2\2\2\u01b6\u01b7\5,\27\2\u01b7\u01b8\b\26\1\2\u01b8\u01bd\3"+
		"\2\2\2\u01b9\u01ba\5b\62\2\u01ba\u01bb\b\26\1\2\u01bb\u01bd\3\2\2\2\u01bc"+
		"\u01b0\3\2\2\2\u01bc\u01b3\3\2\2\2\u01bc\u01b6\3\2\2\2\u01bc\u01b9\3\2"+
		"\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"\u01c1\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c4\7\6\2\2\u01c2\u01c4\7\r"+
		"\2\2\u01c3\u01af\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4+\3\2\2\2\u01c5\u01c6"+
		"\5.\30\2\u01c6\u01c7\b\27\1\2\u01c7\u01cc\3\2\2\2\u01c8\u01c9\5\60\31"+
		"\2\u01c9\u01ca\b\27\1\2\u01ca\u01cc\3\2\2\2\u01cb\u01c5\3\2\2\2\u01cb"+
		"\u01c8\3\2\2\2\u01cc-\3\2\2\2\u01cd\u01cf\5n8\2\u01ce\u01cd\3\2\2\2\u01ce"+
		"\u01cf\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d2\b\30\1\2\u01d1\u01d3\7"+
		"$\2\2\u01d2\u01d1\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4"+
		"\u01d7\7\16\2\2\u01d5\u01d7\7%\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d5\3\2"+
		"\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01da\7&\2\2\u01d9"+
		"\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc\3\2\2\2\u01db\u01dd\7\'"+
		"\2\2\u01dc\u01db\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01df\3\2\2\2\u01de"+
		"\u01e0\7(\2\2\u01df\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\3\2"+
		"\2\2\u01e1\u01e3\7)\2\2\u01e2\u01e4\t\4\2\2\u01e3\u01e2\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\5\u0088E\2\u01e6\u01e7"+
		"\b\30\1\2\u01e7\u01e8\7\b\2\2\u01e8\u01ea\5V,\2\u01e9\u01eb\5:\36\2\u01ea"+
		"\u01e9\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ef\b\30"+
		"\1\2\u01ed\u01ee\7\31\2\2\u01ee\u01f0\7\u00a0\2\2\u01ef\u01ed\3\2\2\2"+
		"\u01ef\u01f0\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u0205\b\30\1\2\u01f2\u0200"+
		"\7\4\2\2\u01f3\u01fc\7*\2\2\u01f4\u01fc\7+\2\2\u01f5\u01fc\7,\2\2\u01f6"+
		"\u01fc\7-\2\2\u01f7\u01fc\7.\2\2\u01f8\u01fc\7/\2\2\u01f9\u01fc\7\60\2"+
		"\2\u01fa\u01fc\7\61\2\2\u01fb\u01f3\3\2\2\2\u01fb\u01f4\3\2\2\2\u01fb"+
		"\u01f5\3\2\2\2\u01fb\u01f6\3\2\2\2\u01fb\u01f7\3\2\2\2\u01fb\u01f8\3\2"+
		"\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fc\u01fe\3\2\2\2\u01fd"+
		"\u01ff\7\5\2\2\u01fe\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0201\3\2"+
		"\2\2\u0200\u01fb\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0200\3\2\2\2\u0202"+
		"\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0206\7\6\2\2\u0205\u01f2\3\2"+
		"\2\2\u0205\u0206\3\2\2\2\u0206\u0222\3\2\2\2\u0207\u020d\7\4\2\2\u0208"+
		"\u0209\5B\"\2\u0209\u020a\b\30\1\2\u020a\u020c\3\2\2\2\u020b\u0208\3\2"+
		"\2\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e"+
		"\u0216\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u0211\5l\67\2\u0211\u0212\b\30"+
		"\1\2\u0212\u0217\3\2\2\2\u0213\u0214\5j\66\2\u0214\u0215\b\30\1\2\u0215"+
		"\u0217\3\2\2\2\u0216\u0210\3\2\2\2\u0216\u0213\3\2\2\2\u0216\u0217\3\2"+
		"\2\2\u0217\u021d\3\2\2\2\u0218\u0219\5B\"\2\u0219\u021a\b\30\1\2\u021a"+
		"\u021c\3\2\2\2\u021b\u0218\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u021b\3\2"+
		"\2\2\u021d\u021e\3\2\2\2\u021e\u0220\3\2\2\2\u021f\u021d\3\2\2\2\u0220"+
		"\u0223\7\6\2\2\u0221\u0223\7\r\2\2\u0222\u0207\3\2\2\2\u0222\u0221\3\2"+
		"\2\2\u0223\u0224\3\2\2\2\u0224\u0225\b\30\1\2\u0225/\3\2\2\2\u0226\u0228"+
		"\5n8\2\u0227\u0226\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u0229\3\2\2\2\u0229"+
		"\u022b\b\31\1\2\u022a\u022c\7$\2\2\u022b\u022a\3\2\2\2\u022b\u022c\3\2"+
		"\2\2\u022c\u022f\3\2\2\2\u022d\u0230\7\16\2\2\u022e\u0230\7%\2\2\u022f"+
		"\u022d\3\2\2\2\u022f\u022e\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0232\3\2"+
		"\2\2\u0231\u0233\7&\2\2\u0232\u0231\3\2\2\2\u0232\u0233\3\2\2\2\u0233"+
		"\u0235\3\2\2\2\u0234\u0236\7\'\2\2\u0235\u0234\3\2\2\2\u0235\u0236\3\2"+
		"\2\2\u0236\u0238\3\2\2\2\u0237\u0239\7(\2\2\u0238\u0237\3\2\2\2\u0238"+
		"\u0239\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023c\7\62\2\2\u023b\u023d\t"+
		"\4\2\2\u023c\u023b\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e\3\2\2\2\u023e"+
		"\u023f\5\u0088E\2\u023f\u0242\b\31\1\2\u0240\u0241\7\63\2\2\u0241\u0243"+
		"\5\u0088E\2\u0242\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0244\3\2\2"+
		"\2\u0244\u0245\b\31\1\2\u0245\u0246\7\b\2\2\u0246\u0248\5V,\2\u0247\u0249"+
		"\5:\36\2\u0248\u0247\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a\3\2\2\2\u024a"+
		"\u024d\b\31\1\2\u024b\u024c\7\31\2\2\u024c\u024e\7\u00a0\2\2\u024d\u024b"+
		"\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0277\b\31\1\2"+
		"\u0250\u0272\7\4\2\2\u0251\u026e\7\64\2\2\u0252\u026e\7*\2\2\u0253\u026e"+
		"\7\65\2\2\u0254\u026e\7\66\2\2\u0255\u026e\7\67\2\2\u0256\u026e\78\2\2"+
		"\u0257\u026e\79\2\2\u0258\u026e\7:\2\2\u0259\u026e\7;\2\2\u025a\u026e"+
		"\7<\2\2\u025b\u026e\7=\2\2\u025c\u026e\7>\2\2\u025d\u026e\7?\2\2\u025e"+
		"\u026e\7@\2\2\u025f\u026e\7A\2\2\u0260\u026e\7B\2\2\u0261\u026e\7C\2\2"+
		"\u0262\u026e\7D\2\2\u0263\u026e\7E\2\2\u0264\u026e\7F\2\2\u0265\u026e"+
		"\7,\2\2\u0266\u026e\7-\2\2\u0267\u026e\7.\2\2\u0268\u026e\7/\2\2\u0269"+
		"\u026e\7G\2\2\u026a\u026e\7H\2\2\u026b\u026e\7\60\2\2\u026c\u026e\7\61"+
		"\2\2\u026d\u0251\3\2\2\2\u026d\u0252\3\2\2\2\u026d\u0253\3\2\2\2\u026d"+
		"\u0254\3\2\2\2\u026d\u0255\3\2\2\2\u026d\u0256\3\2\2\2\u026d\u0257\3\2"+
		"\2\2\u026d\u0258\3\2\2\2\u026d\u0259\3\2\2\2\u026d\u025a\3\2\2\2\u026d"+
		"\u025b\3\2\2\2\u026d\u025c\3\2\2\2\u026d\u025d\3\2\2\2\u026d\u025e\3\2"+
		"\2\2\u026d\u025f\3\2\2\2\u026d\u0260\3\2\2\2\u026d\u0261\3\2\2\2\u026d"+
		"\u0262\3\2\2\2\u026d\u0263\3\2\2\2\u026d\u0264\3\2\2\2\u026d\u0265\3\2"+
		"\2\2\u026d\u0266\3\2\2\2\u026d\u0267\3\2\2\2\u026d\u0268\3\2\2\2\u026d"+
		"\u0269\3\2\2\2\u026d\u026a\3\2\2\2\u026d\u026b\3\2\2\2\u026d\u026c\3\2"+
		"\2\2\u026e\u0270\3\2\2\2\u026f\u0271\7\5\2\2\u0270\u026f\3\2\2\2\u0270"+
		"\u0271\3\2\2\2\u0271\u0273\3\2\2\2\u0272\u026d\3\2\2\2\u0273\u0274\3\2"+
		"\2\2\u0274\u0272\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0276\3\2\2\2\u0276"+
		"\u0278\7\6\2\2\u0277\u0250\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u02a6\3\2"+
		"\2\2\u0279\u0285\7\4\2\2\u027a\u027b\7I\2\2\u027b\u0280\5\u0088E\2\u027c"+
		"\u027d\7\5\2\2\u027d\u027f\5\u0088E\2\u027e\u027c\3\2\2\2\u027f\u0282"+
		"\3\2\2\2\u0280\u027e\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0283\3\2\2\2\u0282"+
		"\u0280\3\2\2\2\u0283\u0284\7\r\2\2\u0284\u0286\3\2\2\2\u0285\u027a\3\2"+
		"\2\2\u0285\u0286\3\2\2\2\u0286\u028c\3\2\2\2\u0287\u0288\5B\"\2\u0288"+
		"\u0289\b\31\1\2\u0289\u028b\3\2\2\2\u028a\u0287\3\2\2\2\u028b\u028e\3"+
		"\2\2\2\u028c\u028a\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u0295\3\2\2\2\u028e"+
		"\u028c\3\2\2\2\u028f\u0290\5l\67\2\u0290\u0291\b\31\1\2\u0291\u0296\3"+
		"\2\2\2\u0292\u0293\5j\66\2\u0293\u0294\b\31\1\2\u0294\u0296\3\2\2\2\u0295"+
		"\u028f\3\2\2\2\u0295\u0292\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u029c\3\2"+
		"\2\2\u0297\u0298\5B\"\2\u0298\u0299\b\31\1\2\u0299\u029b\3\2\2\2\u029a"+
		"\u0297\3\2\2\2\u029b\u029e\3\2\2\2\u029c\u029a\3\2\2\2\u029c\u029d\3\2"+
		"\2\2\u029d\u02a2\3\2\2\2\u029e\u029c\3\2\2\2\u029f\u02a0\5d\63\2\u02a0"+
		"\u02a1\b\31\1\2\u02a1\u02a3\3\2\2\2\u02a2\u029f\3\2\2\2\u02a2\u02a3\3"+
		"\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02a7\7\6\2\2\u02a5\u02a7\7\r\2\2\u02a6"+
		"\u0279\3\2\2\2\u02a6\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9\b\31"+
		"\1\2\u02a9\61\3\2\2\2\u02aa\u02ac\5n8\2\u02ab\u02aa\3\2\2\2\u02ab\u02ac"+
		"\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02af\b\32\1\2\u02ae\u02b0\7$\2\2\u02af"+
		"\u02ae\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b3\7J"+
		"\2\2\u02b2\u02b4\5N(\2\u02b3\u02b2\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b5"+
		"\3\2\2\2\u02b5\u02b6\b\32\1\2\u02b6\u02b7\5\u0088E\2\u02b7\u02b8\b\32"+
		"\1\2\u02b8\u02c1\7\"\2\2\u02b9\u02be\58\35\2\u02ba\u02bb\7\5\2\2\u02bb"+
		"\u02bd\58\35\2\u02bc\u02ba\3\2\2\2\u02bd\u02c0\3\2\2\2\u02be\u02bc\3\2"+
		"\2\2\u02be\u02bf\3\2\2\2\u02bf\u02c2\3\2\2\2\u02c0\u02be\3\2\2\2\u02c1"+
		"\u02b9\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c4\7#"+
		"\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02cb\b\32\1\2\u02c6\u02c7\7\b\2\2\u02c7"+
		"\u02c9\5V,\2\u02c8\u02ca\5:\36\2\u02c9\u02c8\3\2\2\2\u02c9\u02ca\3\2\2"+
		"\2\u02ca\u02cc\3\2\2\2\u02cb\u02c6\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd"+
		"\3\2\2\2\u02cd\u02ce\b\32\1\2\u02ce\u02d8\b\32\1\2\u02cf\u02d0\7K\2\2"+
		"\u02d0\u02d5\5\64\33\2\u02d1\u02d2\7\5\2\2\u02d2\u02d4\5\64\33\2\u02d3"+
		"\u02d1\3\2\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d5\u02d6\3\2"+
		"\2\2\u02d6\u02d9\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d8\u02cf\3\2\2\2\u02d8"+
		"\u02d9\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02ea\b\32\1\2\u02db\u02e5\7"+
		"\4\2\2\u02dc\u02e1\7,\2\2\u02dd\u02e1\7-\2\2\u02de\u02e1\7.\2\2\u02df"+
		"\u02e1\7/\2\2\u02e0\u02dc\3\2\2\2\u02e0\u02dd\3\2\2\2\u02e0\u02de\3\2"+
		"\2\2\u02e0\u02df\3\2\2\2\u02e1\u02e3\3\2\2\2\u02e2\u02e4\7\5\2\2\u02e3"+
		"\u02e2\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e6\3\2\2\2\u02e5\u02e0\3\2"+
		"\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8"+
		"\u02e9\3\2\2\2\u02e9\u02eb\7\6\2\2\u02ea\u02db\3\2\2\2\u02ea\u02eb\3\2"+
		"\2\2\u02eb\u0300\3\2\2\2\u02ec\u02fb\7\4\2\2\u02ed\u02ee\5B\"\2\u02ee"+
		"\u02ef\b\32\1\2\u02ef\u02fa\3\2\2\2\u02f0\u02f1\5f\64\2\u02f1\u02f2\b"+
		"\32\1\2\u02f2\u02fa\3\2\2\2\u02f3\u02f4\5`\61\2\u02f4\u02f5\b\32\1\2\u02f5"+
		"\u02fa\3\2\2\2\u02f6\u02f7\5h\65\2\u02f7\u02f8\b\32\1\2\u02f8\u02fa\3"+
		"\2\2\2\u02f9\u02ed\3\2\2\2\u02f9\u02f0\3\2\2\2\u02f9\u02f3\3\2\2\2\u02f9"+
		"\u02f6\3\2\2\2\u02fa\u02fd\3\2\2\2\u02fb\u02f9\3\2\2\2\u02fb\u02fc\3\2"+
		"\2\2\u02fc\u02fe\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fe\u0301\7\6\2\2\u02ff"+
		"\u0301\7\r\2\2\u0300\u02ec\3\2\2\2\u0300\u02ff\3\2\2\2\u0301\u0302\3\2"+
		"\2\2\u0302\u0303\b\32\1\2\u0303\63\3\2\2\2\u0304\u0305\5T+\2\u0305\u0306"+
		"\b\33\1\2\u0306\65\3\2\2\2\u0307\u0308\5T+\2\u0308\u0309\b\34\1\2\u0309"+
		"\67\3\2\2\2\u030a\u030b\5\u0088E\2\u030b\u030c\b\35\1\2\u030c\u030d\7"+
		"\b\2\2\u030d\u030f\5V,\2\u030e\u0310\5:\36\2\u030f\u030e\3\2\2\2\u030f"+
		"\u0310\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0321\b\35\1\2\u0312\u031c\7"+
		"\4\2\2\u0313\u0318\7,\2\2\u0314\u0318\7-\2\2\u0315\u0318\7.\2\2\u0316"+
		"\u0318\7/\2\2\u0317\u0313\3\2\2\2\u0317\u0314\3\2\2\2\u0317\u0315\3\2"+
		"\2\2\u0317\u0316\3\2\2\2\u0318\u031a\3\2\2\2\u0319\u031b\7\5\2\2\u031a"+
		"\u0319\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u031d\3\2\2\2\u031c\u0317\3\2"+
		"\2\2\u031d\u031e\3\2\2\2\u031e\u031c\3\2\2\2\u031e\u031f\3\2\2\2\u031f"+
		"\u0320\3\2\2\2\u0320\u0322\7\6\2\2\u0321\u0312\3\2\2\2\u0321\u0322\3\2"+
		"\2\2\u0322\u032c\3\2\2\2\u0323\u0327\7\4\2\2\u0324\u0326\5B\"\2\u0325"+
		"\u0324\3\2\2\2\u0326\u0329\3\2\2\2\u0327\u0325\3\2\2\2\u0327\u0328\3\2"+
		"\2\2\u0328\u032a\3\2\2\2\u0329\u0327\3\2\2\2\u032a\u032b\b\35\1\2\u032b"+
		"\u032d\7\6\2\2\u032c\u0323\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u032e\3\2"+
		"\2\2\u032e\u032f\b\35\1\2\u032f9\3\2\2\2\u0330\u0337\7\17\2\2\u0331\u0334"+
		"\5\u0090I\2\u0332\u0333\7L\2\2\u0333\u0335\5\u008eH\2\u0334\u0332\3\2"+
		"\2\2\u0334\u0335\3\2\2\2\u0335\u0338\3\2\2\2\u0336\u0338\t\5\2\2\u0337"+
		"\u0331\3\2\2\2\u0337\u0336\3\2\2\2\u0338\u033b\3\2\2\2\u0339\u033c\7O"+
		"\2\2\u033a\u033c\7P\2\2\u033b\u0339\3\2\2\2\u033b\u033a\3\2\2\2\u033b"+
		"\u033c\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033e\7\20\2\2\u033e\u033f\b"+
		"\36\1\2\u033f;\3\2\2\2\u0340\u0342\5n8\2\u0341\u0340\3\2\2\2\u0341\u0342"+
		"\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0345\b\37\1\2\u0344\u0346\7Q\2\2\u0345"+
		"\u0344\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0348\7R"+
		"\2\2\u0348\u0349\5\u0088E\2\u0349\u034b\b\37\1\2\u034a\u034c\5N(\2\u034b"+
		"\u034a\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034d\3\2\2\2\u034d\u0350\b\37"+
		"\1\2\u034e\u034f\7\b\2\2\u034f\u0351\7\u00a0\2\2\u0350\u034e\3\2\2\2\u0350"+
		"\u0351\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0359\b\37\1\2\u0353\u0356\7"+
		"\4\2\2\u0354\u0357\7S\2\2\u0355\u0357\7T\2\2\u0356\u0354\3\2\2\2\u0356"+
		"\u0355\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035a\7\6"+
		"\2\2\u0359\u0353\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u0369\3\2\2\2\u035b"+
		"\u0364\7\4\2\2\u035c\u035d\5B\"\2\u035d\u035e\b\37\1\2\u035e\u0363\3\2"+
		"\2\2\u035f\u0360\5b\62\2\u0360\u0361\b\37\1\2\u0361\u0363\3\2\2\2\u0362"+
		"\u035c\3\2\2\2\u0362\u035f\3\2\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2"+
		"\2\2\u0364\u0365\3\2\2\2\u0365\u0367\3\2\2\2\u0366\u0364\3\2\2\2\u0367"+
		"\u036a\7\6\2\2\u0368\u036a\7\r\2\2\u0369\u035b\3\2\2\2\u0369\u0368\3\2"+
		"\2\2\u036a\u036b\3\2\2\2\u036b\u036c\b\37\1\2\u036c=\3\2\2\2\u036d\u036f"+
		"\5n8\2\u036e\u036d\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0370\3\2\2\2\u0370"+
		"\u0371\b \1\2\u0371\u0372\7U\2\2\u0372\u0373\5\u0088E\2\u0373\u0375\b"+
		" \1\2\u0374\u0376\5N(\2\u0375\u0374\3\2\2\2\u0375\u0376\3\2\2\2\u0376"+
		"\u0377\3\2\2\2\u0377\u037a\b \1\2\u0378\u0379\7\b\2\2\u0379\u037b\7\u00a0"+
		"\2\2\u037a\u0378\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037c\3\2\2\2\u037c"+
		"\u0383\b \1\2\u037d\u0380\7\4\2\2\u037e\u0381\7S\2\2\u037f\u0381\7T\2"+
		"\2\u0380\u037e\3\2\2\2\u0380\u037f\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0382"+
		"\3\2\2\2\u0382\u0384\7\6\2\2\u0383\u037d\3\2\2\2\u0383\u0384\3\2\2\2\u0384"+
		"\u0396\3\2\2\2\u0385\u0391\7\4\2\2\u0386\u0387\5B\"\2\u0387\u0388\b \1"+
		"\2\u0388\u0390\3\2\2\2\u0389\u038a\5@!\2\u038a\u038b\b \1\2\u038b\u0390"+
		"\3\2\2\2\u038c\u038d\5b\62\2\u038d\u038e\b \1\2\u038e\u0390\3\2\2\2\u038f"+
		"\u0386\3\2\2\2\u038f\u0389\3\2\2\2\u038f\u038c\3\2\2\2\u0390\u0393\3\2"+
		"\2\2\u0391\u038f\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u0394\3\2\2\2\u0393"+
		"\u0391\3\2\2\2\u0394\u0397\7\6\2\2\u0395\u0397\7\r\2\2\u0396\u0385\3\2"+
		"\2\2\u0396\u0395\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u0399\b \1\2\u0399"+
		"?\3\2\2\2\u039a\u039b\7V\2\2\u039b\u039e\5\u0088E\2\u039c\u039e\5\u0088"+
		"E\2\u039d\u039a\3\2\2\2\u039d\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039f"+
		"\u03a2\b!\1\2\u03a0\u03a1\7\31\2\2\u03a1\u03a3\7\u009d\2\2\u03a2\u03a0"+
		"\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a4\3\2\2\2\u03a4\u03af\b!\1\2\u03a5"+
		"\u03a9\7\4\2\2\u03a6\u03a8\5B\"\2\u03a7\u03a6\3\2\2\2\u03a8\u03ab\3\2"+
		"\2\2\u03a9\u03a7\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ac\3\2\2\2\u03ab"+
		"\u03a9\3\2\2\2\u03ac\u03ad\b!\1\2\u03ad\u03b0\7\6\2\2\u03ae\u03b0\7\r"+
		"\2\2\u03af\u03a5\3\2\2\2\u03af\u03ae\3\2\2\2\u03b0A\3\2\2\2\u03b1\u03b3"+
		"\7W\2\2\u03b2\u03b4\7\u00a0\2\2\u03b3\u03b2\3\2\2\2\u03b3\u03b4\3\2\2"+
		"\2\u03b4\u03b5\3\2\2\2\u03b5\u03c1\b\"\1\2\u03b6\u03b7\7\"\2\2\u03b7\u03bc"+
		"\5D#\2\u03b8\u03b9\7\5\2\2\u03b9\u03bb\5D#\2\u03ba\u03b8\3\2\2\2\u03bb"+
		"\u03be\3\2\2\2\u03bc\u03ba\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd\u03bf\3\2"+
		"\2\2\u03be\u03bc\3\2\2\2\u03bf\u03c0\7#\2\2\u03c0\u03c2\3\2\2\2\u03c1"+
		"\u03b6\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03d5\b\""+
		"\1\2\u03c4\u03ce\7\4\2\2\u03c5\u03c6\5B\"\2\u03c6\u03c7\b\"\1\2\u03c7"+
		"\u03cf\3\2\2\2\u03c8\u03c9\5F$\2\u03c9\u03ca\b\"\1\2\u03ca\u03cf\3\2\2"+
		"\2\u03cb\u03cc\5L\'\2\u03cc\u03cd\b\"\1\2\u03cd\u03cf\3\2\2\2\u03ce\u03c5"+
		"\3\2\2\2\u03ce\u03c8\3\2\2\2\u03ce\u03cb\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0"+
		"\u03ce\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d3\7\6"+
		"\2\2\u03d3\u03d6\3\2\2\2\u03d4\u03d6\7\r\2\2\u03d5\u03c4\3\2\2\2\u03d5"+
		"\u03d4\3\2\2\2\u03d6C\3\2\2\2\u03d7\u03d9\7\u00a0\2\2\u03d8\u03d7\3\2"+
		"\2\2\u03d8\u03d9\3\2\2\2\u03d9\u03da\3\2\2\2\u03da\u03dc\7\31\2\2\u03db"+
		"\u03dd\t\6\2\2\u03dc\u03db\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03de\3\2"+
		"\2\2\u03de\u03df\b#\1\2\u03dfE\3\2\2\2\u03e0\u03e1\5B\"\2\u03e1\u03e2"+
		"\b$\1\2\u03e2\u03e7\3\2\2\2\u03e3\u03e4\5H%\2\u03e4\u03e5\b$\1\2\u03e5"+
		"\u03e7\3\2\2\2\u03e6\u03e0\3\2\2\2\u03e6\u03e3\3\2\2\2\u03e7G\3\2\2\2"+
		"\u03e8\u03e9\5J&\2\u03e9\u03ea\b%\1\2\u03ea\u03f5\3\2\2\2\u03eb\u03ec"+
		"\5(\25\2\u03ec\u03ed\b%\1\2\u03ed\u03f5\3\2\2\2\u03ee\u03ef\5&\24\2\u03ef"+
		"\u03f0\b%\1\2\u03f0\u03f5\3\2\2\2\u03f1\u03f2\5@!\2\u03f2\u03f3\b%\1\2"+
		"\u03f3\u03f5\3\2\2\2\u03f4\u03e8\3\2\2\2\u03f4\u03eb\3\2\2\2\u03f4\u03ee"+
		"\3\2\2\2\u03f4\u03f1\3\2\2\2\u03f5I\3\2\2\2\u03f6\u03f7\5\62\32\2\u03f7"+
		"\u03f8\b&\1\2\u03f8\u0400\3\2\2\2\u03f9\u03fa\58\35\2\u03fa\u03fb\b&\1"+
		"\2\u03fb\u0400\3\2\2\2\u03fc\u03fd\5,\27\2\u03fd\u03fe\b&\1\2\u03fe\u0400"+
		"\3\2\2\2\u03ff\u03f6\3\2\2\2\u03ff\u03f9\3\2\2\2\u03ff\u03fc\3\2\2\2\u0400"+
		"K\3\2\2\2\u0401\u0402\7X\2\2\u0402\u0403\5Z.\2\u0403\u0404\b\'\1\2\u0404"+
		"\u0405\7\r\2\2\u0405M\3\2\2\2\u0406\u0407\7Y\2\2\u0407\u040c\5P)\2\u0408"+
		"\u0409\7\5\2\2\u0409\u040b\5P)\2\u040a\u0408\3\2\2\2\u040b\u040e\3\2\2"+
		"\2\u040c\u040a\3\2\2\2\u040c\u040d\3\2\2\2\u040d\u040f\3\2\2\2\u040e\u040c"+
		"\3\2\2\2\u040f\u0410\7Z\2\2\u0410O\3\2\2\2\u0411\u0412\5\u0088E\2\u0412"+
		"\u041c\b)\1\2\u0413\u0414\7!\2\2\u0414\u0419\5T+\2\u0415\u0416\7[\2\2"+
		"\u0416\u0418\5T+\2\u0417\u0415\3\2\2\2\u0418\u041b\3\2\2\2\u0419\u0417"+
		"\3\2\2\2\u0419\u041a\3\2\2\2\u041a\u041d\3\2\2\2\u041b\u0419\3\2\2\2\u041c"+
		"\u0413\3\2\2\2\u041c\u041d\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u041f\b)"+
		"\1\2\u041fQ\3\2\2\2\u0420\u0421\5T+\2\u0421\u0422\b*\1\2\u0422\u0427\3"+
		"\2\2\2\u0423\u0424\5X-\2\u0424\u0425\b*\1\2\u0425\u0427\3\2\2\2\u0426"+
		"\u0420\3\2\2\2\u0426\u0423\3\2\2\2\u0427S\3\2\2\2\u0428\u0434\5Z.\2\u0429"+
		"\u042a\7Y\2\2\u042a\u042f\5R*\2\u042b\u042c\7\5\2\2\u042c\u042e\5R*\2"+
		"\u042d\u042b\3\2\2\2\u042e\u0431\3\2\2\2\u042f\u042d\3\2\2\2\u042f\u0430"+
		"\3\2\2\2\u0430\u0432\3\2\2\2\u0431\u042f\3\2\2\2\u0432\u0433\7Z\2\2\u0433"+
		"\u0435\3\2\2\2\u0434\u0429\3\2\2\2\u0434\u0435\3\2\2\2\u0435U\3\2\2\2"+
		"\u0436\u0437\5^\60\2\u0437\u0438\b,\1\2\u0438\u043d\3\2\2\2\u0439\u043a"+
		"\5T+\2\u043a\u043b\b,\1\2\u043b\u043d\3\2\2\2\u043c\u0436\3\2\2\2\u043c"+
		"\u0439\3\2\2\2\u043dW\3\2\2\2\u043e\u043f\7N\2\2\u043f\u0445\b-\1\2\u0440"+
		"\u0441\t\7\2\2\u0441\u0442\b-\1\2\u0442\u0443\5T+\2\u0443\u0444\b-\1\2"+
		"\u0444\u0446\3\2\2\2\u0445\u0440\3\2\2\2\u0445\u0446\3\2\2\2\u0446Y\3"+
		"\2\2\2\u0447\u044a\5\u0088E\2\u0448\u0449\7\25\2\2\u0449\u044b\7\u009d"+
		"\2\2\u044a\u0448\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u0453\3\2\2\2\u044c"+
		"\u044e\5\\/\2\u044d\u044c\3\2\2\2\u044e\u0451\3\2\2\2\u044f\u044d\3\2"+
		"\2\2\u044f\u0450\3\2\2\2\u0450\u0452\3\2\2\2\u0451\u044f\3\2\2\2\u0452"+
		"\u0454\5\\/\2\u0453\u044f\3\2\2\2\u0453\u0454\3\2\2\2\u0454[\3\2\2\2\u0455"+
		"\u0457\7]\2\2\u0456\u0458\7^\2\2\u0457\u0456\3\2\2\2\u0457\u0458\3\2\2"+
		"\2\u0458\u0459\3\2\2\2\u0459\u045c\5\u0088E\2\u045a\u045b\7\25\2\2\u045b"+
		"\u045d\7\u009d\2\2\u045c\u045a\3\2\2\2\u045c\u045d\3\2\2\2\u045d]\3\2"+
		"\2\2\u045e\u045f\7_\2\2\u045f\u0469\b\60\1\2\u0460\u0461\7`\2\2\u0461"+
		"\u0469\b\60\1\2\u0462\u0463\7a\2\2\u0463\u0469\b\60\1\2\u0464\u0465\7"+
		"b\2\2\u0465\u0469\b\60\1\2\u0466\u0467\7c\2\2\u0467\u0469\b\60\1\2\u0468"+
		"\u045e\3\2\2\2\u0468\u0460\3\2\2\2\u0468\u0462\3\2\2\2\u0468\u0464\3\2"+
		"\2\2\u0468\u0466\3\2\2\2\u0469_\3\2\2\2\u046a\u046c\7d\2\2\u046b\u046d"+
		"\5\u008cG\2\u046c\u046b\3\2\2\2\u046c\u046d\3\2\2\2\u046d\u046e\3\2\2"+
		"\2\u046e\u0475\b\61\1\2\u046f\u0471\7\b\2\2\u0470\u0472\5r:\2\u0471\u0470"+
		"\3\2\2\2\u0471\u0472\3\2\2\2\u0472\u0473\3\2\2\2\u0473\u0476\7\r\2\2\u0474"+
		"\u0476\7\r\2\2\u0475\u046f\3\2\2\2\u0475\u0474\3\2\2\2\u0476\u0477\3\2"+
		"\2\2\u0477\u0478\b\61\1\2\u0478a\3\2\2\2\u0479\u047b\7e\2\2\u047a\u0479"+
		"\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u047c\3\2\2\2\u047c\u047d\b\62\1\2"+
		"\u047d\u0484\7f\2\2\u047e\u0482\5\u008cG\2\u047f\u0480\7\"\2\2\u0480\u0481"+
		"\7\u009f\2\2\u0481\u0483\7#\2\2\u0482\u047f\3\2\2\2\u0482\u0483\3\2\2"+
		"\2\u0483\u0485\3\2\2\2\u0484\u047e\3\2\2\2\u0484\u0485\3\2\2\2\u0485\u0486"+
		"\3\2\2\2\u0486\u048d\b\62\1\2\u0487\u0489\7\b\2\2\u0488\u048a\5p9\2\u0489"+
		"\u0488\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u048b\3\2\2\2\u048b\u048e\7\r"+
		"\2\2\u048c\u048e\7\r\2\2\u048d\u0487\3\2\2\2\u048d\u048c\3\2\2\2\u048e"+
		"\u048f\3\2\2\2\u048f\u0490\b\62\1\2\u0490c\3\2\2\2\u0491\u0498\7g\2\2"+
		"\u0492\u0494\7\b\2\2\u0493\u0495\5p9\2\u0494\u0493\3\2\2\2\u0494\u0495"+
		"\3\2\2\2\u0495\u0496\3\2\2\2\u0496\u0499\7\r\2\2\u0497\u0499\7\r\2\2\u0498"+
		"\u0492\3\2\2\2\u0498\u0497\3\2\2\2\u0499\u049a\3\2\2\2\u049a\u049b\b\63"+
		"\1\2\u049be\3\2\2\2\u049c\u04a3\t\b\2\2\u049d\u04a1\5\u008cG\2\u049e\u049f"+
		"\7\"\2\2\u049f\u04a0\7\u009f\2\2\u04a0\u04a2\7#\2\2\u04a1\u049e\3\2\2"+
		"\2\u04a1\u04a2\3\2\2\2\u04a2\u04a4\3\2\2\2\u04a3\u049d\3\2\2\2\u04a3\u04a4"+
		"\3\2\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04ac\b\64\1\2\u04a6\u04a8\7\b\2\2"+
		"\u04a7\u04a9\5p9\2\u04a8\u04a7\3\2\2\2\u04a8\u04a9\3\2\2\2\u04a9\u04aa"+
		"\3\2\2\2\u04aa\u04ad\7\r\2\2\u04ab\u04ad\7\r\2\2\u04ac\u04a6\3\2\2\2\u04ac"+
		"\u04ab\3\2\2\2\u04ad\u04ae\3\2\2\2\u04ae\u04af\b\64\1\2\u04afg\3\2\2\2"+
		"\u04b0\u04b7\t\t\2\2\u04b1\u04b5\5\u008cG\2\u04b2\u04b3\7\"\2\2\u04b3"+
		"\u04b4\7\u009f\2\2\u04b4\u04b6\7#\2\2\u04b5\u04b2\3\2\2\2\u04b5\u04b6"+
		"\3\2\2\2\u04b6\u04b8\3\2\2\2\u04b7\u04b1\3\2\2\2\u04b7\u04b8\3\2\2\2\u04b8"+
		"\u04b9\3\2\2\2\u04b9\u04c0\b\65\1\2\u04ba\u04bc\7\b\2\2\u04bb\u04bd\5"+
		"p9\2\u04bc\u04bb\3\2\2\2\u04bc\u04bd\3\2\2\2\u04bd\u04be\3\2\2\2\u04be"+
		"\u04c1\7\r\2\2\u04bf\u04c1\7\r\2\2\u04c0\u04ba\3\2\2\2\u04c0\u04bf\3\2"+
		"\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c3\b\65\1\2\u04c3i\3\2\2\2\u04c4\u04c6"+
		"\7l\2\2\u04c5\u04c7\5\u008cG\2\u04c6\u04c5\3\2\2\2\u04c6\u04c7\3\2\2\2"+
		"\u04c7\u04c8\3\2\2\2\u04c8\u04cf\b\66\1\2\u04c9\u04cb\7\b\2\2\u04ca\u04cc"+
		"\5r:\2\u04cb\u04ca\3\2\2\2\u04cb\u04cc\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd"+
		"\u04d0\7\r\2\2\u04ce\u04d0\7\r\2\2\u04cf\u04c9\3\2\2\2\u04cf\u04ce\3\2"+
		"\2\2\u04d0\u04d1\3\2\2\2\u04d1\u04d2\b\66\1\2\u04d2k\3\2\2\2\u04d3\u04d5"+
		"\7m\2\2\u04d4\u04d6\5\u008cG\2\u04d5\u04d4\3\2\2\2\u04d5\u04d6\3\2\2\2"+
		"\u04d6\u04d7\3\2\2\2\u04d7\u04de\b\67\1\2\u04d8\u04da\7\b\2\2\u04d9\u04db"+
		"\5r:\2\u04da\u04d9\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u04dc\3\2\2\2\u04dc"+
		"\u04df\7\r\2\2\u04dd\u04df\7\r\2\2\u04de\u04d8\3\2\2\2\u04de\u04dd\3\2"+
		"\2\2\u04df\u04e0\3\2\2\2\u04e0\u04e1\b\67\1\2\u04e1m\3\2\2\2\u04e2\u04e6"+
		"\7n\2\2\u04e3\u04e6\7o\2\2\u04e4\u04e6\7p\2\2\u04e5\u04e2\3\2\2\2\u04e5"+
		"\u04e3\3\2\2\2\u04e5\u04e4\3\2\2\2\u04e6\u04e7\3\2\2\2\u04e7\u04e8\b8"+
		"\1\2\u04e8o\3\2\2\2\u04e9\u04ea\b9\1\2\u04ea\u04eb\7 \2\2\u04eb\u04ec"+
		"\5r:\2\u04ec\u04ed\b9\1\2\u04ed\u060b\3\2\2\2\u04ee\u04ef\7\36\2\2\u04ef"+
		"\u04f0\5r:\2\u04f0\u04f1\b9\1\2\u04f1\u060b\3\2\2\2\u04f2\u04f3\7\35\2"+
		"\2\u04f3\u04f4\5r:\2\u04f4\u04f5\b9\1\2\u04f5\u060b\3\2\2\2\u04f6\u04f7"+
		"\7\37\2\2\u04f7\u04f8\5r:\2\u04f8\u04f9\b9\1\2\u04f9\u060b\3\2\2\2\u04fa"+
		"\u04fc\5r:\2\u04fb\u04fd\t\n\2\2\u04fc\u04fb\3\2\2\2\u04fc\u04fd\3\2\2"+
		"\2\u04fd\u04fe\3\2\2\2\u04fe\u04ff\7s\2\2\u04ff\u0500\5r:\2\u0500\u0501"+
		"\b9\1\2\u0501\u060b\3\2\2\2\u0502\u0504\5r:\2\u0503\u0505\t\n\2\2\u0504"+
		"\u0503\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u0506\3\2\2\2\u0506\u0507\7\31"+
		"\2\2\u0507\u0508\5r:\2\u0508\u0509\b9\1\2\u0509\u060b\3\2\2\2\u050a\u050c"+
		"\5t;\2\u050b\u050d\t\n\2\2\u050c\u050b\3\2\2\2\u050c\u050d\3\2\2\2\u050d"+
		"\u050e\3\2\2\2\u050e\u050f\7\31\2\2\u050f\u0510\5t;\2\u0510\u0511\b9\1"+
		"\2\u0511\u060b\3\2\2\2\u0512\u0514\5t;\2\u0513\u0515\t\n\2\2\u0514\u0513"+
		"\3\2\2\2\u0514\u0515\3\2\2\2\u0515\u0516\3\2\2\2\u0516\u0517\7Y\2\2\u0517"+
		"\u0518\5t;\2\u0518\u0519\b9\1\2\u0519\u060b\3\2\2\2\u051a\u051c\5t;\2"+
		"\u051b\u051d\t\n\2\2\u051c\u051b\3\2\2\2\u051c\u051d\3\2\2\2\u051d\u051e"+
		"\3\2\2\2\u051e\u051f\7t\2\2\u051f\u0520\5t;\2\u0520\u0521\b9\1\2\u0521"+
		"\u060b\3\2\2\2\u0522\u0524\5t;\2\u0523\u0525\t\n\2\2\u0524\u0523\3\2\2"+
		"\2\u0524\u0525\3\2\2\2\u0525\u0526\3\2\2\2\u0526\u0527\7Z\2\2\u0527\u0528"+
		"\5t;\2\u0528\u0529\b9\1\2\u0529\u060b\3\2\2\2\u052a\u052c\5t;\2\u052b"+
		"\u052d\t\n\2\2\u052c\u052b\3\2\2\2\u052c\u052d\3\2\2\2\u052d\u052e\3\2"+
		"\2\2\u052e\u052f\7u\2\2\u052f\u0530\5t;\2\u0530\u0531\b9\1\2\u0531\u060b"+
		"\3\2\2\2\u0532\u0533\7v\2\2\u0533\u0534\5v<\2\u0534\u0535\7w\2\2\u0535"+
		"\u0536\5t;\2\u0536\u0537\3\2\2\2\u0537\u0538\b9\1\2\u0538\u060b\3\2\2"+
		"\2\u0539\u053a\7\65\2\2\u053a\u053b\7\17\2\2\u053b\u053c\5\u0082B\2\u053c"+
		"\u053d\7\20\2\2\u053d\u053e\b9\1\2\u053e\u060b\3\2\2\2\u053f\u0540\7x"+
		"\2\2\u0540\u0541\7\17\2\2\u0541\u0542\5\u0082B\2\u0542\u0543\7\b\2\2\u0543"+
		"\u0544\5r:\2\u0544\u0549\7y\2\2\u0545\u0547\7\35\2\2\u0546\u0545\3\2\2"+
		"\2\u0546\u0547\3\2\2\2\u0547\u054a\3\2\2\2\u0548\u054a\7\36\2\2\u0549"+
		"\u0546\3\2\2\2\u0549\u0548\3\2\2\2\u054a\u054b\3\2\2\2\u054b\u054c\5r"+
		":\2\u054c\u054d\7\20\2\2\u054d\u054e\b9\1\2\u054e\u060b\3\2\2\2\u054f"+
		"\u0550\7z\2\2\u0550\u0551\7\17\2\2\u0551\u0552\5\u0082B\2\u0552\u0553"+
		"\7\5\2\2\u0553\u0554\5\u0082B\2\u0554\u0555\7\5\2\2\u0555\u0556\5\u0082"+
		"B\2\u0556\u0557\7\5\2\2\u0557\u0558\5\u0082B\2\u0558\u0559\7\20\2\2\u0559"+
		"\u055a\b9\1\2\u055a\u060b\3\2\2\2\u055b\u055c\t\n\2\2\u055c\u055d\5p9"+
		"\20\u055d\u055e\b9\1\2\u055e\u060b\3\2\2\2\u055f\u0560\b9\1\2\u0560\u0561"+
		"\7\u0083\2\2\u0561\u0576\5v<\2\u0562\u056c\7w\2\2\u0563\u056d\5p9\2\u0564"+
		"\u0568\7\4\2\2\u0565\u0567\5p9\2\u0566\u0565\3\2\2\2\u0567\u056a\3\2\2"+
		"\2\u0568\u0566\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u056b\3\2\2\2\u056a\u0568"+
		"\3\2\2\2\u056b\u056d\7\6\2\2\u056c\u0563\3\2\2\2\u056c\u0564\3\2\2\2\u056d"+
		"\u0577\3\2\2\2\u056e\u0572\7\4\2\2\u056f\u0571\5p9\2\u0570\u056f\3\2\2"+
		"\2\u0571\u0574\3\2\2\2\u0572\u0570\3\2\2\2\u0572\u0573\3\2\2\2\u0573\u0575"+
		"\3\2\2\2\u0574\u0572\3\2\2\2\u0575\u0577\7\6\2\2\u0576\u0562\3\2\2\2\u0576"+
		"\u056e\3\2\2\2\u0577\u0578\3\2\2\2\u0578\u0579\b9\1\2\u0579\u060b\3\2"+
		"\2\2\u057a\u057b\b9\1\2\u057b\u057c\7\37\2\2\u057c\u0591\5v<\2\u057d\u0587"+
		"\7w\2\2\u057e\u0588\5p9\2\u057f\u0583\7\4\2\2\u0580\u0582\5p9\2\u0581"+
		"\u0580\3\2\2\2\u0582\u0585\3\2\2\2\u0583\u0581\3\2\2\2\u0583\u0584\3\2"+
		"\2\2\u0584\u0586\3\2\2\2\u0585\u0583\3\2\2\2\u0586\u0588\7\6\2\2\u0587"+
		"\u057e\3\2\2\2\u0587\u057f\3\2\2\2\u0588\u0592\3\2\2\2\u0589\u058d\7\4"+
		"\2\2\u058a\u058c\5p9\2\u058b\u058a\3\2\2\2\u058c\u058f\3\2\2\2\u058d\u058b"+
		"\3\2\2\2\u058d\u058e\3\2\2\2\u058e\u0590\3\2\2\2\u058f\u058d\3\2\2\2\u0590"+
		"\u0592\7\6\2\2\u0591\u057d\3\2\2\2\u0591\u0589\3\2\2\2\u0592\u0593\3\2"+
		"\2\2\u0593\u0594\b9\1\2\u0594\u060b\3\2\2\2\u0595\u0596\b9\1\2\u0596\u0597"+
		"\7 \2\2\u0597\u05ac\5v<\2\u0598\u05a2\7w\2\2\u0599\u05a3\5p9\2\u059a\u059e"+
		"\7\4\2\2\u059b\u059d\5p9\2\u059c\u059b\3\2\2\2\u059d\u05a0\3\2\2\2\u059e"+
		"\u059c\3\2\2\2\u059e\u059f\3\2\2\2\u059f\u05a1\3\2\2\2\u05a0\u059e\3\2"+
		"\2\2\u05a1\u05a3\7\6\2\2\u05a2\u0599\3\2\2\2\u05a2\u059a\3\2\2\2\u05a3"+
		"\u05ad\3\2\2\2\u05a4\u05a8\7\4\2\2\u05a5\u05a7\5p9\2\u05a6\u05a5\3\2\2"+
		"\2\u05a7\u05aa\3\2\2\2\u05a8\u05a6\3\2\2\2\u05a8\u05a9\3\2\2\2\u05a9\u05ab"+
		"\3\2\2\2\u05aa\u05a8\3\2\2\2\u05ab\u05ad\7\6\2\2\u05ac\u0598\3\2\2\2\u05ac"+
		"\u05a4\3\2\2\2\u05ad\u05ae\3\2\2\2\u05ae\u05af\b9\1\2\u05af\u060b\3\2"+
		"\2\2\u05b0\u05b1\b9\1\2\u05b1\u05b2\7\35\2\2\u05b2\u05c7\5v<\2\u05b3\u05bd"+
		"\7w\2\2\u05b4\u05be\5p9\2\u05b5\u05b9\7\4\2\2\u05b6\u05b8\5p9\2\u05b7"+
		"\u05b6\3\2\2\2\u05b8\u05bb\3\2\2\2\u05b9\u05b7\3\2\2\2\u05b9\u05ba\3\2"+
		"\2\2\u05ba\u05bc\3\2\2\2\u05bb\u05b9\3\2\2\2\u05bc\u05be\7\6\2\2\u05bd"+
		"\u05b4\3\2\2\2\u05bd\u05b5\3\2\2\2\u05be\u05c8\3\2\2\2\u05bf\u05c3\7\4"+
		"\2\2\u05c0\u05c2\5p9\2\u05c1\u05c0\3\2\2\2\u05c2\u05c5\3\2\2\2\u05c3\u05c1"+
		"\3\2\2\2\u05c3\u05c4\3\2\2\2\u05c4\u05c6\3\2\2\2\u05c5\u05c3\3\2\2\2\u05c6"+
		"\u05c8\7\6\2\2\u05c7\u05b3\3\2\2\2\u05c7\u05bf\3\2\2\2\u05c8\u05c9\3\2"+
		"\2\2\u05c9\u05ca\b9\1\2\u05ca\u060b\3\2\2\2\u05cb\u05cc\b9\1\2\u05cc\u05cd"+
		"\7\36\2\2\u05cd\u05e2\5v<\2\u05ce\u05d8\7w\2\2\u05cf\u05d9\5p9\2\u05d0"+
		"\u05d4\7\4\2\2\u05d1\u05d3\5p9\2\u05d2\u05d1\3\2\2\2\u05d3\u05d6\3\2\2"+
		"\2\u05d4\u05d2\3\2\2\2\u05d4\u05d5\3\2\2\2\u05d5\u05d7\3\2\2\2\u05d6\u05d4"+
		"\3\2\2\2\u05d7\u05d9\7\6\2\2\u05d8\u05cf\3\2\2\2\u05d8\u05d0\3\2\2\2\u05d9"+
		"\u05e3\3\2\2\2\u05da\u05de\7\4\2\2\u05db\u05dd\5p9\2\u05dc\u05db\3\2\2"+
		"\2\u05dd\u05e0\3\2\2\2\u05de\u05dc\3\2\2\2\u05de\u05df\3\2\2\2\u05df\u05e1"+
		"\3\2\2\2\u05e0\u05de\3\2\2\2\u05e1\u05e3\7\6\2\2\u05e2\u05ce\3\2\2\2\u05e2"+
		"\u05da\3\2\2\2\u05e3\u05e4\3\2\2\2\u05e4\u05e5\b9\1\2\u05e5\u060b\3\2"+
		"\2\2\u05e6\u05e7\b9\1\2\u05e7\u05e8\7\u0084\2\2\u05e8\u05fd\5z>\2\u05e9"+
		"\u05f3\7w\2\2\u05ea\u05f4\5p9\2\u05eb\u05ef\7\4\2\2\u05ec\u05ee\5p9\2"+
		"\u05ed\u05ec\3\2\2\2\u05ee\u05f1\3\2\2\2\u05ef\u05ed\3\2\2\2\u05ef\u05f0"+
		"\3\2\2\2\u05f0\u05f2\3\2\2\2\u05f1\u05ef\3\2\2\2\u05f2\u05f4\7\6\2\2\u05f3"+
		"\u05ea\3\2\2\2\u05f3\u05eb\3\2\2\2\u05f4\u05fe\3\2\2\2\u05f5\u05f9\7\4"+
		"\2\2\u05f6\u05f8\5p9\2\u05f7\u05f6\3\2\2\2\u05f8\u05fb\3\2\2\2\u05f9\u05f7"+
		"\3\2\2\2\u05f9\u05fa\3\2\2\2\u05fa\u05fc\3\2\2\2\u05fb\u05f9\3\2\2\2\u05fc"+
		"\u05fe\7\6\2\2\u05fd\u05e9\3\2\2\2\u05fd\u05f5\3\2\2\2\u05fe\u05ff\3\2"+
		"\2\2\u05ff\u0600\b9\1\2\u0600\u060b\3\2\2\2\u0601\u0602\7\21\2\2\u0602"+
		"\u060b\b9\1\2\u0603\u0604\7\22\2\2\u0604\u060b\b9\1\2\u0605\u0606\7\""+
		"\2\2\u0606\u0607\5p9\2\u0607\u0608\7#\2\2\u0608\u0609\b9\1\2\u0609\u060b"+
		"\3\2\2\2\u060a\u04e9\3\2\2\2\u060a\u04ee\3\2\2\2\u060a\u04f2\3\2\2\2\u060a"+
		"\u04f6\3\2\2\2\u060a\u04fa\3\2\2\2\u060a\u0502\3\2\2\2\u060a\u050a\3\2"+
		"\2\2\u060a\u0512\3\2\2\2\u060a\u051a\3\2\2\2\u060a\u0522\3\2\2\2\u060a"+
		"\u052a\3\2\2\2\u060a\u0532\3\2\2\2\u060a\u0539\3\2\2\2\u060a\u053f\3\2"+
		"\2\2\u060a\u054f\3\2\2\2\u060a\u055b\3\2\2\2\u060a\u055f\3\2\2\2\u060a"+
		"\u057a\3\2\2\2\u060a\u0595\3\2\2\2\u060a\u05b0\3\2\2\2\u060a\u05cb\3\2"+
		"\2\2\u060a\u05e6\3\2\2\2\u060a\u0601\3\2\2\2\u060a\u0603\3\2\2\2\u060a"+
		"\u0605\3\2\2\2\u060b\u0622\3\2\2\2\u060c\u060d\f\17\2\2\u060d\u060e\t"+
		"\13\2\2\u060e\u060f\5p9\20\u060f\u0610\b9\1\2\u0610\u0621\3\2\2\2\u0611"+
		"\u0612\f\16\2\2\u0612\u0613\t\f\2\2\u0613\u0614\5p9\17\u0614\u0615\b9"+
		"\1\2\u0615\u0621\3\2\2\2\u0616\u0617\f\r\2\2\u0617\u0618\t\r\2\2\u0618"+
		"\u0619\5p9\r\u0619\u061a\b9\1\2\u061a\u0621\3\2\2\2\u061b\u061c\f\f\2"+
		"\2\u061c\u061d\t\16\2\2\u061d\u061e\5p9\f\u061e\u061f\b9\1\2\u061f\u0621"+
		"\3\2\2\2\u0620\u060c\3\2\2\2\u0620\u0611\3\2\2\2\u0620\u0616\3\2\2\2\u0620"+
		"\u061b\3\2\2\2\u0621\u0624\3\2\2\2\u0622\u0620\3\2\2\2\u0622\u0623\3\2"+
		"\2\2\u0623q\3\2\2\2\u0624\u0622\3\2\2\2\u0625\u0626\b:\1\2\u0626\u0627"+
		"\7\u0085\2\2\u0627\u0628\5r:\26\u0628\u0629\b:\1\2\u0629\u0656\3\2\2\2"+
		"\u062a\u062b\7\u0086\2\2\u062b\u062c\5r:\25\u062c\u062d\b:\1\2\u062d\u0656"+
		"\3\2\2\2\u062e\u062f\7M\2\2\u062f\u0630\5r:\24\u0630\u0631\b:\1\2\u0631"+
		"\u0656\3\2\2\2\u0632\u0633\b:\1\2\u0633\u0634\7\4\2\2\u0634\u0635\5~@"+
		"\2\u0635\u0636\7w\2\2\u0636\u0637\5p9\2\u0637\u0638\7\6\2\2\u0638\u0639"+
		"\b:\1\2\u0639\u0656\3\2\2\2\u063a\u063b\7\u008a\2\2\u063b\u063c\5p9\2"+
		"\u063c\u063d\7\u008b\2\2\u063d\u063e\5r:\2\u063e\u063f\7\u008c\2\2\u063f"+
		"\u0640\5r:\t\u0640\u0641\b:\1\2\u0641\u0656\3\2\2\2\u0642\u0643\7\u008d"+
		"\2\2\u0643\u0656\b:\1\2\u0644\u0645\7\u008e\2\2\u0645\u0656\b:\1\2\u0646"+
		"\u0647\7\u008f\2\2\u0647\u0656\b:\1\2\u0648\u0649\7\u0090\2\2\u0649\u0656"+
		"\b:\1\2\u064a\u064b\7\"\2\2\u064b\u064c\5r:\2\u064c\u064d\7#\2\2\u064d"+
		"\u064e\b:\1\2\u064e\u0656\3\2\2\2\u064f\u0652\5\u008aF\2\u0650\u0652\5"+
		"T+\2\u0651\u064f\3\2\2\2\u0651\u0650\3\2\2\2\u0652\u0653\3\2\2\2\u0653"+
		"\u0654\b:\1\2\u0654\u0656\3\2\2\2\u0655\u0625\3\2\2\2\u0655\u062a\3\2"+
		"\2\2\u0655\u062e\3\2\2\2\u0655\u0632\3\2\2\2\u0655\u063a\3\2\2\2\u0655"+
		"\u0642\3\2\2\2\u0655\u0644\3\2\2\2\u0655\u0646\3\2\2\2\u0655\u0648\3\2"+
		"\2\2\u0655\u064a\3\2\2\2\u0655\u0651\3\2\2\2\u0656\u068d\3\2\2\2\u0657"+
		"\u0658\f\23\2\2\u0658\u0659\7\25\2\2\u0659\u065a\5r:\24\u065a\u065b\b"+
		":\1\2\u065b\u068c\3\2\2\2\u065c\u065d\f\21\2\2\u065d\u065e\7\u0087\2\2"+
		"\u065e\u065f\5r:\22\u065f\u0660\b:\1\2\u0660\u068c\3\2\2\2\u0661\u0662"+
		"\f\20\2\2\u0662\u0663\7\u0088\2\2\u0663\u0664\5r:\21\u0664\u0665\b:\1"+
		"\2\u0665\u068c\3\2\2\2\u0666\u0668\f\17\2\2\u0667\u0669\5\u0086D\2\u0668"+
		"\u0667\3\2\2\2\u0668\u0669\3\2\2\2\u0669\u066a\3\2\2\2\u066a\u066c\7y"+
		"\2\2\u066b\u066d\5\u0086D\2\u066c\u066b\3\2\2\2\u066c\u066d\3\2\2\2\u066d"+
		"\u066e\3\2\2\2\u066e\u066f\5r:\17\u066f\u0670\b:\1\2\u0670\u068c\3\2\2"+
		"\2\u0671\u0672\f\16\2\2\u0672\u0673\7[\2\2\u0673\u0674\5r:\17\u0674\u0675"+
		"\b:\1\2\u0675\u068c\3\2\2\2\u0676\u0677\f\r\2\2\u0677\u0678\7\23\2\2\u0678"+
		"\u0679\5r:\16\u0679\u067a\b:\1\2\u067a\u068c\3\2\2\2\u067b\u067c\f\f\2"+
		"\2\u067c\u067d\7\24\2\2\u067d\u067e\5r:\r\u067e\u067f\b:\1\2\u067f\u068c"+
		"\3\2\2\2\u0680\u0681\f\13\2\2\u0681\u0682\7\u0089\2\2\u0682\u0683\5r:"+
		"\f\u0683\u0684\b:\1\2\u0684\u068c\3\2\2\2\u0685\u0686\f\22\2\2\u0686\u0687"+
		"\7\17\2\2\u0687\u0688\5r:\2\u0688\u0689\7\20\2\2\u0689\u068a\b:\1\2\u068a"+
		"\u068c\3\2\2\2\u068b\u0657\3\2\2\2\u068b\u065c\3\2\2\2\u068b\u0661\3\2"+
		"\2\2\u068b\u0666\3\2\2\2\u068b\u0671\3\2\2\2\u068b\u0676\3\2\2\2\u068b"+
		"\u067b\3\2\2\2\u068b\u0680\3\2\2\2\u068b\u0685\3\2\2\2\u068c\u068f\3\2"+
		"\2\2\u068d\u068b\3\2\2\2\u068d\u068e\3\2\2\2\u068es\3\2\2\2\u068f\u068d"+
		"\3\2\2\2\u0690\u0691\b;\1\2\u0691\u0692\7\u008a\2\2\u0692\u0693\5p9\2"+
		"\u0693\u0694\7\u008b\2\2\u0694\u0695\5t;\2\u0695\u0696\7\u008c\2\2\u0696"+
		"\u0697\5t;\r\u0697\u0698\b;\1\2\u0698\u06af\3\2\2\2\u0699\u069a\7v\2\2"+
		"\u069a\u069b\5r:\2\u069b\u069c\b;\1\2\u069c\u06af\3\2\2\2\u069d\u069e"+
		"\7\63\2\2\u069e\u069f\5r:\2\u069f\u06a0\b;\1\2\u06a0\u06af\3\2\2\2\u06a1"+
		"\u06a3\7\24\2\2\u06a2\u06a1\3\2\2\2\u06a2\u06a3\3\2\2\2\u06a3\u06a4\3"+
		"\2\2\2\u06a4\u06a5\7\u009d\2\2\u06a5\u06af\b;\1\2\u06a6\u06a7\7\"\2\2"+
		"\u06a7\u06a8\5t;\2\u06a8\u06a9\7#\2\2\u06a9\u06aa\b;\1\2\u06aa\u06af\3"+
		"\2\2\2\u06ab\u06ac\5r:\2\u06ac\u06ad\b;\1\2\u06ad\u06af\3\2\2\2\u06ae"+
		"\u0690\3\2\2\2\u06ae\u0699\3\2\2\2\u06ae\u069d\3\2\2\2\u06ae\u06a2\3\2"+
		"\2\2\u06ae\u06a6\3\2\2\2\u06ae\u06ab\3\2\2\2\u06af\u06cb\3\2\2\2\u06b0"+
		"\u06b1\f\n\2\2\u06b1\u06b2\t\17\2\2\u06b2\u06b3\5t;\13\u06b3\u06b4\b;"+
		"\1\2\u06b4\u06ca\3\2\2\2\u06b5\u06b6\f\t\2\2\u06b6\u06b7\t\20\2\2\u06b7"+
		"\u06b8\5t;\n\u06b8\u06b9\b;\1\2\u06b9\u06ca\3\2\2\2\u06ba\u06bb\f\b\2"+
		"\2\u06bb\u06bc\t\21\2\2\u06bc\u06bd\5t;\t\u06bd\u06be\b;\1\2\u06be\u06ca"+
		"\3\2\2\2\u06bf\u06c0\f\7\2\2\u06c0\u06c1\t\22\2\2\u06c1\u06c2\5t;\b\u06c2"+
		"\u06c3\b;\1\2\u06c3\u06ca\3\2\2\2\u06c4\u06c5\f\6\2\2\u06c5\u06c6\t\23"+
		"\2\2\u06c6\u06c7\5t;\7\u06c7\u06c8\b;\1\2\u06c8\u06ca\3\2\2\2\u06c9\u06b0"+
		"\3\2\2\2\u06c9\u06b5\3\2\2\2\u06c9\u06ba\3\2\2\2\u06c9\u06bf\3\2\2\2\u06c9"+
		"\u06c4\3\2\2\2\u06ca\u06cd\3\2\2\2\u06cb\u06c9\3\2\2\2\u06cb\u06cc\3\2"+
		"\2\2\u06ccu\3\2\2\2\u06cd\u06cb\3\2\2\2\u06ce\u06d3\5x=\2\u06cf\u06d0"+
		"\7\5\2\2\u06d0\u06d2\5x=\2\u06d1\u06cf\3\2\2\2\u06d2\u06d5\3\2\2\2\u06d3"+
		"\u06d1\3\2\2\2\u06d3\u06d4\3\2\2\2\u06d4w\3\2\2\2\u06d5\u06d3\3\2\2\2"+
		"\u06d6\u06d8\7\u0098\2\2\u06d7\u06d6\3\2\2\2\u06d7\u06d8\3\2\2\2\u06d8"+
		"\u06d9\3\2\2\2\u06d9\u06de\5\u0084C\2\u06da\u06db\7\5\2\2\u06db\u06dd"+
		"\5\u0084C\2\u06dc\u06da\3\2\2\2\u06dd\u06e0\3\2\2\2\u06de\u06dc\3\2\2"+
		"\2\u06de\u06df\3\2\2\2\u06df\u06e1\3\2\2\2\u06e0\u06de\3\2\2\2\u06e1\u06e3"+
		"\7\b\2\2\u06e2\u06e4\7\35\2\2\u06e3\u06e2\3\2\2\2\u06e3\u06e4\3\2\2\2"+
		"\u06e4\u06e5\3\2\2\2\u06e5\u06e6\5r:\2\u06e6\u06e7\b=\1\2\u06e7\u0719"+
		"\3\2\2\2\u06e8\u06ea\7\u0098\2\2\u06e9\u06e8\3\2\2\2\u06e9\u06ea\3\2\2"+
		"\2\u06ea\u06eb\3\2\2\2\u06eb\u06f0\5\u0084C\2\u06ec\u06ed\7\5\2\2\u06ed"+
		"\u06ef\5\u0084C\2\u06ee\u06ec\3\2\2\2\u06ef\u06f2\3\2\2\2\u06f0\u06ee"+
		"\3\2\2\2\u06f0\u06f1\3\2\2\2\u06f1\u06f3\3\2\2\2\u06f2\u06f0\3\2\2\2\u06f3"+
		"\u06f4\7\b\2\2\u06f4\u06f5\7\36\2\2\u06f5\u06f6\5r:\2\u06f6\u06f7\b=\1"+
		"\2\u06f7\u0719\3\2\2\2\u06f8\u06fa\7\u0098\2\2\u06f9\u06f8\3\2\2\2\u06f9"+
		"\u06fa\3\2\2\2\u06fa\u06fb\3\2\2\2\u06fb\u0700\5\u0084C\2\u06fc\u06fd"+
		"\7\5\2\2\u06fd\u06ff\5\u0084C\2\u06fe\u06fc\3\2\2\2\u06ff\u0702\3\2\2"+
		"\2\u0700\u06fe\3\2\2\2\u0700\u0701\3\2\2\2\u0701\u0703\3\2\2\2\u0702\u0700"+
		"\3\2\2\2\u0703\u0704\7\b\2\2\u0704\u0705\7\37\2\2\u0705\u0706\5r:\2\u0706"+
		"\u0707\b=\1\2\u0707\u0719\3\2\2\2\u0708\u070a\7\u0098\2\2\u0709\u0708"+
		"\3\2\2\2\u0709\u070a\3\2\2\2\u070a\u070b\3\2\2\2\u070b\u0710\5\u0084C"+
		"\2\u070c\u070d\7\5\2\2\u070d\u070f\5\u0084C\2\u070e\u070c\3\2\2\2\u070f"+
		"\u0712\3\2\2\2\u0710\u070e\3\2\2\2\u0710\u0711\3\2\2\2\u0711\u0713\3\2"+
		"\2\2\u0712\u0710\3\2\2\2\u0713\u0714\7\b\2\2\u0714\u0715\7\u0099\2\2\u0715"+
		"\u0716\5r:\2\u0716\u0717\b=\1\2\u0717\u0719\3\2\2\2\u0718\u06d7\3\2\2"+
		"\2\u0718\u06e9\3\2\2\2\u0718\u06f9\3\2\2\2\u0718\u0709\3\2\2\2\u0719y"+
		"\3\2\2\2\u071a\u071f\5|?\2\u071b\u071c\7\5\2\2\u071c\u071e\5|?\2\u071d"+
		"\u071b\3\2\2\2\u071e\u0721\3\2\2\2\u071f\u071d\3\2\2\2\u071f\u0720\3\2"+
		"\2\2\u0720{\3\2\2\2\u0721\u071f\3\2\2\2\u0722\u0727\5\u0084C\2\u0723\u0724"+
		"\7\5\2\2\u0724\u0726\5\u0084C\2\u0725\u0723\3\2\2\2\u0726\u0729\3\2\2"+
		"\2\u0727\u0725\3\2\2\2\u0727\u0728\3\2\2\2\u0728\u072a\3\2\2\2\u0729\u0727"+
		"\3\2\2\2\u072a\u072b\7\31\2\2\u072b\u072c\5r:\2\u072c\u072d\b?\1\2\u072d"+
		"}\3\2\2\2\u072e\u0733\5\u0080A\2\u072f\u0730\7\5\2\2\u0730\u0732\5\u0080"+
		"A\2\u0731\u072f\3\2\2\2\u0732\u0735\3\2\2\2\u0733\u0731\3\2\2\2\u0733"+
		"\u0734\3\2\2\2\u0734\177\3\2\2\2\u0735\u0733\3\2\2\2\u0736\u0738\7\u0098"+
		"\2\2\u0737\u0736\3\2\2\2\u0737\u0738\3\2\2\2\u0738\u0739\3\2\2\2\u0739"+
		"\u073e\5\u0084C\2\u073a\u073b\7\5\2\2\u073b\u073d\5\u0084C\2\u073c\u073a"+
		"\3\2\2\2\u073d\u0740\3\2\2\2\u073e\u073c\3\2\2\2\u073e\u073f\3\2\2\2\u073f"+
		"\u0741\3\2\2\2\u0740\u073e\3\2\2\2\u0741\u0743\7\b\2\2\u0742\u0744\7\35"+
		"\2\2\u0743\u0742\3\2\2\2\u0743\u0744\3\2\2\2\u0744\u0745\3\2\2\2\u0745"+
		"\u0746\5r:\2\u0746\u0747\3\2\2\2\u0747\u0748\bA\1\2\u0748\u0081\3\2\2"+
		"\2\u0749\u074a\5\u0088E\2\u074a\u0083\3\2\2\2\u074b\u074c\5\u0088E\2\u074c"+
		"\u074d\bC\1\2\u074d\u0085\3\2\2\2\u074e\u074f\t\24\2\2\u074f\u0087\3\2"+
		"\2\2\u0750\u0792\5\u008cG\2\u0751\u0792\7\32\2\2\u0752\u0792\7)\2\2\u0753"+
		"\u0792\7d\2\2\u0754\u0792\7e\2\2\u0755\u0792\7\33\2\2\u0756\u0792\7\64"+
		"\2\2\u0757\u0792\7R\2\2\u0758\u0792\7\u009a\2\2\u0759\u0792\7m\2\2\u075a"+
		"\u0792\7*\2\2\u075b\u0792\7U\2\2\u075c\u0792\7\u009b\2\2\u075d\u0792\7"+
		"!\2\2\u075e\u0792\7+\2\2\u075f\u0792\7\27\2\2\u0760\u0792\7l\2\2\u0761"+
		"\u0792\7\34\2\2\u0762\u0792\7I\2\2\u0763\u0792\7\16\2\2\u0764\u0792\7"+
		"J\2\2\u0765\u0792\7,\2\2\u0766\u0792\7\30\2\2\u0767\u0792\7j\2\2\u0768"+
		"\u0792\7h\2\2\u0769\u0792\7Q\2\2\u076a\u0792\7\62\2\2\u076b\u0792\7(\2"+
		"\2\u076c\u0792\7X\2\2\u076d\u0792\7\u009c\2\2\u076e\u0792\7G\2\2\u076f"+
		"\u0792\7$\2\2\u0770\u0792\7K\2\2\u0771\u0792\7&\2\2\u0772\u0792\7.\2\2"+
		"\u0773\u0792\7\60\2\2\u0774\u0792\7\'\2\2\u0775\u0792\7f\2\2\u0776\u0792"+
		"\7V\2\2\u0777\u0792\7S\2\2\u0778\u0792\7W\2\2\u0779\u0792\7\16\2\2\u077a"+
		"\u0792\7\f\2\2\u077b\u0792\7\35\2\2\u077c\u0792\7\36\2\2\u077d\u0792\7"+
		"\37\2\2\u077e\u0792\7 \2\2\u077f\u0792\7\65\2\2\u0780\u0792\7\66\2\2\u0781"+
		"\u0792\7\67\2\2\u0782\u0792\78\2\2\u0783\u0792\79\2\2\u0784\u0792\7:\2"+
		"\2\u0785\u0792\7;\2\2\u0786\u0792\7<\2\2\u0787\u0792\7=\2\2\u0788\u0792"+
		"\7>\2\2\u0789\u0792\7?\2\2\u078a\u0792\7@\2\2\u078b\u0792\7A\2\2\u078c"+
		"\u0792\7B\2\2\u078d\u0792\7C\2\2\u078e\u0792\7D\2\2\u078f\u0792\7E\2\2"+
		"\u0790\u0792\7F\2\2\u0791\u0750\3\2\2\2\u0791\u0751\3\2\2\2\u0791\u0752"+
		"\3\2\2\2\u0791\u0753\3\2\2\2\u0791\u0754\3\2\2\2\u0791\u0755\3\2\2\2\u0791"+
		"\u0756\3\2\2\2\u0791\u0757\3\2\2\2\u0791\u0758\3\2\2\2\u0791\u0759\3\2"+
		"\2\2\u0791\u075a\3\2\2\2\u0791\u075b\3\2\2\2\u0791\u075c\3\2\2\2\u0791"+
		"\u075d\3\2\2\2\u0791\u075e\3\2\2\2\u0791\u075f\3\2\2\2\u0791\u0760\3\2"+
		"\2\2\u0791\u0761\3\2\2\2\u0791\u0762\3\2\2\2\u0791\u0763\3\2\2\2\u0791"+
		"\u0764\3\2\2\2\u0791\u0765\3\2\2\2\u0791\u0766\3\2\2\2\u0791\u0767\3\2"+
		"\2\2\u0791\u0768\3\2\2\2\u0791\u0769\3\2\2\2\u0791\u076a\3\2\2\2\u0791"+
		"\u076b\3\2\2\2\u0791\u076c\3\2\2\2\u0791\u076d\3\2\2\2\u0791\u076e\3\2"+
		"\2\2\u0791\u076f\3\2\2\2\u0791\u0770\3\2\2\2\u0791\u0771\3\2\2\2\u0791"+
		"\u0772\3\2\2\2\u0791\u0773\3\2\2\2\u0791\u0774\3\2\2\2\u0791\u0775\3\2"+
		"\2\2\u0791\u0776\3\2\2\2\u0791\u0777\3\2\2\2\u0791\u0778\3\2\2\2\u0791"+
		"\u0779\3\2\2\2\u0791\u077a\3\2\2\2\u0791\u077b\3\2\2\2\u0791\u077c\3\2"+
		"\2\2\u0791\u077d\3\2\2\2\u0791\u077e\3\2\2\2\u0791\u077f\3\2\2\2\u0791"+
		"\u0780\3\2\2\2\u0791\u0781\3\2\2\2\u0791\u0782\3\2\2\2\u0791\u0783\3\2"+
		"\2\2\u0791\u0784\3\2\2\2\u0791\u0785\3\2\2\2\u0791\u0786\3\2\2\2\u0791"+
		"\u0787\3\2\2\2\u0791\u0788\3\2\2\2\u0791\u0789\3\2\2\2\u0791\u078a\3\2"+
		"\2\2\u0791\u078b\3\2\2\2\u0791\u078c\3\2\2\2\u0791\u078d\3\2\2\2\u0791"+
		"\u078e\3\2\2\2\u0791\u078f\3\2\2\2\u0791\u0790\3\2\2\2\u0792\u0089\3\2"+
		"\2\2\u0793\u0794\7\u009f\2\2\u0794\u008b\3\2\2\2\u0795\u0796\7\u009e\2"+
		"\2\u0796\u008d\3\2\2\2\u0797\u0798\t\25\2\2\u0798\u008f\3\2\2\2\u0799"+
		"\u079a\7\u009d\2\2\u079a\u0091\3\2\2\2\u00f6\u0099\u00aa\u00b0\u00b5\u00bb"+
		"\u00c1\u00c9\u00d2\u00d8\u00e2\u00ed\u00f3\u00f5\u00f9\u0101\u010e\u0115"+
		"\u011a\u011d\u0127\u012e\u0134\u0140\u0147\u0162\u0164\u0169\u0174\u0177"+
		"\u017b\u017f\u0183\u0186\u018b\u0194\u0197\u019c\u01a1\u01a6\u01aa\u01ac"+
		"\u01bc\u01be\u01c3\u01cb\u01ce\u01d2\u01d6\u01d9\u01dc\u01df\u01e3\u01ea"+
		"\u01ef\u01fb\u01fe\u0202\u0205\u020d\u0216\u021d\u0222\u0227\u022b\u022f"+
		"\u0232\u0235\u0238\u023c\u0242\u0248\u024d\u026d\u0270\u0274\u0277\u0280"+
		"\u0285\u028c\u0295\u029c\u02a2\u02a6\u02ab\u02af\u02b3\u02be\u02c1\u02c9"+
		"\u02cb\u02d5\u02d8\u02e0\u02e3\u02e7\u02ea\u02f9\u02fb\u0300\u030f\u0317"+
		"\u031a\u031e\u0321\u0327\u032c\u0334\u0337\u033b\u0341\u0345\u034b\u0350"+
		"\u0356\u0359\u0362\u0364\u0369\u036e\u0375\u037a\u0380\u0383\u038f\u0391"+
		"\u0396\u039d\u03a2\u03a9\u03af\u03b3\u03bc\u03c1\u03ce\u03d0\u03d5\u03d8"+
		"\u03dc\u03e6\u03f4\u03ff\u040c\u0419\u041c\u0426\u042f\u0434\u043c\u0445"+
		"\u044a\u044f\u0453\u0457\u045c\u0468\u046c\u0471\u0475\u047a\u0482\u0484"+
		"\u0489\u048d\u0494\u0498\u04a1\u04a3\u04a8\u04ac\u04b5\u04b7\u04bc\u04c0"+
		"\u04c6\u04cb\u04cf\u04d5\u04da\u04de\u04e5\u04fc\u0504\u050c\u0514\u051c"+
		"\u0524\u052c\u0546\u0549\u0568\u056c\u0572\u0576\u0583\u0587\u058d\u0591"+
		"\u059e\u05a2\u05a8\u05ac\u05b9\u05bd\u05c3\u05c7\u05d4\u05d8\u05de\u05e2"+
		"\u05ef\u05f3\u05f9\u05fd\u060a\u0620\u0622\u0651\u0655\u0668\u066c\u068b"+
		"\u068d\u06a2\u06ae\u06c9\u06cb\u06d3\u06d7\u06de\u06e3\u06e9\u06f0\u06f9"+
		"\u0700\u0709\u0710\u0718\u071f\u0727\u0733\u0737\u073e\u0743\u0791";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}