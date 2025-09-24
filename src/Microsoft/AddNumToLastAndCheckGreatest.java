package Microsoft;

public class AddNumToLastAndCheckGreatest {

    public static boolean wouldBeLargest(int[] array, int i) {
        if (array == null || array.length == 0) return true;

        int lastElement = array[array.length - 1];
        int newValue = lastElement + i;

        for (int j = 0; j < array.length - 1; j++) {
            if (newValue <= array[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 5, 1, 6};
        int i = 2;
        System.out.println(wouldBeLargest(array1, i)); // Output: true

        int[] array2 = {10, 20, 30, 5};
        int i2 = 10;
        System.out.println(wouldBeLargest(array2, i2)); // Output: false
    }
}
