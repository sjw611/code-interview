package treegraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

public class BinarySearchTreeTest {

	private BinaryTree<Integer> sut = new BinarySearchTree<>();
	private TreeTraversal<Integer> traversal = new InOrderTreeTraversal<>();

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

	@Test
	public void getRandomNode() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.insert("Hello");
		tree.insert("Bye");
		tree.insert("Justin");
		tree.insert("Song");

		Map<Node<String>, AtomicLong> counts = new HashMap<>();

		for (int i = 0; i < 1000; ++i) {
			Node<String> random = tree.getRandomNode();
			counts.putIfAbsent(random, new AtomicLong());
			counts.get(random).incrementAndGet();
		}
		System.out.println(counts);
	}

}
