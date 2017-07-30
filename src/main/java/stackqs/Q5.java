package stackqs;

import java.util.Objects;

public class Q5 {
	public <T extends Comparable<? super T>> MyStack<T> sortStack(MyStack<T> stack) {
		Objects.requireNonNull(stack);

		while (!isSorted(stack)) {
			MyStack<T> shuffleStack = new MyArrayStack<>();
			
			shuffleStack.push(stack.pop());
			
			while (!stack.isEmpty()) {
				if (stack.peek().compareTo(shuffleStack.peek()) <= 0) {
					shuffleStack.push(stack.pop());
				} else {
					T smaller = shuffleStack.pop();
					T larger = stack.pop();
					
					shuffleStack.push(larger);
					shuffleStack.push(smaller);
				}
			}
			
			if (isSorted(shuffleStack)) {
				return shuffleStack;
			}
			
			while (!shuffleStack.isEmpty()) {
				stack.push(shuffleStack.pop());
			}
		}
		return stack;
	}

	private <T extends Comparable<? super T>> boolean isSorted(MyStack<T> stack) {
		Objects.requireNonNull(stack);
		if (stack.isEmpty()) {
			return true;
		}

		MyStack<T> shuffleStack = new MyArrayStack<>();

		boolean sorted = true;

		T min = stack.pop();

		shuffleStack.push(min);

		while (!stack.isEmpty()) {
			if (stack.peek().compareTo(shuffleStack.peek()) < 0) {
				sorted = false;
			}

			shuffleStack.push(stack.pop());
		}

		while (!shuffleStack.isEmpty()) {
			stack.push(shuffleStack.pop());
		}

		return sorted;
	}
}
