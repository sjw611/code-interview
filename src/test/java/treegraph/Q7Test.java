package treegraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import treegraph.Q7.NoBuildOrderAvailableException;

public class Q7Test {

	private Q7 sut = new Q7();
	
	@Test(expected = NullPointerException.class)
	public void nullCheck() {
		sut.buildOrder(null);
	}

	@Test
	public void singleProject() {
		GraphNode<String> a = new GraphNode<String>("A");
		List<GraphNode<String>> order = sut.buildOrder(Collections.singleton(a));
		assertEquals(1, order.size());
		assertSame(a, order.get(0));
	}
	
	@Test(expected = NoBuildOrderAvailableException.class)
	public void cycleFull() {
		GraphNode<String> a = new GraphNode<String>("A");
		GraphNode<String> b = new GraphNode<String>("B");
		GraphNode<String> c = new GraphNode<String>("C");
		
		a.addNeighbour(b);
		b.addNeighbour(c);
		c.addNeighbour(a);
		
		sut.buildOrder(new HashSet<>(Arrays.asList(a, b, c)));
	}
	
	@Test(expected = NoBuildOrderAvailableException.class)
	public void cycleAndSingle() {
		GraphNode<String> a = new GraphNode<String>("A");
		GraphNode<String> b = new GraphNode<String>("B");
		GraphNode<String> c = new GraphNode<String>("C");
		
		a.addNeighbour(b);
		b.addNeighbour(a);
		
		sut.buildOrder(new HashSet<>(Arrays.asList(a, b, c)));
	}
	
	@Test
	public void distinctProjects() {
		GraphNode<String> a = new GraphNode<String>("A");
		GraphNode<String> b = new GraphNode<String>("B");
		GraphNode<String> c = new GraphNode<String>("C");
		
		List<GraphNode<String>> order = sut.buildOrder(new HashSet<>(Arrays.asList(a, b, c)));
		
		System.out.println("Distinct projects order " + order);
	}
	
	@Test
	public void example() {
		GraphNode<String> a = new GraphNode<String>("A");
		GraphNode<String> b = new GraphNode<String>("B");
		GraphNode<String> c = new GraphNode<String>("C");
		GraphNode<String> d = new GraphNode<String>("D");
		GraphNode<String> e = new GraphNode<String>("E");
		GraphNode<String> f = new GraphNode<String>("F");
		
		d.addNeighbour(a);
		b.addNeighbour(f);
		d.addNeighbour(b);
		a.addNeighbour(f);
		c.addNeighbour(d);
		
		List<GraphNode<String>> order = sut.buildOrder(new HashSet<>(Arrays.asList(a, b, c, d, e, f)));
		
		System.out.println("Example order " + order);
	}
}
