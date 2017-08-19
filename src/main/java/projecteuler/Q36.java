package projecteuler;

public class Q36 {

	public static void main(String[] args) {
		long sum = 0;

		for (int i = 0; i <= 1_000_000; ++i) {

			if (isPalindrome(Integer.valueOf(i).toString()) && isPalindrome(Integer.toBinaryString(i))) {
				System.out.println(i + ":" + Integer.toBinaryString(i));
				sum += i;
			}
		}

		System.out.println(sum);
	}

	private static boolean isPalindrome(String number) {
		for (int i = 0; i < number.length() / 2; ++i) {
			if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
				return false;
			}
		}

		return true;
	}
}
