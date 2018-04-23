package java;

import java.util.List;

/**
 * Created by haileyyin on 4/17/18.
 */
public class Triangle {
    /*
    bottom to top
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
    /*
    top to bottom
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0)
            return 0;
        int n = triangle.get(m - 1).size();
        if (n == 0)
            return 0;
        int[] dp = new int[m];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            int l = triangle.get(i).size();
            for (int k = l - 1; k >= 0; k--) {
                int curr = Math.min((k < l - 1 ? dp[k] : Integer.MAX_VALUE), (k >= 1 ? dp[k - 1]: Integer.MAX_VALUE)) + triangle.get(i).get(k);
                dp[k] = curr;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            min = Math.min(min, dp[k]);
        }
        return min;
    }
}
