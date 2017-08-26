package bit;

import java.util.Objects;

public class Q8 {

	private static final int WIDTH_MULTIPLIER = 8;

	public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		Objects.requireNonNull(screen);

		if (width % WIDTH_MULTIPLIER != 0) {
			throw new IllegalArgumentException("Width not divisible by " + WIDTH_MULTIPLIER);
		}

		if (x1 > x2) {
			throw new IllegalArgumentException("x1 greater than x2");
		}

		if (x1 < 0 || x2 >= width) {
			throw new IllegalArgumentException("x out of range");
		}

		if (screen.length * WIDTH_MULTIPLIER % width != 0) {
			throw new IllegalArgumentException("Screen not complete");
		}

		int height = screen.length * WIDTH_MULTIPLIER / width;

		if (y >= height) {
			throw new IllegalArgumentException("y out of range");
		}

		int startInArray = y * width / WIDTH_MULTIPLIER;
		int endInArray = (y + 1) * width / WIDTH_MULTIPLIER - 1;

		for (int i = startInArray; i <= endInArray; ++i) {
			for (int j = 0; j < WIDTH_MULTIPLIER; ++j) {
				int currentIndex = (i - startInArray) * WIDTH_MULTIPLIER + j;

				if (currentIndex >= x1 && currentIndex <= x2) {
					int bit = BitUtils.INSTANCE.setBit((byte) screen[i], WIDTH_MULTIPLIER - j - 1);
					screen[i] = (byte) bit;
				}
			}
		}

	}

	void printScreen(byte[] screen, int width) {
		int height = screen.length * WIDTH_MULTIPLIER / width;

		System.out.println("********");

		for (int i = 0; i < height; ++i) {
			for (int j = i * width / WIDTH_MULTIPLIER; j < i * width / WIDTH_MULTIPLIER
					+ width / WIDTH_MULTIPLIER; ++j) {
				System.out.print(leftPad(Integer.toBinaryString(screen[j])));
			}
			System.out.println();
		}

		System.out.println("********");
	}

	private String leftPad(String str) {
		int currentLength = str.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < WIDTH_MULTIPLIER - currentLength; ++i) {
			sb.append("0");
		}
		sb.append(str);

		String full = sb.toString();
		int len = full.length();
		return full.substring(len - WIDTH_MULTIPLIER, len);
	}
}
