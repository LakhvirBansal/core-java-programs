package Java8;

import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {

		// supplier functional interface dont take any input arguments, it just return the data.
		Supplier<Integer> s = () -> {
			return 10;
		};
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());

	}
}
