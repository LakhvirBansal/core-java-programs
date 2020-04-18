package Sorting;

/* In Insertion sort we insert the element at proper place.
 * 
 * Input - {20, 35, -15, 7, 55, 1, -22};
 * sortedList = {20} - we assume first element is sorted
 * 
 * step 1 -> find the exact place for 35
 *  		check (i > 0 and check 20 > 35) false no need of rotating
 *  		sortedList ={20,35}
 *  
 * step 2 -> find the exact place for -15
 * 			i=2 ; 2> 0 num[1] = 35 > -15 we need to rotate
 * 			i=1 ; 1 > 0 num[0] = 20 > -15 we need to rotate
 *			add -15 at 0 index.
 *			array={-15,20,35,7,55,1,-22}
 * 
 * 	and so on.
 * 
 *	complexity - O(n*n)
 */

public class InsertionSort {
	static int num[] = {20, 35, -15, 7, 55, 1, -22};
	public static void main(String[] args) {
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < num.length; firstUnsortedIndex++) {
			
			int newElement = num[firstUnsortedIndex];
			
			int i;
			// iterate from firstUnsortedIndex to 0 index if i-1 value is greater then we need to rotate.
			for (i = firstUnsortedIndex; i> 0 && num[i-1] > newElement; i--) {
				num[i] = num[i-1];
			}
			
			num[i] = newElement;
			
		}
		
		 for (int i = 0; i < num.length; i++) {
			 System.out.println(num[i]);
		}
		 
	}
}
