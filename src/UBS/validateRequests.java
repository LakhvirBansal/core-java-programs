package UBS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;
public class validateRequests {

    public static List<Integer> validateRequests(List<String> blacklisted_ips, List<String> requests) {

        // Use a stream to transform the blacklisted IP strings into a list of compiled regex patterns.
        // The wildcard '*' is replaced with '.*' for proper regex matching.
        List<Pattern> blacklistPatterns = blacklisted_ips.stream()
                .map(s -> s.replace(".","\\.").replace("*", ".*"))
                .map(Pattern::compile)
                .collect(Collectors.toList());

        // A map to store the timestamps (represented by request index) of unblocked requests for each IP.
        // This is used to implement the rate-limiting logic.
        // This map is a mutable state that is updated within the stream's lambda, which is a
        // necessary side-effect for this stateful problem.
        Map<String, List<Integer>> unblockedRequestTimestamps = new HashMap<>();

        // Use a stream to process each request with its corresponding index, mapping each index to a result (0 or 1).
        return IntStream.range(0, requests.size())
                .mapToObj(i -> {
                    String currentIp = requests.get(i);

                    // Rule 1: Check if the IP matches any blacklisted regex pattern.
                    // The anyMatch() method provides an efficient way to check if any pattern matches.
                    boolean matchesBlacklist = blacklistPatterns.stream()
                            .anyMatch(pattern -> pattern.matcher(currentIp).matches());

                    if (matchesBlacklist) {
                        return 1; // Blocked by blacklist
                    } else {
                        // Rule 2: Check the rate-limiting rule.
                        // An IP is blocked if it has sent >= 2 unblocked requests in the last 5 "seconds".

                        // Get the list of unblocked timestamps for the current IP, or create a new list.
                        List<Integer> timestamps = unblockedRequestTimestamps.getOrDefault(currentIp, new ArrayList<>());

                        // Use a stream to count the number of unblocked requests in the last 5 "seconds".
                        // We are using the request index as a proxy for time. A request at index 'j' is
                        // considered to be in the "last 5 seconds" of a request at index 'i' if 'i - j < 5'.
                        long recentUnblockedCount = timestamps.stream()
                                .filter(timestamp -> (i - timestamp) < 5)
                                .count();

                        if (recentUnblockedCount >= 2) {
                            return 1; // Blocked by rate-limiting
                        } else {
                            // The request is not blocked by either rule.
                            // Add the current timestamp (index) to the list for this IP.
                            timestamps.add(i);
                            unblockedRequestTimestamps.put(currentIp, timestamps);
                            return 0; // Unblocked
                        }
                    }
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> blacklisted_ips = Arrays.asList("*111.*", "123.*", "34.*");
        List<String> requests = Arrays.asList(
                "123.1.23.34",  // blocked due to "123.*"
                "121.1.23.34",  // not blocked
                "121.1.23.34",  // not blocked
                "34.1.23.34",   // blocked due to "34.*"
                "121.1.23.34",  // blocked due to 2 unblocked reqs in last 5 sec
                "121.1.23.34",  // not blocked
                "121.1.23.34"   // not blocked
        );

        List<Integer> result = validateRequests(blacklisted_ips, requests);
        System.out.println("Blocked Status: " + result);


        // Sample Case 0 from the problem description
        List<String> blacklistedIps0 = List.of("111.*.255", "12.");
        List<String> requests0 = List.of("121.3.5.255", "12.13.5.255", "111.3.5.255", "121.3.5.255");
        List<Integer> result0 = validateRequests(blacklistedIps0, requests0);
        System.out.println("Sample Case 0 Result: " + result0); // Expected: [0, 0, 1, 0]

        // Sample Case 1 from the problem description
        List<String> blacklistedIps1 = List.of("111.111.1.1");
        List<String> requests1 = List.of("111.111.1.1");
        List<Integer> result1 = validateRequests(blacklistedIps1, requests1);
        System.out.println("Sample Case 1 Result: " + result1); // Expected: [1]

        // A custom test case to demonstrate the rate-limiting rule.
        List<String> blacklistedIps2 = List.of("123.45.67.*");
        List<String> requests2 = List.of(
                "1.1.1.1", // unblocked (count: 0) -> timestamp: 0
                "1.1.1.1", // unblocked (count: 1) -> timestamp: 1
                "1.1.1.1", // unblocked (count: 2) -> timestamp: 2
                "1.1.1.1", // blocked (count: 2 - from times 1 & 2)
                "1.1.1.1", // unblocked (count: 2 - from times 1 & 2) -> timestamp: 4
                "1.1.1.1"  // blocked (count: 2 - from times 2 & 4)
        );
        List<Integer> result2 = validateRequests(blacklistedIps2, requests2);
        System.out.println("Rate-limiting test Result: " + result2);
    }
}