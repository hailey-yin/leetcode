package java;

/**
 * Created by haileyyin on 1/17/18.
 */
public class ValidPalindrome {
    static public boolean isPalindrome(String s) {
        if(s.length()==0)
            return true;
        char[] c = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(!isAlphanumeric(c[start])){
                start++;
                continue;
            }
            if(!isAlphanumeric(c[end])){
                end--;
                continue;
            }
            if((c[start]==c[end])||(c[start]>64&&c[end]>64&&((c[start]==c[end]+32)||(c[start]==c[end]-32)))){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    static private boolean isAlphanumeric(char c){
        if(c>47&&c<58)
            return true;
        if(c>64&&c<91)
            return true;
        if(c>96&&c<123)
            return true;
        return false;
    }
}
