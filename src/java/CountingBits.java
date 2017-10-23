package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class CountingBits {
    /*
    方法一：暴力计算
     */
    public int[] countBits1(int num) {
        int[] res = new int[num+1];
        for(int i=0; i<=num; i++){
            int count = 0;
            for(int j=0; j<32; j++){
                if(((i>>j)&1)==1){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
    /*
    方法二：找规律
    For number 2(10), 4(100), 8(1000), 16(10000), ..., the number of 1's is 1.
    Any other number can be converted to be 2^m + x. For example, 9=8+1, 10=8+2.
    The number of 1's for any other number is 1 + # of 1's in x.
     */
    public int[] countBits2(int num) {
        int[] result = new int[num+1];

        int p = 1; //p tracks the index for number x
        int pow = 1;
        for(int i=1; i<=num; i++){
            if(i==pow){
                result[i] = 1;
                pow <<= 1;
                p = 1;
            }else{
                result[i] = result[p]+1;
                p++;
            }

        }

        return result;
    }
}
