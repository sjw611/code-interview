package recursive;

public class RecursiveMultiply {

	public long multiply(long a, long b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException();
		}

		if (a > b) {
			return multiplyHelper(a, b);
		}
		return multiplyHelper(b, a);
	}

	private long multiplyHelper(long a, long b) {
		if (b == 2) {
			return a << 1;
		}
		if (b % 2 == 0) {
			return multiplyHelper(a, b / 2) << 1;
		} else {
			return (multiplyHelper(a, b / 2) << 1) + a;
		}
	}
}
