package math;

public class Q9 {
	public static void main(String[] args) {
		int numberDoors = 100;
		boolean[] doors = new boolean[numberDoors + 1];

		for (int i = 1; i <= numberDoors; ++i) {
			for (int j = i; j <= numberDoors; j += i) {
				doors[j] = !doors[j];
			}
		}

		for (int i = 1; i <= numberDoors; ++i) {
			if (doors[i]) {
				System.out.println("Door " + i + " is open");
			}
		}
	}
}
