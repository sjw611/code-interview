package treegraph;

import treegraph.BinaryTree.Node;

public interface TreeTraversal<T> {

	void traverse(Node<T> root);

	default void visit(Node<T> node) {
		System.out.println("Visit tree node: " + node.element);
	}
}
