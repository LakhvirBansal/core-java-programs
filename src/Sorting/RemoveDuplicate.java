package Sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicate {

	public static void main(String[] args) {

		Integer[] a = { 1, 2, 3, 3, 4, 5 };

		List<Integer> list = Arrays.asList(a);
		Set<Integer> set = new TreeSet<Integer>(list);

		System.out.println(set);
	}
}
