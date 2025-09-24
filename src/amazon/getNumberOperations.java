package amazon;

import java.io.*;
import java.util.*;

public class getNumberOperations {

    public static int getNumberOperations(List<Integer> packageSequence) {
        int n = packageSequence.size();
        // pos[x] = index of package x in the input
        int[] pos = new int[n+1];
        for (int i = 0; i < n; i++) {
            pos[packageSequence.get(i)] = i;
        }
        // We always need at least one pass:
        int operations = 1;
        // Whenever the next package's position is to the left of the previous,
        // we must start a new operation.
        for (int x = 2; x <= n; x++) {
            if (pos[x] < pos[x-1]) {
                operations++;
            }
        }
        return operations;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> seq = Arrays.asList(5,3,4,1,2);
        int answer = getNumberOperations(seq);
        System.out.println(answer);
    }
}
