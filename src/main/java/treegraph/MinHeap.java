package treegraph;

import java.util.Comparator;

public class MinHeap<T extends Comparable<? super T>> extends Heap<T> {

	public MinHeap() {
		super(Comparator.naturalOrder());
	}
}
