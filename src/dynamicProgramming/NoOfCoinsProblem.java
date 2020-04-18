package dynamicProgramming;

/* 
 * fibonacci series is like 0,1,1,2,3,5,8,13..  (next number is sum of previous 2 numbers)
 * used to get the fibonacci number at particular index
 * f[0] = 0;
 * f[1] = 1;
 * 
 * n = ladder size
 * k = maximun number of jumps
 * if k = 3 then f(n) = f(n-1) + f(n-2) + f(n-3)
 * 
 *  1111
 *  121
 *  112
 *  211
 *  13
 *  31
 *  22
 *  
 *  o/p - 7 ways
 *
 */
public class NoOfCoinsProblem {

	public static void main(String[] args) {
		
		int[] us_coins = {1,7,10};
		int n = 3;
		int amount = 15;
		int minCoins = coinsNeeded(us_coins, amount, n);
		System.out.println("minimun number of coins :"+minCoins);
	}

	private static int coinsNeeded(int[] coins, int amount, int n) {
		// TODO Auto-generated method stub
		if(amount == 0)
			return 0;
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if(amount-coins[i] >= 0) {
				int smallerAns = coinsNeeded(coins, amount-coins[i], n);
				if(smallerAns != Integer.MAX_VALUE) {
					ans = Math.min(ans, smallerAns + 1);
				}
			}
		}
		
		return ans;
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
		if(dp[n-1] != -1) {
			return dp[n-1];
		} else {
			dp[n-1] = fibTDDP(n-1, dp) + fibTDDP(n - 2, dp);
			return dp[n-1];
		}
		
	}

	/**
	 * 
	 * @param i number
	 * @return ith number in fibonacci series
	 * 
	 * time complexity of this problem is t(n) = O(3 ki power n) because this contains overlapping subproblems.
	 */
	private static int ways(int n) {
		if(n == 0) {
			return 1;
		}
		if(n < 0) {
			return 0;
		}
		int ans = ways(n-1) + ways(n-2) + ways(n-3);
		return ans;
	}
	
	//bottom-up approach
	private static int waysBU(int n, int k) {
		
		if(n == 0) {
			return 1;
		}
		if(n < 0) {
			return 0;
		}
		
		int ans = 0;
		for (int j = 1; j <=k; j++) {
			ans = ans + waysBU(n-j, k);
		}
		
		return ans;
	}
	
	
	//bottom-up DP approach
	/*
	 * time complexity = O(nk)
	 */
		private static int waysBUDP(int n, int k) {
			
			int[] dp = new int[n+1];
			dp[0] = 1;
			for (int step = 1; step < n+1; step++) {
				dp[step] = 0;
				for (int j = 1; j <=k; j++) {
					if(step-j >= 0) {
						
						dp[step] = dp[step] +dp[step-j];
					}
				}
			}
			
			return dp[n];
		}
	
}
