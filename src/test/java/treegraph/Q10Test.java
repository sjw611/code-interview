package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q10Test {
	private Q10 sut = new Q10();

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
		eight.right = ten;
		five.left = two;
		five.right = six;
		ten.left = nine;
		ten.right = eleven;
		six.right = seven;
		eleven.right = twenty;
		
		assertTrue(sut.isSubtree(eight, eleven));
		assertTrue(sut.isSubtree(five, six));
		assertTrue(sut.isSubtree(eight, ten));
		assertFalse(sut.isSubtree(five, eleven));
	}

}
