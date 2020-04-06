package Java;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		s.add("a");
		System.out.println(s.add("a"));
	}
}
