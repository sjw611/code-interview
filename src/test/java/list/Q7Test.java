package list;

import static org.junit.Assert.*;

import org.junit.Test;

import list.SinglyLinkedList.Node;

public class Q7Test {

	private Q7 sut = new Q7();
	
	@Test
	public void intersection() {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		
		node1.next = node3;
		node2.next = node3;
		node3.next = node4;
	
		assertEquals(node3, sut.intersection(node1, node2));
	}
	
	@Test
	public void intersection2() {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		
		node1.next = node3;
		node2.next = node5;
		node3.next = node4;
		node4.next = node5;
	
		assertEquals(node5, sut.intersection(node1, node2));
	}
	

	@Test
	public void noIntersection() {
		Node<Integer> node1 = new Node<Integer>(5);
		Node<Integer> node2 = new Node<Integer>(5);
		
		assertNull(sut.intersection(node1, node2));
	}
}
