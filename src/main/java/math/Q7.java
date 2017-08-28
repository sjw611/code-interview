package math;

import java.util.Random;

public class Q7 {
	public static void main(String[] args) {
		int numberFamilies = 1_000_000;

		int numberBoys = 0;
		int numberGirls = 0;

		Random rand = new Random();

		for (int i = 0; i < numberFamilies; ++i) {
			boolean hasGirl = false;

			while (!hasGirl) {
				boolean girl = rand.nextBoolean();
				if (girl) {
					hasGirl = true;
					++numberGirls;
				} else {
					++numberBoys;
				}

			}
		}
		
		System.out.println("Number of boys: " + numberBoys);
		System.out.println("Number of girls: " + numberGirls);
	}
}
