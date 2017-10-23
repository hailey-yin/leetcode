package java;

/**
 * Created by haileyyin on 10/21/17.
 */
public class RemoveDuplicatesfromSortedArray {

    /*
    Given that it is a sorted array, the positions of each duplicated numbers must be consecutive with their duplicates in the array.
    We can create a pointer traverse the array backwards, and then we compare the number that the pointer points to with its preceding number.
    If they are the same, cover the current pointed number by the next one, and move forward all the subsequent numbers by one position.
    If not, move the pointer to the next position.
     */
    public int removeDuplicates1(int[] nums) {
        int pointer = 0;
        int length = nums.length;
        while(pointer<length-1){
            if(nums[pointer]==nums[pointer+1]) {
                int temp = nums[pointer];
                for(int i=pointer; i<nums.length-1; i++){
                    nums[i]=nums[i+1];
                }
                nums[nums.length-1]=temp;
                length--;
            } else if(nums[pointer]>nums[pointer+1]){
                break;
            } else {
                pointer++;
            }
        }

        return length;
    }

    /*
    update:
    Given that it is a sorted array, the positions of each duplicated numbers must be consecutive with their duplicates in the array.
    We can create a pointer to keep track of the array of unique numbers. As we traverse the array backwards, and then we compare each number with its preceding number.
    If they are the same, we do nothing and visit the next position.
    If not, cover the number that the pointer points at by the number we are visiting and move the pointer to the next position, and then visit the next position.
     */
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int pointer = 1;
        for(int i=1; i<n; i++){
            if(nums[i]!=nums[i-1]){
                nums[pointer++]=nums[i];
            }
        }
        return pointer;
    }
}
