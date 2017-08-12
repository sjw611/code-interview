package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q8Test {

	private Q8 sut = new Q8();
	
	@Test
	public void test() {
		Node<Integer> one = new Node<>(1);
		Node<Integer> two = new Node<>(2);
		Node<Integer> three = new Node<>(3);
		Node<Integer> four = new Node<>(4);
		Node<Integer> five = new Node<>(5);
		Node<Integer> six = new Node<>(6);
		Node<Integer> seven = new Node<>(7);
		Node<Integer> eight = new Node<>(8);
		Node<Integer> nine = new Node<>(9);
		
		one.left = two;
		one.right = three;
		
		two.parent = one;
		three.parent = one;
		
		two.left = four;
		two.right = five;
		
		four.parent = two;
		five.parent = two;
		
		three.left = six;
		
		six.parent = three;
		
		six.left = seven;
		six.right = eight;
		
		seven.parent = six;
		eight.parent = six;
		
		eight.left = nine;
		nine.parent = eight;
		
		assertSame(two, sut.findFirstCommonAncestor(four, five));
		assertSame(one, sut.findFirstCommonAncestor(four, three));
		assertSame(six, sut.findFirstCommonAncestor(seven, nine));
		assertSame(one, sut.findFirstCommonAncestor(five, three));
		assertSame(three, sut.findFirstCommonAncestor(six, seven));
		assertSame(three, sut.findFirstCommonAncestor(six, nine));
		assertSame(one, sut.findFirstCommonAncestor(two, two));
		
		assertSame(null, sut.findFirstCommonAncestor(one, one));
	}

}
