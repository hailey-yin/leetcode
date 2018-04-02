package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 4/1/18.
 */
public class FactorCombinations {
    /*
    12
    n     start    i      cur        res
    12      2      2       2
    6       2      2      2,2
    3       2      2
                   3      2,2,3
    0                                2,2,3
    */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<>();
        if(n<2)
            return res;
        helper(n, 2, new LinkedList<>(), res);
        return res;
    }
    private void helper(int n, int start, List<Integer> cur, List<List<Integer>> res){
        if(n<=1){
            if(cur.size()>1){
                res.add(new ArrayList<Integer>(cur));
                return;
            }
        }
        //i从start开始可以避免重复，2，2，3和2，3，2的情况不会出现
        for(int i=start; i<=n; i++){
            if(n%i==0){
                cur.add(i);
                helper(n/i, i, cur, res);
                cur.remove(cur.size()-1);
            }
        }
    }
}
