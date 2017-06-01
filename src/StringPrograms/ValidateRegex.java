package StringPrograms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRegex {

	public static void main(String[] args) {
		Pattern pattern;
		Matcher matcher;
		final String NAME_PATTERN = "abc[";
		
		pattern = Pattern.compile(NAME_PATTERN);
		matcher = pattern.matcher("bcd");
		System.out.println(matcher.matches());
	}
}
