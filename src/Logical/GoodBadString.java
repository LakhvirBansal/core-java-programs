package Logical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GoodBadString extends A{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		int j;

		for (j = 0; j < noOfTestCases; j++) {

			String inputStr = sc.next();
			List<Integer> list = new ArrayList<Integer>();

			checkVowels(inputStr, list);

			if (list.isEmpty()) {
				System.out.println("Good");
			} else {
				getStringType(list);
			}
		}
		sc.close();
	}

	private static void getStringType(List<Integer> list) {
		List<Integer> tempList = new ArrayList<Integer>(list);
		Collections.reverse(tempList);
		boolean sorted = tempList.equals(list);
		System.out.println(sorted);
	}

	private static void checkVowels(String inputStr, List<Integer> numberList) {

		for (int i = 0; i < inputStr.length(); i++) {
			char ch = inputStr.charAt(i);
			switch (ch) {
			case 'a':
				numberList.add((int) ch);
				break;
			case 'e':
				numberList.add((int) ch);
				break;
			case 'i':
				numberList.add((int) ch);
				break;
			case 'o':
				numberList.add((int) ch);
				break;
			case 'u':
				numberList.add((int) ch);
				break;
			}
		}

	}

}
