package Visa;

public class MonotonicSequence {

    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 3) return new int[0];

        int n = arr.length;
        int[] res = new int[n - 2];

        for (int i = 0; i <= n - 3; i++) {
            int a = arr[i], b = arr[i + 1], c = arr[i + 2];
            if ((a < b && b < c) || (a > b && b > c)) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    // quick test
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, -4, 5, 10};
        int[] out1 = solution(arr1); // expected [0,1,0,1]
        for (int v : out1) System.out.print(v + " ");
        System.out.println();

        int[] arr2 = {10, 10, 10, 10, 10};
        int[] out2 = solution(arr2); // expected [0,0,0]
        for (int v : out2) System.out.print(v + " ");
        System.out.println();
    }
}
