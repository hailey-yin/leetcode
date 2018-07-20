package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 7/19/18.
 */
public class DifferentWaystoAddParentheses {
    /*
   dynamic programming
   dp[i][j] represents all possible results from computing all the different possible ways to group numbers, and we use hashmap to reduce redundant computation.
   base case: dp[i][i]
   induction rule: dp[i][j] = dp[i][k-1] opt(k) dp[k+1][j] where j is every operator in the dp[i][j]
   desired result: dp[0][n-1]
   */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
}
