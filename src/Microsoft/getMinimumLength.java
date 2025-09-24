package Microsoft;
import java.util.*;
public class getMinimumLength {

    static class Edge {
        int to;
        int w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }
    public static List<Integer> getMinimumLength(int roadNodes, int m,
                                                 List<Integer> roadsFrom,
                                                 List<Integer> roadsTo,
                                                 List<Integer> roadsWeight) {
        List<List<Edge>> graph = new ArrayList<>(roadNodes + 1);
        for (int i = 0; i <= roadNodes; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = roadsFrom.get(i);
            int v = roadsTo.get(i);
            int w = roadsWeight.get(i);
            graph.get(u).add(new Edge(v, w));
        }
        int[] eU = new int[m];
        int[] eV = new int[m];
        int[] eW = new int[m];
        for (int i = 0; i < m; i++) {
            eU[i] = roadsFrom.get(i);
            eV[i] = roadsTo.get(i);
            eW[i] = roadsWeight.get(i);
        }
        final long INF = Long.MAX_VALUE / 4;
        List<Integer> result = new ArrayList<>(roadNodes);
        for (int s = 1; s <= roadNodes; s++) {
            long[] dist = new long[roadNodes + 1];
            Arrays.fill(dist, INF);
            dist[s] = 0L;
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
            pq.offer(new long[]{0L, s});
            while (!pq.isEmpty()) {
                long[] cur = pq.poll();
                long d = cur[0];
                int u = (int) cur[1];
                if (d != dist[u]) continue;
                for (Edge e : graph.get(u)) {
                    int v = e.to;
                    long nd = d + e.w;
                    if (nd < dist[v]) {
                        dist[v] = nd;
                        pq.offer(new long[]{nd, v});
                    }
                }
            }
            long best = INF;
            for (int i = 0; i < m; i++) {
                if (eV[i] == s && dist[eU[i]] < INF) {
                    long cand = dist[eU[i]] + eW[i];
                    if (cand < best) best = cand;
                }
            }
            result.add(best == INF ? 0 : (int) best);
        }
        return result;
    }
    public static void main(String[] args) {
        int roadNodes = 3;
        int m = 3;
        List<Integer> from = Arrays.asList(1,2,3);
        List<Integer> to   = Arrays.asList(2,3,1);
        List<Integer> w    = Arrays.asList(10,10,10);
        List<Integer> ans = getMinimumLength(roadNodes, m, from, to, w);
        System.out.println(ans);
    }

}
