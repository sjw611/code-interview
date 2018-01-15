package sortsearch;

import java.util.Objects;

public class InsertionSort<T extends Comparable<? super T>> implements Sort<T> {

	@Override
	public void sort(T[] arr) {
		Objects.requireNonNull(arr);

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 && arr[j - 1].compareTo(arr[j]) > 0; j--) {
				swap(arr, j, j - 1);
			}
		}
	}

}
