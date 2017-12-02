package recursive;

import java.util.Arrays;
import java.util.Objects;

public class PaintFill {

	private static final char BLANK = ' ';

	public static void main(String[] args) {
		PaintFill app = new PaintFill();

		Cell[][] grid = new Cell[4][5];

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[i].length; ++j) {
				grid[i][j] = new PaintFill.Cell();
			}
		}

		grid[0][1].setColour('X');
		grid[0][3].setColour('X');
		grid[0][4].setColour('X');
		grid[1][0].setColour('X');
		grid[2][0].setColour('X');
		grid[3][0].setColour('X');

		for (int i = 0; i < grid.length; ++i) {
			System.out.println(Arrays.toString(grid[i]));
		}

		app.fill(grid, 2, 1);

		for (int i = 0; i < grid.length; ++i) {
			System.out.println(Arrays.toString(grid[i]));
		}

	}

	public void fill(Cell[][] grid, int x, int y) {
		Objects.requireNonNull(grid);

		int height = grid.length;

		Objects.requireNonNull(grid[0]);

		int width = grid[0].length;

		if (x < 0 || x >= width) {
			throw new IllegalArgumentException();
		}
		if (y < 0 || y >= height) {
			throw new IllegalArgumentException();
		}

		fill(grid, x, y, 'O');
	}

	private void fill(Cell[][] grid, int x, int y, char colour) {
		Cell current = grid[y][x];

		if (current.colour == BLANK) {
			current.setColour(colour);
			if (x - 1 >= 0) {
				fill(grid, x - 1, y, colour);
			} else {
				return;
			}
			if (y - 1 >= 0) {
				fill(grid, x, y - 1, colour);
			} else {
				return;
			}
			if (x + 1 < grid[0].length) {
				fill(grid, x + 1, y, colour);
			} else {
				return;
			}
			if (y + 1 < grid.length) {
				fill(grid, x, y + 1, colour);
			} else {
				return;
			}
		} else if (current.colour != colour) {
			return;
		}

	}

	private static class Cell {
		private char colour = ' ';

		public void setColour(char colour) {
			this.colour = colour;
		}

		@Override
		public String toString() {
			return String.valueOf(colour);
		}

	}
}
