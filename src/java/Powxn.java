package java;

/**
 * Created by haileyyin on 11/14/17.
 */
public class Powxn {
    /*
    brutal force
    time limit exceed
     */
    public double myPow1(double x, int n) {
        if(n==0)
            return 1;
        int sign = 1;
        if(n<0){
            sign = -1;
            n = Math.abs(n);
        }
        double res = 1;
        for(int i=0; i<n; i++){
            res *= x;
        }
        return sign==1?res:(1/res);
    }

    /*
    recursive and binary
     */
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1.0/x;
        double tmp = myPow(x, n/2);
        if(n%2==0) {
            return tmp*tmp;
        }
        if(n>0) {
            return tmp*tmp*x;
        }
        return tmp*tmp/x;
    }
}
