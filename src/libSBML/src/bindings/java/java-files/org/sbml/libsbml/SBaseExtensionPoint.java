/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 *  Base class for extending SBML components
 <p>
 * <p style='color: #777; font-style: italic'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  This class is not prescribed by
the SBML specifications, although it is used to implement features
defined in SBML.
</p>

 <p>
 * @internal 
 <p>
 * <p>
 * This class is used as part of the mechanism that connects plugin objects
 * (implemented using {@link SBasePlugin} or {@link SBMLDocumentPlugin}) to a given package
 * extension.  For instance, an implementation of an extended version of
 * {@link Model} (e.g., LayoutModelPlugin in the Layout package) would involve the
 * creation of an extension point using {@link SBaseExtensionPoint} and a mediator
 * object created using SBasePluginCreator, to 'plug' the extended {@link Model}
 * object (LayoutModelPlugin) into the overall LayoutExtension object.
 <p>
 * The use of {@link SBaseExtensionPoint} is relatively straightforward.  The
 * class needs to be used for each extended SBML object implemented using
 * {@link SBMLDocumentPlugin} or {@link SBasePlugin}.  Doing so requires knowing just two
 * things:
 <p>
 * <ul>
 * <li> The short-form name of the <em>parent</em> package being extended.  The
 * parent package is often simply core SBML, identified in libSBML by the
 * nickname <code>'core'</code>, but a SBML Level&nbsp;3 package could
 * conceivably extend another Level&nbsp;3 package.
 <p>
 * <li> The libSBML type code assigned to the object being extended.  For
 * example, if an extension of {@link Model} is implemented, the relevant type code
 * is #SBML_MODEL, found in #SBMLTypeCode_t.
 *
 * </ul> <p>
 * The typical use of {@link SBaseExtensionPoint} is illustrated by the following
 * code fragment:
 <p>
 * <pre class='fragment'>{.cpp}
 * {@link SBaseExtensionPoint} docExtPoint('core', SBML_DOCUMENT);
 * {@link SBaseExtensionPoint} modelExtPoint('core', SBML_MODEL);
 * 
 * SBasePluginCreator&lt;GroupsSBMLDocumentPlugin, GroupsExtension&gt; docPluginCreator(docExtPoint, pkgURIs);
 * SBasePluginCreator&lt;GroupsModelPlugin, GroupsExtension&gt; modelPluginCreator(modelExtPoint, pkgURIs);</pre>
 <p>
 * The code above shows two core SBML components being extended: the
 * document object, and the {@link Model} object.  These extended objects are
 * created elsewhere (not shown) as the
 * <code>GroupsSBMLDocumentPlugin</code> and <code>GroupsModelPlugin</code>
 * objects.  The corresponding {@link SBaseExtensionPoint} objects are handed as
 * arguments to the constructor for SBasePluginCreator to create the
 * connection between the extended core components and the overall package
 * extension (here, for the Groups package, with the
 * <code>GroupsExtension</code> object).
 <p>
 * The code above is typically placed in the implementation of the
 * <code>init()</code> method of the package class derived from
 * {@link SBMLExtension}.  (For the example above, it would be in the
 * <code>GroupsExtension.cpp</code> file.)
 */

