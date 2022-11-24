package _014_daiding;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.myAtoi("+-12");
        System.out.println(i);
        char x = 48;
        System.out.println(x);

    }

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        char tmp = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        if (tmp == '-' || tmp == '+' || (tmp >= 48 && tmp <= 57)) {
            sb.append(tmp);
        } else {
            return 0;
        }
        for (int i = 1; i < s.length(); i++) {
            tmp = s.charAt(i);
            if (tmp >= 48 && tmp <= 57) {
                sb.append(tmp);
            } else {
                break;
            }
        }
        s = sb.toString();
        boolean flag = s.equals("-") || s.equals("+") || s.length() == 0;
        long result;
        try {
            result =  flag ? 0 : Long.parseLong(sb.toString());
        } catch (Exception e) {
            return s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }
}
