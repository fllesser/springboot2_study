package _003_count_prime_number;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */
public class Solution {

    /**
     * 暴力
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
    }
}
