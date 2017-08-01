package StringPrograms;

import java.util.Scanner;

public class CountSetBits {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int no_of_test_cases = sc.nextInt();
		
		for (int no = 0; no < no_of_test_cases; no++) {
			int decimalNumber = sc.nextInt();
			int count = 0;
			
			while(decimalNumber > 1){
				int val = decimalNumber%2;
				if(val == 1){
					count++;
				}
				decimalNumber = decimalNumber / 2;
			}
			count++;
			System.out.println(count);
		}
	}
}
