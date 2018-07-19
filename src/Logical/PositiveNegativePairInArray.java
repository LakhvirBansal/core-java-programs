package Logical;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PositiveNegativePairInArray {

	public static void main(String[] args) {
		int arr[] = { 4, 8, 9, -4, 1, -1, -8, -9 };
		int n = arr.length;
		printPairs(arr, n);
	}

	private static void printPairs(int[] arr, int n) {

		Map<Integer, Integer> numberCountMap = new TreeMap<Integer, Integer>();
		
		for (int i = 0; i < n; i++) {
			int val = Math.abs(arr[i]);
			if (numberCountMap.containsKey(val)) {
				numberCountMap.put(val, numberCountMap.get(val) + 1);
			} else {
				numberCountMap.put(val, 1);
			}
		}

		Set<Integer> keys = numberCountMap.keySet();
		Iterator<Integer> itr = keys.iterator();

		while (itr.hasNext()) {

			Integer key = itr.next();
			Integer val = numberCountMap.get(key);
			if (val >= 2) {
				System.out.println(-(key) + "  " + key);
			}
		}
	}
}
