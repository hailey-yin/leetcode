package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 4/2/18.
 */
public class MinimumFactorization {
    /*
    分解出的因数一定是个位数字，即范围是[2, 9]。那我们就可以从大到小开始找因数，首先查找9是否是因数，是要能整除a，就是其因数，
    如果是的话，就加入到结果res的开头，a自除以9，我们用while循环查找9，直到取出所有的9，然后取8，7，6...以此类推，
    如果a能成功的被分解的话，最后a的值应该为1，如果a值大于1，说明无法被分解，返回true。
    最后还要看我们结果res字符转为整型是否越界，越界的话还是返回0
    Time: ?
    Space: ?
    */
    public int smallestFactorization(int a) {
        if(a==1)
            return 1;
        List<Integer> list = new LinkedList<>();
        for(int i=9; i>1; i--) {
            while(a%i==0){
                a /= i;
                list.add(0, i);
            }
        }
        if(a!=1)
            return 0;
        long res = 0;
        for(int i=0; i<list.size(); i++){
            res = res*10+list.get(i);
        }
        return res>Integer.MAX_VALUE?0:(int)res;
    }
}
