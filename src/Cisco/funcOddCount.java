package Cisco;

import java.util.*;
import java.lang.*;
import java.io.*;
public class funcOddCount {

    public static void  funcOddCount(int[] inputArr)
    {
        // Write your code here
        Set<Integer> odd = new HashSet<>();
        for(int i : inputArr){
            if(!odd.add(i)){
                odd.remove(i);
            }
        }
        System.out.println(odd.size());
    }

    public static void main(String[] args)
    {
        int inputArr[] = {4,8,2,8,9};
        funcOddCount(inputArr);
    }
}
