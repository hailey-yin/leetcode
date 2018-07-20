package java;

import java.util.*;

/**
 * Created by haileyyin on 7/19/18.
 */
public class TheSkylineProblem {
    /*
    https://www.youtube.com/watch?v=GSBLe8cKu0s

    break down each segment to critical points, sort them and visit one by one
    we maintain a priority queue, and a max height
    for each critial point, we put its height into a priority queue to see the max value of queue changed or not, if changed, it is a point we need.
     */
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> cp = new LinkedList<>();  //  critical points
        List<int[]> res = new LinkedList<>();
        for (int[] i : buildings) {
            cp.add(new int[]{i[0], i[2], 0});  //  start point
            cp.add(new int[]{i[1], i[2], 1});  //  end point
        }
        Collections.sort(cp, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            if (a[1] != b[1] && a[2] != b[2]) {
                return a[2] - b[2];
            }
            if (a[1] != b[1] && a[2] == b[2]) {
                if (a[2] == 0)
                    return b[1] - a[1];
                else
                    return a[1] - b[1];
            }
            if (a[1] == b[1] && a[2] != b[2]) {
                return a[2] - b[2];
            }
            return a[2] - b[2];
        });
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        queue.offer(0);
        int max = 0;
        for (int[] i : cp) {
            if (i[2] == 0) {  //  start point
                queue.offer(i[1]);
            } else {          //  end point
                queue.remove(i[1]);
            }
            int curMax = queue.peek();
            if (curMax != max) {
                max = curMax;
                res.add(new int[]{i[0], curMax});
            }
        }
        return res;
    }

    /*
    brutal force
     */
    public List<int[]> getSkyline2(int[][] buildings) {
        List<int[]> ans = new LinkedList<>();
        if (buildings.length == 0) {
            return ans;
        }
        int maxX = Integer.MIN_VALUE;
        for (int i = 0; i < buildings.length; i++) {
            maxX = Math.max(maxX, buildings[i][1]);
        }
        int[] pixel = new int[maxX+1];
        for (int i = 0; i < buildings.length; i++) {
            for (int j = buildings[i][0]; j <= buildings[i][1]; j++) {
                pixel[j] = Math.max(pixel[j], buildings[i][2]);
            }
        }
        for (int i = 1; i < maxX; i++) {
            if (pixel[i] > pixel[i-1]) {
                ans.add(new int[]{i, pixel[i]});
            } else if (pixel[i] > pixel[i+1]) {
                ans.add(new int[]{i, pixel[i+1]});
            }
        }
        ans.add(new int[]{maxX,0});
        return ans;
    }
}
