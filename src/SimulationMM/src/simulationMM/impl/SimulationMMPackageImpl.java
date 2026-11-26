/**
 */
package simulationMM.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import simulationMM.Depth;
import simulationMM.Formation;
import simulationMM.PassingStyle;
import simulationMM.Rule;
import simulationMM.SimTeam;
import simulationMM.Simulation;
import simulationMM.SimulationMMFactory;
import simulationMM.SimulationMMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulationMMPackageImpl extends EPackageImpl implements SimulationMMPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simTeamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum formationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum depthEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum passingStyleEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see simulationMM.SimulationMMPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SimulationMMPackageImpl() {
		super(eNS_URI, SimulationMMFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link SimulationMMPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SimulationMMPackage init() {
		if (isInited) return (SimulationMMPackage)EPackage.Registry.INSTANCE.getEPackage(SimulationMMPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSimulationMMPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SimulationMMPackageImpl theSimulationMMPackage = registeredSimulationMMPackage instanceof SimulationMMPackageImpl ? (SimulationMMPackageImpl)registeredSimulationMMPackage : new SimulationMMPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theSimulationMMPackage.createPackageContents();

		// Initialize created meta-data
		theSimulationMMPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSimulationMMPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SimulationMMPackage.eNS_URI, theSimulationMMPackage);
		return theSimulationMMPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimulation() {
		return simulationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulation_MatchId() {
		return (EAttribute)simulationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulation_Ticks() {
		return (EAttribute)simulationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimulation_Team() {
		return (EReference)simulationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimulation_NumOfRuns() {
		return (EAttribute)simulationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRule_Probability() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimTeam() {
		return simTeamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimTeam_Name() {
		return (EAttribute)simTeamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimTeam_HomeTeam() {
		return (EAttribute)simTeamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimTeam_Passing() {
		return (EAttribute)simTeamEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimTeam_Recovery() {
		return (EAttribute)simTeamEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimTeam_Shooting() {
		return (EAttribute)simTeamEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimTeam_Goalkeeping() {
		return (EAttribute)simTeamEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimTeam_Formation() {
		return (EAttribute)simTeamEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimTeam_Depth() {
		return (EAttribute)simTeamEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimTeam_PassingStyle() {
		return (EAttribute)simTeamEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getFormation() {
		return formationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDepth() {
		return depthEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPassingStyle() {
		return passingStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimulationMMFactory getSimulationMMFactory() {
		return (SimulationMMFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		simulationEClass = createEClass(SIMULATION);
		createEAttribute(simulationEClass, SIMULATION__MATCH_ID);
		createEAttribute(simulationEClass, SIMULATION__TICKS);
		createEReference(simulationEClass, SIMULATION__TEAM);
		createEAttribute(simulationEClass, SIMULATION__NUM_OF_RUNS);

		ruleEClass = createEClass(RULE);
		createEAttribute(ruleEClass, RULE__PROBABILITY);

		simTeamEClass = createEClass(SIM_TEAM);
		createEAttribute(simTeamEClass, SIM_TEAM__NAME);
		createEAttribute(simTeamEClass, SIM_TEAM__HOME_TEAM);
		createEAttribute(simTeamEClass, SIM_TEAM__PASSING);
		createEAttribute(simTeamEClass, SIM_TEAM__RECOVERY);
		createEAttribute(simTeamEClass, SIM_TEAM__SHOOTING);
		createEAttribute(simTeamEClass, SIM_TEAM__GOALKEEPING);
		createEAttribute(simTeamEClass, SIM_TEAM__FORMATION);
		createEAttribute(simTeamEClass, SIM_TEAM__DEPTH);
		createEAttribute(simTeamEClass, SIM_TEAM__PASSING_STYLE);

		// Create enums
		formationEEnum = createEEnum(FORMATION);
		depthEEnum = createEEnum(DEPTH);
		passingStyleEEnum = createEEnum(PASSING_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(simulationEClass, Simulation.class, "Simulation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimulation_MatchId(), ecorePackage.getEInt(), "matchId", null, 1, 1, Simulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulation_Ticks(), ecorePackage.getEInt(), "ticks", null, 1, 1, Simulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulation_Team(), this.getSimTeam(), null, "team", null, 2, 2, Simulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulation_NumOfRuns(), ecorePackage.getEInt(), "numOfRuns", null, 1, 1, Simulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRule_Probability(), ecorePackage.getEInt(), "probability", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simTeamEClass, SimTeam.class, "SimTeam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimTeam_Name(), ecorePackage.getEString(), "name", null, 1, 1, SimTeam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimTeam_HomeTeam(), ecorePackage.getEBoolean(), "homeTeam", null, 1, 1, SimTeam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimTeam_Passing(), ecorePackage.getEDouble(), "passing", null, 1, 1, SimTeam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimTeam_Recovery(), ecorePackage.getEDouble(), "recovery", null, 1, 1, SimTeam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimTeam_Shooting(), ecorePackage.getEDouble(), "shooting", null, 1, 1, SimTeam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimTeam_Goalkeeping(), ecorePackage.getEInt(), "goalkeeping", null, 1, 1, SimTeam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimTeam_Formation(), this.getFormation(), "formation", null, 1, 1, SimTeam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimTeam_Depth(), this.getDepth(), "depth", null, 1, 1, SimTeam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimTeam_PassingStyle(), this.getPassingStyle(), "passingStyle", null, 1, 1, SimTeam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(formationEEnum, Formation.class, "Formation");
		addEEnumLiteral(formationEEnum, Formation.F442);
		addEEnumLiteral(formationEEnum, Formation.F433);
		addEEnumLiteral(formationEEnum, Formation.F352);

		initEEnum(depthEEnum, Depth.class, "Depth");
		addEEnumLiteral(depthEEnum, Depth.LOW);
		addEEnumLiteral(depthEEnum, Depth.MEDIUM);
		addEEnumLiteral(depthEEnum, Depth.HIGH);

		initEEnum(passingStyleEEnum, PassingStyle.class, "PassingStyle");
		addEEnumLiteral(passingStyleEEnum, PassingStyle.ONE_TOUCH);
		addEEnumLiteral(passingStyleEEnum, PassingStyle.LONG_BALLS);
		addEEnumLiteral(passingStyleEEnum, PassingStyle.TARGET_MAN);

		// Create resource
		createResource(eNS_URI);
	}

} //SimulationMMPackageImpl
