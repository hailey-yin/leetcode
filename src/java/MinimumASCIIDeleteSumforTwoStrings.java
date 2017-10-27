package java;

/**
 * Created by haileyyin on 10/26/17.
 */
public class MinimumASCIIDeleteSumforTwoStrings {
    /*
    comparing the first characters of two strings ：
    1. equal
    2. unequal:
       - delete the first character of s1, find the minimum delete sum of s1[1,n] and s2
       or
       - delete the first character of s1, find the minimum delete sum of s1 and s2[1,m]
     */
    public int minimumDeleteSum1(String s1, String s2) {
        if(s1.length()==0)
            return ascii(s2);
        if(s2.length()==0)
            return ascii(s1);
        if(s1.charAt(0)==s2.charAt(0)){
            return minimumDeleteSum1(s1.substring(1), s2.substring(1));
        } else {
            return Math.min(minimumDeleteSum1(s1, s2.substring(1))+ascii(s2.substring(0,1)),minimumDeleteSum1(s1.substring(1), s2)+ascii(s1.substring(0,1)));
        }
    }

    private int ascii(String s){
        int res = 0;
        for(int i=0; i<s.length(); i++){
            res += (int)s.charAt(i);
        }
        return res;
    }

    /*
    dp[i][j] stands for the minimum delete sum of s1[0,i-1] and s2[0,j-1]
    dp[i][j] =
              dp[i-1][j-1]                               //s1[i-1]==s2[j-1]
              dp[i-1][j-1]+ascii(s1[i])+ascii(s2[j])     //s1[i-1]!=s2[j-1]
           or dp[i-1][j]+ascii(s1[i])
           or dp[i][j-1]+ascii(s2[j])
     */
    public int minimumDeleteSum2(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<=s1.length(); i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for(int j=1; j<=s2.length(); j++){
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int count1 = (int)s1.charAt(i-1);
                    int count2 = (int)s2.charAt(j-1);
                    dp[i][j] = Math.min(dp[i-1][j]+count1, dp[i][j-1]+count2);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+count1+count2);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
