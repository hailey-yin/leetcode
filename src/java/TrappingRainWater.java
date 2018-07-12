package java;

import java.util.Stack;

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
    /*
     if we want to find out how much water on a bar(bot), we need to find out the left larger bar's index (il),
     and right larger bar's index(ir), so that the water is (min(A[il],A[ir])-A[bot])*(ir-il-1), use min since only the lower boundary can hold water,
     and we also need to handle the edge case that there is no il.

     use a stack that store the indices with decreasing bar height, one we find a bar who's height is larger, then
     let the top of the stack be bot, the cur bar is if, and the previous bar is l.
     */
    public int trap1(int[] A) {
        if (A == null) {
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        int i = 0, max = 0, maxBot = 0;
        while (i < A.length) {
            if (s.isEmpty() || A[i] <= A[s.peek()]) {
                s.push(i++);
            } else {
                int bot = s.pop();
                if (s.isEmpty()) {
                    maxBot = 0;
                } else {
                    maxBot = (Math.min(A[s.peek()], A[i]) - A[bot]) * (i - s.peek() - 1);
                }
                max += maxBot;
            }
        }
        return max;
    }
}
