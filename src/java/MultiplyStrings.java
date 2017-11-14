package java;

/**
 * Created by haileyyin on 11/13/17.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] array = new int[m+n];

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int product = (num1.charAt(j)-'0')*(num2.charAt(i)-'0');
                int sum = array[i+j+1]+product;
                array[i+j] += sum/10;
                array[i+j+1] = sum%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i:array){
            if(!(sb.length()==0&&i==0)){
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
