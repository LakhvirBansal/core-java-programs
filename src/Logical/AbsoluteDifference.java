package Logical;

public class AbsoluteDifference {

	public static void main(String[] args) {
		// Integer[] A = { 3, 1, 2, 4, 3 };
		// Integer[] A = { -1000, 1000 };
		long startTime = System.currentTimeMillis();
		Integer[] A = { -10, -5, -3, -4, -5 };
		int netsum = 0;

		int number = A.length % 2 == 0 ? A.length / 2 : (A.length / 2) + 1;
		for (int i = 0; i < number; i++) {
			int nextsum = 0;
			int previousSum = 0;
			for (int j = 0; j < A.length; j++) {
				if (j <= i) {
					previousSum = previousSum + A[j];
				} else {
					nextsum = nextsum + A[j];
				}
			}
			if (i == 0) {
				netsum = Math.abs(nextsum - previousSum);
			} else if (netsum > Math.abs(nextsum - previousSum)) {
				netsum = Math.abs(nextsum - previousSum);
			}
		}

		System.out.println(netsum);
		System.out.println("total time taken :" + (System.currentTimeMillis() - startTime));
	}
}
