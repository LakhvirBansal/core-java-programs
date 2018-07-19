package CodeArena;

import java.util.Scanner;

public class CodeArena13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		int[][] arr = new int[number][number];
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int rowCount = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					rowCount = rowCount + 1;
					break;
				}
			}
		}

	}


}
