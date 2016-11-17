/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 *  Set of SBML Level + Version + namespace triples.
 <p>
 * <p style='color: #777; font-style: italic'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  This class is not prescribed by
the SBML specifications, although it is used to implement features
defined in SBML.
</p>

 <p>
 * There are differences in the definitions of components between different
 * SBML Levels, as well as Versions within Levels.  For example, the
 * 'sboTerm' attribute was not introduced until Level&nbsp;2
 * Version&nbsp;2, and then only on certain component classes; the SBML
 * Level&nbsp;2 Version&nbsp;3 specification moved the 'sboTerm' attribute
 * to the {@link SBase} class, thereby allowing nearly all components to have {@link SBO}
 * annotations.  As a result of differences such as those, libSBML needs to
 * track the SBML Level and Version of every object created.
 <p>
 * The purpose of the {@link SBMLNamespaces} object class is to make it easier to
 * communicate SBML Level and Version data between libSBML constructors and
 * other methods.  The {@link SBMLNamespaces} object class tracks 3-tuples
 * (triples) consisting of SBML Level, Version, and the corresponding SBML
 * XML namespace.
 <p>
 * The plural name (SBMLNamespaces) is not a mistake, because in SBML
 * Level&nbsp;3, objects may have extensions added by Level&nbsp;3 packages
 * used by a given model and therefore may have multiple namespaces
 * associated with them; however, until the introduction of SBML
 * Level&nbsp;3, the {@link SBMLNamespaces} object only records one SBML
 * Level/Version/namespace combination at a time.  Most constructors for
 * SBML objects in libSBML take a {@link SBMLNamespaces} object as an argument,
 * thereby allowing the constructor to produce the proper combination of
 * attributes and other internal data structures for the given SBML Level
 * and Version.
 */

