package java;

/**
 * Created by haileyyin on 1/9/18.
 */
public class JumpGameII {
    public int jump1(int[] nums) {
        /*
        the problem can be changed to a BFS problem, through building a BFS tree by putting the indexs of all the nodes that can be accessed by i steps into depth i. The answer is the first depth that contains the last index.
        */
        if(nums.length==0 || nums[0]==0)
            return 0;
        if(nums.length==1)
            return 0;
        int curLevelStart = 0;
        int curLevelEnd = 0;
        int depth = 0;
        while(curLevelEnd!=nums.length-1){
            int nextEnd = curLevelEnd;
            for(int i=curLevelStart; i<=curLevelEnd; i++){
                if(i+nums[i]>curLevelEnd){
                    nextEnd = Math.max(i+nums[i], nextEnd);
                }
            }
            curLevelStart = curLevelEnd+1;
            curLevelEnd = nextEnd>nums.length-1?nums.length-1:nextEnd;
            depth++;
        }
        return depth;
    }

    /*
    simplify
     */
    public int jump2(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
    /*
    dp
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (j <= nums[i] && i+j < nums.length) {
                min = Math.min(min, dp[i+j]);
                j++;
            }
            if (min == Integer.MAX_VALUE)
                dp[i] = min;
            else
                dp[i] = min + 1;
        }
        return dp[0];
    }
}
