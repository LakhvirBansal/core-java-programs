package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphBFS {

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

		public void bfs(Graph graph, int i) {

			List<Integer> visited = new ArrayList<Integer>();
			visited.add(i);

			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(i);

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
		// create the graph given in above figure
		Graph graph = new Graph(5);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 0);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 3);

		graph.bfs(graph, 2);
	}
}
