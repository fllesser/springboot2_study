package _009_ones_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ONES面试算法题 2022-11-19
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 没写完
     */
    public void twoQuestion() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), m, n;
        StringBuilder sb1, sb2;
        for (int i = 0; i < t + 1; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            sb1 = new StringBuilder();
            sb2 = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb1.append(sc.nextLine());
            }
            for (int j = 0; j < n; j++) {
                sb2.append(sc.nextLine());
            }

        }
    }

    /**
     * 合法单词: 辅音字母不相邻
     * 一个字符串中能组成的合法单词的最长长度
     */
    public void longestWord() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // 可以用布尔数组
        List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                count++;
            }
        }
        System.out.println(Math.min(s.length(), count * 2 + 1));
    }
}
