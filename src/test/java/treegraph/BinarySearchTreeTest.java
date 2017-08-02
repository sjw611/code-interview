package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	BinaryTree<Integer> sut = new BinarySearchTree<>();
	TreeTraversal<Integer> traversal = new InOrderTreeTraversal<>();

	@Test
	public void test() {
		sut.insert(20);
		sut.insert(8);
		sut.insert(4);
		sut.insert(2);
		sut.insert(10);
		sut.insert(6);

		traversal.traverse(sut.root);

		sut.insert(6);
		sut.insert(4);

		traversal.traverse(sut.root);

		assertEquals(6, sut.find(6).element.intValue());
		assertEquals(20, sut.find(20).element.intValue());

		assertNull(sut.find(12));
	}

}
