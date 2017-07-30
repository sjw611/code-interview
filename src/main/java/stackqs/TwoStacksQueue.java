package stackqs;

public class TwoStacksQueue<T> implements MyQueue<T> {

	private MyStack<T> storageStack;
	private MyStack<T> shuffleStack;

	public TwoStacksQueue(MyStack<T> storageStack, MyStack<T> shuffleStack) {
		this.storageStack = storageStack;
		this.shuffleStack = shuffleStack;
	}

	@Override
	public boolean enqueue(T element) {
		return storageStack.push(element);
	}

	@Override
	public T head() {
		return headOrDequeue(false);
	}

	@Override
	public T dequeue() {
		return headOrDequeue(true);
	}

	private T headOrDequeue(boolean remove) {
		if (storageStack.isEmpty()) {
			return null;
		}

		while (storageStack.size() != 1) {
			shuffleStack.push(storageStack.pop());
		}

		T headElement = remove ? storageStack.pop() : storageStack.peek();

		while (!shuffleStack.isEmpty()) {
			storageStack.push(shuffleStack.pop());
		}

		return headElement;
	}

	@Override
	public int size() {
		return storageStack.size();
	}

}
