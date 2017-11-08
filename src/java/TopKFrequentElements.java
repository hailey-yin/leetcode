package java;

import java.util.*;

/**
 * Created by haileyyin on 11/7/17.
 */
public class TopKFrequentElements {
    /*
        hashmap
         */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            if(hmap.containsKey(nums[i])){
                hmap.put(nums[i], hmap.get(nums[i])+1);
            } else {
                hmap.put(nums[i], 1);
            }
        }
        for(int i=0; i<k; i++){
            int maxCount = Collections.max(hmap.values());
            for (int o : hmap.keySet()) {
                if (hmap.get(o).equals(maxCount)) {
                    res.add(o);
                    hmap.remove(o);
                    break;
                }
            }
        }
        return res;
    }

    /*
    hashmap+busket
    use an array to save numbers into different bucket whose index is the frequency
    hmap.getOrDefault(n,0)
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int n: nums){
            hmap.put(n, hmap.getOrDefault(n,0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:hmap.keySet()){
            int count = hmap.get(n);
            if(bucket[count]==null)
                bucket[count] = new LinkedList<>();
            bucket[count].add(n);
        }

        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i];
                res.addAll(list);
                k-= list.size();
            }
        }
        return res;
    }

    /*
    maxHeap: put entry into maxHeap so we can always poll a number with largest frequency
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
     */
    public List<Integer> topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int n: nums){
            hmap.put(n, hmap.getOrDefault(n,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry:hmap.entrySet()){
            maxHeap.add(entry);
        }
        List<Integer> res = new LinkedList<>();
        while(res.size()<k){
            Map.Entry<Integer,Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
