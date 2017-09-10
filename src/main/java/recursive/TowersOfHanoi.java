package recursive;

public class TowersOfHanoi {

	public void solve(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}

		System.out.println("Solve for " + n);

		solve(n, 1, 2, 3);
	}

	private void solve(int n, int source, int intermediate, int destination) {
		if (n == 1) {
			System.out.println(String.format("%s -> %s", source, destination));
		} else {
			solve(n - 1, source, destination, intermediate);
			solve(1, source, intermediate, destination);
			solve(n - 1, intermediate, source, destination);
		}
	}

	public static void main(String[] args) {
		TowersOfHanoi sut = new TowersOfHanoi();
		sut.solve(4);
	}
}
