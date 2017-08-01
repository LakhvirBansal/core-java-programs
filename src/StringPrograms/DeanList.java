package StringPrograms;

import java.util.Scanner;

public class DeanList {
	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		boolean pass = true;
		
		for (int i = 0; i < testCases; i++) {
			
			int students = scr.nextInt();
			
			int[] academics = new int[students];
			int[] sports = new int[students];
			int[] communication = new int[students];
			
			
			for (int sub = 0; sub < 3; sub++) {
				for (int j = 0; j < students; j++) {
					int val = scr.nextInt();
					if(sub == 0){
						academics[j] = val;
						if(j == 0 && val < 30){
							pass = false;
						}
					}
					if(sub == 1){
						sports[j] = val;
						if(j == 0 && val < 30){
							pass = false;
						}
					}
					if(sub == 2){
						communication[j] = val;
						if(j == 0 && val < 30){
							pass = false;
						}
					}
				}
			}
			
			int[] resultArr = new int[students];
			int count = 0;
			for (int j = 0; j < students; j++) {
				resultArr[j] = academics[j] + sports[j] + communication[j];
			}
			
			for (int j = 1; j < resultArr.length; j++) {
				if(resultArr[0] > resultArr[j]){
					count++;
				} else if (resultArr[0] == resultArr[j]) {
					if(academics[0] > academics[j] ){
						count++;
					} else if(academics[0] == academics[j] ){
						if(sports[0] > sports[j]){
							count++;
						}
					}
				}
			}
			if(!pass){
				System.out.println("NO");
			} else{
				if(students - count <= 3 ){
					System.out.println("YES");
				} else{
					System.out.println("NO");
				}
			}

		
		}
	}
}
