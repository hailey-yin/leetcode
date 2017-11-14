package java;

/**
 * Created by haileyyin on 11/13/17.
 */
public class DivideTwoIntegers {
    /*
    time limit exceeded
     */
    public int divide1(int dividend, int divisor) {
        int sign = 1;
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)){
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        //corner case
        if(ldivisor == 0){
            return Integer.MAX_VALUE;
        }
        if(ldividend == 0 || ldividend<ldivisor){
            return 0;
        }

        long lans = 0;
        int ans = 0;
        while(ldividend>=ldivisor){
            ldividend -= ldivisor;
            lans += 1;
        }
        if(lans > Integer.MAX_VALUE){
            return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        } else {
            ans = (int)(sign*lans);
        }
        return ans;
    }

    /*
    乘法二分法
    通过移位依次找到最大的2的幂数x使得 dividend < divisor*2^x
    32 ~ 3*10 = 3*[1*(2^3) + 0*(2^2) + 1*(2^1) + 0*(2^0)]
     */
    public int divide2(int dividend, int divisor) {
        int sign = 1;
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)){
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        //corner case
        if(ldivisor == 0){
            return Integer.MAX_VALUE;
        }
        if(ldividend == 0 || ldividend<ldivisor){
            return 0;
        }

        long lans = 0;
        int i = 0 ;
        while(ldividend >= ldivisor<<(i+1)){
            i++;
        }
        while(ldividend>=ldivisor){
            if(ldividend >= ldivisor<<i){
                ldividend -= ldivisor<<i;
                lans += (long)1<<i;
            }
            i--;
        }

        if(lans > Integer.MAX_VALUE){
            return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return (int)(sign*lans);
    }
}
