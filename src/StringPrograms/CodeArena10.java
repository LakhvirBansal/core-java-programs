package StringPrograms;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class CodeArena10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		String[] strArr = new String[number];
		for (int i = 0; i < number; i++) {

			String name = sc.next();
			Integer no = sc.nextInt();
			strArr[i] = name + "_" + no;

		}
		Map<Integer, Set<String>> markNameMap = new TreeMap<Integer, Set<String>>(Collections.reverseOrder());

		for (int i = 0; i < strArr.length; i++) {
			String name = strArr[i];
			String[] vals = name.split("_");

			Integer num = Integer.parseInt(vals[1]);
			
			if(markNameMap.containsKey(num)) {
				markNameMap.get(num).add(vals[0]);
			} else {
				Set<String> names = new TreeSet<String>();
				names.add(vals[0]);
				markNameMap.put(num, names);
			}
		}

		Set<Integer> keySet = markNameMap.keySet();
		Iterator<Integer> itr = keySet.iterator();

		while (itr.hasNext()) {
			Integer integer = (Integer) itr.next();
			Set<String> names = markNameMap.get(integer);

			for (String string : names) {
				System.out.println(string + " " + integer);
			}
		}
	}

}
