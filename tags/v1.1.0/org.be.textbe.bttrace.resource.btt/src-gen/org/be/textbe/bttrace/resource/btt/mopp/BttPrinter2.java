/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttPrinter2 implements org.be.textbe.bttrace.resource.btt.IBttTextPrinter {
	
	protected class PrintToken {
		
		private String text;
		private String tokenName;
		
		public PrintToken(String text, String tokenName) {
			this.text = text;
			this.tokenName = tokenName;
		}
		
		public String getText() {
			return text;
		}
		
		public String getTokenName() {
			return tokenName;
		}
		
	}
	
	public final static String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	
	private final PrintToken SPACE_TOKEN = new PrintToken(" ", null);
	private final PrintToken TAB_TOKEN = new PrintToken("\t", null);
	private final PrintToken NEW_LINE_TOKEN = new PrintToken(NEW_LINE, null);
	
	/**
	 * Holds the resource that is associated with this printer. May be null if the
	 * printer is used stand alone.
	 */
	private org.be.textbe.bttrace.resource.btt.IBttTextResource resource;
	
	private java.util.Map<?, ?> options;
	private java.io.OutputStream outputStream;
	protected java.util.List<PrintToken> tokenOutputStream;
	private org.be.textbe.bttrace.resource.btt.IBttTokenResolverFactory tokenResolverFactory = new org.be.textbe.bttrace.resource.btt.mopp.BttTokenResolverFactory();
	private boolean handleTokenSpaceAutomatically = true;
	private int tokenSpace = 1;
	/**
	 * A flag that indicates whether tokens have already been printed for some object.
	 * The flag is set to false whenever printing of an EObject tree is started. The
	 * status of the flag is used to avoid printing default token space in front of
	 * the root object.
	 */
	private boolean startedPrintingObject = false;
	/**
	 * The number of tab characters that were printed before the current line. This
	 * number is used to calculate the relative indentation when printing contained
	 * objects, because all contained objects must start with this indentation
	 * (tabsBeforeCurrentObject + currentTabs).
	 */
	private int currentTabs;
	/**
	 * The number of tab characters that must be printed before the current object.
	 * This number is used to calculate the indentation of new lines, when line breaks
	 * are printed within one object.
	 */
	private int tabsBeforeCurrentObject;
	/**
	 * This flag is used to indicate whether the number of tabs before the current
	 * object has been set for the current object. The flag is needed, because setting
	 * the number of tabs must be performed when the first token of the contained
	 * element is printed.
	 */
	private boolean startedPrintingContainedObject;
	
	public BttPrinter2(java.io.OutputStream outputStream, org.be.textbe.bttrace.resource.btt.IBttTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		tokenOutputStream = new java.util.ArrayList<PrintToken>();
		currentTabs = 0;
		tabsBeforeCurrentObject = 0;
		startedPrintingObject = true;
		startedPrintingContainedObject = false;
		java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement>  formattingElements = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement>();
		doPrint(element, formattingElements);
		// print all remaining formatting elements
		java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations = getCopyOfLayoutInformation(element);
		org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation eofLayoutInformation = getLayoutInformation(layoutInformations, null, null, null);
		printFormattingElements(formattingElements, layoutInformations, eofLayoutInformation);
		java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		if (handleTokenSpaceAutomatically) {
			printSmart(writer);
		} else {
			printBasic(writer);
		}
		writer.flush();
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (outputStream == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.be.textbe.bttrace.TextBTTrace) {
			printInternal(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_0, foundFormattingElements);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.BT) {
			printInternal(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_1, foundFormattingElements);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Delay) {
			printInternal(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_2, foundFormattingElements);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Activate) {
			printInternal(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_3, foundFormattingElements);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Interleave) {
			printInternal(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_4, foundFormattingElements);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Trace) {
			printInternal(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_5, foundFormattingElements);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.NodeGroup) {
			printInternal(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_6, foundFormattingElements);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Node) {
			printInternal(element, org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.BTT_7, foundFormattingElements);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void printInternal(org.eclipse.emf.ecore.EObject eObject, org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement ruleElement, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements) {
		java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations = getCopyOfLayoutInformation(eObject);
		org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator decoratorTree = getDecoratorTree(ruleElement);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, foundFormattingElements, layoutInformations);
	}
	
	/**
	 * creates a tree of decorator objects which reflects the syntax tree that is
	 * attached to the given syntax element
	 */
	public org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator getDecoratorTree(org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement syntaxElement) {
		org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement[] children = syntaxElement.getChildren();
		int childCount = children.length;
		org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator[] childDecorators = new org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator[childCount];
		for (int i = 0; i < childCount; i++) {
			childDecorators[i] = getDecoratorTree(children[i]);
		}
		org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator decorator = new org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator(syntaxElement, childDecorators);
		return decorator;
	}
	
	public void decorateTree(org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject) {
		java.util.Map<String, Integer> printCountingMap = initializePrintCountingMap(eObject);
		java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator> keywordsToPrint = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator>();
		decorateTreeBasic(decorator, eObject, printCountingMap, keywordsToPrint);
		for (org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator keywordToPrint : keywordsToPrint) {
			// for keywords the concrete index does not matter, but we must add one to
			// indicate that the keyword needs to be printed here. Thus, we use 0 as index.
			keywordToPrint.addIndexToPrint(0);
		}
	}
	
	/**
	 * Tries to decorate the decorator with an attribute value, or reference holded by
	 * eObject. Returns true if an attribute value or reference was found.
	 */
	public boolean decorateTreeBasic(org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.Map<String, Integer> printCountingMap, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator> keywordsToPrint) {
		boolean foundFeatureToPrint = false;
		org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement syntaxElement = decorator.getDecoratedElement();
		org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality = syntaxElement.getCardinality();
		boolean isFirstIteration = true;
		while (true) {
			java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator> subKeywordsToPrint = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator>();
			boolean keepDecorating = false;
			if (syntaxElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttKeyword) {
				subKeywordsToPrint.add(decorator);
			} else if (syntaxElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttTerminal) {
				org.be.textbe.bttrace.resource.btt.grammar.BttTerminal terminal = (org.be.textbe.bttrace.resource.btt.grammar.BttTerminal) syntaxElement;
				org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
				if (feature == org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.ANONYMOUS_FEATURE) {
					return false;
				}
				int countLeft = printCountingMap.get(feature.getName());
				if (countLeft > terminal.getMandatoryOccurencesAfter()) {
					decorator.addIndexToPrint(countLeft);
					printCountingMap.put(feature.getName(), countLeft - 1);
					keepDecorating = true;
				}
			}
			if (syntaxElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttChoice) {
				// for choices we do print only the choice which does print at least one feature
				org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator childToPrint = null;
				for (org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
					// pick first choice as default, will be overridden if a choice that prints a
					// feature is found
					if (childToPrint == null) {
						childToPrint = childDecorator;
					}
					if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {
						childToPrint = childDecorator;
						break;
					}
				}
				keepDecorating |= decorateTreeBasic(childToPrint, eObject, printCountingMap, subKeywordsToPrint);
			} else {
				// for all other syntax element we do print all children
				for (org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
					keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);
				}
			}
			foundFeatureToPrint |= keepDecorating;
			// only print keywords if a feature was printed or the syntax element is mandatory
			if (cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			} else if (cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.PLUS) {
				if (isFirstIteration) {
					keywordsToPrint.addAll(subKeywordsToPrint);
				} else {
					if (keepDecorating) {
						keywordsToPrint.addAll(subKeywordsToPrint);
					}
				}
			} else if (keepDecorating && (cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.STAR || cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.QUESTIONMARK)) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			}
			if (cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE || cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.QUESTIONMARK) {
				break;
			} else if (!keepDecorating) {
				break;
			}
			isFirstIteration = false;
		}
		return foundFeatureToPrint;
	}
	
	/**
	 * Checks whether decorating the given node will use at least one attribute value,
	 * or reference holded by eObject. Returns true if a printable attribute value or
	 * reference was found. This method is used to decide which choice to pick, when
	 * multiple choices are available. We pick the choice that prints at least one
	 * attribute or reference.
	 */
	public boolean doesPrintFeature(org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.Map<String, Integer> printCountingMap) {
		org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement syntaxElement = decorator.getDecoratedElement();
		if (syntaxElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttTerminal) {
			org.be.textbe.bttrace.resource.btt.grammar.BttTerminal terminal = (org.be.textbe.bttrace.resource.btt.grammar.BttTerminal) syntaxElement;
			org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
			if (feature == org.be.textbe.bttrace.resource.btt.grammar.BttGrammarInformationProvider.ANONYMOUS_FEATURE) {
				return false;
			}
			int countLeft = printCountingMap.get(feature.getName());
			if (countLeft > terminal.getMandatoryOccurencesAfter()) {
				// found a feature to print
				return true;
			}
		}
		for (org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
			if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean printTree(org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations) {
		org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement printElement = decorator.getDecoratedElement();
		org.be.textbe.bttrace.resource.btt.grammar.BttCardinality cardinality = printElement.getCardinality();
		java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> cloned = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement>();
		cloned.addAll(foundFormattingElements);
		boolean foundSomethingAtAll = false;
		boolean foundSomethingToPrint;
		while (true) {
			foundSomethingToPrint = false;
			Integer indexToPrint = decorator.getNextIndexToPrint();
			if (indexToPrint != null) {
				if (printElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttKeyword) {
					printKeyword(eObject, (org.be.textbe.bttrace.resource.btt.grammar.BttKeyword) printElement, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder) {
					org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder placeholder = (org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder) printElement;
					printFeature(eObject, placeholder, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttContainment) {
					org.be.textbe.bttrace.resource.btt.grammar.BttContainment containment = (org.be.textbe.bttrace.resource.btt.grammar.BttContainment) printElement;
					printContainedObject(eObject, containment, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttBooleanTerminal) {
					org.be.textbe.bttrace.resource.btt.grammar.BttBooleanTerminal booleanTerminal = (org.be.textbe.bttrace.resource.btt.grammar.BttBooleanTerminal) printElement;
					printBooleanTerminal(eObject, booleanTerminal, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal) {
					org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal enumTerminal = (org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal) printElement;
					printEnumerationTerminal(eObject, enumTerminal, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				}
			}
			if (foundSomethingToPrint) {
				foundSomethingAtAll = true;
			}
			if (printElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttWhiteSpace) {
				foundFormattingElements.add((org.be.textbe.bttrace.resource.btt.grammar.BttWhiteSpace) printElement);
			}
			if (printElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttLineBreak) {
				foundFormattingElements.add((org.be.textbe.bttrace.resource.btt.grammar.BttLineBreak) printElement);
			}
			for (org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				foundSomethingToPrint |= printTree(childDecorator, eObject, foundFormattingElements, layoutInformations);
				org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement decoratedElement = decorator.getDecoratedElement();
				if (foundSomethingToPrint && decoratedElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttChoice) {
					break;
				}
			}
			if (cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.ONE || cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.QUESTIONMARK) {
				break;
			} else if (!foundSomethingToPrint) {
				break;
			}
		}
		// only print formatting elements if a feature was printed or the syntax element
		// is mandatory
		if (!foundSomethingAtAll && (cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.STAR || cardinality == org.be.textbe.bttrace.resource.btt.grammar.BttCardinality.QUESTIONMARK)) {
			foundFormattingElements.clear();
			foundFormattingElements.addAll(cloned);
		}
		return foundSomethingToPrint;
	}
	
	public void printKeyword(org.eclipse.emf.ecore.EObject eObject, org.be.textbe.bttrace.resource.btt.grammar.BttKeyword keyword, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations) {
		org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, keyword, null, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		String value = keyword.getValue();
		tokenOutputStream.add(new PrintToken(value, "'" + org.be.textbe.bttrace.resource.btt.util.BttStringUtil.escapeToANTLRKeyword(value) + "'"));
	}
	
	public void printFeature(org.eclipse.emf.ecore.EObject eObject, org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder placeholder, int count, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature feature = placeholder.getFeature();
		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			printAttribute(eObject, (org.eclipse.emf.ecore.EAttribute) feature, placeholder, count, foundFormattingElements, layoutInformations);
		} else {
			printReference(eObject, (org.eclipse.emf.ecore.EReference) feature, placeholder, count, foundFormattingElements, layoutInformations);
		}
	}
	
	public void printAttribute(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EAttribute attribute, org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder placeholder, int count, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations) {
		String result;
		Object attributeValue = getValue(eObject, attribute, count);
		org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the attribute is deresolved to obtain its textual
			// representation
			org.be.textbe.bttrace.resource.btt.IBttTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());
			tokenResolver.setOptions(getOptions());
			String deResolvedValue = tokenResolver.deResolve(attributeValue, attribute, eObject);
			result = deResolvedValue;
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, placeholder.getTokenName()));
		}
	}
	
	
	public void printBooleanTerminal(org.eclipse.emf.ecore.EObject eObject, org.be.textbe.bttrace.resource.btt.grammar.BttBooleanTerminal booleanTerminal, int count, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EAttribute attribute = booleanTerminal.getAttribute();
		String result;
		Object attributeValue = getValue(eObject, attribute, count);
		org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, booleanTerminal, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the boolean attribute is converted to its textual
			// representation using the literals of the boolean terminal
			if (Boolean.TRUE.equals(attributeValue)) {
				result = booleanTerminal.getTrueLiteral();
			} else {
				result = booleanTerminal.getFalseLiteral();
			}
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, "'" + org.be.textbe.bttrace.resource.btt.util.BttStringUtil.escapeToANTLRKeyword(result) + "'"));
		}
	}
	
	
	public void printEnumerationTerminal(org.eclipse.emf.ecore.EObject eObject, org.be.textbe.bttrace.resource.btt.grammar.BttEnumerationTerminal enumTerminal, int count, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EAttribute attribute = enumTerminal.getAttribute();
		String result;
		Object attributeValue = getValue(eObject, attribute, count);
		org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, enumTerminal, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the enumeration attribute is converted to its textual
			// representation using the literals of the enumeration terminal
			assert attributeValue instanceof org.eclipse.emf.common.util.Enumerator;
			result = enumTerminal.getText(((org.eclipse.emf.common.util.Enumerator) attributeValue).getName());
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, "'" + org.be.textbe.bttrace.resource.btt.util.BttStringUtil.escapeToANTLRKeyword(result) + "'"));
		}
	}
	
	
	public void printContainedObject(org.eclipse.emf.ecore.EObject eObject, org.be.textbe.bttrace.resource.btt.grammar.BttContainment containment, int count, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature reference = containment.getFeature();
		Object o = getValue(eObject, reference, count);
		// save current number of tabs to restore them after printing the contained object
		int oldTabsBeforeCurrentObject = tabsBeforeCurrentObject;
		int oldCurrentTabs = currentTabs;
		// use current number of tabs to indent contained object. we do not directly set
		// 'tabsBeforeCurrentObject' because the first element of the new object must be
		// printed with the old number of tabs.
		startedPrintingContainedObject = false;
		currentTabs = 0;
		doPrint((org.eclipse.emf.ecore.EObject) o, foundFormattingElements);
		// restore number of tabs after printing the contained object
		tabsBeforeCurrentObject = oldTabsBeforeCurrentObject;
		currentTabs = oldCurrentTabs;
	}
	
	public void printFormattingElements(java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations, org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation layoutInformation) {
		String hiddenTokenText = getHiddenTokenText(layoutInformation);
		if (hiddenTokenText != null) {
			// removed used information
			if (layoutInformations != null) {
				layoutInformations.remove(layoutInformation);
			}
			tokenOutputStream.add(new PrintToken(hiddenTokenText, null));
			foundFormattingElements.clear();
			startedPrintingObject = false;
			setTabsBeforeCurrentObject(0);
			return;
		}
		int printedTabs = 0;
		if (foundFormattingElements.size() > 0) {
			for (org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement foundFormattingElement : foundFormattingElements) {
				if (foundFormattingElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttWhiteSpace) {
					int amount = ((org.be.textbe.bttrace.resource.btt.grammar.BttWhiteSpace) foundFormattingElement).getAmount();
					for (int i = 0; i < amount; i++) {
						tokenOutputStream.add(SPACE_TOKEN);
					}
				}
				if (foundFormattingElement instanceof org.be.textbe.bttrace.resource.btt.grammar.BttLineBreak) {
					currentTabs = ((org.be.textbe.bttrace.resource.btt.grammar.BttLineBreak) foundFormattingElement).getTabs();
					printedTabs += currentTabs;
					tokenOutputStream.add(NEW_LINE_TOKEN);
					for (int i = 0; i < tabsBeforeCurrentObject + currentTabs; i++) {
						tokenOutputStream.add(TAB_TOKEN);
					}
				}
			}
			foundFormattingElements.clear();
			startedPrintingObject = false;
		} else {
			if (startedPrintingObject) {
				// if no elements have been printed yet, we do not add the default token space,
				// because spaces before the first element are not desired.
				startedPrintingObject = false;
			} else {
				if (!handleTokenSpaceAutomatically) {
					tokenOutputStream.add(new PrintToken(getWhiteSpaceString(tokenSpace), null));
				}
			}
		}
		// after printing the first element, we can use the new number of tabs.
		setTabsBeforeCurrentObject(printedTabs);
	}
	
	private void setTabsBeforeCurrentObject(int tabs) {
		if (startedPrintingContainedObject) {
			return;
		}
		tabsBeforeCurrentObject = tabsBeforeCurrentObject + tabs;
		startedPrintingContainedObject = true;
	}
	
	private Object getValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int count) {
		// get value of feature
		Object o = eObject.eGet(feature);
		if (o instanceof java.util.List<?>) {
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			o = list.get(index);
		}
		return o;
	}
	
	@SuppressWarnings("unchecked")	
	public void printReference(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EReference reference, org.be.textbe.bttrace.resource.btt.grammar.BttPlaceholder placeholder, int count, java.util.List<org.be.textbe.bttrace.resource.btt.grammar.BttFormattingElement> foundFormattingElements, java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations) {
		String tokenName = placeholder.getTokenName();
		Object referencedObject = getValue(eObject, reference, count);
		// first add layout before the reference
		org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, referencedObject, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		// proxy objects must be printed differently
		String deresolvedReference = null;
		if (referencedObject instanceof org.eclipse.emf.ecore.EObject) {
			org.eclipse.emf.ecore.EObject eObjectToDeResolve = (org.eclipse.emf.ecore.EObject) referencedObject;
			if (eObjectToDeResolve.eIsProxy()) {
				deresolvedReference = ((org.eclipse.emf.ecore.InternalEObject) eObjectToDeResolve).eProxyURI().fragment();
				if (deresolvedReference != null && deresolvedReference.startsWith(org.be.textbe.bttrace.resource.btt.IBttContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
					deresolvedReference = deresolvedReference.substring(org.be.textbe.bttrace.resource.btt.IBttContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
					deresolvedReference = deresolvedReference.substring(deresolvedReference.indexOf("_") + 1);
				}
			}
		}
		if (deresolvedReference == null) {
			// NC-References must always be printed by deresolving the reference. We cannot
			// use the visible token information, because deresolving usually depends on
			// attribute values of the referenced object instead of the object itself.
			@SuppressWarnings("rawtypes")			
			org.be.textbe.bttrace.resource.btt.IBttReferenceResolver referenceResolver = getReferenceResolverSwitch().getResolver(reference);
			referenceResolver.setOptions(getOptions());
			deresolvedReference = referenceResolver.deResolve((org.eclipse.emf.ecore.EObject) referencedObject, eObject, reference);
		}
		org.be.textbe.bttrace.resource.btt.IBttTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
		tokenResolver.setOptions(getOptions());
		String deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);
		// write result to output stream
		tokenOutputStream.add(new PrintToken(deresolvedToken, tokenName));
	}
	
	public java.util.Map<String, Integer> initializePrintCountingMap(org.eclipse.emf.ecore.EObject eObject) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>();
		java.util.List<org.eclipse.emf.ecore.EStructuralFeature> features = eObject.eClass().getEAllStructuralFeatures();
		for (org.eclipse.emf.ecore.EStructuralFeature feature : features) {
			int count = 0;
			Object featureValue = eObject.eGet(feature);
			if (featureValue != null) {
				if (featureValue instanceof java.util.List<?>) {
					count = ((java.util.List<?>) featureValue).size();
				} else {
					count = 1;
				}
			}
			printCountingMap.put(feature.getName(), count);
		}
		return printCountingMap;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTextResource getResource() {
		return resource;
	}
	
	protected org.be.textbe.bttrace.resource.btt.mopp.BttReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.be.textbe.bttrace.resource.btt.mopp.BttReferenceResolverSwitch) new org.be.textbe.bttrace.resource.btt.mopp.BttMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.be.textbe.bttrace.resource.btt.IBttTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.be.textbe.bttrace.resource.btt.mopp.BttProblem(errorMessage, org.be.textbe.bttrace.resource.btt.BttEProblemType.PRINT_PROBLEM, org.be.textbe.bttrace.resource.btt.BttEProblemSeverity.WARNING), cause);
	}
	
	protected org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformationAdapter getLayoutInformationAdapter(org.eclipse.emf.ecore.EObject element) {
		for (org.eclipse.emf.common.notify.Adapter adapter : element.eAdapters()) {
			if (adapter instanceof org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformationAdapter) {
				return (org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformationAdapter) adapter;
			}
		}
		org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformationAdapter newAdapter = new org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
	private org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation getLayoutInformation(java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations, org.be.textbe.bttrace.resource.btt.grammar.BttSyntaxElement syntaxElement, Object object, org.eclipse.emf.ecore.EObject container) {
		for (org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation layoutInformation : layoutInformations) {
			if (syntaxElement == layoutInformation.getSyntaxElement()) {
				if (object == null) {
					return layoutInformation;
				} else if (object == layoutInformation.getObject(container)) {
					return layoutInformation;
				}
			}
		}
		return null;
	}
	
	public java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> getCopyOfLayoutInformation(org.eclipse.emf.ecore.EObject eObject) {
		org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// create a copy of the original list of layout information object in order to be
		// able to remove used informations during printing
		java.util.List<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation> layoutInformations = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		return layoutInformations;
	}
	
	private String getHiddenTokenText(org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getHiddenTokenText();
		} else {
			return null;
		}
	}
	
	private String getVisibleTokenText(org.be.textbe.bttrace.resource.btt.mopp.BttLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getVisibleTokenText();
		} else {
			return null;
		}
	}
	
	protected String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < count; i++) {
			result.append(character);
		}
		return result.toString();
	}
	
	public void setHandleTokenSpaceAutomatically(boolean handleTokenSpaceAutomatically) {
		this.handleTokenSpaceAutomatically = handleTokenSpaceAutomatically;
	}
	
	public void setTokenSpace(int tokenSpace) {
		this.tokenSpace = tokenSpace;
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer (as it is).
	 */
	public void printBasic(java.io.PrintWriter writer) throws java.io.IOException {
		for (PrintToken nextToken : tokenOutputStream) {
			writer.write(nextToken.getText());
		}
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer.
	 * 
	 * This methods implements smart whitespace printing. It does so by writing output
	 * to a token stream instead of printing the raw token text to a PrintWriter.
	 * Tokens in this stream hold both the text and the type of the token (i.e., its
	 * name).
	 * 
	 * To decide where whitespace is needed, sequences of successive tokens are
	 * searched that can be printed without separating whitespace. To determine such
	 * groups we start with two successive non-whitespace tokens, concatenate their
	 * text and use the generated ANTLR lexer to split the text. If the resulting
	 * token sequence of the concatenated text is exactly the same as the one that is
	 * to be printed, no whitespace is needed. The tokens in the sequence are checked
	 * both regarding their type and their text. If two tokens successfully form a
	 * group a third one is added and so on.
	 */
	public void printSmart(java.io.PrintWriter writer) throws java.io.IOException {
		// stores the text of the current group of tokens. this text is given to the lexer
		// to check whether it can be correctly scanned.
		StringBuilder currentBlock = new StringBuilder();
		// stores the index of the first token of the current group.
		int currentBlockStart = 0;
		// stores the text that was already successfully checked (i.e., is can be scanned
		// correctly and can thus be printed).
		String validBlock = "";
		for (int i = 0; i < tokenOutputStream.size(); i++) {
			PrintToken tokenI = tokenOutputStream.get(i);
			currentBlock.append(tokenI.getText());
			// if declared or preserved whitespace is found - print block
			if (tokenI.getTokenName() == null) {
				writer.write(currentBlock.toString());
				// reset all values
				currentBlock = new StringBuilder();
				currentBlockStart = i + 1;
				validBlock = "";
				continue;
			}
			// now check whether the current block can be scanned
			org.be.textbe.bttrace.resource.btt.IBttTextScanner scanner = new org.be.textbe.bttrace.resource.btt.mopp.BttMetaInformation().createLexer();
			scanner.setText(currentBlock.toString());
			// retrieve all tokens from scanner and add them to list 'tempTokens'
			java.util.List<org.be.textbe.bttrace.resource.btt.IBttTextToken> tempTokens = new java.util.ArrayList<org.be.textbe.bttrace.resource.btt.IBttTextToken>();
			org.be.textbe.bttrace.resource.btt.IBttTextToken nextToken = scanner.getNextToken();
			while (nextToken != null && nextToken.getText() != null) {
				tempTokens.add(nextToken);
				nextToken = scanner.getNextToken();
			}
			boolean sequenceIsValid = true;
			// check whether the current block was scanned to the same token sequence
			for (int t = 0; t < tempTokens.size(); t++) {
				PrintToken printTokenT = tokenOutputStream.get(currentBlockStart + t);
				org.be.textbe.bttrace.resource.btt.IBttTextToken tempToken = tempTokens.get(t);
				if (!tempToken.getText().equals(printTokenT.getText())) {
					sequenceIsValid = false;
					break;
				}
				String commonTokenName = tempToken.getName();
				String printTokenName = printTokenT.getTokenName();
				if (printTokenName.length() > 2 && printTokenName.startsWith("'") && printTokenName.endsWith("'")) {
					printTokenName = printTokenName.substring(1, printTokenName.length() - 1);
				}
				if (!commonTokenName.equals(printTokenName)) {
					sequenceIsValid = false;
					break;
				}
			}
			if (sequenceIsValid) {
				// sequence is still valid, try adding one more token in the next iteration of the
				// loop
				validBlock += tokenI.getText();
			} else {
				// sequence is not valid, must print whitespace to separate tokens
				// print text that is valid so far
				writer.write(validBlock);
				// print separating whitespace
				writer.write(" ");
				// add current token as initial value for next iteration
				currentBlock = new StringBuilder(tokenI.getText());
				currentBlockStart = i;
				validBlock = tokenI.getText();
			}
		}
		// flush remaining valid text to writer
		writer.write(validBlock);
	}
	
}
