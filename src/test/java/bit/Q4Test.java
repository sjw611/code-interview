package bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q4Test {

	private Q4 sut = new Q4();
	
	@Test
	public void test() {
		assertArrayEquals(new int[] {10, 12}, sut.nextNumbers(9));
		assertArrayEquals(new int[] {20, 24}, sut.nextNumbers(18));
		assertArrayEquals(new int[] {1, 1}, sut.nextNumbers(1));
		assertArrayEquals(new int[] {0, 0}, sut.nextNumbers(0));
	}

}
