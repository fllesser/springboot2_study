package _003_count_prime_number;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(499979));
        System.out.println(bf(499979));
    }

    /**
     * 暴力
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
    }

    public static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
