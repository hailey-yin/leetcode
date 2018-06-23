package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haileyyin on 6/22/18.
 */
public class SummaryRanges {
    /*
    primitive way: we walk through the input array, for each element, there are 3 possibilities:
    1. nums[i] is a head, iff
                             (1) i == 0
                             (2) nums[i-1] != nums[i] - 1
    2. nums[i] is a tail, iff
                             (1) i == n - 1
                             (2) nums[i+1] != nums[i] + 1
    3. nums[i] could be a head and tail at the same time
    4. nums[i] is within a range, otherwise

    the real problem is when we determine to add a new range into result list: whenever we encounter a head integer
    */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (isHead(nums, i)) {  //we find a head
                if (cur.size() == 1) {
                    res.add(cur.get(0)+"");
                } else if (cur.size() > 1) {
                    res.add(cur.get(0)+"->"+cur.get(cur.size()-1));
                }
                cur.clear();
                cur.add(nums[i]);
            } else {
                cur.add(nums[i]);
            }
        }
        if (cur.size() == 1) {
            res.add(cur.get(0)+"");
        } else if (cur.size() > 1) {
            res.add(cur.get(0)+"->"+cur.get(cur.size()-1));
        }
        return res;
    }
    private boolean isHead(int[] nums, int i) {
        if (i == 0 || nums[i-1] != nums[i] - 1)
            return true;
        return false;
    }
}
