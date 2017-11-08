package java;

/**
 * Created by haileyyin on 11/7/17.
 */
public class PalindromicSubstrings {
    /*
    brutal forse
    two for loop
     */
    public int countSubstrings1(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(isPalindromic(s.substring(i,j+1))){
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isPalindromic(String s){
        boolean ans =  true;
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                ans = false;
                break;
            }
        }
        return ans;
    }

    /*
    one for loop
    start from each index and try to extend palindrome for both odd and even length
     */
    public int countSubstrings2(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            count = countPalindromic(s, i, i, count); //count palindromic of odd length
            count = countPalindromic(s, i, i+1, count); //count palindromic of even length
        }
        return count;
    }

    private int countPalindromic(String s, int left, int right, int count) {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
