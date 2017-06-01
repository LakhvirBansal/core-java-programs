package StringPrograms;

import java.util.Arrays;

public class StringCharSort {
	public static void main(String[] args) {
		String str = "hello how are you";
		char[] chArr = str.toCharArray();
		Arrays.sort(chArr);
		for (int i = 0; i < chArr.length; i++) {
			System.out.print(chArr[i]);
		}
	}
}
