package StringPrograms;

public class ArrayReverse {
	public static void main(String[] args) {
		/*int[] arr = {1,2,3,4,5,6,7,8,9};
		
		int count = 0;
		int arrLength = arr.length;
		for (int i = 0; i < arr.length/2; i++) {
			if(arr[i] % 2 == 1){
				continue;
			} else{
				int temp = arr[i];
				arr[i] = arr[arrLength-(count + 1)];
				arr[arrLength-(count + 1)] = temp;
				i--;
				count = count + 1;
			}
			
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}*/
		
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
