package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class PowerofFour {
    /*
    我们来看power of four的数有什么规律：
    0：    00000
    4：    00100
    16:    10000
    …
    即，所有的二进制位只有1位为0，且在第1，3，5，7，...奇数位上
     */

    /*
    方法一：暴力
     */
    public boolean isPowerOfFour1(int num) {
        while(num>0){
            if(num==1) return true;
            if(num%4!=0){
                return false;
            }else{
                num=num/4;
            }
        }
        return false;
    }
    /*
    方法二：位运算
     */
    public boolean isPowerOfFour(int num) {
        int count = 0;
        int index = 0;
        for(int i=0; i<32; i++){
            if(((num>>i)&1)==1){
                if(count==0){
                    count++;
                    index = i+1;
                } else {
                    return false;
                }
            }
        }
        if(index%2==1){
            return true;
        }
        return false;
    }
}
