package Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GetDuplicate {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");

		Set<String> result = list.stream().filter(l -> Collections.frequency(list, l) > 1).collect(Collectors.toSet());

		System.out.println(result);

		List<String> linkedList = new LinkedList<String>();
		linkedList.add("a");
		linkedList.add("b");
		linkedList.add("c");
		linkedList.add("d");
		linkedList.add("e");
		linkedList.add("f");
		linkedList.add("g");
		linkedList.add("h");
		linkedList.add("i");
		linkedList.add("j");

		System.out.println(linkedList.get(8));

	}

}
