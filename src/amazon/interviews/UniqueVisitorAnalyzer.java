package amazon.interviews;

import java.util.*;
public class UniqueVisitorAnalyzer {

    // Helper event class
    static class VisitEvent {
        String userId;
        long timestamp;
        public VisitEvent(String userId, long timestamp) {
            this.userId = userId;
            this.timestamp = timestamp;
        }
    }

    private final Map<String, Integer> visitCount = new HashMap<>();
    private final Map<String, Long> firstTimestamp = new HashMap<>();

    // 1. Process a single event at a time
    public void processVisit(VisitEvent event) {
        // Increment visit count
        visitCount.put(event.userId, visitCount.getOrDefault(event.userId, 0) + 1);
        // Store the earliest timestamp for this user
        if (!firstTimestamp.containsKey(event.userId)) {
            firstTimestamp.put(event.userId, event.timestamp);
        } else {
            firstTimestamp.put(event.userId, Math.min(firstTimestamp.get(event.userId), event.timestamp));
        }
    }

    // 2. Get the oldest unique visitor (who visited only once)
    public String getOldestUniqueVisitor() {
        String result = null;
        long minTimestamp = Long.MAX_VALUE;
        for (String userId : visitCount.keySet()) {
            if (visitCount.get(userId) == 1) {
                long ts = firstTimestamp.get(userId);
                if (ts < minTimestamp) {
                    minTimestamp = ts;
                    result = userId;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        UniqueVisitorAnalyzer analyzer = new UniqueVisitorAnalyzer();
        List<VisitEvent> events = Arrays.asList(
                new VisitEvent("A", 1000),
                new VisitEvent("B", 1010),
                new VisitEvent("C", 1020),
                new VisitEvent("A", 1050),
                new VisitEvent("D", 1060),
                new VisitEvent("E", 1070)
        );
        for (VisitEvent event : events) {
            analyzer.processVisit(event);
        }
        System.out.println(analyzer.getOldestUniqueVisitor()); // Output: B
    }
}
