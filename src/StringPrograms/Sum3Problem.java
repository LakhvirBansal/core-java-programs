package StringPrograms;

public class Sum3Problem {

	public static void main(String[] args) {
		int[] a = { 4, 3, -1, 2, -2, 10 };

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						System.out.println(a[i] + " " + a[j] + " " + a[k]);
					}
				}
			}
		}
	}
}
