package studio2;

import java.util.Scanner;

public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner (System.in);
		System.out.println("Start Amount: ");
		int startAmount = in.nextInt();
		System.out.println("Win Chance: ");
		double winChance = in.nextDouble();
		System.out.println("Win Limit: ");
		int winLimit = in.nextInt();
		System.out.println("Total Simulations: ");
		int totalSimulations = in.nextInt();
		int numberOfPlays = 0;
		int numberofRuins = 0;

		for(int i = 0; i < totalSimulations; i++) {
			int currentAmount = startAmount;
			numberOfPlays = 0;
			while(currentAmount > 0 && currentAmount < winLimit) {
				numberOfPlays++;
				double randomValue = Math.random();
				if(randomValue <= winChance) {//win
					currentAmount++;
				} else {//lost
					currentAmount--;
				}
			}
			System.out.print("Day " + (i+1));
			System.out.print("  Number of Plays " + numberOfPlays);
			if(currentAmount == 0) {
				System.out.println("  Ruin");
				numberofRuins++;
			}else {
				System.out.println("  Success");
			}
		}
		System.out.println("Actual Ruin Rate: " + (double)numberofRuins/totalSimulations);
		double expectedRuinRate = 0;
		if(winChance == 0.5) {
			expectedRuinRate = 1 - (startAmount / winLimit);
		}else {
			double alpha = (1 - winChance) / winChance;
			expectedRuinRate = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha,winLimit));
		}
		System.out.println("Expected Ruin Rate: " + expectedRuinRate);

	}

}
