package StringPrograms;

import java.util.ArrayList;
import java.util.List;

public class MatchString {

	public static void main(String[] args) {

		String str1 = "my name is lucky";
		String str2 = "one two three";
		String str3 = "on";

		List<String> al = new ArrayList<String>();
		al.add(str1);
		al.add(str2);
		al.add(str3);

		List<String> returnList = new ArrayList<String>();
		for (String str : al) {
			if (str.contains("on")) {
				returnList.add(str);
			}
		}

		System.out.println(returnList);
	}
}
