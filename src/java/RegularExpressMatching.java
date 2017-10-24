package java;

/**
 * Created by haileyyin on 10/23/17.
 */
public class RegularExpressMatching {
    /*
    several conditions:
    1. s[i] == p[j]: dp[i][j] = dp[i-1][j-1]
    2. p[j] == ".": dp[i][j] = dp[i-1][j-1]
    3. p[j] == "*":
           if p[j-1] != s[i]: dp[i][j] = dp[i][j-2]
           if p[j-1] == s[i]:
                         dp[i][j] = dp[i][j-2] // a* counts as empty
                     or  dp[i][j] = dp[i][j-1] // a* counts as single a
                     or  dp[i][j] = dp[i-1][j] // a* counts as multiple a
     */

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<p.length(); j++){
                if(p.charAt(j)==s.charAt(i) || p.charAt(j)=='.'){
                    dp[i+1][j+1] = dp[i][j];
                } else if(p.charAt(j)=='*'){
                    if(p.charAt(j-1)!=s.charAt(i) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j-1]||dp[i+1][j]||dp[i][j+1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
