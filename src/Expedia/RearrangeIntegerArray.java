package Expedia;

import java.util.*;
public class RearrangeIntegerArray {

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(7,8,6,5);
        List<Integer> result = rearrange(elements);
        for (int num : result) {
            System.out.println(num);
        }
    }

    public static List<Integer> rearrange(List<Integer> elements) {
        if (elements == null || elements.size() <= 1) return elements;
        elements.sort((a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);
            if (bitA != bitB)
                return Integer.compare(bitA, bitB);
            return Integer.compare(a, b);
        });
        return elements;
    }
}
