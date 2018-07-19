package Logical;

import java.util.Arrays;
import java.util.List;

public class CountElementsBwTwoGivenElements {

	public static void main(String[] args) {
		Integer arr[] = { 4, 6, 8, 3, 6, 2, 8, 9, 4 };
		int n = arr.length;
		int num1 = 4, num2 = 4;
		System.out.println(getCount(arr, n, num1, num2));
	}

	private static int getCount(Integer[] arr, int n, int num1, int num2) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(arr);

		int index1 = numbers.indexOf(num1);
		int index2 = numbers.lastIndexOf(num2);

		return (index2 - index1) - 1;
	}
}
