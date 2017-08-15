package projecteuler;

public class Q12 {
	public static void main(String[] args) {

		long max = 0;
		for (long n = 1; n < 100000; ++n) {
			long triangle = n * (n + 1) / 2;
			long divisors = numDivisors(triangle);
			if (divisors > max) {
				max = divisors;
				System.out.println("triangle " + triangle + ":" + divisors);
			}
		}
	}

	public static long numDivisors(long num) {
		long d = 0;

		long upper = num;
		
		for (long i = 1; i < upper; ++i) {
			if (num % i == 0) {
				++d;
				upper = num / i;
				
				if (upper > i) {
					++d;
				}
			}
		}
		return d;
	}

}
