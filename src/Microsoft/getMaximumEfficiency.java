package Microsoft;

import java.util.*;
public class getMaximumEfficiency {

    public static long getMaximumEfficiency(int connectNodes,
                                            List<Integer> connectFrom,
                                            List<Integer> connectTo,
                                            List<Integer> computerVal,
                                            int k) {
        int n = connectNodes;
        // build undirected adjacency
        List<List<Integer>> adj = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n-1; i++){
            int u = connectFrom.get(i), v = connectTo.get(i);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // root the tree at 1
        int root = 1;
        int[] parent = new int[n+1];
        List<List<Integer>> tree = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) tree.add(new ArrayList<>());
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(root);
        parent[root] = 0;
        while(!stack.isEmpty()){
            int u = stack.pop();
            for(int v: adj.get(u)){
                if(v == parent[u]) continue;
                parent[v] = u;
                tree.get(u).add(v);
                stack.push(v);
            }
        }

        // post‑order traversal (parent after children)
        long[] subtreeSum = new long[n+1];
        long[] dp         = new long[n+1];
        List<Integer> order = new ArrayList<>(n);
        stack.push(root);
        while(!stack.isEmpty()){
            int u = stack.pop();
            order.add(u);
            for(int v: tree.get(u))
                stack.push(v);
        }

        // bottom‑up DP
        for(int i = order.size() - 1; i >= 0; i--){
            int u = order.get(i);
            long sum = computerVal.get(u-1);   // 0‑based list
            long keepCost = 0;
            for(int v: tree.get(u)){
                sum += subtreeSum[v];
                keepCost += dp[v];
            }
            subtreeSum[u] = sum;
            long deleteCost = sum + (long)k;
            dp[u] = Math.min(deleteCost, keepCost);
        }

        long totalSum = subtreeSum[root];
        // dp[root] is the minimal total deletion‑cost
        return totalSum - dp[root];
    }

    public static void main(String[] args) {
        // Example 1 (Expected Output: -2)
        int connectNodes = 4;
        List<Integer> connectFrom = Arrays.asList(1, 2, 3);
        List<Integer> connectTo = Arrays.asList(2, 3, 4);
        List<Integer> computerVal = Arrays.asList(3, -7, -8, -9);
        int k = 5;

        long result = getMaximumEfficiency(connectNodes, connectFrom, connectTo, computerVal, k);
        System.out.println("Max Efficiency (Example 1): " + result);  // Should print: -2


        connectNodes = 3;
        connectFrom = Arrays.asList(1, 3);
        connectTo = Arrays.asList(2, 2);
        computerVal = Arrays.asList(9, -1, 3);
        k = 3;

        result = getMaximumEfficiency(connectNodes, connectFrom, connectTo, computerVal, k);
        System.out.println("Max Efficiency (Example 2): " + result);  // Expected: 11

    }
}

