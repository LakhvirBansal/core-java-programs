package Logical;

import java.util.Scanner;

public class PositiveDiffenenceIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int noOfTest = sc.nextInt();
		int i, k, j;
		for (j = 0; j < noOfTest; j++) {

			int numbers = sc.nextInt();

			int[] arr = new int[numbers];

			for (i = 0; i < numbers; i++) {
				arr[i] = sc.nextInt();
			}
			int finalCount = 0;
			int arrlength = arr.length;

			for (i = 0; i < arrlength; i++) {
				for (k = arrlength - 1; k > i; k--) {
					if (arr[i] < arr[k]) {
						if (finalCount < (k + 1) - i) {
							finalCount = (k + 1) - i;
						}
						break;
					}
				}
			}
			System.out.println(finalCount);
		}
		sc.close();
	}

}
