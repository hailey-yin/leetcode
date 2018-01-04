package java;

/**
 * Created by haileyyin on 11/28/17.
 */
public class MinimumMovestoEqualArrayElements {
    /*
    其实给n-1个数字加1，效果等同于给那个未被选中的数字减1，我们只要先找到最小值，然后累加每个数跟最小值之间的差值即可
    */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i:nums){
            min = Math.min(min,i);
        }
        int ans = 0;
        for(int i:nums){
            ans += i-min;
        }
        return ans;
    }
}
