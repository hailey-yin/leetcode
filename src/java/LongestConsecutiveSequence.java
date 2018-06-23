package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haileyyin on 6/13/18.
 */
public class LongestConsecutiveSequence {
    /*
    hashmap
    The key thing is to keep track of the sequence length and store that in the boundary points of the sequence.

    Whenever a new element n is inserted into the map, do two things:
    1. See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n.
    Variables left and right will be the length of those two sequences, while 0 means there is no sequence and n will be the boundary point later.
    Store (left + right + 1) as the associated value to key n into the map.
    2. Use left and right to locate the other end of the sequences to the left and right of n respectively, and replace the value with the new length.

    Everything inside the for loop is O(1) so the total time is O(n).
     */
    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }

    /*
    union-find
     */
    public int longestConsecutive2(int[] nums) {
        UF uf = new UF(nums.length);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); // <value,index>
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i],i);
            if(map.containsKey(nums[i]+1)){
                uf.union(i,map.get(nums[i]+1));
            }
            if(map.containsKey(nums[i]-1)){
                uf.union(i,map.get(nums[i]-1));
            }
        }
        return uf.maxUnion();
    }
}

class UF{
    private int[] list;
    public UF(int n){
        list = new int[n];
        for(int i=0; i<n; i++){
            list[i] = i;
        }
    }

    private int root(int i){
        while(i!=list[i]){
            list[i] = list[list[i]];
            i = list[i];
        }
        return i;
    }

    public boolean connected(int i, int j){
        return root(i) == root(j);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        list[i] = j;
    }

    // returns the maxium size of union
    public int maxUnion(){ // O(n)
        int[] count = new int[list.length];
        int max = 0;
        for(int i=0; i<list.length; i++){
            count[root(i)] ++;
            max = Math.max(max, count[root(i)]);
        }
        return max;
    }
}
