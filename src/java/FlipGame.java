package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 3/29/18.
 */
public class FlipGame {
    /*
    brutal force:

    Dynamic programming
    1:   true
    2:   true
    3:   true
    4:   4/2=2...0 dp[2]=true
    5:   true
    6:   6/2=3...0 true
    7:   7/2=3...1 7/3=2...1 7/5=1...2 false
    8:   8/2=4...0 dp[4]=true
    9:   9/3=3...0 dp[3]=true
    10:  10/2=5 dp[5]=true
    11:  11/2=5...1 11/3=3...2 11/5=2...1 false
    12:  12/2=6...0 dp[6]=true
    13:  13/2=6...1 13/3=4...1 13/5=2...3 false
    14:  14/2=7...0 dp[7]=false

    Memory Limit Exceeded.
    */
    public boolean isUgly(int num) {
        if(num<=0)
            return false;
        if(num<=5)
            return true;
        int[] dp = new int[num+1];
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=1;
        dp[5]=1;
        for(int i=6; i<=num; i++){
            if(i%2==0){
                dp[i] = dp[i/2];
            } else if(i%3==0){
                dp[i] = dp[i/3];
            } else if(i%5==0){
                dp[i] = dp[i/5];
            }
        }
        return dp[num]==1;
    }
    /*
    Just divide by 2, 3 and 5 as often as possible and then check whether we arrived at 1.
     */
    public boolean isUgly2(int num) {
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }
}
