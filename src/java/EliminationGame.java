package java;

/**
 * Created by haileyyin on 3/22/18.
 */
public class EliminationGame {
    /*
    find the mathematic law

    n=8,
    1,2,3,4,5,6,7,8
      2,  4,  6,  8
      2,      6
              6
    n=7
    1,2,3,4,5,6,7
      2,  4,  6
          4

    After each round of elimination, the step between two intergers increases by 1.

    time:  O(logn)
    space: O(1)
    */
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while(remaining>1){
            if(left || remaining%2==1){
                head += step;
            }
            step = step*2;
            remaining = remaining/2;
            left = !left;
        }
        return head;
    }
}
