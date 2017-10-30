package recursive;

import java.util.Objects;

public class MagicIndex {

	private static final int NOT_FOUND = -1;

	public int find(int[] array) {
		Objects.requireNonNull(array);

		int low = 0;
		int high = array.length - 1;

		while (true) {
			if (low > high) {
				return NOT_FOUND;
			}
			int mid = low + ((high - low) >> 1);
			if (array[mid] == mid) {
				return mid;
			} else if (array[mid] > mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
	}

}
