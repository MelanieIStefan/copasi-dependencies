/**
 * @file    CompSBMLDocumentPlugin.h
 * @brief   Definition of CompSBMLDocumentPlugin, the plugin class of
 *          comp package for the Model element.
 * @author  Lucian Smith
 *
 * <!---------------------------------------------------------------------------
 * This file is part of libSBML.  Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright 2011 California Institute of Technology.
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation.  A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as http://sbml.org/software/libsbml/license.html
 *------------------------------------------------------------------------- -->
 *
 * @class CompSBMLDocumentPlugin
 * @ingroup Comp
 * @brief @htmlinclude pkg-marker-comp.html
 * Implementation of the 'comp' package extention to the %SBMLDocument construct.
 *
 * The CompSBMLDocumentPlugin class inherits from the SBMLDocumentPlugin
 * class, and codifies the extentions to the SBMLDocument class defined in
 * the SBML Level&nbsp;3 @ref Comp "Hierarchical Model Composition" package ('comp').
 * This extention allows multiple Model objects to be defined in a single
 * SBMLDocument, stored in an optional child ListOfModelDefinitions object,
 * as well as define references to Model objects in other files, stored in
 * the optional child ListOfExternalModelDefinitions object.  These model
 * definitions, if present, allow Submodel objects to reference other Models
 * to instantiate.
 *
 * The presence of ModelDefinitions and ExternalModelDefinitions in an
 * SBMLDocument does not change the default Model in the file.  If a
 * SBMLDocument is submitted somewhere to be simulated, it is still the
 * <code>&lt;model&gt;</code> child of the <code>&lt;sbml&gt;</code> element
 * that should be simulated.
 *
 * In addition, as all packages do, the CompSBMLDocumentPlugin defines a
 * required flag named <code>required</code>, which indicates whether the
 * 'comp' constructs in the document change the mathematics of the
 * <code>&lt;model&gt;</code> child of the <code>&lt;sbml&gt;</code> element.
 * If they do, this attribute must be set @c true, and if not, this attribute
 * must be set @c false.
 */

#ifndef CompSBMLDocumentPlugin_h
#define CompSBMLDocumentPlugin_h


#ifdef __cplusplus

#include <sbml/common/extern.h>
#include <sbml/common/sbmlfwd.h>
#include <sbml/SBMLTypeCodes.h>
#include <sbml/SBMLErrorLog.h>
#include <sbml/SBase.h>
#include <sbml/xml/XMLInputStream.h>
#include <sbml/xml/XMLOutputStream.h>
#include <sbml/extension/SBasePlugin.h>
#include <sbml/extension/SBMLDocumentPlugin.h>

#include <iostream>
#include <string>
#include <map>

#include <sbml/packages/comp/extension/CompExtension.h>
#include <sbml/packages/comp/common/compfwd.h>
#include <sbml/packages/comp/sbml/ModelDefinition.h>
#include <sbml/packages/comp/sbml/ListOfModelDefinitions.h>
#include <sbml/packages/comp/sbml/ListOfExternalModelDefinitions.h>
#include <sbml/packages/comp/validator/CompValidator.h>

LIBSBML_CPP_NAMESPACE_BEGIN

class CompValidator;

class LIBSBML_EXTERN CompSBMLDocumentPlugin : public SBMLDocumentPlugin
{
protected:

  /** @cond doxygen-libsbml-internal */
  ListOfModelDefinitions  mListOfModelDefinitions;
  ListOfExternalModelDefinitions  mListOfExternalModelDefinitions;
  std::map<std::string, SBMLDocument*> mURIToDocumentMap;
  /** @endcond */

public:

  /**
   * Constructor.
   */
  CompSBMLDocumentPlugin (const std::string &uri, const std::string &prefix,
                          CompPkgNamespaces *compns);


  /**
   * Copy constructor. Creates a copy of this CompSBMLDocumentPlugin object.
   */
  CompSBMLDocumentPlugin(const CompSBMLDocumentPlugin& orig);


  /**
   * Destroy this object.
   */
  virtual ~CompSBMLDocumentPlugin ();


  /**
   * Assignment operator for CompSBMLDocumentPlugin.
   */
  CompSBMLDocumentPlugin& operator=(const CompSBMLDocumentPlugin& orig);


  /**
   * Creates and returns a deep copy of this CompSBMLDocumentPlugin object.
   * 
   * @return a (deep) copy of this CompSBMLDocumentPlugin object
   */
  virtual CompSBMLDocumentPlugin* clone () const;


