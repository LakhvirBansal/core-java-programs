package caspex;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FactorialChallenge {

    public static List<Integer> solve(int m, int n) {
        List<Integer> result = new ArrayList<>();
        List<Integer> valid = new ArrayList<>();

        for (int i = m; i <= n; i++) {
            BigInteger factorial = BigInteger.ONE;
            for (int j = 2; j <= i; j++) {
                factorial = factorial.multiply(BigInteger.valueOf(j));
            }

            char firstChar = factorial.toString().charAt(0);
            if (firstChar == '2' || firstChar == '4' || firstChar == '6' || firstChar == '8') {
                valid.add(i);
            }
        }

        if(valid.size() == 0){
            result.add(0);
        } else {
            result.addAll(valid);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> output = solve(1,10);
        System.out.println("output is :"+output);
    }
}
