package treegraph;

import java.util.Arrays;

import org.junit.Test;

public class Q2Test {

	private Q2 sut = new Q2();

	@Test
	public void test() {
		Node<Integer> tree = sut.minimalTree(Arrays.asList(1, 3, 5, 7, 9).toArray(new Integer[] {}));
		
		TreeTraversal<Integer> traversal = new PreOrderTreeTraversal<>();
		
		traversal.traverse(tree);
	}

}
