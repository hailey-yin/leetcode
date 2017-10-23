package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class BitwiseANDofNumbersRange {
    /*
    方法一：
    根据每一bit的变化频率来判断。
    第一位变化频率是1（每1个变化一次）
    第二位变化频率是2（每2个变化一次）
    第三位变化频率是4
    第n位变化频率是2^n。

    知道这个规律后，我们从低位依次往高位看。
    首先如果m和n之间的数大于当前位的变化频率，那AND的结果肯定是0.
    如果小于，我们再判断两个数的当前位是否都为1，如果是那AND的结果肯定是1，否则为0。
     */
    // Time Complexity: O(log n), Space Complexity: O(1)
    public int rangeBitwiseAnd1(int m, int n) {
        int distance = n-m+1;
        int res = 0;
        for(int i=0; i<32; i++){
            if(distance<=Math.pow(2,i)){
                if((((m>>i)&1)==1)&&(((n>>i)&1)==1)){
                    res += (1<<i);
                }
            }
        }
        return res;
    }
    /*
    方法二：
    N与它前一个不小于m的数取交集，每一次操作都能确定一位数。这道题相当于找高位相等的数
     */
    // Time Complexity: O(log n), Space Complexity: O(1)
    public int rangeBitwiseAnd2(int m, int n) {
        while (n > m) {
            n &= n - 1;
        }
        return m & n;
    }
}
