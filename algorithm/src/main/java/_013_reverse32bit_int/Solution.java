package _013_reverse32bit_int;

public class Solution {
    public static void main(String[] args) {
        int reverse = new Solution().reverse2(-2147483412);
        System.out.println(reverse);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        boolean signed = false;
        if (x < 0) {
            signed = true;
            x = Math.abs(x);
        }
        int len = (max + "").length();
        StringBuilder sb = new StringBuilder(x + "").reverse();
        if (sb.length() < len) return (signed ? -1 : 1) * Integer.parseInt(sb.toString());
        if (sb.length() == len) {
            char[] xChars = sb.toString().toCharArray();
            char[] mChars = (max + "").toCharArray();
            for (int i = 0; i < len; i++) {
                if (xChars[i] == mChars[i]) {
                    continue;
                }
                if (signed && i == len - 1) {
                    return xChars[i] == 56 ? 0 : -Integer.parseInt(sb.toString());
                }
                if (xChars[i] > mChars[i]) {
                    return 0;
                } else {
                    return (signed ? -1 : 1) * Integer.parseInt(sb.toString());
                }
            }
            return (signed ? -1 : 1) * Integer.parseInt(sb.toString());
        }
        return 0;
    }


    public int reverse2(int x) {
        boolean signed = false;
        if (x < 0) {
            signed = true;
            x = Math.abs(x);
        }
        StringBuilder sb = new StringBuilder(x + "").reverse();
        try {
            return (signed ? -1 : 1) * Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverse3(int x) {
        int sum = 0;
        while (x != 0) {
            int m = x % 10;
            if (sum > 214748364 || (sum == 214748364 && m >= 8)) {
                //此地若是用2^31,则会出现错误（2147483648）
                return 0;
            }
            if (sum < -214748364 || (sum == -214748364 && m < -8)) {
                return 0;
            }
            sum = sum * 10 + m;
            x /= 10;
        }
        return sum;
    }
}