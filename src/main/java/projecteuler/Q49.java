package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Q49 {

	public static void main(String[] args) {
		int[] prime = Q7.prime();

		Map<String, List<Integer>> perms = new TreeMap<>();

		for (int i = 1000; i <= 9999; ++i) {
			if (prime[i] == 1) {
				char[] charArray = String.valueOf(i).toCharArray();
				Arrays.sort(charArray);

				String key = new String(charArray);

				perms.putIfAbsent(key, new ArrayList<>());
				perms.get(key).add(i);
			}
		}

		for (List<Integer> list : perms.values()) {
			if (list.size() >= 3) {
				for (int i = 0; i < list.size() - 2; ++i) {
					for (int j = i + 1; j < list.size() - 1; ++j) {
						for (int k = j + 1; k < list.size(); ++k) {
							if (list.get(i) + list.get(k) == 2 * list.get(j)) {
								System.out.println(list.get(i) + "" + list.get(j) + "" + list.get(k));
							}
						}
					}
				}
			}
		}
	}
}
