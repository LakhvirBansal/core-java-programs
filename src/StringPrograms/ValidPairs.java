package StringPrograms;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
/*
 * this problem is to find valid shoe pairs
 * 
 * Example we need to pass noOfShoes, suppose numberOfShoes is 5
 * 
 * I/P - 1L 1R 2L 2R 3L
 * o/p - 2
 * 
 * I/P - 1L 1R 2L 3L 4L
 * o/p - 1
 */
public class ValidPairs {
	
	 public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
		
		int no_of_test_cases = sc.nextInt();
		
		for (int no = 0; no < no_of_test_cases; no++) {
			
			int sum = 0;
			
			int NoOfShoes = sc.nextInt();
			CopyOnWriteArrayList<String> sizeList = new CopyOnWriteArrayList<String>();
			for (int i = 0; i < NoOfShoes; i++) {
				String shoeNumber = sc.next();
				sizeList.add(shoeNumber);
			}

			for (String number : sizeList) {
				char[] chars = number.toCharArray();
				char val = chars[0];
				char secondCh = chars[1];
				String matchString = "";
				if(secondCh == 'L'){
					matchString = String.valueOf(val) +"R";
				} else{
					matchString = String.valueOf(val) +"L";
				}
				if(sizeList.contains(matchString)){
					sizeList.remove(matchString);
					sum = sum + 1;
				}
				sizeList.remove(number);
			}
			System.out.println("the matching pair is :"+ sum);
		}
  }
}
