package ood;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularArrayTest {

	private static final int CAPACITY = 6;
	
	private CircularArray<String> sut = new CircularArray<>(CAPACITY);
	
	@Test
	public void test() {
		assertTrue(sut.isEmpty());
		assertEquals(0, sut.size());
		
		assertNull(sut.add("Song"));
		assertNull(sut.add("Jingwei"));
		
		assertFalse(sut.isEmpty());
		assertEquals(2, sut.size());
		
		assertNull(sut.add("Justin"));
		
		assertEquals("Song", sut.removeFirst());
		
		assertNull(sut.add("e570711"));
		assertNull(sut.add("E570711"));
		
		assertNull(sut.add("song"));
		assertNull(sut.add("SONG"));
		
		assertEquals("Jingwei", sut.add("JINGWEI"));
		
		assertEquals(CAPACITY, sut.size());
		
		assertEquals("JINGWEI", sut.removeLast());
		
		assertEquals(5, sut.size());
		
		assertNull(sut.add("sONG"));
		assertEquals("Justin", sut.removeFirst());
		
		for (String s : sut) {
			System.out.println(s);
		}
	}
	

}
