package java;

/**
 * Created by haileyyin on 7/16/18.
 */
public class MoveZeroes {
    /*
    two pointers: slow, fast
    */
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j == nums.length) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j++;
        }
    }
}
