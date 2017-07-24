package list;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q1Test {

	private Q1 sut = new Q1();
	
	@Test
	public void test() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.append("Song");
		list.append("Jingwei");
		list.append("song");
		list.append("Song");
		list.append("Song");
		list.append("Jingwei");
		list.append("jingwei");
		
		assertEquals(7, list.size());
		
		sut.removeDuplicates(list);
		
		assertEquals(4, list.size());
	}

}