public class SBMLNamespaces {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected SBMLNamespaces(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(SBMLNamespaces obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (SBMLNamespaces obj)
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
        libsbmlJNI.delete_SBMLNamespaces(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  /**
   * Equality comparison method for SBMLNamespaces.
   * <p>
   * Because the Java methods for libSBML are actually wrappers around code
   * implemented in C++ and C, certain operations will not behave as
   * expected.  Equality comparison is one such case.  An instance of a
   * libSBML object class is actually a <em>proxy object</em>
   * wrapping the real underlying C/C++ object.  The normal <code>==</code>
   * equality operator in Java will <em>only compare the Java proxy objects</em>,
   * not the underlying native object.  The result is almost never what you
   * want in practical situations.  Unfortunately, Java does not provide a
   * way to override <code>==</code>.
   *  <p>
   * The alternative that must be followed is to use the
   * <code>equals()</code> method.  The <code>equals</code> method on this
   * class overrides the default java.lang.Object one, and performs an
   * intelligent comparison of instances of objects of this class.  The
   * result is an assessment of whether two libSBML Java objects are truly 
   * the same underlying native-code objects.
   *  <p>
   * The use of this method in practice is the same as the use of any other
   * Java <code>equals</code> method.  For example,
   * <em>a</em><code>.equals(</code><em>b</em><code>)</code> returns
   * <code>true</code> if <em>a</em> and <em>b</em> are references to the
   * same underlying object.
   *
   * @param sb a reference to an object to which the current object
   * instance will be compared
   *
   * @return <code>true</code> if <code>sb</code> refers to the same underlying 
   * native object as this one, <code>false</code> otherwise
   */
  public boolean equals(Object sb)
  {
    if ( this == sb ) 
    {
      return true;
    }
    return swigCPtr == getCPtr((SBMLNamespaces)(sb));
  }

  /**
   * Returns a hashcode for this SBMLNamespaces object.
   *
   * @return a hash code usable by Java methods that need them.
   */
  public int hashCode()
  {
    return (int)(swigCPtr^(swigCPtr>>>32));
  }

  
/**
   * Creates a new {@link SBMLNamespaces} object corresponding to the given SBML
   * <code>level</code> and <code>version</code>.
   <p>
   * <p>
 * {@link SBMLNamespaces} objects are used in libSBML to communicate SBML Level and
 * Version data between constructors and other methods.  The {@link SBMLNamespaces}
 * object class holds triples consisting of SBML Level, Version, and the
 * corresponding SBML XML namespace.  Most constructors for SBML objects in
 * libSBML take a {@link SBMLNamespaces} object as an argument, thereby allowing
 * the constructor to produce the proper combination of attributes and
 * other internal data structures for the given SBML Level and Version.
 <p>
 * The plural name (SBMLNamespaces) is not a mistake, because in SBML
 * Level&nbsp;3, objects may have extensions added by Level&nbsp;3 packages
 * used by a given model and therefore may have multiple namespaces
 * associated with them.  In SBML Levels below Level&nbsp;3, the
 * {@link SBMLNamespaces} object only records one SBML Level/Version/namespace
 * combination at a time.  Most constructors for SBML objects in libSBML
 * take a {@link SBMLNamespaces} object as an argument, thereby allowing the
 * constructor to produce the proper combination of attributes and other
 * internal data structures for the given SBML Level and Version. 
   <p>
   * @param level the SBML level.
   * @param version the SBML version.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 SBMLNamespaces(long level, long version) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_SBMLNamespaces__SWIG_0(level, version), true);
  }

  
/**
   * Creates a new {@link SBMLNamespaces} object corresponding to the given SBML
   * <code>level</code> and <code>version</code>.
   <p>
   * <p>
 * {@link SBMLNamespaces} objects are used in libSBML to communicate SBML Level and
 * Version data between constructors and other methods.  The {@link SBMLNamespaces}
 * object class holds triples consisting of SBML Level, Version, and the
 * corresponding SBML XML namespace.  Most constructors for SBML objects in
 * libSBML take a {@link SBMLNamespaces} object as an argument, thereby allowing
 * the constructor to produce the proper combination of attributes and
 * other internal data structures for the given SBML Level and Version.
 <p>
 * The plural name (SBMLNamespaces) is not a mistake, because in SBML
 * Level&nbsp;3, objects may have extensions added by Level&nbsp;3 packages
 * used by a given model and therefore may have multiple namespaces
 * associated with them.  In SBML Levels below Level&nbsp;3, the
 * {@link SBMLNamespaces} object only records one SBML Level/Version/namespace
 * combination at a time.  Most constructors for SBML objects in libSBML
 * take a {@link SBMLNamespaces} object as an argument, thereby allowing the
 * constructor to produce the proper combination of attributes and other
 * internal data structures for the given SBML Level and Version. 
   <p>
   * @param level the SBML level.
   * @param version the SBML version.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 SBMLNamespaces(long level) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_SBMLNamespaces__SWIG_1(level), true);
  }

  
/**
   * Creates a new {@link SBMLNamespaces} object corresponding to the given SBML
   * <code>level</code> and <code>version</code>.
   <p>
   * <p>
 * {@link SBMLNamespaces} objects are used in libSBML to communicate SBML Level and
 * Version data between constructors and other methods.  The {@link SBMLNamespaces}
 * object class holds triples consisting of SBML Level, Version, and the
 * corresponding SBML XML namespace.  Most constructors for SBML objects in
 * libSBML take a {@link SBMLNamespaces} object as an argument, thereby allowing
 * the constructor to produce the proper combination of attributes and
 * other internal data structures for the given SBML Level and Version.
 <p>
 * The plural name (SBMLNamespaces) is not a mistake, because in SBML
 * Level&nbsp;3, objects may have extensions added by Level&nbsp;3 packages
 * used by a given model and therefore may have multiple namespaces
 * associated with them.  In SBML Levels below Level&nbsp;3, the
 * {@link SBMLNamespaces} object only records one SBML Level/Version/namespace
 * combination at a time.  Most constructors for SBML objects in libSBML
 * take a {@link SBMLNamespaces} object as an argument, thereby allowing the
 * constructor to produce the proper combination of attributes and other
 * internal data structures for the given SBML Level and Version. 
   <p>
   * @param level the SBML level.
   * @param version the SBML version.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 SBMLNamespaces() throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_SBMLNamespaces__SWIG_2(), true);
  }

  
/**
   * (For extensions) Creates a new {@link SBMLNamespaces} object corresponding to
   * the combination of (1) the given SBML <code>level</code> and <code>version</code>, and (2)
   * the given <code>package</code> with the <code>package</code> <code>version</code>.
   <p>
   * <p>
 * {@link SBMLNamespaces} objects are used in libSBML to communicate SBML Level and
 * Version data between constructors and other methods.  The {@link SBMLNamespaces}
 * object class holds triples consisting of SBML Level, Version, and the
 * corresponding SBML XML namespace.  Most constructors for SBML objects in
 * libSBML take a {@link SBMLNamespaces} object as an argument, thereby allowing
 * the constructor to produce the proper combination of attributes and
 * other internal data structures for the given SBML Level and Version.
 <p>
 * The plural name (SBMLNamespaces) is not a mistake, because in SBML
 * Level&nbsp;3, objects may have extensions added by Level&nbsp;3 packages
 * used by a given model and therefore may have multiple namespaces
 * associated with them.  In SBML Levels below Level&nbsp;3, the
 * {@link SBMLNamespaces} object only records one SBML Level/Version/namespace
 * combination at a time.  Most constructors for SBML objects in libSBML
 * take a {@link SBMLNamespaces} object as an argument, thereby allowing the
 * constructor to produce the proper combination of attributes and other
 * internal data structures for the given SBML Level and Version. 
   <p>
   * @param level   the SBML Level.
   * @param version the SBML Version.
   * @param pkgName the string of package name (e.g. 'layout', 'multi').
   * @param pkgVersion the package version.
   * @param pkgPrefix the prefix of the package namespace (e.g. 'layout', 'multi') to be added.
   *        The package's name will be used if the given string is empty (default).
   <p>
   * @throws SBMLExtensionException if the extension module that supports the
   * combination of the given SBML Level, SBML Version, package name, and
   * package version has not been registered with libSBML.
   */ public
 SBMLNamespaces(long level, long version, String pkgName, long pkgVersion, String pkgPrefix) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_SBMLNamespaces__SWIG_3(level, version, pkgName, pkgVersion, pkgPrefix), true);
  }

  
/**
   * (For extensions) Creates a new {@link SBMLNamespaces} object corresponding to
   * the combination of (1) the given SBML <code>level</code> and <code>version</code>, and (2)
   * the given <code>package</code> with the <code>package</code> <code>version</code>.
   <p>
   * <p>
 * {@link SBMLNamespaces} objects are used in libSBML to communicate SBML Level and
 * Version data between constructors and other methods.  The {@link SBMLNamespaces}
 * object class holds triples consisting of SBML Level, Version, and the
 * corresponding SBML XML namespace.  Most constructors for SBML objects in
 * libSBML take a {@link SBMLNamespaces} object as an argument, thereby allowing
 * the constructor to produce the proper combination of attributes and
 * other internal data structures for the given SBML Level and Version.
 <p>
 * The plural name (SBMLNamespaces) is not a mistake, because in SBML
 * Level&nbsp;3, objects may have extensions added by Level&nbsp;3 packages
 * used by a given model and therefore may have multiple namespaces
 * associated with them.  In SBML Levels below Level&nbsp;3, the
 * {@link SBMLNamespaces} object only records one SBML Level/Version/namespace
 * combination at a time.  Most constructors for SBML objects in libSBML
 * take a {@link SBMLNamespaces} object as an argument, thereby allowing the
 * constructor to produce the proper combination of attributes and other
 * internal data structures for the given SBML Level and Version. 
   <p>
   * @param level   the SBML Level.
   * @param version the SBML Version.
   * @param pkgName the string of package name (e.g. 'layout', 'multi').
   * @param pkgVersion the package version.
   * @param pkgPrefix the prefix of the package namespace (e.g. 'layout', 'multi') to be added.
   *        The package's name will be used if the given string is empty (default).
   <p>
   * @throws SBMLExtensionException if the extension module that supports the
   * combination of the given SBML Level, SBML Version, package name, and
   * package version has not been registered with libSBML.
   */ public
 SBMLNamespaces(long level, long version, String pkgName, long pkgVersion) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_SBMLNamespaces__SWIG_4(level, version, pkgName, pkgVersion), true);
  }

  
