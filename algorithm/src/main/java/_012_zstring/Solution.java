package _012_zstring;

import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.UIManager.getString;

/**
 * 你妹的一个z形变换做了两个小时
 */
public class Solution {

    public static void main(String[] args) {
        String palatalising = new Solution().convert2("ABCDEFGHIJKLMN", 4);
        System.out.println(palatalising);
        StringBuilder[] sbs = new StringBuilder[2];

        Arrays.fill(sbs, new StringBuilder()); // 填充引用类型, 填充的是对象的引用
        sbs[0].append("123123");
        sbs[1].append("123123");
        System.out.println(Arrays.toString(sbs));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= 2) return s;
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int left = 0;
        for (int i = 0; i < s.length(); i += 2 * numRows - 2) {
            for (int j = i; j < i + numRows; j++) {
                if (j == s.length()) return getString1(list);
                list.get(left++).append(s.charAt(j));
            }
            left -= 2;
            for (int j = i + numRows; j < i + 2 * numRows - 2; j++) {
                if (j == s.length()) return getString1(list);
                list.get(left--).append(s.charAt(j));
            }
        }
        return getString1(list);
    }

    public String getString1(ArrayList<StringBuilder> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1 || s.length() <= 2) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int left = 0;
        for (int i = 0; i < s.length(); i += 2 * numRows - 2) {
            for (int j = i; j < i + numRows; j++) {
                if (j == s.length()) return getString2(sbs);
                sbs[left++].append(s.charAt(j));
            }
            left -= 2;
            for (int j = i + numRows; j < i + 2 * numRows - 2; j++) {
                if (j == s.length()) return getString2(sbs);
                sbs[left--].append(s.charAt(j));
            }
        }
        return getString2(sbs);
    }

    public String convert3(String s, int numRows) {
        if (numRows == 1 || s.length() <= 2) return s;
        if (numRows == 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += 2) {
                sb.append(s.charAt(i));
            }
            for (int i = 1; i < s.length(); i += 2) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int left = 0, flag = 1;
        for (int i = 0; i < s.length(); i += 2 * numRows - 2) {
            for (int j = i; j < i + 2 * numRows - 2; j++) {
                if (j == s.length()) return getString(sbs);
                if (left == numRows) {
                    flag = -1;
                    left = left - 2;
                } else if (left == 0) {
                    flag = 1;
                }
                sbs[left].append(s.charAt(j));
                left += flag;
            }
        }
        return getString(sbs);
    }

    public String getString2(StringBuilder[] sbs) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(sbs).forEach(sb::append);
        return sb.toString();
    }

}