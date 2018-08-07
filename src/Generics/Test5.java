package Generics;

import java.util.ArrayList;

public class Test5 {

	/**
	 * generics concept is only related to compile time,at run time there is no use of generics
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList l = new ArrayList<String>();
		l.add(10);
		l.add(10.5);
		l.add(true);
		System.out.println(l);// [10, 10.5, true]

		ArrayList<String> ar = new ArrayList();
		// ar.add(10); it can take only string data
	}

}
