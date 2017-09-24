package recursive;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringPermutationsTest {

	private StringPermutations sut = new StringPermutations();
	
	@Test
	public void test() {
		assertEquals(1, sut.permutations("a").size());
		assertEquals(1, sut.permutations("").size());
		assertEquals(24, sut.permutations("abcd").size());
		assertEquals(120, sut.permutations("abcde").size());
		
		assertEquals(1, sut.permutations("aa").size());
		assertEquals(3, sut.permutations("aba").size());
	}

}
