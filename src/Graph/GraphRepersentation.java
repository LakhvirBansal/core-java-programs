package Graph;

import java.util.LinkedList;

public class GraphRepersentation {

	static class Graph {
		int v;
		LinkedList<Integer> adjListArray[];

		Graph(int val) {
			v = val;
			adjListArray = new LinkedList[v];

			for (int i = 0; i < v; i++) {
				adjListArray[i] = new LinkedList<Integer>();
			}
		}
	}

	static void addEdge(Graph graph, int src, int dest) {
		// Add an edge from src to dest.
		graph.adjListArray[src].addFirst(dest);

		// Since graph is undirected, add an edge from dest
		// to src also
		graph.adjListArray[dest].addFirst(src);
	}

	static void printGraph(Graph graph) {
		for (int v = 0; v < graph.v; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : graph.adjListArray[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	public static void main(String args[]) {
		// create the graph given in above figure
		Graph graph = new Graph(5);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);

		// print the adjacency list representation of
		// the above graph
		printGraph(graph);
	}
}
