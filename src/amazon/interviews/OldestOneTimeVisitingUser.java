package amazon.interviews;

import java.util.*;
public class OldestOneTimeVisitingUser {

    private final Map<String, Integer> loginCounts = new HashMap<>();
    // Maintain order of first login for one-time users
    private final LinkedHashSet<String> oneTimeUsers = new LinkedHashSet<>();

    // Called every time a user logs in
    public void newUserLogin(String username) {
        int count = loginCounts.getOrDefault(username, 0) + 1;
        loginCounts.put(username, count);
        if (count == 1) {
            // First login, add to oneTimeUsers
            oneTimeUsers.add(username);
        } else if (count == 2) {
            // Second login, remove from oneTimeUsers if present
            oneTimeUsers.remove(username);
        }
    }

    // Return the oldest user who has visited only once, or null if none
    public String getOldestOneTimeVisitingUser() {
        return oneTimeUsers.isEmpty() ? null : oneTimeUsers.iterator().next();
    }

    public static void main(String[] args) {
        OldestOneTimeVisitingUser tracker = new OldestOneTimeVisitingUser();
        tracker.newUserLogin("john");
        tracker.newUserLogin("jeff");
        tracker.newUserLogin("jeff");
        System.out.println(tracker.getOldestOneTimeVisitingUser()); // john
        tracker.newUserLogin("amy");
        tracker.newUserLogin("sam");
        tracker.newUserLogin("amy");
        System.out.println(tracker.getOldestOneTimeVisitingUser()); // john
        tracker.newUserLogin("john");
        System.out.println(tracker.getOldestOneTimeVisitingUser()); // sam
    }
}
