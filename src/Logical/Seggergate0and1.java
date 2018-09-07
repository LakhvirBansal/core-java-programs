package Logical;

public class Seggergate0and1 {

	public static void main(String[] args) {

		int[] array = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };

		segregate0and1(array);

		for (int a : array) {
			System.out.print(a + " ");
		}

	}

	static void segregate0and1(int arr[]) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			if (arr[start] == 1) {
				if (arr[end] == 0) {
					arr[end] = 1;
					arr[start] = 0;
				}
				end--;
			} else {
				start++;
			}
		}

	}
     
}
