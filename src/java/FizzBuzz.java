package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 2/4/18.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(i%15==0){
                res.add("FizzBuzz");
            } else if(i%3==0){
                res.add("Fizz");
            } else if(i%5==0){
                res.add("Buzz");
            } else {
                res.add(i+"");
            }
        }
        return res;
    }
}
