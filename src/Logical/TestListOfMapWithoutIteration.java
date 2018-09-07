package Logical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		HashMap obj1 = (HashMap) o1;
		HashMap obj2 = (HashMap) o2;
		return obj1.get("aa").toString().compareTo(obj2.get("aa").toString());
	}


}

public class TestListOfMapWithoutIteration {

	public static void main(String argv[]) {

		List<Map<String, String>> lmap = new ArrayList<Map<String, String>>();

		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("aa", "a1");
		Map<String, String> m2 = new HashMap<String, String>();
		m2.put("aa", "a2");
		Map<String, String> m3 = new HashMap<String, String>();
		m3.put("aa", "a3");
		Map<String, String> m4 = new HashMap<String, String>();
		m4.put("aa", "a4");
		Map<String, String> m5 = new HashMap<String, String>();
		m5.put("aa", "a5");

		lmap.add(m1);
		lmap.add(m2);
		lmap.add(m3);
		lmap.add(m4);
		lmap.add(m5);

		Map<String, String> m6 = new HashMap<String, String>();
		m6.put("aa", "a6");

		MyComparator m = new MyComparator();
		// Collections.sort(lmap, m);

		int index = Collections.binarySearch(lmap, m6, m);
		System.out.println(index);
		// System.out.println(lmap.stream().filter(e -> e.containsValue("a5")).findAny().orElse(null));
	}


}
