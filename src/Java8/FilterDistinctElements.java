package Java8;

import java.util.ArrayList;
import java.util.List;

public class FilterDistinctElements {
	private static List names=new ArrayList<>();
	static {
		names.add("Stephen");
		names.add("Regina");
		names.add("Edward");
		names.add("Miguel");
		names.add("George");
		names.add("Brad");
		names.add("Jose");
		names.add("Edward");
		names.add("George");
	}
	public static void main (String args[]) {
		System.out.println("Collection without filtering distinct elements: ");
		//names.stream().forEach(System.out::println);
		System.out.println("Collection filtering distinct elements: ");
		names.stream().distinct().forEach(System.out::println);
	}
}
