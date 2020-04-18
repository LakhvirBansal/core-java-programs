package dynamicProgramming;

/* 
 * fibonacci series is like 0,1,1,2,3,5,8,13..  (next number is sum of previous 2 numbers)
 * used to get the fibonacci number at particular index
 * f[0] = 0;
 * f[1] = 1;
 *
 */
public class FibonacciSeries {

	public static void main(String[] args) {
		
		int num = getFibNumByRecursion(7);
		System.out.println("using recursion :"+num);
		
		int result = fibBUDP(7);
		System.out.println("using fibBUDP :"+result);
		
		int[] dp = new int[8];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		int resultUsingMemotization = fibTDDP(7, dp);
		System.out.println("using recursion and memoization :"+resultUsingMemotization);
	}

	/*
	 * time complexity is t(n) = O(2n-1) = O(n)
	 */
	// top down dp = recursion + memoization
	private static int fibTDDP(int n, int[] dp) {
		if(n == 0 || n == 1) {
			dp[n] = n;
			return n;
		}
		// already computed
		if(dp[n] != -1) {
			return dp[n];
		} else {
			dp[n] = fibTDDP(n-1, dp) + fibTDDP(n - 2, dp);
			return dp[n];
		}
		
	}

	/**
	 * 
	 * @param i number
	 * @return ith number in fibonacci series
	 * 
	 * time complexity of this problem is t(n) = O(2 power n) because this contains overlapping subproblems.
	 */
	private static int getFibNumByRecursion(int i) {
		if(i == 0 || i == 1) {
			return i;
		}
		return getFibNumByRecursion(i-1) + getFibNumByRecursion(i - 2);
	}
	
	/*
	 * bottom up DP approach
	 * time compexity = O(n)
	 */
	
	private static int fibBUDP(int i) {
		
		int[] dp = new int[i+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for (int j = 2; j <=i; j++) {
			dp[j] = dp[j-1] + dp[j-2];
		}
		
		return dp[i];
	}
	
	
	
	
}
