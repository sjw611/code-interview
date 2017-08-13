package treegraph;

public class Q10 {
	public <T> boolean isSubtree(Node<T> tree, Node<T> subtree) {
		if (tree == subtree) {
			return true;
		}
		
		if (tree == null && subtree != null) {
			return false;
		}
		
		if (subtree == null && tree != null) {
			return false;
		}
		
		return isSubtree(tree.left, subtree) || isSubtree(tree.right, subtree);
	}
}
