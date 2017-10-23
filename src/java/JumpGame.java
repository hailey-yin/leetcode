package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class JumpGame {
    /*
    Idea is to work backwards from the last index.
    Keep track of the smallest index that can "jump" to the last index.
    Check whether the current index can jump to this smallest index.
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last=n-1,i,j;
        for(i=n-2;i>=0;i--){
            if(i+nums[i]>=last)last=i;
        }
        return last<=0;
    }
}
