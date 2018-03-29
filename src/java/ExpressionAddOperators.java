package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 3/28/18.
 */
public class ExpressionAddOperators {
    /*
    枚举，backtracking

    乘法需要做特殊处理：
    2+3*4
    (5-3)+3*4
    因为value会先计算2+3，再传到下一个
    */
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        if(num==null||num.length()==0)
            return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }
    private void helper(List<String> res, String path, String num, int target, int pos, long value, long preNum) {
        if(pos==num.length()){
            if(value==target){
                res.add(path);
                return;
            }
        }
        for(int i=pos; i<num.length(); i++){
            if(i!=pos&&num.charAt(pos)=='0')
                break;
            long cur = Long.parseLong(num.substring(pos,i+1));
            if(pos==0){
                helper(res, path+cur, num, target, i+1, cur, cur);
            } else {
                helper(res, path+"+"+cur, num, target, i+1, value+cur, cur);
                helper(res, path+"-"+cur, num, target, i+1, value-cur, -cur);
                helper(res, path+"*"+cur, num, target, i+1, value-preNum+preNum*cur, preNum*cur);
            }
        }
    }
}
