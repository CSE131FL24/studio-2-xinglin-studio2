package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int startAmount = 2;
		double winChance = 0.7;
		int winLimit = 10;
		int totalSimulations = 500;
		
		for (int count = 1; count <= totalSimulations; count++) {
			while (startAmount <= winLimit  || startAmount == 0) {
				boolean random_boolean = Math.random() < winChance;
				if (random_boolean) {
					startAmount += 1;
					System.out.println("win");
				}
				else {
					startAmount -= 1;
					System.out.println("Lose");
				}
			
			}
		}
		
		
	}

}
