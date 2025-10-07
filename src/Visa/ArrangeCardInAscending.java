package Visa;

public class ArrangeCardInAscending {

    public static int solution(int[] deck) {
        if (deck == null || deck.length == 0) return -1;
        int n = deck.length;

        // find position of card 1
        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (deck[i] == 1) { pos = i; break; }
        }
        if (pos == -1) return -1; // should not happen for valid input, but safe

        // check if rotation by pos produces [1,2,...,n]
        for (int i = 0; i < n; i++) {
            int expected = i + 1;
            int actual = deck[(pos + i) % n];
            if (actual != expected) return -1;
        }

        return pos; // minimal k is index of 1
    }

    // quick tests
    public static void main(String[] args) {
        int[] deck1 = {1, 4, 2, 3};
        System.out.println(solution(deck1)); // -1

        int[] deck2 = {3, 4, 5, 1, 2};
        System.out.println(solution(deck2)); // 3

        int[] deck3 = {1,2,3,4,5};
        System.out.println(solution(deck3)); // 0

        int[] deck4 = {2,3,4,5,1};
        System.out.println(solution(deck4)); // 4
    }
}
