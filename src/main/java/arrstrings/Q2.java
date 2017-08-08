package arrstrings;

public class Q2 {
	public boolean isPermutation(String one, String other) {
		if (one == null && other == null) {
			return true;
		}

		if (one == null || other == null) {
			return false;
		}

		if (one.length() != other.length()) {
			return false;
		}

		int[] counts = new int[128];

		for (char c : one.toCharArray()) {
			++counts[c];
		}

		for (char c : other.toCharArray()) {
			if (--counts[c] < 0) {
				return false;
			}
		}

		return true;
	}
}
