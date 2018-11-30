package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClearMap {

	public static void main(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("a", "a");
		m.put("b", "b");
		System.out.println(m.size());
		m.remove("b");
		System.out.println(m.size());

		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		Map<List<String>, String> map = new HashMap<List<String>, String>();
	}
}
