/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

public class BttMetaInformation implements org.be.textbe.bttrace.resource.btt.IBttMetaInformation {
	
	public String getSyntaxName() {
		return "btt";
	}
	
	public String getURI() {
		return "http://org.be.textbe/textbttrace";
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTextScanner createLexer() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttAntlrScanner(new org.be.textbe.bttrace.resource.btt.mopp.BttLexer());
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttParser().createInstance(inputStream, encoding);
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTextPrinter createPrinter(java.io.OutputStream outputStream, org.be.textbe.bttrace.resource.btt.IBttTextResource resource) {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttReferenceResolverSwitch();
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTokenResolverFactory getTokenResolverFactory() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.be.textbe.bttrace.model/metamodel/bttrace.cs";
	}
	
	public String[] getTokenNames() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttParser(null).getTokenNames();
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.be.textbe.bttrace.resource.btt.IBttBracketPair> getBracketPairs() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttResourceFactory();
	}
	
	public org.be.textbe.bttrace.resource.btt.mopp.BttNewFileContentProvider getNewFileContentProvider() {
		return new org.be.textbe.bttrace.resource.btt.mopp.BttNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.be.textbe.bttrace.resource.btt.mopp.BttResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.be.textbe.bttrace.resource.btt.ui.launchConfigurationType";
	}
	
}
