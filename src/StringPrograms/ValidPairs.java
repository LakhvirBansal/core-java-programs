package StringPrograms;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

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
			
			/*String numbers = s.nextLine();
			String[] eachNumbers = numbers.split(" ");
			CopyOnWriteArrayList<String> numberList = new CopyOnWriteArrayList<String>(Arrays.asList(eachNumbers));*/
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
