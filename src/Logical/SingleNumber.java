package Logical;

import java.util.Arrays;

public class SingleNumber {

	public static void main(String[] args) {
		int[] a= {1,3,1,-1,3};

		SingleNumber obj = new SingleNumber();
		int singleNumber = obj.singleNumber(a);
		System.out.println("single number is :"+singleNumber);
	}
	
	public int singleNumber(int[] nums) {
		Arrays.parallelSort(nums);
		for (int i = 0; i < nums.length-1; i=i+2) {
				if(nums[i] != nums[i+1]) {
					return nums[i];
				}
			}
		
		return nums[nums.length - 1];
    }
}
