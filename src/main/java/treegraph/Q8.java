package treegraph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Q8 {
	public <T> Node<T> findFirstCommonAncestor(Node<T> n1, Node<T> n2) {
		Objects.requireNonNull(n1);
		Objects.requireNonNull(n2);
		
		Set<Node<T>> n1Ancestors = new LinkedHashSet<>();
		Set<Node<T>> n2Ancestors = new LinkedHashSet<>();
		
		Node<T> n1Current = n1;
		Node<T> n2Current = n2;
		
		while (n1Current.parent != null) {
			n1Ancestors.add(n1Current.parent);
			n1Current = n1Current.parent;
		}
		
		while (n2Current.parent != null) {
			n2Ancestors.add(n2Current.parent);
			n2Current = n2Current.parent;
		}
		
		n1Ancestors.retainAll(n2Ancestors);
		
		if (n1Ancestors.isEmpty()) {
			return null;
		}
		
		return new ArrayList<>(n1Ancestors).get(0);
	}
}
