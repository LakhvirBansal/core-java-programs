package CapitalOne;

public class OddOccuranceofDigitZero {

    public static void main(String[] args) {
        int[] arr = {4,50,100,65,2000, 700,1,10};
        System.out.println(solution(arr));
    }

    static int solution(int[] a) {
        int count = 0;

        for (int num : a) {
            int zeroCount = 0;

            // Special case: number itself is 0
            if (num == 0) {
                zeroCount = 1;
            } else {
                int temp = num;

                while (temp > 0) {
                    if (temp % 10 == 0) {
                        zeroCount++;
                    }
                    temp /= 10;
                }
            }

            // check if zero occurrences are odd
            if (zeroCount % 2 == 1) {
                count++;
            }
        }

        return count;
    }
}
