package arrstrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q2Test {

	private Q2 sut = new Q2();

	@Test
	public void nullCheck() {
		assertTrue(sut.isPermutation(null, null));
		assertFalse(sut.isPermutation(null, "abc"));
		assertFalse(sut.isPermutation("abc", null));
	}

	@Test
	public void permutation() {
		assertTrue(sut.isPermutation("abc", "abc"));
		assertTrue(sut.isPermutation("abcd", "acbd"));
	}

	@Test
	public void nonPermutation() {
		assertFalse(sut.isPermutation("abc", "addbc"));
		assertFalse(sut.isPermutation("abc", "xyz"));
	}

	@Test
	public void empty() {
		assertFalse(sut.isPermutation("", "addbc"));
		assertTrue(sut.isPermutation("", ""));
	}
}
