package Logical;

import java.util.Scanner;

public class RotateAndSpeakGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		int i, j;

		for (j = 0; j < noOfTestCases; j++) {

			int numberOfPlayers = sc.nextInt();
			int[] numbers = new int[numberOfPlayers];

			for (i = 0; i < numberOfPlayers; i++) {
				numbers[i] = sc.nextInt();
			}

			int noOfMoves = sc.nextInt();

			for (int l = 0; l < noOfMoves; l++) {
				int firstNumber = sc.nextInt();
				int secondNumber = sc.nextInt();

				switch (firstNumber) {

				case 1:
					numbers = rotateArrayAnticlock(numbers, secondNumber);
					break;

				case 2:
					numbers = rotateArrayClockWise(numbers, secondNumber);
					break;

				case 3:
					printElement(numbers, secondNumber);
					break;

				}
			}
		}
		sc.close();
	}

	private static void printElement(int[] numbers, int secondNumber) {
		System.out.println(numbers[secondNumber]);
	}

	private static int[] rotateArrayClockWise(int[] numbers, int secondNumber) {
		int length = numbers.length;
		int[] temp = new int[length];
		for (int i = 0; i < length; i++) {
			if (i + secondNumber > length - 1) {
				temp[(secondNumber + i) - length] = numbers[i];
			} else {
				temp[i + secondNumber] = numbers[i];
			}
		}
		return temp;
	}

	private static int[] rotateArrayAnticlock(int[] numbers, int secondNumber) {
		int length = numbers.length;
		int[] temp = new int[length];
		for (int i = 0; i < length; i++) {
			if (i - secondNumber < 0) {
				temp[(length - 1) - i] = numbers[i];
			} else {
				temp[i - secondNumber] = numbers[i];
			}
		}

		return temp;
	}

}
