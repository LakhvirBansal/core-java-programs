package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterOccurance {

	public static void main(String[] args) {
		int[] arr = {1,2,3,2,3,4,2,3,4};
	       Map<Integer, Long> freq = 
	               Arrays.stream(arr)
	               .boxed()
	               .collect(Collectors.groupingBy(n->n,
	                                Collectors.counting()));
	      
	       System.out.println(freq);
	       
	       freq.entrySet()
	               .stream()
	               .sorted(Comparator.comparing(Map.Entry::getValue)).findFirst();
	}
	       
}
