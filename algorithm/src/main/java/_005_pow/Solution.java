package _005_pow;

public class Solution {

    public double mypow(int x, int n) {
        return n >= 0 ? pow(x, n) : 1.0 / pow(x, -n);
    }

    public double pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
