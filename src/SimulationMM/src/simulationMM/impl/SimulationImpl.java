/**
 */
package simulationMM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import simulationMM.SimTeam;
import simulationMM.Simulation;
import simulationMM.SimulationMMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link simulationMM.impl.SimulationImpl#getMatchId <em>Match Id</em>}</li>
 *   <li>{@link simulationMM.impl.SimulationImpl#getTicks <em>Ticks</em>}</li>
 *   <li>{@link simulationMM.impl.SimulationImpl#getTeam <em>Team</em>}</li>
 *   <li>{@link simulationMM.impl.SimulationImpl#getNumOfRuns <em>Num Of Runs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimulationImpl extends MinimalEObjectImpl.Container implements Simulation {
	/**
	 * The default value of the '{@link #getMatchId() <em>Match Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchId()
	 * @generated
	 * @ordered
	 */
	protected static final int MATCH_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMatchId() <em>Match Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchId()
	 * @generated
	 * @ordered
	 */
	protected int matchId = MATCH_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTicks() <em>Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTicks()
	 * @generated
	 * @ordered
	 */
	protected static final int TICKS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTicks() <em>Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTicks()
	 * @generated
	 * @ordered
	 */
	protected int ticks = TICKS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTeam() <em>Team</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam()
	 * @generated
	 * @ordered
	 */
	protected EList<SimTeam> team;

	/**
	 * The default value of the '{@link #getNumOfRuns() <em>Num Of Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfRuns()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_OF_RUNS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumOfRuns() <em>Num Of Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfRuns()
	 * @generated
	 * @ordered
	 */
	protected int numOfRuns = NUM_OF_RUNS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationMMPackage.Literals.SIMULATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMatchId() {
		return matchId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatchId(int newMatchId) {
		int oldMatchId = matchId;
		matchId = newMatchId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIMULATION__MATCH_ID, oldMatchId, matchId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTicks() {
		return ticks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTicks(int newTicks) {
		int oldTicks = ticks;
		ticks = newTicks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIMULATION__TICKS, oldTicks, ticks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SimTeam> getTeam() {
		if (team == null) {
			team = new EObjectContainmentEList<SimTeam>(SimTeam.class, this, SimulationMMPackage.SIMULATION__TEAM);
		}
		return team;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumOfRuns() {
		return numOfRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumOfRuns(int newNumOfRuns) {
		int oldNumOfRuns = numOfRuns;
		numOfRuns = newNumOfRuns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIMULATION__NUM_OF_RUNS, oldNumOfRuns, numOfRuns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulationMMPackage.SIMULATION__TEAM:
				return ((InternalEList<?>)getTeam()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulationMMPackage.SIMULATION__MATCH_ID:
				return getMatchId();
			case SimulationMMPackage.SIMULATION__TICKS:
				return getTicks();
			case SimulationMMPackage.SIMULATION__TEAM:
				return getTeam();
			case SimulationMMPackage.SIMULATION__NUM_OF_RUNS:
				return getNumOfRuns();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulationMMPackage.SIMULATION__MATCH_ID:
				setMatchId((Integer)newValue);
				return;
			case SimulationMMPackage.SIMULATION__TICKS:
				setTicks((Integer)newValue);
				return;
			case SimulationMMPackage.SIMULATION__TEAM:
				getTeam().clear();
				getTeam().addAll((Collection<? extends SimTeam>)newValue);
				return;
			case SimulationMMPackage.SIMULATION__NUM_OF_RUNS:
				setNumOfRuns((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SimulationMMPackage.SIMULATION__MATCH_ID:
				setMatchId(MATCH_ID_EDEFAULT);
				return;
			case SimulationMMPackage.SIMULATION__TICKS:
				setTicks(TICKS_EDEFAULT);
				return;
			case SimulationMMPackage.SIMULATION__TEAM:
				getTeam().clear();
				return;
			case SimulationMMPackage.SIMULATION__NUM_OF_RUNS:
				setNumOfRuns(NUM_OF_RUNS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SimulationMMPackage.SIMULATION__MATCH_ID:
				return matchId != MATCH_ID_EDEFAULT;
			case SimulationMMPackage.SIMULATION__TICKS:
				return ticks != TICKS_EDEFAULT;
			case SimulationMMPackage.SIMULATION__TEAM:
				return team != null && !team.isEmpty();
			case SimulationMMPackage.SIMULATION__NUM_OF_RUNS:
				return numOfRuns != NUM_OF_RUNS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (matchId: ");
		result.append(matchId);
		result.append(", ticks: ");
		result.append(ticks);
		result.append(", numOfRuns: ");
		result.append(numOfRuns);
		result.append(')');
		return result.toString();
	}

} //SimulationImpl
