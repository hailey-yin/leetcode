package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/24/17.
 */
public class Subsets2 {
    /*
    通过变量数组used来避免重复子集和允许重复元素出现在某个子集中
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans  = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(new ArrayList<>(), nums, ans, used, 0);
        return ans;
    }

    private void backtracking(List<Integer> curr, int[] nums, List<List<Integer>> ans, boolean[] used, int start) {
        ans.add(new ArrayList<Integer>(curr));
        for(int i=start; i<nums.length; i++){
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1])
                continue;
            curr.add(nums[i]);
            used[i]=true;
            backtracking(curr, nums, ans, used, i+1);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }
}
