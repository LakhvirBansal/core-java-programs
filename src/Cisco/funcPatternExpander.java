package Cisco;

import java.util.*;
import java.lang.*;
public class funcPatternExpander {

    public static String  funcPatternExpander(String inputStr)
    {
        if(inputStr == null || inputStr.isEmpty())
            return "";
        inputStr = inputStr.trim();
        int n = inputStr.length();
        StringBuilder sb = new StringBuilder();
        Deque<StringBuilder> stack = new ArrayDeque<>();
        int i = 0;
        while(i < n){
            char c = inputStr.charAt(i);
            if(c == '('){
                stack.push(sb);
                sb = new StringBuilder();
                i++;
            } else if(c == ')'){
                i++;
                while(i < n && Character.isWhitespace(inputStr.charAt(i))){
                    i++;
                }
                int k = 1;
                if(i < n && inputStr.charAt(i) == '{'){
                    i++;
                    int val = 0;
                    while(i < n && Character.isDigit(inputStr.charAt(i))){
                        val = val * 10 + (inputStr.charAt(i) - '0');
                        i++;
                    }
                    k = val;
                    while(i < n && Character.isWhitespace(inputStr.charAt(i))){
                        i++;
                    }
                    if(i < n && inputStr.charAt(i) == '}')
                        i++;
                }
                String piece = sb.toString();
                StringBuilder repeated = new StringBuilder(piece.length() * Math.max(k, 0));
                for(int t = 0; t < k; t++){
                    repeated.append(piece);
                }
                sb = stack.pop().append(repeated);
            }
            else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        String result = funcPatternExpander("ababab");
        System.out.print(result);
    }
}
