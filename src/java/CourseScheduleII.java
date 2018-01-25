package java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by haileyyin on 1/24/18.
 */
public class CourseScheduleII {
    /*
    Almost the same with course schedule I.
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            List<Integer> next = null;
            if(hm.containsKey(prerequisites[i][1])){
                next = hm.get(prerequisites[i][1]);
            } else {
                next = new LinkedList();
            }
            next.add(prerequisites[i][0]);
            hm.put(prerequisites[i][1], next);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        int index = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans[index++] = cur;
            if(hm.containsKey(cur)){
                List<Integer> next = hm.get(cur);
                for(int i:next){
                    indegree[i]--;
                    if(indegree[i]==0)
                        queue.offer(i);
                }
            }
        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i]!=0)
                return new int[]{};
        }
        return ans;
    }
}
