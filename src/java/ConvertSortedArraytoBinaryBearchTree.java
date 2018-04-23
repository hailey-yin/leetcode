package java;

/**
 * Created by haileyyin on 4/17/18.
 */
public class ConvertSortedArraytoBinaryBearchTree {
    /*
    recursion, break down in the middle and the subproblem is exactly same with the original problem.
    Time: O(n)
    Space: O(n)
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int i, int j){
        if(i>j)
            return null;
        if(i==j)
            return new TreeNode(nums[i]);
        int mid = (j+i)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, i, mid-1);
        root.right = helper(nums, mid+1, j);
        return root;
    }
}
