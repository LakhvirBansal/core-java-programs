package StringPrograms;

import java.util.Scanner;

public class CodeArena7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();

		/*int[] arr = new int[numbers];*/
		for (int i = 0; i < testCases; i++) {

			int numbers = sc.nextInt();
			int separator = sc.nextInt();
			
			int[] numArr = new int[numbers];
			for (int j = 0; j < numbers; j++) {
				numArr[j] = sc.nextInt();
			}

			int previousNum = 0;
			int output = 0;
			int difference = 1;
			for (int j = 0; j < numArr.length; j++) {

				if (j == 0 && numArr[j] > 0) {
					output = numArr[j];
					difference = 0;
				} else if (difference == 0) {
					if (numArr[j] > output) {
						output = numArr[j];
					}

				} else {

				}

				if (numArr[j] > output) {
					output = numArr[j];
				}
				if (numArr[j] > 0 && difference > 0) {
					output = output + numArr[j];
					difference = 0;
				}
			}

		}

	}
}
