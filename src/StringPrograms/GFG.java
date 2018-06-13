package StringPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GFG {

	/*
	 * // Returns count of possible paths to reach // cell at row number m and column number n // from the topmost
	 * leftmost cell (cell at 1, 1) static int numberOfPaths(int m, int n) { // If either given row number is first or
	 * // given column number is first if (m == 1 || n == 1) return 1;
	 * 
	 * // If diagonal movements are allowed then // the last addition is required. return numberOfPaths(m - 1, n) +
	 * numberOfPaths(m, n - 1); // + numberOfPaths(m-1,n-1); }
	 * 
	 * public static void main(String args[]) { System.out.println(numberOfPaths(9, 9)); }
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		List<String> list = subStringSequence(str);
		System.out.println(list);
		sc.close();
	}

	public static List<String> subStringSequence(String str) {

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				list.add(str.substring(i, j));
			}
		}

		return list;
	}
}
