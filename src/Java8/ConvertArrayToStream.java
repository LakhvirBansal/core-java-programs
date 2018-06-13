package Java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConvertArrayToStream {

	public static void main(String[] args) {

		String[] array = { "a", "b", "c", "d", "e" };
		Stream<String> st = Arrays.stream(array);
		st.forEach(s -> System.out.println(s.toUpperCase()));
	}
}
