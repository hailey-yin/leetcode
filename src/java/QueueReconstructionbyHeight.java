package java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 2/2/18.
 */
public class QueueReconstructionbyHeight {

    /*
        1. Pick out tallest people
        2. For 2nd tallest people (and the rest), insert into (S) by k value. So on and so forth.
        */
    //pick up the tallest guy first
    //when insert the next tall guy, just need to insert him into kth position
    //repeat until all people are inserted into list
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
