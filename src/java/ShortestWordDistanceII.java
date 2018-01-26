package java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 1/25/18.
 */
public class ShortestWordDistanceII {
    HashMap<String, List<Integer>> hm = new HashMap<>();

    public ShortestWordDistanceII(String[] words) {
        for(int i=0; i<words.length; i++){
            List<Integer> list = null;
            if(hm.containsKey(words[i])){
                list = hm.get(words[i]);
            } else {
                list = new LinkedList<>();
            }
            list.add(i);
            hm.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = hm.get(word1);
        List<Integer> l2 = hm.get(word2);
        int idx1 = 0;
        int idx2 = 0;
        int min = Integer.MAX_VALUE;
        while(idx1<l1.size()&&idx2<l2.size()){
            min = Math.min(min, Math.abs(l1.get(idx1)-l2.get(idx2)));
            if(l1.get(idx1)<l2.get(idx2)){
                idx1++;
            } else {
                idx2++;
            }
        }
        return min;
    }
}
