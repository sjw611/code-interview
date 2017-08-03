package treegraph;

public class DepthFirstSearch<T> extends Search<T> {

	public DepthFirstSearch() {
		super(new LifoFrontier<>(), new MatchingGoalValidator<>());
	}
}
