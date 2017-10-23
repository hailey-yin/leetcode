package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class PowerofTwo {
    /*
    我们来看power of two的数有什么规律：
    0：0000
    2：0010
    4：0100
    8：1000
    …
    即，所有的二进制位只有1位为0.
     */

    /*
    方法一：计算1的个数
     */
    public boolean isPowerOfTwo1(int n) {
        if(n<=0)
            return false;
        int count = 0;
        for(int i=0; i<31; i++){
            if(((n>>i)&1)==1){
                count++;
            }
        }
        if(count==1){
            return true;
        }
        return false;
    }
    /*
    方法二：如果一个数是2的幂，则它的二进制最高位必然为1，其余为0，此时如果我们减1的话，最高位降为0，其余位变为1，如果把两个数按位与，结果必然为0。
     */
    // Power of Two
    // Time Complexity: O(1), Space Complexity: O(1)
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
