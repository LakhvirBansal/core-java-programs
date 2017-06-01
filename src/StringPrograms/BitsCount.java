package StringPrograms;

import java.util.HashMap;
import java.util.Map;

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
