package java;

/**
 * Created by haileyyin on 2/6/18.
 */
public class ArrangingCoins {
    /*
    The idea is about quadratic equation, the formula to get the sum of arithmetic progression is
    sum = (x + 1) * x / 2
    so for this problem, if we know the the sum, then we can know the x = (-1 + sqrt(8 * n + 1)) / 2

    ax²+bx+c=0（a≠0）sigma = b^2-4ab
    if sigma>=0, x1=(-b+sqrt(sigma))/2a x2=(-b-sqrt(sigma))/2a
    */
    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
