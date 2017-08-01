package StringPrograms;

import java.util.Scanner;

public class SpellChecker {

	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		boolean pass = true;
		
		String[] chArr = {"a","e","i","o","u","y"};
		for (int i = 0; i < testCases; i++) {
			
			String firstStr = scr.next();
			String secondStr = scr.next();
			
			String firstStrChar = String.valueOf(firstStr.charAt(0));
			String secondStrChar = String.valueOf(secondStr.charAt(0));
			for (String ch : chArr) {
				firstStr.replace(ch,"");
				secondStr.replace(ch, "");
			}
			
		}
	}
}
