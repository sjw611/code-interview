package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q4Test {

	private Q4 sut = new Q4();
	
	@Test(expected = NullPointerException.class)
	public void nullCheck() {
		sut.isBalanced(null);
	}

	@Test
	public void singleNodeTree() {
		assertTrue(sut.isBalanced(new Node<String>("Hello")));
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
		
		assertTrue(sut.isBalanced(eight));
	}
	
	@Test
	public void linkedlist() {
		Node<Integer> eight = new Node<>(8);
		Node<Integer> five = new Node<>(5);
		Node<Integer> two = new Node<>(2);
		
		eight.left = five;
		five.left = two;
		
		assertFalse(sut.isBalanced(eight));
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
		
		assertFalse(sut.isBalanced(eight));
	}
}
