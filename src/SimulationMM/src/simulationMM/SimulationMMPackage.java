/**
 */
package simulationMM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see simulationMM.SimulationMMFactory
 * @model kind="package"
 * @generated
 */
public interface SimulationMMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simulationMM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://lnu.se/4dt903/simulation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simulationMM";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimulationMMPackage eINSTANCE = simulationMM.impl.SimulationMMPackageImpl.init();

	/**
	 * The meta object id for the '{@link simulationMM.impl.SimulationImpl <em>Simulation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simulationMM.impl.SimulationImpl
	 * @see simulationMM.impl.SimulationMMPackageImpl#getSimulation()
	 * @generated
	 */
	int SIMULATION = 0;

	/**
	 * The feature id for the '<em><b>Match Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION__MATCH_ID = 0;

	/**
	 * The feature id for the '<em><b>Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION__TICKS = 1;

	/**
	 * The feature id for the '<em><b>Team</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION__TEAM = 2;

	/**
	 * The feature id for the '<em><b>Num Of Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION__NUM_OF_RUNS = 3;

	/**
	 * The number of structural features of the '<em>Simulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Simulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link simulationMM.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simulationMM.impl.RuleImpl
	 * @see simulationMM.impl.SimulationMMPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 1;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__PROBABILITY = 0;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link simulationMM.impl.SimTeamImpl <em>Sim Team</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simulationMM.impl.SimTeamImpl
	 * @see simulationMM.impl.SimulationMMPackageImpl#getSimTeam()
	 * @generated
	 */
	int SIM_TEAM = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Home Team</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM__HOME_TEAM = 1;

	/**
	 * The feature id for the '<em><b>Passing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM__PASSING = 2;

	/**
	 * The feature id for the '<em><b>Recovery</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM__RECOVERY = 3;

	/**
	 * The feature id for the '<em><b>Shooting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM__SHOOTING = 4;

	/**
	 * The feature id for the '<em><b>Goalkeeping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM__GOALKEEPING = 5;

	/**
	 * The feature id for the '<em><b>Formation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM__FORMATION = 6;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM__DEPTH = 7;

	/**
	 * The feature id for the '<em><b>Passing Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM__PASSING_STYLE = 8;

	/**
	 * The number of structural features of the '<em>Sim Team</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Sim Team</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_TEAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link simulationMM.Formation <em>Formation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simulationMM.Formation
	 * @see simulationMM.impl.SimulationMMPackageImpl#getFormation()
	 * @generated
	 */
	int FORMATION = 3;

	/**
	 * The meta object id for the '{@link simulationMM.Depth <em>Depth</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simulationMM.Depth
	 * @see simulationMM.impl.SimulationMMPackageImpl#getDepth()
	 * @generated
	 */
	int DEPTH = 4;

	/**
	 * The meta object id for the '{@link simulationMM.PassingStyle <em>Passing Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simulationMM.PassingStyle
	 * @see simulationMM.impl.SimulationMMPackageImpl#getPassingStyle()
	 * @generated
	 */
	int PASSING_STYLE = 5;


	/**
	 * Returns the meta object for class '{@link simulationMM.Simulation <em>Simulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation</em>'.
	 * @see simulationMM.Simulation
	 * @generated
	 */
	EClass getSimulation();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.Simulation#getMatchId <em>Match Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Match Id</em>'.
	 * @see simulationMM.Simulation#getMatchId()
	 * @see #getSimulation()
	 * @generated
	 */
	EAttribute getSimulation_MatchId();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.Simulation#getTicks <em>Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ticks</em>'.
	 * @see simulationMM.Simulation#getTicks()
	 * @see #getSimulation()
	 * @generated
	 */
	EAttribute getSimulation_Ticks();

	/**
	 * Returns the meta object for the containment reference list '{@link simulationMM.Simulation#getTeam <em>Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Team</em>'.
	 * @see simulationMM.Simulation#getTeam()
	 * @see #getSimulation()
	 * @generated
	 */
	EReference getSimulation_Team();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.Simulation#getNumOfRuns <em>Num Of Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Of Runs</em>'.
	 * @see simulationMM.Simulation#getNumOfRuns()
	 * @see #getSimulation()
	 * @generated
	 */
	EAttribute getSimulation_NumOfRuns();

	/**
	 * Returns the meta object for class '{@link simulationMM.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see simulationMM.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.Rule#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see simulationMM.Rule#getProbability()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Probability();

	/**
	 * Returns the meta object for class '{@link simulationMM.SimTeam <em>Sim Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sim Team</em>'.
	 * @see simulationMM.SimTeam
	 * @generated
	 */
	EClass getSimTeam();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.SimTeam#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see simulationMM.SimTeam#getName()
	 * @see #getSimTeam()
	 * @generated
	 */
	EAttribute getSimTeam_Name();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.SimTeam#isHomeTeam <em>Home Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Team</em>'.
	 * @see simulationMM.SimTeam#isHomeTeam()
	 * @see #getSimTeam()
	 * @generated
	 */
	EAttribute getSimTeam_HomeTeam();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.SimTeam#getPassing <em>Passing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passing</em>'.
	 * @see simulationMM.SimTeam#getPassing()
	 * @see #getSimTeam()
	 * @generated
	 */
	EAttribute getSimTeam_Passing();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.SimTeam#getRecovery <em>Recovery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recovery</em>'.
	 * @see simulationMM.SimTeam#getRecovery()
	 * @see #getSimTeam()
	 * @generated
	 */
	EAttribute getSimTeam_Recovery();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.SimTeam#getShooting <em>Shooting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shooting</em>'.
	 * @see simulationMM.SimTeam#getShooting()
	 * @see #getSimTeam()
	 * @generated
	 */
	EAttribute getSimTeam_Shooting();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.SimTeam#getGoalkeeping <em>Goalkeeping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goalkeeping</em>'.
	 * @see simulationMM.SimTeam#getGoalkeeping()
	 * @see #getSimTeam()
	 * @generated
	 */
	EAttribute getSimTeam_Goalkeeping();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.SimTeam#getFormation <em>Formation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Formation</em>'.
	 * @see simulationMM.SimTeam#getFormation()
	 * @see #getSimTeam()
	 * @generated
	 */
	EAttribute getSimTeam_Formation();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.SimTeam#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see simulationMM.SimTeam#getDepth()
	 * @see #getSimTeam()
	 * @generated
	 */
	EAttribute getSimTeam_Depth();

	/**
	 * Returns the meta object for the attribute '{@link simulationMM.SimTeam#getPassingStyle <em>Passing Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passing Style</em>'.
	 * @see simulationMM.SimTeam#getPassingStyle()
	 * @see #getSimTeam()
	 * @generated
	 */
	EAttribute getSimTeam_PassingStyle();

	/**
	 * Returns the meta object for enum '{@link simulationMM.Formation <em>Formation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Formation</em>'.
	 * @see simulationMM.Formation
	 * @generated
	 */
	EEnum getFormation();

	/**
	 * Returns the meta object for enum '{@link simulationMM.Depth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Depth</em>'.
	 * @see simulationMM.Depth
	 * @generated
	 */
	EEnum getDepth();

	/**
	 * Returns the meta object for enum '{@link simulationMM.PassingStyle <em>Passing Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Passing Style</em>'.
	 * @see simulationMM.PassingStyle
	 * @generated
	 */
	EEnum getPassingStyle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimulationMMFactory getSimulationMMFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link simulationMM.impl.SimulationImpl <em>Simulation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simulationMM.impl.SimulationImpl
		 * @see simulationMM.impl.SimulationMMPackageImpl#getSimulation()
		 * @generated
		 */
		EClass SIMULATION = eINSTANCE.getSimulation();

		/**
		 * The meta object literal for the '<em><b>Match Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION__MATCH_ID = eINSTANCE.getSimulation_MatchId();

		/**
		 * The meta object literal for the '<em><b>Ticks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION__TICKS = eINSTANCE.getSimulation_Ticks();

		/**
		 * The meta object literal for the '<em><b>Team</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION__TEAM = eINSTANCE.getSimulation_Team();

		/**
		 * The meta object literal for the '<em><b>Num Of Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION__NUM_OF_RUNS = eINSTANCE.getSimulation_NumOfRuns();

		/**
		 * The meta object literal for the '{@link simulationMM.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simulationMM.impl.RuleImpl
		 * @see simulationMM.impl.SimulationMMPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__PROBABILITY = eINSTANCE.getRule_Probability();

		/**
		 * The meta object literal for the '{@link simulationMM.impl.SimTeamImpl <em>Sim Team</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simulationMM.impl.SimTeamImpl
		 * @see simulationMM.impl.SimulationMMPackageImpl#getSimTeam()
		 * @generated
		 */
		EClass SIM_TEAM = eINSTANCE.getSimTeam();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TEAM__NAME = eINSTANCE.getSimTeam_Name();

		/**
		 * The meta object literal for the '<em><b>Home Team</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TEAM__HOME_TEAM = eINSTANCE.getSimTeam_HomeTeam();

		/**
		 * The meta object literal for the '<em><b>Passing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TEAM__PASSING = eINSTANCE.getSimTeam_Passing();

		/**
		 * The meta object literal for the '<em><b>Recovery</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TEAM__RECOVERY = eINSTANCE.getSimTeam_Recovery();

		/**
		 * The meta object literal for the '<em><b>Shooting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TEAM__SHOOTING = eINSTANCE.getSimTeam_Shooting();

		/**
		 * The meta object literal for the '<em><b>Goalkeeping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TEAM__GOALKEEPING = eINSTANCE.getSimTeam_Goalkeeping();

		/**
		 * The meta object literal for the '<em><b>Formation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TEAM__FORMATION = eINSTANCE.getSimTeam_Formation();

		/**
		 * The meta object literal for the '<em><b>Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TEAM__DEPTH = eINSTANCE.getSimTeam_Depth();

		/**
		 * The meta object literal for the '<em><b>Passing Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIM_TEAM__PASSING_STYLE = eINSTANCE.getSimTeam_PassingStyle();

		/**
		 * The meta object literal for the '{@link simulationMM.Formation <em>Formation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simulationMM.Formation
		 * @see simulationMM.impl.SimulationMMPackageImpl#getFormation()
		 * @generated
		 */
		EEnum FORMATION = eINSTANCE.getFormation();

		/**
		 * The meta object literal for the '{@link simulationMM.Depth <em>Depth</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simulationMM.Depth
		 * @see simulationMM.impl.SimulationMMPackageImpl#getDepth()
		 * @generated
		 */
		EEnum DEPTH = eINSTANCE.getDepth();

		/**
		 * The meta object literal for the '{@link simulationMM.PassingStyle <em>Passing Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simulationMM.PassingStyle
		 * @see simulationMM.impl.SimulationMMPackageImpl#getPassingStyle()
		 * @generated
		 */
		EEnum PASSING_STYLE = eINSTANCE.getPassingStyle();

	}

} //SimulationMMPackage
