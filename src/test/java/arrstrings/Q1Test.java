package arrstrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q1Test {

	private Q1 sut = new Q1();
	
	@Test
	public void emptyString() {
		assertTrue(sut.isUnique(""));
	}

	@Test(expected = NullPointerException.class)
	public void nullCheck() {
		sut.isUnique(null);
	}
	
	@Test
	public void unique() {
		assertTrue(sut.isUnique("abcd"));
	}
	
	@Test
	public void nonUnique() {
		assertFalse(sut.isUnique("aacde"));
		assertFalse(sut.isUnique("abacde"));
		assertFalse(sut.isUnique("abcdebb"));
	}
}
