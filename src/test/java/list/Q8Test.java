package list;

import static org.junit.Assert.*;

import org.junit.Test;


public class Q8Test {

	private Q8 sut = new Q8();
	
	@Test(expected = NullPointerException.class)
	public void nullCheck() {
		sut.loopDetection(null);
	}

	@Test
	public void noLoop() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.append("Hello");
		assertNull(sut.loopDetection(list));
		list.append("World");
		assertNull(sut.loopDetection(list));
		list.append("!");
		assertNull(sut.loopDetection(list));
	}
	
	@Test
	public void loop() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.append("A");
		list.append("B");
		list.append("C");
		list.append("D");
		list.append("E");
		list.head().next.next.next.next.next = list.head().next.next;
		assertEquals(list.head().next.next, sut.loopDetection(list));
	}
}
