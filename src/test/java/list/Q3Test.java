package list;

import static org.junit.Assert.*;

import org.junit.Test;

import list.SinglyLinkedList.Node;

public class Q3Test {

	private Q3 sut = new Q3();
	
	@Test
	public void test() {
		Node<String> a = new Node<>("a");
		Node<String> b = new Node<>("b");
		Node<String> c = new Node<>("c");
		Node<String> d = new Node<>("d");
		Node<String> e = new Node<>("e");
		Node<String> f = new Node<>("f");

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		sut.deleteMiddleNode(c);
		
		assertEquals("a", a.data);
		assertEquals("b", b.data);
		assertEquals("d", c.data);
		assertEquals("f", f.data);
		
		assertEquals("b", a.next.data);
		assertEquals("d", b.next.data);
		assertEquals("e", d.next.data);
		assertEquals("f", e.next.data);
		assertNull(f.next);
	}

}
