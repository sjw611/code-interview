package bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q3Test {

	private Q3 sut = new Q3();
	
	@Test
	public void test() {
		assertEquals(8, sut.flipBitToWin(1775));
		assertEquals(3, sut.flipBitToWin(5));
		assertEquals(2, sut.flipBitToWin(9));
		assertEquals(4, sut.flipBitToWin(15));
	}

}
