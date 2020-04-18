package graph;

import java.util.LinkedList;

public class Graph{
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
