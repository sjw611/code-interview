package treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q9 {
	public <T> List<List<Node<T>>> bstSequences(Node<T> root) {
		List<List<Node<T>>> result = new ArrayList<>();
		
		if (root == null) {
			result.add(new LinkedList<>());
			return result;
		}
		
		List<Node<T>> prefix = new LinkedList<>();
		prefix.add(root);
		
		List<List<Node<T>>> left = bstSequences(root.left);
		List<List<Node<T>>> right = bstSequences(root.right);
		
		for (List<Node<T>> l : left) {
			for (List<Node<T>> r : right) {
				List<List<Node<T>>> weaved = new ArrayList<>();
				weaveLists(l, r, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}

	private <T> void weaveLists(List<Node<T>> l, List<Node<T>> r, List<List<Node<T>>> weaved, List<Node<T>> prefix) {
		if (l.size() == 0 || r.size() == 0) {
			List<Node<T>> result = new LinkedList<>(prefix);
			result.addAll(l);
			result.addAll(r);
			weaved.add(result);
			return;
		}
		
		Node<T> headLeft = l.remove(0);
		prefix.add(headLeft);
		weaveLists(l, r, weaved, prefix);
		prefix.remove(prefix.size() - 1);
		l.add(0, headLeft);

		Node<T> headRight = r.remove(0);
		prefix.add(headRight);
		weaveLists(l, r, weaved, prefix);
		prefix.remove(prefix.size() - 1);
		r.add(0, headRight);
	}
}

