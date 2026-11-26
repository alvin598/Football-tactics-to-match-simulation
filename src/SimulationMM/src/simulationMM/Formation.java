/**
 */
package simulationMM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Formation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see simulationMM.SimulationMMPackage#getFormation()
 * @model
 * @generated
 */
public enum Formation implements Enumerator {
	/**
	 * The '<em><b>F442</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #F442_VALUE
	 * @generated
	 * @ordered
	 */
	F442(0, "F442", "F442"),

	/**
	 * The '<em><b>F433</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #F433_VALUE
	 * @generated
	 * @ordered
	 */
	F433(1, "F433", "F433"),

	/**
	 * The '<em><b>F352</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #F352_VALUE
	 * @generated
	 * @ordered
	 */
	F352(2, "F352", "F352");

	/**
	 * The '<em><b>F442</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #F442
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int F442_VALUE = 0;

	/**
	 * The '<em><b>F433</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #F433
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int F433_VALUE = 1;

	/**
	 * The '<em><b>F352</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #F352
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int F352_VALUE = 2;

	/**
	 * An array of all the '<em><b>Formation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Formation[] VALUES_ARRAY =
		new Formation[] {
			F442,
			F433,
			F352,
		};

	/**
	 * A public read-only list of all the '<em><b>Formation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Formation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Formation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Formation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Formation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Formation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Formation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Formation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Formation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Formation get(int value) {
		switch (value) {
			case F442_VALUE: return F442;
			case F433_VALUE: return F433;
			case F352_VALUE: return F352;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Formation(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Formation
