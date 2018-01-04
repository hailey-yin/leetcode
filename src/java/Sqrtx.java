package java;

/**
 * Created by haileyyin on 11/16/17.
 */
public class Sqrtx {
    /*
    y=sqrt(x)
    divide and conquer: each time I screen out half of the candidates.
    until I find the y that satisfies : y^2<= x < (y+1)^2
    start = 0; end = x; mid = (start+end)/2;
    */
    public int mySqrt(int x) {
        if(x<=1) return x;
        int start=0, end=x;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(x/mid==mid)
                return mid;
            else if(x/mid<mid)
                end = mid-1;
            else
                start = mid+1;
        }
        return end;
    }
}
