package Uber;

import java.util.*;
public class PalindromePaths {

    static List<List<Integer>> graph;
    static int[] parent;
    static int[] depth;
    static int[] prefixMask;
    static char[] values;

    public static List<Integer> palindromePaths(int tree_nodes,
                                                List<Integer> tree_from,
                                                List<Integer> tree_to,
                                                List<Character> arr,
                                                List<Integer> queries) {

        // Build graph
        graph = new ArrayList<>();
        for (int i = 0; i < tree_nodes; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < tree_from.size(); i++) {
            int u = tree_from.get(i);
            int v = tree_to.get(i);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        parent = new int[tree_nodes];
        depth = new int[tree_nodes];
        prefixMask = new int[tree_nodes];
        values = new char[tree_nodes];

        for (int i = 0; i < tree_nodes; i++)
            values[i] = arr.get(i);

        // DFS from root (0)
        dfs(0, -1, 0, 0);

        List<Integer> result = new ArrayList<>();

        for (int q : queries) {

            int count = 0;
            int current = q;

            while (current != -1) {

                // mask from q → current
                int pathMask = prefixMask[q] ^
                        (parent[current] == -1 ? 0 : prefixMask[parent[current]]);

                // Check palindrome condition
                if (pathMask == 0 || (pathMask & (pathMask - 1)) == 0)
                    count++;

                current = parent[current];
            }

            result.add(count);
        }

        return result;
    }

    static void dfs(int node, int par, int d, int mask) {

        parent[node] = par;
        depth[node] = d;

        // Toggle current character
        mask ^= (1 << (values[node] - 'a'));
        prefixMask[node] = mask;

        for (int child : graph.get(node)) {
            if (child != par)
                dfs(child, node, d + 1, mask);
        }
    }


    public static void main(String[] args) {

        int tree_nodes = 4;
        int tree_edges = 3;

        List<Integer> tree_from = Arrays.asList(0,0,1);
        List<Integer> tree_to = Arrays.asList(1,2,3);
        List<Character> arr = Arrays.asList('z','a','a','a');
        List<Integer> queries =Arrays.asList(3);;

        List<Integer> ans = PalindromePaths.palindromePaths(tree_nodes, tree_from, tree_to, arr, queries);

        for (int val : ans)
            System.out.println(val);
    }

}
