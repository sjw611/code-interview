package treegraph;

import java.util.Objects;

public class Q8 {
	public <T> Node<T> findFirstCommonAncestor(Node<T> n1, Node<T> n2) {
		Objects.requireNonNull(n1);
		Objects.requireNonNull(n2);

		Node<T> n1Ancestor = n1.parent;

		Search<T> search = new DepthFirstSearch<>();

		while (true) {
			if (n1Ancestor == null) {
				return null;
			}

			Node<T> n2Present = search.find(n1Ancestor, n2.element);

			if (n2Present == n2) {
				return n1Ancestor;
			} else {
				n1Ancestor = n1Ancestor.parent;
			}
		}
	}
}
