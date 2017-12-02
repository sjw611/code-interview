package recursive;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Parens {
	private static final char LEFT_PAREN = '(';
	private static final char RIGHT_PAREN = ')';

	public void parens(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}

		Set<String> combinations = new HashSet<>();

		combinations.add("" + LEFT_PAREN);

		for (int i = 1; i < 2 * n; ++i) {
			Set<String> appended = new HashSet<>();

			for (String s : combinations) {
				appended.add(s + LEFT_PAREN);
				appended.add(s + RIGHT_PAREN);
			}

			combinations.clear();
			combinations.addAll(appended);
		}

		for (Iterator<String> iter = combinations.iterator(); iter.hasNext();) {
			String current = iter.next();

			Deque<Character> stack = new ArrayDeque<>();

			for (char c : current.toCharArray()) {
				if (c == LEFT_PAREN) {
					stack.push(c);
				} else {
					if (stack.isEmpty() || stack.peek() == RIGHT_PAREN) {
						iter.remove();
						break;
					} else {
						stack.pop();
					}
				}
			}

			if (!stack.isEmpty()) {
				iter.remove();
			}
		}

		System.out.println(combinations);
	}

	public static void main(String[] args) {
		Parens app = new Parens();
		app.parens(1);
		app.parens(2);
		app.parens(3);
		app.parens(4);
	}
}
