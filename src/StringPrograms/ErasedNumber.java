package StringPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class ErasedNumber {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		 Scanner sc = new Scanner(System.in);
		int no_of_test_cases = sc.nextInt();
		
		for (int no = 0; no < no_of_test_cases; no++) {
			
			int numbers = sc.nextInt();
			int[] numberArr = new int[numbers];
			for (int i = 0; i < numbers; i++) {
				int val = sc.nextInt();
				numberArr[i] = val;
			}
			
			Arrays.sort(numberArr);
			int count = 0;
			int val = 0;
			if((numberArr[numbers-1] - numberArr[0]) == (numbers-1)){
				System.out.println(numberArr[numbers-1] + 1);
			} else if(numbers+1 != (numberArr[numbers-1] - numberArr[0]) + 1){
				System.out.println("FOUL");
			}else {
				for (int i = 0; i < numberArr.length; i++) {
					for (int j = (i+1); j < numberArr.length; j++) {
						if(numberArr[j] != (numberArr[i]+1)) {
							count = count + 1;
							val = numberArr[i]+1;
							break;
						} else{
							break;
						}
					}
				}
				
				if(count >= 2){
					System.out.println("FOUL");
				} else{
					System.out.println(val);
				}
			}
		}
		
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
