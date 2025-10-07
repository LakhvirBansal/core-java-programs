package amazon;

import java.io.*;
import java.util.*;

public class FindMinimumOperations {

    public static int findMinimumOperations(List<Integer> arr) {
        int n = arr.size();
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) pos[arr.get(i)] = i;
        boolean circularInc = true;
        for (int v = 1; v < n; v++) {
            if ((pos[v + 1] - pos[v] + n) % n != 1) { circularInc = false; break; }
        }
        if (circularInc) {
            int k = pos[1];
            return Math.min(k, 2 + (n - k));
        }
        boolean circularDec = true;
        for (int v = 1; v < n; v++) {
            if ((pos[v] - pos[v + 1] + n) % n != 1) { circularDec = false; break; }
        }
        if (circularDec) {
            int p1 = pos[1];
            int r = (p1 + 1) % n;
            int costA = r + 1;
            int kPrime = n - 1 - p1;
            int costB = 1 + Math.min(kPrime, 2 + (n - kPrime));
            return Math.min(costA, costB);
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Integer nObj = fs.nextInt();
        if (nObj == null) return;
        int n = nObj;

        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Integer x = fs.nextInt();
            if (x == null) { System.out.println(-1); return; }
            arr.add(x);
        }

        System.out.println(findMinimumOperations(arr));
    }
    private static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { this.in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        Integer nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
                if (c == -1) return null;
            } while (c <= ' ');

            if (c == '-') { sign = -1; c = read(); }

            while (c > ' ') {
                if (c < '0' || c > '9') break;
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
