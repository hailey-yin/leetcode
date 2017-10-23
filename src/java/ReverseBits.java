package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class ReverseBits {
    /*
    方法一：位运算
    先把十进制数转换成数组表示其二进制，再反向相加
     */
    public int reverseBits1(int n) {
        int w = Integer.SIZE;
        int[] count = new int[w];
        for(int i=0; i<w; i++){
            count[i] = (((n>>i)&1)==1)? 1:0;
        }
        //reverse add
        int res = 0;
        for(int i=0; i<w; i++){
            res += count[w-i-1]<<i;
        }
        return res;
    }
    /*
    Update: 从右向左把一位位取出来，添加到新生成的整数的最低位即可。
     */
    // Time Complexity: O(logn), Space Complexity: O(1)
    public int reverseBits2(int n) {
        int res = 0;
        for(int i=0; i<32; i++){
            if((n&1)==1){
                res = (res<<1)+1;
            } else {
                res = (res<<1);
            }
            n=n>>1;
        }
        return res;
    }
    /*
    方法二：左右不断交换位，直到相遇。
     */
    // Time Complexity: O(logn), Space Complexity: O(1)
    // you need treat n as an unsigned value
    public int reverseBits3(int n) {
        int left = 0;
        int right = 31;
        while (left < right) {
            // swap bit
            int x = (n >> left) & 1;
            int y = (n >> right) & 1;

            if (x != y) {
                n ^= (1 << left) | (1 << right);
            }
            ++left;
            --right;
        }
        return n;
    }
}
