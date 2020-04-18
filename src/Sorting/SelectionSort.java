package Sorting;

/* In selection sort we select the largest element and replace with the last element.
 *  input - 20,35,-15,7,55,1,-22
 *  step 1-> 
		 *  largest = 0;  in starting we assume first element is the largest.
		 *  35 > 20 largest = 1;
		 *  -15 > 35 largest = 1;
		 *  7 > 35 largest = 1;
		 *  55> 35 change largest to index of 55 -> 4
		 *  1> 55 largest = 4
		 *  -22 > 55 largest = 4
		 *  swap last element with largest element  (20,35,-15,7,-22,1,55)
 *  
 * step 2 ->
		 *  largest = 0;
		 *	35 > 20 largest 1;
		 *	-15 > 35 largest 1;
		 *	7 > 35 largest = 1;
		 *  -22 > 35 largest = 1;
		 *  1 > 35 largest = 1;
		 *  swap second last element with largest element (element present at 1st index) (20,1,-15,7,-22,35,55)
 *  
 *  and so on.
 * 
 * complexity - O(n*n)
 * swap count is less as compare to bubble sort.
 */

public class SelectionSort {
	static int num[] = {20, 35, -15, 7, 55, 1, -22};
	public static void main(String[] args) {
		int min;
		/*
		 * int count = 0; int swapCount = 0;
		 */
		for (int lastUnsortedIndex = num.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			int largest = 0;
			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if(num[i] > num[largest]){
					largest = i;
					//swapCount++;// in selection sort swap count is less than swap count in bubble sort.
				}
				//count++;
			}
			swap(largest, lastUnsortedIndex);
			System.out.println(largest);
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i]+" ");
			}
		}
		/*
		 * for (int i = 0; i < num.length; i++) { System.out.println(num[i]); }
		 */
		/*
		 * System.out.println(count);
		 * System.out.println("the swap count is "+swapCount);
		 */
	}
	private static void swap(int j, int min) {
		int temp = num[min];
		num[min] = num[j];
		num[j] = temp;
	}
}
