package recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class StringPermutations {

	public List<String> permutations(String input) {
		Objects.requireNonNull(input);

		if (input.isEmpty() || input.length() == 1) {
			return Collections.singletonList(input);
		}

		List<String> result = new ArrayList<>();
		result.add(input.charAt(0) + "");

		for (int i = 1; i < input.length(); ++i) {
			result = permutations(result, input.charAt(i));
		}

		return new ArrayList<>(new HashSet<>(result));
	}

	private List<String> permutations(List<String> rest, char c) {
		List<String> combined = new ArrayList<>();

		for (String one : rest) {
			for (int i = 0; i <= one.length(); ++i) {
				StringBuilder sb = new StringBuilder(one);
				sb.insert(i, c);
				combined.add(sb.toString());
			}
		}

		return combined;
	}
}
