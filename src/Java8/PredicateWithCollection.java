package Java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class PredicateWithCollection {

	public static void main(String[] args) {
		Predicate<Collection<String>> p = c -> c.isEmpty();

		List<String> l = new ArrayList<String>();
		l.add("dssdd");
		System.out.println(p.test(l));

		List<String> l1 = new ArrayList<String>();
		System.out.println(p.test(l1));
	}
}
