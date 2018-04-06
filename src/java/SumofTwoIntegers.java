package java;

/**
 * Created by haileyyin on 4/4/18.
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        if(b == 0){//没有进位的时候完成运算
            return a;
        }
        int sum,carry;
        sum = a^b;//完成第一步加法的运算
        carry = (a&b)<<1;//完成第二步进位并且左移运算
        return getSum(sum,carry);//
    }
}
