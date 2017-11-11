package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 11/9/17.
 */
public class ReverseInteger {
    /*
    无法解决溢出问题
     */
    public int reverse1(int x) {
        List<Integer> list = new LinkedList<>();
        int res = 0;
        int convert = 1;
        if(x<0){
            convert = -1;
            x *= convert;
        }
        while(x!=0){
            list.add(x%10);
            x /= 10;
        }
        for(int i=0; i<list.size(); i++){
            res = res*10 + list.get(i);
        }
        return res*convert;
    }

    /*
    判断溢出。如果出现溢出，原路返回得不到上一次的结果
     */
    public int reverse2(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    /*
    update
     */
    public int reverse3(int x) {
        boolean neg = x < 0;
        if (neg) x = -x;
        Long ans = 0l;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        if (ans > Integer.MAX_VALUE) return 0;
        return ans.intValue() * (neg ? -1 : 1);
    }
}
