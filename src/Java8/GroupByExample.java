package Java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByExample {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("banana",
                "apple", "orange", "banana", "papaya");
		Map<String, Long> fruitCount = fruits.stream().collect(
				Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

		Map<String, Long> finalMap = new LinkedHashMap<>();
	/*	fruitCount.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed())
				.forEachOrdered(p -> finalMap.put(p.getKey(), p.getValue()));*/

		
		fruitCount.keySet().stream().sorted().forEach(p -> finalMap.put(p, fruitCount.get(p)));
		System.out.println(finalMap);

		

	}
}
