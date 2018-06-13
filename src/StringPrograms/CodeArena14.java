package StringPrograms;

import java.util.Scanner;

public class CodeArena14 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		for (int i = 0; i < number; i++) {

			String val = sc.next();

			int result = SubString(val, val.length());

			System.out.println(result);

		}
	}

	public static int SubString(String str, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				String subString = str.substring(i, i + j);
				int subStringLength = subString.length();
				if (subStringLength == 1) {
					count = count + 1;
				} else {
					String reverseString = new StringBuilder(subString).reverse().toString();
					if (subString.equals(reverseString)) {
						count = (int) (count + Math.pow(subStringLength, 2));
					}
				}
			}
		}

		return count;
	}

}
