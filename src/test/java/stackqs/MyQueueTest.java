package stackqs;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyQueueTest {

	private MyQueue<String> sut = new TwoStacksQueue<>(new MyDoublyLinkedListStack<>(), new MyArrayStack<>());
	
	@Test
	public void test() {
		assertTrue(sut.isEmpty());
		assertEquals(0, sut.size());
		assertNull(sut.head());
		assertNull(sut.dequeue());
		
		assertTrue(sut.enqueue("a"));
		assertTrue(sut.enqueue("b"));
		assertTrue(sut.enqueue("c"));
		assertTrue(sut.enqueue("d"));
		assertTrue(sut.enqueue("e"));
		assertTrue(sut.enqueue("f"));
		
		assertFalse(sut.isEmpty());
		assertEquals(6, sut.size());
		
		assertEquals("a", sut.dequeue());
		assertEquals("b", sut.head());

		sut.enqueue("g");
		sut.enqueue("h");
		sut.enqueue("i");
		
		assertFalse(sut.isEmpty());
		assertEquals(8, sut.size());
		
		assertEquals("b", sut.dequeue());
		assertEquals("c", sut.dequeue());
		assertEquals("d", sut.dequeue());
		assertEquals("e", sut.dequeue());
		assertEquals("f", sut.dequeue());
		assertEquals("g", sut.dequeue());
		assertEquals("h", sut.dequeue());
		assertEquals("i", sut.dequeue());
		
		assertTrue(sut.isEmpty());
		assertEquals(0, sut.size());
	}

}
