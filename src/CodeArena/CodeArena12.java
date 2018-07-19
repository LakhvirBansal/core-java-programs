package CodeArena;

import java.util.HashMap;
import java.util.Map;


public class CodeArena12 {

	/*public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberOfTestCases = sc.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int number = sc.nextInt();
			
			String[] strArr = new String[number];
			int count = 0;
			for (int j = 0; j < number; j++) {
				
				String str = sc.next();
				strArr[j] = str;
			}

		}
	}*/

	public static void main(String[] args) {
		//String s = "hello";
		//String s ="zxvczbtxyzvy";
		String s  ="xxyyzz";
		nonRepeatingCharacter(s);
	}
	
	public static void nonRepeatingCharacter(String s) {
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),  map.get(s.charAt(i)) +1);			
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		
		boolean repeat = false;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
            if (map.get(c) == 1) {
            	repeat = true;
                System.out.println(c);
                break;
            }
        }
		
		if(!repeat) {
			System.out.println("-1");
		}
	}
}
