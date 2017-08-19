package projecteuler;

import java.math.BigInteger;

public class Q25 {
	static BigInteger[] cache = new BigInteger[10000];

	public static void main(String[] args) {
		int targetLength = 1000;
		int n = 1;
		while (true){
			int currentLength = fib(n).toString().length();
			if (currentLength>=targetLength) {
				System.out.println(n);
				System.out.println(currentLength);
				break;
			}
			++n;
		}
	}
	
	
	
	public static BigInteger fib(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}

		if (n == 1 || n == 2) {
			cache[n] = BigInteger.ONE;
			return cache[n];
		}
		if (cache[n] != null) {
			return cache[n];
		}

		BigInteger fibN = fib(n - 1).add(fib(n - 2));
		cache[n] = fibN;
		return fibN;
	}
}
