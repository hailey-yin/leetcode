package java;

/**
 * Created by haileyyin on 1/26/18.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int length = num.length();
        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            if(!(c=='0'&&num.charAt(length-i-1)=='0')&&!(c=='1'&&num.charAt(length-i-1)=='1')&&!(c=='8'&&num.charAt(length-i-1)=='8')&&!(c=='6'&&num.charAt(length-i-1)=='9')&&!(c=='9'&&num.charAt(length-i-1)=='6'))
                return false;
        }
        return true;
    }
}
