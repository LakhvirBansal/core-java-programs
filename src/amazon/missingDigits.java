package amazon;

public class missingDigits {

    public static String missingDigits(String config, int x, int y) {
        int m = config.length();
        int[] need = new int[m];
        for (int i = 0; i < m; i++) {
            need[i] = config.charAt(i) - '0';
        }
        int totalStates = (m + 1) * 10;
        boolean[] visited = new boolean[totalStates];
        int[] parent = new int[totalStates];
        byte[] parentEdge = new byte[totalStates];
        int[] queue = new int[totalStates];
        int head = 0, tail = 0;
        visited[0] = true;
        parent[0] = -1;
        queue[tail++] = 0;
        int endState = -1;
        while (head < tail) {
            int id = queue[head++];
            int i = id / 10;
            int j = id % 10;
            if (i == m) {
                endState = id;
                break;
            }
            if (x == y) {
                int nj = (j + x) % 10;
                int ni = i + (i < m && nj == need[i] ? 1 : 0);
                int nid = ni * 10 + nj;
                if (!visited[nid]) {
                    visited[nid] = true;
                    parent[nid] = id;
                    parentEdge[nid] = (byte) nj;
                    queue[tail++] = nid;
                }
            } else {
                int nj1 = (j + x) % 10;
                int ni1 = i + (i < m && nj1 == need[i] ? 1 : 0);
                int nj2 = (j + y) % 10;
                int ni2 = i + (i < m && nj2 == need[i] ? 1 : 0);
                if (nj1 < nj2 || (nj1 == nj2 && ni1 > ni2)) {
                    int nid1 = ni1 * 10 + nj1;
                    if (!visited[nid1]) {
                        visited[nid1] = true;
                        parent[nid1] = id;
                        parentEdge[nid1] = (byte) nj1;
                        queue[tail++] = nid1;
                    }
                    int nid2 = ni2 * 10 + nj2;
                    if (!visited[nid2]) {
                        visited[nid2] = true;
                        parent[nid2] = id;
                        parentEdge[nid2] = (byte) nj2;
                        queue[tail++] = nid2;
                    }
                } else {
                    int nid2 = ni2 * 10 + nj2;
                    if (!visited[nid2]) {
                        visited[nid2] = true;
                        parent[nid2] = id;
                        parentEdge[nid2] = (byte) nj2;
                        queue[tail++] = nid2;
                    }
                    int nid1 = ni1 * 10 + nj1;
                    if (!visited[nid1]) {
                        visited[nid1] = true;
                        parent[nid1] = id;
                        parentEdge[nid1] = (byte) nj1;
                        queue[tail++] = nid1;
                    }
                }
            }
        }
        if (endState < 0) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int cur = endState; parent[cur] != -1; cur = parent[cur]) {
            sb.append((char) (parentEdge[cur] + '0'));
        }
        return sb.reverse().toString();
    }
}
