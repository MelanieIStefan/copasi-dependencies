/**
 * @file    ModelCreator.cpp
 * @brief   ModelCreator I/O
 * @author  Sarah Keating
 * 
 * Copyright (C) 2013-2017 jointly by the following organizations:
 *     1. California Institute of Technology, Pasadena, CA, USA
 *     2. EMBL European Bioinformatics Institute (EMBL-EBI), Hinxton, UK
 *     3. University of Heidelberg, Heidelberg, Germany
 *
 * Copyright (C) 2009-2013 jointly by the following organizations: 
 *     1. California Institute of Technology, Pasadena, CA, USA
 *     2. EMBL European Bioinformatics Institute (EMBL-EBI), Hinxton, UK
 *  
 * Copyright (C) 2006-2008 by the California Institute of Technology,
 *     Pasadena, CA, USA 
 *  
 * Copyright (C) 2002-2005 jointly by the following organizations: 
 *     1. California Institute of Technology, Pasadena, CA, USA
 *     2. Japan Science and Technology Agency, Japan
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation.  A copy of the license agreement is
 * provided in the file named "LICENSE.txt" included with this software
 * distribution.  It is also available online at
 * http://sbml.org/software/libsbml/license.html
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */


#include <sbml/annotation/ModelCreator.h>
#include <sbml/common/common.h>
#include <sbml/SBase.h>
#include <cstdio>

/** @cond doxygenIgnored */
using namespace std;
/** @endcond */

LIBSBML_CPP_NAMESPACE_BEGIN
#ifdef __cplusplus

/*
 * Creates a new ModelCreator.
 */
ModelCreator::ModelCreator () :
    mAdditionalRDF(NULL)
  , mHasBeenModified (false)
  , mUsingFNVcard4 (false)
  , mUseSingleName (false)
{
}

/*
 * create a new ModelCreator from an XMLNode
 */
ModelCreator::ModelCreator(const XMLNode creator):
    mAdditionalRDF(NULL)
  , mHasBeenModified (false)
  , mUsingFNVcard4 (false)
  , mUseSingleName (false)
{
  std::string vcard3_uri = "http://www.w3.org/2001/vcard-rdf/3.0#";
  std::string vcard4_uri = "http://www.w3.org/2006/vcard/ns#";

  // check that this is the right place in the RDF Annotation
  if (creator.getName() == "li")
  {
    int numChildren = static_cast<int>(creator.getNumChildren());
    int n = 0;

    // are we dealing with vcard3 or vcard4
    bool vcard3 = true;
    std::string name_element = "N";
    std::string email_element = "EMAIL";
    std::string org_element = "ORG";
    std::string fn_element = "fn";
    std::string text_element = "text";

    const string& uri = creator.getChild((unsigned int)n).getURI();
    if (uri == vcard4_uri)
    {
      vcard3 = false;
      name_element = "hasName";
      email_element = "hasEmail";
      org_element = "organization-name";
    }

    // we expect an N / EMAIL / ORG in that order 
    // find the positions of the first occurence of each
    int Npos = -1;
    int EMAILpos = -1;
    int ORGpos = -1;
    for (n = 0; n < numChildren; n++)
    {
      const string& name = creator.getChild((unsigned int)n).getName();
      if (name == name_element && Npos < 0)
        Npos = n;
      else if (name == fn_element && Npos < 0)
      {
        Npos = n;
        mUsingFNVcard4 = true;
      }
      else if (name == email_element && EMAILpos < 0 && n > Npos)
        EMAILpos = n;
      else if (name == org_element && ORGpos < 0 && n > EMAILpos)
        ORGpos = n;
    }

    //get Names
    if (Npos >= 0)
    {
      if (vcard3)
      {
        setFamilyName(creator.getChild((unsigned int)Npos).getChild("Family").getChild(0).getCharacters());
        setGivenName(creator.getChild((unsigned int)Npos).getChild("Given").getChild(0).getCharacters());
      }
      else
      {
        if (mUsingFNVcard4)
        {
          setName(creator.getChild((unsigned int)Npos).getChild("text").getChild(0).getCharacters());
        }
        else
        {
          setFamilyName(creator.getChild((unsigned int)Npos).getChild("family-name").getChild(0).getCharacters());
          setGivenName(creator.getChild((unsigned int)Npos).getChild("given-name").getChild(0).getCharacters());
        }
      }
    }

    // get EMAIL
    if (EMAILpos >= 0)
    {
      setEmail(creator.getChild((unsigned int)EMAILpos).getChild(0).getCharacters());
    }

    // get ORG
    if (ORGpos >= 0)
    {
      if (vcard3)
      {
        setOrganization(creator.getChild((unsigned int)ORGpos).getChild("Orgname")
                               .getChild(0).getCharacters());
      }
      else
      {
        setOrganization(creator.getChild((unsigned int)ORGpos).getChild(0).getCharacters());
      }
    }
    // loop thru and save any other elements
    numChildren = static_cast<int>(creator.getNumChildren());
    for (n = 0; n < numChildren; n++)
    {
      if (n != Npos && n != EMAILpos && n!= ORGpos)
      {
        if (mAdditionalRDF == NULL)
        {
          mAdditionalRDF = new XMLNode();
        }
        mAdditionalRDF->addChild(creator.getChild((unsigned int)n));
      }
    }
  }
}


