package Logical;

public class ArrayProblem {

	public static void main(String[] args) {

		int[][] a = new int[5][5];
		int[] arr1 = { 2, 0, 2, 0 };
		int[] arr2 = { 0, 1, 1, 3 };
		int num = arr1.length / 2;

		for (int k = 0; k < arr2.length; k++) {
			a[arr1[k]][arr2[k]] = 1;
		}

		int finalCount = 0;
		int rowcount = 0;
		int columnCount = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (a[i][j] == 1) {
					rowcount++;
				}
				if (a[j][i] == 1) {
					columnCount++;
				}
			}
			if (num == rowcount) {
				finalCount++;
			}
			if (num == columnCount) {
				finalCount++;
			}
		}

		System.out.println(finalCount);
	}
}
