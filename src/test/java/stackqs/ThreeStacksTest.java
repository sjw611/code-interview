package stackqs;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeStacksTest {

	private ArrayStacks<String> sut = new ArrayStacks<>(3);
	
	@Test
	public void test() {
		assertNull(sut.peek(1));
		assertNull(sut.peek(2));
		assertNull(sut.peek(3));
		
		assertNull(sut.pop(2));
		
		assertTrue(sut.push("Hello", 2));
		assertTrue(sut.push("Bye", 1));
		assertTrue(sut.push("Hey", 3));
		
		assertEquals(1, sut.size(1));
		assertEquals(1, sut.size(2));
		assertEquals(1, sut.size(3));
		
		assertEquals("Hello", sut.peek(2));
		assertEquals("Hey", sut.peek(3));
		assertEquals("Bye", sut.peek(1));
		
		assertTrue(sut.push("A", 2));
		assertTrue(sut.push("B", 2));
		assertTrue(sut.push("C", 2));
		
		assertTrue(sut.push("D", 1));
		assertTrue(sut.push("E", 1));
		assertTrue(sut.push("F", 1));
		
		assertEquals("F", sut.peek(1));
		assertEquals("C", sut.peek(2));
		assertEquals("Hey", sut.peek(3));
		
		assertEquals("F", sut.pop(1));
		assertEquals("C", sut.pop(2));
		assertEquals("Hey", sut.pop(3));
		
		assertEquals("E", sut.pop(1));
		assertEquals("D", sut.pop(1));
		assertEquals("Bye", sut.pop(1));
		assertNull(sut.pop(1));
		

		assertEquals(0, sut.size(1));
		assertEquals(3, sut.size(2));
		assertEquals(0, sut.size(3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void rangeCheck() {
		sut.peek(10);
	}

}
