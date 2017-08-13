package bit;

public enum BitUtils {
	INSTANCE;
	
	public int getBit(int number, int location) {
		return (number & (1 << location)) == 0 ? 0 : 1;
	}
	
	public void setBit(int number, int location) {
		
	}
}
