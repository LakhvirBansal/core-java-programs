package CodeArena;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeArena3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numbers = sc.nextInt();

		int val = 1;
		for (int i = 0; i < numbers; i++) {
			val = val * sc.nextInt();


		}
		countdivisors(val);
	}

	private static void countdivisors(int n) {

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= n; i++)
        {
			if (n % i == 0)
            {
				set.add(i);
            }
		}

		System.out.println(set.size());
	}

}
