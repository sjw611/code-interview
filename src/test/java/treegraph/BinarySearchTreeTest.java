package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	BinaryTree<Integer> sut = new BinarySearchTree<>();
	TreeTraversal<Integer> traversal = new InOrderTreeTraversal<>();
	
	@Test
	public void test() {
		assertTrue(sut.insert(20));
		assertTrue(sut.insert(8));
		assertTrue(sut.insert(4));
		assertTrue(sut.insert(2));
		assertTrue(sut.insert(10));
		assertTrue(sut.insert(6));
		
		traversal.traverse(sut.root);
		
		assertFalse(sut.insert(6));
		assertFalse(sut.insert(4));
		
		assertEquals(6, sut.find(6).element.intValue());
		assertEquals(20, sut.find(20).element.intValue());
		
		assertNull(sut.find(12));
	}

}
