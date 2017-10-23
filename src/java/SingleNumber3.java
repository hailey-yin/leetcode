package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haileyyin on 10/22/17.
 */
public class SingleNumber3 {
    /*
    方法一：哈希表
     */
    public int[] singleNumber1(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hmap.get(nums[i])==null){
                hmap.put(nums[i],1);
            } else {
                hmap.remove(nums[i]);
            }
        }
        int[] res = new int[hmap.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry:hmap.entrySet()){
            res[i] = entry.getKey();
            i++;
        }
        return res;
    }
    /*
    方法二：位运算
    假设两个只出现一次的数字分别是x和y，如果直接做亦或运算得到的结果是x^y，无法将它们分离。
    因为x和y不相同，因此至少有一位不相同，一个数在这一位上是1，另一个数是0。
    我们先对整个数组做亦或运算得到结果，假设第k位是1，那么x和y在k位上肯定不同。
    因此我们可以根据k位将数组分成两组，在每组里只有一个数只出现了一次，因此可以用single number1的解法。
     */
    public int[] singleNumber2(int[] nums) {
        int xorRes = 0;
        for(int i:nums){
            xorRes ^= i;
        }
        int k = 0;
        for(k=0; k<Integer.SIZE; k++){
            if(((xorRes>>k)&1)==1)
                break;
        }
        int xorRes2 = 0;
        for(int i:nums){
            if(((i>>k)&1)==1){
                xorRes2 ^= i;
            }
        }
        return new int[] {xorRes2, xorRes^xorRes2};
    }
}
