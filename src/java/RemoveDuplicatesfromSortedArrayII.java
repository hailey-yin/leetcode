package java;

/**
 * Created by haileyyin on 1/11/18.
 */
public class RemoveDuplicatesfromSortedArrayII {
    /*
    go through the numbers and include those in the result that haven’t been included twice already.
     */
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(ans<2 || nums[i]>nums[ans-2]){
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
}
