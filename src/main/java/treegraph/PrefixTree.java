package treegraph;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PrefixTree {

	TrieNode root = new RootTrieNode();

	private static final char TERMINATING_VALUE = '*';
	private static final TrieNode TERMINATING_NODE = new TerminatingTrieNode();

	public void insert(String word) {
		Objects.requireNonNull(word);

		System.out.println("...Inserting " + word);

		TrieNode current = root;

		for (char c : word.toCharArray()) {
			TrieNode child;

			if (current.children.containsKey(c)) {
				child = current.children.get(c);
			} else {
				child = new TrieNode(c);
				current.children.put(c, child);
			}

			current = child;
		}

		current.children.put(TERMINATING_VALUE, TERMINATING_NODE);
	}

	static class TrieNode {
		char element;
		Map<Character, TrieNode> children = new HashMap<>();

		public TrieNode(char element) {
			this.element = element;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(element).append(children.isEmpty() ? "" : "->")
					.append(children.isEmpty() ? "" : children.values());
			return sb.toString();
		}
	}

	private static final class RootTrieNode extends TrieNode {
		private RootTrieNode() {
			super('~');
		}
	}

	private static final class TerminatingTrieNode extends TrieNode {
		private TerminatingTrieNode() {
			super('*');
		}
	}
    public boolean lookup(String word) {
    	return false;
    }
}
