package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 3/28/18.
 */
public class PerfectSquares {
    /*
    Dynamic programming
    1   1      res = 0,1
    2   1+1    res = 0,1,2
    3   1+1+1  res = 0,1,2,3
    4   4      res = 0,1,2,3,1
    5   4+1
    6   4+1+1
    7   4+1+1+1
    8   4+4
    9   9
    10  9+1
    11  9+1+1
    12  4+4+4
    13  4+9
    */
    public int numSquares(int n) {
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for(int i=0; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                res[i] = Math.min(res[i], res[i-j*j]+1);
            }
        }
        return res[n];
    }
}
