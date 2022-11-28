package _017_intoroman;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman2(1994));

    }

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

    public String intToRoman2(int num) {
        int[] ints = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] chars = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        StringBuilder sb = new StringBuilder();
        //ArrayList<Character> list = new ArrayList<>();
        int tmp;
        for (int i = 0; i < 7; i++) {
            tmp = num / ints[i];
            if (tmp > 0) {
                if ((i == 2 || i == 4 || i == 6) && tmp == 4) {
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
}
