package stackqs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q5Test {

	private Q5 sut = new Q5();
	
	@Test(expected = NullPointerException.class)
	public void nullCheck() {
		sut.sortStack(null);
	}

	@Test
	public void sort() {
		MyStack<Integer> stack = new MyDoublyLinkedListStack<>();
		stack.push(3);
		stack.push(5);
		stack.push(2);
		stack.push(6);
		stack.push(1);
		stack = sut.sortStack(stack);
		
		assertEquals(1, stack.pop().intValue());
		assertEquals(2, stack.pop().intValue());
		assertEquals(3, stack.pop().intValue());
		assertEquals(5, stack.pop().intValue());
		assertEquals(6, stack.pop().intValue());
		assertNull(stack.pop());
	}
	
	@Test
	public void sortReversed() {
		MyStack<Integer> stack = new MyDoublyLinkedListStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack = sut.sortStack(stack);
		
		assertEquals(1, stack.pop().intValue());
		assertEquals(2, stack.pop().intValue());
		assertEquals(3, stack.pop().intValue());
		assertEquals(4, stack.pop().intValue());
	}
	
	@Test
	public void sortedAlready() {
		MyStack<Integer> stack = new MyDoublyLinkedListStack<>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack = sut.sortStack(stack);
		
		assertEquals(1, stack.pop().intValue());
		assertEquals(2, stack.pop().intValue());
		assertEquals(3, stack.pop().intValue());
		assertEquals(4, stack.pop().intValue());
	}
}
