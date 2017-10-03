package StringPrograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListToSet {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("a");
		list.add("a");
		list.add("a");
		System.out.println(list);
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
	}
}
