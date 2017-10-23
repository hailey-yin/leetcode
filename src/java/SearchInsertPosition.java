package java;

/**
 * Created by haileyyin on 10/21/17.
 */
public class SearchInsertPosition {
    /*
    Visit the array backwards, at each visit we compare the current numbers with the target.
    If target is smaller, return the current index; otherwise, move to the next position.
     */
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>target||nums[i]==target){
                return i;
            }
        }
        return nums.length;
    }
}
