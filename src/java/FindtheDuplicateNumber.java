package java;

/**
 * Created by haileyyin on 4/4/18.
 */
public class FindtheDuplicateNumber {
    /*
    Time: O(n) but modified the array
    */
    public int findDuplicate(int[] nums)
    {

        while(true)
        {
            int tmp = nums[0];
            if(nums[tmp] == tmp) return tmp;
            exchange(nums, 0, tmp);
        }
    }
    public void exchange(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    /*
    Time: O(n) without modifing the array
    Space: O(1)
    */
    public int findDuplicate2(int[] nums)
    {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
