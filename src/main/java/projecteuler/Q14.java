package projecteuler;

public class Q14 {
	public static void main(String[] args) {
		long limit = 1_000_000;
		long maxChainLength = 1;

		for (long i = 1; i < limit; ++i) {
			long chainLength = chainLength(i);
			if (chainLength > maxChainLength) {
				maxChainLength = chainLength;
				System.out.println("Number " + i + " has chain length " + chainLength);
			}
		}
	}

	private static long chainLength(long num) {
		long current = num;
		long length = 1;

		while (current != 1) {
			if (current % 2 == 0) {
				current = current / 2;
			} else {
				current = 3 * current + 1;
			}
			++length;
		}
		return length;
	}
}
