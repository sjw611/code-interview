package stackqs;

public class ArrayStacks<T> {
	private static final int EXPANSION_FACTOR = 2;

	private T[] array;
	private int[] stackPointers;

	@SuppressWarnings("unchecked")
	public ArrayStacks(int numStacks) {
		array = (T[]) new Object[numStacks];
		stackPointers = new int[numStacks];
		initStackPointers(stackPointers, array.length);
	}

	public int size(int stackNumber) {
		validateStackNumber(stackNumber);

		return stackPointers[stackNumberInArray(stackNumber)]
				- array.length / stackPointers.length * stackNumberInArray(stackNumber);
	}

	private int stackNumberInArray(int stackNumber) {
		return stackNumber - 1;
	}

	public T pop(int stackNumber) {
		validateStackNumber(stackNumber);

		T result = peek(stackNumber);

		if (result == null) {
			return null;
		}

		array[--stackPointers[stackNumberInArray(stackNumber)]] = null;

		return result;
	}

	public T peek(int stackNumber) {
		validateStackNumber(stackNumber);

		if (stackPointers[stackNumberInArray(stackNumber)] == 0) {
			return null;
		}

		return array[stackPointers[stackNumberInArray(stackNumber)] - 1];
	}

	public boolean push(T element, int stackNumber) {
		validateStackNumber(stackNumber);

		ensureCapacity();

		array[stackPointers[stackNumberInArray(stackNumber)]++] = element;

		return true;
	}

	private void ensureCapacity() {
		if (requiresExpansion()) {
			@SuppressWarnings("unchecked")
			T[] expanded = (T[]) new Object[array.length * EXPANSION_FACTOR];

			int[] expandedStackPointers = new int[stackPointers.length];

			initStackPointers(expandedStackPointers, expanded.length);

			for (int i = 0; i < stackPointers.length; ++i) {
				System.arraycopy(array, expandedStackPointers[i] / EXPANSION_FACTOR, expanded, expandedStackPointers[i],
						stackPointers[i] - expandedStackPointers[i] / EXPANSION_FACTOR);
				expandedStackPointers[i] = expandedStackPointers[i] / EXPANSION_FACTOR + stackPointers[i];
			}

			array = expanded;
			stackPointers = expandedStackPointers;
		}
	}

	private boolean requiresExpansion() {
		for (int i = 0; i < stackPointers.length; ++i) {
			if (stackPointers[i] == array.length / stackPointers.length * (i + 1)) {
				return true;
			}
		}
		return false;
	}

	private void validateStackNumber(int stackNumber) {
		if (stackNumber <= 0 || stackNumber > stackPointers.length) {
			throw new IllegalArgumentException("Invalid stack number " + stackNumber);
		}
	}

	private void initStackPointers(int[] stackPointers, int arrayLength) {
		if (arrayLength % stackPointers.length != 0) {
			throw new IllegalArgumentException("Invalid array length : " + arrayLength);
		}

		for (int i = 0; i < stackPointers.length; ++i) {
			stackPointers[i] = arrayLength / stackPointers.length * i;
		}
	}
}
