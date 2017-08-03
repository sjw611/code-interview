package treegraph;

import java.util.ArrayDeque;
import java.util.Deque;

public class FifoFrontier<T> implements Frontier<T> {

	private Deque<Node<T>> queue = new ArrayDeque<>();
	
	@Override
	public Node<T> next() {
		if (isEmpty()) {
			return null;
		}
		return queue.pollFirst();
	}

	@Override
	public void add(Node<T> node) {
		queue.offerLast(node);
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void init() {
		queue.clear();
	}

}
