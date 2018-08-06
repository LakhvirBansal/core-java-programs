package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxMarks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numbers = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[numbers];
		sc.delimiter();
		for (int i = 0; i < numbers; i++) {
			arr[i] = sc.nextLine();
		}
		
		Map<Integer, Map<String, Integer>> countNameMap = new HashMap<Integer, Map<String, Integer>>();
		Map<String, Integer> nameTimeMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			String[] nameTime = arr[i].split(" ");
			if(nameTimeMap.containsKey(nameTime[0])){
				nameTimeMap.put(nameTime[0], nameTimeMap.get(nameTime[0]) + Integer.parseInt(nameTime[1]));
			} else {
				
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
