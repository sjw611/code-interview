package treegraph;

import treegraph.BinaryTree.Node;

public class InOrderTreeTraversal<T> implements TreeTraversal<T> {

	@Override
	public void traverse(Node<T> root) {
		if (root != null) {
			traverse(root.left);
			visit(root);
			traverse(root.right);
		}
	}

}
