package Visa;

public class ContiguousSubArrayLessThanThreshold {

    public static int solution(int[] dataSizes, int threshold) {
        if (dataSizes == null || dataSizes.length == 0) return 0;
        int n = dataSizes.length;

        // build prefix sums (1-based indexing for convenience)
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) prefix[i] = prefix[i - 1] + dataSizes[i - 1];

        int best = 0;
        for (int l = 1; l <= n; l++) {
            long before = prefix[l - 1];
            long limit = (long) threshold + 2L * before;

            // binary search largest r in [l..n] with prefix[r] <= limit
            int low = l, high = n, far = l - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (prefix[mid] <= limit) {
                    far = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (far >= l) {
                int len = far - l + 1;
                if (len > best) best = len;
            }
        }

        return best;
    }

    // quick manual tests
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,4}, 5));          // expected 2
        System.out.println(solution(new int[] {8,5,6,1,4,1,9}, 5));    // expected 4
        System.out.println(solution(new int[] {}, 10));                // 0
        System.out.println(solution(new int[] {0,0,0}, 0));            // 3 (prefixs non-neg)
    }
}
