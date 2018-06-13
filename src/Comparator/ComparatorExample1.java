package Comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample1 {

	public static void main(String[] args) {
		TreeSet<Integer> t = new TreeSet<Integer>(new MyComparator());
		t.add(10);
		t.add(0);
		t.add(15);
		t.add(5);
		t.add(20);
		System.out.println(t);
	}
}

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer val1, Integer val2) {
		if (val1 < val2) {
			return 1;
		}
		if (val1 > val2) {
			return -1;
		}
		return 0;
	}

}