package StringPrograms;

import java.util.Scanner;

public class CadeArena1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numbers = sc.nextInt();

		int previousNumber = 0;
		int curNum = 0;
		boolean returnVal = false;
		for (int i = 0; i < numbers; i++) {
			if (i > 0) {
				previousNumber = curNum;
			}
			curNum = sc.nextInt();

			if (i == 0) {
				previousNumber = curNum;
			}
			if (previousNumber != curNum) {
				returnVal = true;
			}
		}

		if (returnVal) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
}
