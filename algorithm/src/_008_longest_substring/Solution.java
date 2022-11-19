package _008_longest_substring;


import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        char[] chars = new char[128];
        System.out.println(chars.length);
    }

    /**
     * 4ms
     * @param s
     * @return
     */
    public int maxLong(String s) {
        if (s == null || s.length() == 0) return 0;
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = sb.indexOf(s.substring(i, i + 1));//String.valueOf(s.charAt(i))
            if (index != -1) {
                sb.delete(0, index + 1);
            }
            sb.append(s.charAt(i));
            max = Math.max(max, sb.length());
        }
        return max;
    }

    /**
     * 40ms arrayList 太慢了
     * @param s
     * @return
     */
    public int maxLong2(String s) {
        if (s == null || s.length() == 0) return 0;
        ArrayList<Character> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = list.indexOf(s.charAt(i));
            if (index != -1) {
                //sb.delete(0, index + 1);
                list.removeAll(list.subList(0, index + 1));
            }
            //sb.append(s.charAt(i));
            list.add(s.charAt(i));
            max = Math.max(max, list.size());
        }
        return max;
    }

    /**
     * 1ms
     * 要点:
     *  1. char本质是数字, 所以char可以作为数组的索引
     *  2. 判断布尔数组的值
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        boolean[] vis = new boolean[128];
        int l = 0, ans = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (!vis[c]) {
                vis[c] = true;
            } else {
                while (s.charAt(l) != c) vis[s.charAt(l++)] = false;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

}
