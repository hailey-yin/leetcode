package java;

/**
 * Created by haileyyin on 1/26/18.
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int length = s.length();
        for(int i=0; i<length/2; i++){
            char temp = c[i];
            c[i] = c[length-i-1];
            c[length-i-1] = temp;
        }
        return String.valueOf(c);
    }
}
