package java;

/**
 * Created by haileyyin on 10/21/17.
 */
public class RemoveElement {
    /*
    We create a pointer to keep track of the new array. As we traverse the array backwards, we compare the the currently visiting number with the given value.
    If they are the same, we do nothing. If not, we cover the number that the pointer points to by the number we are visiting, and move the pointer to the next position.
     */
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]!=val){
                nums[pointer++]=nums[i];
            }
        }
        return pointer;
    }
}
