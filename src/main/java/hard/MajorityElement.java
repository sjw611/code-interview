package hard;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class MajorityElement {

	private static final int NOT_FOUND = -1;

	public static void main(String[] args) {
		int[] array = { 1, 2, 2 };
		System.out.println(majority(array));
		System.out.println(boyerMooreMajority(array));
	}

	public static int boyerMooreMajority(int[] array) {
		Objects.requireNonNull(array);
		int count = 0;
		int candidate = 0;

		for (int i : array) {
			if (count == 0) {
				candidate = i;
			}

			count += (i == candidate) ? 1 : -1;
		}

		count = 0;
		int countLowerBound = array.length / 2;

		for (int i : array) {
			if (i == candidate) {
				count++;
			}
		}

		if (count > countLowerBound) {
			return candidate;
		}

		return NOT_FOUND;
	}

	public static int majority(int[] array) {
		Objects.requireNonNull(array);

		Map<Integer, Long> counts = Arrays.stream(array).boxed().collect(groupingBy(Function.identity(), counting()));

		int countLowerBound = array.length / 2;

		for (Integer i : counts.keySet()) {
			if (counts.get(i) > countLowerBound) {
				return i;
			}
		}

		return NOT_FOUND;
	}

}
