package list;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q6Test {

	private Q6 sut = new Q6();
	
	@Test
	public void test() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertTrue(sut.palindrome(list.head()));
		
		list.append(3);
		assertTrue(sut.palindrome(list.head()));
		
		list.append(5);
		assertFalse(sut.palindrome(list.head()));
		
		list.append(8);
		list.append(5);
		list.append(3);
		assertTrue(sut.palindrome(list.head()));
		
		list.append(3);
		list.append(5);
		list.append(8);
		list.append(5);
		assertFalse(sut.palindrome(list.head()));
		
		list.append(3);
		assertTrue(sut.palindrome(list.head()));
	}

}
