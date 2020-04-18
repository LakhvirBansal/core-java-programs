package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * we will get the shortest path in undirected graph by using BFS.
 */
public class ShortestpathInUndirectedGraph {


		public static void distanceUsingBFS(Graph graph, int src, int dest) {
			//Traverse all the nodes of the graph
	     	Queue<Integer> q =  new LinkedList<Integer>();
	     	boolean visited[] = new boolean[graph.v];
	     	int dist[] = new int[graph.v];
	     	int parent[] = new int[graph.v];

	     	for(int i=0;i<graph.v;i++){
	     		parent[i] = -1;
	     	}

	     	q.add(src);
	     	visited[src] = true;

	     	while(!q.isEmpty()){
	     		int node = q.poll();
	     		System.out.print(node+" ");

	     		List<Integer> adjencyList = graph.adjListArray[node]; // adjacent edges of a particular vertex
	     		for (Integer neighbour : adjencyList) {
	     			if(!visited[neighbour]) {
	     				q.add(neighbour); // add neighbours to the queue
	     				visited[neighbour] = true; // marked visited as true
	     				dist[neighbour] = dist[node]  + 1; // increase distance of neighbour by 1
	     				parent[neighbour] = node; // parent of the neighbour is current node
	     			}
				}
	     	}
	     	System.out.println(" ");
	     	//Print the distances of every node from source

	     	System.out.println("shortest distance is :"+dist[dest]);
	     	System.out.print("shortest path is :");

	     	int temp = dest;
	     	while(temp!=-1){
	     		System.out.print(temp+"-->");
	     		temp = parent[temp];
	     	}
			
		}

	static void addEdge(Graph graph, int src, int dest) {
		// Add an edge from src to dest.
		graph.adjListArray[src].addFirst(dest);

		// Since graph is undirected, add an edge from dest
		// to src also
		graph.adjListArray[dest].addFirst(src);
	}

	public static void main(String args[]) {
		
		Graph graph = new Graph(6);
		
		addEdge(graph, 0,1);
		addEdge(graph, 1,2);
		addEdge(graph, 0,4);
		addEdge(graph, 2,4);
		addEdge(graph, 3,2);
		addEdge(graph, 2,3);
		addEdge(graph, 3,5);
		addEdge(graph, 3,4);
		
		/*
		 * this method is used to find the shortest distance between 0th vertex to 5th vertex.
		 */
		distanceUsingBFS(graph, 0, 5);
	}
}
