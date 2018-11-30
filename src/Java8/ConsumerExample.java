package Java8;

import java.util.Date;

public class ConsumerExample {

	public static void main(String[] args) {
		// Consumer functional interface don't return anything, it just takes the argument and process over the
		// argument.
		/*Consumer<Integer> p = i -> System.out.println(i);
		p.accept(10);
		p.accept(50);*/
		
		Date d = new Date("2018-10-25 13:58:16");
		System.out.println(((java.sql.Timestamp) d).getTime());
	}
}