/**
   * Copy constructor; creates a copy of a {@link SBMLNamespaces}.
   <p>
   * @param orig the {@link SBMLNamespaces} instance to copy.
   */ public
 SBMLNamespaces(SBMLNamespaces orig) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_SBMLNamespaces__SWIG_5(SBMLNamespaces.getCPtr(orig), orig), true);
  }

  
/**
   * Creates and returns a deep copy of this {@link SBMLNamespaces} object.
   <p>
   * @return the (deep) copy of this {@link SBMLNamespaces} object.
   */ public
 SBMLNamespaces cloneObject() {
  return libsbml.DowncastSBMLNamespaces(libsbmlJNI.SBMLNamespaces_cloneObject(swigCPtr, this), true);
}

  
/**
   * Returns a string representing the SBML XML namespace for the 
   * given <code>level</code> and <code>version</code> of SBML.
   <p>
   * @param level the SBML level.
   * @param version the SBML version.
   <p>
   * @return a string representing the SBML namespace that reflects the
   * SBML Level and Version specified.
   <p>
   * 
   */ public
 static String getSBMLNamespaceURI(long level, long version) {
    return libsbmlJNI.SBMLNamespaces_getSBMLNamespaceURI(level, version);
  }

  
/**
   * Returns a list of all supported {@link SBMLNamespaces} in this version of 
   * libsbml. 
   <p>
   * @return a list with supported SBML namespaces.
   <p>
   * 
   */ public
 static  SBMLNamespacesList  getSupportedNamespaces() { 
  long cPtr = libsbmlJNI.SBMLNamespaces_getSupportedNamespaces();
  return (cPtr == 0) ? null : new  SBMLNamespacesList(cPtr, true);
}

  
/**
   * Frees the list of supported namespaces as generated by
   * getSupportedNamespaces().
   <p>
   * @param supportedNS the list to be freed.
   <p>
   * 
   */ public
 static void freeSBMLNamespaces(SWIGTYPE_p_List supportedNS) {
    libsbmlJNI.SBMLNamespaces_freeSBMLNamespaces(SWIGTYPE_p_List.getCPtr(supportedNS));
  }

  
