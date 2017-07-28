package stackqs;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyStackTest {

	private MyStack<Integer> stack = new MyArrayStack<>();
	
	@Test
	public void test() {
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
		assertNull(stack.peek());
		
		assertTrue(stack.push(1));
		assertEquals(1, stack.peek().intValue());
		
		assertTrue(stack.push(2));
		assertTrue(stack.push(3));
		assertTrue(stack.push(4));
		assertEquals(4, stack.size());
		
		assertEquals(4, stack.peek().intValue());
		
		assertEquals(4, stack.pop().intValue());
		assertEquals(3, stack.size());
		assertEquals(3, stack.pop().intValue());
		assertEquals(2, stack.pop().intValue());
		assertEquals(1, stack.pop().intValue());
		assertNull(stack.pop());
		
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

}
