package java;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by haileyyin on 10/22/17.
 */
public class MajorityElement {
    /*
    方法一：哈希表
    时间 O(N) 空间 O(N)
     */
    public int majorityElement1(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int n = nums.length;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i:nums){
            if(hmap.get(i)==null){
                hmap.put(i,1);
            } else {
                int count = hmap.get(i);
                if (count+1>n/2){
                    return i;
                } else {
                    hmap.put(i,count+1);
                }
            }
        }
        return 0;
    }
    /*
    方法二：排序，中间的那个数一定是
    时间 O(NlogN) 空间 O(1)
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    /*
    方法三：位运算
     */
    public int majorityElement3(int[] nums) {
        int w = Integer.SIZE;
        int[] res = new int[w];
        for(int k=0; k<w; k++){
            int count=0;
            for(int i:nums){
                if(((i>>k)&1)==1){
                    count++;
                }
            }
            if(count>(nums.length/2)){
                res[k] = 1;
            } else {
                res[k] = 0;
            }
        }
        int result = 0;
        for(int i=0; i<w; i++){
            result += res[i]<<i;
        }
        return result;
    }
}
