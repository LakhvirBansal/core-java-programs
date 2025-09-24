package caspex;

import java.util.Arrays;
import java.util.List;

public class MoveAllZerosToEnd {

    public static List<Integer> solve(List<Integer> nums) {
        int pos = 0; // Position to place the next non-zero

        // First pass: move all non-zero elements to the front
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != 0) {
                nums.set(pos, nums.get(i));
                pos++;
            }
        }

        // Second pass: fill the rest with 0s
        while (pos < nums.size()) {
            nums.set(pos, 0);
            pos++;
        }

        return nums;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(0,1,2,3,0,5,6,7,0);
        List<Integer> moveNumsToEnd = solve(nums);
        for(int num : moveNumsToEnd){
            System.out.print(num +" ");
        }
    }

}
