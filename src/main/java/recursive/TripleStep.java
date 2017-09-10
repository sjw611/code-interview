package recursive;

import java.util.Arrays;

public class TripleStep {
	private static final long SENTINEL = -1;

	public long count(int n) {
		long[] cache = new long[n + 1];
		Arrays.fill(cache, SENTINEL);
		return count(n, cache);
	}

	private long count(int n, long[] cache) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (cache[n] == SENTINEL) {
			return cache[n] = count(n - 1, cache) + count(n - 2, cache) + count(n - 3, cache);
		}
		return cache[n];
	}
}
