package Logical;

public class Main {

	int j;

	void display() {
		System.err.println(j);
	}
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);

		}
	}

	private static void swap(Integer i, Integer j) {
		// TODO Auto-generated method stub
		Integer temp = new Integer(i);

		i = j;
		j = temp;
	}
}
