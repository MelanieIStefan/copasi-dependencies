#ifdef USE_DISTRIB
if (pkgName == "distrib")
{
	if (sb->getTypeCode() == SBML_FUNCTIONDEFINITION)
	{
		return SWIGTYPE_p_DistribFunctionDefinitionPlugin;
	}
}

#endif // USE_DISTRIB 

