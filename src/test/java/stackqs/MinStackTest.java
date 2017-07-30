package stackqs;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinStackTest {

	private MinStack<Integer> sut = new MinStack<>();
	
	@Test
	public void test() {
		assertTrue(sut.isEmpty());
		assertEquals(0, sut.size());
		assertNull(sut.peek());
		assertNull(sut.pop());
		assertNull(sut.min());
		
		sut.push(3);
		assertEquals(3, sut.min().intValue());
		
		sut.push(5);
		assertEquals(3, sut.min().intValue());
		
		sut.push(2);
		assertEquals(2, sut.min().intValue());
		
		sut.push(6);
		assertEquals(2, sut.min().intValue());
		
		sut.push(1);
		assertEquals(1, sut.min().intValue());
		
		assertEquals(1, sut.pop().intValue());
		assertEquals(2, sut.min().intValue());
		
		assertEquals(4, sut.size());
		
		assertEquals(6, sut.pop().intValue());
		assertEquals(2, sut.min().intValue());
		
		assertEquals(2, sut.pop().intValue());
		assertEquals(3, sut.min().intValue());
		
		assertEquals(5, sut.pop().intValue());
		assertEquals(3, sut.pop().intValue());
		
		assertNull(sut.min());
	}

}
