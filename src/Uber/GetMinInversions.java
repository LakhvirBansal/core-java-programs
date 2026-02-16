package Uber;

import java.util.*;
public class GetMinInversions {

    static class Edge {
        int to, cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }


    static List<List<Edge>> graph;
    static int[] ans;

    public static int getMinInversions(int g_nodes, List<Integer> g_from, List<Integer> g_to) {

        graph = new ArrayList<>();
        for (int i = 0; i <= g_nodes; i++) graph.add(new ArrayList<>());

        // Build graph
        for (int i = 0; i < g_from.size(); i++) {
            int u = g_from.get(i);
            int v = g_to.get(i);

            graph.get(u).add(new Edge(v, 0)); // correct direction
            graph.get(v).add(new Edge(u, 1)); // reverse needed
        }

        ans = new int[g_nodes + 1];

        // Step1: calculate reversals if root = 1
        ans[1] = dfs1(1, -1);

        // Step2: reroot DP
        dfs2(1, -1);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= g_nodes; i++) {
            res = Math.min(res, ans[i]);
        }
        return res;
    }

    // Count reversals for root=1
    static int dfs1(int node, int parent) {
        int total = 0;

        for (Edge e : graph.get(node)) {
            if (e.to == parent) continue;
            total += e.cost + dfs1(e.to, node);
        }
        return total;
    }

    // Rerooting
    static void dfs2(int node, int parent) {
        for (Edge e : graph.get(node)) {
            if (e.to == parent) continue;

            // if edge node->child had cost 0 (correct)
            // making child root requires +1 reversal
            // if cost 1 (reverse edge), then -1
            if (e.cost == 0) {
                ans[e.to] = ans[node] + 1;
            } else {
                ans[e.to] = ans[node] - 1;
            }

            dfs2(e.to, node);
        }
    }

    public static void main(String[] args) {


        int g_nodes = 3;

        List<Integer> g_from = Arrays.asList(2,2);
        List<Integer> g_to = Arrays.asList(1,3);


        int result = GetMinInversions.getMinInversions(g_nodes, g_from, g_to);
        System.out.println(result);
    }
}
