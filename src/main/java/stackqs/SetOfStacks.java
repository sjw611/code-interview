package stackqs;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks<T> implements MyStack<T> {

	private int capacity;
	private List<MyStack<T>> stacks;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
		stacks = new ArrayList<>();
	}

	@Override
	public T pop() {
		return popAt(stacks.size() - 1);
	}

	public T popAt(int index) {
		if (stacks.isEmpty()) {
			return null;
		}
		
		if (index < 0 || index >= stacks.size()) {
			throw new IllegalArgumentException("Invalid stack index: " + index);
		}

		MyStack<T> stack = stacks.get(index);

		T element = stack.pop();

		if (stack.isEmpty()) {
			stacks.remove(index);
		}
		return element;
	}

	@Override
	public boolean push(T element) {
		if (stacks.isEmpty()) {
			stacks.add(new MyArrayStack<>());
		}

		MyStack<T> last = lastStack();

		if (last.size() == capacity) {
			stacks.add(new MyArrayStack<>());
			last = lastStack();
		}

		return last.push(element);
	}

	@Override
	public int size() {
		int totalSize = 0;

		for (MyStack<T> s : stacks) {
			totalSize += s.size();
		}

		return totalSize;
	}

	@Override
	public T peek() {
		if (stacks.isEmpty()) {
			return null;
		}

		MyStack<T> last = lastStack();

		return last.peek();
	}

	private MyStack<T> lastStack() {
		return stacks.get(stacks.size() - 1);
	}

}
