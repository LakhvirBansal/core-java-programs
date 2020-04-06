package StringPrograms;

public class BinaryToDecimalConversion {

	public static void main(String[] args) {
		int[] arr = {1,1,0,1,0};

		int sum = 0;
		for (int i = arr.length -1, j=0; i >=0; i--, j++) {
			int val = arr[i];
			sum = sum + (int) (val * Math.pow(2, j));
		}
		
		System.out.println("the sum is :"+sum);
	}
}
