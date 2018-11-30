package Logical;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MultiplesSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int inputNum = sc.nextInt();
		int firstNum = sc.nextInt();
		int secondNum = sc.nextInt();

		sc.close();

		// approach 1 (using simple for loop)
		int multiplesSum = getMultiplesSum(inputNum, firstNum, secondNum);
		System.out.println(multiplesSum);

		// approach 2 (using optimized way)
		multiplesSum = getSum(inputNum, firstNum, secondNum);
		System.out.println(multiplesSum);

		// approach 3 (using set and java8)
		multiplesSum = getSumUsingSet(inputNum, firstNum, secondNum);
		System.out.println(multiplesSum);

	}

	/**
	 * approach 1 (using simple for loop)
	 * 
	 * @param inputNum
	 * @param firstNum
	 * @param secondNum
	 * @return multiplesSum
	 */
	private static int getMultiplesSum(int inputNum, int firstNum, int secondNum) {
		int sum = 0;
		for (int i = 1; i < inputNum; i++) {
			if (i % firstNum == 0 || i % secondNum == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}

	/**
	 * approach 2 (count the number of iteration based on the giver numbers.
	 * 
	 * @param inputNum
	 * @param firstNum
	 * @param secondNum
	 * @return multiples sum
	 */
	private static int getSum(int inputNum, int firstNum, int secondNum) {

		int sum = 0;

		int loopCount = (inputNum % firstNum == 0) ? (inputNum / firstNum) - 1 : inputNum / firstNum;
		for (int i = 1; i <= loopCount; i++) {
			sum = sum + i * firstNum;
		}

		loopCount = (inputNum % secondNum == 0) ? (inputNum / secondNum) - 1 : inputNum / secondNum;
		for (int i = 1; i <= loopCount; i++) {
			if ((i * secondNum) % firstNum != 0) { // if number is already added. (common number added only once)
				sum = sum + i * secondNum;
			}

		}
		return sum;
	}

	/**
	 * approach 3 (add the numbers into set and sum using java8)
	 * 
	 * @param inputNum
	 * @param firstNum
	 * @param secondNum
	 * @return multiples sum
	 */
	private static int getSumUsingSet(int inputNum, int firstNum, int secondNum) {
		Set<Integer> numbers = new HashSet<Integer>();
		int loopCount = (inputNum % firstNum == 0) ? (inputNum / firstNum) - 1 : inputNum / firstNum;
		for (int i = 1; i <= loopCount; i++) {
			numbers.add(i * firstNum);
		}

		loopCount = (inputNum % secondNum == 0) ? (inputNum / secondNum) - 1 : inputNum / secondNum;
		for (int i = 1; i <= loopCount; i++) {
			if ((i * secondNum) % firstNum != 0) {
				numbers.add(i * secondNum);
			}
		}

		return numbers.stream().mapToInt(i -> i).sum();
	}




}