/**
   * Returns a string representing the SBML XML namespace of this
   * object.
   <p>
   * @return a string representing the SBML namespace that reflects the
   * SBML Level and Version of this object.
   */ public
 String getURI() {
    return libsbmlJNI.SBMLNamespaces_getURI(swigCPtr, this);
  }

  
/**
   * Get the SBML Level of this {@link SBMLNamespaces} object.
   <p>
   * @return the SBML Level of this {@link SBMLNamespaces} object.
   */ public
 long getLevel() {
    return libsbmlJNI.SBMLNamespaces_getLevel__SWIG_0(swigCPtr, this);
  }

  
/**
   * Get the SBML Version of this {@link SBMLNamespaces} object.
   <p>
   * @return the SBML Version of this {@link SBMLNamespaces} object.
   */ public
 long getVersion() {
    return libsbmlJNI.SBMLNamespaces_getVersion__SWIG_0(swigCPtr, this);
  }

  
/**
   * Get the XML namespaces list for this {@link SBMLNamespaces} object.
   <p>
   * <p>
 * {@link SBMLNamespaces} objects are used in libSBML to communicate SBML Level and
 * Version data between constructors and other methods.  The {@link SBMLNamespaces}
 * object class holds triples consisting of SBML Level, Version, and the
 * corresponding SBML XML namespace.  Most constructors for SBML objects in
 * libSBML take a {@link SBMLNamespaces} object as an argument, thereby allowing
 * the constructor to produce the proper combination of attributes and
 * other internal data structures for the given SBML Level and Version.
 <p>
 * The plural name (SBMLNamespaces) is not a mistake, because in SBML
 * Level&nbsp;3, objects may have extensions added by Level&nbsp;3 packages
 * used by a given model and therefore may have multiple namespaces
 * associated with them.  In SBML Levels below Level&nbsp;3, the
 * {@link SBMLNamespaces} object only records one SBML Level/Version/namespace
 * combination at a time.  Most constructors for SBML objects in libSBML
 * take a {@link SBMLNamespaces} object as an argument, thereby allowing the
 * constructor to produce the proper combination of attributes and other
 * internal data structures for the given SBML Level and Version.
   <p>
   * @return the XML namespaces of this {@link SBMLNamespaces} object.
   */ public
 XMLNamespaces getNamespaces() {
    long cPtr = libsbmlJNI.SBMLNamespaces_getNamespaces__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new XMLNamespaces(cPtr, false);
  }

  
