package recursive;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class RobotGrid {

	public static void main(String[] args) {
		RobotGrid solver = new RobotGrid();

		Coordinate[][] maze = new Coordinate[4][4];

		maze[0][0] = new Coordinate(0, 0, true);
		maze[1][0] = new Coordinate(1, 0, true);
		maze[2][0] = new Coordinate(2, 0, true);
		maze[3][0] = new Coordinate(3, 0, false);

		maze[0][1] = new Coordinate(0, 1, true);
		maze[1][1] = new Coordinate(1, 1, false);
		maze[2][1] = new Coordinate(2, 1, true);
		maze[3][1] = new Coordinate(3, 1, true);

		maze[0][2] = new Coordinate(0, 2, false);
		maze[1][2] = new Coordinate(1, 2, true);
		maze[2][2] = new Coordinate(2, 2, false);
		maze[3][2] = new Coordinate(3, 2, true);

		maze[0][3] = new Coordinate(0, 3, true);
		maze[1][3] = new Coordinate(1, 3, true);
		maze[2][3] = new Coordinate(2, 3, true);
		maze[3][3] = new Coordinate(3, 3, true);

		for (Iterator<Coordinate> iter = solver.path(maze).descendingIterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
	}

	public Deque<Coordinate> path(Coordinate[][] maze) {
		Objects.requireNonNull(maze);

		Deque<Coordinate> path = new LinkedList<>();

		Pair[][] nextMatrix = new Pair[maze.length][maze[0].length];

		for (int i = 0; i < nextMatrix.length; ++i) {
			for (int j = 0; j < nextMatrix[i].length; ++j) {
				Coordinate current = maze[i][j];
				if (current.isAccessible()) {

					if (j < nextMatrix[i].length - 1) {
						Coordinate down = maze[i][j + 1];
						if (down.isAccessible()) {
							Pair pair = new Pair();
							pair.setPrevious(current);
							pair.setCurrent(down);
							nextMatrix[i][j + 1] = pair;
						}
					}

					if (i < nextMatrix.length - 1) {
						Coordinate right = maze[i + 1][j];
						if (right.isAccessible()) {
							Pair pair = new Pair();
							pair.setPrevious(current);
							pair.setCurrent(right);
							nextMatrix[i + 1][j] = pair;
						}
					}
				}
			}
		}

		Coordinate current = nextMatrix[nextMatrix.length - 1][nextMatrix[0].length - 1].current;

		path.add(current);

		while (true) {
			Coordinate previous = nextMatrix[current.x][current.y].previous;

			path.add(previous);

			if (previous.x == 0 && previous.y == 0) {
				break;
			}
			current = nextMatrix[previous.x][previous.y].current;
		}

		return path;
	}

	static class Pair {
		private Coordinate previous;
		private Coordinate current;

		public Coordinate getPrevious() {
			return previous;
		}

		public void setPrevious(Coordinate previous) {
			this.previous = previous;
		}

		public Coordinate getCurrent() {
			return current;
		}

		public void setCurrent(Coordinate current) {
			this.current = current;
		}

		@Override
		public String toString() {
			return previous + "->" + current;
		}

	}

	static class Coordinate {
		private int x;
		private int y;
		private boolean accessible;

		public Coordinate(int x, int y, boolean accessible) {
			this.x = x;
			this.y = y;
			this.accessible = accessible;
		}

		public boolean isAccessible() {
			return accessible;
		}

		@Override
		public String toString() {
			return String.format("(%d, %d)", x, y);
		}
	}
}
