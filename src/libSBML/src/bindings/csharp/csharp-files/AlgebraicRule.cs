using System;
using System.Runtime.InteropServices;
 
/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

namespace libsbmlcs {

 using System;
 using System.Runtime.InteropServices;

/** 
 * @sbmlpackage{core}
 *
@htmlinclude pkg-marker-core.html An SBML <em>algebraic rule</em> representing <em>0 = f(<b>W</b>)</em>.
 *
 * The rule type AlgebraicRule is derived from the parent class Rule.  It
 * is used to express equations that are neither assignments of model
 * variables nor rates of change.  AlgebraicRule does not add any
 * attributes to the basic Rule; its role is simply to distinguish this
 * case from the other cases.
 *
 * In the context of a simulation, algebraic rules are in effect at all
 * times, <em>t</em> >= <em>0</em>.  For purposes of evaluating
 * expressions that involve the delay 'csymbol' (see the SBML
 * specification), algebraic rules are considered to apply also at
 * <em>t</em> <= <em>0</em>.  Please consult the relevant SBML
 * specification for additional information about the semantics of
 * assignments, rules, and entity values for simulation time <em>t</em>
 * <= <em>0</em>.
 *
 * An SBML model must not be overdetermined.  The ability to define
 * arbitrary algebraic expressions in an SBML model introduces the
 * possibility that a model is mathematically overdetermined by the overall
 * system of equations constructed from its rules, reactions and events.
 * Therefore, if an algebraic rule is introduced in a model, for at least
 * one of the entities referenced in the rule's 'math' element the value of
 * that entity must not be completely determined by other constructs in the
 * model.  This means that at least this entity must not have the attribute
 * 'constant'=@c true and there must also not be a rate rule or assignment
 * rule for it.  Furthermore, if the entity is a Species object, its value
 * must not be determined by reactions, which means that it must either
 * have the attribute 'boundaryCondition'=@c true or else not be involved
 * in any reaction at all.  These restrictions are explained in more detail
 * in the SBML specification documents.
 *
 * In SBML Levels 2 and&nbsp;3, Reaction object identifiers can be
 * referenced in the 'math' expression of an algebraic rule, but reaction
 * rates can never be <em>determined</em> by algebraic rules.  This is true
 * even when a reaction does not contain a KineticLaw
 * @if conly structure @else object@endif.  (In such cases of missing
 * kinetic law definitions, the model is valid but incomplete; the rates of
 * reactions lacking kinetic laws are simply undefined, and not determined by
 * the algebraic rule.)
 *
 * In SBML Level&nbsp;2 and Level&nbsp;3 Version&nbsp;1, the 'math'
 * subelement of the AlgebraicRule is required.  In SBML Level&nbsp;3
 * Version&nbsp;2, this rule is relaxed, and the subelement is
 * optional.  If an AlgebraicRule with no 'math' child is present
 * in the model, no additional mathematical constraints on the model are
 * added by the rule.  This may represent a situation where the model itself
 * is unfinished, or the missing information may be provided by an
 * SBML Level&nbsp;3 package.
 *
 * Finally, any symbol that appears as the target of a rateOf csymbol 
 * (@link libsbml#AST_FUNCTION_RATE_OF AST_FUNCTION_RATE_OF@endlink, introduced in 
 * SBML Level&nbsp;3 Version&nbsp;2) may 
 * not be determined by an AlgebraicRule. This is because the rateOf 
 * csymbol is defined as applying only to symbols whose rates of change 
 * are easily determinable.
 *
 * Users should note that these rules about what symbols may not be 
 * determined by an AlgebraicRule may be used to discover what symbol 
 * is being determined by an AlgebraicRule. If three symbols appear in 
 * the math element of an AlgebraicRule, the first of which is flagged 
 * constant=@c true, and the second of which appears as the target of a
 * rateOf csymbol, one may conclude that the AlgebraicRule must be used 
 * to determine the value of the third symbol. This is, in fact, a 
 * principle use (outside of validation) of the constant attribute: its 
 * use in allowing software to properly identify the dependent variable 
 * in an AlgebraicRule.
 *
 *
 * @section rules-general General summary of SBML rules
 *
 * In SBML Level&nbsp;3 as well as Level&nbsp;2, rules are separated into three
 * subclasses for the benefit of model analysis software.  The three
 * subclasses are based on the following three different possible functional
 * forms (where <em>x</em> is a variable, <em>f</em> is some arbitrary
 * function returning a numerical result, <b><em>V</em></b> is a vector of
 * variables that does not include <em>x</em>, and <b><em>W</em></b> is a
 * vector of variables that may include <em>x</em>):
 *
 * <table border='0' cellpadding='0' class='centered' style='font-size: small'>
 * <tr><td width='120px'><em>Algebraic:</em></td><td width='250px'>left-hand side is zero</td><td><em>0 = f(<b>W</b>)</em></td></tr>
 * <tr><td><em>Assignment:</em></td><td>left-hand side is a scalar:</td><td><em>x = f(<b>V</b>)</em></td></tr>
 * <tr><td><em>Rate:</em></td><td>left-hand side is a rate-of-change:</td><td><em>dx/dt = f(<b>W</b>)</em></td></tr>
 * </table>
 *
 * In their general form given above, there is little to distinguish
 * between <em>assignment</em> and <em>algebraic</em> rules.  They are treated as
 * separate cases for the following reasons:
 *
 * @li <em>Assignment</em> rules can simply be evaluated to calculate
 * intermediate values for use in numerical methods.  They are statements
 * of equality that hold at all times.  (For assignments that are only
 * performed once, see InitialAssignment.)

 * @li SBML needs to place restrictions on assignment rules, for example
 * the restriction that assignment rules cannot contain algebraic loops.
 *
 * @li Some simulators do not contain numerical solvers capable of solving
 * unconstrained algebraic equations, and providing more direct forms such
 * as assignment rules may enable those simulators to process models they
 * could not process if the same assignments were put in the form of
 * general algebraic equations;
 *
 * @li Those simulators that <em>can</em> solve these algebraic equations make a
 * distinction between the different categories listed above; and
 *
 * @li Some specialized numerical analyses of models may only be applicable
 * to models that do not contain <em>algebraic</em> rules.
 *
 * The approach taken to covering these cases in SBML is to define an
 * abstract Rule structure containing a subelement, 'math', to hold the
 * right-hand side expression, then to derive subtypes of Rule that add
 * attributes to distinguish the cases of algebraic, assignment and rate
 * rules.  The 'math' subelement must contain a MathML expression defining the
 * mathematical formula of the rule.  This MathML formula must return a
 * numerical value.  The formula can be an arbitrary expression referencing
 * the variables and other entities in an SBML model.
 *
 * Each of the three subclasses of Rule (AssignmentRule, AlgebraicRule,
 * RateRule) inherit the the 'math' subelement and other fields from SBase.
 * The AssignmentRule and RateRule classes add an additional attribute,
 * 'variable'.  See the definitions of AssignmentRule, AlgebraicRule and
 * RateRule for details about the structure and interpretation of each one.
 *
 * @section rules-restrictions Additional restrictions on SBML rules
 *
 * An important design goal of SBML rule semantics is to ensure that a
 * model's simulation and analysis results will not be dependent on when or
 * how often rules are evaluated.  To achieve this, SBML needs to place two
 * restrictions on rule use.  The first concerns algebraic loops in the system
 * of assignments in a model, and the second concerns overdetermined systems.
 *
 * @subsection rules-no-loops A model must not contain algebraic loops
 *
 * The combined set of InitialAssignment, AssignmentRule and KineticLaw
 * objects in a model constitute a set of assignment statements that should be
 * considered as a whole.  (A KineticLaw object is counted as an assignment
 * because it assigns a value to the symbol contained in the 'id' attribute of
 * the Reaction object in which it is defined.)  This combined set of
 * assignment statements must not contain algebraic loops---dependency
 * chains between these statements must terminate.  To put this more formally,
 * consider a directed graph in which nodes are assignment statements and
 * directed arcs exist for each occurrence of an SBML species, compartment or
 * parameter symbol in an assignment statement's 'math' subelement.  Let the
 * directed arcs point from the statement assigning the symbol to the
 * statements that contain the symbol in their 'math' subelement expressions.
 * This graph must be acyclic.
 *
 * Similarly, the combined set of RateRule and Reaction objects constitute 
 * a set of definitions for the rates of change of various model entities 
 * (namely, the objects identified by the values of the 'variable' attributes 
 * of the RateRule objects, and the 'species' attributes of the SpeciesReference 
 * objects in each Reaction).  In SBML Level&nbsp;3 Version&nbsp;2, these rates 
 * of change may be referenced directly 
 * using the <em>rateOf</em> csymbol, but may not thereby contain algebraic 
 * loops---dependency chains between these statements must terminate.  More 
 * formally, consider a directed graph in which the nodes are the definitions 
 * of different variables' rates of change, and directed arcs exist for each 
 * occurrence of a variable referenced by a <em>rateOf</em> csymbol from any 
 * RateRule or KineticLaw object in the model.  Let the directed arcs point 
 * from the variable referenced by the <em>rateOf</em> csymbol (call it 
 * <em>x</em>) to the variable(s) determined by the 'math' expression in which
 * <em>x</em> appears.  This graph must be acyclic.
 *
 * SBML does not specify when or how often rules should be evaluated.
 * Eliminating algebraic loops ensures that assignment statements can be
 * evaluated any number of times without the result of those evaluations
 * changing.  As an example, consider the set of equations <em>x = x + 1</em>,
 * <em>y = z + 200</em> and <em>z = y + 100</em>.  If this set of equations
 * were interpreted as a set of assignment statements, it would be invalid
 * because the rule for <em>x</em> refers to <em>x</em> (exhibiting one type
 * of loop), and the rule for <em>y</em> refers to <em>z</em> while the rule
 * for <em>z</em> refers back to <em>y</em> (exhibiting another type of loop).
 * Conversely, the following set of equations would constitute a valid set of
 * assignment statements: <em>x = 10</em>, <em>y = z + 200</em>, and <em>z = x
 * + 100</em>.
 *
 * @subsection rules-not-overdetermined A model must not be overdetermined
 *
 * An SBML model must not be overdetermined; that is, a model must not
 * define more equations than there are unknowns in a model.  A valid SBML model
 * that does not contain AlgebraicRule structures cannot be overdetermined.
 *
 * LibSBML implements the static analysis procedure described in
 * Appendix&nbsp;B of the SBML Level&nbsp;3
 * specification for assessing whether a model is overdetermined.
 *
 * (In summary, assessing whether a given continuous, deterministic,
 * mathematical model is overdetermined does not require dynamic analysis; it
 * can be done by analyzing the system of equations created from the model.
 * One approach is to construct a bipartite graph in which one set of vertices
 * represents the variables and the other the set of vertices represents the
 * equations.  Place edges between vertices such that variables in the system
 * are linked to the equations that determine them.  For algebraic equations,
 * there will be edges between the equation and each variable occurring in the
 * equation.  For ordinary differential equations (such as those defined by
 * rate rules or implied by the reaction rate definitions), there will be a
 * single edge between the equation and the variable determined by that
 * differential equation.  A mathematical model is overdetermined if the
 * maximal matchings of the bipartite graph contain disconnected vertexes
 * representing equations.  If one maximal matching has this property, then
 * all the maximal matchings will have this property; i.e., it is only
 * necessary to find one maximal matching.)
 *
 * @section RuleType_t Rule types for SBML Level 1
 *
 * SBML Level 1 uses a different scheme than SBML Level 2 and Level 3 for
 * distinguishing rules; specifically, it uses an attribute whose value is
 * drawn from an enumeration of 3 values.  LibSBML supports this using methods
 * that work @if clike a libSBML enumeration type,
 * @link Rule::RuleType_t RuleType_t@endlink, whose values
 * are @else with the enumeration values @endif listed below.
 *
 * @li @link libsbml#RULE_TYPE_RATE RULE_TYPE_RATE@endlink: Indicates
 * the rule is a 'rate' rule.
 * @li @link libsbml#RULE_TYPE_SCALAR RULE_TYPE_SCALAR@endlink:
 * Indicates the rule is a 'scalar' rule.
 * @li @link libsbml#RULE_TYPE_INVALID RULE_TYPE_INVALID@endlink:
 * Indicates the rule type is unknown or not yet set.
 *
 *
 */

public class AlgebraicRule : Rule {
	private HandleRef swigCPtr;
	
