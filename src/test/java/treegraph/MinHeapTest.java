package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinHeapTest {

	private Heap<Integer> sut = new MinHeap<>();
	
	@Test
	public void test() {
		assertNull(sut.first());
		assertNull(sut.removeFirst());
		
		sut.insert(20);
		sut.insert(8);
		sut.insert(4);
		sut.insert(2);
		sut.insert(10);
		sut.insert(6);
		
		assertEquals(2, sut.first().intValue());
		assertEquals(2, sut.removeFirst().intValue());
		assertEquals(4, sut.removeFirst().intValue());
		assertEquals(6, sut.removeFirst().intValue());
		assertEquals(8, sut.removeFirst().intValue());
		assertEquals(10, sut.removeFirst().intValue());
		assertEquals(20, sut.removeFirst().intValue());
	}

}
