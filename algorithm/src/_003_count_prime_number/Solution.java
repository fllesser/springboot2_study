package _003_count_prime_number;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(499979));
    }

    /**
     * 暴力
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int count = 1;
        for (int i = 3; i < n; i++) {
            boolean flag = true;
            if (i % 10 % 2 == 0) flag = false; // 个位能被2整除
            else {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) count++;
        }
        return count;
    }
}