  /**
   * Returns the first child element found that has the given @p id in the
   * model-wide SId namespace, or @c NULL if no such object is found.
   *
   * @param id string representing the identifier of objects to find
   *
   * @return a pointer to the SBase element with the given @p id.
   *
   * @note The comp SBML document plugin has multiple model-wide SId
   * namespaces, so a valid document may well contain multiple elements with
   * the same SId that reside in separate models.  It is not recommended to
   * ever call this function&mdash;instead, call the function on the child
   * ModelDefinition objects.
   */
  virtual SBase* getElementBySId(std::string id);
  
  
  /**
   * Returns the first child element it can find with the given @p metaid, or
   * itself if it has the given @p metaid, or @c NULL if no such object is
   * found.
   *
   * @param metaid string representing the meta identifier of objects to find
   *
   * @return a pointer to the SBase element with the given @p metaid.
   */
  virtual SBase* getElementByMetaId(std::string metaid);
  
  
  /**
   * Returns a List of all child SBase objects, including those nested to an
   * arbitrary depth
   *
   * @return a List of pointers to all children objects.
   */
  virtual List* getAllElements(ElementFilter* filter=NULL);
  
  
  /** @cond doxygen-libsbml-internal */
  /**
   * @return the SBML object corresponding to next XMLToken in the
   * XMLInputStream or @c NULL if the token was not recognized.
   */
  virtual SBase* createObject (XMLInputStream& stream);
  /** @endcond */


  /** @cond doxygen-libsbml-internal */
  /**
   * Subclasses must override this method to write out their contained
   * SBML objects as XML elements if they have their specific elements.
   */
  virtual void writeElements (XMLOutputStream& stream) const;
  /** @endcond */

#ifndef SWIG

  /** @cond doxygen-libsbml-internal */
  /**
   * Subclasses should override this method to get the list of
   * expected attributes.
   * This function is invoked from corresponding readAttributes()
   * function.
   */
  virtual void addExpectedAttributes(ExpectedAttributes& attributes);
  /** @endcond */


  /** @cond doxygen-libsbml-internal */
  /**
   * Reads the attributes of corresponding package in SBMLDocument element.
   */
  virtual void readAttributes (const XMLAttributes& attributes,
                               const ExpectedAttributes& expectedAttributes);
  /** @endcond */


#endif //SWIG
 
  virtual bool isFlatteningImplemented() const;


  virtual unsigned int checkConsistency(bool overrideFlattening = false); 


  /** @cond doxygen-libsbml-internal */

  virtual bool accept(SBMLVisitor& v) const;

  /** @endcond */


  /*
   * ============================
   * Additional public functions
   * ============================
   */

  /**
   * Returns the ListOf object that holds all ModelDefinitions.
   *
   * @return the ListOf object that holds all ModelDefinitions.
   */ 
  const ListOfModelDefinitions* getListOfModelDefinitions () const;


  /**
   * Returns the ModelDefinition with the given index.
   *
   * @param n the index number of the ModelDefinition to get.
   *
   * @return the nth ModelDefinition in the ListOfModelDefinitions.  If the
   * index is invalid, @c NULL is returned.
   */ 
  ModelDefinition* getModelDefinition (unsigned int n);


  /**
   * Returns the ModelDefinition with the given index.
   *
   * @param n the index number of the ModelDefinition to get.
   *
   * @return the nth ModelDefinition in the ListOfModelDefinitions.  If the
   * index @p n is invalid, @c NULL is returned.
   */ 
  const ModelDefinition* getModelDefinition (unsigned int n) const;


  /**
   * Returns the model definition object based on its identifier.
   *
   * @param sid a string representing the identifier 
   * of the model definition to get.
   * 
   * @return ModelDefinition in the ListOfModelDefinitions with the given @p sid
   * or @c NULL if no such ModelDefinition exists.
   *
   * @see get(unsigned int n)
   * @see size()
   */
  ModelDefinition* getModelDefinition (const std::string& sid);


  /**
   * Returns the model definition object based on its identifier.
   *
   * @param sid a string representing the identifier 
   * of the model definition to get.
   * 
   * @return ModelDefinition in the ListOfModelDefinitions with the given @p sid
   * or @c NULL if no such ModelDefinition exists.
   *
   * @see get(unsigned int n)
   * @see size()
   */
  const ModelDefinition* getModelDefinition (const std::string& sid) const;


