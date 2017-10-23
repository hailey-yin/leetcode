package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class InterleavingString {
    /*
    D(I,j) is defined as the boolean result of whether s3[0,…i+j] is formed by interleaving s1[0…i] and s2[0…j]
                    D(i-1,j) if s1[i-1]=s3[I+j-1]
    D(i,j) =        or
                    D(i,j-1) if s2[j-1]=s3[I+j-1]
     */

    /*
    方法一：递归，up to bottom
    Time Limit Exceeded
    */
    public boolean isInterleave1(String s1, String s2, String s3) {
        boolean res1 = false;
        boolean res2 = false;
        if(s1.equals("") && s2.equals("") && !s3.equals(""))
            return false;
        if(s1.equals("") && s2.equals("") && s3.equals(""))
            return true;
        if(s1.length()>0 && s3.length()>0 && s3.charAt(s3.length()-1)==s1.charAt(s1.length()-1))
            res1=isInterleave1(s1.substring(0,s1.length()-1),s2,s3.substring(0,s3.length()-1));
        if (res1==true) return true;
        if(s2.length()>0 && s3.length()>0 && s3.charAt(s3.length()-1)==s2.charAt(s2.length()-1))
            res2=isInterleave1(s1,s2.substring(0,s2.length()-1),s3.substring(0,s3.length()-1));
        return res2;
    }

    /*
    方法二：dp bottom to up
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        //initiate
        dp[0][0] = true;
        for(int i=1; i<=s1.length(); i++) {
            if(s1.charAt(i-1)==s3.charAt(i-1))
                dp[i][0] = dp[i-1][0];
        }
        for(int j=1; j<=s2.length(); j++) {
            if(s2.charAt(j-1)==s3.charAt(j-1))
                dp[0][j] = dp[0][j-1];
        }
        //dp
        if(s1.length()>0 && s2.length()>0){
            for(int i=1; i<=s1.length(); i++){
                for(int j=1; j<=s2.length(); j++){
                    dp[i][j] = (s1.charAt(i-1)==s3.charAt((i+j-1))&&dp[i-1][j])||(s2.charAt(j-1)==s3.charAt((i+j-1))&&dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
