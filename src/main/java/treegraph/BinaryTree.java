package treegraph;

public abstract class BinaryTree<T> {

	Node<T> root;
	
	public abstract boolean insert(T element);
	
	public abstract Node<T> find(T element);
}
