package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class DecodeWays {
    /*
    dp: D(k) is defined as the total number of ways to decode substring X[1…k]
    Initialization:
       D(0) = 1
       D(1) = 1
    Recurrence Relation:
       D(k) = D(k-1) + D(k-2)
    Desired solution: D(n)
     */
    public int numDecodings(String s) {
        if (s.length()==0)
            return 0;
        int dp[]=new int[s.length()+1];
        dp[0]=1;
        if (s.charAt(0)=='0')
            dp[1]=0;
        else dp[1]=1;
        for (int i=2;i<=s.length();i++) {
            if (s.charAt(i - 1) == '0') {
                if (Integer.parseInt(s.substring(i - 2, i)) <= 26 && Integer.parseInt(s.substring(i - 2, i)) >= 10)
                    dp[i] = dp[i - 2] ;
                else return 0;
            } else {
                if (Integer.parseInt(s.substring(i - 2, i)) <= 26&&Integer.parseInt(s.substring(i - 2, i))>=10)
                    dp[i]=dp[i-1]+dp[i-2];
                else dp[i]=dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
