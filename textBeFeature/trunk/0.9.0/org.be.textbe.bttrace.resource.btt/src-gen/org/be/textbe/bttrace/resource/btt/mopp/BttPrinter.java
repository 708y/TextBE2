/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttPrinter implements org.be.textbe.bttrace.resource.btt.IBttTextPrinter {
	
	protected org.be.textbe.bttrace.resource.btt.IBttTokenResolverFactory tokenResolverFactory = new org.be.textbe.bttrace.resource.btt.mopp.BttTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.be.textbe.bttrace.resource.btt.IBttTextResource resource;
	
	private java.util.Map<?, ?> options;
	
	public BttPrinter(java.io.OutputStream outputStream, org.be.textbe.bttrace.resource.btt.IBttTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.be.textbe.bttrace.TextBTTrace) {
			print_org_be_textbe_bttrace_TextBTTrace((org.be.textbe.bttrace.TextBTTrace) element, globaltab, out);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.BT) {
			print_org_be_textbe_bttrace_BT((org.be.textbe.bttrace.BT) element, globaltab, out);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Delay) {
			print_org_be_textbe_bttrace_Delay((org.be.textbe.bttrace.Delay) element, globaltab, out);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Activate) {
			print_org_be_textbe_bttrace_Activate((org.be.textbe.bttrace.Activate) element, globaltab, out);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Interleave) {
			print_org_be_textbe_bttrace_Interleave((org.be.textbe.bttrace.Interleave) element, globaltab, out);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Trace) {
			print_org_be_textbe_bttrace_Trace((org.be.textbe.bttrace.Trace) element, globaltab, out);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.NodeGroup) {
			print_org_be_textbe_bttrace_NodeGroup((org.be.textbe.bttrace.NodeGroup) element, globaltab, out);
			return;
		}
		if (element instanceof org.be.textbe.bttrace.Node) {
			print_org_be_textbe_bttrace_Node((org.be.textbe.bttrace.Node) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
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
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_org_be_textbe_bttrace_TextBTTrace(org.be.textbe.bttrace.TextBTTrace element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__BT));
		printCountingMap.put("bt", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__DELAY));
		printCountingMap.put("delay", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__ACTIVATE));
		printCountingMap.put("activate", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__INTERLEAVE));
		printCountingMap.put("interleave", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__TRACE));
		printCountingMap.put("trace", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("bt");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__BT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("bt", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("delay");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__DELAY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("delay", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("activate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__ACTIVATE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("activate", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("interleave");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__INTERLEAVE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("interleave", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("trace");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TEXT_BT_TRACE__TRACE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("trace", count - 1);
		}
	}
	
	
	public void print_org_be_textbe_bttrace_BT(org.be.textbe.bttrace.BT element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.BT__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("BT");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.BT__VALUE));
			if (o != null) {
				org.be.textbe.bttrace.resource.btt.IBttTokenResolver resolver = tokenResolverFactory.createTokenResolver("FILE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.BT__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_org_be_textbe_bttrace_Delay(org.be.textbe.bttrace.Delay element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.DELAY__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("DELAY");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.DELAY__VALUE));
			if (o != null) {
				org.be.textbe.bttrace.resource.btt.IBttTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.DELAY__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_org_be_textbe_bttrace_Activate(org.be.textbe.bttrace.Activate element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.ACTIVATE__COLOR));
		printCountingMap.put("color", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("ACTIVATE");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("color");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.ACTIVATE__COLOR));
			if (o != null) {
				org.be.textbe.bttrace.resource.btt.IBttTokenResolver resolver = tokenResolverFactory.createTokenResolver("COLORS");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.ACTIVATE__COLOR), element));
				out.print(" ");
			}
			printCountingMap.put("color", count - 1);
		}
	}
	
	
	public void print_org_be_textbe_bttrace_Interleave(org.be.textbe.bttrace.Interleave element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.INTERLEAVE__COLOR));
		printCountingMap.put("color", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("INTERLEAVE");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("color");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.INTERLEAVE__COLOR));
			if (o != null) {
				org.be.textbe.bttrace.resource.btt.IBttTokenResolver resolver = tokenResolverFactory.createTokenResolver("COLORS");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.INTERLEAVE__COLOR), element));
				out.print(" ");
			}
			printCountingMap.put("color", count - 1);
		}
	}
	
	
	public void print_org_be_textbe_bttrace_Trace(org.be.textbe.bttrace.Trace element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__NODE_GROUP));
		printCountingMap.put("nodeGroup", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__LOOP_NODE_GROUP));
		printCountingMap.put("loopNodeGroup", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"nodeGroup"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"loopNodeGroup"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"nodeGroup"		,
		"loopNodeGroup"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_be_textbe_bttrace_Trace_1(element, localtab, out, printCountingMap);
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_be_textbe_bttrace_Trace_2(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (CompoundDefinition)
			print_org_be_textbe_bttrace_Trace_0(element, localtab, out, printCountingMap);
		}
	}
	
	public void print_org_be_textbe_bttrace_Trace_0(org.be.textbe.bttrace.Trace element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("TRACE");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_be_textbe_bttrace_Trace_0_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_be_textbe_bttrace_Trace_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_org_be_textbe_bttrace_Trace_0_0(org.be.textbe.bttrace.Trace element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("nodeGroup");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__NODE_GROUP));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("nodeGroup", count - 1);
		}
	}
	
	public void print_org_be_textbe_bttrace_Trace_1(org.be.textbe.bttrace.Trace element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("LOOP");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_be_textbe_bttrace_Trace_1_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_be_textbe_bttrace_Trace_1_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_org_be_textbe_bttrace_Trace_1_0(org.be.textbe.bttrace.Trace element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("loopNodeGroup");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__LOOP_NODE_GROUP));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("loopNodeGroup", count - 1);
		}
	}
	
	public void print_org_be_textbe_bttrace_Trace_2(org.be.textbe.bttrace.Trace element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("TRACE");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_be_textbe_bttrace_Trace_2_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_be_textbe_bttrace_Trace_2_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("LOOP");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_be_textbe_bttrace_Trace_2_1(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_be_textbe_bttrace_Trace_2_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_org_be_textbe_bttrace_Trace_2_0(org.be.textbe.bttrace.Trace element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("nodeGroup");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__NODE_GROUP));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("nodeGroup", count - 1);
		}
	}
	
	public void print_org_be_textbe_bttrace_Trace_2_1(org.be.textbe.bttrace.Trace element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("loopNodeGroup");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.TRACE__LOOP_NODE_GROUP));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("loopNodeGroup", count - 1);
		}
	}
	
	
	public void print_org_be_textbe_bttrace_NodeGroup(org.be.textbe.bttrace.NodeGroup element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE_GROUP__ACTIVE_NODE));
		printCountingMap.put("activeNode", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE_GROUP__INTERLEAVE_NODE));
		printCountingMap.put("interleaveNode", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("activeNode");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE_GROUP__ACTIVE_NODE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("activeNode", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_be_textbe_bttrace_NodeGroup_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_org_be_textbe_bttrace_NodeGroup_0(org.be.textbe.bttrace.NodeGroup element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("interleaveNode");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE_GROUP__INTERLEAVE_NODE));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("interleaveNode", count - 1);
		}
	}
	
	
	public void print_org_be_textbe_bttrace_Node(org.be.textbe.bttrace.Node element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE__VALUE));
			if (o != null) {
				org.be.textbe.bttrace.resource.btt.IBttTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.be.textbe.bttrace.BttracePackage.NODE__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
}
