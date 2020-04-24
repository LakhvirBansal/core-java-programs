package Java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckSet {

	public static void main(String[] args) {
		String s = "a";
		String s1 = new String("a");

		Set<String> set = new HashSet<String>();
		set.add(s);
		set.add(s1);

		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(set.size());

		List<String> list = new ArrayList<String>();

		list.add("a");
		list.add("a2");
		list.add("a3");
		list.add("a4");
		methodOne(list);
		list.add("a5");
		System.out.println(list);

	}

	private static void methodOne(List list) {
		list.add(10);
		list.add(20);
		

	}

}
