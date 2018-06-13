package Comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample2 {

	public static void main(String[] args) {
		TreeSet<String> t = new TreeSet<String>(new MyComparator2());
		t.add("Roja");
		t.add("ShobaRani");
		t.add("RajaKumari");
		t.add("GangaBhavani");
		t.add("Ramulamma");
		System.out.println(t);

	}
}

class MyComparator2 implements Comparator<String> {

	@Override
	public int compare(String val1, String val2) {
		return -val1.compareTo(val2);
	}

}