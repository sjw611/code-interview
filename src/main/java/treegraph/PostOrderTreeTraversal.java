package treegraph;

public class PostOrderTreeTraversal<T> implements TreeTraversal<T> {

	@Override
	public void traverse(Node<T> root) {
		if (root != null) {
			traverse(root.left);
			traverse(root.right);
			visit(root);
		}

	}

}
