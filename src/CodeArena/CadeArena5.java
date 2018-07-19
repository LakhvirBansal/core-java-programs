package CodeArena;

import java.util.Scanner;

public class CadeArena5 {

	static int a = 10;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numbers = sc.nextInt();

		int[] arr = new int[numbers];
		for (int i = 0; i < numbers; i++) {
			arr[i] = sc.nextInt();
			
			if(i > 0) {
				for (int j = 0; j < i; j++) {
					int val = arr[j];
					if (val > arr[i]) {
						arr[j] = val + 1;
					}
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
