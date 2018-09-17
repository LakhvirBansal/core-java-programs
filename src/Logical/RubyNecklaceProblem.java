package Logical;

import java.util.Scanner;

public class RubyNecklaceProblem {

	/*
	 * A blue ruby should be followed by either a blue ruby or a red ruby
	 * 
	 * A green ruby should be followed by either a green ruby or a yellow ruby
	 * 
	 * A red ruby should be followed by either a green ruby or a yellow ruby
	 * 
	 * A yellow ruby should be followed by either a blue ruby or a red ruby
	 * 
	 * If it is possible, we should always start a necklace with a blue or a red ruby
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		int r = sc.nextInt();
		int y = sc.nextInt();
		int g = sc.nextInt();

		int necklaceLength = 0;
		if (b > 0) {
			necklaceLength++;
			b--;
			if (b > 1 && r > 0 && y > 0) {
				necklaceLength++;
				r--;
			}
		}
		while (b > 0) {
			necklaceLength++;
			b--;

			while (r > 0) {
				necklaceLength++;
				r--;

				while (g > 0) {
					necklaceLength++;
					g--;
					if (y > 0) {
						necklaceLength++;
						y--;
					}
				}
			}
		}

		System.out.println(necklaceLength);
		sc.close();
	}




}
