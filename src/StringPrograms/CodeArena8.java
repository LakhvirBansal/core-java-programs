package StringPrograms;

import java.util.Scanner;

public class CodeArena8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int nearestPrimeNumber = getPrimeNumber(number);

		/*int[] arr = new int[numbers];*/
		for (int i = 0; i < number; i++) {

			

		}

	}

	private static int getPrimeNumber(int number) {
		int returnVal = 0;
		for (int i = number; i > 2; i++) {
			boolean checkPrime = checkPrime(i);
			if (checkPrime) {
				returnVal = i;
				break;
			}
		}
		return returnVal;
	}

	private static boolean checkPrime(int i) {
		// TODO Auto-generated method stub
		return false;
	}
}
