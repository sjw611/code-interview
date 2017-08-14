package projecteuler;

public class Q9 {
	public static void main(String[] args) {
		long sum = 1000;
		for (long i = 1; i < sum / 2; ++i) {
			for (long j = 1; j < sum / 2; ++j) {
				long k = sum - i - j;

				if (i * i + j * j == k * k || i * i + k * k == j * j || j * j + k * k == i * i) {
					System.out.println(i * j * k);
					return;
				}
			}
		}
	}
}
