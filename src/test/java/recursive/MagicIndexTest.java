package recursive;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagicIndexTest {

	private MagicIndex sut = new MagicIndex();

	@Test
	public void test() {
		assertEquals(0, sut.find(new int[] { 0, 1, 3, 5, 6 }));
		assertEquals(-1, sut.find(new int[] { 1, 2, 3, 5, 6 }));
		assertEquals(2, sut.find(new int[] { -1, -2, 2, 5, 6 }));
		assertEquals(2, sut.find(new int[] { -2, -2, 2, 5, 6 }));
		assertEquals(2, sut.find(new int[] { -2, -2, 2, 5 }));
	}

}
