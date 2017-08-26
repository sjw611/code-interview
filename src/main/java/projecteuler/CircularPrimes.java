package projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CircularPrimes {
	public static void main(String[] args) {
		int[] primeCandidates = Q7.prime();

		Map<String, List<Integer>> circular = new TreeMap<>();

		for (int i = 2; i <= 1_000_000; ++i) {
			if (primeCandidates[i] == 1) {
				char[] keyArray = String.valueOf(i).toCharArray();
				Arrays.sort(keyArray);
				String key = new String(keyArray);

				circular.putIfAbsent(key, new ArrayList<>());
				circular.get(key).add(i);
			}
		}

		int count = 0;

		for (Entry<String, List<Integer>> entry : circular.entrySet()) {
			Map<Character, AtomicInteger> counts = new HashMap<>();
			for (char c : entry.getKey().toCharArray()) {
				counts.putIfAbsent(c, new AtomicInteger());
				counts.get(c).incrementAndGet();
			}

			BigInteger combinations = Q20.fact(BigInteger.valueOf(entry.getKey().length()));

			Set<Character> uniques = new HashSet<>();

			for (char c : entry.getKey().toCharArray()) {
				uniques.add(c);
			}

			for (char c : uniques) {
				combinations = combinations.divide(Q20.fact(BigInteger.valueOf(counts.get(c).get())));
			}

			if (combinations.intValue() == entry.getValue().size()) {
				System.out.println(entry);
				count += combinations.intValue();
			}
		}

		System.out.println(count);
	}
}
