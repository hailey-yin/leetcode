package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 6/30/18.
 */
public class CombinationSumIV {

    /*
    dynamic programming
    M[i] represents the possible combination of target i
    base case: M[0]
    induction rule: M[i] = M[i-nums[0]] + M[i-nums[1]]+ ... M[i-nums[n-1]]
    output: M[target]
    time: O(nk)
    space: O(n)
    */
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] M = new int[target+1];
        M[0] = 1;
        for (int i = 1; i <= target; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i - nums[j] >= 0) {
                    count += M[i - nums[j]];
                }
            }
            M[i] = count;
        }
        return M[target];
    }

    /*
    primitive way: recursion
    base case: remain == 0
    M[i] represents the possible combination of target i
    rucursive rule: M[i] = M[target-nums[0]] + M[target-nums[1]]+ ... M[target-nums[n-1]]
    */
    public int combinationSum42(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        helper(nums, target, new LinkedList<>(), list);
        return list.size();
    }

    private void helper(int[] nums, int remain, List<Integer> cur, List<List<Integer>> res) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            res.add(new LinkedList<Integer>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(nums, remain - nums[i], cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
