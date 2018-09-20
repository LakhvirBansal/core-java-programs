package Logical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OddOccurance {

	public static void main(String[] args) {
		Integer[] a = { 9, 7, 7, 9, 4, 3, 5, 9, 9 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(a));

		// using java8
		Integer i = list.stream().filter(l1 -> Collections.frequency(list, l1) % 2 == 1).findFirst().orElse(null);
		System.out.println(i);

		// using java7
		for (Integer integer : list) {
			int count = Collections.frequency(list, integer);
			if (count % 2 == 1) {
				System.out.println(integer);
				break;
			}
		}

	}
}
