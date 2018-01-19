package java;

/**
 * Created by haileyyin on 1/17/18.
 */

public class ValidPalindromeII {
    /*
    Time Limit Exceeded
     */
    public boolean validPalindrome(String s) {
        if(ValidPalindrome.isPalindrome(s))
            return true;
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            sb.setCharAt(i, ' ');
            if(ValidPalindrome. isPalindrome(sb.toString()))
                return true;
            sb.setCharAt(i, temp);
        }
        return false;
    }
    /*
    update: all characters in string is alphanumberic
     */
    public boolean validPalindrome2(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
}