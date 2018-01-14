package recursive;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {

	public static void main(String[] args) {
		System.out.println(solveEightQueens());
	}

	private static List<List<Integer>> permutations(int number) {
		List<List<Integer>> solutions = new ArrayList<>();
		solutions.add(List.of(0));

		for (int i = 1; i <= number; i++) {
			solutions = permutations(solutions, i);
		}
		return solutions;
	}

	private static List<List<Integer>> permutations(List<List<Integer>> partialSolutions, int number) {
		List<List<Integer>> solutions = new ArrayList<>();

		for (List<Integer> partialSolution : partialSolutions) {
			for (int i = 0; i <= partialSolution.size(); i++) {
				List<Integer> completeSolution = new ArrayList<>(partialSolution);
				completeSolution.add(i, number);
				solutions.add(completeSolution);
			}
		}

		return solutions;
	}

	public static List<List<Integer>> solveEightQueens() {
		return solve(8);
	}

	public static List<List<Integer>> solve(int magnitude) {
		List<List<Integer>> permutations = permutations(magnitude - 1);

		List<List<Integer>> solutions = new ArrayList<>();

		for (List<Integer> permutation : permutations) {

			boolean valid = true;

			for (int i = 0; i < permutation.size() - 1; i++) {
				for (int j = 1; j < permutation.size(); j++) {
					if (i != j && j - i == Math.abs(permutation.get(j) - permutation.get(i))) {
						valid = false;
						break;
					}
				}
			}

			if (valid) {
				solutions.add(permutation);
			}
		}

		return solutions;
	}
}
