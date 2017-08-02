package treegraph;

public abstract class BinaryTree<T> {

	Node<T> root;
	
	public abstract boolean insert(T element);
	
	public abstract Node<T> find(T element);
	
	static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		
		Node(E element) {
			this.element = element;
		}
	}
}
