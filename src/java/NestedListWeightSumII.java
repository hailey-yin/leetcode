package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haileyyin on 7/11/18.
 */
public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int ans = 0;
        if (nestedList.size() == 0) {
            return ans;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int depth = helper(nestedList, 1, map);
        for (Map.Entry<Integer, List<Integer>> entry:map.entrySet()) {
            int dep = depth - entry.getKey() + 1;
            List<Integer> list = entry.getValue();
            for (int i:list) {
                ans = ans + i * dep;
            }
        }
        return ans;
    }

    private int helper(List<NestedInteger> nestedList, int level, HashMap<Integer, List<Integer>> map) {
        List<Integer> list = map.getOrDefault(level, new ArrayList<>());
        int depth = level;
        for (NestedInteger i:nestedList) {
            if (i.isInteger()) {
                list.add(i.getInteger());
                map.put(level, list);
            } else {
                depth = Math.max(depth, helper(i.getList(), level + 1, map));
            }
        }
        return depth;
    }
}
