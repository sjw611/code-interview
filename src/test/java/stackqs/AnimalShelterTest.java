package stackqs;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class AnimalShelterTest {

	private AnimalShelter sut = new AnimalShelter();
	
	@Test
	public void test() {
		assertNull(sut.dequeue());
		assertNull(sut.dequeueDog());
		assertNull(sut.dequeueCat());
		assertTrue(sut.isEmpty());
		
		assertTrue(sut.enqueue(new Cat("1", LocalDateTime.of(2000, 1, 1, 10, 10))));
		assertTrue(sut.enqueue(new Cat("2", LocalDateTime.of(2001, 1, 1, 10, 10))));
		assertTrue(sut.enqueue(new Cat("3", LocalDateTime.of(2002, 1, 1, 10, 10))));
		assertTrue(sut.enqueue(new Dog("1", LocalDateTime.of(2003, 1, 1, 10, 10))));
		assertTrue(sut.enqueue(new Dog("2", LocalDateTime.of(2004, 1, 1, 10, 10))));
		assertTrue(sut.enqueue(new Dog("3", LocalDateTime.of(2005, 1, 1, 10, 10))));
		
		assertTrue(sut.enqueue(new Cat("4", LocalDateTime.of(2006, 1, 1, 10, 10))));
		assertTrue(sut.enqueue(new Cat("5", LocalDateTime.of(2007, 1, 1, 10, 10))));
		
		assertTrue(sut.enqueue(new Dog("4", LocalDateTime.of(2008, 1, 1, 10, 10))));
		assertTrue(sut.enqueue(new Dog("5", LocalDateTime.of(2009, 1, 1, 10, 10))));
		
		assertTrue(sut.enqueue(new Cat("6", LocalDateTime.of(2010, 1, 1, 10, 10))));
		
		assertEquals(11, sut.size());
		
		assertEquals("Cat-1", sut.dequeueAny().getName());
		assertEquals("Dog-1", sut.dequeueDog().getName());
		assertEquals("Cat-2", sut.dequeueAny().getName());
		assertEquals("Cat-3", sut.dequeueAny().getName());
		assertEquals("Cat-4", sut.dequeueCat().getName());
		assertEquals("Dog-2", sut.dequeueDog().getName());
	}

}