  /**
   * Adds a copy of the given ModelDefinition object to the list of
   * ModelDefinitions.
   *
   * @param modelDefinition the ModelDefinition object to be added to the
   * list of ModelDefinitions.  Fails if the added ModelDefinition is @c NULL,
   * does not match the level/version/package of the parent object, or cannot
   * be added to the list of replaced elements.
   *
   * @return integer value indicating success/failure of the
   * function.  @if clike The value is drawn from the
   * enumeration #OperationReturnValues_t. @endif The possible values
   * returned by this function are:
   * @li @link OperationReturnValues_t#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS @endlink
   * @li @link OperationReturnValues_t#LIBSBML_INVALID_OBJECT LIBSBML_INVALID_OBJECT @endlink
   * @li @link OperationReturnValues_t#LIBSBML_LEVEL_MISMATCH LIBSBML_LEVEL_MISMATCH @endlink
   * @li @link OperationReturnValues_t#LIBSBML_VERSION_MISMATCH LIBSBML_VERSION_MISMATCH @endlink
   * @li @link OperationReturnValues_t#LIBSBML_PKG_VERSION_MISMATCH LIBSBML_VERSION_MISMATCH @endlink
   */
  int addModelDefinition (const ModelDefinition* modelDefinition);


  /**
   * Returns the number of ModelDefinitions for this SBMLDocumentPlugin.
   *
   * @return the number of ModelDefinitions.
   */
  unsigned int getNumModelDefinitions () const;


  /**
   * Creates a ModelDefinition object, adds it to the end of the
   * ModelDefinition objects list and returns a pointer to the newly
   * created object.
   *
   * @return a newly created ModelDefinition object
   */
  ModelDefinition* createModelDefinition ();


  /**
   * Removes the ModelDefinition with the given index from the CompSBMLDocumentPlugin.
   *
   * A pointer to the ModelDefinition that was removed is returned.
   * If no ModelDefinition has been removed, @c NULL is returned.
   *
   * @param index the index of the ModelDefinition object to remove
   *
   * @return the ModelDefinition object removed.  As mentioned above, 
   * the caller owns the returned object. @c NULL is returned if 
   * the given index is out of range.
   */
  ModelDefinition* removeModelDefinition(unsigned int index);


  /**
   * Removes the ModelDefinition with the given @p id from the CompSBMLDocumentPlugin.
   *
   * A pointer to the ModelDefinition that was removed is returned.
   * If no ModelDefinition has been removed, @c NULL is returned.
   *
   * @param id the id of the ModelDefinition object to remove
   *
   * @return the ModelDefinition object removed.  As mentioned above, 
   * the caller owns the returned object. @c NULL is returned if 
   * the given index is out of range.
   */
  ModelDefinition* removeModelDefinition(std::string id);


  /**
   * Returns the ListOf object that holds all ExternalModelDefinitions.
   *
   * @return the ListOf object that holds all ExternalModelDefinitions.
   */ 
  const ListOfExternalModelDefinitions* getListOfExternalModelDefinitions () const;


  /**
   * Returns the ExternalModelDefinition with the given index.
   *
   * @param n the index number of the ExternalModelDefinition to get.
   *
   * @return the nth ExternalModelDefinition in the
   * ListOfExternalModelDefinitions.  If the index is invalid, @c NULL is
   * returned.
   */ 
  ExternalModelDefinition* getExternalModelDefinition (unsigned int n);


  /**
   * Returns the ExternalModelDefinition with the given index.
   *
   * @param n the index number of the ExternalModelDefinition to get.
   *
   * @return the nth ExternalModelDefinition in the
   * ListOfExternalModelDefinitions.  If the index is invalid, @c NULL is
   * returned.
   */ 
  const ExternalModelDefinition* getExternalModelDefinition (unsigned int n) const;


  /**
   * Returns the model definition object based on its identifier.
   *
   * @param sid a string representing the identifier 
   * of the model definition to get.
   * 
   * @return ExternalModelDefinition in the ListOfExternalModelDefinitions with the given @p sid
   * or @c NULL if no such ExternalModelDefinition exists.
   *
   * @see get(unsigned int n)
   * @see size()
   */
  ExternalModelDefinition* getExternalModelDefinition (const std::string& sid);


