package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 2/6/18.
 */
public class FindAllDuplicatesinanArray {
    /*
        open extra space
        space complexity = O(n)
        Time complexity = O(n)
        */
    public List<Integer> findDuplicates(int[] nums) {
        int[] array = new int[nums.length+1];
        List<Integer> res = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            if(array[nums[i]]!=0)
                res.add(nums[i]);
            array[nums[i]]++;
        }
        return res;
    }
    /*
    in place
    when find a number i, flip the number at position i-1 to negative.
    if the number at position i-1 is already negative, i is the number that occurs twice.

    space complexity = O(1)
    Time complexity = O(n)
    */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
