package recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BooleanEvaluation {

	public static void main(String[] args) {
		System.out.println(countEvaluations("1^0|0|1", false));
		System.out.println(countEvaluations("0&0&0&1^1|0", true));
	}

	private static class BooleanEvaluationKey {
		private final String expression;
		private final boolean result;

		private BooleanEvaluationKey(String expression, boolean result) {
			this.expression = expression;
			this.result = result;
		}

		@Override
		public boolean equals(Object that) {
			if (this == that) {
				return true;
			}

			if (!(that instanceof BooleanEvaluationKey)) {
				return false;
			}

			BooleanEvaluationKey another = (BooleanEvaluationKey) that;

			return Objects.equals(expression, another.expression) && result == another.result;
		}

		@Override
		public int hashCode() {
			return Objects.hash(expression, result);
		}
	}

	public static int countEvaluations(String expression, boolean result) {
		return countEvaluations(expression, result, new HashMap<>());
	}

	private static int countEvaluations(String s, boolean result, Map<BooleanEvaluationKey, Integer> cache) {
		if (s.isEmpty()) {
			return 0;
		}

		if (s.length() == 1) {
			return stringToBool(s) == result ? 1 : 0;
		}

		BooleanEvaluationKey key = new BooleanEvaluationKey(s, result);
		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		int count = 0;

		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);

			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());

			int leftTrue = countEvaluations(left, true, cache);
			int leftFalse = countEvaluations(left, false, cache);
			int rightTrue = countEvaluations(right, true, cache);
			int rightFalse = countEvaluations(right, false, cache);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

			int totalTrue = 0;

			if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			}
			if (c == '&') {
				totalTrue = leftTrue * rightTrue;
			}
			if (c == '|') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
			}

			int subCount = result ? totalTrue : total - totalTrue;

			count += subCount;
		}

		cache.put(key, count);
		return count;
	}

	private static boolean stringToBool(String s) {
		return s.equals("1");
	}
}
