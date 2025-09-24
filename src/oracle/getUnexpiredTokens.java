package oracle;

import java.util.*;
public class getUnexpiredTokens {

    public static List<Integer> getUnexpiredTokens(int time_to_live, List<String> queries) {
        Map<String, Integer> tokenExpiry = new HashMap<>(); // token_id -> expiry
        TreeMap<Integer, Set<String>> expiryMap = new TreeMap<>(); // expiry time -> set of token_ids
        List<Integer> result = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");
            String command = parts[0];

            if (command.equals("generate")) {
                String token = parts[1];
                int time = Integer.parseInt(parts[2]);
                int expiry = time + time_to_live;

                tokenExpiry.put(token, expiry);
                expiryMap.computeIfAbsent(expiry, k -> new HashSet<>()).add(token);

            } else if (command.equals("renew")) {
                String token = parts[1];
                int time = Integer.parseInt(parts[2]);

                if (tokenExpiry.containsKey(token) && tokenExpiry.get(token) > time) {
                    // Remove old expiry
                    int oldExpiry = tokenExpiry.get(token);
                    Set<String> tokens = expiryMap.get(oldExpiry);
                    if (tokens != null) {
                        tokens.remove(token);
                        if (tokens.isEmpty()) expiryMap.remove(oldExpiry);
                    }

                    // Add new expiry
                    int newExpiry = time + time_to_live;
                    tokenExpiry.put(token, newExpiry);
                    expiryMap.computeIfAbsent(newExpiry, k -> new HashSet<>()).add(token);
                }

            } else if (command.equals("count")) {
                int currentTime = Integer.parseInt(parts[1]);

                // Remove expired tokens (expiryTime <= currentTime)
                NavigableMap<Integer, Set<String>> expired = expiryMap.headMap(currentTime, true);
                List<Integer> expiredKeys = new ArrayList<>(expired.keySet());
                for (int expiryTime : expiredKeys) {
                    for (String t : expiryMap.get(expiryTime)) {
                        tokenExpiry.remove(t);
                    }
                    expiryMap.remove(expiryTime);
                }

                result.add(tokenExpiry.size());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int time_to_live = 9;

        List<String> queries = Arrays.asList(
                "generate token1 3",
                "renew token1 5",
                "generate token2 7",
                "renew token2 8",
                "generate token3 9",
                "count 12"
        );

        List<Integer> result = getUnexpiredTokens(time_to_live, queries);
        System.out.println("Unexpired tokens count: " + result);
    }
}
