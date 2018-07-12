package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haileyyin on 6/25/18.
 */
public class StrobogrammaticNumberII {
    /*
    1, 6, 8, 9, 0
    0 + s + 0
    1 + s + 1
    6 + s + 9
    8 + s + 8
    9 + s + 6

    permutation: recursion
    base case: n == 0
    recursion rule: M[n] = "1"+M[n-2]+"1"
                           "6"+M[n-2]+"9"
                           "9"+M[n-2]+"6"
                           "8"+M[n-2]+"8"
                           "0"+M[n-2]+"0" if not the most outer layer
    time: O(n)
    space:
    recursion tree, there are n/2 layers of node. There are 5 branches that can be generated from a single node.
    1 + 5^1 + 5^2 + ... + 5^(n/2) = O(5^(n/2)

                        root(n)
                    /   | | |  \
                 1(n-2)1 ...   0(n-2)0
                 ...                  ...
                 0          ...        0
    */
    int[] nums = {1, 6, 8, 9, 0};
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    private List<String> helper(int n, int m) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
            return res;
        }
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        List<String> sublist = helper(n-2, m);
        for (String i:sublist) {
            res.add("1"+i+"1");
            res.add("6"+i+"9");
            res.add("8"+i+"8");
            res.add("9"+i+"6");
            if (m != n) {
                res.add("0"+i+"0");
            }
        }
        return res;
    }


}
