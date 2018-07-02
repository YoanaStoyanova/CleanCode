package geometry.shapes;
/**
 * Class providing common validation methods
 * 
 * @author Joana
 *
 */
public class Validators {

	public static boolean less(Double A, Double B) {
		if (A.compareTo(B) < 0) {
			return true;
		} else {
			throw new IllegalArgumentException("Value of arg " + A + " is not less than value of " + B);
		}
	}

	public static boolean positive(Double A) {
		if (A.compareTo(0.0) > 0) {
			return true;
		} else {
			throw new IndexOutOfBoundsException("Negative argument value " + A);
		}
	}

	public static boolean areEqual(Double A, Double B) {
		if (A.compareTo(B) == 0) {
			return true;
		} else {
			throw new IllegalArgumentException("Value of " + A + " not equal to value of " + B);
		}
	}

	public static boolean notEqual(Double A, Double B) {
		if (A.compareTo(B) != 0) {
			return true;
		} else {
			throw new IllegalArgumentException("Value of  " + A + " equal to value of  " + B);
		}
	}
	
	public static boolean notNull(Double A) {
		if ( A != null) {
			return true;
		}else {
			throw new NullPointerException("Invalid null value");
		}
	}
}
