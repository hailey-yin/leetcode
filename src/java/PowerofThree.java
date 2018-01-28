package java;

/**
 * Created by haileyyin on 1/26/18.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        int remainder = 0;
        if(n==0||n<0)
            return false;
        while(true){
            if(remainder!=0)
                return false;
            if(n==1)
                return true;
            remainder = n%3;
            n /= 3;
        }
    }
    /*
     without loop
     */
    public boolean isPowerOfThree2(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }
}
