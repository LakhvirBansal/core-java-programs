package amazon;

import java.io.*;
import java.util.*;
public class getStrength {

    public static long getStrength(List<List<Integer>> machine_powers) {
        long sumSecond  = 0;
        int globalMin   = Integer.MAX_VALUE;
        int minSecond   = Integer.MAX_VALUE;

        for (List<Integer> powers : machine_powers) {
            // find the two smallest values in this machine
            int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
            for (int p : powers) {
                if (p < first) {
                    second = first;
                    first  = p;
                } else if (p < second) {
                    second = p;
                }
            }
            globalMin = Math.min(globalMin, first);
            sumSecond += second;
            minSecond = Math.min(minSecond, second);
        }

        // sum of all second‑minima,
        // drop the smallest of those (the ultimate “receiver”),
        // and add back the overall minimum
        return sumSecond - minSecond + globalMin;
    }

    public static void main(String[] args) throws IOException {

        int n = 2;
        List<List<Integer>> machine_powers = new ArrayList<>(n);
        List<Integer> row1 = Arrays.asList(2,7,4);
        List<Integer> row2 = Arrays.asList(2,4,3);

        machine_powers.add(row1);
        machine_powers.add(row2);

        long answer = getStrength(machine_powers);
        System.out.println(answer);
    }
}
