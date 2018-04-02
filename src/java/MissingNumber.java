package java;

/**
 * Created by haileyyin on 3/30/18.
 */
public class MissingNumber {
    /*bit manipulation*/
    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
