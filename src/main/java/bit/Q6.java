package bit;

public class Q6 {
	public int conversion(int number1, int number2) {
		int xor = number1 ^ number2;
		int conversion = 0;

		for (int i = xor; i != 0; i = i >> 1) {
			conversion += i & 1;
		}

		return conversion;
	}
}
