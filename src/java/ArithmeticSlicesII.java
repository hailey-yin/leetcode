package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haileyyin on 2/7/18.
 */
public class ArithmeticSlicesII {
    /*
    Time O(N^2), Space O(N^2)

    T(i, d), which denotes the total number of arithmetic subsequence slices ending at index i with difference d.
    Base case: T(0, d) = 0 (This is true for any d).
    Recurrence relation: T(i, d) = summation of (1 + T(j, d)) as long as 0 <= j < i && d == A[i] - A[j].
     */
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length];

        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int)diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }

        return res;
    }
}
