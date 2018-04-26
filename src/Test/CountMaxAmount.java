package Test;

import java.util.Scanner;

public class CountMaxAmount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();

		int[][] colony = new int[arraySize][arraySize];

		for (int i = 0; i < colony.length; i++) {

			for (int j = 0; j < colony.length; j++) {
				String row = sc.next();
				colony[i][j] = Integer.parseInt(row);
			}
		}

		for (int i = 0; i < colony.length; i++) {
			for (int j = 0; j < colony.length; j++) {
				System.out.println(colony[i][j]);
			}
		}
	}
}
