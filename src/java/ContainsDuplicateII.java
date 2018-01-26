package java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by haileyyin on 1/25/18.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            List<Integer> list = null;
            if(hm.containsKey(nums[i])){
                list = hm.get(nums[i]);
                for(int j=0; j<list.size(); j++){
                    if(i-list.get(j)<=k)
                        return true;
                }
            } else {
                list = new LinkedList<>();
            }
            list.add(i);
            hm.put(nums[i], list);
        }
        return false;
    }
    /*
    update: 只用记录最近的下标位置就行
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                final int preIndex = map.get(nums[i]);
                final int gap = i - preIndex;
                min = Math.min(min, gap);
            }
            map.put(nums[i], i);
        }
        return min <= k;
    }
}
