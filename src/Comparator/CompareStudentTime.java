package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CompareStudentTime {

	public static void main(String[] args) {
		ArrayList<Student> ar = new ArrayList<Student>();
		ar.add(new Student("Tom", 10));
		ar.add(new Student("gagan", 15));
		ar.add(new Student("Tom", 10));
		ar.add(new Student("gagan", 15));
		ar.add(new Student("Tom", 10));
		ar.add(new Student("Sumit", 10));
		ar.add(new Student("Sumit", 20));
		ar.add(new Student("lucky", 20));
		ar.add(new Student("lucky", 10));

		Map<String, Integer> nameCount = new HashMap<String, Integer>();
		for (Student student : ar) {
			if (nameCount.containsKey(student.getName())) {
				nameCount.put(student.getName(), nameCount.get(student.getName()) + 1);
			} else {
				nameCount.put(student.getName(), 1);
			}
		}

		Collections.sort(ar, new SortByNameAndTime());

	}
}
