package java;

import java.util.HashSet;
import java.util.List;

/**
 * Created by haileyyin on 6/13/18.
 */
public class WordBreak {
    /*
    Dynamic Programming: "leetcode"

    M[i] represents whether the s[0...i] can be break down

    base case:
    M[0] = false;
    M[1] = true/false;  set.contains("l")

    induction rule:
    M[2] = case0 || case1;
      case0: le, set.contains("le")
      case1: l|e = M[1] && set.contains("e")
    M[3] = case0 || case1 || case2
       case0: lee, set.contains("lee")
       case1: l|ee = M[1] && set.contains("ee")
       case2: le|e = M[2] && set.contains("e")
    M[4] = case0 || case1 || case2 || case3
       case0: leet, set.contains("leet")
       case1: l|eet = M[1] && set.contains(eet")
       case2: le|et = M[2] && set.contains("et")
       case3: lee|t = M[3] && set.contains("t")
    ...

    return: M[n]
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word:wordDict) {
            set.add(word);
        }
        boolean[] res = new boolean[s.length()+1];
        for (int i = 1; i <= s.length(); i++) {
            boolean flag = set.contains(s.substring(0,i));
            for (int j = 1; j < i; j++) {
                if (flag) break;
                flag = res[j] && set.contains(s.substring(j,i)) ;
            }
            res[i] = flag;
        }
        return res[s.length()];
    }
    /*
   recursion: Time Limit exceeded
   */
    HashSet<String> set = new HashSet<>();
    public boolean wordBreak2(String s, List<String> wordDict) {
        for (String word:wordDict) {
            set.add(word);
        }
        return helper(s);
    }
    private boolean helper(String s) {
        if (s.length() == 0) {
            return true;
        }
        boolean result = false;
        for (int i = 1; i <= s.length(); i++) {
            if (!set.contains(s.substring(0,i))){
                continue;
            } else {
                result = result || helper(s.substring(i));
            }
        }
        return result;
    }
}
