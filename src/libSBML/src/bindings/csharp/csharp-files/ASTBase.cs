using System;
using System.Runtime.InteropServices;
 
/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

namespace libsbmlcs {

 using System;
 using System.Runtime.InteropServices;

/** 
 * @sbmlpackage{core}
 *
@htmlinclude pkg-marker-core.html Base node for AST classes.
 * @internal
 */

public class ASTBase : IDisposable {
	private HandleRef swigCPtr;
	protected bool swigCMemOwn;
	
	internal ASTBase(IntPtr cPtr, bool cMemoryOwn)
	{
		swigCMemOwn = cMemoryOwn;
		swigCPtr    = new HandleRef(this, cPtr);
	}
	
	internal static HandleRef getCPtr(ASTBase obj)
	{
		return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
	}
	
	internal static HandleRef getCPtrAndDisown (ASTBase obj)
	{
		HandleRef ptr = new HandleRef(null, IntPtr.Zero);
		
		if (obj != null)
		{
			ptr             = obj.swigCPtr;
			obj.swigCMemOwn = false;
		}
		
		return ptr;
	}

  ~ASTBase() {
    Dispose();
  }

  public virtual void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          libsbmlPINVOKE.delete_ASTBase(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
    }
  }

  
/** */ /* libsbml-internal */ public new
 ASTBase deepCopy() {
	ASTBase ret = (ASTBase) libsbml.DowncastASTBase(libsbmlPINVOKE.ASTBase_deepCopy(swigCPtr), false);
	return ret;
}

  
/** */ /* libsbml-internal */ public
 void loadASTPlugins(SBMLNamespaces sbmlns) {
    libsbmlPINVOKE.ASTBase_loadASTPlugins(swigCPtr, SBMLNamespaces.getCPtr(sbmlns));
  }

  
/** */ /* libsbml-internal */ public new
 int getType() {
    int ret = libsbmlPINVOKE.ASTBase_getType(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 int getExtendedType() {
    int ret = libsbmlPINVOKE.ASTBase_getExtendedType(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isSetType() {
    bool ret = libsbmlPINVOKE.ASTBase_isSetType(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 int setType(int type) {
    int ret = libsbmlPINVOKE.ASTBase_setType__SWIG_0(swigCPtr, type);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isAvogadro() {
    bool ret = libsbmlPINVOKE.ASTBase_isAvogadro(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isBoolean() {
    bool ret = libsbmlPINVOKE.ASTBase_isBoolean(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isBinaryFunction() {
    bool ret = libsbmlPINVOKE.ASTBase_isBinaryFunction(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isConstant() {
    bool ret = libsbmlPINVOKE.ASTBase_isConstant(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isExponential() {
    bool ret = libsbmlPINVOKE.ASTBase_isExponential(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isCiNumber() {
    bool ret = libsbmlPINVOKE.ASTBase_isCiNumber(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isConstantNumber() {
    bool ret = libsbmlPINVOKE.ASTBase_isConstantNumber(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isCSymbolFunction() {
    bool ret = libsbmlPINVOKE.ASTBase_isCSymbolFunction(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isCSymbolNumber() {
    bool ret = libsbmlPINVOKE.ASTBase_isCSymbolNumber(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isFunction() {
    bool ret = libsbmlPINVOKE.ASTBase_isFunction(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isInteger() {
    bool ret = libsbmlPINVOKE.ASTBase_isInteger(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isLambda() {
    bool ret = libsbmlPINVOKE.ASTBase_isLambda(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isLogical() {
    bool ret = libsbmlPINVOKE.ASTBase_isLogical(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isName() {
    bool ret = libsbmlPINVOKE.ASTBase_isName(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isNaryFunction() {
    bool ret = libsbmlPINVOKE.ASTBase_isNaryFunction(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isNumber() {
    bool ret = libsbmlPINVOKE.ASTBase_isNumber(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isOperator() {
    bool ret = libsbmlPINVOKE.ASTBase_isOperator(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isPiecewise() {
    bool ret = libsbmlPINVOKE.ASTBase_isPiecewise(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isQualifier() {
    bool ret = libsbmlPINVOKE.ASTBase_isQualifier(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isRational() {
    bool ret = libsbmlPINVOKE.ASTBase_isRational(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isReal() {
    bool ret = libsbmlPINVOKE.ASTBase_isReal(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isRelational() {
    bool ret = libsbmlPINVOKE.ASTBase_isRelational(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isSemantics() {
    bool ret = libsbmlPINVOKE.ASTBase_isSemantics(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isUnaryFunction() {
    bool ret = libsbmlPINVOKE.ASTBase_isUnaryFunction(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isUnknown() {
    bool ret = libsbmlPINVOKE.ASTBase_isUnknown(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isUserFunction() {
    bool ret = libsbmlPINVOKE.ASTBase_isUserFunction(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool representsBvar() {
    bool ret = libsbmlPINVOKE.ASTBase_representsBvar(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 int setIsBvar(bool isbvar) {
    int ret = libsbmlPINVOKE.ASTBase_setIsBvar(swigCPtr, isbvar);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isNumberNode() {
    bool ret = libsbmlPINVOKE.ASTBase_isNumberNode(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isFunctionNode() {
    bool ret = libsbmlPINVOKE.ASTBase_isFunctionNode(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isTopLevelMathMLFunctionNodeTag(string name) {
    bool ret = libsbmlPINVOKE.ASTBase_isTopLevelMathMLFunctionNodeTag(swigCPtr, name);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isTopLevelMathMLNumberNodeTag(string name) {
    bool ret = libsbmlPINVOKE.ASTBase_isTopLevelMathMLNumberNodeTag(swigCPtr, name);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 void write(XMLOutputStream stream) {
    libsbmlPINVOKE.ASTBase_write(swigCPtr, XMLOutputStream.getCPtr(stream));
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
  }

  
/** */ /* libsbml-internal */ public new
 bool read(XMLInputStream stream, string reqd_prefix) {
    bool ret = libsbmlPINVOKE.ASTBase_read__SWIG_0(swigCPtr, XMLInputStream.getCPtr(stream), reqd_prefix);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool read(XMLInputStream stream) {
    bool ret = libsbmlPINVOKE.ASTBase_read__SWIG_1(swigCPtr, XMLInputStream.getCPtr(stream));
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 void addExpectedAttributes(SWIGTYPE_p_ExpectedAttributes attributes, XMLInputStream stream) {
    libsbmlPINVOKE.ASTBase_addExpectedAttributes(swigCPtr, SWIGTYPE_p_ExpectedAttributes.getCPtr(attributes), XMLInputStream.getCPtr(stream));
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
  }

  
/** */ /* libsbml-internal */ public new
 bool readAttributes(XMLAttributes attributes, SWIGTYPE_p_ExpectedAttributes expectedAttributes, XMLInputStream stream, XMLToken element) {
    bool ret = libsbmlPINVOKE.ASTBase_readAttributes(swigCPtr, XMLAttributes.getCPtr(attributes), SWIGTYPE_p_ExpectedAttributes.getCPtr(expectedAttributes), XMLInputStream.getCPtr(stream), XMLToken.getCPtr(element));
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 void logError(XMLInputStream stream, XMLToken element, int code, string msg) {
    libsbmlPINVOKE.ASTBase_logError__SWIG_0(swigCPtr, XMLInputStream.getCPtr(stream), XMLToken.getCPtr(element), code, msg);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
  }

  
/** */ /* libsbml-internal */ public new
 void logError(XMLInputStream stream, XMLToken element, int code) {
    libsbmlPINVOKE.ASTBase_logError__SWIG_1(swigCPtr, XMLInputStream.getCPtr(stream), XMLToken.getCPtr(element), code);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
  }

  public virtual void setIsChildFlag(bool flag) {
    libsbmlPINVOKE.ASTBase_setIsChildFlag(swigCPtr, flag);
  }

  public string getClass() {
    string ret = libsbmlPINVOKE.ASTBase_getClass(swigCPtr);
    return ret;
  }

  public string getId() {
    string ret = libsbmlPINVOKE.ASTBase_getId(swigCPtr);
    return ret;
  }

  public string getStyle() {
    string ret = libsbmlPINVOKE.ASTBase_getStyle(swigCPtr);
    return ret;
  }

  public SBase getParentSBMLObject() {
	SBase ret = (SBase) libsbml.DowncastSBase(libsbmlPINVOKE.ASTBase_getParentSBMLObject(swigCPtr), false);
	return ret;
}

  public bool isSetClass() {
    bool ret = libsbmlPINVOKE.ASTBase_isSetClass(swigCPtr);
    return ret;
  }

  public bool isSetId() {
    bool ret = libsbmlPINVOKE.ASTBase_isSetId(swigCPtr);
    return ret;
  }

  public bool isSetStyle() {
    bool ret = libsbmlPINVOKE.ASTBase_isSetStyle(swigCPtr);
    return ret;
  }

  public bool isSetParentSBMLObject() {
    bool ret = libsbmlPINVOKE.ASTBase_isSetParentSBMLObject(swigCPtr);
    return ret;
  }

  public int setClass(string className) {
    int ret = libsbmlPINVOKE.ASTBase_setClass(swigCPtr, className);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public int setId(string id) {
    int ret = libsbmlPINVOKE.ASTBase_setId(swigCPtr, id);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public int setStyle(string style) {
    int ret = libsbmlPINVOKE.ASTBase_setStyle(swigCPtr, style);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public int unsetClass() {
    int ret = libsbmlPINVOKE.ASTBase_unsetClass(swigCPtr);
    return ret;
  }

  public int unsetId() {
    int ret = libsbmlPINVOKE.ASTBase_unsetId(swigCPtr);
    return ret;
  }

  public int unsetStyle() {
    int ret = libsbmlPINVOKE.ASTBase_unsetStyle(swigCPtr);
    return ret;
  }

  public int unsetParentSBMLObject() {
    int ret = libsbmlPINVOKE.ASTBase_unsetParentSBMLObject(swigCPtr);
    return ret;
  }

  public virtual ASTBase getFunction() {
	ASTBase ret = (ASTBase) libsbml.DowncastASTBase(libsbmlPINVOKE.ASTBase_getFunction(swigCPtr), false);
	return ret;
}

  public virtual void addPlugin(ASTBasePlugin plugin) {
    libsbmlPINVOKE.ASTBase_addPlugin(swigCPtr, ASTBasePlugin.getCPtr(plugin));
  }

  
/** */ /* libsbml-internal */ public new
 ASTBasePlugin getPlugin(string package) {
        ASTBasePlugin ret = (ASTBasePlugin) libsbml.DowncastASTBasePlugin(libsbmlPINVOKE.ASTBase_getPlugin__SWIG_0(swigCPtr, package), false);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
        return ret;
}

  
/** */ /* libsbml-internal */ public new
 ASTBasePlugin getPlugin(long n) {
        ASTBasePlugin ret = (ASTBasePlugin) libsbml.DowncastASTBasePlugin(libsbmlPINVOKE.ASTBase_getPlugin__SWIG_2(swigCPtr, n), false);
        return ret;
}

  
/** */ /* libsbml-internal */ public
 long getNumPlugins() { return (long)libsbmlPINVOKE.ASTBase_getNumPlugins(swigCPtr); }

  
/** */ /* libsbml-internal */ public
 int getTypeFromName(string name) {
    int ret = libsbmlPINVOKE.ASTBase_getTypeFromName(swigCPtr, name);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 string getNameFromType(int type) {
    string ret = libsbmlPINVOKE.ASTBase_getNameFromType(swigCPtr, type);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 bool isSetUserData() {
    bool ret = libsbmlPINVOKE.ASTBase_isSetUserData(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 int unsetUserData() {
    int ret = libsbmlPINVOKE.ASTBase_unsetUserData(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 void writeNodeOfType(XMLOutputStream stream, int type, bool inChildNode) {
    libsbmlPINVOKE.ASTBase_writeNodeOfType__SWIG_0(swigCPtr, XMLOutputStream.getCPtr(stream), type, inChildNode);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
  }

  
/** */ /* libsbml-internal */ public new
 void writeNodeOfType(XMLOutputStream stream, int type) {
    libsbmlPINVOKE.ASTBase_writeNodeOfType__SWIG_1(swigCPtr, XMLOutputStream.getCPtr(stream), type);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
  }

  
/** */ /* libsbml-internal */ public new
 bool isWellFormedNode() {
    bool ret = libsbmlPINVOKE.ASTBase_isWellFormedNode(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool hasCorrectNumberArguments() {
    bool ret = libsbmlPINVOKE.ASTBase_hasCorrectNumberArguments(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 int getTypeCode() {
    int ret = libsbmlPINVOKE.ASTBase_getTypeCode(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 string getPackageName() {
    string ret = libsbmlPINVOKE.ASTBase_getPackageName(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public
 int setPackageName(string name) {
    int ret = libsbmlPINVOKE.ASTBase_setPackageName(swigCPtr, name);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool hasCnUnits() {
    bool ret = libsbmlPINVOKE.ASTBase_hasCnUnits(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 string getUnitsPrefix() {
    string ret = libsbmlPINVOKE.ASTBase_getUnitsPrefix(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool isPackageInfixFunction() {
    bool ret = libsbmlPINVOKE.ASTBase_isPackageInfixFunction(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool hasPackageOnlyInfixSyntax() {
    bool ret = libsbmlPINVOKE.ASTBase_hasPackageOnlyInfixSyntax(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 int getL3PackageInfixPrecedence() {
    int ret = libsbmlPINVOKE.ASTBase_getL3PackageInfixPrecedence(swigCPtr);
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 bool hasUnambiguousPackageInfixGrammar(ASTNode child) {
    bool ret = libsbmlPINVOKE.ASTBase_hasUnambiguousPackageInfixGrammar(swigCPtr, ASTNode.getCPtr(child));
    return ret;
  }

  
/** */ /* libsbml-internal */ public new
 double getValue() {
    double ret = libsbmlPINVOKE.ASTBase_getValue(swigCPtr);
    return ret;
  }

}

}
