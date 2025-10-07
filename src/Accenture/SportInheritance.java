package Accenture;


import java.util.*;
import java.io.*;

/*
 * Implements the Cricket and Football classes following the described spec.
 * Uses inheritance to share common playerID logic.
 */

class Team {
    // 1-based indices for players: index 1..11 used
    protected int[] playerIDs;

    public Team() {
        // initialize array size 12 so index 1..11 valid
        playerIDs = new int[12];
        for (int i = 1; i <= 11; i++) {
            playerIDs[i] = 1; // active
        }
    }

    // retire player for both sports: sets to -1 and prints appropriate message
    public void retirePlayer(int id) {
        if (id < 1 || id > 11) {
            // ignore invalid id (not expected per problem constraints)
            return;
        }
        if (playerIDs[id] == -1) {
            System.out.println("Player has already retired");
        } else {
            playerIDs[id] = -1;
            System.out.println("Player with id: " + id + " has retired");
        }
    }

    // helper to check if active
    protected boolean isActive(int id) {
        if (id < 1 || id > 11) return false;
        return playerIDs[id] != -1;
    }
}

class Cricket extends Team {
    public Cricket() {
        super();
        System.out.println("A new cricket team has been formed");
    }

    // ages array length should be 11
    public void calculateAvgAge(int[] age) {
        if (age == null || age.length == 0) {
            System.out.println("The average age of the team is 0.00");
            return;
        }
        double sum = 0;
        for (int a : age) sum += a;
        double avg = sum / age.length;
        System.out.printf("The average age of the team is %.2f%n", avg);
    }
}

class Football extends Team {
    public Football() {
        super();
        System.out.println("A new football team has been formed");
    }

    public void calculateAvgAge(int[] age) {
        if (age == null || age.length == 0) {
            System.out.println("The average age of the team is 0.00");
            return;
        }
        double sum = 0;
        for (int a : age) sum += a;
        double avg = sum / age.length;
        System.out.printf("The average age of the team is %.2f%n", avg);
    }

    // transfer: if active => set to 1 (remains active) and print transferred message
    // if already retired => print "Player has already retired"
    public void playerTransfer(int fee, int id) {
        if (id < 1 || id > 11) {
            return;
        }
        if (!isActive(id)) {
            System.out.println("Player has already retired");
        } else {
            // ensure active
            playerIDs[id] = 1;
            System.out.println("Player with id: " + id + " has been transferred with a fee of " + fee);
        }
    }
}

public class SportInheritance {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Read cricket ages (11 space-separated integers)
        int[] cricketAges = new int[11];
        for (int i = 0; i < 11; ) {
            if (!sc.hasNext()) break;
            String token = sc.next();
            // If token is newline or blank, continue; otherwise parse
            try {
                cricketAges[i] = Integer.parseInt(token);
                i++;
            } catch (NumberFormatException e) {
                // ignore unexpected tokens
            }
        }

        // Read football ages (11 space-separated integers)
        int[] footballAges = new int[11];
        for (int i = 0; i < 11; ) {
            if (!sc.hasNext()) break;
            String token = sc.next();
            try {
                footballAges[i] = Integer.parseInt(token);
                i++;
            } catch (NumberFormatException e) {
                // ignore unexpected tokens
            }
        }

        // Next 5 lines: each contains an integer ID to retire (one per line)
        List<Integer> retireIds = new ArrayList<>();
        int retireCount = 5;
        for (int i = 0; i < retireCount; i++) {
            if (!sc.hasNextInt()) {
                // If input separated by newlines, try to read lines
                if (!sc.hasNext()) break;
                sc.next();
                i--;
                continue;
            }
            retireIds.add(sc.nextInt());
        }

        // Last line: transfer fee and id
        int fee = 0, transferId = 0;
        if (sc.hasNextInt()) {
            fee = sc.nextInt();
            if (sc.hasNextInt()) transferId = sc.nextInt();
        }

        // Create teams and run actions
        Cricket c = new Cricket();
        Football f = new Football();

        c.calculateAvgAge(cricketAges);
        f.calculateAvgAge(footballAges);

        // Perform retire operations on cricket team (as in sample)
        for (int id : retireIds) {
            c.retirePlayer(id);
        }

        // Perform transfer on football
        f.playerTransfer(fee, transferId);

        sc.close();
    }
}

