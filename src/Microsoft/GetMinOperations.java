package Microsoft;

public class GetMinOperations {
    public static int getMinOperations(long n) {
        int operations = 0;

        while (n > 0) {

            // If n becomes 1, only one operation needed
            if (n == 1) {
                operations++;
                break;
            }

            // If even, just shift right (divide by 2)
            if ((n & 1) == 0) {
                n >>= 1;
            } else {
                // odd number
                // choose +1 or -1 optimally
                if (n == 3 || (n & 3) == 1) {
                    // subtract 1
                    operations++;
                    n = (n - 1) >> 1;
                } else {
                    // add 1
                    operations++;
                    n = (n + 1) >> 1;
                }
            }
        }

        return operations;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(GetMinOperations.getMinOperations(21L));
    }

}
