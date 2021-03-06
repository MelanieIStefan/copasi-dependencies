/**
 * @file    SBMLStripPackageConverter.cpp
 * @brief   Implementation of SBMLStripPackageConverter, the base class of package extensions.
 * @author  Sarah Keating
 * 
 * <!--------------------------------------------------------------------------
 * This file is part of libSBML.  Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
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
 * the Free Software Foundation.  A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as http://sbml.org/software/libsbml/license.html
 * ------------------------------------------------------------------------ -->
 */

#include <sbml/conversion/SBMLStripPackageConverter.h>
#include <sbml/conversion/SBMLConverterRegistry.h>
#include <sbml/conversion/SBMLConverterRegister.h>
#include <sbml/extension/SBasePlugin.h>

#ifdef __cplusplus

#include <algorithm>
#include <string>

using namespace std;
LIBSBML_CPP_NAMESPACE_BEGIN

  
/** @cond doxygenLibsbmlInternal */
void SBMLStripPackageConverter::init()
{
  SBMLStripPackageConverter converter;
  SBMLConverterRegistry::getInstance().addConverter(&converter);
}
/** @endcond */


SBMLStripPackageConverter::SBMLStripPackageConverter () 
  : SBMLConverter("SBML Strip Package Converter")
{
}


/*
 * Copy constructor.
 */
SBMLStripPackageConverter::SBMLStripPackageConverter(const SBMLStripPackageConverter& orig) 
  : SBMLConverter(orig)
{
}


/*
 * Destroy this object.
 */
SBMLStripPackageConverter::~SBMLStripPackageConverter ()
{
}


/*
 * Assignment operator for SBMLStripPackageConverter.
 */
SBMLStripPackageConverter& 
SBMLStripPackageConverter::operator=(const SBMLStripPackageConverter& rhs)
{  
  if(&rhs!=this)
  {
    this->SBMLConverter::operator =(rhs);
  }

  return *this;
}


SBMLStripPackageConverter*
SBMLStripPackageConverter::clone () const
{
  return new SBMLStripPackageConverter(*this);
}


ConversionProperties
SBMLStripPackageConverter::getDefaultProperties() const
{
  static ConversionProperties prop;
  static bool init = false;

  if (init) 
  {
    return prop;
  }
  else
  {
    prop.addOption("stripPackage", true,
                   "Strip SBML Level 3 package constructs from the model");
    prop.addOption("stripAllUnrecognized", false, "If set, all unsupported packages will be removed.");
    prop.addOption("package", "",
                   "Name of the SBML Level 3 package to be stripped");
    init = true;
    return prop;
  }
}


bool 
SBMLStripPackageConverter::matchesProperties(const ConversionProperties &props) const
{
  if (!props.hasOption("stripPackage"))
    return false;
  return true;
}

/** @cond doxygenLibsbmlInternal */
bool 
SBMLStripPackageConverter::stripPackage(const std::string& packageToStrip)
{
  bool conversion = false;
  const std::string& pkgURI =
    mDocument->getSBMLNamespaces()->getNamespaces()->getURI(packageToStrip);

  // TO DO - SK Comment
  // pass control to package code to see if needs to do more 
  // additional boolean flag is to do with preseving info
  // not yet used but I think it will need to be passed
  // conversion = mDocument->getModel()->getPlugin(packageToStrip)
  //                                       ->stripPackage(packageToStrip, false);


  if (pkgURI.empty() == false)
  {
    // disabling the package will literally strip the pkg info
    mDocument->enablePackage(pkgURI, packageToStrip, false);

    // check it is disabled
    if (mDocument->isPkgEnabled(packageToStrip) == false)
      conversion = true;
  }

  return conversion;
}
/** @endcond */

int
SBMLStripPackageConverter::convert()
{
// TO DO - SK Comment
  // would like an option that put the extension classes somewhere were I 
  // could get at them later

  if (isStripAllUnrecognizedPackages())
  {
    int numPackages = mDocument->getNumUnknownPackages();
    bool result = true;
    for (int i = numPackages-1; i >=0; --i)
    {
      const std::string& current = mDocument->getUnknownPackagePrefix(i);
      result &= stripPackage(current);
      if (!result)
        return LIBSBML_OPERATION_FAILED;
    }
  }

  std::string packageToStrip = getPackageToStrip();

  if (packageToStrip.empty())
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  
  if (mDocument->isPkgEnabled(packageToStrip) == false)
  {
    std::string pkgURI = mDocument->getSBMLNamespaces()
                         ->getNamespaces()->getURI(packageToStrip);
    if (mDocument->isIgnoredPackage(pkgURI) == false)
    {
      return LIBSBML_CONV_PKG_CONSIDERED_UNKNOWN;
    }
  }

  bool conversion = stripPackage(packageToStrip);

// TO DO - SK Comment
  // test that package is stripped

  if (conversion)
    // disabling the package will literally strip the pkg info
    return LIBSBML_OPERATION_SUCCESS;
  else
    return LIBSBML_OPERATION_FAILED;
}
  

std::string
SBMLStripPackageConverter::getPackageToStrip() const
{
  if (getProperties()->getOption("package") != NULL)
  {
    return getProperties()->getOption("package")->getValue();
  }
  else
  {
    return "";
  }
}

bool 
SBMLStripPackageConverter::isStripAllUnrecognizedPackages() const
{
  if (getProperties()->getOption("stripAllUnrecognized") != NULL)
  {
    return getProperties()->getOption("stripAllUnrecognized")->getBoolValue();
  }
  else
  {
    return false;
  }
}

/** @cond doxygenIgnored */
/** @endcond */

LIBSBML_CPP_NAMESPACE_END

#endif  /* __cplusplus */


