package sortsearch;

import java.util.Objects;

public class SelectionSort<T extends Comparable<? super T>> implements Sort<T> {

	@Override
	public void sort(T[] arr) {
		Objects.requireNonNull(arr);

		for (int i = 0; i < arr.length; ++i) {
			int minIndex = i;
			T min = arr[minIndex];
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j].compareTo(min) < 0) {
					minIndex = j;
					min = arr[j];
				}
			}
			swap(arr, i, minIndex);
		}
	}

}
