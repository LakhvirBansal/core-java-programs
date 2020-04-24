package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {

	public static void bfs(Graph graph, int i) {

		List<Integer> visited = new ArrayList<Integer>();

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);

		while(! queue.isEmpty()) {
			int val = queue.poll();
			if(!visited.contains(val)) {
				System.out.print(val+ " ");
				queue.addAll(graph.adjListArray[val]);
				visited.add(val);
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

	public static void main(String args[]) {
		// create the graph given in above figure
		Graph graph = new Graph(5);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 1);
		addEdge(graph, 1, 4);

		bfs(graph, 2);
	}
}
