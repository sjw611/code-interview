package arrstrings;

import java.util.Objects;

public class Q1 {

	public boolean isUnique(String str) {
		Objects.requireNonNull(str);

		int alphabet = 0;

		for (char c : str.toCharArray()) {
			int offset = c - 'a';
			int location = 1 << offset;
			alphabet = alphabet ^ location;
			int check = (alphabet >> offset) % 2;
			if (check == 0) {
				return false;
			}
		}

		return true;
	}
}
