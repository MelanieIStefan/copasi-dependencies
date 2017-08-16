/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 *  Converter for replacing object identifiers.
 <p>
 * <p style='color: #777; font-style: italic'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  It is a class used in
the implementation of extra functionality provided by libSBML.
</p>

 <p>
 * This converter translates all instances of a given identifier (i.e., SBML object 'id'
 * attribute value) of type 'SId' in a {@link Model} to another identifier.  It does this based on a list of source
 * identifiers, translating each one to its corresponding replacement value
 * in a list of replacement identifiers.  It also updates all references to
 * the identifiers so replaced.  (More technically, it replaces all values
 * known as type <code>SIdRef</code> in the SBML Level&nbsp;3 specifications.)
 <p>
 * This converter only searches the global SId namespace for the {@link Model} child of the 
 * {@link SBMLDocument}.  It does not replace any IDs or SIdRefs for LocalParameters, nor
 * does it replace any UnitSIds or UnitSIdRefs.  It likewise does not replace any IDs
 * in a new namespace introduced by a package, such as the PortSId namespace
 * from the Hierarchical Model Composition package, nor any {@link Model} objects that are
 * not the direct child of the {@link SBMLDocument}, such as the ModelDefinitions from 
 * the Hierarchical Model Composition package.
 <p>
 * If, however, a package introduces a new element with an 'id' attribute
 * of type SId, any attribute of type SIdRef, or child of type SIdRef (such as 
 * a new Math child of a package element), those IDs will be replaced if they
 * match a source identifier.
 <p>
 * <h2>Configuration and use of {@link SBMLIdConverter}</h2>
 <p>
 * {@link SBMLIdConverter} is enabled by creating a {@link ConversionProperties} object with
 * the option <code>'renameSIds'</code>, and passing this properties object to
 * {@link SBMLDocument#convert(ConversionProperties)}.
 * The converter accepts two options, and both must
 * be set or else no conversion is performed:
 <p>
 * <ul>
 * <li> <code>'currentIds':</code> A comma-separated list of identifiers to replace.
 * <li> <code>'newIds':</code> A comma-separated list of identifiers to use as the
 * replacements.  The values should correspond one-to-one with the identifiers
 * in <code>'currentIds'</code> that should be replaced.
 *
 * </ul> <p>
 * <p>
 * <h2>General information about the use of SBML converters</h2>
 <p>
 * The use of all the converters follows a similar approach.  First, one
 * creates a {@link ConversionProperties} object and calls
 * {@link ConversionProperties#addOption(ConversionOption)}
 * on this object with one argument: a text string that identifies the desired
 * converter.  (The text string is specific to each converter; consult the
 * documentation for a given converter to find out how it should be enabled.)
 <p>
 * Next, for some converters, the caller can optionally set some
 * converter-specific properties using additional calls to
 * {@link ConversionProperties#addOption(ConversionOption)}.
 * Many converters provide the ability to
 * configure their behavior to some extent; this is realized through the use
 * of properties that offer different options.  The default property values
 * for each converter can be interrogated using the method
 * {@link SBMLConverter#getDefaultProperties()} on the converter class in question .
 <p>
 * Finally, the caller should invoke the method
 * {@link SBMLDocument#convert(ConversionProperties)}
 * with the {@link ConversionProperties} object as an argument.
 <p>
 * <h3>Example of invoking an SBML converter</h3>
 <p>
 * The following code fragment illustrates an example using
 * {@link SBMLReactionConverter}, which is invoked using the option string 
 * <code>'replaceReactions':</code>
 <p>
<pre class='fragment'>
{@link ConversionProperties} props = new {@link ConversionProperties}();
if (props != null) {
  props.addOption('replaceReactions');
} else {
  // Deal with error.
}
</pre>
<p>
 * In the case of {@link SBMLReactionConverter}, there are no options to affect
 * its behavior, so the next step is simply to invoke the converter on
 * an {@link SBMLDocument} object.  Continuing the example code:
 <p>
<pre class='fragment'>
  // Assume that the variable 'document' has been set to an {@link SBMLDocument} object.
  status = document.convert(config);
  if (status != libsbml.LIBSBML_OPERATION_SUCCESS)
  {
    // Handle error somehow.
    System.out.println('Error: conversion failed due to the following:');
    document.printErrors();
  }
</pre>
<p>
 * Here is an example of using a converter that offers an option. The
 * following code invokes {@link SBMLStripPackageConverter} to remove the
 * SBML Level&nbsp;3 <em>Layout</em> package from a model.  It sets the name
 * of the package to be removed by adding a value for the option named
 * <code>'package'</code> defined by that converter:
 <p>
<pre class='fragment'>
{@link ConversionProperties} config = new {@link ConversionProperties}();
if (config != None) {
  config.addOption('stripPackage');
  config.addOption('package', 'layout');
  status = document.convert(config);
  if (status != LIBSBML_OPERATION_SUCCESS) {
    // Handle error somehow.
    System.out.println('Error: unable to strip the Layout package');
    document.printErrors();
  }
} else {
  // Handle error somehow.
  System.out.println('Error: unable to create {@link ConversionProperties} object');
}
</pre>
<p>
 * <h3>Available SBML converters in libSBML</h3>
 <p>
 * LibSBML provides a number of built-in converters; by convention, their
 * names end in <em>Converter</em>. The following are the built-in converters
 * provided by libSBML 5.15.2:
 <p>
 * @copydetails doc_list_of_libsbml_converters
 */

public class SBMLIdConverter extends SBMLConverter {
   private long swigCPtr;

   protected SBMLIdConverter(long cPtr, boolean cMemoryOwn)
   {
     super(libsbmlJNI.SBMLIdConverter_SWIGUpcast(cPtr), cMemoryOwn);
     swigCPtr = cPtr;
   }

   protected static long getCPtr(SBMLIdConverter obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (SBMLIdConverter obj)
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
        libsbmlJNI.delete_SBMLIdConverter(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  
/** * @internal */ public
 static void init() {
    libsbmlJNI.SBMLIdConverter_init();
  }

  
/**
   * Creates a new {@link SBMLIdConverter} object.
   */ public
 SBMLIdConverter() {
    this(libsbmlJNI.new_SBMLIdConverter__SWIG_0(), true);
  }

  
/**
   * Copy constructor; creates a copy of an {@link SBMLIdConverter}
   * object.
   <p>
   * @param obj the {@link SBMLIdConverter} object to copy.
   */ public
 SBMLIdConverter(SBMLIdConverter obj) {
    this(libsbmlJNI.new_SBMLIdConverter__SWIG_1(SBMLIdConverter.getCPtr(obj), obj), true);
  }

  
/**
   * Creates and returns a deep copy of this {@link SBMLIdConverter}
   * object.
   <p>
   * @return a (deep) copy of this converter.
   */ public
 SBMLConverter cloneObject() {
    long cPtr = libsbmlJNI.SBMLIdConverter_cloneObject(swigCPtr, this);
    return (cPtr == 0) ? null : new SBMLIdConverter(cPtr, true);
  }

  
/**
   * Returns <code>true</code> if this converter object's properties match the given
   * properties.
   <p>
   * A typical use of this method involves creating a {@link ConversionProperties}
   * object, setting the options desired, and then calling this method on
   * an {@link SBMLIdConverter} object to find out if the object's
   * property values match the given ones.  This method is also used by
   * {@link SBMLConverterRegistry#getConverterFor(ConversionProperties)}
   * to search across all registered converters for one matching particular
   * properties.
   <p>
   * @param props the properties to match.
   <p>
   * @return <code>true</code> if this converter's properties match, <code>false</code>
   * otherwise.
   */ public
 boolean matchesProperties(ConversionProperties props) {
    return libsbmlJNI.SBMLIdConverter_matchesProperties(swigCPtr, this, ConversionProperties.getCPtr(props), props);
  }

  
/**
   * Perform the conversion.
   <p>
   * This method causes the converter to do the actual conversion work,
   * that is, to convert the {@link SBMLDocument} object set by
   * {@link SBMLConverter#setDocument(SBMLDocument)} and
   * with the configuration options set by
   * {@link SBMLConverter#setProperties(ConversionProperties)}.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_FAILED LIBSBML_OPERATION_FAILED}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_OBJECT LIBSBML_INVALID_OBJECT}
   * <li> {@link libsbmlConstants#LIBSBML_UNEXPECTED_ATTRIBUTE LIBSBML_UNEXPECTED_ATTRIBUTE}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE}
   * </ul>
   */ public
 int convert() {
    return libsbmlJNI.SBMLIdConverter_convert(swigCPtr, this);
  }

  
/**
   * Returns the default properties of this converter.
   <p>
   * A given converter exposes one or more properties that can be adjusted
   * in order to influence the behavior of the converter.  This method
   * returns the <em>default</em> property settings for this converter.  It is
   * meant to be called in order to discover all the settings for the
   * converter object.
   <p>
   * @return the {@link ConversionProperties} object describing the default properties
   * for this converter.
   */ public
 ConversionProperties getDefaultProperties() {
    return new ConversionProperties(libsbmlJNI.SBMLIdConverter_getDefaultProperties(swigCPtr, this), true);
  }

}
