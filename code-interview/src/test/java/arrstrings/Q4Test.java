package arrstrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q4Test {

	private Q4 sut = new Q4();
	
	@Test(expected = NullPointerException.class)
	public void nullCheckPalindrome() {
		sut.isPalindrome(null);
	}

	@Test
	public void emptyPalindrome() {
		assertTrue(sut.isPalindrome(""));
		assertTrue(sut.isPalindrome("  "));
	}
	
	@Test
	public void palindrome() {
		assertTrue(sut.isPalindrome("taco cat"));
		assertTrue(sut.isPalindrome("Taco cat"));
		assertTrue(sut.isPalindrome("atota"));
	}
	
	@Test
	public void nonPalindrome() {
		assertFalse(sut.isPalindrome("Hello World"));
		assertFalse(sut.isPalindrome("Hey"));
	}

	@Test
	public void palindromePermutation() {
		assertTrue(sut.isPalindromePermutation("Tact Coa"));
		assertTrue(sut.isPalindromePermutation("aabbcc"));
		assertTrue(sut.isPalindromePermutation("aabbc"));
		assertTrue(sut.isPalindromePermutation("ababc"));
	}

	@Test
	public void nonPalindromePermutation() {
		assertFalse(sut.isPalindromePermutation("Tact Coas"));
		assertFalse(sut.isPalindromePermutation("abcd"));
		assertFalse(sut.isPalindromePermutation("aabbcd"));
	}
}
