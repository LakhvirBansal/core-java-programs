package StringPrograms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveCharOnly {

	public static void main(String[] args) {
		String str = "Ab,c,de!$";

		int i = 0;
		int l = str.length() - 1;

		Pattern p = Pattern.compile("[a-zA-Z0-9]");

		while (i < l) {
			Matcher m = p.matcher(args[i]);
			if (m.find()) {

			}
		}

	}
}
