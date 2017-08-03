package treegraph;


class Node<E> {
	E element;
	Node<E> left;
	Node<E> right;
	Node<E> parent;
	
	Node(E element) {
		this.element = element;
	}
}