package projecteuler;

import java.math.BigInteger;

public class Q20 {
	public static void main(String[] args) {
		BigInteger fact = fact(BigInteger.valueOf(100));
		System.out.println(fact);
		
		long digits = Q16.sumDigits(fact);
		
		System.out.println(digits);
	}

	static BigInteger fact(BigInteger num) {
		if (num.compareTo(BigInteger.ONE) <= 0) {
			return BigInteger.ONE;
		}

		return fact(num.subtract(BigInteger.ONE)).multiply(num);
	}
}
