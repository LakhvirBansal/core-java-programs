package Test;

import java.util.HashSet;
import java.util.Set;

public class TestPerson {

	public static void main(String[] args) {

		Person p1 = new Person("Lucky", 10l);
		Person p2 = new Person("Lucky", 10l);

		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		Set<Person> persons = new HashSet<Person>();
		persons.add(p2);
		persons.add(p1);

		System.out.println(persons.size());
		System.out.println(persons);
	}
}
