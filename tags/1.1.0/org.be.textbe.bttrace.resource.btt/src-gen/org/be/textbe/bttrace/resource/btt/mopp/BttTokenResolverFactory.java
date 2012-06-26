/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.be.textbe.bttrace.resource.btt.mopp;

/**
 * The BttTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class BttTokenResolverFactory implements org.be.textbe.bttrace.resource.btt.IBttTokenResolverFactory {
	
	private java.util.Map<String, org.be.textbe.bttrace.resource.btt.IBttTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.be.textbe.bttrace.resource.btt.IBttTokenResolver> featureName2CollectInTokenResolver;
	private static org.be.textbe.bttrace.resource.btt.IBttTokenResolver defaultResolver = new org.be.textbe.bttrace.resource.btt.analysis.BttDefaultTokenResolver();
	
	public BttTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.be.textbe.bttrace.resource.btt.IBttTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.be.textbe.bttrace.resource.btt.IBttTokenResolver>();
		registerTokenResolver("INTEGER", new org.be.textbe.bttrace.resource.btt.analysis.BttINTEGERTokenResolver());
		registerTokenResolver("COLORS", new org.be.textbe.bttrace.resource.btt.analysis.BttCOLORSTokenResolver());
		registerTokenResolver("FILE", new org.be.textbe.bttrace.resource.btt.analysis.BttFILETokenResolver());
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.be.textbe.bttrace.resource.btt.IBttTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.be.textbe.bttrace.resource.btt.IBttTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.be.textbe.bttrace.resource.btt.IBttTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.be.textbe.bttrace.resource.btt.IBttTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.be.textbe.bttrace.resource.btt.IBttTokenResolver internalCreateResolver(java.util.Map<String, org.be.textbe.bttrace.resource.btt.IBttTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.be.textbe.bttrace.resource.btt.IBttTokenResolver> resolverMap, String key, org.be.textbe.bttrace.resource.btt.IBttTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
