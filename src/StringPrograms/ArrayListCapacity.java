package StringPrograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListCapacity {

	public static void main(String[] args) {
		Set<String> a = new HashSet<String>();
		a.add("a");
		a.add("a");
		a.add("c");
		
		List<String> l = new ArrayList<String>(a);
		System.out.println(l);
	}
}
