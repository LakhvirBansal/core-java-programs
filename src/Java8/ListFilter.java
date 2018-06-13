package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListFilter {

	public static void main(String[] args) {

		List<String> colors = Arrays.asList("red", "blue", "green", "white");
		List<String> result = getFilterOutput(colors, "white");

		/*for (String color : result) {
			System.out.println(color);
		}*/

		List<String> selectedColors = colors.stream().filter(color -> !"white".equals(color))
				.collect(Collectors.toList());

		/*selectedColors.forEach(color -> {
			System.out.println(color);
		});*/

		boolean allColor = colors.stream().filter(color -> !"white".equals(color)).allMatch(val -> val.contains("e"));
		System.out.println(allColor);
		boolean noneColor = colors.stream().filter(color -> !"white".equals(color)).noneMatch(val -> val.contains("e"));
		System.out.println(noneColor);
		boolean anyColor = colors.stream().filter(color -> !"white".equals(color))
				.anyMatch(val -> val.contains("red"));
		System.out.println(anyColor);

		Optional<String> val = colors.stream().filter(val1 -> "white123".equals(val1)).findAny();

		if (val == null) {
			System.out.println("val is not there");
		}
		System.out.println(val.isPresent());
		if (val.isPresent()) {
			System.out.println(val.get());
		}


	}

	private static List<String> getFilterOutput(List<String> colors, String selectColor) {
		List<String> returnList = new ArrayList<String>();
		for (String color : colors) {
			if (!color.equals(selectColor)) {
				returnList.add(color);
			}
		}

		return returnList;
	}
}
