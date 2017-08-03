package treegraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public abstract class Heap<T extends Comparable<? super T>> {

	private List<T> array = new ArrayList<>();
	private Comparator<T> comp;

	public Heap(Comparator<T> comp) {
		this.comp = Objects.requireNonNull(comp);
	}

	public T first() {
		if (array.isEmpty()) {
			return null;
		}
		return array.get(0);
	}

	public T removeFirst() {
		if (array.isEmpty()) {
			return null;
		}

		if (array.size() == 0) {
			return array.remove(0);
		} else {
			swapNodeValues(0, array.size() - 1);
			T result = array.remove(array.size() - 1);
			percolateDown();

			return result;
		}
	}

	public boolean insert(T element) {
		boolean result = array.add(element);
		percolateUp();
		return result;
	}

	private void swapNodeValues(int idx1, int idx2) {
		T tmp = array.get(idx1);
		array.set(idx1, array.get(idx2));
		array.set(idx2, tmp);
	}

	private void percolateUp() {
		int currentIndex = array.size() - 1;
		while (true) {
			if (currentIndex == 0) {
				return;
			}

			int parentIndex = (currentIndex - 1) >> 1;

			T currentElement = array.get(currentIndex);
			T parentElement = array.get(parentIndex);

			if (comp.compare(currentElement, parentElement) <= 0) {
				swapNodeValues(currentIndex, parentIndex);
				currentIndex = parentIndex;
			} else {
				return;
			}
		}
	}

	private void percolateDown() {
		int currentIndex = 0;

		while (true) {
			int leftChildIndex = (currentIndex << 1) + 1;
			int rightChildIndex = leftChildIndex + 1;

			if (leftChildIndex >= array.size() - 1) {
				return;
			} else if (rightChildIndex >= array.size() - 1) {
				T currentElement = array.get(currentIndex);
				T leftElement = array.get(leftChildIndex);

				if (comp.compare(currentElement, leftElement) >= 0) {
					swapNodeValues(currentIndex, leftChildIndex);
					currentIndex = leftChildIndex;
				} else {
					return;
				}
			} else {
				T currentElement = array.get(currentIndex);
				T leftElement = array.get(leftChildIndex);
				T rightElement = array.get(rightChildIndex);

				if (comp.compare(currentElement, leftElement) < 0 && comp.compare(currentElement, rightElement) < 0) {
					return;
				} else if (comp.compare(currentElement, leftElement) >= 0
						&& comp.compare(currentElement, rightElement) < 0) {
					swapNodeValues(currentIndex, leftChildIndex);
					currentIndex = leftChildIndex;
				} else if (comp.compare(currentElement, leftElement) < 0
						&& comp.compare(currentElement, rightElement) >= 0) {
					swapNodeValues(currentIndex, rightChildIndex);
					currentIndex = rightChildIndex;
				} else {
					if (comp.compare(leftElement, rightElement) < 0) {
						swapNodeValues(currentIndex, leftChildIndex);
						currentIndex = leftChildIndex;
					} else {
						swapNodeValues(currentIndex, rightChildIndex);
						currentIndex = rightChildIndex;
					}
				}
			}
		}
	}
}
