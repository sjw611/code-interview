package treegraph;

public interface Frontier<T> {
	Node<T> next();
	void add(Node<T> node);
	boolean isEmpty();
	void init();
}
