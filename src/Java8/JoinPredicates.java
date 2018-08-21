package Java8;

import java.util.function.Predicate;

public class JoinPredicates {

	public static void main(String[] args) {
		int[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		Predicate<Integer> p1 = i -> (i > 5);
		Predicate<Integer> p2 = i -> (i % 2 == 0);

		System.out.println("the numbers greater than 5 ");
		m1(x, p1);

		System.out.println("the even numbers ");
		m1(x, p2);

		System.out.println("the even numbers greater than 5");
		m1(x, p1.and(p2));

		System.out.println("the even numbers or numbers greater than 5");
		m1(x, p1.or(p2));

		System.out.println("the numbers not greater than 5");
		m1(x, p1.negate());
	}

	private static void m1(int[] x, Predicate<Integer> p1) {
		for (int i : x) {
			if (p1.test(i)) {
				System.out.println(i);
			}
		}

	}
}
