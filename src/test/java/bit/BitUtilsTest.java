package bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitUtilsTest {

	private BitUtils sut = BitUtils.INSTANCE;
	
	@Test
	public void getBit() {
		int number = 45;
		assertEquals("101101", Integer.toBinaryString(number));
		
		assertEquals(1, sut.getBit(number, 0));
		assertEquals(0, sut.getBit(number, 1));
		assertEquals(1, sut.getBit(number, 2));
		assertEquals(1, sut.getBit(number, 3));
		assertEquals(0, sut.getBit(number, 4));
		assertEquals(1, sut.getBit(number, 5));
		assertEquals(0, sut.getBit(number, 6));
	}

}
