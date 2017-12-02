package moderate;

public class NumberSwapper {
	public static void main(String[] args) {
		int a = 14;
		int b = 224;

		System.out.println(swap(a, b));
	}

	private static Pair swap(int a, int b) {
		int offset = 16;
		int mask = (int) Math.pow(2, offset) - 1;

		a = (a << offset) | b;
		b = a ^ b;
		b = b >> offset;
		a = a & mask;

		return new Pair(a, b);
	}

	private static class Pair {
		private int a;
		private int b;

		private Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "(" + a + ", " + b + ")";
		}
	}
}
