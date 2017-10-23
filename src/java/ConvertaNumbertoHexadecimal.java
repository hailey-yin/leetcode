package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class ConvertaNumbertoHexadecimal {
    /*
    直接将num当做二进制的数字去处理，然后每4位映射一次就好,然后逻辑位移就好
     */
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            sb.append(map[(num & 15)]);
            num = (num >>> 4);
        }
        sb.reverse();
        return sb.toString();
    }
}
