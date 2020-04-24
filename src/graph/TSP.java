package graph;

/**
 * TSP problem is Graph problem where we need to find the shortest path in the hamitolian tour
 * 
 * Hamitolian tour - a tour starts from any city s goes through all the n-1 cities exactly once and return to start city s.
 * 
 * in this problem we need to use bit-masking for 4 vertices we use 4 bits (0000) and all are visited then its value is 1111
 * 
 * 			0000 in starting all the bits are      0000
			DCBA if A is visited then its value is 0001
				 if B is visited then its value is 0011
				 if C is visited then its value is 0111
				 if D is visited then its value is 1111
 * 				
 * 
 * @author Lakhvir Bansal
 *
 */
public class TSP {

	static int[][] dist ={
							{0,20,42,25},
							{20,0,30,34},
							{42,30,0,10},
							{25,34,10,0}
						};
    // 1<<4 = 10000 (1 then 4 times 0) then its decimal value
	static int VISITED_ALL = (1<<4) - 1;
	static int n = 4;

	static void addEdge(Graph graph, int src, int dest, boolean bidirectional) {
		graph.adjListArray[src].add(dest);

		if(bidirectional) 
			graph.adjListArray[dest].add(src);
	}

	static int tsp(int mask,int pos){
		
		if(mask==VISITED_ALL){
			return dist[pos][0];
		}

		//Now from current node, we will try to go to every other node and take the min ans
		int ans = Integer.MAX_VALUE;

		//Visit all the unvisited cities and take the best route
		for(int city=0;city<n;city++){

			if((mask&(1<<city))==0){

				int newAns = dist[pos][city] + tsp( mask|(1<<city), city);
				ans = Math.min(ans, newAns);
			}

		}
		return ans;
	} 
	
	private static int tspTDDP(int mask, int pos) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n*n][n];
		
 		if(mask==VISITED_ALL){
			return dist[pos][0];
		}
 		if(dp[mask][pos] != 0) {
 			return dp[mask][pos];
 		}

		//Now from current node, we will try to go to every other node and take the min ans
		int ans = Integer.MAX_VALUE;

		//Visit all the unvisited cities and take the best route
		for(int city=0;city<n;city++){

			if((mask&(1<<city))==0){

				int newAns = dist[pos][city] + tsp( mask|(1<<city), city);
				ans = Math.min(ans, newAns);
				dp[mask][pos] = ans;
			}

		}
		return dp[mask][pos];
	}
	
	public static void main(String args[]) {
		
		System.out.println(tsp(1,0));
		System.out.println(tspTDDP(1,0));
		int mask = 1;
		
		/*
		 * for (int i = 0; i < 4; i++) { int j = 1<<i; int k = mask&j;
		 * System.out.println(k == 0); }
		 */
		//Shortest path
		//System.out.println("the shortest path to reach :");
		//distanceUsingBFS(graph,0,36);
	}

	
}
