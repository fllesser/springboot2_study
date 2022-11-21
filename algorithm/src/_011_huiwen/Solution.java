package _011_huiwen;

/**
 * 找出一个字符串最长的回文子串
 */
public class Solution {

    public static void main(String[] args) {
        Integer i2 = new Integer(40);
        Integer i1 = 40;

        System.out.println(i1==i2);
    }

    /**
     * 如果一个字符串s本身是回文串，那么它的最长回文子串就是它自己。就不用接着遍历了。
     * 如果不是，那么取len= s.length() - 1, 然后遍历所有长度等于len的子串，如果哪个子串是回文串，就不用接着遍历了。
     * 如果还没找到，则len = len - 1, 取所有长度为len的子串继续遍历。
     * 依次类推，直到len等于0为止。（子串长度len等于1的时候，就无论如何都找到了）
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int left, right;
        int divide = s.length();
        while (divide > 0) {
            for (int i = 0; i + divide <= s.length(); i++) {
                left = i;
                right = i + divide - 1;
                boolean isTrueString = isValid(s, left, right);
                if (isTrueString) {
                    return s.substring(left, right + 1);
                }
            }
            divide--;
        }
        return s;
    }

    private boolean isValid(String s, int left, int right) {
        int length = s.length();
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
