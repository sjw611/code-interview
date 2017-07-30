package stackqs;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetOfStacksTest {

	private SetOfStacks<Integer> sut = new SetOfStacks<>(2);
	
	@Test
	public void test() {
		assertTrue(sut.isEmpty());
		assertEquals(0, sut.size());
		assertNull(sut.peek());
		
		assertTrue(sut.push(1));
		assertEquals(1, sut.peek().intValue());
		
		assertTrue(sut.push(2));
		assertTrue(sut.push(3));
		assertTrue(sut.push(4));
		assertEquals(4, sut.size());
		
		assertEquals(4, sut.peek().intValue());
		
		assertEquals(4, sut.pop().intValue());
		assertEquals(3, sut.size());
		assertEquals(3, sut.pop().intValue());
		assertEquals(2, sut.pop().intValue());
		assertEquals(1, sut.pop().intValue());
		assertNull(sut.pop());
		
		assertTrue(sut.isEmpty());
		assertEquals(0, sut.size());
	}

}
