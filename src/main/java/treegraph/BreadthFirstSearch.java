package treegraph;

public class BreadthFirstSearch<T> extends Search<T> {

	public BreadthFirstSearch() {
		super(new FifoFrontier<>(), new MatchingGoalValidator<>());
	}

}