/*
 * destructor
 */
ModelCreator::~ModelCreator()
{
  delete mAdditionalRDF;
}


/*
 * Copy constructor.
 */
ModelCreator::ModelCreator(const ModelCreator& orig)
{
  {
    mFamilyName   = orig.mFamilyName;
    mGivenName    = orig.mGivenName;
    mEmail        = orig.mEmail;
    mOrganization = orig.mOrganization;

    if (orig.mAdditionalRDF != NULL)
      this->mAdditionalRDF = orig.mAdditionalRDF->clone();
    else
      this->mAdditionalRDF = NULL;

    mHasBeenModified = orig.mHasBeenModified;
    mUsingFNVcard4 = orig.mUsingFNVcard4;
    mUseSingleName = orig.mUseSingleName;
  }
}


/*
 * Assignment operator
 */
ModelCreator& ModelCreator::operator=(const ModelCreator& rhs)
{
  if(&rhs!=this)
  {
    mFamilyName   = rhs.mFamilyName;
    mGivenName    = rhs.mGivenName;
    mEmail        = rhs.mEmail;
    mOrganization = rhs.mOrganization;

    delete this->mAdditionalRDF;
    if (rhs.mAdditionalRDF != NULL)
      this->mAdditionalRDF = rhs.mAdditionalRDF->clone();
    else
      this->mAdditionalRDF = NULL;

    mHasBeenModified = rhs.mHasBeenModified;
    mUsingFNVcard4 = rhs.mUsingFNVcard4;
    mUseSingleName = rhs.mUseSingleName;
  }

  return *this;
}


/*
 * @return a (deep) copy of this ModelCreator.
 */
ModelCreator* ModelCreator::clone () const
{
  return new ModelCreator(*this);
}


bool 
ModelCreator::isSetFamilyName()
{
  return (mFamilyName.empty() == false);
}


bool 
ModelCreator::isSetGivenName()
{
  return (mGivenName.empty() == false);
}


bool 
ModelCreator::isSetEmail()
{
  return (mEmail.empty() == false);
}


bool 
ModelCreator::isSetOrganization()
{
  return (mOrganization.empty() == false);
}


bool 
ModelCreator::isSetOrganisation()
{
  return isSetOrganization();
}


bool 
ModelCreator::isSetName()
{
  if (mUsingFNVcard4)
    return (mFamilyName.empty() == false);
  else
    return false;
}


/*
 * sets the family name
 */
