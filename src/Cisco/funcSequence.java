package Cisco;

public class funcSequence {

    public static void  funcSequence(int inputNum)
    {
        // Write your code here
        String s = Integer.toString(inputNum);
        StringBuilder sb = new StringBuilder();
        int i = 0, n = s.length();
        while(i < n){
            char c = s.charAt(i);
            int j = i + 1;
            while(j < n && s.charAt(j) == c)
                j++;
            sb.append(j - i).append(c);
            i = j;
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args)
    {
        // input for inputNum
        int inputNum = 225;
        funcSequence(inputNum);
    }
}
