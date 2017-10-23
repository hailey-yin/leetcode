package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haileyyin on 10/22/17.
 */
public class SingleNumber2 {
    /*
    方法一：哈希表
     */
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hmap.get(nums[i])==null){
                hmap.put(nums[i],1);
            } else {
                hmap.put(nums[i],hmap.get(nums[i])+1);
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
    由于x^x^x = x，无法直接利用I的方法来解。但可以应用类似的思路，即利用位运算来消除重复3次的数。以一个数组[14 14 14 9]为例，将每个数字以二进制表达：

    1110
    1110
    1110
    1001
    _____
    4331    对每一位进行求和
    1001    对每一位的和做%3运算，来消去所有重复3次的数

    问题就是如何对每一位做十进制求和？
    通过一位一位地右移和&1得到

    得到结果的二进制数组如何返回？
    通过左移相加
     */
    public int singleNumber2(int[] nums) {
        final int W = Integer.SIZE; // 一个整数的bit数，即整数字长
        int[] count = new int[W];  // count[i]表示在在i位出现的1的次数
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < W; j++) {
                count[j] += (nums[i] >> j) & 1;
                count[j] %= 3;
            }
        }
        int result = 0;
        for (int i = 0; i < W; i++) {
            result += (count[i] << i);
        }
        return result;
    }
}
