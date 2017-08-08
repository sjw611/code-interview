package arrstrings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Q3Test {

	private Q3 sut = new Q3();
	
	@Test(expected = NullPointerException.class)
	public void nullCheck() {
		sut.urlify(null, 0);
	}

	@Test
	public void empty() {
		assertTrue(Arrays.equals(new char[] {}, sut.urlify(new char[] {}, 0)));
	}
	
	@Test
	public void noSpace() {
		assertTrue(Arrays.equals("abc".toCharArray(), sut.urlify("abc".toCharArray(), 3)));
	}
	
	@Test
	public void spaces() {
		assertTrue(Arrays.equals("Mr%20John%20Smith".toCharArray(), sut.urlify("Mr John Smith    ".toCharArray(), 13)));
		assertTrue(Arrays.equals("%20ABC".toCharArray(), sut.urlify(" ABC  ".toCharArray(), 4)));
		assertTrue(Arrays.equals("%20A%20%20BC".toCharArray(), sut.urlify(" A  BC      ".toCharArray(), 6)));
	}
}
