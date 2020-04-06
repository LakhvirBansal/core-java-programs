package StringPrograms;

import java.util.Scanner;

public class NumbersLogic {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i <= number; i++) {
			int sum = 0;
			for(int j = 0; j <= i ;j++){
				sum = sum +j;
			}
			output.append(sum+" ");
		}
		
		System.out.println("the value is :"+output.toString());
	}
}



