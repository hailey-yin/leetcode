package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haileyyin on 10/21/17.
 */
public class TwoSum {
    /*
    从左到右依次判断。指针指向每个数字时，判断该数字右边是否有另一个解。
    注意，不能通过判断当前数字是否小于target来排除当前数字，因为有负数存在的可能。
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = {0,0};
        for(int i=0; i<nums.length; i++){
            int first = nums[i];
            for(int j=i+1; j<nums.length; j++){
                if (nums[i]+nums[j]==target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /*
    updation
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }
}
