package Generics;

import java.util.HashSet;
import java.util.Set;

class Student {

	int rollNo;

	String name;

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
}

public class Test2 {

	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();

		Set<Student> stdSet = new HashSet<Student>();

		stdSet.add(s1);
		stdSet.add(s2);
		stdSet.add(s3);

		System.out.println(stdSet.size());
	}

}
