package Logical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XOROperation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int noOfTest = sc.nextInt();
		long i, k, j;
		for (i = 0; i < noOfTest; i++) {

			j = sc.nextLong();
			k = sc.nextLong();

			List<Integer> numList = new ArrayList<Integer>();
			for (int z = 0;; z++) {
				if (j < Math.pow(2, z) && k > Math.pow(2, z)) {
					numList.add((int) Math.pow(2, z));
				}
				if (Math.pow(2, z) > k) {
					break;
				}
			}

			Object[] intArray = (Object[]) numList.toArray();
			int n = intArray.length;

			System.out.println(pairORSum(intArray, n));

		}
		sc.close();
	}

	static int pairORSum(Object[] intArray, int n) {
		int ans = 0;

		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				ans += (int) intArray[i] ^ (int) intArray[j];

		return ans;
	}

}
