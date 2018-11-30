package Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RemoveNull {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("gagan", "lucky", null, "sumit", "gagan");

		List<String> result = names.stream().filter(p -> p != null).collect(Collectors.toList());

		System.out.println(result);

		List<String> result1 = names.stream().filter(Objects::nonNull).collect(Collectors.toList());
		System.out.println(result1);

		int occurrences = Collections.frequency(names, "as");
		System.out.println(occurrences);
	}
}
