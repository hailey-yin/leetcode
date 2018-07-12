package java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by haileyyin on 7/10/18.
 */
public class FindKPairswithSmallestSums {
    /*
    using min-heap to maintain possible candidates
    time: O(klogk)
    */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return ans;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            ans.add(new int[]{cur[0], cur[1]});
            if (cur[2] < nums2.length - 1) {
                pq.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
            }
        }
        return ans;
    }
}
