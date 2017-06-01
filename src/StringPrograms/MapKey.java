package StringPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapKey {

	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("ba");
		
		map.put("x", list);
		map.put("y", list);
		
		map.remove("x");
		System.out.println(map);
	}
}
