package java;

/**
 * Created by haileyyin on 11/9/17.
 */
public class LongestPalindromicSubstring {
    /*
    one for loop
    iterate the string, and extent palindrome for both odd and even length from each index, and compare the length.

    Time Limit Exceeded
     */
    public String longestPalindrome1(String s) {
        String res = new String();
        for(int i=0; i<s.length(); i++){
            String temp1 = extendPalindrome1(s, i, i); //odd length palindrome
            res = (temp1.length()>res.length())?temp1:res;
            String temp2 = extendPalindrome1(s, i, i+1); //even length palindrome
            res = (temp2.length()>res.length())?temp2:res;
        }
        return res;
    }

    private String extendPalindrome1(String s, int left, int right){
        String temp = new String();
        while (left>=0 &&right<s.length()&&s.charAt(left)==s.charAt(right)){
            temp = s.substring(left, right+1);
            left--;
            right++;
        }
        return temp;
    }

    /*
    update
    keep track of the index during the process, and cut from the string at the last step
     */
    int lo = 0;
    int maxLen = 0;
    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;

        for(int i=0; i<s.length(); i++){
            extendPalindrome(s, i, i); //odd length palindrome
            extendPalindrome(s, i, i+1); //even length palindrome
        }
        return s.substring(lo, lo+maxLen);
    }

    private void extendPalindrome(String s, int left, int right){
        while (left>=0 &&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if(right-left-1>maxLen){
            maxLen = right-left-1;
            lo = left+1;
        }
    }
}
