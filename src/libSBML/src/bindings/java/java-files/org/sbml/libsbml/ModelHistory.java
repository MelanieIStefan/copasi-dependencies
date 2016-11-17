/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 *  MIRIAM-compliant data about a model's history.
 <p>
 * <p style='color: #777; font-style: italic'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  This class is not prescribed by
the SBML specifications, although it is used to implement features
defined in SBML.
</p>

 <p>
 * The SBML specification beginning with Level&nbsp;2 Version&nbsp;2 defines
 * a standard approach to recording optional model history and model creator
 * information in a form that complies with MIRIAM (<a target='_blank'
 * href='http://www.nature.com/nbt/journal/v23/n12/abs/nbt1156.html'>'Minimum
 * Information Requested in the Annotation of biochemical Models'</a>,
 * <i>Nature Biotechnology</i>, vol. 23, no. 12, Dec. 2005).  LibSBML
 * provides the {@link ModelHistory} class as a convenient high-level interface for
 * working with model history data.
 <p>
 * {@link Model} histories in SBML consist of one or more <em>model creators</em>,
 * a single date of <em>creation</em>, and one or more <em>modification</em> dates.
 * The overall XML form of this data takes the following form:
 <p>
 <pre class='fragment'>
 &lt;dc:creator&gt;
   &lt;rdf:Bag&gt;
     &lt;rdf:li rdf:parseType='Resource'&gt;
       <span style='background-color: #d0eed0'>+++</span>
       &lt;vCard:N rdf:parseType='Resource'&gt;
         &lt;vCard:Family&gt;<span style='background-color: #bbb'>family name</span>&lt;/vCard:Family&gt;
         &lt;vCard:Given&gt;<span style='background-color: #bbb'>given name</span>&lt;/vCard:Given&gt;
       &lt;/vCard:N&gt;
       <span style='background-color: #d0eed0'>+++</span>
       <span style='border-bottom: 2px dotted #888'>&lt;vCard:EMAIL&gt;<span style='background-color: #bbb'>email address</span>&lt;/vCard:EMAIL&gt;</span>
       <span style='background-color: #d0eed0'>+++</span>
       <span style='border-bottom: 2px dotted #888'>&lt;vCard:ORG rdf:parseType='Resource'&gt;</span>
        <span style='border-bottom: 2px dotted #888'>&lt;vCard:Orgname&gt;<span style='background-color: #bbb'>organization name</span>&lt;/vCard:Orgname&gt;</span>
       <span style='border-bottom: 2px dotted #888'>&lt;/vCard:ORG&gt;</span>
       <span style='background-color: #d0eed0'>+++</span>
     &lt;/rdf:li&gt;
     <span style='background-color: #edd'>...</span>
   &lt;/rdf:Bag&gt;
 &lt;/dc:creator&gt;
 &lt;dcterms:created rdf:parseType='Resource'&gt;
   &lt;dcterms:W3CDTF&gt;<span style='background-color: #bbb'>creation date</span>&lt;/dcterms:W3CDTF&gt;
 &lt;/dcterms:created&gt;
 &lt;dcterms:modified rdf:parseType='Resource'&gt;
   &lt;dcterms:W3CDTF&gt;<span style='background-color: #bbb'>modification date</span>&lt;/dcterms:W3CDTF&gt;
 &lt;/dcterms:modified&gt;
 <span style='background-color: #edd'>...</span>
 </pre>
 <p>
 * In the template above, the <span style='border-bottom: 2px dotted #888'>underlined</span>
 * portions are optional, the symbol
 * <span class='code' style='background-color: #d0eed0'>+++</span> is a placeholder
 * for either no content or valid XML content that is not defined by
 * the annotation scheme, and the ellipses
 * <span class='code' style='background-color: #edd'>...</span>
 * are placeholders for zero or more elements of the same form as the
 * immediately preceding element.  The various placeholders for content, namely
 * <span class='code' style='background-color: #bbb'>family name</span>,
 * <span class='code' style='background-color: #bbb'>given name</span>,
 * <span class='code' style='background-color: #bbb'>email address</span>,
 * <span class='code' style='background-color: #bbb'>organization</span>,
 * <span class='code' style='background-color: #bbb'>creation date</span>, and
 * <span class='code' style='background-color: #bbb'>modification date</span>
 * are data that can be filled in using the various methods on
 * the {@link ModelHistory} class described below.
 <p>
 * @see ModelCreator
 * @see Date
 */

