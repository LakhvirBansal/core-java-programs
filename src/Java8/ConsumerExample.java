package Java8;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		// Consumer functional interface don't return anything, it just takes the argument and process over the
		// argument.
		Consumer<Integer> p = i -> System.out.println(i);
		p.accept(10);
		p.accept(50);
	}
}
