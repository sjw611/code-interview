package treegraph;

import java.util.Objects;

public abstract class Search<T> {
	private Frontier<T> frontier;
	private GoalValidator<T> goalValidator;
	
	public Search(Frontier<T> frontier, GoalValidator<T> goalValidator) {
		this.frontier = frontier;
		this.goalValidator = goalValidator;
	}
	
	public Node<T> find(Node<T> root, T element) {
		Objects.requireNonNull(root);
		Objects.requireNonNull(element);
		
		frontier.init();
		
		frontier.add(root);
		
		while (!frontier.isEmpty()) {
			Node<T> current = frontier.next();
			
			if (current.left != null) {
				frontier.add(current.left);
			}
			if (current.right != null) {
				frontier.add(current.right);
			}
			
			if (goalValidator.isGoal(current, element)) {
				return current;
			}
		}
		
		return null;
	}
}
