package bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q7Test {

	private Q7 sut = new Q7();
	
	@Test
	public void test() {
		assertEquals(10, sut.pairwiseSwap(5));
		assertEquals(5, sut.pairwiseSwap(10));
		assertEquals(2, sut.pairwiseSwap(1));
	}

}
