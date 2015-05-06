/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 *  Base node for AST classes.
 * @internal
 */

public class ASTBase {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected ASTBase(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(ASTBase obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (ASTBase obj)
   {
     long ptr = 0;

     if (obj != null)
     {
       ptr             = obj.swigCPtr;
       obj.swigCMemOwn = false;
     }

     return ptr;
   }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libsbmlJNI.delete_ASTBase(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  
/** * @internal */ public
 ASTBase deepCopy() {
  return libsbml.DowncastASTBase(libsbmlJNI.ASTBase_deepCopy(swigCPtr, this), false);
}

  
/** * @internal */ public
 void loadASTPlugins(SBMLNamespaces sbmlns) {
    libsbmlJNI.ASTBase_loadASTPlugins(swigCPtr, this, SBMLNamespaces.getCPtr(sbmlns), sbmlns);
  }

  
/** * @internal */ public
 int getType() {
    return libsbmlJNI.ASTBase_getType(swigCPtr, this);
  }

  
/** * @internal */ public
 int getExtendedType() {
    return libsbmlJNI.ASTBase_getExtendedType(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isSetType() {
    return libsbmlJNI.ASTBase_isSetType(swigCPtr, this);
  }

  
/** * @internal */ public
 int setType(int type) {
    return libsbmlJNI.ASTBase_setType__SWIG_0(swigCPtr, this, type);
  }

  
/** * @internal */ public
 boolean isAvogadro() {
    return libsbmlJNI.ASTBase_isAvogadro(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isBoolean() {
    return libsbmlJNI.ASTBase_isBoolean(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isBinaryFunction() {
    return libsbmlJNI.ASTBase_isBinaryFunction(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isConstant() {
    return libsbmlJNI.ASTBase_isConstant(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isExponential() {
    return libsbmlJNI.ASTBase_isExponential(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isCiNumber() {
    return libsbmlJNI.ASTBase_isCiNumber(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isConstantNumber() {
    return libsbmlJNI.ASTBase_isConstantNumber(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isCSymbolFunction() {
    return libsbmlJNI.ASTBase_isCSymbolFunction(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isCSymbolNumber() {
    return libsbmlJNI.ASTBase_isCSymbolNumber(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isFunction() {
    return libsbmlJNI.ASTBase_isFunction(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isInteger() {
    return libsbmlJNI.ASTBase_isInteger(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isLambda() {
    return libsbmlJNI.ASTBase_isLambda(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isLogical() {
    return libsbmlJNI.ASTBase_isLogical(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isName() {
    return libsbmlJNI.ASTBase_isName(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isNaryFunction() {
    return libsbmlJNI.ASTBase_isNaryFunction(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isNumber() {
    return libsbmlJNI.ASTBase_isNumber(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isOperator() {
    return libsbmlJNI.ASTBase_isOperator(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isPiecewise() {
    return libsbmlJNI.ASTBase_isPiecewise(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isQualifier() {
    return libsbmlJNI.ASTBase_isQualifier(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isRational() {
    return libsbmlJNI.ASTBase_isRational(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isReal() {
    return libsbmlJNI.ASTBase_isReal(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isRelational() {
    return libsbmlJNI.ASTBase_isRelational(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isSemantics() {
    return libsbmlJNI.ASTBase_isSemantics(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isUnaryFunction() {
    return libsbmlJNI.ASTBase_isUnaryFunction(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isUnknown() {
    return libsbmlJNI.ASTBase_isUnknown(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isUserFunction() {
    return libsbmlJNI.ASTBase_isUserFunction(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean representsBvar() {
    return libsbmlJNI.ASTBase_representsBvar(swigCPtr, this);
  }

  
/** * @internal */ public
 int setIsBvar(boolean isbvar) {
    return libsbmlJNI.ASTBase_setIsBvar(swigCPtr, this, isbvar);
  }

  
/** * @internal */ public
 boolean isNumberNode() {
    return libsbmlJNI.ASTBase_isNumberNode(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isFunctionNode() {
    return libsbmlJNI.ASTBase_isFunctionNode(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isTopLevelMathMLFunctionNodeTag(String name) {
    return libsbmlJNI.ASTBase_isTopLevelMathMLFunctionNodeTag(swigCPtr, this, name);
  }

  
/** * @internal */ public
 boolean isTopLevelMathMLNumberNodeTag(String name) {
    return libsbmlJNI.ASTBase_isTopLevelMathMLNumberNodeTag(swigCPtr, this, name);
  }

  
/** * @internal */ public
 void write(XMLOutputStream stream) {
    libsbmlJNI.ASTBase_write(swigCPtr, this, XMLOutputStream.getCPtr(stream), stream);
  }

  
/** * @internal */ public
 boolean read(XMLInputStream stream, String reqd_prefix) {
    return libsbmlJNI.ASTBase_read__SWIG_0(swigCPtr, this, XMLInputStream.getCPtr(stream), stream, reqd_prefix);
  }

  
/** * @internal */ public
 boolean read(XMLInputStream stream) {
    return libsbmlJNI.ASTBase_read__SWIG_1(swigCPtr, this, XMLInputStream.getCPtr(stream), stream);
  }

  
/** * @internal */ public
 void addExpectedAttributes(SWIGTYPE_p_ExpectedAttributes attributes, XMLInputStream stream) {
    libsbmlJNI.ASTBase_addExpectedAttributes(swigCPtr, this, SWIGTYPE_p_ExpectedAttributes.getCPtr(attributes), XMLInputStream.getCPtr(stream), stream);
  }

  
/** * @internal */ public
 boolean readAttributes(XMLAttributes attributes, SWIGTYPE_p_ExpectedAttributes expectedAttributes, XMLInputStream stream, XMLToken element) {
    return libsbmlJNI.ASTBase_readAttributes(swigCPtr, this, XMLAttributes.getCPtr(attributes), attributes, SWIGTYPE_p_ExpectedAttributes.getCPtr(expectedAttributes), XMLInputStream.getCPtr(stream), stream, XMLToken.getCPtr(element), element);
  }

  
/** * @internal */ public
 void logError(XMLInputStream stream, XMLToken element, int code, String msg) {
    libsbmlJNI.ASTBase_logError__SWIG_0(swigCPtr, this, XMLInputStream.getCPtr(stream), stream, XMLToken.getCPtr(element), element, code, msg);
  }

  
/** * @internal */ public
 void logError(XMLInputStream stream, XMLToken element, int code) {
    libsbmlJNI.ASTBase_logError__SWIG_1(swigCPtr, this, XMLInputStream.getCPtr(stream), stream, XMLToken.getCPtr(element), element, code);
  }

  
/** * @internal */ public
 boolean isChild() {
    return libsbmlJNI.ASTBase_isChild(swigCPtr, this);
  }

  
/** * @internal */ public
 void setIsChildFlag(boolean flag) {
    libsbmlJNI.ASTBase_setIsChildFlag(swigCPtr, this, flag);
  }

  
/** * @internal */ public
 String getClassName() {
    return libsbmlJNI.ASTBase_getClassName(swigCPtr, this);
  }

  
/** * @internal */ public
 String getId() {
    return libsbmlJNI.ASTBase_getId(swigCPtr, this);
  }

  
/** * @internal */ public
 String getStyle() {
    return libsbmlJNI.ASTBase_getStyle(swigCPtr, this);
  }

  
/** * @internal */ public
 SBase getParentSBMLObject() {
  return libsbml.DowncastSBase(libsbmlJNI.ASTBase_getParentSBMLObject(swigCPtr, this), false);
}

  
/** * @internal */ public
 boolean isSetClass() {
    return libsbmlJNI.ASTBase_isSetClass(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isSetId() {
    return libsbmlJNI.ASTBase_isSetId(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isSetStyle() {
    return libsbmlJNI.ASTBase_isSetStyle(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isSetParentSBMLObject() {
    return libsbmlJNI.ASTBase_isSetParentSBMLObject(swigCPtr, this);
  }

  
/** * @internal */ public
 int setClassName(String className) {
    return libsbmlJNI.ASTBase_setClassName(swigCPtr, this, className);
  }

  
/** * @internal */ public
 int setId(String id) {
    return libsbmlJNI.ASTBase_setId(swigCPtr, this, id);
  }

  
/** * @internal */ public
 int setStyle(String style) {
    return libsbmlJNI.ASTBase_setStyle(swigCPtr, this, style);
  }

  
/** * @internal */ public
 int unsetClass() {
    return libsbmlJNI.ASTBase_unsetClass(swigCPtr, this);
  }

  
/** * @internal */ public
 int unsetId() {
    return libsbmlJNI.ASTBase_unsetId(swigCPtr, this);
  }

  
/** * @internal */ public
 int unsetStyle() {
    return libsbmlJNI.ASTBase_unsetStyle(swigCPtr, this);
  }

  
/** * @internal */ public
 int unsetParentSBMLObject() {
    return libsbmlJNI.ASTBase_unsetParentSBMLObject(swigCPtr, this);
  }

  
/** * @internal */ public
 ASTBase getFunction() {
  return libsbml.DowncastASTBase(libsbmlJNI.ASTBase_getFunction(swigCPtr, this), false);
}

  
/** * @internal */ public
 void addPlugin(ASTBasePlugin plugin) {
    libsbmlJNI.ASTBase_addPlugin(swigCPtr, this, ASTBasePlugin.getCPtr(plugin), plugin);
  }

  
/** * @internal */ public
 ASTBasePlugin getPlugin(String arg0) {
    long cPtr = libsbmlJNI.ASTBase_getPlugin__SWIG_0(swigCPtr, this, arg0);
    return (cPtr == 0) ? null : new ASTBasePlugin(cPtr, false);
  }

  
/** * @internal */ public
 ASTBasePlugin getPlugin(long n) {
    long cPtr = libsbmlJNI.ASTBase_getPlugin__SWIG_2(swigCPtr, this, n);
    return (cPtr == 0) ? null : new ASTBasePlugin(cPtr, false);
  }

  
/** * @internal */ public
 long getNumPlugins() {
    return libsbmlJNI.ASTBase_getNumPlugins(swigCPtr, this);
  }

  
/** * @internal */ public
 int getTypeFromName(String name) {
    return libsbmlJNI.ASTBase_getTypeFromName(swigCPtr, this, name);
  }

  
/** * @internal */ public
 String getNameFromType(int type) {
    return libsbmlJNI.ASTBase_getNameFromType(swigCPtr, this, type);
  }

  
/** * @internal */ public
 boolean isSetUserData() {
    return libsbmlJNI.ASTBase_isSetUserData(swigCPtr, this);
  }

  
/** * @internal */ public
 int unsetUserData() {
    return libsbmlJNI.ASTBase_unsetUserData(swigCPtr, this);
  }

  
/** * @internal */ public
 void writeNodeOfType(XMLOutputStream stream, int type, boolean inChildNode) {
    libsbmlJNI.ASTBase_writeNodeOfType__SWIG_0(swigCPtr, this, XMLOutputStream.getCPtr(stream), stream, type, inChildNode);
  }

  
/** * @internal */ public
 void writeNodeOfType(XMLOutputStream stream, int type) {
    libsbmlJNI.ASTBase_writeNodeOfType__SWIG_1(swigCPtr, this, XMLOutputStream.getCPtr(stream), stream, type);
  }

  
/** * @internal */ public
 boolean isWellFormedNode() {
    return libsbmlJNI.ASTBase_isWellFormedNode(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean hasCorrectNumberArguments() {
    return libsbmlJNI.ASTBase_hasCorrectNumberArguments(swigCPtr, this);
  }

  
/** * @internal */ public
 int getTypeCode() {
    return libsbmlJNI.ASTBase_getTypeCode(swigCPtr, this);
  }

  
/** * @internal */ public
 String getPackageName() {
    return libsbmlJNI.ASTBase_getPackageName(swigCPtr, this);
  }

  
/** * @internal */ public
 int setPackageName(String name) {
    return libsbmlJNI.ASTBase_setPackageName(swigCPtr, this, name);
  }

  
/** * @internal */ public
 boolean hasCnUnits() {
    return libsbmlJNI.ASTBase_hasCnUnits(swigCPtr, this);
  }

  
/** * @internal */ public
 String getUnitsPrefix() {
    return libsbmlJNI.ASTBase_getUnitsPrefix(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean isPackageInfixFunction() {
    return libsbmlJNI.ASTBase_isPackageInfixFunction(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean hasPackageOnlyInfixSyntax() {
    return libsbmlJNI.ASTBase_hasPackageOnlyInfixSyntax(swigCPtr, this);
  }

  
/** * @internal */ public
 int getL3PackageInfixPrecedence() {
    return libsbmlJNI.ASTBase_getL3PackageInfixPrecedence(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean hasUnambiguousPackageInfixGrammar(ASTNode child) {
    return libsbmlJNI.ASTBase_hasUnambiguousPackageInfixGrammar(swigCPtr, this, ASTNode.getCPtr(child), child);
  }

  
/** * @internal */ public
 double getValue() {
    return libsbmlJNI.ASTBase_getValue(swigCPtr, this);
  }

}
