package StringPrograms;

import java.util.Arrays;


public class StringChange {
	public static void main(String[] args) {
		//String str = "i am the best";
		//String str = "qwe yhijh op iquhwvd";
		String str = "iuhj mnhvj oiq oi l iwuywhbwgv";
		String[] strArr = str.split(" ");
		int[] lengthArr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			lengthArr[i] = strArr[i].length();
		}
		//[4, 5 , 3,2, 1,10]
		Arrays.sort(lengthArr);//[1,2,3,4,5,10]
		for (int i = 0; i < lengthArr.length/2; i++) {

			int minLength = lengthArr[i];
			int maxLength = lengthArr[lengthArr.length - (i+1)];

			int smallNumberIndex = 0;
			int maxNumberIndex = 0;
			for (int j = 0; j < strArr.length; j++) {
				
				if(strArr[j].length() == minLength){
					smallNumberIndex = j;
				} 
				if(strArr[j].length() == maxLength){
					maxNumberIndex =j;
				}
			}
			
			String temp = strArr[smallNumberIndex];
			strArr[smallNumberIndex] = strArr[maxNumberIndex];
			strArr[maxNumberIndex] = temp;
	
		}
		
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i]+" ");
		}
	}
}



