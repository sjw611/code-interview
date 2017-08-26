package projecteuler;

import java.math.BigInteger;

public class Q15 {
	public static void main(String[] args) {
		System.out.println(choose(BigInteger.valueOf(20), BigInteger.valueOf(40)));
	}

	static BigInteger choose(BigInteger lower, BigInteger upper) {
		return Q20.fact(upper).divide(Q20.fact(lower).multiply(Q20.fact(upper.subtract(lower))));
	}
}
