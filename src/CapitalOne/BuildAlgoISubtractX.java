package CapitalOne;

public class BuildAlgoISubtractX {

    public static void main(String[] args) {
        int[] numbers = {3,3,5,2,3};
        System.out.println(BuildAlgoISubtractX.solution(numbers));
    }


    static int solution(int[] numbers) {
        int n = numbers.length;
        int result = 0;

        while (true) {
            // Step 1: find leftmost non-zero element
            int i = 0;
            while (i < n && numbers[i] == 0) i++;

            // if none exists, finish
            if (i == n) break;

            int x = numbers[i];

            // Step 2: starting from i, subtract x while possible
            for (int j = i; j < n; j++) {
                if (numbers[j] < x) break;   // can't subtract further, go to step 3
                numbers[j] -= x;
            }

            // Step 3: add x to final result
            result += x;

            // Step 4: repeat
        }

        return result;
    }
}
