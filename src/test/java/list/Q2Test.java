package list;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q2Test {

	private Q2 sut = new Q2();
	
	private SinglyLinkedList<String> list = new SinglyLinkedList<>();
	
	{
		list.append("Song");
		list.append("Jingwei");
		list.append("song");
		list.append("jingwei");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidK() {
		sut.kToLast(list, -1);
	}

	@Test(expected = NullPointerException.class)
	public void invalidList() {
		sut.kToLast(null, 0);
	}
	
	@Test
	public void head() {
		assertEquals("Song", sut.kToLast(list, 5));
		assertEquals("Song", sut.kToLast(list, 3));
	}
	
	@Test
	public void tail() {
		assertEquals("jingwei", sut.kToLast(list, 0));
	}
	
	@Test
	public void mid() {
		assertEquals("Jingwei", sut.kToLast(list, 2));
		assertEquals("song", sut.kToLast(list, 1));
	}
}
