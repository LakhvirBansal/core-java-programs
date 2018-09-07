package Logical;


public class FindGap {

	public static void main(String[] args) {
		String str = "1000001000000";// 10000010001

		String[] splitArr = str.split("1");

		int indexArr[] = new int[splitArr.length];
		int index = str.indexOf("1");
		int count = 0;
		while (index >= 0) {
			indexArr[count] = index;
			count++;
			index = str.indexOf("1", index + 1);
		}

		int biggestGap = 0;
		int previousIndex = 0;
		for (int i : indexArr) {
			if (i - previousIndex > biggestGap) {
				biggestGap = i - previousIndex;
			}
			previousIndex = i;
		}

		if (biggestGap == 0) {
			System.out.println(biggestGap);
		} else {

			System.out.println(biggestGap - 1);
		}
	}
}
