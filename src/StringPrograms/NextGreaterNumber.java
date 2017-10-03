package StringPrograms;

import java.util.Arrays;
import java.util.Comparator;

public class NextGreaterNumber {

	public static void main(String[] args) {

		Integer inputNum = 423865;
		Integer[] arr = new Integer[String.valueOf(inputNum).length()];

		int count = 0;
		while (inputNum > 0) {
			int num = inputNum % 10;
			arr[count] = num;
			inputNum = inputNum / 10;
			count++;
		}

		Arrays.sort(arr, new IntegerComparator());

		StringBuilder sb = new StringBuilder();
		for (Integer val : arr) {
			sb.append(val);
		}
		System.out.println(sb.toString());
	}
}

class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
}