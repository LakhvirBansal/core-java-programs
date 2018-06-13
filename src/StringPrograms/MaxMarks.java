package StringPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MaxMarks {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 1, 3, 1 };

		Map<Integer, List<Integer>> indexNumberMap = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			if (indexNumberMap.containsKey(arr[i])) {
				indexNumberMap.get(arr[i]).add(i);
			} else {
				List<Integer> indexes = new ArrayList<Integer>();
				indexes.add(i);
				indexNumberMap.put(arr[i], indexes);
			}
		}

		Set<Integer> keySet = indexNumberMap.keySet();
		Iterator<Integer> itr = keySet.iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			List<Integer> values = indexNumberMap.get(key);
			for (Integer integer : values) {
				System.out.println(key + " " + integer);
			}
		}
	}
}