/**
   * Add the given XML namespaces list to the set of namespaces within this
   * {@link SBMLNamespaces} object.
   <p>
   * The following code gives an example of how one could add the XHTML
   * namespace to the list of namespaces recorded by the top-level
   * <code>&lt;sbml&gt;</code> element of a model.  It gives the new
   * namespace a prefix of <code>html</code>.
   <p>
<pre class='fragment'>
{@link SBMLDocument} sd;
try
{
    sd = new {@link SBMLDocument}(3, 1);
}
catch (SBMLConstructorException e)
{
    // Here, have code to handle a truly exceptional situation. Candidate
    // causes include invalid combinations of SBML Level and Version
    // (impossible if hardwired as given here), running out of memory, and
    // unknown system exceptions.
}

{@link SBMLNamespaces} sn = sd.getNamespaces();
if (sn != null)
{
    sn.add('http://www.w3.org/1999/xhtml', 'html');
}
else
{
    // Handle another truly exceptional situation.
 }
</pre>
<p>
   * @param xmlns the XML namespaces to be added.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_FAILED LIBSBML_OPERATION_FAILED}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_OBJECT LIBSBML_INVALID_OBJECT}
   * </ul>
   */ public
 int addNamespaces(XMLNamespaces xmlns) {
    return libsbmlJNI.SBMLNamespaces_addNamespaces(swigCPtr, this, XMLNamespaces.getCPtr(xmlns), xmlns);
  }

  
/**
   * Add an XML namespace (a pair of URI and prefix) to the set of namespaces
   * within this {@link SBMLNamespaces} object.
   <p>
   * @param uri    the XML namespace to be added.
   * @param prefix the prefix of the namespace to be added.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_FAILED LIBSBML_OPERATION_FAILED}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_OBJECT LIBSBML_INVALID_OBJECT}
   * </ul>
   */ public
 int addNamespace(String uri, String prefix) {
    return libsbmlJNI.SBMLNamespaces_addNamespace(swigCPtr, this, uri, prefix);
  }

  
/**
   * Removes an XML namespace from the set of namespaces within this 
   * {@link SBMLNamespaces} object.
   <p>
   * @param uri    the XML namespace to be added.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_INDEX_EXCEEDS_SIZE LIBSBML_INDEX_EXCEEDS_SIZE}
   * </ul>
   */ public
 int removeNamespace(String uri) {
    return libsbmlJNI.SBMLNamespaces_removeNamespace(swigCPtr, this, uri);
  }

  
/**
   * Add an XML namespace (a pair of URI and prefix) of a package extension
   * to the set of namespaces within this {@link SBMLNamespaces} object.
   <p>
   * The SBML Level and SBML Version of this object is used.
   <p>
   * @param pkgName the string of package name (e.g. 'layout', 'multi').
   * @param pkgVersion the package version.
   * @param prefix the prefix of the package namespace to be added.
   *        The package's name will be used if the given string is empty (default).
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE}
   *
   * </ul> <p>
   * @note An XML namespace of a non-registered package extension can't be
   * added by this function ({@link libsbmlConstants#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE} 
   * will be returned).
   <p>
   * @see #addNamespace(String, String)
   */ public
 int addPackageNamespace(String pkgName, long pkgVersion, String prefix) {
    return libsbmlJNI.SBMLNamespaces_addPackageNamespace__SWIG_0(swigCPtr, this, pkgName, pkgVersion, prefix);
  }

  
