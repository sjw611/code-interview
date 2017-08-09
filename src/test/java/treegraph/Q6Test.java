package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q6Test {

	private Q6 sut = new Q6();
	
	@Test
	public void test() {
		Node<Integer> eight = new Node<>(8);
		Node<Integer> five = new Node<>(5);
		Node<Integer> ten = new Node<>(10);
		Node<Integer> two = new Node<>(2);
		Node<Integer> six = new Node<>(6);
		Node<Integer> nine = new Node<>(9);
		Node<Integer> eleven = new Node<>(11);
		Node<Integer> seven = new Node<>(7);
		Node<Integer> twenty = new Node<>(20);
		
		eight.left = five;
		five.parent = eight;
		
		eight.right = ten;
		ten.parent = eight;
		
		five.left = two;
		two.parent = five;
		
		five.right = six;
		six.parent = five;
		
		ten.left = nine;
		nine.parent = ten;
		
		ten.right = eleven;
		eleven.parent = ten;
		
		six.right = seven;
		seven.parent = six;
		
		eleven.right = twenty;
		twenty.parent = eleven;
		
		assertSame(five, sut.successor(two));
		assertSame(six, sut.successor(five));
		assertSame(seven, sut.successor(six));
		assertSame(eight, sut.successor(seven));
		assertSame(nine, sut.successor(eight));
		assertSame(ten, sut.successor(nine));
		assertSame(eleven, sut.successor(ten));
		assertSame(twenty, sut.successor(eleven));
	}

}
