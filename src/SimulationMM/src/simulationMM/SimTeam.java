/**
 */
package simulationMM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sim Team</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simulationMM.SimTeam#getName <em>Name</em>}</li>
 *   <li>{@link simulationMM.SimTeam#isHomeTeam <em>Home Team</em>}</li>
 *   <li>{@link simulationMM.SimTeam#getPassing <em>Passing</em>}</li>
 *   <li>{@link simulationMM.SimTeam#getRecovery <em>Recovery</em>}</li>
 *   <li>{@link simulationMM.SimTeam#getShooting <em>Shooting</em>}</li>
 *   <li>{@link simulationMM.SimTeam#getGoalkeeping <em>Goalkeeping</em>}</li>
 *   <li>{@link simulationMM.SimTeam#getFormation <em>Formation</em>}</li>
 *   <li>{@link simulationMM.SimTeam#getDepth <em>Depth</em>}</li>
 *   <li>{@link simulationMM.SimTeam#getPassingStyle <em>Passing Style</em>}</li>
 * </ul>
 *
 * @see simulationMM.SimulationMMPackage#getSimTeam()
 * @model
 * @generated
 */
public interface SimTeam extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see simulationMM.SimulationMMPackage#getSimTeam_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link simulationMM.SimTeam#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Home Team</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Home Team</em>' attribute.
	 * @see #setHomeTeam(boolean)
	 * @see simulationMM.SimulationMMPackage#getSimTeam_HomeTeam()
	 * @model required="true"
	 * @generated
	 */
	boolean isHomeTeam();

	/**
	 * Sets the value of the '{@link simulationMM.SimTeam#isHomeTeam <em>Home Team</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home Team</em>' attribute.
	 * @see #isHomeTeam()
	 * @generated
	 */
	void setHomeTeam(boolean value);

	/**
	 * Returns the value of the '<em><b>Passing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passing</em>' attribute.
	 * @see #setPassing(double)
	 * @see simulationMM.SimulationMMPackage#getSimTeam_Passing()
	 * @model required="true"
	 * @generated
	 */
	double getPassing();

	/**
	 * Sets the value of the '{@link simulationMM.SimTeam#getPassing <em>Passing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passing</em>' attribute.
	 * @see #getPassing()
	 * @generated
	 */
	void setPassing(double value);

	/**
	 * Returns the value of the '<em><b>Recovery</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recovery</em>' attribute.
	 * @see #setRecovery(double)
	 * @see simulationMM.SimulationMMPackage#getSimTeam_Recovery()
	 * @model required="true"
	 * @generated
	 */
	double getRecovery();

	/**
	 * Sets the value of the '{@link simulationMM.SimTeam#getRecovery <em>Recovery</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recovery</em>' attribute.
	 * @see #getRecovery()
	 * @generated
	 */
	void setRecovery(double value);

	/**
	 * Returns the value of the '<em><b>Shooting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shooting</em>' attribute.
	 * @see #setShooting(double)
	 * @see simulationMM.SimulationMMPackage#getSimTeam_Shooting()
	 * @model required="true"
	 * @generated
	 */
	double getShooting();

	/**
	 * Sets the value of the '{@link simulationMM.SimTeam#getShooting <em>Shooting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shooting</em>' attribute.
	 * @see #getShooting()
	 * @generated
	 */
	void setShooting(double value);

	/**
	 * Returns the value of the '<em><b>Goalkeeping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goalkeeping</em>' attribute.
	 * @see #setGoalkeeping(int)
	 * @see simulationMM.SimulationMMPackage#getSimTeam_Goalkeeping()
	 * @model required="true"
	 * @generated
	 */
	int getGoalkeeping();

	/**
	 * Sets the value of the '{@link simulationMM.SimTeam#getGoalkeeping <em>Goalkeeping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goalkeeping</em>' attribute.
	 * @see #getGoalkeeping()
	 * @generated
	 */
	void setGoalkeeping(int value);

	/**
	 * Returns the value of the '<em><b>Formation</b></em>' attribute.
	 * The literals are from the enumeration {@link simulationMM.Formation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formation</em>' attribute.
	 * @see simulationMM.Formation
	 * @see #setFormation(Formation)
	 * @see simulationMM.SimulationMMPackage#getSimTeam_Formation()
	 * @model required="true"
	 * @generated
	 */
	Formation getFormation();

	/**
	 * Sets the value of the '{@link simulationMM.SimTeam#getFormation <em>Formation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formation</em>' attribute.
	 * @see simulationMM.Formation
	 * @see #getFormation()
	 * @generated
	 */
	void setFormation(Formation value);

	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * The literals are from the enumeration {@link simulationMM.Depth}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see simulationMM.Depth
	 * @see #setDepth(Depth)
	 * @see simulationMM.SimulationMMPackage#getSimTeam_Depth()
	 * @model required="true"
	 * @generated
	 */
	Depth getDepth();

	/**
	 * Sets the value of the '{@link simulationMM.SimTeam#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see simulationMM.Depth
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(Depth value);

	/**
	 * Returns the value of the '<em><b>Passing Style</b></em>' attribute.
	 * The literals are from the enumeration {@link simulationMM.PassingStyle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passing Style</em>' attribute.
	 * @see simulationMM.PassingStyle
	 * @see #setPassingStyle(PassingStyle)
	 * @see simulationMM.SimulationMMPackage#getSimTeam_PassingStyle()
	 * @model required="true"
	 * @generated
	 */
	PassingStyle getPassingStyle();

	/**
	 * Sets the value of the '{@link simulationMM.SimTeam#getPassingStyle <em>Passing Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passing Style</em>' attribute.
	 * @see simulationMM.PassingStyle
	 * @see #getPassingStyle()
	 * @generated
	 */
	void setPassingStyle(PassingStyle value);

} // SimTeam
