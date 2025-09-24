package amazon;
import java.util.*;
public class optimizeInventory {

    public static void main(String[] args) {

        List<Integer> inventoryAdjustments = Arrays.asList(4, -4,-3,1,2);

        int result = optimizeInventory(inventoryAdjustments);
        System.out.println(result);
        inventoryAdjustments = Arrays.asList(3, -5,8, -9,-7);

        result = optimizeInventory(inventoryAdjustments);
        System.out.println(result);
        inventoryAdjustments = Arrays.asList(-1,-3, -2, 0);

        result = optimizeInventory(inventoryAdjustments);
        System.out.println(result);

    }

    public static int optimizeInventory(List<Integer> inventoryAdjustments) {
        // We use a max-priority queue to process negative adjustments
        // in order from largest (closest to zero) to smallest (most negative).
        // This greedy approach ensures we maintain a positive inventory for as long as possible.
        PriorityQueue<Long> negativeAdjustments = new PriorityQueue<>(Collections.reverseOrder());

        long currentInventory = 0;
        int processedShipments = 0;

        // First, process all positive and zero adjustments to build up the initial inventory.
        for (int adjustment : inventoryAdjustments) {
            long longAdjustment = (long) adjustment;
            if (longAdjustment >= 0) {
                currentInventory += longAdjustment;
                processedShipments++;
            } else {
                negativeAdjustments.offer(longAdjustment);
            }
        }

        // Now, process the negative adjustments from the priority queue
        // to see how many we can include without the inventory dropping to zero or below.
        while (!negativeAdjustments.isEmpty()) {
            long largestNegative = negativeAdjustments.poll();
            // Check if adding this negative adjustment would keep the inventory strictly positive.
            if (currentInventory + largestNegative > 0) {
                currentInventory += largestNegative;
                processedShipments++;
            } else {
                // If the inventory would become zero or negative, we cannot process this shipment
                // or any subsequent shipments. So, we stop.
                break;
            }
        }

        // This is the critical fix for the edge case where the final inventory is zero or negative.
        // According to the problem description, if the inventory reaches zero or goes negative,
        // no shipments can be processed.
        if (currentInventory <= 0) {
            return 0;
        }

        return processedShipments;
    }

}
