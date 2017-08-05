package sortsearch;

public interface Sort<T extends Comparable<? super T>> {
	
	default void swap(T[] arr, int idx1, int idx2) {
		T tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	
	void sort(T[] arr);
}
