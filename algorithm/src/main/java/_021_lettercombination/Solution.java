package _021_lettercombination;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("2548"));
        "23123".chars().forEach(c -> System.out.println(c - '0'));
        System.out.println("231".charAt(0) - '0');
        int[] test = new int[]{1, 2, 3};
        System.out.println(test["231".charAt(0) - '0']);
    }

    public List<String> letterCombinations(String digits) {
        String[] strChain = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> res = new ArrayList<>();
        int len = digits.length();
        String[] strs = new String[len];
        int[] charNum = new int[len];
        for (int i = 0; i < len; i++) {
            strs[i] = strChain[digits.charAt(i) - '0' - 2];
            charNum[i] = strs[i].length();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {

        }
        return res;
    }
}
