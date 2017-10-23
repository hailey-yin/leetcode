package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class EditDistance {
    /*
    dp: D(n,m) is defined as the edit distance between X[1…i] and Y[1…j]
    Initialization:
       D(i,0) = i
       D(0,j) = j
    Recurrence Relation:
       D(i-1,j) + 1(delete)
       D(i,j) = min
       D(i,j-1) + 1(insert)
       D(i-1,j-1) + 1(substitute)
    Desired solution: D(n,m)
     */
    public int minDistance(String word1, String word2) {
        if(word1.length()==0){
            return word2.length();
        } else if(word2.length()==0){
            return word1.length();
        }
        int size1 = word1.length();
        int size2 = word2.length();
        int[][] dp = new int[size1+1][size2+1];
        //initiate
        for(int i=0; i<=size1; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=size2; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=size1; i++){
            for(int j=1; j<=size2; j++) {
                int edit=1;
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    edit=0;
                dp[i][j]=Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1,dp[i-1][j-1]+edit));
            }
        }
        return dp[size1][size2];
    }
}
