package java;

/**
 * Created by haileyyin on 4/5/18.
 */
public class WiggleSort {
    /*
    brutal force: bubble sort then swap the even index elements
    Time: O(n^2)

    wrong case:
    [1,2,3]
    */
    public void wiggleSort(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            int min = Integer.MAX_VALUE;
            int index = i;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]<min){
                    min = nums[j];
                    index = j;
                }
            }
            if(nums[i]>min)
                swap(nums, i, index);
        }
        for(int i=1; i<nums.length/2; i=i+2){
            swap(nums, i, nums.length-i-1);
        }
    }
    /*
    偶数位置是局部低谷，奇数位置是局部高峰
    Time: O(n)
    */
    public void wiggleSort2(int[] nums) {
        for(int i=1; i<nums.length; i++){
            if(i%2==1&&nums[i]<nums[i-1]||i%2==0&&nums[i]>nums[i-1])
                swap(nums, i, i-1);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
