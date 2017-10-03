package StringPrograms;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueString {

	public static void main(String[] args) {
		String str = "abac";
		Set<String> stringSet = new HashSet<String>();
		String resString = "";
		StringBuilder sb = new StringBuilder("");
		int start = 0;
		int end = 0;

		while (end < str.length()) {
			end = end + 1;
			char ch = str.charAt(end - 1);

			if (!stringSet.contains(String.valueOf(ch))) {
				stringSet.add(String.valueOf(ch));

				if (end - start > resString.length()) {
					resString = "";
					for (int i = start; i < end; i++) {
						sb.append(String.valueOf(str.charAt(i)));
					}
					resString = sb.toString();
					sb = new StringBuilder("");
				}
			} else {
				for (int i = start; i < end - 1; i++) {
					if (str.charAt(i) != ch) {
						stringSet.remove(String.valueOf(str.charAt(i)));
						start = start + 1;
					} else {
						start = start + 1;
						break;
					}

				}
			}
		}
		
		System.out.println(resString);
	}

}
