package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 11/15/17.
 */
public class PermutationSequence {
    /*
    dfs, backtracking
    Space complexity: O(1)
    time complexity in backtracking: factorial
    */

    /*
    time limit exceeded
    when n=9, k=54494
     */
    public String getPermutation1(int n, int k) {
        int[] array = new int[n+1];
        int[] used = new int[n+1];
        for(int i=1; i<=n; i++){
            array[i] = i;
        }
        List<List<Integer>> ans = new LinkedList();
        backtracking1(array, new LinkedList<Integer>(), used, ans);
        List<Integer> temp = ans.get(k-1);
        StringBuilder sb = new StringBuilder();
        for(int i:temp){
            sb.append(i);
        }
        return sb.toString();
    }

    private void backtracking1(int[] array, List<Integer> curr, int[] used, List<List<Integer>> ans){
        if(curr.size() == array.length-1){
            ans.add(new LinkedList<Integer>(curr));
        } else {
            for(int i=1; i<array.length; i++){
                if(used[i]!=1){
                    curr.add(array[i]);
                    used[i] = 1;
                    backtracking1(array, curr, used, ans);
                    used[i] = 0;
                    curr.remove(curr.size()-1);
                }
            }
        }
    }

    /*
    less space
    but still time limit exceed.
     */
    int index = 0;
    public String getPermutation2(int n, int k) {
        int[] array = new int[n+1];
        int[] used = new int[n+1];
        index = k;
        for(int i=1; i<=n; i++){
            array[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        backtracking2(array, new LinkedList<Integer>(), used,  sb);
        if(index>1)
            return "";
        return sb.toString();
    }

    private void backtracking2(int[] array, List<Integer> curr, int[] used, StringBuilder sb){
        if(curr.size() == array.length-1){
            if(index==1){
                for(int i:curr){
                    sb.append(i);
                }
            }
            index--;
        } else {
            for(int i=1; i<array.length; i++){
                if(used[i]!=1){
                    curr.add(array[i]);
                    used[i] = 1;
                    backtracking2(array, curr, used, sb);
                    used[i] = 0;
                    curr.remove(curr.size()-1);
                }
            }
        }
    }

    /*
    math way:
    对于n个字符组成的字符串{1,2,3,...,n}，取第k个数时，首先可以求出第一个数，即(k-1)/(n-1个数的排列个数)。

    比如n=3，k=4时，全排列组合为：

    1 + {2,3}的全排列
    2 + {1,3}的全排列
    3 + {1,2}的全排列

    可以一层一层的求出第k个顺序的字符串。

    时间复杂度为O(N)。
     */

    /*
    recursive
     */
    public String getPermutation(int n, int k) {
        char[] nums = new char[]{'1','2','3','4','5','6','7','8','9'};
        String s = "";
        for(int i=0;i<n;i++) {
            s += nums[i];
        }
        return fun(new StringBuffer(s), k);
    }

    public String fun(StringBuffer s, int k) {
        if(k<0 || s.toString().equals("")) return "";
        int cnt = 1, tmp = s.length()-1;
        //求阶乘，即当前位的循环周期
        while(tmp > 1) {
            cnt*=tmp;
            tmp-=1;
        }
        int pos = (k-1)/cnt;
        return s.charAt(pos) + fun(s.deleteCharAt(pos), k - pos*cnt);
    }
}
