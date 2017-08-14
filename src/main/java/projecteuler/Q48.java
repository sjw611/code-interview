package projecteuler;

import java.math.BigInteger;

public class Q48 {
	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 1; i <= 1000; ++i) {
			sum = sum.add(BigInteger.valueOf(i).pow(i));
		}
		
		String s = String.valueOf(sum);
		
		System.out.println(s.substring(s.length() - 10, s.length()));
	}
}
