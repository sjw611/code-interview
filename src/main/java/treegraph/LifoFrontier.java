package treegraph;

import java.util.ArrayDeque;

import java.util.Deque;

public class LifoFrontier<T> implements Frontier<T> {

	private Deque<Node<T>> stack = new ArrayDeque<>();
	
	@Override
	public Node<T> next() {
		if (isEmpty()) {
			return null;
		}
		return stack.pollFirst();
	}

	@Override
	public void add(Node<T> node) {
		stack.offerFirst(node);
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void init() {
		stack.clear();
	}

}
