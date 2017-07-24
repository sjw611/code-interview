package list;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoublyLinkedListTest {

	private DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

	@Test
	public void test() {
		assertTrue(sut.isEmpty());
		assertEquals(0, sut.size());

		assertEquals(1, sut.add(1).getData().intValue());
		assertEquals(3, sut.add(3).getData().intValue());
		assertEquals(5, sut.add(5).getData().intValue());
		assertEquals(7, sut.add(7).getData().intValue());
		assertEquals(9, sut.add(9).getData().intValue());

		assertFalse(sut.isEmpty());
		assertEquals(5, sut.size());

		assertEquals(5, sut.delete(5).getData().intValue());
		assertEquals(3, sut.delete(3).getData().intValue());
		assertEquals(9, sut.delete(9).getData().intValue());
		assertEquals(1, sut.delete(1).getData().intValue());

		assertEquals(1, sut.size());

		assertEquals(2, sut.add(2).getData().intValue());

		assertEquals(2, sut.size());

		assertEquals(2, sut.delete(2).getData().intValue());
		assertEquals(7, sut.delete(7).getData().intValue());
		assertTrue(sut.isEmpty());
	}

}
