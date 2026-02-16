package Viant;

import java.util.*;
public class FindMinWeight {

    public static int findMinWeight(List<Integer> weights, int d) {

        // Max heap to always pick largest chocolate
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;

        // add all weights
        for (int w : weights) {
            maxHeap.add(w);
            total += w;
        }

        // perform for d days
        for (int i = 0; i < d; i++) {
            int max = maxHeap.poll();  // pick largest

            int eaten = max / 2;       // floor(max/2)
            int remaining = max - eaten;

            total -= eaten;            // reduce total weight
            maxHeap.add(remaining);    // put remaining back
        }

        return (int) total;
    }

    public static void main(String[] args) {

        List<Integer> weights = Arrays.asList(30,20,25);
        int result = FindMinWeight.findMinWeight(weights, 4);
        System.out.println(result);
    }
}

/**

 SELECT
 a.username,
 a.email,
 (
 SELECT t2.name
 FROM readings r2
 JOIN tariffs t2 ON r2.tariff_id = t2.id
 WHERE r2.account_id = a.id
 ORDER BY t2.cost DESC
 LIMIT 1
 ) AS highest_tariff,
 SUM(r.amount) AS consumption,
 ROUND(SUM(r.amount * t.cost), 2) AS total_cost
 FROM accounts a
 JOIN readings r ON a.id = r.account_id
 JOIN tariffs t ON r.tariff_id = t.id
 GROUP BY a.id, a.username, a.email
 ORDER BY a.username ASC;

 */
