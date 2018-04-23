package java;

/**
 * Created by haileyyin on 4/22/18.
 */
public class ExcelSheetColumnTitle {
    /*
    十进制转26进制

    n=1  A 65 remainder=0 n=0
    n=26 Z 90
    */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            int remainder = (n-1)%26;
            sb.append(Character.toString ((char)(65+remainder)));
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }
}
