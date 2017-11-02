package java;

/**
 * Created by haileyyin on 11/1/17.
 */
public class UglyNumber {
    /*
    把n里面的2,3,5 全部消掉，看最后能不能剩下1
     */
    public boolean isUgly(int num) {
        if(num<=0)
            return false;
        while(num%2==0) num/=2;
        while(num%3==0) num/=3;
        while(num%5==0) num/=5;
        return num==1;
    }
}
