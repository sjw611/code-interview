package bit;

public class Q4 {
	public int[] nextNumbers(int number) {
		int[] next = new int[2];

		String binaryString = Integer.toBinaryString(number);

		char[] arraySmallest = binaryString.toCharArray();

		int pos0 = arraySmallest.length - 1;
		boolean met1 = false;
		boolean met0 = false;
		int numberOf1s = 0;

		for (int i = arraySmallest.length - 1; i >= 0; --i) {
			if (arraySmallest[i] == '1') {
				met1 = true;
				++numberOf1s;
			} else if (arraySmallest[i] == '0' && met1) {
				met0 = true;
				pos0 = i;
				break;
			}
		}

		if (!met0) {
			next[0] = next[1] = number;
		} else {
			arraySmallest[pos0] = '1';
			for (int i = arraySmallest.length - 1; i > arraySmallest.length - numberOf1s; --i) {
				arraySmallest[i] = '1';
			}
			for (int i = arraySmallest.length - numberOf1s; i > pos0; --i) {
				arraySmallest[i] = '0';
			}
			next[0] = Integer.valueOf(new String(arraySmallest), 2);
		}

		// finding next largest
		char[] arrayLargest = binaryString.toCharArray();

		int total1s = 0;

		for (char c : arrayLargest) {
			if (c == '1') {
				++total1s;
			}
		}

		for (int i = 0; i < total1s; ++i) {
			arrayLargest[i] = '1';
		}

		for (int i = total1s; i < arrayLargest.length; ++i) {
			arrayLargest[i] = '0';
		}

		next[1] = Integer.valueOf(new String(arrayLargest), 2);

		return next;
	}

}
