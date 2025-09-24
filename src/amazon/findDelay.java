package amazon;

import java.io.*;
import java.util.*;

public class findDelay {

    static class Fenwick {
        int[] tree;
        int n;
        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
            Arrays.fill(tree, -1);
        }
        void update(int i, int val) {
            while (i <= n) {
                tree[i] = Math.max(tree[i], val);
                i += i & -i;
            }
        }
        int query(int i) {
            int res = -1;
            while (i > 0) {
                res = Math.max(res, tree[i]);
                i -= i & -i;
            }
            return res;
        }
    }

    public static List<Integer> findDelay(List<Integer> priorities) {
        int n = priorities.size();
        List<Integer> sorted = new ArrayList<>(priorities);
        Collections.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int v : sorted) {
            if (!rank.containsKey(v))
                rank.put(v, r++);
        }
        Fenwick fenw = new Fenwick(r);
        List<Integer> delay = new ArrayList<>(Collections.nCopies(n, 0));
        for (int i = n - 1; i >= 0; i--) {
            int p = priorities.get(i);
            int rk = rank.get(p);
            if (rk > 1) {
                int j = fenw.query(rk - 1);
                if (j != -1)
                    delay.set(i, j - i);
            }
            fenw.update(rk, i);
        }
        return delay;
    }

    public static void main(String[] args) throws IOException {
        int n = 4;
        List<Integer> priorities = Arrays.asList(6,10,9,7);
        System.out.println(findDelay(priorities));

        priorities = Arrays.asList(8,2,5,3);
        System.out.println(findDelay(priorities));
    }

}
