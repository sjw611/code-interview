package arrstrings;

import java.util.Objects;

public class Q4 {

	public boolean isPalindromePermutation(String input) {
		String normalised = normalise(input);
		
		int[] counts = new int[128];
		
		for (char c : normalised.toCharArray()) {
			++counts[c];
		}
		
		boolean oddCountPresent = false;
		
		for (int i : counts) {
			if (i % 2 != 0) {
				if (oddCountPresent) {
					return false;
				}
				oddCountPresent = true;
			}
		}
		
		return true;
	}
	
	public boolean isPalindrome(String input) {
		String normalised = normalise(input);
		
		int length = normalised.length();
		int mid = length >> 1;
		
		for (int i = 0; i < mid; ++i) {
			if (normalised.charAt(i) != normalised.charAt(length - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}

	private String normalise(String input) {
		return Objects.requireNonNull(input).replaceAll("\\s+", "").toLowerCase();
	}
}
