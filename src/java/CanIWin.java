package java;

import java.util.HashMap;

/**
 * Created by haileyyin on 7/13/18.
 */
public class CanIWin {
    /*
    there are O(2^n) subproblems, so the complexity is O(2^n) after memorization. (Without memo, time complexity should be like O(n!)
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0)
            return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
            return false;
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal, used, new HashMap<>());
    }

    private boolean helper(int remain, boolean[] used, HashMap<Integer, Boolean> map) {
        if (remain <= 0) {
            return false;
        }
        int key = format(used);
        //avoid repeatedly solving sub-problems
        if(!map.containsKey(key)){
            for(int i = 1; i < used.length; i++){
                if(!used[i]){
                    used[i] = true;
                    // check whether this lead to a win (i.e. the other player lose)
                    if(!helper(remain-i, used, map)){
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }
    // transfer boolean[] to an Integer
    private int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}
