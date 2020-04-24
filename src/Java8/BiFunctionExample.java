package Java8;

import java.util.function.BiFunction;

/*
 * Predicate functionalInterface can take only one input parameters if you want 2 parameters then we need to consider BiPredicate
 */
public class BiFunctionExample {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> bf = (i,j) -> (i+j);
		System.out.println(bf.apply(10, 20));
		System.out.println(bf.apply(100, 200));
	}
}
