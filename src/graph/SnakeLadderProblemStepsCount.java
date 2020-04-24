package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * this problem finds the smallest path to reach to the top
 * for ladder we are using positive values
 * for snakes we are using -ve values
 * 
 * suppose there is a ladder at 2 and it reaches to 15 then jump = 15-2  = 13
 * suppose there is a snake at 17 and it reaches to 4 then jump = 17 - 4  = -13
 */
public class SnakeLadderProblemStepsCount {


		public static void distanceUsingBFS(Graph graph, int src, int dest) {
			//Traverse all the nodes of the graph
	     	Queue<Integer> q =  new LinkedList<Integer>();
	     	boolean visited[] = new boolean[graph.v];
	     	int dist[] = new int[graph.v];
		/*
		 * int parent[] = new int[graph.v];
		 * 
		 * for(int i=0;i<graph.v;i++){ parent[i] = -1; }
		 */

	     	q.add(src);
	     	visited[src] = true;

	     	while(!q.isEmpty()){
	     		int node = q.poll();
	     		//System.out.print(node+" ");

	     		List<Integer> adjencyList = graph.adjListArray[node]; // adjacent edges of a particular vertex
	     		for (Integer neighbour : adjencyList) {
	     			if(visited[dest]) {
	     				break;
	     			}
	     			if(!visited[neighbour]) {
	     				q.add(neighbour); // add neighbours to the queue
	     				visited[neighbour] = true; // marked visited as true
	     				dist[neighbour] = dist[node]  + 1; // increase distance of neighbour by 1
	     				//parent[neighbour] = node; // parent of the neighbour is current node
	     			}
				}
	     	}
	     	System.out.println(" ");
	     	//Print the distances of every node from source

	     	System.out.println("shortest distance is :"+dist[dest]);
	     	System.out.print("shortest path is :");

		/*
		 * int temp = dest; while(temp!=-1){ System.out.print(temp+"-->"); temp =
		 * parent[temp]; }
		 */
			
		}

	static void addEdge(Graph graph, int src, int dest, boolean bidirectional) {
		graph.adjListArray[src].add(dest);

		if(bidirectional) 
			graph.adjListArray[dest].add(src);
	}

	public static void main(String args[]) {
		
		Graph graph = new Graph(37);
		
		int[] board = new int[37];
	    board[2] = 13;
	    board[5] = 2;
	    board[9] = 18;
	    board[18] = 11;
	    board[17] = -13;
	    board[20] = -14;
	    board[24] = -8;
	    board[25] = -10;
	    board[32] = -2;
	    board[34] = -22;

		//Insert edges
		for(int u=0;u<36;u++){
			//Throw a dice from 1 to 6
			for(int dice=1;dice<=6;dice++){
				if(u+dice <= 36) {
					int v = u + dice + board[u+dice];
					addEdge(graph,u,v,false);
				}
				
			}
			/*
			 	List<Integer> adjList = graph.adjListArray[u];
				for (Integer val : adjList) {
					System.out.print(val+"-->");
				}
				System.out.println(" ");
			 */
		
		}
		
		for (int i = 0; i < graph.v; i++) {
			System.out.print(i+"-->");
			
			List<Integer> adjList = graph.adjListArray[i];
			for (Integer val : adjList) {
				System.out.print(val+"-->");
			}
			System.out.println(" ");
		}
		//Shortest path
		
		System.out.println("the shortest path to reach :");
		distanceUsingBFS(graph,0,36);
	}
}
