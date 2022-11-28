package _017_intoroman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.intToRoman2(1994);
        System.out.println(s);
        int i = solution.romanToInt2(s);
        System.out.println(i);

    }

    //数字转罗马
    public String intToRoman(int num) {
        int[] ints = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] chars = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        //StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        int tmp;
        for (int i = 0; i < ints.length; i++) {
            tmp = num / ints[i];
            if (tmp > 0) {
                if ((i == 2 || i == 4 || i == 6) && tmp == 4) {
                    //sb.append(chars[i]).append(chars[i - 1]);
                    list.add(chars[i]);
                    if (list.contains(chars[i - 1])) {
                        list.remove(Character.valueOf(chars[i - 1])); //不加valueOf,char会转成int(index)
                        list.add(chars[i - 2]);
                    } else {
                        list.add(chars[i - 1]);
                    }
                } else {
                    for (int j = 0; j < tmp; j++) {
                        //sb.append(chars[i]);
                        list.add(chars[i]);
                    }
                }
                num = num % ints[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    /**
     * 数字转罗马
     * 少用arraylist, 真的很慢
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
        int[] ints = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] chars = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        StringBuilder sb = new StringBuilder();
        //ArrayList<Character> list = new ArrayList<>();
        int tmp;
        for (int i = 0; i < 7; i++) {
            tmp = num / ints[i];
            if (tmp > 0) {
                //i == 2 || i == 4 || i == 6
                if ((i % 2 == 0) && tmp == 4) {
                    //sb.append(chars[i]).append(chars[i - 1]);
                    sb.append(chars[i]);
                    if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == chars[i - 1]) {
                        sb.delete(sb.length() - 2, sb.length() - 1);
                        sb.append(chars[i - 2]);
                    } else {
                        sb.append(chars[i - 1]);
                    }
                } else {
                    for (int j = 0; j < tmp; j++) {
                        //sb.append(chars[i]);
                        sb.append(chars[i]);
                    }
                }
                num = num % ints[i];
            }
        }
        return sb.toString();
    }

    /**
     * 罗马转数字
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int[] ints = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] chars = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        char[] ss = s.toCharArray(); // toCharArray遍历比charAt遍历效率高!!!
        int[] res = new int[ss.length];
        int i = 0, j = 0;
        while (i < ss.length && j < 7) {
            if (ss[i] == chars[j]) {
                res[i] = ints[j];
                if (i + 1 < ss.length && j >= 1) {
                    if (ss[i + 1] == chars[j - 1]) {
                        res[i] = -ints[j];
                        res[i + 1] = ints[j - 1];
                        i += 2;
                        continue;
                    } else if (j >= 2 && ss[i + 1] == chars[j - 2]) {
                        res[i] = -ints[j];
                        res[i + 1] = ints[j - 2];
                        i += 2;
                        continue;
                    }
                }
                i++;
            } else {
                j++;
            }
        }
        int result = 0;
        for (int re : res) {
            result += re;
        }
        return result;
    }

    public int romanToInt2(String s) {
        int[] ints = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] chars = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] res = new int[s.length()];
        int i = 0, j = 0;
        while (i < s.length() && j < 7) {
            if (s.charAt(i) == chars[j]) {
                res[i] = ints[j];
                if (i + 1 < s.length() && j >= 1) {
                    if (s.charAt(i + 1) == chars[j - 1]) {
                        res[i] = -ints[j];
                        res[i + 1] = ints[j - 1];
                        //i++;
                        i += 2;
                        continue;
                    } else if (j >= 2 && s.charAt(i + 1) == chars[j - 2]) {
                        res[i] = -ints[j];
                        res[i + 1] = ints[j - 2];
                        //i++;
                        i += 2;
                        continue;
                    }
                }
                i++;
            } else {
                j++;
            }
        }
        int result = 0;
        for (int re : res) {
            result += re;
        }
        return result;
    }
}
