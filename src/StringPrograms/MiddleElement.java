package StringPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class MiddleElement {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int NoOfTestCases = scr.nextInt();
		
		for (int i = 1; i <= NoOfTestCases; i++) {
			int NoofElements = scr.nextInt();
			int[] firstArr = new int[NoofElements];
			int[] secondArr = new int[NoofElements];
			int[] finalArr = new int[2*NoofElements];
			for (int j = 0; j < NoofElements; j++) {
				int element = scr.nextInt();
				firstArr[j] = element;
				finalArr[j] = element;
			}
			
			for (int j = 0; j < NoofElements; j++) {
				int element = scr.nextInt();
				secondArr[j] = element;
				finalArr[j+NoofElements] = element;
			}
			
			Arrays.sort(finalArr);
			
			int finalArrLength = finalArr.length;
			int sum = finalArr[finalArrLength/2 -1] + finalArr[finalArrLength/2];
			System.out.println(sum);
		}
	}
}
