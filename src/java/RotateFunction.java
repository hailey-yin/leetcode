package java;

/**
 * Created by haileyyin on 3/26/18.
 */
public class RotateFunction {
    /*
    A = [4, 3, 2, 6]

    F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
    F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
    F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
    F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

    F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
    F(k-1) = 0 * Bk[1] + 1 * Bk[2] + ... + (n-1) * Bk[0].

    F(k)-F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] - (n-1) * Bk[0]
                = Bk[0] + Bk[1] + Bk[2] + ... + Bk[n-1] - nBk[0]
                = sums - nBk[0]

    F(k) = F(k-1) + sums - nBk[0]

    k = 0 :  Bk[0] = A[0]
    k = 1 :  Bk[0] = A[n-1]
    ...
    K = n-1: Bk[0] = A[1]
    */
    public int maxRotateFunction(int[] A) {
        int sums = 0;
        int len = A.length;
        int candidate = 0;
        for(int i=0; i<len; i++){
            sums += A[i];
            candidate += i*A[i];  //F[0]
        }
        int res = candidate;
        for(int i=len-1; i>0; i--){
            candidate = candidate + sums - len*A[i];
            res = Math.max(candidate, res);
        }
        return res;
    }
}
