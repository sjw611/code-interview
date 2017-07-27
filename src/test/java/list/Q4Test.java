package list;

import org.junit.Test;

public class Q4Test {

	private Q4 sut= new Q4();

	@Test
	public void test() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.append(3);
		list.append(5);
		list.append(8);
		list.append(5);
		list.append(10);
		list.append(2);
		list.append(1);
		
		System.out.println(list.toString());
		
		System.out.println(sut.partition(list, 5));
	}

}
