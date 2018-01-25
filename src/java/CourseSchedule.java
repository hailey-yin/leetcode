package java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by haileyyin on 1/24/18.
 */
public class CourseSchedule {
    /*
    cycle in a directed graph

    1. construct a hashmap<Integer, List<Integer>>, class number as the key and all the classes follow it form a list as the value.
    2. construct a int array to keep the indegree of each nodes.
    3. BFS: push all the nodes with 0 indegree into a queue, and delete their edges which means to decrease the indegree of their next nodes by 1.Remove them from the queue and repeat again until no node meet the requirement.

    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int[] indegree = new int[numCourses];
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
        while(!queue.isEmpty()){
            int cur = queue.poll();
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
                return false;
        }
        return true;
    }
}
