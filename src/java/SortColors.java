package java;

/**
 * Created by haileyyin on 1/10/18.
 */
public class SortColors {
    /*
    using two pointers point from start and end as seperator, swap all the 0 to one pointer's left and swap all the 2 to another pointer's right
    Time complexity: O(n)
    Space complexity: O(1)
    */
    public int[] sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        for(int i=0; i<=end; i++){
            while(i>start && i<=end && nums[i]==0){
                swap(start, i, nums);
                start++;
                i--;
            }
            while(i<end && i>=start && nums[i]==2){
                swap(end, i, nums);
                end--;
                i--;
            }
        }
        return nums;
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
