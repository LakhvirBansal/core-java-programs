package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {

		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("bb");
		l.add("ccc");
		l.add("dddd");
		l.add("eeeee");
		l.add("ffffff");
		l.add("ggggggg");
		l.add("hhhhhhhh");

		List<String> l1 = l.stream().filter(s -> s.length() > 5).collect(Collectors.toList());
		System.out.println(l1);
		List<String> l2 = l.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(l2);

		long count = l.stream().filter(s -> s.length() > 5).count();
		System.out.println(count);

	}
}
