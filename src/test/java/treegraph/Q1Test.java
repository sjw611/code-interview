package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q1Test {

	private Q1 sut = new Q1();
	
	@Test
	public void test() {
		GraphNode<String> a = new GraphNode<String>("A");
		GraphNode<String> b = new GraphNode<String>("B");
		GraphNode<String> c = new GraphNode<String>("C");
		GraphNode<String> d = new GraphNode<String>("D");
		GraphNode<String> e = new GraphNode<String>("E");
		
		a.addNeighbour(b);
		a.addNeighbour(d);
		a.addNeighbour(c);
		
		c.addNeighbour(d);
		c.addNeighbour(e);
		
		d.addNeighbour(e);
		
		assertTrue(sut.routeBetweenNodes(a, b));
		assertTrue(sut.routeBetweenNodes(a, e));
		assertTrue(sut.routeBetweenNodes(c, e));
		assertTrue(sut.routeBetweenNodes(b, b));
		assertFalse(sut.routeBetweenNodes(b, e));
	}

	@Test
	public void cycle() {
		GraphNode<String> a = new GraphNode<String>("A");
		GraphNode<String> b = new GraphNode<String>("B");
		GraphNode<String> c = new GraphNode<String>("C");
		
		a.addNeighbour(b);
		b.addNeighbour(a);
		b.addNeighbour(c);
		
		assertTrue(sut.routeBetweenNodes(a, b));
		assertTrue(sut.routeBetweenNodes(b, a));
		assertTrue(sut.routeBetweenNodes(a, c));
		assertFalse(sut.routeBetweenNodes(c, a));
	}
}
