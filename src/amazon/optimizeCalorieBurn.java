package amazon;

import java.io.*;
import java.util.*;
class Result {

    public static long optimizeCalorieBurn(List<Integer> height) {
        int n = height.size();
        // copy into array and sort
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = height.get(i);
        }
        Arrays.sort(h);

        long total = 0;
        long prev = 0;           // start on the ground (height = 0)
        int left = 0, right = n - 1;
        boolean pickHigh = true; // first jump to the highest block

        // alternate between the highest and lowest remaining blocks
        while (left < right) {
            int curr = pickHigh ? h[right--] : h[left++];
            long diff = prev - curr;
            total += diff * diff;
            prev = curr;
            pickHigh = !pickHigh;
        }

        // if one block remains, take it last
        if (left == right) {
            long curr = h[left];
            long diff = prev - curr;
            total += diff * diff;
        }

        return total;
    }
}

public class optimizeCalorieBurn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        List<Integer> height = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            height.add(Integer.parseInt(reader.readLine().trim()));
        }
        long answer = Result.optimizeCalorieBurn(height);
        System.out.println(answer);
        reader.close();
    }
}