  /**
   * Returns the model definition object based on its identifier.
   *
   * @param sid a string representing the identifier 
   * of the model definition to get.
   * 
   * @return ExternalModelDefinition in the ListOfExternalModelDefinitions with the given @p sid
   * or @c NULL if no such ExternalModelDefinition exists.
   *
   * @see get(unsigned int n)
   * @see size()
   */
  const ExternalModelDefinition* getExternalModelDefinition (const std::string& sid) const;


  /**
   * Searches the model namespace of the document and returns the Model,
   * ModelDefinition, or ExternalModelDefintion object with the given
   * identifier.
   *
   * @param sid a string representing the identifier of the model definition to get.
   *
   * @return The SBase* corresponding to the given @p sid or @c NULL if no such
   * model exists.  If no such model exists, this will return @c NULL.
   */
  const SBase* getModel(const std::string& sid) const;

  
  /**
   * Searches the model namespace of the document and returns the Model,
   * ModelDefinition, or ExternalModelDefintion object with the given
   * identifier.
   *
   * @param sid a string representing the identifier of the model definition to get.
   *
   * @return The SBase* corresponding to the given @p sid or @c NULL if no such
   * model exists.  If no such model exists, this will return @c NULL.
   */
  SBase* getModel(const std::string& sid);
  

  /**
   *
   * Sets the bool value of "required" attribute of corresponding package
   * in SBMLDocument element.  The only legal value is 'true' for the 
   * Hierarchical Model Composition package.
   *
   * @param value the bool value of "required" attribute of corresponding 
   * package in SBMLDocument element.
   *
   * @return integer value indicating success/failure of the
   * function.  The possible values
   * returned by this function are:
   * @li @link OperationReturnValues_t#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS @endlink
   * @li @link OperationReturnValues_t#LIBSBML_UNEXPECTED_ATTRIBUTE LIBSBML_UNEXPECTED_ATTRIBUTE @endlink
   * @li @link OperationReturnValues_t#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE @endlink
   */
  virtual int setRequired(bool value);


  /**
   * Adds a copy of the given ExternalModelDefinition object to the list of
   * ExternalModelDefinitions.
   *
   * @param externalModelDefinition the ExternalModelDefinition object to be
   * added to the list of ExternalModelDefinitions.  Fails if the added
   * ExternalModelDefinition is @c NULL, does not match the
   * level/version/package of the parent object, or cannot be added to the
   * list of external model definitions.
   *
   * @return integer value indicating success/failure of the
   * function.  @if clike The value is drawn from the
   * enumeration #OperationReturnValues_t. @endif The possible values
   * returned by this function are:
   * @li @link OperationReturnValues_t#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS @endlink
   * @li @link OperationReturnValues_t#LIBSBML_INVALID_OBJECT LIBSBML_INVALID_OBJECT @endlink
   * @li @link OperationReturnValues_t#LIBSBML_LEVEL_MISMATCH LIBSBML_LEVEL_MISMATCH @endlink
   * @li @link OperationReturnValues_t#LIBSBML_VERSION_MISMATCH LIBSBML_VERSION_MISMATCH @endlink
   * @li @link OperationReturnValues_t#LIBSBML_PKG_VERSION_MISMATCH LIBSBML_VERSION_MISMATCH @endlink
   */
  int addExternalModelDefinition (const ExternalModelDefinition* externalModelDefinition);


  /**
   * Returns the number of ExternalModelDefinitions for this SBMLDocumentPlugin.
   *
   * @return the number of ExternalModelDefinitions for this SBMLDocumentPlugin.
   */
  unsigned int getNumExternalModelDefinitions () const;


  /**
   * Creates a ExternalModelDefinition object, adds it to the end of the
   * ExternalModelDefinition objects list and returns a pointer to the newly
   * created object.
   *
   * @return a newly created ExternalModelDefinition object
   */
  ExternalModelDefinition* createExternalModelDefinition ();


  /**
   * Removes the ExternalModelDefinition with the given index.
   *
   * A pointer to the ExternalModelDefinition that was removed is returned.
   * If no ExternalModelDefinition has been removed, @c NULL is returned.
   *
   * @param index the index of the ExternalModelDefinition object to remove
   *
   * @return the ExternalModelDefinition object removed.  As mentioned above, 
   * the caller owns the returned object. @c NULL is returned if 
   * the given index is out of range.
   */
  ExternalModelDefinition* removeExternalModelDefinition(unsigned int index);


