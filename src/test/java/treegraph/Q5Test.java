package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q5Test {

	private Q5 sut = new Q5();

	@Test(expected = NullPointerException.class)
	public void nullCheck() {
		sut.isBst(null);
	}

	@Test
	public void singleNodeTree() {
		assertTrue(sut.isBst(new Node<String>("Hello")));
	}

	@Test
	public void fullTree() {
		Node<Integer> eight = new Node<>(8);
		Node<Integer> five = new Node<>(5);
		Node<Integer> ten = new Node<>(10);
		Node<Integer> two = new Node<>(2);
		Node<Integer> six = new Node<>(6);
		Node<Integer> nine = new Node<>(9);
		Node<Integer> eleven = new Node<>(11);

		eight.left = five;
		eight.right = ten;
		five.left = two;
		five.right = six;
		ten.left = nine;
		ten.right = eleven;

		assertTrue(sut.isBst(eight));
	}

	@Test
	public void linkedlist() {
		Node<Integer> eight = new Node<>(8);
		Node<Integer> five = new Node<>(5);
		Node<Integer> two = new Node<>(2);

		eight.left = five;
		five.left = two;

		assertTrue(sut.isBst(eight));
	}

	@Test
	public void triangle() {
		Node<Integer> eight = new Node<>(8);
		Node<Integer> five = new Node<>(5);
		Node<Integer> ten = new Node<>(10);
		Node<Integer> two = new Node<>(2);
		Node<Integer> eleven = new Node<>(11);
		Node<Integer> six = new Node<>(6);
		Node<Integer> nine = new Node<>(9);

		eight.left = five;
		eight.right = ten;
		five.left = two;
		ten.right = eleven;
		two.left = six;
		eleven.right = nine;

		assertFalse(sut.isBst(eight));
	}

	@Test
	public void special() {
		Node<Integer> twenty = new Node<>(20);
		Node<Integer> ten = new Node<>(10);
		Node<Integer> thirty = new Node<>(30);
		Node<Integer> twentyFive = new Node<>(25);

		twenty.left = ten;
		ten.right = twentyFive;
		twenty.right = thirty;

		assertFalse(sut.isBst(twenty));
	}
}
