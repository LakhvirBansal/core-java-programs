package CapitalOne;

public class Astronomors {

    public static String solution(String season, int dayCount, String initialPhase) {
        // List of months and their lengths (non-leap year)
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Lunar phases in fixed cycle
        String[] phases = {"NewMoon", "Crescent", "Quarter", "Gibbous",
                "Full", "Waning", "Eclipse", "Twilight"};

        // 1. Calculate days since start of year till the given date
        int daysSinceStart = 0;
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(season)) {
                break;
            }
            daysSinceStart += daysInMonth[i];
        }

        // Add dayCount for the specific day in the season
        daysSinceStart += dayCount - 1; // subtract 1 since Jan 1 = day 0

        // 2. Find index of initialPhase
        int initialIndex = 0;
        for (int i = 0; i < phases.length; i++) {
            if (phases[i].equals(initialPhase)) {
                initialIndex = i;
                break;
            }
        }

        // 3. Compute final phase
        int finalIndex = (initialIndex + daysSinceStart) % phases.length;
        return phases[finalIndex];
    }

    public static void main(String[] args) {
        // Test case 1
        String result1 = solution("January", 4, "Full");
        System.out.println("Lunar phase on January 4th starting from Full: " + result1); // Expected: Twilight

        // Test case 2
        String result2 = solution("February", 4, "Crescent");
        System.out.println("Lunar phase on February 4th starting from Crescent: " + result2); // Expected: Gibbous

        // Test case 3
        String result3 = solution("March", 15, "NewMoon");
        System.out.println("Lunar phase on March 15th starting from NewMoon: " + result3); // Try your own expectation
    }
}
