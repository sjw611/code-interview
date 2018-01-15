package sortsearch;

import java.util.Objects;

public class MergeSort<T extends Comparable<? super T>> implements Sort<T> {

	@Override
	public void sort(T[] arr) {
		Objects.requireNonNull(arr);
		mergeSort(arr, 0, arr.length);
	}

	private void mergeSort(T[] items, int low, int high) {
		if (low < high - 1) {
			int mid = low + ((high - low) >> 1);
			mergeSort(items, low, mid);
			mergeSort(items, mid, high);
			merge(items, low, mid, high);
		}
	}

	private void merge(T[] items, int low, int mid, int high) {
		T[] merged = items.clone();

		int i = low;
		int j = mid;
		int k = low;

		while (i < mid && j < high) {
			if (merged[i].compareTo(merged[j]) < 0) {
				items[k++] = merged[i++];
			} else {
				items[k++] = merged[j++];
			}
		}

		if (j == high) {
			System.arraycopy(merged, i, items, k, mid - i);
		}
	}

}
