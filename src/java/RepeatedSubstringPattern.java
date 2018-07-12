package java;

/**
 * Created by haileyyin on 7/8/18.
 */
public class RepeatedSubstringPattern {
    /*
    Time: O(n^2)
     */
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.length()%(i+1) != 0) {
                continue;
            }
            String subStr = s.substring(0, i + 1);
            int j = i + 1;
            while (j < s.length()) {
                if (!s.substring(j, j + i + 1).equals(subStr)) {
                    break;
                }
                j = j + i + 1;
            }
            if (j >= s.length())
                return true;
        }
        return false;
    }
}
