package recursive;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursiveMultiplyTest {

	private RecursiveMultiply sut = new RecursiveMultiply();
	
	@Test
	public void test() {
		assertEquals(72, sut.multiply(8, 9));
		assertEquals(80, sut.multiply(8, 10));
		assertEquals(81, sut.multiply(9, 9));
	}

}
