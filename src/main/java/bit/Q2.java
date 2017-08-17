package bit;

public class Q2 {

	static final String OVERFLOW = "ERROR";
	static final int OVERFLOW_SIZE = 32;

	public String binaryToString(double number) {
		if (number < 0 || number > 1) {
			throw new IllegalArgumentException();
		}

		if (number == 0) {
			return 0 + "";
		}

		if (number == 1) {
			return 1 + "";
		}

		StringBuilder sb = new StringBuilder("0.");

		double remainder = number;
		double multiplier = 0.5;

		for (int i = 3; i <= OVERFLOW_SIZE && remainder != 0; ++i) {
			if (remainder >= multiplier) {
				sb.append(1);
				remainder -= multiplier;
			} else {
				sb.append(0);
			}
			multiplier *= 0.5;
		}

		if (remainder != 0) {
			return OVERFLOW;
		}

		return sb.toString();
	}
}
