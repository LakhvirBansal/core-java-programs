package dynamicProgramming;

/* 
 * find the number of ways to reach to top of the ladder
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
public class LadderProblem {

	public static void main(String[] args) {
		
		int n = 4;
		int k = 3;
		int num = ways(n);
		System.out.println("total ways :"+num);
		int steps = waysBU(n, k);
		System.out.println("total steps by bottomup :"+steps);
		int stepsBUDP = waysBUDP(n,k);
		System.out.println("total steps BUDP:"+stepsBUDP);
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
					// run only if step is more than 0.
					if(step-j >= 0) {
						/*
						 * k = 3
						 * d[step] = d[step-1] +d[step-2] +d[step-3];
						 */
						dp[step] = dp[step] +dp[step-j]; // add previous number j times
					}
				}
			}
			
			for (int i = 0; i < dp.length; i++) {
				System.out.print(dp[i]+" ");
			}
			System.out.println("");
			return dp[n];
		}
	
}
