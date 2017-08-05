package sortsearch;

import java.util.Objects;

public class BubbleSort<T extends Comparable<? super T>> implements Sort<T> {

	@Override
	public void sort(T[] arr) {
		Objects.requireNonNull(arr);

		for (int i = 0; i < arr.length - 1; ++i) {

			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}

}