	internal AlgebraicRule(IntPtr cPtr, bool cMemoryOwn) : base(libsbmlPINVOKE.AlgebraicRule_SWIGUpcast(cPtr), cMemoryOwn)
	{
		//super(libsbmlPINVOKE.AlgebraicRuleUpcast(cPtr), cMemoryOwn);
		swigCPtr = new HandleRef(this, cPtr);
	}
	
	internal static HandleRef getCPtr(AlgebraicRule obj)
	{
		return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
	}
	
	internal static HandleRef getCPtrAndDisown (AlgebraicRule obj)
	{
		HandleRef ptr = new HandleRef(null, IntPtr.Zero);
		
		if (obj != null)
		{
			ptr             = obj.swigCPtr;
			obj.swigCMemOwn = false;
		}
		
		return ptr;
	}

  ~AlgebraicRule() {
    Dispose();
  }

  public override void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          libsbmlPINVOKE.delete_AlgebraicRule(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
      base.Dispose();
    }
  }

  
/**
   * Creates a new AlgebraicRule object using the given SBML @p level and @p
   * version values.
   *
   * @param level the SBML Level to assign to this AlgebraicRule object.
   *
   * @param version the SBML Version to assign to this AlgebraicRule object.
   *
   *
 * @throws SBMLConstructorException
 * Thrown if the given @p level and @p version combination are invalid
 * or if this object is incompatible with the given level and version.
 *
 *
   * 
   *
 * @note Attempting to add an object to an SBMLDocument having a different
 * combination of SBML Level, Version and XML namespaces than the object
 * itself will result in an error at the time a caller attempts to make the
 * addition.  A parent object must have compatible Level, Version and XML
 * namespaces.  (Strictly speaking, a parent may also have more XML
 * namespaces than a child, but the reverse is not permitted.)  The
 * restriction is necessary to ensure that an SBML model has a consistent
 * overall structure.  This requires callers to manage their objects
 * carefully, but the benefit is increased flexibility in how models can be
 * created by permitting callers to create objects bottom-up if desired.  In
 * situations where objects are not yet attached to parents (e.g.,
 * SBMLDocument), knowledge of the intented SBML Level and Version help
 * libSBML determine such things as whether it is valid to assign a
 * particular value to an attribute.
 *
 *
   */ public
 AlgebraicRule(long level, long version) : this(libsbmlPINVOKE.new_AlgebraicRule__SWIG_0(level, version), true) {
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
  }

  
/**
   * Creates a new AlgebraicRule object using the given SBMLNamespaces object
   * @p sbmlns.
   *
   *
 * 
 * The SBMLNamespaces object encapsulates SBML Level/Version/namespaces
 * information.  It is used to communicate the SBML Level, Version, and (in
 * Level&nbsp;3) packages used in addition to SBML Level&nbsp;3 Core.  A
 * common approach to using libSBML's SBMLNamespaces facilities is to create an
 * SBMLNamespaces object somewhere in a program once, then hand that object
 * as needed to object constructors that accept SBMLNamespaces as arguments.
 *
 * 
   *
   * @param sbmlns an SBMLNamespaces object.
   *
   *
 * @throws SBMLConstructorException
 * Thrown if the given @p sbmlns is inconsistent or incompatible
 * with this object.
 *
 *
   *
   *
 * @note Attempting to add an object to an SBMLDocument having a different
 * combination of SBML Level, Version and XML namespaces than the object
 * itself will result in an error at the time a caller attempts to make the
 * addition.  A parent object must have compatible Level, Version and XML
 * namespaces.  (Strictly speaking, a parent may also have more XML
 * namespaces than a child, but the reverse is not permitted.)  The
 * restriction is necessary to ensure that an SBML model has a consistent
 * overall structure.  This requires callers to manage their objects
 * carefully, but the benefit is increased flexibility in how models can be
 * created by permitting callers to create objects bottom-up if desired.  In
 * situations where objects are not yet attached to parents (e.g.,
 * SBMLDocument), knowledge of the intented SBML Level and Version help
 * libSBML determine such things as whether it is valid to assign a
 * particular value to an attribute.
 *
 *
   */ public
 AlgebraicRule(SBMLNamespaces sbmlns) : this(libsbmlPINVOKE.new_AlgebraicRule__SWIG_1(SBMLNamespaces.getCPtr(sbmlns)), true) {
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
  }

  
/**
   * Creates and returns a deep copy of this AlgebraicRule object.
   *
   * @return the (deep) copy of this Rule object.
   */ public new
 AlgebraicRule clone() {
    IntPtr cPtr = libsbmlPINVOKE.AlgebraicRule_clone(swigCPtr);
    AlgebraicRule ret = (cPtr == IntPtr.Zero) ? null : new AlgebraicRule(cPtr, true);
    return ret;
  }

  
/**
   * Predicate returning @c true if all the required attributes for this
   * AlgebraicRule object have been set.
   *
   * In SBML Levels&nbsp;2&ndash;3, there is no required attribute
   * for an AlgebraicRule object.  For Level&nbsp;1, the only required
   * attribute is 'formula'.
   *
   * @return @c true if the required attributes have been set, @c false
   * otherwise.
   */ public new
 bool hasRequiredAttributes() {
    bool ret = libsbmlPINVOKE.AlgebraicRule_hasRequiredAttributes(swigCPtr);
    return ret;
  }

}

}
