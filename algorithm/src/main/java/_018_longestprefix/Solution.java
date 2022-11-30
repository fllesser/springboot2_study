package _018_longestprefix;

public class Solution {


    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        char temp;
        for (int i = 0; i < strs[0].length(); i++) {
            temp = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || str.charAt(i) != temp) return sb.toString();
            }
            sb.append(temp);
        }
        return sb.toString();

    }
}