package CodeArena;

import java.util.Scanner;

public class CopyOfCadeArena4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numbers = sc.nextInt();


		for (int i = 0; i < numbers; i++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			int n = sc.nextInt();

			int[] arr = new int[n];
			int output = 0;
			int count = 0;

			while (count < n) {
				if (count < x) {
					arr[count] = y;
				} else {
					arr[count] = arr[count - 1] + arr[count - 2] + arr[count - 3];
				}
				count++;
			}
			output = arr[n - 1];
			System.out.println(output);
		}


	}
}
