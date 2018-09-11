package Java8;

import java.util.function.Predicate;

public class PredicateJoining {

	public static void main(String[] args) {
		int[] a = { 0, 5, 10, 15, 20, 25, 30 };

		Predicate<Integer> p1 = I -> I > 10;
		Predicate<Integer> p2 = I -> I % 2 == 0;
		System.out.println("numbers greater than 10.");
		m1(p1, a);
		System.out.println("even numbers");
		m1(p2, a);

		System.out.println("numbers less than 10.");
		m1(p1.negate(), a);

		System.out.println("numbers greater than 10 and even numbers ");
		m1(p1.and(p2), a);

		System.out.println("numbers greater than 10 or even numbers ");
		m1(p1.or(p2), a);

	}

	private static void m1(Predicate<Integer> p1, int[] a) {
		for (int i : a) {
			if (p1.test(i)) {
				System.out.println(i);
			}
			;
		}

	}
}
