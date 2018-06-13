package StringPrograms;

public class CalculateSum {

	public static void main(String[] args) {
		int[] a = { 10, 5, 1, 0, 1, 1 };

		int minPrice = 6;
		int maxPrice = 8;

		int comboCount = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] > maxPrice) {
				continue;
			}

			int previousCount = a[i];
			for (int j = i + 1; j < a.length; j++) {

				int sumVal = previousCount + a[j];
				if (sumVal >= minPrice && sumVal <= maxPrice) {
					comboCount = comboCount + 1;
					previousCount = sumVal;
				} else {
					break;
				}
			}
		}

		System.out.println(comboCount);
	}
}
