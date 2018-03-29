package java;

/**
 * Created by haileyyin on 3/22/18.
 */
public class SubmissionDetail {
    /*
    Dynamic Programming
    dp[i,j] denotes the boolean result of isSubsequence(s, t) where s starts from char i and t starts from char j
    dp[i,j] = dp[i,j+1] || dp[i+1,j+1]

    Recursion:
    stackoverflow when：
    s：leeeeetcode
    t：yyyyylyy...y
     */
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length())
            return false;
        if(s.length()==0)
            return true;
        char c1 = s.charAt(0);
        char c2 = t.charAt(0);
        if(c1==c2)
            return isSubsequence(s.substring(1, s.length()), t.substring(1, t.length()));
        if(c1!=c2)
            return isSubsequence(s, t.substring(1, t.length()));
        return false;
    }
    /*
    Iterationn
    */
    public boolean isSubsequence2(String s, String t) {
        if(s.length()>t.length())
            return false;
        if(s.length()==0||s==null)
            return true;
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j))
                i++;
            j++;
        }
        return i==s.length();
    }
}