public class SBaseExtensionPoint {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected SBaseExtensionPoint(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(SBaseExtensionPoint obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (SBaseExtensionPoint obj)
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
        libsbmlJNI.delete_SBaseExtensionPoint(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  
/**
   * Constructor for {@link SBaseExtensionPoint}.
   <p>
   * The use of {@link SBaseExtensionPoint} is relatively straightforward.  The
   * class needs to be used for each extended SBML object implemented
   * using {@link SBMLDocumentPlugin} or {@link SBasePlugin}.  Doing so requires knowing
   * just two things:
   <p>
   * <ul>
   * <li> The short-form name of the <em>parent</em> package being extended.
   * The parent package is often simply core SBML, identified in libSBML
   * by the nickname <code>'core'</code>, but a SBML Level&nbsp;3
   * package could conceivably extend another Level&nbsp;3 package and
   * the mechanism supports this.
   <p>
   * <li> The libSBML type code assigned to the object being extended.
   * For example, if an extension of {@link Model} is implemented, the relevant
   * type code is SBML_MODEL, found in #SBMLTypeCode_t.
   *
   * </ul> <p>
   * @param pkgName the short-form name of the parent package where
   * that this package extension is extending.
   <p>
   * @param typeCode the type code of the object being extended.
   */ public
 SBaseExtensionPoint(String pkgName, int typeCode) {
    this(libsbmlJNI.new_SBaseExtensionPoint__SWIG_0(pkgName, typeCode), true);
  }

  
/**
  * Constructor for {@link SBaseExtensionPoint}.
  <p>
  * The use of {@link SBaseExtensionPoint} is relatively straightforward.  The
  * class needs to be used for each extended SBML object implemented
  * using {@link SBMLDocumentPlugin} or {@link SBasePlugin}.  Doing so requires knowing
  * just two things:
  <p>
  * <ul>
  * <li> The short-form name of the <em>parent</em> package being extended.
  * The parent package is often simply core SBML, identified in libSBML
  * by the nickname <code>'core'</code>, but a SBML Level&nbsp;3
  * package could conceivably extend another Level&nbsp;3 package and
  * the mechanism supports this.
  <p>
  * <li> The libSBML type code assigned to the object being extended.
  * For example, if an extension of {@link Model} is implemented, the relevant
  * type code is SBML_MODEL, found in #SBMLTypeCode_t.
  *
  * </ul> <p>
  * @param pkgName the short-form name of the parent package where
  * that this package extension is extending.
  <p>
  * @param typeCode the type code of the object being extended.
  <p>
  * @param elementName element name for the target element, in case 
  * multiple elements match the same type code (as will be the case
  * for {@link ListOf} classes).
  <p>
  * @param elementOnly flag to be used during the registration 
  * of the package, when set then the plugin is only applied to 
  * elements whose elementName match.
  */ public
 SBaseExtensionPoint(String pkgName, int typeCode, String elementName, boolean elementOnly) {
    this(libsbmlJNI.new_SBaseExtensionPoint__SWIG_1(pkgName, typeCode, elementName, elementOnly), true);
  }

  
/**
  * Constructor for {@link SBaseExtensionPoint}.
  <p>
  * The use of {@link SBaseExtensionPoint} is relatively straightforward.  The
  * class needs to be used for each extended SBML object implemented
  * using {@link SBMLDocumentPlugin} or {@link SBasePlugin}.  Doing so requires knowing
  * just two things:
  <p>
  * <ul>
  * <li> The short-form name of the <em>parent</em> package being extended.
  * The parent package is often simply core SBML, identified in libSBML
  * by the nickname <code>'core'</code>, but a SBML Level&nbsp;3
  * package could conceivably extend another Level&nbsp;3 package and
  * the mechanism supports this.
  <p>
  * <li> The libSBML type code assigned to the object being extended.
  * For example, if an extension of {@link Model} is implemented, the relevant
  * type code is SBML_MODEL, found in #SBMLTypeCode_t.
  *
  * </ul> <p>
  * @param pkgName the short-form name of the parent package where
  * that this package extension is extending.
  <p>
  * @param typeCode the type code of the object being extended.
  <p>
  * @param elementName element name for the target element, in case 
  * multiple elements match the same type code (as will be the case
  * for {@link ListOf} classes).
  <p>
  * @param elementOnly flag to be used during the registration 
  * of the package, when set then the plugin is only applied to 
  * elements whose elementName match.
  */ public
 SBaseExtensionPoint(String pkgName, int typeCode, String elementName) {
    this(libsbmlJNI.new_SBaseExtensionPoint__SWIG_2(pkgName, typeCode, elementName), true);
  }

  
/**
   * Copy constructor.
   <p>
   * This creates a copy of an {@link SBaseExtensionPoint} instance.
   <p>
   * @param rhs the object to copy.
   */ public
 SBaseExtensionPoint(SBaseExtensionPoint rhs) {
    this(libsbmlJNI.new_SBaseExtensionPoint__SWIG_3(SBaseExtensionPoint.getCPtr(rhs), rhs), true);
  }

  
/**
   * Creates and returns a deep copy of this {@link SBaseExtensionPoint} object.
   <p>
   * @return the (deep) copy of this {@link SBaseExtensionPoint} object.
   */ public
 SBaseExtensionPoint cloneObject() {
    long cPtr = libsbmlJNI.SBaseExtensionPoint_cloneObject(swigCPtr, this);
    return (cPtr == 0) ? null : new SBaseExtensionPoint(cPtr, true);
  }

  
/**
   * Returns the package name of this extension point.
   */ public
 String getPackageName() {
    return libsbmlJNI.SBaseExtensionPoint_getPackageName(swigCPtr, this);
  }

  
/**
   * Returns the libSBML type code of this extension point.
   */ public
 int getTypeCode() {
    return libsbmlJNI.SBaseExtensionPoint_getTypeCode(swigCPtr, this);
  }

  
/**
   * the target element name
   */ public
 String getElementName() {
    return libsbmlJNI.SBaseExtensionPoint_getElementName(swigCPtr, this);
  }

  
/**
   */ public
 boolean isElementOnly() {
    return libsbmlJNI.SBaseExtensionPoint_isElementOnly(swigCPtr, this);
  }

}
