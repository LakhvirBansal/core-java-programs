package Logical;

import java.util.HashSet;
import java.util.Set;

public class EarliestTime {

	public static void main(String[] args) {

		int x = 1;
		Integer[] A = { 1 };
		int data = checkTime(x, A);
		System.out.println(data);

	}

	private static int checkTime(int x, Integer[] a) {

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= x) {
				set.add(a[i]);
			}

			if (set.size() == x) {
				return i;
			}
		}
		return -1;
	}

}
