package java;

/**
 * Created by haileyyin on 5/12/18.
 */
public class ProductofArrayExceptSelf {
    /*
    dp: 将问题拆分为算出元素左边所有元素的乘积和右边所有元素的乘积，两个乘积相乘得到答案
    First, we calcuate the running product of the part before the current number.
    Second, we calculate the running product of the part after the current number through scanning from the end of the array.
    Time : O(n)
    Space: O(n)
    */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0)
            return res;
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
