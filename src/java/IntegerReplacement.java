package java;

/**
 * Created by haileyyin on 7/6/18.
 */
public class IntegerReplacement {
    /*
    when the number is even, it is obviously better to halve it
    when the number is odd, we need to thnk the following cases:
    (1)
     111011 -> 111010 -> 11101 -> 11100 -> 1110 -> 111 -> 1000 -> 100 -> 10 -> 1
     111011 -> 111100 -> 11110 -> 1111 -> 10000 -> 1000 -> 100 -> 10 -> 1
     + 1 is better
    (2) only exception
     11 -> 10 -> 1
     11 -> 100 -> 10 -> 1
     -1 is better

     solution:
     (1) if n is even, halve it
     (2) if n=3 or (n-1 has less 1's than n+1), decrement n.
     (3) otherwise, increment n.
     */
    public int integerReplacement(int n) {
        int ans = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                n--;
            } else {
                n++;
            }
            ans++;
        }
        return ans;
    }
}
