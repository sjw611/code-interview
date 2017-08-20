package bit;

public class Q3 {
	public int flipBitToWin(int number) {
		String binaryString = Integer.toBinaryString(number);

		int maxLength = 0;
		int zeroPosition = 0;
		int currentLength = 0;
		int currentPosition = 0;

		while (currentPosition != binaryString.length() && zeroPosition != binaryString.length()) {
			currentLength = 0;
			while (currentPosition != binaryString.length() && binaryString.charAt(currentPosition) == '1') {
				++currentLength;
				++currentPosition;
				++zeroPosition;
			}

			if (currentPosition != binaryString.length() && binaryString.charAt(currentPosition) == '0') {
				++currentLength;
				++currentPosition;
				++zeroPosition;
			}

			while (currentPosition != binaryString.length() && binaryString.charAt(currentPosition) == '1') {
				++currentLength;
				++currentPosition;
			}

			if (currentLength > maxLength) {
				maxLength = currentLength;
			}

			currentPosition = zeroPosition;
			while (currentPosition != binaryString.length() && binaryString.charAt(currentPosition) == '0') {
				++currentPosition;
			}
		}

		return maxLength;
	}
}
