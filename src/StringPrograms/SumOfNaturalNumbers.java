package StringPrograms;

import java.util.Scanner;
/*
 * pass a particular number and get sum of each number upto that number.
 * 
 * Example
 * number = 4
 * o/p 0 1 3 6 10
 */
public class SumOfNaturalNumbers {
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