  /**
   * Removes the ExternalModelDefinition with the given @p id.
   *
   * A pointer to the ExternalModelDefinition that was removed is returned.
   * If no ExternalModelDefinition has been removed, @c NULL is returned.
   *
   * @param id the id of the ExternalModelDefinition object to remove
   *
   * @return the ExternalModelDefinition object removed.  As mentioned above, 
   * the caller owns the returned object. @c NULL is returned if 
   * the given index is out of range.
   */
  ExternalModelDefinition* removeExternalModelDefinition(std::string id);


  // ---------------------------------------------------------
  //
  // virtual functions (internal implementation) which should
  // be overridden by subclasses.
  //
  // ---------------------------------------------------------

  /** @cond doxygen-libsbml-internal */
  /**
   * Sets the parent SBMLDocument of this plugin object.
   *
   * Subclasses which contain one or more SBase derived elements must
   * override this function.
   *
   * @param d the SBMLDocument object to use
   *
   * @see connectToParent
   * @see enablePackageInternal
   */
  virtual void setSBMLDocument (SBMLDocument* d);
  /** @endcond */


  /** @cond doxygen-libsbml-internal */
  /**
   * Sets the *parent* of this SBML object to child SBML objects (if any).
   * (Creates a child-parent relationship by the parent)
   *
   * @see setSBMLDocument
   * @see enablePackageInternal
   */
  virtual void connectToChild ();
  /** @endcond */


  /** @cond doxygen-libsbml-internal */
  /**
   * Sets the parent SBML object of this SBML object.
   * (Creates a child-parent relationship by the child)
   * This function is called when a child element is
   * set/added/created by its parent element (e.g. by setXXX,
   * addXXX, createXXX, and connectToChild functions of the
   * parent element).
   *
   * @param sb the SBML object to use
   */
  void connectToParent (SBase* parent);
  /** @endcond */

  /** @cond doxygen-libsbml-internal */
  /**
   * Enables/Disables the given package with child elements in this plugin
   * object (if any).
   * (This is an internal implementation invoked from
   *  SBase::enablePackageInternal() function)
   *
   * @note Subclasses in which one or more SBase derived elements are
   * defined must override this function.
   *
   * @see setSBMLDocument
   * @see connectToParent
   */
  virtual void enablePackageInternal(const std::string& pkgURI,
                                     const std::string& pkgPrefix, bool flag);
  /** @endcond */

  friend class ExternalModelDefinition; //So that it can call 'getSBMLDocumentFromURI' but nothing else can.

private:

  /**
   * Uses the suite of URI resolvers to find the document referenced by the
   * URI, or @c NULL if no document can be found.  The pointer returned is a
   * *non-owning* pointer: this CompSBMLDocumentPlugin owns the document in
   * question, and will return the same pointer if the same URI is requested
   * later.  This is so that when Model* objects are returned by
   * ExternalModelDefinition functions, the document the model is from will
   * persist.  The public interface for this function is therefore to use
   * ExternalModelDefinition::getReferencedModel() function.
   */
  virtual SBMLDocument* getSBMLDocumentFromURI(const std::string& uri);


  /**
   * Used by getSBMDocumentFromURI to first resolve the URI into its
   * canonical form, for example, from 'model.xml" to
   * "file:/path/to/model.xml".
   */
  virtual std::string  getResolvedURI(const std::string& uri);


  /**
   * Clears the internal list of SBMLDocuments kept when resolving URIs.  May
   * invalidate distributed pointers, and therefore should only be used if a
   * call to getSBMLDocumentFromURI has returned an incorrect document, and
   * the URI resolvers have since been tweaked so as to no longer return the
   * same result.
   */
  virtual void clearStoredURIDocuments();

  
  /** variables and functions for consistency checking **/

  /** @cond doxygen-libsbml-internal */
  bool mCheckingDummyDoc;
  bool mFlattenAndCheck;
  /** @endcond */
};

LIBSBML_CPP_NAMESPACE_END

#endif /* __cplusplus */


#ifndef SWIG

LIBSBML_CPP_NAMESPACE_BEGIN
BEGIN_C_DECLS

LIBSBML_EXTERN
ModelDefinition_t *
CompSBMLDocumentPlugin_createModelDefinition(CompSBMLDocumentPlugin_t * docPlug);

END_C_DECLS
LIBSBML_CPP_NAMESPACE_END


#endif  /* !SWIG */
#endif  /* CompSBMLDocumentPlugin_h */
