package java;

import java.util.HashSet;

/**
 * Created by haileyyin on 1/23/18.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(true){
            int temp = trans(n);
            if(temp==1)
                break;
            if(hs.contains(temp))
                return false;
            hs.add(temp);
            n = temp;
        }
        return true;
    }

    private int trans(int n){
        int sum = 0;
        while(n/10>0){
            if(n%10!=0)
                sum += Math.pow(n%10, 2);
            n = n/10;
        }
        if(n!=0)
            sum += Math.pow(n,2);
        return sum;
    }

    /*
     Floyd Cycle detection algorithm
     */
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = trans2(slow);
            fast = trans2(fast);
            fast = trans2(fast);
        } while(slow != fast);
        if (slow == 1)
            return true;
        return false;
    }

    private int trans2(int n){
        int sum = 0;
        while(n/10>0){
            if(n%10!=0)
                sum += Math.pow(n%10, 2);
            n = n/10;
        }
        if(n!=0)
            sum += Math.pow(n,2);
        return sum;
    }
}
