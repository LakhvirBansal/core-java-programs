package Optiver;

public class DaysBetween {

    static int daysBetween(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {
        int totalDays = 0;

        // If both dates are in the same year
        if (year1 == year2) {
            totalDays = daysFromStartOfYear(year2, month2, day2) - daysFromStartOfYear(year1, month1, day1);
            return totalDays;
        }

        // Days remaining in the first year
        totalDays += daysInYear(year1) - daysFromStartOfYear(year1, month1, day1);

        // Add full years between
        for (int year = year1 + 1; year < year2; year++) {
            totalDays += daysInYear(year);
        }

        // Add days passed in the last year
        totalDays += daysFromStartOfYear(year2, month2, day2);

        return totalDays;
    }

    // Helper function: total days from Jan 1 to given date
    static int daysFromStartOfYear(int year, int month, int day) throws Exception {
        int days = 0;
        for (int m = 1; m < month; m++) {
            days += DaysInMonth(m, year);
        }
        days += day;
        return days;
    }

    // Helper function: check if leap year
    static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Helper function: total days in a year
    static int daysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    // The implementation of this function is hidden.
    static int DaysInMonth(int month, int year) throws Exception {
        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonth[month - 1];
    }

    public static void main(String[] args) throws Exception {

        int year1 = 2010;
        int month1 = 5;
        int day1 = 1;
        int year2 = 2011;
        int month2 = 5;
        int day2 = 1;

        int res = daysBetween(year1, month1, day1, year2, month2, day2);
        System.out.println(res);
    }
}
