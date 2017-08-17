package bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q2Test {

	private Q2 sut = new Q2();
	
	@Test
	public void test() {
		assertEquals(Q2.OVERFLOW, sut.binaryToString(0.1));
		assertEquals(Q2.OVERFLOW, sut.binaryToString(0.01));
		
		assertEquals("0", sut.binaryToString(0));
		assertEquals("0", sut.binaryToString(0.0));
		assertEquals("1", sut.binaryToString(1));
		assertEquals("0.1", sut.binaryToString(0.5));
		assertEquals("0.101", sut.binaryToString(0.625));
	}

}
