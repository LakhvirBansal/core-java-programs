package amazon;

import java.util.*;
public class DetermineRankingPoints {

    static class Player {
        int expertise;
        int points;
        int index;

        Player(int e, int p, int i) {
            expertise = e;
            points = p;
            index = i;
        }
    }


    public static List<Long> determineRankingPoints(List<Integer> expertise,
                                                    List<Integer> points,
                                                    int count) {

        int n = expertise.size();
        Player[] arr = new Player[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Player(expertise.get(i), points.get(i), i);
        }

        // sort by expertise
        Arrays.sort(arr, (a, b) -> Integer.compare(a.expertise, b.expertise));

        long[] ans = new long[n];

        // min heap for top 'count' points
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;

        int i = 0;

        while (i < n) {
            int j = i;

            // group same expertise
            while (j < n && arr[j].expertise == arr[i].expertise) {
                j++;
            }

            // for all same expertise participants
            // assign answer first (strictly less expertise only)
            for (int k = i; k < j; k++) {
                ans[arr[k].index] = sum;
            }

            // now add their points into heap
            for (int k = i; k < j; k++) {
                int pt = arr[k].points;

                if (count > 0) {
                    if (minHeap.size() < count) {
                        minHeap.add(pt);
                        sum += pt;
                    } else if (!minHeap.isEmpty() && pt > minHeap.peek()) {
                        sum -= minHeap.poll();
                        minHeap.add(pt);
                        sum += pt;
                    }
                }
            }

            i = j;
        }

        List<Long> result = new ArrayList<>();
        for (long v : ans) result.add(v);
        return result;
    }


    public static void main(String[] args) throws Exception {

        List<Integer> expertise = Arrays.asList(1,7,5);
        List<Integer> points = Arrays.asList(0,0,1);
        int count = 1;

        List<Long> res = DetermineRankingPoints.determineRankingPoints(expertise, points, count);

        for (long v : res) {
            System.out.println(v);
        }
    }

}
