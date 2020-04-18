package Logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
URL :- https://www.codechef.com/APRIL20B/problems/COVIDLQ
3
3
1 0 1
7
1 0 0 0 0 0 1
11
0 1 0 0 0 0 0 1 0 0 1

ist line is no of test cases
2nd no of elements in test case

if there is a difference of 6 elements in each 1 then the result is yes otherwise no.
 */
public class CovidPandemic{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_of_test_cases = sc.nextInt();
		
		for (int no = 0; no < no_of_test_cases; no++) {
			
			int numbers = sc.nextInt();
			int[] numberArr = new int[numbers];
			for (int i = 0; i < numbers; i++) {
				int val = sc.nextInt();
				numberArr[i] = val;
			}
			
			
			  if(numbers < 7) { 
				  System.out.println("No"); 
			  } else { 
				  Map<Integer,List<Integer>> numberIndexMap = new HashMap<Integer, List<Integer>>();
			  
				  for (int i = 0; i < numberArr.length; i++) { 
					  if(numberArr[i] == 1) {
						  	if(numberIndexMap.containsKey(1)) {
						  		numberIndexMap.get(1).add(i); 
						  	} else {
						  		List<Integer> indexList = new ArrayList<Integer>();
						  		indexList.add(i);
						  		numberIndexMap.put(1, indexList); 
						  	} 
					  } 
				  }
			  
				  Set<Integer> keySet = numberIndexMap.keySet(); 
				  Iterator<Integer> itr = keySet.iterator(); 
				  boolean result = true; 
				  while (itr.hasNext()) { 
					  Integer key = (Integer) itr.next(); 
					  List<Integer> indexes = numberIndexMap.get(key); 
					  for(int i = 0; i < indexes.size(); i++) { 
						  if(i < indexes.size() - 1) {
							  if((indexes.get(i+1) - indexes.get(i)) < 6) { 
								  result = false; 
							  } 
						  }
					  } 
				  }
				  
				  if(result) { 
					  System.out.println("YES"); 
				  } else {
					  System.out.println("No"); 
				  }
			  }
		}
		
	}
}
