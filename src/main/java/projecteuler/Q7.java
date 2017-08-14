package projecteuler;

import java.util.Arrays;

public class Q7 {
	public static void main(String[] args) {
		int[] prime = new int[2_000_000];
		Arrays.fill(prime, 1);

		prime[0] = 0;
		prime[1] = 0;

		for (int i = 2; i <= Math.sqrt(prime.length); ++i) {
			if (prime[i] != 0) {
				for (int j = i * 2; j < prime.length; j = j + i) {
					prime[j] = 0;
				}
			}
		}

		long sum = 0;

		for (int i = 2; i < prime.length; ++i) {
			if (prime[i] == 1) {
				sum += i;
			}
		}

		System.out.println(sum);
	}

}
