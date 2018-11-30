package Logical;

public class RemoveAdjacentElements {

	public static void main(String[] args) {

		String str = "aabbaabbaabba";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length() - 1; i++) {
			char ch = str.charAt(i);
			while (ch == str.charAt(i + 1)) {
					i = i + 1;
				if (i == str.length() - 1) {
					break;
				}
			}
			sb.append(ch);
		}

		if (str.charAt(str.length() - 2) != str.charAt(str.length() - 1)) {
			sb.append(str.charAt(str.length() - 1));

		}
		System.out.println(sb.toString());
	}
}
