package treegraph;

public interface GoalValidator<T> {
	boolean isGoal(Node<T> node, T target);
}
