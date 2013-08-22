/**
 * @cond doxygen-libsbml-internal
 *
 * @file    IdentifierConsistencyConstraints.cpp
 * @brief   IdentifierConsistency check constraints.  See SBML Wiki
 * @author  Sarah Keating
 * 
 * <!--------------------------------------------------------------------------
 * This file is part of libSBML.  Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright (C) 2009-2013 jointly by the following organizations: 
 *     1. California Institute of Technology, Pasadena, CA, USA
 *     2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
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
 * ---------------------------------------------------------------------- -->*/

#ifndef AddingConstraintsToValidator

#include <sbml/validator/VConstraint.h>

#include <sbml/packages/qual/validator/QualSBMLError.h>
#include <sbml/packages/qual/sbml/FunctionTerm.h>

#include "QualCSymbolMathCheck.h"

#endif

#include <sbml/validator/ConstraintMacros.h>

/** @cond doxygen-ignored */

using namespace std;

//10201
START_CONSTRAINT (QualFunctionTermBool, FunctionTerm, ft)
{
  pre( ft.isSetMath() );

  bool fail = false;

  if (m.isBoolean(ft.getMath()) == false)
  {
    fail = true;
  }

  inv( fail == false);
}
END_CONSTRAINT

//10202
EXTERN_CONSTRAINT (QualMathCSymbolDisallowed, QualCSymbolMathCheck)

/** @endcond */

