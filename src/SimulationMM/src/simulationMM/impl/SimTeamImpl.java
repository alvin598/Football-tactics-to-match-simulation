/**
 */
package simulationMM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import simulationMM.Depth;
import simulationMM.Formation;
import simulationMM.PassingStyle;
import simulationMM.SimTeam;
import simulationMM.SimulationMMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sim Team</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link simulationMM.impl.SimTeamImpl#getName <em>Name</em>}</li>
 *   <li>{@link simulationMM.impl.SimTeamImpl#isHomeTeam <em>Home Team</em>}</li>
 *   <li>{@link simulationMM.impl.SimTeamImpl#getPassing <em>Passing</em>}</li>
 *   <li>{@link simulationMM.impl.SimTeamImpl#getRecovery <em>Recovery</em>}</li>
 *   <li>{@link simulationMM.impl.SimTeamImpl#getShooting <em>Shooting</em>}</li>
 *   <li>{@link simulationMM.impl.SimTeamImpl#getGoalkeeping <em>Goalkeeping</em>}</li>
 *   <li>{@link simulationMM.impl.SimTeamImpl#getFormation <em>Formation</em>}</li>
 *   <li>{@link simulationMM.impl.SimTeamImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link simulationMM.impl.SimTeamImpl#getPassingStyle <em>Passing Style</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimTeamImpl extends MinimalEObjectImpl.Container implements SimTeam {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isHomeTeam() <em>Home Team</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHomeTeam()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HOME_TEAM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHomeTeam() <em>Home Team</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHomeTeam()
	 * @generated
	 * @ordered
	 */
	protected boolean homeTeam = HOME_TEAM_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassing() <em>Passing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassing()
	 * @generated
	 * @ordered
	 */
	protected static final double PASSING_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPassing() <em>Passing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassing()
	 * @generated
	 * @ordered
	 */
	protected double passing = PASSING_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecovery() <em>Recovery</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecovery()
	 * @generated
	 * @ordered
	 */
	protected static final double RECOVERY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRecovery() <em>Recovery</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecovery()
	 * @generated
	 * @ordered
	 */
	protected double recovery = RECOVERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getShooting() <em>Shooting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShooting()
	 * @generated
	 * @ordered
	 */
	protected static final double SHOOTING_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getShooting() <em>Shooting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShooting()
	 * @generated
	 * @ordered
	 */
	protected double shooting = SHOOTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoalkeeping() <em>Goalkeeping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalkeeping()
	 * @generated
	 * @ordered
	 */
	protected static final int GOALKEEPING_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGoalkeeping() <em>Goalkeeping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalkeeping()
	 * @generated
	 * @ordered
	 */
	protected int goalkeeping = GOALKEEPING_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormation() <em>Formation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormation()
	 * @generated
	 * @ordered
	 */
	protected static final Formation FORMATION_EDEFAULT = Formation.F442;

	/**
	 * The cached value of the '{@link #getFormation() <em>Formation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormation()
	 * @generated
	 * @ordered
	 */
	protected Formation formation = FORMATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepth() <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepth()
	 * @generated
	 * @ordered
	 */
	protected static final Depth DEPTH_EDEFAULT = Depth.LOW;

	/**
	 * The cached value of the '{@link #getDepth() <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepth()
	 * @generated
	 * @ordered
	 */
	protected Depth depth = DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassingStyle() <em>Passing Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassingStyle()
	 * @generated
	 * @ordered
	 */
	protected static final PassingStyle PASSING_STYLE_EDEFAULT = PassingStyle.ONE_TOUCH;

	/**
	 * The cached value of the '{@link #getPassingStyle() <em>Passing Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassingStyle()
	 * @generated
	 * @ordered
	 */
	protected PassingStyle passingStyle = PASSING_STYLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimTeamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationMMPackage.Literals.SIM_TEAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIM_TEAM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHomeTeam() {
		return homeTeam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHomeTeam(boolean newHomeTeam) {
		boolean oldHomeTeam = homeTeam;
		homeTeam = newHomeTeam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIM_TEAM__HOME_TEAM, oldHomeTeam, homeTeam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPassing() {
		return passing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPassing(double newPassing) {
		double oldPassing = passing;
		passing = newPassing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIM_TEAM__PASSING, oldPassing, passing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRecovery() {
		return recovery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecovery(double newRecovery) {
		double oldRecovery = recovery;
		recovery = newRecovery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIM_TEAM__RECOVERY, oldRecovery, recovery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getShooting() {
		return shooting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShooting(double newShooting) {
		double oldShooting = shooting;
		shooting = newShooting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIM_TEAM__SHOOTING, oldShooting, shooting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGoalkeeping() {
		return goalkeeping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGoalkeeping(int newGoalkeeping) {
		int oldGoalkeeping = goalkeeping;
		goalkeeping = newGoalkeeping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIM_TEAM__GOALKEEPING, oldGoalkeeping, goalkeeping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Formation getFormation() {
		return formation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFormation(Formation newFormation) {
		Formation oldFormation = formation;
		formation = newFormation == null ? FORMATION_EDEFAULT : newFormation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIM_TEAM__FORMATION, oldFormation, formation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Depth getDepth() {
		return depth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepth(Depth newDepth) {
		Depth oldDepth = depth;
		depth = newDepth == null ? DEPTH_EDEFAULT : newDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIM_TEAM__DEPTH, oldDepth, depth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PassingStyle getPassingStyle() {
		return passingStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPassingStyle(PassingStyle newPassingStyle) {
		PassingStyle oldPassingStyle = passingStyle;
		passingStyle = newPassingStyle == null ? PASSING_STYLE_EDEFAULT : newPassingStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationMMPackage.SIM_TEAM__PASSING_STYLE, oldPassingStyle, passingStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulationMMPackage.SIM_TEAM__NAME:
				return getName();
			case SimulationMMPackage.SIM_TEAM__HOME_TEAM:
				return isHomeTeam();
			case SimulationMMPackage.SIM_TEAM__PASSING:
				return getPassing();
			case SimulationMMPackage.SIM_TEAM__RECOVERY:
				return getRecovery();
			case SimulationMMPackage.SIM_TEAM__SHOOTING:
				return getShooting();
			case SimulationMMPackage.SIM_TEAM__GOALKEEPING:
				return getGoalkeeping();
			case SimulationMMPackage.SIM_TEAM__FORMATION:
				return getFormation();
			case SimulationMMPackage.SIM_TEAM__DEPTH:
				return getDepth();
			case SimulationMMPackage.SIM_TEAM__PASSING_STYLE:
				return getPassingStyle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulationMMPackage.SIM_TEAM__NAME:
				setName((String)newValue);
				return;
			case SimulationMMPackage.SIM_TEAM__HOME_TEAM:
				setHomeTeam((Boolean)newValue);
				return;
			case SimulationMMPackage.SIM_TEAM__PASSING:
				setPassing((Double)newValue);
				return;
			case SimulationMMPackage.SIM_TEAM__RECOVERY:
				setRecovery((Double)newValue);
				return;
			case SimulationMMPackage.SIM_TEAM__SHOOTING:
				setShooting((Double)newValue);
				return;
			case SimulationMMPackage.SIM_TEAM__GOALKEEPING:
				setGoalkeeping((Integer)newValue);
				return;
			case SimulationMMPackage.SIM_TEAM__FORMATION:
				setFormation((Formation)newValue);
				return;
			case SimulationMMPackage.SIM_TEAM__DEPTH:
				setDepth((Depth)newValue);
				return;
			case SimulationMMPackage.SIM_TEAM__PASSING_STYLE:
				setPassingStyle((PassingStyle)newValue);
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
			case SimulationMMPackage.SIM_TEAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SimulationMMPackage.SIM_TEAM__HOME_TEAM:
				setHomeTeam(HOME_TEAM_EDEFAULT);
				return;
			case SimulationMMPackage.SIM_TEAM__PASSING:
				setPassing(PASSING_EDEFAULT);
				return;
			case SimulationMMPackage.SIM_TEAM__RECOVERY:
				setRecovery(RECOVERY_EDEFAULT);
				return;
			case SimulationMMPackage.SIM_TEAM__SHOOTING:
				setShooting(SHOOTING_EDEFAULT);
				return;
			case SimulationMMPackage.SIM_TEAM__GOALKEEPING:
				setGoalkeeping(GOALKEEPING_EDEFAULT);
				return;
			case SimulationMMPackage.SIM_TEAM__FORMATION:
				setFormation(FORMATION_EDEFAULT);
				return;
			case SimulationMMPackage.SIM_TEAM__DEPTH:
				setDepth(DEPTH_EDEFAULT);
				return;
			case SimulationMMPackage.SIM_TEAM__PASSING_STYLE:
				setPassingStyle(PASSING_STYLE_EDEFAULT);
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
			case SimulationMMPackage.SIM_TEAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SimulationMMPackage.SIM_TEAM__HOME_TEAM:
				return homeTeam != HOME_TEAM_EDEFAULT;
			case SimulationMMPackage.SIM_TEAM__PASSING:
				return passing != PASSING_EDEFAULT;
			case SimulationMMPackage.SIM_TEAM__RECOVERY:
				return recovery != RECOVERY_EDEFAULT;
			case SimulationMMPackage.SIM_TEAM__SHOOTING:
				return shooting != SHOOTING_EDEFAULT;
			case SimulationMMPackage.SIM_TEAM__GOALKEEPING:
				return goalkeeping != GOALKEEPING_EDEFAULT;
			case SimulationMMPackage.SIM_TEAM__FORMATION:
				return formation != FORMATION_EDEFAULT;
			case SimulationMMPackage.SIM_TEAM__DEPTH:
				return depth != DEPTH_EDEFAULT;
			case SimulationMMPackage.SIM_TEAM__PASSING_STYLE:
				return passingStyle != PASSING_STYLE_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", homeTeam: ");
		result.append(homeTeam);
		result.append(", passing: ");
		result.append(passing);
		result.append(", recovery: ");
		result.append(recovery);
		result.append(", shooting: ");
		result.append(shooting);
		result.append(", goalkeeping: ");
		result.append(goalkeeping);
		result.append(", formation: ");
		result.append(formation);
		result.append(", depth: ");
		result.append(depth);
		result.append(", passingStyle: ");
		result.append(passingStyle);
		result.append(')');
		return result.toString();
	}

} //SimTeamImpl
