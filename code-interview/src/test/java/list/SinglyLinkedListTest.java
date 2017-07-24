package list;

import static org.junit.Assert.*;

import org.junit.Test;

public class SinglyLinkedListTest {

	private SinglyLinkedList<Integer> sut = new SinglyLinkedList<>();
	
	@Test
	public void test() {
		assertTrue(sut.isEmpty());
		
		sut.append(1);
		sut.append(3);
		sut.append(5);
		sut.append(7);
		sut.append(9);
		
		assertFalse(sut.isEmpty());
		assertEquals(5, sut.size());
		
		assertEquals(Integer.valueOf(3), sut.delete(3).data());
		
		assertNull(sut.delete(10));
		
		assertEquals(4, sut.size());
		
		assertNotNull(sut.delete(9));
		assertNotNull(sut.delete(1));
		assertNotNull(sut.delete(5));
		assertNotNull(sut.delete(7));
		
		assertTrue(sut.isEmpty());
		
		assertEquals(Integer.valueOf(2), sut.append(2).data());
		assertEquals(1, sut.size());
	}

}
