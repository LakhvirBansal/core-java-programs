package amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class getMinRequests {
    public static long getMinRequests(List<Integer> request,
                                      List<Integer> health,
                                      int k) {
        int n = request.size();
        // build (p, w) pairs
        Server[] servers = new Server[n];
        for (int i = 0; i < n; i++) {
            int hitsNeeded = (health.get(i) + k - 1) / k;  // ceil(health/k)
            int weight     = request.get(i);
            servers[i] = new Server(hitsNeeded, weight);
        }

        // sort by ascending p_i/w_i  (i.e. p1*w2 < p2*w1)
        Arrays.sort(servers);

        // suffix sum of weights
        long suffixW = 0;
        for (Server s : servers) {
            suffixW += s.w;
        }

        // accumulate cost = sum_j p_j * (sum_{t=j..n-1} w_t)
        long total = 0;
        for (Server s : servers) {
            total += (long) s.p * suffixW;
            suffixW -= s.w;
        }

        // +1 final request to conclude drill
        return total + 1;
    }

    private static class Server implements Comparable<Server> {
        int p, w;
        Server(int p, int w) { this.p = p; this.w = w; }

        @Override
        public int compareTo(Server o) {
            // compare p/ w  vs  o.p / o.w
            // i.e. p * o.w  ?  o.p * w
            long lhs = (long) this.p * o.w;
            long rhs = (long) o.p * this.w;
            return Long.compare(lhs, rhs);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read request[]
        int nReq = Integer.parseInt(br.readLine().trim());
        List<Integer> request = new ArrayList<>(nReq);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nReq; i++) {
            request.add(Integer.parseInt(st.nextToken()));
        }

        // read health[]
        int nHp = Integer.parseInt(br.readLine().trim());
        List<Integer> health = new ArrayList<>(nHp);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nHp; i++) {
            health.add(Integer.parseInt(st.nextToken()));
        }

        // read k
        int k = Integer.parseInt(br.readLine().trim());

        // compute and print result
        long ans = getMinRequests(request, health, k);
        System.out.println(ans);
    }
}
