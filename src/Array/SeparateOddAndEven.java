package Array;

public class SeparateOddAndEven {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		  int[] b = new int[a.length];

		  int count = 0;
		  int countLength = b.length-1;
		  
		  for (int j = 0; j < a.length; j++) {

		   if (a[j] % 2 != 0) {
		    b[count] = a[j];
		    count = count + 1;
		   }else{
		    b[countLength] = a[j];
		    countLength = countLength - 1;
		   }
		  }
		 
		  for (int item : b) {
		   System.out.print(item + " ");
		  }
	}
}
