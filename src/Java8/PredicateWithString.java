package Java8;

import java.util.function.Predicate;

public class PredicateWithString {

	public static void main(String[] args) {
		Predicate<String> p = s -> (s.length() > 5);
		System.out.println(p.test("abcedf"));
		System.out.println(p.test("abc"));
	}
}
