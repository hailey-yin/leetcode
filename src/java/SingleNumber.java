package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haileyyin on 10/22/17.
 */
public class SingleNumber {
    /*
    方法一：哈希表
     */
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hmap.get(nums[i])==null){
                hmap.put(nums[i],1);
            } else {
                hmap.put(nums[i],2);
            }
        }
        for(Map.Entry<Integer, Integer> entry:hmap.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return 0;
    }
    /*
    方法二：位运算
    这题的终极解法是利用位运算中的异或：x^x = 0, x^0 = x。并且异或有交换律：1^1^0 = 0 = 1^0^1。所以如果将全部数字进行异或运算，所有重复元素都会被消除，最后的结果便是那个唯一的数。
    什么原理？？1^2^3^1^2的过程怎么体现出重复元素被消除
     */
    public int singleNumber2(int[] nums) {
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }
        return x;
    }

}
