package Logical;

import java.util.Scanner;

public class AlphabetChoclate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long startMills = System.currentTimeMillis();
		int noOfTestCases = sc.nextInt();
		int j, k, l, m;
		for (j = 0; j < noOfTestCases; j++) {

			String inputStr = sc.next();
			int count = 0;
			int strLength = inputStr.length();
			for (k = 0; k < strLength; k++) {
				for (l = k + 1; l <= strLength; l++) {
					String checkString = inputStr.substring(k, l);

					for (m = 0; m < checkString.length(); ++m) {
						switch (checkString.charAt(m)) {
						case 'a':
						case 'A':
						case 'e':
						case 'E':
						case 'i':
						case 'I':
						case 'o':
						case 'O':
						case 'u':
						case 'U':
							count++;
						}
					}
				}
			}
			System.out.println(count);
		}
		sc.close();
		System.out.println(System.currentTimeMillis() - startMills);
	}

}
