package bit;

import org.junit.Test;

public class Q8Test {

	private Q8 sut = new Q8();
	
	@Test(expected = NullPointerException.class)
	public void nullScreen() {
		sut.drawLine(null, 0, 0, 0, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void widthInvalidScreen() {
		byte[] screen = new byte[3];
		sut.drawLine(screen, 12, 0, 0, 0);
	}
	
	@Test
	public void screen() {
		byte[] screen = new byte[3];
		sut.drawLine(screen, 8, 1, 3, 1);
		
		sut.printScreen(screen, 8);
	}
	
	@Test
	public void widerScreen() {
		byte[] screen = new byte[4];
		sut.drawLine(screen, 16, 2, 14, 1);
		
		sut.printScreen(screen, 16);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void incompleteScreen() {
		byte[] screen = new byte[3];
		sut.drawLine(screen, 16, 0, 0, 0);
	}
}
