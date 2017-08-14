package projecteuler;

import java.math.BigInteger;

public class Q16 {
	public static void main(String[] args) {
		BigInteger result = BigInteger.valueOf(2).pow(1000);
		System.out.println(result);
		
		long sum = sumDigits(result);
		
		System.out.println(sum);
	}

	static long sumDigits(BigInteger result) {
		String s = String.valueOf(result);
		
		long sum = 0;
		for (int i = 0; i < s.length(); ++i) {
			sum += new Integer(s.substring(i, i + 1));
		}
		return sum;
	}
}
