package treegraph;

import java.util.Objects;

public class MatchingGoalValidator<T> implements GoalValidator<T> {

	@Override
	public boolean isGoal(Node<T> node, T target) {
		Objects.requireNonNull(node);
		Objects.requireNonNull(target);
		System.out.println("Validate " + node.element);
		return target.equals(node.element);
	}

}
