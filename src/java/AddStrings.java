package java;

/**
 * Created by haileyyin on 1/27/18.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int m = c1.length-1;
        int n = c2.length-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(m>=0 && n>=0){
            int temp = Character.getNumericValue(c1[m])+Character.getNumericValue(c2[n])+carry;
            sb.insert(0, temp%10);
            carry = temp/10;
            m--;
            n--;
        }
        if(m>=0){
            while(m>=0){
                int temp = Character.getNumericValue(c1[m])+carry;
                sb.insert(0, temp%10);
                carry = temp/10;
                m--;
            }
        } else if(n>=0){
            while(n>=0){
                int temp = Character.getNumericValue(c2[n])+carry;
                sb.insert(0, temp%10);
                carry = temp/10;
                n--;
            }
        }
        if(carry!=0)
            sb.insert(0, carry);
        return sb.toString();
    }
}
