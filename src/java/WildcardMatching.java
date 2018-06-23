package java;

/**
 * Created by haileyyin on 6/13/18.
 */
public class WildcardMatching {
    /*
    Dynamic Programming:

    base case:
    - s == "" && p == ""
    - only one chatacter in either s and p

    notation: M[i, j] is the boolean result that whether string s[0..i] is matched with string p[0..j]
    recursive rule:
    - M[i,j] = true, if:
               p == "*" && (M[i-1,j-1] || M[i-1, j] || M[i, j-1]
               p == "?" && M[i-1,j-1]
               p == letter && s.charAt(i) == p.charAt(j) && M[i-1, j-1]
    - M[i,j] = false, otherwise
    */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] M = new boolean[m+1][n+1];
        // initialization
        M[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (M[0][i-1]&&p.charAt(i-1)=='*') {
                M[0][i] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*') {
                    M[i][j] = M[i-1][j-1] || M[i-1][j] || M[i][j-1];
                } else if (p.charAt(j-1) == '?') {
                    M[i][j] = M[i-1][j-1];
                } else {
                    M[i][j] = s.charAt(i-1) == p.charAt(j-1) && M[i-1][j-1];
                }
            }
        }
        return M[m][n];
    }

    /*
    Time Limit Exceeded:  recursion

    base case:
    - s == "" && p == ""
    - only one chatacter in either s and p

    notation: M[i, j] is the boolean result that whether string s[i...m] is matched with string p[j...n]
    recursive rule:
    - M[i,j] = true, if:
                   p == "*" && (M[i+1,j] == true || M[i+1, j+1] || M[i+2, j+1] ... || M[m, j+1])
                   p == "?" && M[i+1,j+1]
                   p == letter && s.charAt(i) == p.charAt(j) && M[i+1, j+1]
    - M[i,j] = false, otherwise
    */
    public boolean isMatch2(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        } else if (s.length() == 0 && p.length() != 0) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        } else if (s.length() != 0 && p.length() == 0) {
            return false;
        }

        if (p.charAt(0) == '*') {
            for (int i = 1; i <= s.length(); i++) {
                if (isMatch(s.substring(i), p.substring(1)) )
                    return true;
            }
            return isMatch(s, p.substring(1));
        } else if (p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return p.charAt(0) == s.charAt(0) && isMatch(s.substring(1), p.substring(1));
        }
    }
}
