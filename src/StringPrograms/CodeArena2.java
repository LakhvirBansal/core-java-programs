package StringPrograms;

import java.util.HashSet;
import java.util.Scanner;

public class CodeArena2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numbers = sc.nextInt();

		for (int i = 0; i < numbers; i++) {
			int noOfElements = 0;
			int distinctVal = 0;
			for (int j = 0; j <= 0; j++) {
				noOfElements = sc.nextInt();
				distinctVal = sc.nextInt();
			}

			int[] arr = new int[noOfElements];
			for (int j = 0; j < noOfElements; j++) {
				arr[j] = sc.nextInt();
			}

			checkDistinctVal(arr, distinctVal);
		}

	}

	private static void checkDistinctVal(int[] arr, int distinctVal) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i=0; i<arr.length; i++)
        {
            if (!set.contains(arr[i]))
            {
                set.add(arr[i]);
            }
		}
		
		if (set.size() == distinctVal) {
			System.out.println("Good");
		} else if (set.size() > distinctVal) {
			System.out.println("Average");
		} else {
			System.out.println("Bad");
		}
	}
}
