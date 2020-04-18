package dynamicProgramming;

/*
 * this is 1-0 knapsack problem (2D dp)
 * 
 * metrix is like 
 * 
 *  0 0 0 0 0 0 
	0 0 0 0 10 10 
    0 0 4 4 10 10 
    0 0 4 7 10 11 
    
	row - no of items
	col - weights
	each cell contains the maxprofit at particular point
	
	we need to add 0 in starting
 */
public class Knapsack {

	public static void main(String[] args) {
		
		int weights[] = {0,4,2,3};
	    int values[] = {0,10,4,7};

	    int noOFitems= 3;
	    int capacityOfKnapsack = 5;
	    
	    int amount = knapsackDP(weights, values, noOFitems, capacityOfKnapsack);
		System.out.println("amount :"+amount);
	}

	/*
	 * time complexity = O(i*w) = O(NW)
	 * because we iterate 2 loops
	 */
	static int knapsackDP(int weights[],int values[],int noOFitems,int capacityOfKnapsack){
        int dp[][] = new int[noOFitems+1][capacityOfKnapsack+1];

        for(int i=1;i<noOFitems+1;i++){
            for(int w=1;w<capacityOfKnapsack+1;w++){

                int inc = 0;	
                if(weights[i] <= w){
                    inc = values[i] + dp[i-1][w-weights[i]];
                }
                int exc = dp[i-1][w];
                dp[i][w] = Math.max(inc,exc);

           }
        }
        
        for (int i = 0; i < noOFitems+1; i++) {
			for (int j = 0; j < capacityOfKnapsack+1; j++) {
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println("");
		}
        
        return dp[noOFitems][capacityOfKnapsack];
	}

}
