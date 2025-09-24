package amazon;

import java.io.*;
import java.util.*;

public class findMaxUnloaded  {
    /*
     * Complete the 'findMaxUnloaded' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts the following parameters:
     *  1. INTEGER_ARRAY boxes
     *  2. INTEGER space
     */
    public static int findMaxUnloaded(List<Integer> boxes, int space) {
        int n = boxes.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = boxes.get(i);
        }
        Arrays.sort(a);

        int j = 0, maxKeep = 1;
        for (int i = 0; i < n; i++) {
            // advance j while window [i..j] remains valid
            while (j + 1 < n && (long)a[j + 1] <= (long)space * a[i]) {
                j++;
            }
            maxKeep = Math.max(maxKeep, j - i + 1);
        }

        // unload = total boxes minus those we keep
        return n - maxKeep;
    }

    public static void main(String[] args) {
        int n = 4;
        List<Integer> boxes = Arrays.asList(1,4,3,2);
        int space = 2;
        int result = findMaxUnloaded(boxes, space);
        System.out.println(result);
    }

}