int 
ModelCreator::setFamilyName(const std::string& name)
{
  {
    mFamilyName = name;
    mHasBeenModified = true;
    mUseSingleName = false;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * sets the given name
 */
int 
ModelCreator::setGivenName(const std::string& name)
{
  {
    mGivenName = name;
    mHasBeenModified = true;
    mUseSingleName = false;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * sets the email
 */
int 
ModelCreator::setEmail(const std::string& email)
{
  {
    mEmail = email;
    mHasBeenModified = true;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


int 
ModelCreator::setOrganization(const std::string& organization)
{
  {
    mOrganization = organization;
    mHasBeenModified = true;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


int 
ModelCreator::setOrganisation(const std::string& organization)
{
  return setOrganization(organization);
}


/*
 * sets the family name
 */
int 
ModelCreator::setName(const std::string& name)
{
  {
    mFamilyName = name;
    mGivenName = name;
    mHasBeenModified = true;
    mUsingFNVcard4 = true;
    mUseSingleName = true;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


int 
ModelCreator::unsetFamilyName()
{
  mFamilyName.erase();

  if (mFamilyName.empty()) 
  {
    mHasBeenModified = true;
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


int 
ModelCreator::unsetGivenName()
{
  mGivenName.erase();

  if (mGivenName.empty()) 
  {
    mHasBeenModified = true;
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


int 
ModelCreator::unsetEmail()
{
  mEmail.erase();

  if (mEmail.empty()) 
  {
    mHasBeenModified = true;
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


int 
ModelCreator::unsetOrganization()
{
  mOrganization.erase();

  if (mOrganization.empty()) 
  {
    mHasBeenModified = true;
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


int 
ModelCreator::unsetOrganisation()
{
  return unsetOrganization();
}

int 
ModelCreator::unsetName()
{
  mFamilyName.erase();

  if (mFamilyName.empty()) 
  {
    mHasBeenModified = true;
    mUsingFNVcard4 = false;
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/** @cond doxygenLibsbmlInternal */
XMLNode *
ModelCreator::getAdditionalRDF()
{
  return mAdditionalRDF;
}
/** @endcond */


bool
ModelCreator::hasRequiredAttributes()
{
  bool valid = true;
   
  if (mUsingFNVcard4)
  {
    if (!isSetName())
    {
      valid = false;
    }
  }
  else
  {
    if (!isSetFamilyName())
    {
      valid = false;
    }

    if (!isSetGivenName())
    {
      valid = false;
    }
  }

  return valid;
}


/** @cond doxygenLibsbmlInternal */
bool
ModelCreator::hasBeenModified()
{
  return mHasBeenModified;
}
/** @endcond */


/** @cond doxygenLibsbmlInternal */
void
ModelCreator::resetModifiedFlags()
{
  mHasBeenModified = false;
}
/** @endcond */

/** @cond doxygenLibsbmlInternal */
bool
ModelCreator::usingSingleName()
{
  return mUseSingleName;
}
/** @endcond */


/** @cond doxygenLibsbmlInternal */
void
ModelCreator::setUseSingleName(bool flag)
{
  mUsingFNVcard4 = flag;
  mUseSingleName = flag;
}
/** @endcond */




#endif /* __cplusplus */


/** @cond doxygenIgnored */
LIBSBML_EXTERN
ModelCreator_t *
ModelCreator_create()
{
  return new(nothrow) ModelCreator();
}

LIBSBML_EXTERN
ModelCreator_t *
ModelCreator_createFromNode(const XMLNode_t * node)
{
  if (node == NULL) return NULL;
  return new(nothrow) ModelCreator(*node);
}


LIBSBML_EXTERN
void
ModelCreator_free(ModelCreator_t * mc)
{
  if (mc == NULL) return;
  delete static_cast<ModelCreator*>(mc);
}


LIBSBML_EXTERN
ModelCreator_t *
ModelCreator_clone (const ModelCreator_t* mc)
{
  if (mc == NULL) return NULL;
  return static_cast<ModelCreator*>( mc->clone() );
}


LIBSBML_EXTERN
const char * 
ModelCreator_getFamilyName(ModelCreator_t *mc)
{
  if (mc == NULL) return NULL;
  return mc->getFamilyName().c_str();
}


LIBSBML_EXTERN
const char * 
ModelCreator_getGivenName(ModelCreator_t *mc)
{
  if (mc == NULL) return NULL;
  return mc->getGivenName().c_str();
}


LIBSBML_EXTERN
const char * 
ModelCreator_getEmail(ModelCreator_t *mc)
{
  if (mc == NULL) return NULL;
  return mc->getEmail().c_str();
}


LIBSBML_EXTERN
const char * 
ModelCreator_getOrganisation(ModelCreator_t *mc)
{
  if (mc == NULL) return NULL;
  return mc->getOrganisation().c_str();
}


LIBSBML_EXTERN
const char * 
ModelCreator_getOrganization(ModelCreator_t *mc)
{
  return ModelCreator_getOrganisation(mc);
}


LIBSBML_EXTERN
const char * 
ModelCreator_getName(ModelCreator_t *mc)
{
  if (mc == NULL) return NULL;
  return mc->getName().c_str();
}


LIBSBML_EXTERN
int 
ModelCreator_isSetFamilyName(ModelCreator_t *mc)
{
  if (mc == NULL) return (int)false;
  return static_cast<int>(mc->isSetFamilyName());
}


LIBSBML_EXTERN
int 
ModelCreator_isSetGivenName(ModelCreator_t *mc)
{
  if (mc == NULL) return (int)false;
  return static_cast<int>(mc->isSetGivenName());
}


LIBSBML_EXTERN
int 
ModelCreator_isSetEmail(ModelCreator_t *mc)
{
  if (mc == NULL) return (int)false;
  return static_cast<int>(mc->isSetEmail());
}


LIBSBML_EXTERN
int 
ModelCreator_isSetOrganisation(ModelCreator_t *mc)
{
  if (mc == NULL) return (int)false;
  return static_cast<int>(mc->isSetOrganisation());
}


LIBSBML_EXTERN
int 
ModelCreator_isSetOrganization(ModelCreator_t *mc)
{
  return ModelCreator_isSetOrganisation(mc);
}


LIBSBML_EXTERN
int 
ModelCreator_isSetName(ModelCreator_t *mc)
{
  if (mc == NULL) return (int)false;
  return static_cast<int>(mc->isSetName());
}


LIBSBML_EXTERN
int 
ModelCreator_setFamilyName(ModelCreator_t *mc, const char * name)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->setFamilyName(name);
}


LIBSBML_EXTERN
int 
ModelCreator_setGivenName(ModelCreator_t *mc, const char * name)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->setGivenName(name);
}


LIBSBML_EXTERN
int 
ModelCreator_setEmail(ModelCreator_t *mc, const char * email)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->setEmail(email);
}


LIBSBML_EXTERN
int 
ModelCreator_setOrganisation(ModelCreator_t *mc, const char * org)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->setOrganisation(org);
}


LIBSBML_EXTERN
int 
ModelCreator_setOrganization(ModelCreator_t *mc, const char * org)
{
  return ModelCreator_setOrganisation(mc, org);
}


LIBSBML_EXTERN
int 
ModelCreator_setName(ModelCreator_t *mc, const char * name)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->setName(name);
}


LIBSBML_EXTERN
int 
ModelCreator_unsetFamilyName(ModelCreator_t *mc)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->unsetFamilyName();
}


LIBSBML_EXTERN
int 
ModelCreator_unsetGivenName(ModelCreator_t *mc)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->unsetGivenName();
}


LIBSBML_EXTERN
int 
ModelCreator_unsetEmail(ModelCreator_t *mc)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->unsetEmail();
}


LIBSBML_EXTERN
int 
ModelCreator_unsetOrganisation(ModelCreator_t *mc)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->unsetOrganisation();
}


LIBSBML_EXTERN
int 
ModelCreator_unsetOrganization(ModelCreator_t *mc)
{
  return ModelCreator_unsetOrganisation(mc);
}


LIBSBML_EXTERN
int 
ModelCreator_unsetName(ModelCreator_t *mc)
{
  if (mc == NULL) return LIBSBML_INVALID_OBJECT;
  return mc->unsetName();
}


LIBSBML_EXTERN
int
ModelCreator_hasRequiredAttributes(ModelCreator_t *mc)
{
  if (mc == NULL) return (int)false;
  return static_cast<int> (mc->hasRequiredAttributes());
}
/** @endcond */

LIBSBML_CPP_NAMESPACE_END

