package java;

import java.util.List;

/**
 * Created by haileyyin on 4/2/18.
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        if(nestedList.size()==0)
            return sum;
        sum = helper(nestedList, 1);
        return sum;
    }

    private int helper(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(int i=0; i<nestedList.size(); i++){
            if(nestedList.get(i).isInteger()){
                sum += nestedList.get(i).getInteger()*depth;
            } else {
                sum += helper(nestedList.get(i).getList(), depth+1);
            }
        }
        return sum;
    }
}
