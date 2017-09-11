package recursive;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class TripleStepTest {

	private TripleStep sut = new TripleStep();

	@Test
	public void test() {
		assertEquals(1, sut.count(1).intValue());
		assertEquals(2, sut.count(2).intValue());
		assertEquals(4, sut.count(3).intValue());
		assertEquals(7, sut.count(4).intValue());
		assertEquals(13, sut.count(5).intValue());
		assertTrue(sut.count(40).compareTo(BigDecimal.ZERO) > 0);
		assertTrue(sut.count(1000).compareTo(BigDecimal.ZERO) > 0);
		assertTrue(sut.count(10000).compareTo(BigDecimal.ZERO) > 0);
		assertTrue(sut.count(100000).compareTo(BigDecimal.ZERO) > 0);
	}

}
