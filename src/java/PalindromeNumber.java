package java;

/**
 * Created by haileyyin on 11/10/17.
 */
public class PalindromeNumber {
    /*
    空间复杂度O(1)
     */
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        long reverse = 0;
        int temp = x;
        while(x>0){
            reverse = reverse*10+x%10;
            x/=10;
        }
        return (reverse==temp);
    }
}
