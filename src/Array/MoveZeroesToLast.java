package Array;

import java.util.Arrays;

public class MoveZeroesToLast {

	
	public static void main(String[] args) {
		int[] arr = {1,1,0,0,3,0,12};
		MoveZeroesToLast obj = new MoveZeroesToLast();
		obj.printArr(arr);
		
		System.out.println("after moving the elements");
		obj.moveElements(arr);
		obj.printArr(arr);
	}

	private void moveElements(int[] arr) {
		
		int count = 0;  // Count of non-zero elements 
		  
        // Traverse the array. If element encountered is 
        // non-zero, then replace the element at index 'count' 
        // with this element 
		
        for (int i = 0; i < arr.length; i++) {
        	 if (arr[i] != 0) {
        		 arr[count++] = arr[i]; 
        	 }
                 
        }
           // here count is 
                                       // incremented 
  
        // Now all non-zero elements have been shifted to 
        // front and 'count' is set as index of first 0. 
        // Make all elements 0 from count to end. 
        while (count < arr.length) 
            arr[count++] = 0; 
       
		
	}

	private void swap(int[] arr, int i, int noOfZero) {
		// TODO Auto-generated method stub
		arr[i-noOfZero] = arr[i+1];
		arr[i+1] = 0;
	}

	private void printArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	
}
