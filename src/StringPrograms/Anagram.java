package StringPrograms;

import java.util.Scanner;

/*
 * this program is used to check whether a string is anagram or not.
 * 
 * Example - abcd and dcba are the anagram strings
 */
public class Anagram {

	  public static void main(String[] args) {
		  
	      Scanner s = new Scanner(System.in);
	        int numbers = s.nextInt();
	        
	        String[] strArr = new String[numbers];
	        
	        for (int i = 0; i < numbers; i++) {
	        	
	    		String firstString = s.next();
	    		String secondString = s.next();
	    		strArr[i] = firstString+" "+secondString;
	        }
	        
	        for (int i = 0; i < strArr.length; i++) {
	        	
	        	String[] bothWords = strArr[i].split(" ");
				String firstWord = bothWords[0];
				String secondWord = bothWords[1];
				int check = 0;
				
				if(firstWord.length() != secondWord.length()){
					System.out.println("NO");
				} else{
					for (int j = 0; j < firstWord.length(); j++) {
						char ch = firstWord.charAt(j);
						if(secondWord.indexOf(ch) == -1){
							System.out.println("NO");
							check++;
							break;
						} else{
							secondWord = secondWord.replaceFirst(String.valueOf(ch),"");
						}
					}
					if(check == 0){
						System.out.println("YES");
					}
				}
			}
	  	}
}
