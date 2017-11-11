package java;

/**
 * Created by haileyyin on 11/9/17.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int n = s.length();
        char[] c = s.toCharArray();
        StringBuilder[] builder = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            builder[i] = new StringBuilder();
        }
        int idx=0;
        while(idx<n){
            for(int row=0; row<numRows && idx<n; row++){ // vertically down
                builder[row].append(c[idx++]);
            }
            for(int row=numRows-2; row>0 && idx<n; row--){ // obliquely up
                builder[row].append(c[idx++]);
            }
        }
        for(int i=1; i<numRows; i++){
            builder[0].append(builder[i]);
        }
        return builder[0].toString();
    }
}
