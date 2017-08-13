package bit;

public enum BitUtils {
	INSTANCE;
	
	public int getBit(int number, int location) {
		return (number & (1 << location)) == 0 ? 0 : 1;
	}
	
	public int setBit(int number, int location) {
		return (1 << location) | number;
	}
	
	public int clearBit(int number, int location) {
		return (~(1 << location)) & number;
	}
	
	public int insertion(int n, int m, int i, int j) {
		int nCleared = n;
		
		for (int idx = i; idx <= j; ++idx) {
			nCleared = clearBit(nCleared, idx);
		}
		
		return (m << i) | nCleared;
	}
}
