package StringPrograms;



public class CodeArena11 {

	public static void main(String[] args) {

		int[] arr = { 1, -1, 3, 2, -7, -5, 11, 6 };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] > 0) {
						int temp = arr[j];
						while (j - i > 0) {
							arr[j] = arr[j - 1];
							j--;
						}
						arr[i] = temp;
					}
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
