package java;

/**
 * Created by haileyyin on 4/22/18.
 */
public class FactorialTrailingZeroes {
    /*
    Because all trailing 0 is from factors 5 * 2.

    But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors.
    In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.
    */

    /*
    iteration
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    /*
    recursion
     */
    public int trailingZeroes2(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
