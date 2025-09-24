package Visa;

public class CummulativeSum {

    static String solution(int initial, int[] changes) {
        int rating = initial;

        for (int change : changes) {
            rating += change;

            // Rating is guaranteed to stay within 1 to 2500 as per problem
            // So no bounds check needed
        }

        if (rating < 1000) {
            return "beginner";
        } else if (rating < 1500) {
            return "intermediate";
        } else if (rating < 2000) {
            return "advanced";
        } else {
            return "pro";
        }
    }

    public static void main(String[] args) {
        int initial = 1500;
        int[] changes = {-100, -300, 450, 500, -500, -600};
        System.out.println(solution(initial, changes));
    }
}
