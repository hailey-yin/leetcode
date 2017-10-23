package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class TrappingRainWater {
    /*
    To find the trapped water at position I, we need to find the maximum value of the left elements of I and right elements of i.
    Assuming they are maxLeft[I] and maxRight[I]. The trapped water is min(maxLeft[I], maxRight[I])-A[I].
    We need to create two new array to separately record maxLeft and maxRight of each element.
     */
    public int trap(int[] A) {
        if (A.length == 0)
            return 0;
        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            maxLeft[i] = max;
            if (A[i] > max)
                max = A[i];
        }
        max = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            maxRight[i] = max;
            if (A[i] > max)
                max = A[i];
        }
        int ret = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int trap = Math.min(maxLeft[i], maxRight[i]) - A[i];
            if (trap > 0)
                ret += trap;
        }
        return ret;
    }
}
