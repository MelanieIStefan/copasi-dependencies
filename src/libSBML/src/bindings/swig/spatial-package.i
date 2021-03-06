#ifdef USE_SPATIAL

%newobject removeDomainType;
%newobject removeDomain;
%newobject removeInteriorPoint;
%newobject removeAdjacentDomains;
%newobject removeGeometryDefinition;
%newobject removeCoordinateComponent;
%newobject removeSampledField;
%newobject removeSampledVolume;
%newobject removeAnalyticVolume;
%newobject removeParametricObject;
%newobject removeCSGObject;
%newobject removeCSGNode;
%newobject removeOrdinalMapping;

%template (SpatialPkgNamespaces) SBMLExtensionNamespaces<SpatialExtension>;

%include <sbml/packages/spatial/extension/SpatialExtension.h>
%include <sbml/packages/spatial/extension/SpatialModelPlugin.h>
%include <sbml/packages/spatial/extension/SpatialCompartmentPlugin.h>
%include <sbml/packages/spatial/extension/SpatialSpeciesPlugin.h>
%include <sbml/packages/spatial/extension/SpatialParameterPlugin.h>
%include <sbml/packages/spatial/extension/SpatialReactionPlugin.h>
%include <sbml/packages/spatial/sbml/DomainType.h>
%include <sbml/packages/spatial/sbml/Domain.h>
%include <sbml/packages/spatial/sbml/InteriorPoint.h>
%include <sbml/packages/spatial/sbml/Boundary.h>
%include <sbml/packages/spatial/sbml/AdjacentDomains.h>
%include <sbml/packages/spatial/sbml/GeometryDefinition.h>
%include <sbml/packages/spatial/sbml/CompartmentMapping.h>
%include <sbml/packages/spatial/sbml/CoordinateComponent.h>
%include <sbml/packages/spatial/sbml/SampledFieldGeometry.h>
%include <sbml/packages/spatial/sbml/SampledField.h>
%include <sbml/packages/spatial/sbml/SampledVolume.h>
%include <sbml/packages/spatial/sbml/AnalyticGeometry.h>
%include <sbml/packages/spatial/sbml/AnalyticVolume.h>
%include <sbml/packages/spatial/sbml/ParametricGeometry.h>
%include <sbml/packages/spatial/sbml/ParametricObject.h>
%include <sbml/packages/spatial/sbml/CSGeometry.h>
%include <sbml/packages/spatial/sbml/CSGObject.h>
%include <sbml/packages/spatial/sbml/CSGNode.h>
%include <sbml/packages/spatial/sbml/CSGTransformation.h>
%include <sbml/packages/spatial/sbml/CSGTranslation.h>
%include <sbml/packages/spatial/sbml/CSGRotation.h>
%include <sbml/packages/spatial/sbml/CSGScale.h>
%include <sbml/packages/spatial/sbml/CSGHomogeneousTransformation.h>
%include <sbml/packages/spatial/sbml/TransformationComponent.h>
%include <sbml/packages/spatial/sbml/CSGPrimitive.h>
%include <sbml/packages/spatial/sbml/CSGSetOperator.h>
%include <sbml/packages/spatial/sbml/SpatialSymbolReference.h>
%include <sbml/packages/spatial/sbml/DiffusionCoefficient.h>
%include <sbml/packages/spatial/sbml/AdvectionCoefficient.h>
%include <sbml/packages/spatial/sbml/BoundaryCondition.h>
%include <sbml/packages/spatial/sbml/Geometry.h>
%include <sbml/packages/spatial/sbml/MixedGeometry.h>
%include <sbml/packages/spatial/sbml/OrdinalMapping.h>
%include <sbml/packages/spatial/sbml/SpatialPoints.h>
%include <sbml/packages/spatial/sbml/ListOfDomainTypes.h>
%include <sbml/packages/spatial/sbml/ListOfDomains.h>
%include <sbml/packages/spatial/sbml/ListOfInteriorPoints.h>
%include <sbml/packages/spatial/sbml/ListOfAdjacentDomains.h>
%include <sbml/packages/spatial/sbml/ListOfGeometryDefinitions.h>
%include <sbml/packages/spatial/sbml/ListOfCoordinateComponents.h>
%include <sbml/packages/spatial/sbml/ListOfSampledFields.h>
%include <sbml/packages/spatial/sbml/ListOfSampledVolumes.h>
%include <sbml/packages/spatial/sbml/ListOfAnalyticVolumes.h>
%include <sbml/packages/spatial/sbml/ListOfParametricObjects.h>
%include <sbml/packages/spatial/sbml/ListOfCSGObjects.h>
%include <sbml/packages/spatial/sbml/ListOfCSGNodes.h>
%include <sbml/packages/spatial/sbml/ListOfOrdinalMappings.h>

#endif /* USE_SPATIAL */

