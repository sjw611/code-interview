package treegraph;

import java.util.HashSet;
import java.util.Set;

public class GraphNode<T> {
	T element;
	Set<GraphNode<T>> neighbours = new HashSet<>();
	
	public GraphNode(T element) {
		this.element = element;
	}
	
	public void addNeighbour(GraphNode<T> node) {
		neighbours.add(node);
	}
}
