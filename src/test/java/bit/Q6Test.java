package bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q6Test {

	private Q6 sut = new Q6();
	
	@Test
	public void test() {
		assertEquals(2, sut.conversion(29, 15));
		assertEquals(0, sut.conversion(29, 29));
		
		assertEquals(1, sut.conversion(0, 1));
		assertEquals(1, sut.conversion(3, 2));
	}

}