/**
   * Add an XML namespace (a pair of URI and prefix) of a package extension
   * to the set of namespaces within this {@link SBMLNamespaces} object.
   <p>
   * The SBML Level and SBML Version of this object is used.
   <p>
   * @param pkgName the string of package name (e.g. 'layout', 'multi').
   * @param pkgVersion the package version.
   * @param prefix the prefix of the package namespace to be added.
   *        The package's name will be used if the given string is empty (default).
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE}
   *
   * </ul> <p>
   * @note An XML namespace of a non-registered package extension can't be
   * added by this function ({@link libsbmlConstants#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE} 
   * will be returned).
   <p>
   * @see #addNamespace(String, String)
   */ public
 int addPackageNamespace(String pkgName, long pkgVersion) {
    return libsbmlJNI.SBMLNamespaces_addPackageNamespace__SWIG_1(swigCPtr, this, pkgName, pkgVersion);
  }

  
/**
   * Add the XML namespaces of package extensions in the given XMLNamespace
   * object to the set of namespaces within this {@link SBMLNamespaces} object
   * (Non-package XML namespaces are not added by this function).
   <p>
   * @param xmlns the XML namespaces to be added.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE}
   *
   * </ul> <p>
   * @note XML namespaces of a non-registered package extensions are not
   * added (just ignored) by this function. {@link libsbmlConstants#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE} will be returned if the given
   * xmlns is null.
   */ public
 int addPackageNamespaces(XMLNamespaces xmlns) {
    return libsbmlJNI.SBMLNamespaces_addPackageNamespaces(swigCPtr, this, XMLNamespaces.getCPtr(xmlns), xmlns);
  }

  
/**
   * Removes an XML namespace of a package extension from the set of namespaces 
   * within this {@link SBMLNamespaces} object.
   <p>
   * @param level   the SBML level.
   * @param version the SBML version.
   * @param pkgName the string of package name (e.g. 'layout', 'multi').
   * @param pkgVersion the package version.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE}
   * <li> {@link libsbmlConstants#LIBSBML_INDEX_EXCEEDS_SIZE LIBSBML_INDEX_EXCEEDS_SIZE}
   * </ul>
   */ public
 int removePackageNamespace(long level, long version, String pkgName, long pkgVersion) {
    return libsbmlJNI.SBMLNamespaces_removePackageNamespace(swigCPtr, this, level, version, pkgName, pkgVersion);
  }

  
/** * @internal */ public
 int addPkgNamespace(String pkgName, long pkgVersion, String prefix) {
    return libsbmlJNI.SBMLNamespaces_addPkgNamespace__SWIG_0(swigCPtr, this, pkgName, pkgVersion, prefix);
  }

  
/** * @internal */ public
 int addPkgNamespace(String pkgName, long pkgVersion) {
    return libsbmlJNI.SBMLNamespaces_addPkgNamespace__SWIG_1(swigCPtr, this, pkgName, pkgVersion);
  }

  
/** * @internal */ public
 int addPkgNamespaces(XMLNamespaces xmlns) {
    return libsbmlJNI.SBMLNamespaces_addPkgNamespaces(swigCPtr, this, XMLNamespaces.getCPtr(xmlns), xmlns);
  }

  
/** * @internal */ public
 int removePkgNamespace(long level, long version, String pkgName, long pkgVersion) {
    return libsbmlJNI.SBMLNamespaces_removePkgNamespace(swigCPtr, this, level, version, pkgName, pkgVersion);
  }

  
/**
   * Predicate returning <code>true</code> if the given URL is one of SBML XML
   * namespaces.
   <p>
   * @param uri the URI of namespace.
   <p>
   * @return <code>true</code> if the 'uri' is one of SBML namespaces, <code>false</code> otherwise.
   <p>
   * 
   */ public
 static boolean isSBMLNamespace(String uri) {
    return libsbmlJNI.SBMLNamespaces_isSBMLNamespace(uri);
  }

  
/**
   * Predicate returning <code>true</code> if the given set of namespaces represent a
   * valid set
   <p>
   * @return <code>true</code> if the set of namespaces is valid, <code>false</code> otherwise.
   */ public
 boolean isValidCombination() {
    return libsbmlJNI.SBMLNamespaces_isValidCombination(swigCPtr, this);
  }

  
/**
   * Returns the name of the main package for this namespace.
   <p>
   * @return the name of the main package for this namespace.
   * 'core' will be returned if this namespace is defined in the SBML 
   * core. 
   */ public
 String getPackageName() {
    return libsbmlJNI.SBMLNamespaces_getPackageName(swigCPtr, this);
  }

}
