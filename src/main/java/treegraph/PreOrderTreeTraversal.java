package treegraph;

import treegraph.BinaryTree.Node;

public class PreOrderTreeTraversal<T> implements TreeTraversal<T> {

	@Override
	public void traverse(Node<T> root) {
		if (root != null) {
			visit(root);
			traverse(root.left);
			traverse(root.right);
		}

	}

}
