package _015_huiwennum;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        int x = 123123123;
        System.out.println(Integer.reverse(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x <= 9) return true;
        String s = String.valueOf(x);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;

    }
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        ArrayList<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);

    }

    public boolean isPalindrome4(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1; //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome5(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isPalindrome6(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        //先找到第六位
        ArrayList<Integer> list = new ArrayList<>(5);
        int tmp = x;
        for (int i = 0; i < 5; i++) {
            list.add(tmp % 10);
            if (tmp > 1) {
                tmp /= 10;
            } else {
                break;
            }
        }
        if (!list.contains(tmp % 10)) return false;
        tmp = 0;
        for (int i = 0; i < 5; i++) {
            tmp = list.get(i) + tmp;
            tmp *= 10;
            if (x == tmp) return true;
        }
        return false;
    }

}
