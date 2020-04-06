package Array;

public class RotateArray {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(a, 3);
	}

	private static void rotate(int[] a, int i) {
		int arrLength = a.length;
		int[] b = new int[arrLength];

		for (int j = 0; j < a.length; j++) {

			if (i > arrLength) {
				i = i % arrLength;
			}

			if (j + i < arrLength) {
				b[j + i] = a[j];
			} else {
				b[j + i - arrLength] = a[j];
			}

			/*
			 * if (j - i < 0) { b[j - i + arrLength] = a[j]; } else { b[j - i] = a[j]; }
			 */
		}

		for (int j = 0; j < b.length; j++) {
			System.out.print(b[j]);
		}

	}
}
