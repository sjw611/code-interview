package recursive;

public class Fibonacci {

	private static final int MAX_FIB_N = 1000;

	public int fib(int i) {
		if (i <= 0) {
			throw new IllegalArgumentException("Please enter positive number only. Actual: " + i);
		}

		if (i >= MAX_FIB_N) {
			throw new IllegalArgumentException("Sorry too large fibonacci number requested: " + i);
		}

		int a = 0;
		int b = 1;
		int c = 1;

		for (int j = 3; j <= i; ++j) {
			a = b + c;
			b = c;
			c = a;
		}

		return c;
	}

}
