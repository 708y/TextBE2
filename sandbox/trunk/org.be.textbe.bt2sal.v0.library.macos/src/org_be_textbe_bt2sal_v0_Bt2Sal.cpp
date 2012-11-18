#include "org_be_textbe_bt2sal_v0_Bt2Sal.h"
#include "TranslateSALMain.h"
#include "NString.h"

JNIEXPORT jstring JNICALL Java_org_be_textbe_bt2sal_v0_Bt2Sal_translateToSal(JNIEnv* env, jobject jobj, jstring strTree, jint iPriority, jint iBuff, jint iWithSets, jstring strSets, jstring strInit){
	CTranslateSALMain cTranslator; 
	// Convert the jstrings to char strings.
	//const char* strConvertedTree = (const char*) strTree;
	//const jchar* strJTree = env->GetStringUTFChars(strTree, NULL); 
	const char* strConvertedTree = env->GetStringUTFChars(strTree, NULL); //(const char*) strJTree;
//	const jchar* strJSets = env->GetStringUTFChars(strSets, NULL); 
	const char* strConvertedSets = env->GetStringUTFChars(strSets, NULL);// = (const char*) strJSets;
//	const jchar* strJInit = env->GetStringUTFChars(strInit, NULL); 
	const char* strConvertedInit = env->GetStringUTFChars(strSets, NULL);// = (const char*) strJInit;
	
	// Call the translator.
	cTranslator.SelectOptions(strConvertedTree, iPriority, iBuff, iWithSets, strConvertedSets, strConvertedInit);
	NString strNResult = cTranslator.ParseBT(0, false, false);
	
	// Convert the result into a jstring.
	static std::string strWResult = strNResult.GetString();
	const char* strFinalResult = strWResult.c_str();
//	const jchar* strJResult = (const jchar*) strFinalResult;
//	unsigned int iLength = wcslen(strFinalResult);
   return env->NewStringUTF(strFinalResult);
//	return strTree;
}
