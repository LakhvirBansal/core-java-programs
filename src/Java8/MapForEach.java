package Java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapForEach {

	public static void main(String[] args) {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		
		items.forEach((k, v) -> {
			System.out.println("key : " + k + " val : " + v);
		});

		List<String> list = new ArrayList<>();
		list.add("Adsbdsm");
		list.add("Bsdds");
		list.add("Cbbbdsd");
		list.add("D");
		list.add("E");

		list.stream().filter(s -> s.contains("b")).forEach(val -> {
			System.out.println(val);
		});
		/*list.forEach(val -> {
			System.out.println("list val is " + val);
		});*/
	}
}
