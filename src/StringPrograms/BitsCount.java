package StringPrograms;

import java.util.HashMap;
import java.util.Map;
/*
 * this product is used to change a decimal number into binary number and count the number of 0 and 1 in the binary number
 * 
 * Example :- 
 * I/p - 122, Binaryform - 1111010
 * o/p - 0-2 and 1-5
 */
public class BitsCount {

	public static void main(String[] args) {
		int num = 122;
		StringBuilder sb = new StringBuilder();
		
		while(num > 0){
			sb.append((num % 2)+"");
			num = num/2;
		}
		
		String binaryString = sb.reverse().toString();
		System.out.println(sb);
		int binaryStringLength = binaryString.length();
		Map<Character,Integer> countMap = new HashMap<Character, Integer>();
		
		for (int i=0; i< binaryStringLength; i++) {
			Character ch = binaryString.charAt(i);
			if(countMap.containsKey(ch)){
				countMap.put(ch,countMap.get(ch)+1);
			} else{
				countMap.put(ch, 1);
			}
		}
		
		System.out.println(countMap);
	}
}
