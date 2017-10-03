package StringPrograms;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetByComparator {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>(new MyComparator());
		ts.add (10);
		ts.add (0);
		ts.add (15);
		ts.add (5);
		ts.add (20);
		System.out.println (ts);	

	}

}

class MyComparator implements Comparator {	
	
	public int compare(Object obj1, Object obj2) {	
		Integer i1 = (Integer) obj1;
		Integer i2 = (Integer) obj2;
		if ( i1 < i2 )
			return +1;
		else if ( i1 > i2 )
			return -100;
		else return 0;
	}
}