public class ModelHistory {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected ModelHistory(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(ModelHistory obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (ModelHistory obj)
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
        libsbmlJNI.delete_ModelHistory(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  /**
   * Equality comparison method for ModelHistory.
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
    return swigCPtr == getCPtr((ModelHistory)(sb));
  }

  /**
   * Returns a hashcode for this ModelHistory object.
   *
   * @return a hash code usable by Java methods that need them.
   */
  public int hashCode()
  {
    return (int)(swigCPtr^(swigCPtr>>>32));
  }

  
/**
   * Creates a new {@link ModelHistory} object.
   */ public
 ModelHistory() {
    this(libsbmlJNI.new_ModelHistory__SWIG_0(), true);
  }

  
/**
   * Copy constructor; creates a copy of this {@link ModelHistory} object.
   <p>
   * @param orig the object to copy.
   */ public
 ModelHistory(ModelHistory orig) {
    this(libsbmlJNI.new_ModelHistory__SWIG_1(ModelHistory.getCPtr(orig), orig), true);
  }

  
/**
   * Creates and returns a deep copy of this {@link ModelHistory} object.
   <p>
   * @return the (deep) copy of this {@link ModelHistory} object.
   */ public
 ModelHistory cloneObject() {
    long cPtr = libsbmlJNI.ModelHistory_cloneObject(swigCPtr, this);
    return (cPtr == 0) ? null : new ModelHistory(cPtr, true);
  }

  
/**
   * Returns the 'creation date' portion of this {@link ModelHistory} object.
   <p>
   * @return a {@link Date} object representing the creation date stored in
   * this {@link ModelHistory} object.
   */ public
 Date getCreatedDate() {
    long cPtr = libsbmlJNI.ModelHistory_getCreatedDate(swigCPtr, this);
    return (cPtr == 0) ? null : new Date(cPtr, false);
  }

  
/**
   * Returns the 'modified date' portion of this {@link ModelHistory} object.
   <p>
   * Note that in the MIRIAM format for annotations, there can be multiple
   * modification dates.  The libSBML {@link ModelHistory} class supports this by
   * storing a list of 'modified date' values.  If this {@link ModelHistory} object
   * contains more than one 'modified date' value in the list, this method
   * will return the first one in the list.
   <p>
   * @return a {@link Date} object representing the date of modification
   * stored in this {@link ModelHistory} object.
   */ public
 Date getModifiedDate() {
    long cPtr = libsbmlJNI.ModelHistory_getModifiedDate__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new Date(cPtr, false);
  }

  
/**
   * Predicate returning <code>true</code> or <code>false</code> depending on whether this
   * {@link ModelHistory}'s 'creation date' is set.
   <p>
   * @return <code>true</code> if the creation date value of this {@link ModelHistory} is
   * set, <code>false</code> otherwise.
   */ public
 boolean isSetCreatedDate() {
    return libsbmlJNI.ModelHistory_isSetCreatedDate(swigCPtr, this);
  }

  
/**
   * Predicate returning <code>true</code> or <code>false</code> depending on whether this
   * {@link ModelHistory}'s 'modified date' is set.
   <p>
   * @return <code>true</code> if the modification date value of this {@link ModelHistory}
   * object is set, <code>false</code> otherwise.
   */ public
 boolean isSetModifiedDate() {
    return libsbmlJNI.ModelHistory_isSetModifiedDate(swigCPtr, this);
  }

  
/**
   * Sets the creation date of this {@link ModelHistory} object.
   <p>
   * @param date a {@link Date} object representing the date to which the 'created
   * date' portion of this {@link ModelHistory} should be set.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_OBJECT LIBSBML_INVALID_OBJECT}
   * </ul>
   */ public
 int setCreatedDate(Date date) {
    return libsbmlJNI.ModelHistory_setCreatedDate(swigCPtr, this, Date.getCPtr(date), date);
  }

  
/**
   * Sets the modification date of this {@link ModelHistory} object.
   <p>
   * @param date a {@link Date} object representing the date to which the 'modified
   * date' portion of this {@link ModelHistory} should be set.
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
 int setModifiedDate(Date date) {
    return libsbmlJNI.ModelHistory_setModifiedDate(swigCPtr, this, Date.getCPtr(date), date);
  }

  
/**
   * Adds a copy of a {@link Date} object to the list of 'modified date' values
   * stored in this {@link ModelHistory} object.
   <p>
   * In the MIRIAM format for annotations, there can be multiple
   * modification dates.  The libSBML {@link ModelHistory} class supports this by
   * storing a list of 'modified date' values.
   <p>
   * @param date a {@link Date} object representing the 'modified date' that should
   * be added to this {@link ModelHistory} object.
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
 int addModifiedDate(Date date) {
    return libsbmlJNI.ModelHistory_addModifiedDate(swigCPtr, this, Date.getCPtr(date), date);
  }

  
/**
   * Returns the list of 'modified date' values (as {@link Date} objects) stored in
   * this {@link ModelHistory} object.
   <p>
   * In the MIRIAM format for annotations, there can be multiple
   * modification dates.  The libSBML {@link ModelHistory} class supports this by
   * storing a list of 'modified date' values.
   <p>
   * @return the list of modification dates for this {@link ModelHistory} object.
   */ public
  DateList  getListModifiedDates() { 
  long cPtr = libsbmlJNI.ModelHistory_getListModifiedDates(swigCPtr, this);
  return (cPtr == 0) ? null : new  DateList(cPtr, true);
}

  
/**
   * Get the nth {@link Date} object in the list of 'modified date' values stored
   * in this {@link ModelHistory} object.
   <p>
   * In the MIRIAM format for annotations, there can be multiple
   * modification dates.  The libSBML {@link ModelHistory} class supports this by
   * storing a list of 'modified date' values.
   <p>
   * @return the nth {@link Date} in the list of ModifiedDates of this
   * {@link ModelHistory}.
   */ public
 Date getModifiedDate(long n) {
    long cPtr = libsbmlJNI.ModelHistory_getModifiedDate__SWIG_1(swigCPtr, this, n);
    return (cPtr == 0) ? null : new Date(cPtr, false);
  }

  
/**
   * Get the number of {@link Date} objects in this {@link ModelHistory} object's list of
   * 'modified dates'.
   <p>
   * In the MIRIAM format for annotations, there can be multiple
   * modification dates.  The libSBML {@link ModelHistory} class supports this by
   * storing a list of 'modified date' values.
   <p>
   * @return the number of ModifiedDates in this {@link ModelHistory}.
   */ public
 long getNumModifiedDates() {
    return libsbmlJNI.ModelHistory_getNumModifiedDates(swigCPtr, this);
  }

  
/**
   * Adds a copy of a {@link ModelCreator} object to the list of 'model creator'
   * values stored in this {@link ModelHistory} object.
   <p>
   * In the MIRIAM format for annotations, there can be multiple model
   * creators.  The libSBML {@link ModelHistory} class supports this by storing a
   * list of 'model creator' values.
   <p>
   * @param mc the {@link ModelCreator} to add.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_OBJECT LIBSBML_INVALID_OBJECT}
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_FAILED LIBSBML_OPERATION_FAILED}
   * </ul>
   */ public
 int addCreator(ModelCreator mc) {
    return libsbmlJNI.ModelHistory_addCreator(swigCPtr, this, ModelCreator.getCPtr(mc), mc);
  }

  
/**
   * Returns the list of {@link ModelCreator} objects stored in this {@link ModelHistory}
   * object.
   <p>
   * In the MIRIAM format for annotations, there can be multiple model
   * creators.  The libSBML {@link ModelHistory} class supports this by storing a
   * list of 'model creator' values.
   <p>
   * @return the list of {@link ModelCreator} objects.
   */ public
  ModelCreatorList  getListCreators() { 
  long cPtr = libsbmlJNI.ModelHistory_getListCreators(swigCPtr, this);
  return (cPtr == 0) ? null : new  ModelCreatorList(cPtr, true);
}

  
/**
   * Get the nth {@link ModelCreator} object stored in this {@link ModelHistory} object.
   <p>
   * In the MIRIAM format for annotations, there can be multiple model
   * creators.  The libSBML {@link ModelHistory} class supports this by storing a
   * list of 'model creator' values.
   <p>
   * @return the nth {@link ModelCreator} object.
   */ public
 ModelCreator getCreator(long n) {
    long cPtr = libsbmlJNI.ModelHistory_getCreator(swigCPtr, this, n);
    return (cPtr == 0) ? null : new ModelCreator(cPtr, false);
  }

  
/**
   * Get the number of {@link ModelCreator} objects stored in this {@link ModelHistory}
   * object.
   <p>
   * In the MIRIAM format for annotations, there can be multiple model
   * creators.  The libSBML {@link ModelHistory} class supports this by storing a
   * list of 'model creator' values.
   <p>
   * @return the number of ModelCreators objects.
   */ public
 long getNumCreators() {
    return libsbmlJNI.ModelHistory_getNumCreators(swigCPtr, this);
  }

  
/**
   * Predicate returning <code>true</code> if all the required elements for this
   * {@link ModelHistory} object have been set.
   <p>
   * The required elements for a {@link ModelHistory} object are 'created
   * name', 'modified date', and at least one 'model creator'.
   <p>
   * @return a boolean value indicating whether all the required
   * elements for this object have been defined.
   */ public
 boolean hasRequiredAttributes() {
    return libsbmlJNI.ModelHistory_hasRequiredAttributes(swigCPtr, this);
  }

  
/** * @internal */ public
 boolean hasBeenModified() {
    return libsbmlJNI.ModelHistory_hasBeenModified(swigCPtr, this);
  }

  
/** * @internal */ public
 void resetModifiedFlags() {
    libsbmlJNI.ModelHistory_resetModifiedFlags(swigCPtr, this);
  }

}
