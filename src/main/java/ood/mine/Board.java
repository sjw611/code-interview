package ood.mine;

public class Board {

	private Grid[][] grid;

	public Board(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		grid = new Grid[n][n];
	}

	public Grid getGrid(int x, int y) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid.length) {
			throw new IllegalArgumentException();
		}
		return grid[x][y];
	}

}
