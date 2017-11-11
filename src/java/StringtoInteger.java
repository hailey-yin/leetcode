package java;

/**
 * Created by haileyyin on 11/9/17.
 */
public class StringtoInteger {
    /*
    be aware of four cases:
    - discards all leading whitespaces
    - sign of the number
    - overflow
    - invalid input
     */
    public int myAtoi(String str) {
        long res = 0;
        char[] c = str.toCharArray();
        int sign = 1;
        int idx = 0;
        //1. Empty string
        if(str.length()==0)
            return 0;
        //2. Remove Spaces
        while(c[idx]==' '&&idx<c.length){
            idx++;
        }
        //3. Handle signs
        if (c[idx] == '-' || c[idx] == '+') {
            sign = (c[idx++] == '-')?-1:1;
        }
        //4. Convert number and avoid overflow
        for(int i=idx ;i<c.length; i++){
            if(c[i] >= '0' && c[i]<='9'){
                res = res*10+Character.getNumericValue(c[i]);
                if(res>Integer.MAX_VALUE){
                    if(sign==1)
                        return Integer.MAX_VALUE;
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return (int)res*sign;
    }
}
