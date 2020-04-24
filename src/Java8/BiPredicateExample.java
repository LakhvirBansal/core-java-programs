package Java8;

import java.util.function.BiPredicate;

/*
 * Predicate functionalInterface can take only one input parameters if you want 2 parameters then we need to consider BiPredicate
 */
public class BiPredicateExample {

	public static void main(String[] args) {
		
		BiPredicate<Integer, Integer> bp = (i,j) -> (i+j)%2 == 0;
		
		System.out.println(bp.test(1000,2000));
		System.out.println(bp.test(5,10));
	}
}
