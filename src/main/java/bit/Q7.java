package bit;

public class Q7 {
	public int pairwiseSwap(int number) {
		return ((number & 0xaaaaaaaa) >>> 1) | ((number & 0x55555555) << 1);
	}
}
