package Generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardCharacter {

	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(20);
		l.add(10);
		m1(l);
	}

	public <T extends Number & Runnable> void methodOne(T t) {
	}//

	/**
	 * <?> we can pass any type of ArrayList.
	 *  we can’t add anything to the List except null.
	 */
	private static void m1(List<?> l) {
		l.add(null);
		// l.add(30); // not possible
		System.out.println(l);
	}
}
