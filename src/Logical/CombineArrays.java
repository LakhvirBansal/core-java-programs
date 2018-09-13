package Logical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CombineArrays {

	public static void main(String[] args) {
		Integer[] a1 = { 1, 2, 3, 4, 5, 1, 4, 5 };
		Integer[] a2 = { 1, 3, 3, 32, 3, 3, 3, 3, 3 };

		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(a1));
		Iterator<Integer> itr = l1.iterator();
		while (itr.hasNext()) {
			Integer i = itr.next();
			if (i == 1) {
				itr.remove();
			}
		}
		l1.addAll(Arrays.asList(a2));
		System.out.println(l1);
	}
}
