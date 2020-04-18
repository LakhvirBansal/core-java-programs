package Sorting;

/*
 *  input - 20,35,-15,7,55,1,-22
 *  step 1 ->	 compare 20 and 35, 20 > 35 increment i by 1 
 *  		 	 compare 35 with -15, 35 > -15 true swap the elements
 *  		 	 compare 35 with 7, 35> 7 true swap the elements
 *  			compare 35 with 55, 35>55 false increment i by 1
 *  			compare 55 with 1, 55>1 true swap the element and increment i by 1
 * 				compare 55 with -22, 55>-22 true swap the element and increment i by 1 	 
 * 
 * 				20,-15,7,35,1,-22,55 (now 55 is sorted and it is last element)
 * 
 * step 2-> compare 20 with -15 20> -15 true, swap the elements
 * 			comapre 20 with 7 true, swap the elements
 * 			compare 20 with 35 false incremet by 1 
 * 			compare 35 with 1 true swap the elements
 * 			comapre 35 with -22 true swap the elements
 * 
 * 			-15,7,20,1,-22,35,55
 * 
 * step 3 -> compare -15 with 7 false
 * 			compare 7 with 20 false
 * 			commpare 20 with 1 swap
 *          compare 20 with -22 swap
 *          
 *          -15 7 1 -22 20 35 55
 *          
 *          and so on.
 * 
 * complexity - O(n*n)
 */
public class BubbleSort {
	
	static int num[] = {20, 35, -15, 7, 55, 1, -22};
	
	public static void main(String[] args) {
		
		int unsortedPartitionIndex = num.length - 1;
	//	int count=0,swapcount = 0;
		
		for( int out=unsortedPartitionIndex; out>0; out--){
			for(int i=0; i<out; i++){
				if( num[i] > num[i+1] ){
					swap(i, i+1);
					//swapcount++;
				}
				//count++;
			}
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println(" ");
		}
		
		
		//System.out.println(count);
		//System.out.println("the swap count is "+swapcount);
		}
	
	private static void swap(int one, int two){
		int temp = num[one];
		num[one] = num[two];
		num[two] = temp;
	}
	
}
