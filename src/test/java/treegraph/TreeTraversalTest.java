package treegraph;

import org.junit.Test;

import treegraph.BinaryTree.Node;

public class TreeTraversalTest {

	private TreeTraversal<String> sut = new PreOrderTreeTraversal<>();

	@Test
	public void test() {
		Node<String> root = new Node<>("Hello");
		Node<String> n1 = new Node<>("Song");
		Node<String> n2 = new Node<>("Jingwei");
		Node<String> n3 = new Node<>("Jessica");
		Node<String> n4 = new Node<>("Penny");
		Node<String> n5 = new Node<>("Justin");
		Node<String> n6 = new Node<>("Gu");

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n4.left = n6;
		
		sut.traverse(root);
	}

}
