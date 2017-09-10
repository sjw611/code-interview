package recursive;

import static org.junit.Assert.*;

import org.junit.Test;

public class TripleStepTest {

	private TripleStep sut = new TripleStep();

	@Test
	public void test() {
		assertEquals(1, sut.count(1));
		assertEquals(2, sut.count(2));
		assertEquals(4, sut.count(3));
		assertEquals(7, sut.count(4));
		assertEquals(13, sut.count(5));
		assertTrue(sut.count(40) > 0);
		assertTrue(sut.count(1000) > 0);
	}

}
