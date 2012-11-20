// $ANTLR ${project.version} ${buildNumber}

	package org.be.textbe.bttrace.resource.btt.mopp;


import org.antlr.runtime3_3_0.*;
import java.util.HashMap;
@SuppressWarnings("unused")
public class BttParser extends BttANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FILE", "INTEGER", "COLORS", "TEXT", "WHITESPACE", "LINEBREAK", "'BT'", "'DELAY'", "'ACTIVATE'", "'INTERLEAVE'", "'TRACE'", "'LOOP'", "'['", "','", "']'"
    };
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int FILE=4;
    public static final int INTEGER=5;
    public static final int COLORS=6;
    public static final int TEXT=7;
    public static final int WHITESPACE=8;
    public static final int LINEBREAK=9;

    // delegates
    // delegators


        public BttParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BttParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[19+1];
             
             
        }
        

    public String[] getTokenNames() { return BttParser.tokenNames; }
    public String getGrammarFileName() { return "Btt.g"; }


    	private org.be.textbe.bttrace.resource.btt.IBttTokenResolverFactory tokenResolverFactory = new org.be.textbe.bttrace.resource.btt.mopp.BttTokenResolverFactory();
    	
    	/**
    	 * the index of the last token that was handled by collectHiddenTokens()
    	 */
    	private int lastPosition;
    	
    	/**
    	 * A flag that indicates whether the parser should remember all expected elements.
    	 * This flag is set to true when using the parse for code completion. Otherwise it
    	 * is set to false.
    	 */
    	private boolean rememberExpectedElements = false;
    	
    	private Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	
    	/**
    	 * A list of expected elements the were collected while parsing the input stream.
    	 * This list is only filled if <code>rememberExpectedElements</code> is set to
    	 * true.
    	 */
    	private java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal> expectedElements = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected java.util.List<org.antlr.runtime3_3_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_3_0.RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	protected java.util.Stack<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
    	
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private int tokenIndexOfLastCompleteElement;
    	
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	/**
    	 * The offset indicating the cursor position when the parser is used for code
    	 * completion by calling parseToExpectedElements().
    	 */
    	private int cursorOffset;
    	
    	/**
    	 * The offset of the first hidden token of the last expected element. This offset
    	 * is used to discard expected elements, which are not needed for code completion.
    	 */
    	private int lastStartIncludingHidden;
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource>() {
    			public boolean execute(org.be.textbe.bttrace.resource.btt.IBttTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.be.textbe.bttrace.resource.btt.IBttProblem() {
    					public org.be.textbe.bttrace.resource.btt.BttEProblemSeverity getSeverity() {
    						return org.be.textbe.bttrace.resource.btt.BttEProblemSeverity.ERROR;
    					}
    					public org.be.textbe.bttrace.resource.btt.BttEProblemType getType() {
    						return org.be.textbe.bttrace.resource.btt.BttEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.be.textbe.bttrace.resource.btt.IBttExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal expectedElement = new org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal(terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    		postParseCommands.add(new org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource>() {
    			public boolean execute(org.be.textbe.bttrace.resource.btt.IBttTextResource resource) {
    				org.be.textbe.bttrace.resource.btt.IBttLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_3_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    		postParseCommands.add(new org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource>() {
    			public boolean execute(org.be.textbe.bttrace.resource.btt.IBttTextResource resource) {
    				org.be.textbe.bttrace.resource.btt.IBttLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				if (source == null) {
    					return true;
    				}
    				locationMap.setCharStart(target, source.getStartIndex());
    				locationMap.setCharEnd(target, source.getStopIndex());
    				locationMap.setColumn(target, source.getCharPositionInLine());
    				locationMap.setLine(target, source.getLine());
    				return true;
    			}
    		});
    	}
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		postParseCommands.add(new org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource>() {
    			public boolean execute(org.be.textbe.bttrace.resource.btt.IBttTextResource resource) {
    				org.be.textbe.bttrace.resource.btt.IBttLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.be.textbe.bttrace.resource.btt.IBttTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new BttParser(new org.antlr.runtime3_3_0.CommonTokenStream(new BttLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new BttParser(new org.antlr.runtime3_3_0.CommonTokenStream(new BttLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			org.be.textbe.bttrace.resource.btt.mopp.BttPlugin.logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public BttParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_3_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((BttLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((BttLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.be.textbe.bttrace.TextBTTrace.class) {
    				return parse_org_be_textbe_bttrace_TextBTTrace();
    			}
    			if (type.getInstanceClass() == org.be.textbe.bttrace.BT.class) {
    				return parse_org_be_textbe_bttrace_BT();
    			}
    			if (type.getInstanceClass() == org.be.textbe.bttrace.Delay.class) {
    				return parse_org_be_textbe_bttrace_Delay();
    			}
    			if (type.getInstanceClass() == org.be.textbe.bttrace.Activate.class) {
    				return parse_org_be_textbe_bttrace_Activate();
    			}
    			if (type.getInstanceClass() == org.be.textbe.bttrace.Interleave.class) {
    				return parse_org_be_textbe_bttrace_Interleave();
    			}
    			if (type.getInstanceClass() == org.be.textbe.bttrace.Trace.class) {
    				return parse_org_be_textbe_bttrace_Trace();
    			}
    			if (type.getInstanceClass() == org.be.textbe.bttrace.NodeGroup.class) {
    				return parse_org_be_textbe_bttrace_NodeGroup();
    			}
    			if (type.getInstanceClass() == org.be.textbe.bttrace.Node.class) {
    				return parse_org_be_textbe_bttrace_Node();
    			}
    		}
    		throw new org.be.textbe.bttrace.resource.btt.mopp.BttUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(org.antlr.runtime3_3_0.IntStream arg0, org.antlr.runtime3_3_0.RecognitionException arg1, int arg2, org.antlr.runtime3_3_0.BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	public Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected Object getTypeObject() {
    		Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(org.be.textbe.bttrace.resource.btt.IBttOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.be.textbe.bttrace.resource.btt.IBttParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource>>();
    		org.be.textbe.bttrace.resource.btt.mopp.BttParseResult parseResult = new org.be.textbe.bttrace.resource.btt.mopp.BttParseResult();
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    			}
    		} catch (org.antlr.runtime3_3_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_3_0.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.be.textbe.bttrace.resource.btt.IBttTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_3_0.CommonTokenStream tokenStream = (org.antlr.runtime3_3_0.CommonTokenStream) getTokenStream();
    		org.be.textbe.bttrace.resource.btt.IBttParseResult result = parse();
    		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
    			org.antlr.runtime3_3_0.Lexer lexer = (org.antlr.runtime3_3_0.Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			org.eclipse.emf.ecore.EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (org.be.textbe.bttrace.resource.btt.IBttCommand<org.be.textbe.bttrace.resource.btt.IBttTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal>();
    		java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal> newFollowSet = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 36;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_3_0.CommonToken nextToken = (org.antlr.runtime3_3_0.CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<org.be.textbe.bttrace.resource.btt.util.BttPair<org.be.textbe.bttrace.resource.btt.IBttExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.be.textbe.bttrace.resource.btt.util.BttPair<org.be.textbe.bttrace.resource.btt.IBttExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
    							org.be.textbe.bttrace.resource.btt.IBttExpectedElement newFollower = newFollowerPair.getLeft();
    							org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal newFollowTerminal = new org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
    							newFollowSet.add(newFollowTerminal);
    							expectedElements.add(newFollowTerminal);
    						}
    					}
    				}
    				currentFollowSet.clear();
    				currentFollowSet.addAll(newFollowSet);
    			}
    			followSetID++;
    		}
    		// after the last token in the stream we must set the position for the elements
    		// that were added during the last iteration of the loop
    		for (org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.be.textbe.bttrace.resource.btt.mopp.BttExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			org.antlr.runtime3_3_0.CommonToken tokenAtIndex = (org.antlr.runtime3_3_0.CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(org.antlr.runtime3_3_0.IntStream input, int ttype, org.antlr.runtime3_3_0.BitSet follow) throws org.antlr.runtime3_3_0.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_3_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
    			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_3_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_3_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
    			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
    			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
    			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_3_0.CommonToken) {
    			final org.antlr.runtime3_3_0.CommonToken ct = (org.antlr.runtime3_3_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_3_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
    			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
    			org.antlr.runtime3_3_0.EarlyExitException eee = (org.antlr.runtime3_3_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
    			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
    			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedRangeException) {
    			org.antlr.runtime3_3_0.MismatchedRangeException mre = (org.antlr.runtime3_3_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
    			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    	}
    	
    	protected void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			this.incompleteObjects.pop();
    		}
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	



    // $ANTLR start "start"
    // Btt.g:484:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_be_textbe_bttrace_TextBTTrace ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.be.textbe.bttrace.TextBTTrace c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Btt.g:485:1: ( (c0= parse_org_be_textbe_bttrace_TextBTTrace ) EOF )
            // Btt.g:486:2: (c0= parse_org_be_textbe_bttrace_TextBTTrace ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_0, 0, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_0);
              		expectedElementsIndexOfLastCompleteElement = 0;
              	
            }
            // Btt.g:491:2: (c0= parse_org_be_textbe_bttrace_TextBTTrace )
            // Btt.g:492:3: c0= parse_org_be_textbe_bttrace_TextBTTrace
            {
            pushFollow(FOLLOW_parse_org_be_textbe_bttrace_TextBTTrace_in_start82);
            c0=parse_org_be_textbe_bttrace_TextBTTrace();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		retrieveLayoutInformation(element, null, null, false);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "start"


    // $ANTLR start "parse_org_be_textbe_bttrace_TextBTTrace"
    // Btt.g:500:1: parse_org_be_textbe_bttrace_TextBTTrace returns [org.be.textbe.bttrace.TextBTTrace element = null] : (a0_0= parse_org_be_textbe_bttrace_BT ) ( (a1_0= parse_org_be_textbe_bttrace_Delay ) )? ( (a2_0= parse_org_be_textbe_bttrace_Activate ) )? ( (a3_0= parse_org_be_textbe_bttrace_Interleave ) )? (a4_0= parse_org_be_textbe_bttrace_Trace ) ;
    public final org.be.textbe.bttrace.TextBTTrace parse_org_be_textbe_bttrace_TextBTTrace() throws RecognitionException {
        org.be.textbe.bttrace.TextBTTrace element =  null;
        int parse_org_be_textbe_bttrace_TextBTTrace_StartIndex = input.index();
        org.be.textbe.bttrace.BT a0_0 = null;

        org.be.textbe.bttrace.Delay a1_0 = null;

        org.be.textbe.bttrace.Activate a2_0 = null;

        org.be.textbe.bttrace.Interleave a3_0 = null;

        org.be.textbe.bttrace.Trace a4_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // Btt.g:503:1: ( (a0_0= parse_org_be_textbe_bttrace_BT ) ( (a1_0= parse_org_be_textbe_bttrace_Delay ) )? ( (a2_0= parse_org_be_textbe_bttrace_Activate ) )? ( (a3_0= parse_org_be_textbe_bttrace_Interleave ) )? (a4_0= parse_org_be_textbe_bttrace_Trace ) )
            // Btt.g:504:2: (a0_0= parse_org_be_textbe_bttrace_BT ) ( (a1_0= parse_org_be_textbe_bttrace_Delay ) )? ( (a2_0= parse_org_be_textbe_bttrace_Activate ) )? ( (a3_0= parse_org_be_textbe_bttrace_Interleave ) )? (a4_0= parse_org_be_textbe_bttrace_Trace )
            {
            // Btt.g:504:2: (a0_0= parse_org_be_textbe_bttrace_BT )
            // Btt.g:505:3: a0_0= parse_org_be_textbe_bttrace_BT
            {
            pushFollow(FOLLOW_parse_org_be_textbe_bttrace_BT_in_parse_org_be_textbe_bttrace_TextBTTrace119);
            a0_0=parse_org_be_textbe_bttrace_BT();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTextBTTrace();
              				incompleteObjects.push(element);
              			}
              			if (a0_0 != null) {
              				if (a0_0 != null) {
              					Object value = a0_0;
              					element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__BT), value);
              					completedElement(value, true);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_0_0_0_0, a0_0, true);
              				copyLocalizationInfos(a0_0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_1, 1, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_1);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_2, 1, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_2);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_3, 1, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_3);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_4, 1, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_5, 1, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_6, 1, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              	
            }
            // Btt.g:535:2: ( (a1_0= parse_org_be_textbe_bttrace_Delay ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // Btt.g:536:3: (a1_0= parse_org_be_textbe_bttrace_Delay )
                    {
                    // Btt.g:536:3: (a1_0= parse_org_be_textbe_bttrace_Delay )
                    // Btt.g:537:4: a1_0= parse_org_be_textbe_bttrace_Delay
                    {
                    pushFollow(FOLLOW_parse_org_be_textbe_bttrace_Delay_in_parse_org_be_textbe_bttrace_TextBTTrace146);
                    a1_0=parse_org_be_textbe_bttrace_Delay();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
                      				}
                      				if (element == null) {
                      					element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTextBTTrace();
                      					incompleteObjects.push(element);
                      				}
                      				if (a1_0 != null) {
                      					if (a1_0 != null) {
                      						Object value = a1_0;
                      						element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__DELAY), value);
                      						completedElement(value, true);
                      					}
                      					collectHiddenTokens(element);
                      					retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_0_0_0_1, a1_0, true);
                      					copyLocalizationInfos(a1_0, element);
                      				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_2, 2, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_2);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_3, 2, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_3);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_4, 2, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_5, 2, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_6, 2, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              	
            }
            // Btt.g:567:2: ( (a2_0= parse_org_be_textbe_bttrace_Activate ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Btt.g:568:3: (a2_0= parse_org_be_textbe_bttrace_Activate )
                    {
                    // Btt.g:568:3: (a2_0= parse_org_be_textbe_bttrace_Activate )
                    // Btt.g:569:4: a2_0= parse_org_be_textbe_bttrace_Activate
                    {
                    pushFollow(FOLLOW_parse_org_be_textbe_bttrace_Activate_in_parse_org_be_textbe_bttrace_TextBTTrace181);
                    a2_0=parse_org_be_textbe_bttrace_Activate();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
                      				}
                      				if (element == null) {
                      					element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTextBTTrace();
                      					incompleteObjects.push(element);
                      				}
                      				if (a2_0 != null) {
                      					if (a2_0 != null) {
                      						Object value = a2_0;
                      						element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__ACTIVATE), value);
                      						completedElement(value, true);
                      					}
                      					collectHiddenTokens(element);
                      					retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_0_0_0_2, a2_0, true);
                      					copyLocalizationInfos(a2_0, element);
                      				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_3, 3, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_3);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_4, 3, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_5, 3, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_6, 3, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              	
            }
            // Btt.g:598:2: ( (a3_0= parse_org_be_textbe_bttrace_Interleave ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Btt.g:599:3: (a3_0= parse_org_be_textbe_bttrace_Interleave )
                    {
                    // Btt.g:599:3: (a3_0= parse_org_be_textbe_bttrace_Interleave )
                    // Btt.g:600:4: a3_0= parse_org_be_textbe_bttrace_Interleave
                    {
                    pushFollow(FOLLOW_parse_org_be_textbe_bttrace_Interleave_in_parse_org_be_textbe_bttrace_TextBTTrace216);
                    a3_0=parse_org_be_textbe_bttrace_Interleave();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
                      				}
                      				if (element == null) {
                      					element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTextBTTrace();
                      					incompleteObjects.push(element);
                      				}
                      				if (a3_0 != null) {
                      					if (a3_0 != null) {
                      						Object value = a3_0;
                      						element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__INTERLEAVE), value);
                      						completedElement(value, true);
                      					}
                      					collectHiddenTokens(element);
                      					retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_0_0_0_3, a3_0, true);
                      					copyLocalizationInfos(a3_0, element);
                      				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_4, 4, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_5, 4, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_6, 4, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              	
            }
            // Btt.g:628:2: (a4_0= parse_org_be_textbe_bttrace_Trace )
            // Btt.g:629:3: a4_0= parse_org_be_textbe_bttrace_Trace
            {
            pushFollow(FOLLOW_parse_org_be_textbe_bttrace_Trace_in_parse_org_be_textbe_bttrace_TextBTTrace246);
            a4_0=parse_org_be_textbe_bttrace_Trace();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTextBTTrace();
              				incompleteObjects.push(element);
              			}
              			if (a4_0 != null) {
              				if (a4_0 != null) {
              					Object value = a4_0;
              					element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__TRACE), value);
              					completedElement(value, true);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_0_0_0_4, a4_0, true);
              				copyLocalizationInfos(a4_0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_be_textbe_bttrace_TextBTTrace_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_be_textbe_bttrace_TextBTTrace"


    // $ANTLR start "parse_org_be_textbe_bttrace_BT"
    // Btt.g:655:1: parse_org_be_textbe_bttrace_BT returns [org.be.textbe.bttrace.BT element = null] : a0= 'BT' (a1= FILE ) ;
    public final org.be.textbe.bttrace.BT parse_org_be_textbe_bttrace_BT() throws RecognitionException {
        org.be.textbe.bttrace.BT element =  null;
        int parse_org_be_textbe_bttrace_BT_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Btt.g:658:1: (a0= 'BT' (a1= FILE ) )
            // Btt.g:659:2: a0= 'BT' (a1= FILE )
            {
            a0=(Token)match(input,10,FOLLOW_10_in_parse_org_be_textbe_bttrace_BT279); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createBT();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_1_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_7, 6);
              	
            }
            // Btt.g:673:2: (a1= FILE )
            // Btt.g:674:3: a1= FILE
            {
            a1=(Token)match(input,FILE,FOLLOW_FILE_in_parse_org_be_textbe_bttrace_BT297); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createBT();
              				incompleteObjects.push(element);
              			}
              			if (a1 != null) {
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("FILE");
              				tokenResolver.setOptions(getOptions());
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.BT__VALUE), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.BT__VALUE), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_1_0_0_1, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_1, 7, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_1);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_2, 7, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_2);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_3, 7, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_3);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_4, 7, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_5, 7, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_6, 7, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_be_textbe_bttrace_BT_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_be_textbe_bttrace_BT"


    // $ANTLR start "parse_org_be_textbe_bttrace_Delay"
    // Btt.g:716:1: parse_org_be_textbe_bttrace_Delay returns [org.be.textbe.bttrace.Delay element = null] : a0= 'DELAY' (a1= INTEGER ) ;
    public final org.be.textbe.bttrace.Delay parse_org_be_textbe_bttrace_Delay() throws RecognitionException {
        org.be.textbe.bttrace.Delay element =  null;
        int parse_org_be_textbe_bttrace_Delay_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Btt.g:719:1: (a0= 'DELAY' (a1= INTEGER ) )
            // Btt.g:720:2: a0= 'DELAY' (a1= INTEGER )
            {
            a0=(Token)match(input,11,FOLLOW_11_in_parse_org_be_textbe_bttrace_Delay333); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createDelay();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_2_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_8, 8);
              	
            }
            // Btt.g:734:2: (a1= INTEGER )
            // Btt.g:735:3: a1= INTEGER
            {
            a1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_be_textbe_bttrace_Delay351); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createDelay();
              				incompleteObjects.push(element);
              			}
              			if (a1 != null) {
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
              				tokenResolver.setOptions(getOptions());
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.DELAY__VALUE), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.DELAY__VALUE), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_2_0_0_1, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_2, 9, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_2);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_3, 9, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_3);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_4, 9, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_5, 9, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_6, 9, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_be_textbe_bttrace_Delay_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_be_textbe_bttrace_Delay"


    // $ANTLR start "parse_org_be_textbe_bttrace_Activate"
    // Btt.g:776:1: parse_org_be_textbe_bttrace_Activate returns [org.be.textbe.bttrace.Activate element = null] : a0= 'ACTIVATE' (a1= COLORS ) ;
    public final org.be.textbe.bttrace.Activate parse_org_be_textbe_bttrace_Activate() throws RecognitionException {
        org.be.textbe.bttrace.Activate element =  null;
        int parse_org_be_textbe_bttrace_Activate_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Btt.g:779:1: (a0= 'ACTIVATE' (a1= COLORS ) )
            // Btt.g:780:2: a0= 'ACTIVATE' (a1= COLORS )
            {
            a0=(Token)match(input,12,FOLLOW_12_in_parse_org_be_textbe_bttrace_Activate387); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createActivate();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_3_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_9, 10);
              	
            }
            // Btt.g:794:2: (a1= COLORS )
            // Btt.g:795:3: a1= COLORS
            {
            a1=(Token)match(input,COLORS,FOLLOW_COLORS_in_parse_org_be_textbe_bttrace_Activate405); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createActivate();
              				incompleteObjects.push(element);
              			}
              			if (a1 != null) {
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("COLORS");
              				tokenResolver.setOptions(getOptions());
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.ACTIVATE__COLOR), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.ACTIVATE__COLOR), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_3_0_0_1, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_3, 11, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_3);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_4, 11, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_5, 11, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_6, 11, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_be_textbe_bttrace_Activate_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_be_textbe_bttrace_Activate"


    // $ANTLR start "parse_org_be_textbe_bttrace_Interleave"
    // Btt.g:835:1: parse_org_be_textbe_bttrace_Interleave returns [org.be.textbe.bttrace.Interleave element = null] : a0= 'INTERLEAVE' (a1= COLORS ) ;
    public final org.be.textbe.bttrace.Interleave parse_org_be_textbe_bttrace_Interleave() throws RecognitionException {
        org.be.textbe.bttrace.Interleave element =  null;
        int parse_org_be_textbe_bttrace_Interleave_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Btt.g:838:1: (a0= 'INTERLEAVE' (a1= COLORS ) )
            // Btt.g:839:2: a0= 'INTERLEAVE' (a1= COLORS )
            {
            a0=(Token)match(input,13,FOLLOW_13_in_parse_org_be_textbe_bttrace_Interleave441); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createInterleave();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_4_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_10, 12);
              	
            }
            // Btt.g:853:2: (a1= COLORS )
            // Btt.g:854:3: a1= COLORS
            {
            a1=(Token)match(input,COLORS,FOLLOW_COLORS_in_parse_org_be_textbe_bttrace_Interleave459); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createInterleave();
              				incompleteObjects.push(element);
              			}
              			if (a1 != null) {
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("COLORS");
              				tokenResolver.setOptions(getOptions());
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.INTERLEAVE__COLOR), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.INTERLEAVE__COLOR), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_4_0_0_1, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_4, 13, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_5, 13, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_6, 13, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_4);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_be_textbe_bttrace_Interleave_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_be_textbe_bttrace_Interleave"


    // $ANTLR start "parse_org_be_textbe_bttrace_Trace"
    // Btt.g:893:1: parse_org_be_textbe_bttrace_Trace returns [org.be.textbe.bttrace.Trace element = null] : ( (a0= 'TRACE' ( ( (a1_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ ) | (a2= 'LOOP' ( ( (a3_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ ) | (a4= 'TRACE' ( ( (a5_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ a6= 'LOOP' ( ( (a7_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ ) );
    public final org.be.textbe.bttrace.Trace parse_org_be_textbe_bttrace_Trace() throws RecognitionException {
        org.be.textbe.bttrace.Trace element =  null;
        int parse_org_be_textbe_bttrace_Trace_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        org.be.textbe.bttrace.NodeGroup a1_0 = null;

        org.be.textbe.bttrace.NodeGroup a3_0 = null;

        org.be.textbe.bttrace.NodeGroup a5_0 = null;

        org.be.textbe.bttrace.NodeGroup a7_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Btt.g:896:1: ( (a0= 'TRACE' ( ( (a1_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ ) | (a2= 'LOOP' ( ( (a3_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ ) | (a4= 'TRACE' ( ( (a5_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ a6= 'LOOP' ( ( (a7_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ ) )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // Btt.g:897:2: (a0= 'TRACE' ( ( (a1_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ )
                    {
                    // Btt.g:897:2: (a0= 'TRACE' ( ( (a1_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ )
                    // Btt.g:898:3: a0= 'TRACE' ( ( (a1_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+
                    {
                    a0=(Token)match(input,14,FOLLOW_14_in_parse_org_be_textbe_bttrace_Trace499); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTrace();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_5_0_0_0_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 14, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_5);
                      		
                    }
                    // Btt.g:912:3: ( ( (a1_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Btt.g:913:4: ( (a1_0= parse_org_be_textbe_bttrace_NodeGroup ) )
                    	    {
                    	    // Btt.g:913:4: ( (a1_0= parse_org_be_textbe_bttrace_NodeGroup ) )
                    	    // Btt.g:914:5: (a1_0= parse_org_be_textbe_bttrace_NodeGroup )
                    	    {
                    	    // Btt.g:914:5: (a1_0= parse_org_be_textbe_bttrace_NodeGroup )
                    	    // Btt.g:915:6: a1_0= parse_org_be_textbe_bttrace_NodeGroup
                    	    {
                    	    pushFollow(FOLLOW_parse_org_be_textbe_bttrace_NodeGroup_in_parse_org_be_textbe_bttrace_Trace534);
                    	    a1_0=parse_org_be_textbe_bttrace_NodeGroup();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
                    	      						}
                    	      						if (element == null) {
                    	      							element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTrace();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						if (a1_0 != null) {
                    	      							if (a1_0 != null) {
                    	      								Object value = a1_0;
                    	      								addObjectToList(element, org.be.textbe.bttrace.BttracePackage.TRACE__NODE_GROUP, value);
                    	      								completedElement(value, true);
                    	      							}
                    	      							collectHiddenTokens(element);
                    	      							retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_5_0_0_0_0_0_1_0_0_0, a1_0, true);
                    	      							copyLocalizationInfos(a1_0, element);
                    	      						}
                    	      					
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      					// expected elements (follow set)
                    	      					addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 15, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_5);
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 16, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_5);
                      		
                    }

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      	
                    }

                    }
                    break;
                case 2 :
                    // Btt.g:953:4: (a2= 'LOOP' ( ( (a3_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ )
                    {
                    // Btt.g:953:4: (a2= 'LOOP' ( ( (a3_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ )
                    // Btt.g:954:3: a2= 'LOOP' ( ( (a3_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+
                    {
                    a2=(Token)match(input,15,FOLLOW_15_in_parse_org_be_textbe_bttrace_Trace600); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTrace();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_5_0_1_0_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 18, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_6);
                      		
                    }
                    // Btt.g:968:3: ( ( (a3_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Btt.g:969:4: ( (a3_0= parse_org_be_textbe_bttrace_NodeGroup ) )
                    	    {
                    	    // Btt.g:969:4: ( (a3_0= parse_org_be_textbe_bttrace_NodeGroup ) )
                    	    // Btt.g:970:5: (a3_0= parse_org_be_textbe_bttrace_NodeGroup )
                    	    {
                    	    // Btt.g:970:5: (a3_0= parse_org_be_textbe_bttrace_NodeGroup )
                    	    // Btt.g:971:6: a3_0= parse_org_be_textbe_bttrace_NodeGroup
                    	    {
                    	    pushFollow(FOLLOW_parse_org_be_textbe_bttrace_NodeGroup_in_parse_org_be_textbe_bttrace_Trace635);
                    	    a3_0=parse_org_be_textbe_bttrace_NodeGroup();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
                    	      						}
                    	      						if (element == null) {
                    	      							element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTrace();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						if (a3_0 != null) {
                    	      							if (a3_0 != null) {
                    	      								Object value = a3_0;
                    	      								addObjectToList(element, org.be.textbe.bttrace.BttracePackage.TRACE__LOOP_NODE_GROUP, value);
                    	      								completedElement(value, true);
                    	      							}
                    	      							collectHiddenTokens(element);
                    	      							retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_5_0_1_0_0_0_1_0_0_0, a3_0, true);
                    	      							copyLocalizationInfos(a3_0, element);
                    	      						}
                    	      					
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      					// expected elements (follow set)
                    	      					addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 19, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_6);
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 20, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_6);
                      		
                    }

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      	
                    }

                    }
                    break;
                case 3 :
                    // Btt.g:1009:4: (a4= 'TRACE' ( ( (a5_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ a6= 'LOOP' ( ( (a7_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ )
                    {
                    // Btt.g:1009:4: (a4= 'TRACE' ( ( (a5_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ a6= 'LOOP' ( ( (a7_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ )
                    // Btt.g:1010:3: a4= 'TRACE' ( ( (a5_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ a6= 'LOOP' ( ( (a7_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+
                    {
                    a4=(Token)match(input,14,FOLLOW_14_in_parse_org_be_textbe_bttrace_Trace701); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTrace();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_5_0_2_0_0_0_0, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 22, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_5);
                      		
                    }
                    // Btt.g:1024:3: ( ( (a5_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==16) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Btt.g:1025:4: ( (a5_0= parse_org_be_textbe_bttrace_NodeGroup ) )
                    	    {
                    	    // Btt.g:1025:4: ( (a5_0= parse_org_be_textbe_bttrace_NodeGroup ) )
                    	    // Btt.g:1026:5: (a5_0= parse_org_be_textbe_bttrace_NodeGroup )
                    	    {
                    	    // Btt.g:1026:5: (a5_0= parse_org_be_textbe_bttrace_NodeGroup )
                    	    // Btt.g:1027:6: a5_0= parse_org_be_textbe_bttrace_NodeGroup
                    	    {
                    	    pushFollow(FOLLOW_parse_org_be_textbe_bttrace_NodeGroup_in_parse_org_be_textbe_bttrace_Trace736);
                    	    a5_0=parse_org_be_textbe_bttrace_NodeGroup();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
                    	      						}
                    	      						if (element == null) {
                    	      							element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTrace();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						if (a5_0 != null) {
                    	      							if (a5_0 != null) {
                    	      								Object value = a5_0;
                    	      								addObjectToList(element, org.be.textbe.bttrace.BttracePackage.TRACE__NODE_GROUP, value);
                    	      								completedElement(value, true);
                    	      							}
                    	      							collectHiddenTokens(element);
                    	      							retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_5_0_2_0_0_0_1_0_0_0, a5_0, true);
                    	      							copyLocalizationInfos(a5_0, element);
                    	      						}
                    	      					
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      					// expected elements (follow set)
                    	      					addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 23, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_5);
                    	      					addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_12, 23);
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 24, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_5);
                      			addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_12, 24);
                      		
                    }
                    a6=(Token)match(input,15,FOLLOW_15_in_parse_org_be_textbe_bttrace_Trace787); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTrace();
                      				incompleteObjects.push(element);
                      			}
                      			collectHiddenTokens(element);
                      			retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_5_0_2_0_0_0_2, null, true);
                      			copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 25, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_6);
                      		
                    }
                    // Btt.g:1075:3: ( ( (a7_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Btt.g:1076:4: ( (a7_0= parse_org_be_textbe_bttrace_NodeGroup ) )
                    	    {
                    	    // Btt.g:1076:4: ( (a7_0= parse_org_be_textbe_bttrace_NodeGroup ) )
                    	    // Btt.g:1077:5: (a7_0= parse_org_be_textbe_bttrace_NodeGroup )
                    	    {
                    	    // Btt.g:1077:5: (a7_0= parse_org_be_textbe_bttrace_NodeGroup )
                    	    // Btt.g:1078:6: a7_0= parse_org_be_textbe_bttrace_NodeGroup
                    	    {
                    	    pushFollow(FOLLOW_parse_org_be_textbe_bttrace_NodeGroup_in_parse_org_be_textbe_bttrace_Trace822);
                    	    a7_0=parse_org_be_textbe_bttrace_NodeGroup();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
                    	      						}
                    	      						if (element == null) {
                    	      							element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createTrace();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						if (a7_0 != null) {
                    	      							if (a7_0 != null) {
                    	      								Object value = a7_0;
                    	      								addObjectToList(element, org.be.textbe.bttrace.BttracePackage.TRACE__LOOP_NODE_GROUP, value);
                    	      								completedElement(value, true);
                    	      							}
                    	      							collectHiddenTokens(element);
                    	      							retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_5_0_2_0_0_0_3_0_0_0, a7_0, true);
                    	      							copyLocalizationInfos(a7_0, element);
                    	      						}
                    	      					
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      					// expected elements (follow set)
                    	      					addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 26, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_6);
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected elements (follow set)
                      			addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 27, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_6);
                      		
                    }

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      	
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
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_be_textbe_bttrace_Trace_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_be_textbe_bttrace_Trace"


    // $ANTLR start "parse_org_be_textbe_bttrace_NodeGroup"
    // Btt.g:1117:1: parse_org_be_textbe_bttrace_NodeGroup returns [org.be.textbe.bttrace.NodeGroup element = null] : a0= '[' (a1_0= parse_org_be_textbe_bttrace_Node ) ( (a2= ',' (a3_0= parse_org_be_textbe_bttrace_Node ) ) )* a4= ']' ;
    public final org.be.textbe.bttrace.NodeGroup parse_org_be_textbe_bttrace_NodeGroup() throws RecognitionException {
        org.be.textbe.bttrace.NodeGroup element =  null;
        int parse_org_be_textbe_bttrace_NodeGroup_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        Token a4=null;
        org.be.textbe.bttrace.Node a1_0 = null;

        org.be.textbe.bttrace.Node a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Btt.g:1120:1: (a0= '[' (a1_0= parse_org_be_textbe_bttrace_Node ) ( (a2= ',' (a3_0= parse_org_be_textbe_bttrace_Node ) ) )* a4= ']' )
            // Btt.g:1121:2: a0= '[' (a1_0= parse_org_be_textbe_bttrace_Node ) ( (a2= ',' (a3_0= parse_org_be_textbe_bttrace_Node ) ) )* a4= ']'
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_org_be_textbe_bttrace_NodeGroup895); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createNodeGroup();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_6_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_13, 29, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_7);
              	
            }
            // Btt.g:1135:2: (a1_0= parse_org_be_textbe_bttrace_Node )
            // Btt.g:1136:3: a1_0= parse_org_be_textbe_bttrace_Node
            {
            pushFollow(FOLLOW_parse_org_be_textbe_bttrace_Node_in_parse_org_be_textbe_bttrace_NodeGroup913);
            a1_0=parse_org_be_textbe_bttrace_Node();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createNodeGroup();
              				incompleteObjects.push(element);
              			}
              			if (a1_0 != null) {
              				if (a1_0 != null) {
              					Object value = a1_0;
              					element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE_GROUP__ACTIVE_NODE), value);
              					completedElement(value, true);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_6_0_0_1, a1_0, true);
              				copyLocalizationInfos(a1_0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_14, 30);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_15, 30);
              	
            }
            // Btt.g:1162:2: ( (a2= ',' (a3_0= parse_org_be_textbe_bttrace_Node ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==17) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Btt.g:1163:3: (a2= ',' (a3_0= parse_org_be_textbe_bttrace_Node ) )
            	    {
            	    // Btt.g:1163:3: (a2= ',' (a3_0= parse_org_be_textbe_bttrace_Node ) )
            	    // Btt.g:1164:4: a2= ',' (a3_0= parse_org_be_textbe_bttrace_Node )
            	    {
            	    a2=(Token)match(input,17,FOLLOW_17_in_parse_org_be_textbe_bttrace_NodeGroup940); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createNodeGroup();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_6_0_0_2_0_0_0, null, true);
            	      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_13, 31, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_8);
            	      			
            	    }
            	    // Btt.g:1178:4: (a3_0= parse_org_be_textbe_bttrace_Node )
            	    // Btt.g:1179:5: a3_0= parse_org_be_textbe_bttrace_Node
            	    {
            	    pushFollow(FOLLOW_parse_org_be_textbe_bttrace_Node_in_parse_org_be_textbe_bttrace_NodeGroup966);
            	    a3_0=parse_org_be_textbe_bttrace_Node();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
            	      					}
            	      					if (element == null) {
            	      						element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createNodeGroup();
            	      						incompleteObjects.push(element);
            	      					}
            	      					if (a3_0 != null) {
            	      						if (a3_0 != null) {
            	      							Object value = a3_0;
            	      							addObjectToList(element, org.be.textbe.bttrace.BttracePackage.NODE_GROUP__INTERLEAVE_NODE, value);
            	      							completedElement(value, true);
            	      						}
            	      						collectHiddenTokens(element);
            	      						retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_6_0_0_2_0_0_1, a3_0, true);
            	      						copyLocalizationInfos(a3_0, element);
            	      					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_14, 32);
            	      				addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_15, 32);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_14, 33);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_15, 33);
              	
            }
            a4=(Token)match(input,18,FOLLOW_18_in_parse_org_be_textbe_bttrace_NodeGroup1007); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createNodeGroup();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_6_0_0_3, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_11, 34, org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.FEATURE_5);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_be_textbe_bttrace_NodeGroup_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_be_textbe_bttrace_NodeGroup"


    // $ANTLR start "parse_org_be_textbe_bttrace_Node"
    // Btt.g:1229:1: parse_org_be_textbe_bttrace_Node returns [org.be.textbe.bttrace.Node element = null] : (a0= INTEGER ) ;
    public final org.be.textbe.bttrace.Node parse_org_be_textbe_bttrace_Node() throws RecognitionException {
        org.be.textbe.bttrace.Node element =  null;
        int parse_org_be_textbe_bttrace_Node_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Btt.g:1232:1: ( (a0= INTEGER ) )
            // Btt.g:1233:2: (a0= INTEGER )
            {
            // Btt.g:1233:2: (a0= INTEGER )
            // Btt.g:1234:3: a0= INTEGER
            {
            a0=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_org_be_textbe_bttrace_Node1040); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.be.textbe.bttrace.resource.btt.mopp.BttTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.be.textbe.bttrace.BttraceFactory.eINSTANCE.createNode();
              				incompleteObjects.push(element);
              			}
              			if (a0 != null) {
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
              				tokenResolver.setOptions(getOptions());
              				org.be.textbe.bttrace.resource.btt.IBttTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE__VALUE), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
              				}
              				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE__VALUE), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_7_0_0_0, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_14, 35);
              		addExpectedElement(org.be.textbe.bttrace.resource.btt.grammar.BttFollowSetProvider.TERMINAL_15, 35);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_be_textbe_bttrace_Node_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_be_textbe_bttrace_Node"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\12\uffff";
    static final String DFA8_eofS =
        "\6\uffff\1\10\3\uffff";
    static final String DFA8_minS =
        "\1\16\1\20\1\uffff\1\5\1\21\1\5\1\17\1\21\2\uffff";
    static final String DFA8_maxS =
        "\1\17\1\20\1\uffff\1\5\1\22\1\5\1\20\1\22\2\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\5\uffff\1\1\1\3";
    static final String DFA8_specialS =
        "\12\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\1\2",
            "\1\3",
            "",
            "\1\4",
            "\1\5\1\6",
            "\1\7",
            "\1\11\1\3",
            "\1\5\1\6",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "893:1: parse_org_be_textbe_bttrace_Trace returns [org.be.textbe.bttrace.Trace element = null] : ( (a0= 'TRACE' ( ( (a1_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ ) | (a2= 'LOOP' ( ( (a3_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ ) | (a4= 'TRACE' ( ( (a5_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ a6= 'LOOP' ( ( (a7_0= parse_org_be_textbe_bttrace_NodeGroup ) ) )+ ) );";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_TextBTTrace_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_BT_in_parse_org_be_textbe_bttrace_TextBTTrace119 = new BitSet(new long[]{0x000000000000F800L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_Delay_in_parse_org_be_textbe_bttrace_TextBTTrace146 = new BitSet(new long[]{0x000000000000F800L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_Activate_in_parse_org_be_textbe_bttrace_TextBTTrace181 = new BitSet(new long[]{0x000000000000F800L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_Interleave_in_parse_org_be_textbe_bttrace_TextBTTrace216 = new BitSet(new long[]{0x000000000000F800L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_Trace_in_parse_org_be_textbe_bttrace_TextBTTrace246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_parse_org_be_textbe_bttrace_BT279 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_FILE_in_parse_org_be_textbe_bttrace_BT297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_parse_org_be_textbe_bttrace_Delay333 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_be_textbe_bttrace_Delay351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_org_be_textbe_bttrace_Activate387 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLORS_in_parse_org_be_textbe_bttrace_Activate405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_org_be_textbe_bttrace_Interleave441 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLORS_in_parse_org_be_textbe_bttrace_Interleave459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_be_textbe_bttrace_Trace499 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_NodeGroup_in_parse_org_be_textbe_bttrace_Trace534 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_15_in_parse_org_be_textbe_bttrace_Trace600 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_NodeGroup_in_parse_org_be_textbe_bttrace_Trace635 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_14_in_parse_org_be_textbe_bttrace_Trace701 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_NodeGroup_in_parse_org_be_textbe_bttrace_Trace736 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_parse_org_be_textbe_bttrace_Trace787 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_NodeGroup_in_parse_org_be_textbe_bttrace_Trace822 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_parse_org_be_textbe_bttrace_NodeGroup895 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_Node_in_parse_org_be_textbe_bttrace_NodeGroup913 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_parse_org_be_textbe_bttrace_NodeGroup940 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_org_be_textbe_bttrace_Node_in_parse_org_be_textbe_bttrace_NodeGroup966 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_parse_org_be_textbe_bttrace_NodeGroup1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_parse_org_be_textbe_bttrace_Node1040 = new BitSet(new long[]{0x0000000000000002L});

}