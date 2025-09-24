package amazon;

import java.io.*;
import java.util.*;

public class getminSubsegments  {
    /*
     * Complete the 'getminSubsegments' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING frames as parameter.
     */
    public static int getminSubsegments(String frames) {
        int n = frames.length();
        // dp arrays: for each bit b=0,1, we store two states:
        //   flipsOdd[b],  runsOdd[b]  = ending at i with run of b of odd length
        //   flipsEven[b], runsEven[b] = ending at i with run of b of even length
        final int INF = Integer.MAX_VALUE / 2;
        int[] flipsOdd  = {INF, INF}, flipsEven  = {INF, INF};
        int[] runsOdd   = {INF, INF}, runsEven   = {INF, INF};

        // i=0 initialization: start first run of length 1 => odd
        for (int b = 0; b < 2; b++) {
            int cost = (frames.charAt(0) - '0' == b ? 0 : 1);
            flipsOdd[b] = cost;
            runsOdd[b]  = 1;
        }

        // iterate positions 1..n-1
        for (int i = 1; i < n; i++) {
            int bitAtI = frames.charAt(i) - '0';
            // new dp buffers
            int[] no = {INF, INF}, ne = {INF, INF};
            int[] ro = {INF, INF}, re = {INF, INF};

            for (int b = 0; b < 2; b++) {
                int flipCost = (bitAtI == b ? 0 : 1);

                // 1) continue same run: odd->even
                {
                    int f = flipsOdd[b] + flipCost;
                    int r = runsOdd[b];
                    if (f < ne[b] || (f == ne[b] && r < re[b])) {
                        ne[b] = f; re[b] = r;
                    }
                }
                // 2) continue same run: even->odd
                {
                    int f = flipsEven[b] + flipCost;
                    int r = runsEven[b];
                    if (f < no[b] || (f == no[b] && r < ro[b])) {
                        no[b] = f; ro[b] = r;
                    }
                }
                // 3) start new run here (only allowed if prev run even)
                int ob = 1 - b;
                {
                    int f = flipsEven[ob] + flipCost;
                    int r = runsEven[ob] + 1;
                    if (f < no[b] || (f == no[b] && r < ro[b])) {
                        no[b] = f; ro[b] = r;
                    }
                }
            }

            // copy back
            flipsOdd  = no;  runsOdd  = ro;
            flipsEven = ne;  runsEven = re;
        }

        // at end we only accept even-length runs
        // choose best among bit=0 or 1
        int bestFlips = INF, bestRuns = INF;
        for (int b = 0; b < 2; b++) {
            int f = flipsEven[b], r = runsEven[b];
            if (f < bestFlips || (f == bestFlips && r < bestRuns)) {
                bestFlips = f;
                bestRuns  = r;
            }
        }
        return bestRuns;
    }

    public static void main(String[] args) {
        String frames = "1110011000";
        System.out.println(getminSubsegments(frames));
    }
}
