package Logical;

import java.util.Arrays;

public class PermutationExample {

	public static void main(String[] args) {

		Integer[] A = { 1, 2, 3, 4 };
		int data = permuteData(A);
		if (data == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static int permuteData(Integer[] A) {
		int numbers = A.length;
		Arrays.sort(A);
		int sum = (numbers * (numbers + 1)) / 2;
		for (int i = 0; i < numbers; i++) {
			if (A[i] != i + 1) {
				return 0;
			}
			sum = sum - A[i];
		}

		if (sum == 0) {
			return 1;
		}
		return 0;
	}
}
