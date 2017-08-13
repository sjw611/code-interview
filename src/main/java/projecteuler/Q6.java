package projecteuler;

public class Q6 {
	public static void main(String[] args) {
		System.out.println(sumSquareDifference(1000000));
	}
	
	public static long sumSquareDifference(long n) {
		long sum = 0;
		
		for (long i = 1; i < n; ++i) {
			sum += (i * (i + 1 + n) * (n - i));
		}
		
		return sum;
	}
}
