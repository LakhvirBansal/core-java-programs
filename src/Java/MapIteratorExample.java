package Java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteratorExample {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);

		Iterator<Integer> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			Integer key = itr.next();
			if (key == 1) {
				map.put(key, 4);
				map.put(5, 6);
			}
			System.out.println(key + " " + map.get(key));
		}
	}
}
