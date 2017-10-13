package Test;

public class SortArray {

	public static void main(String[] args) {
		int[] arr = {3,1,2,3,1,2,3,1,2};
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] < arr[i]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}


	}
}
