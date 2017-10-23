package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class Numberof1Bits {
    /*
    位运算

    n&(n-1)消除最右边的1
    n&(-n)取出最右边的1
     */
    public int hammingWeight(int n) {
        int res = 0;
        for(int i=0; i<32; i++){
            if(((n>>i)&1)==1)
                res++;
        }
        return res;
    }
}
