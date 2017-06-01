package StringPrograms;

import java.util.Scanner;

public class StringCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		String numStr = String.valueOf(number);
		
		int result = 0;
		int strLength = numStr.length();
		while (strLength > 1) {
			int count = 0;
			for (int i =0; i < strLength; i++) {
				int ch =  Integer.parseInt(String.valueOf(numStr.charAt(i)));
				count = count + ch;
			}
			result = count;
			numStr = String.valueOf(count);
			strLength = numStr.length();
		}
		
		System.out.println( "the result is :"+result);
	}
}
