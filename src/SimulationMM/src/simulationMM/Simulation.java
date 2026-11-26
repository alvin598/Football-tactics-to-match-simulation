/**
 */
package simulationMM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simulationMM.Simulation#getMatchId <em>Match Id</em>}</li>
 *   <li>{@link simulationMM.Simulation#getTicks <em>Ticks</em>}</li>
 *   <li>{@link simulationMM.Simulation#getTeam <em>Team</em>}</li>
 *   <li>{@link simulationMM.Simulation#getNumOfRuns <em>Num Of Runs</em>}</li>
 * </ul>
 *
 * @see simulationMM.SimulationMMPackage#getSimulation()
 * @model
 * @generated
 */
public interface Simulation extends EObject {
	/**
	 * Returns the value of the '<em><b>Match Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match Id</em>' attribute.
	 * @see #setMatchId(int)
	 * @see simulationMM.SimulationMMPackage#getSimulation_MatchId()
	 * @model id="true" required="true"
	 * @generated
	 */
	int getMatchId();

	/**
	 * Sets the value of the '{@link simulationMM.Simulation#getMatchId <em>Match Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match Id</em>' attribute.
	 * @see #getMatchId()
	 * @generated
	 */
	void setMatchId(int value);

	/**
	 * Returns the value of the '<em><b>Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ticks</em>' attribute.
	 * @see #setTicks(int)
	 * @see simulationMM.SimulationMMPackage#getSimulation_Ticks()
	 * @model required="true"
	 * @generated
	 */
	int getTicks();

	/**
	 * Sets the value of the '{@link simulationMM.Simulation#getTicks <em>Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ticks</em>' attribute.
	 * @see #getTicks()
	 * @generated
	 */
	void setTicks(int value);

	/**
	 * Returns the value of the '<em><b>Team</b></em>' containment reference list.
	 * The list contents are of type {@link simulationMM.SimTeam}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team</em>' containment reference list.
	 * @see simulationMM.SimulationMMPackage#getSimulation_Team()
	 * @model containment="true" lower="2" upper="2"
	 * @generated
	 */
	EList<SimTeam> getTeam();

	/**
	 * Returns the value of the '<em><b>Num Of Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Runs</em>' attribute.
	 * @see #setNumOfRuns(int)
	 * @see simulationMM.SimulationMMPackage#getSimulation_NumOfRuns()
	 * @model required="true"
	 * @generated
	 */
	int getNumOfRuns();

	/**
	 * Sets the value of the '{@link simulationMM.Simulation#getNumOfRuns <em>Num Of Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Of Runs</em>' attribute.
	 * @see #getNumOfRuns()
	 * @generated
	 */
	void setNumOfRuns(int value);

} // Simulation
