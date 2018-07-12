package java;

import java.util.*;

/**
 * Created by haileyyin on 7/11/18.
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();   // record adjacent nodes for each node
        int[] degree = new int[org.length]; // record indegree number for each node

        // for(int i = 1; i<=org.length; i++)
        //      map.put(i, new HashSet<>());
        //cannot init map with org, has to do with seqs, to avoid case like [1], [], expected: false

        for(List<Integer> list: seqs){
            if(list.size()==1)
                map.computeIfAbsent(list.get(0), k->new HashSet<Integer>()); //dont forget
            for(int i = 1; i<list.size(); i++){
                int pre = list.get(i-1);
                int cur = list.get(i);
                map.computeIfAbsent(pre, k->new HashSet<Integer>());
                map.computeIfAbsent(cur, k->new HashSet<Integer>());
                if(pre>org.length || cur>org.length || pre<1 || cur<1)
                    return false;
                //dont forget. or degree array can "ArrayIndexOutOfBoundsException"

                if(!map.get(pre).contains(cur)){
                    degree[cur-1]++;
                    map.get(pre).add(cur);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<degree.length; i++){
            if(degree[i]==0) q.add(i+1);
        }
        int index = 0;
        while(!q.isEmpty()){
            if(q.size()>1) return false; //check with org
            int cur = q.poll();
            if(org[index++] != cur) return false; //check with org
            if(!map.containsKey(cur)) continue; //don't forget
            for(int ii: map.get(cur)){
                degree[ii-1]--;
                if(degree[ii-1]==0) q.add(ii);
            }
        }
        return index == org.length && index==map.size();//has to check with map size
    }

    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();  // record adjacent nodes for each node
        Map<Integer, Integer> indegree = new HashMap<>();  // record indegree number for each node

        for(int[] seq: seqs) {
            if(seq.length == 1) {
                if(!map.containsKey(seq[0])) {
                    map.put(seq[0], new HashSet<>());
                    indegree.put(seq[0], 0);
                }
            } else {
                for(int i = 0; i < seq.length - 1; i++) {
                    if(!map.containsKey(seq[i])) {
                        map.put(seq[i], new HashSet<>());
                        indegree.put(seq[i], 0);
                    }

                    if(!map.containsKey(seq[i + 1])) {
                        map.put(seq[i + 1], new HashSet<>());
                        indegree.put(seq[i + 1], 0);
                    }

                    if(map.get(seq[i]).add(seq[i + 1])) {
                        indegree.put(seq[i + 1], indegree.get(seq[i + 1]) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0)
                queue.offer(entry.getKey());
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(size > 1)
                return false;
            int curr = queue.poll();
            if(index == org.length || curr != org[index++])
                return false;
            for(int next: map.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0)
                    queue.offer(next);
            }
        }
        return index == org.length && index == map.size();
    }
}
