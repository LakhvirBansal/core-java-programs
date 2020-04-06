package StringPrograms;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExampl {

	public static void main(String[] args) {
		
		Set<Integer> s = new TreeSet<>();
		s.add(1);
		System.out.println(s);
		s.add(null); // treeSet don't allow null values
		System.out.println(s);
	}
}
