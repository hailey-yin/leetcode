package java;

/**
 * Created by haileyyin on 11/1/17.
 */
public class UglyNumber2 {
    /*
        dp solution

        (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
        (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
        (3) 1×5, 2×5, 3×5, 4×5, 5×5, …

        k[0] = 1
        k[1] = min( k[0]x2, k[0]x3, k[0]x5) the minimum is k[0]x2
        k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on
        Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3.
         */
    public int nthUglyNumber1(int n) {
        //pointers for 2,3,5,,
        int x=0, y=0, z=0;
        int[] uns = new int[n];
        uns[0]=1;
        for(int i=1; i<n; i++){
            uns[i] = Math.min(uns[x]*2, Math.min(uns[y]*3, uns[z]*5));
            if(uns[i]==uns[x]*2) x++;
            if(uns[i]==uns[y]*3) y++;
            if(uns[i]==uns[z]*5) z++;
        }
        return uns[n-1];
    }
}
