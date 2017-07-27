package list;

import org.junit.Test;

public class Q5Test {

	private Q5 sut = new Q5();
	
	@Test
	public void test() {
		SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
		l1.append(7);
		l1.append(1);
		l1.append(6);
		
		SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
		l2.append(5);
		l2.append(9);
		l2.append(2);
		
		System.out.println(sut.sum(l1, l2));
		System.out.println(sut.reverseSum(l1, l2));
		
		l2.append(1);
		System.out.println(sut.sum(l1, l2));
		System.out.println(sut.reverseSum(l1, l2));
		
		l1.append(9);
		System.out.println(sut.sum(l1, l2));
		System.out.println(sut.reverseSum(l1, l2));
	}

}
