package Array;

public class MaximumSubArray {

	
	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubArray obj = new MaximumSubArray();
		int maxNumber =  obj.maxSubArray(arr);
		System.out.println("maximun sum is :"+maxNumber);
		
		int maxNumberUsingKandane = obj.kandaneForMaxSubArrayForNegativ(arr);
		System.out.println("maximun sum using kandane :"+maxNumberUsingKandane);
	}
	
	/*
	 *we will use dynamic programming
		Lets say array be arr[] and maximum sum upto index i is maxSum(i)
		Logic which can be used for dynamic programming:
		maxSum(i) = Max of (maxSum(i-1) + a[i] , a[i])
		So it can be define as
		Max sum at index i is maximum of (max sum upto i-1 + current element , current element)
	 */
	
	public int maxSubArray(int[] nums) {

		 int[] result = new int[nums.length];
		 result[0]=nums[0];
		 
		 for (int i = 1; i < nums.length; i++) {
			 result[i]=Math.max(result[i-1]+nums[i], nums[i]);
		 }
		 int maxSumArray = result[0];
		 	
		 for (int j = 1; j <result.length ; j++) {
			 if(maxSumArray<result[j])
			 maxSumArray = result[j];
		 }
		 
		 return maxSumArray;
    }

	
	 public int kandaneForMaxSubArrayForNegativ(int[] arr) {
		  int maxEndHere = arr[0];
		  int maxSoFar = arr[0];
		  for(int i=1;i<arr.length;i++){
		   maxEndHere = Math.max(arr[i], maxEndHere+arr[i]	);
		   maxSoFar = Math.max(maxSoFar,maxEndHere);
		  }
		  return maxSoFar;
		 }
}
