package java;

import java.util.TreeSet;

/**
 * Created by haileyyin on 1/25/18.
 */
public class ContainsDuplicateIII {
    /*
     | nums[i] - nums[j] | <= t 并且 | i - j | <= k

     using slide window and BST(TreeSet)

     TreeSet数据结构（Java）使用红黑树实现，是平衡二叉树的一种。

     该数据结构支持如下操作：

     1. floor()方法返set中≤给定元素的最大元素；如果不存在这样的元素，则返回 null。

     2. ceiling()方法返回set中≥给定元素的最小元素；如果不存在这样的元素，则返回 null。
    */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            Integer floor = set.floor(nums[i]);
            Integer ceiling = set.ceiling(nums[i]);
            if ((floor != null && nums[i] <= floor + t) || (ceiling != null && nums[i] >= ceiling -t))
                return true;
            set.add(nums[i]);
            if(i>=k)
                set.remove(nums[i-k]);
        }
        return false;
    }
}
