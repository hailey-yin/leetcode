package java;

import java.util.HashMap;

/**
 * Created by haileyyin on 3/28/18.
 */
public class FlipGameII {
    /*
    backtracking
    time: T(N) = (N-2) * T(N-2) = (N-2) * (N-4) * T(N-4) ... = (N-2) * (N-4) * (N-6) * ... ~ O(N!!)
    */
    public boolean canWin(String s) {
        if(s==null||s.length()==0)
            return false;
        HashMap<String, Boolean> hm = new HashMap<>();
        return helper(s, hm);
    }

    private boolean helper(String s, HashMap<String, Boolean> hm){
        if(hm.containsKey(s))
            return hm.get(s);
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='+'&&s.charAt(i+1)=='+'){
                String next = s.substring(0,i)+"--"+s.substring(i+2);
                if(!helper(next, hm)){
                    hm.put(s,true);
                    return true;
                }
            }
        }
        return false;
    }
}
