package java;

/**
 * Created by haileyyin on 5/1/18.
 */
public class RotateArray {
    /*
    time: O(n) space: O(n)
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    /*
    reversal algorithm
    time: O(n) space: O(1)

                                k= 3
    original list               1 2 3 4 5 6 7
    reversing all               7 6 5 4 3 2 1
    reversing first k           5 6 7 4 3 2 1
    reversing last n-k          5 6 7 1 2 3 4 -> result
     */
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(k<=0 || n<=1)
            return;
        if(k>n)
            k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

}
