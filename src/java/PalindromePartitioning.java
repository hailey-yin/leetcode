package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/24/17.
 */
public class PalindromePartitioning {

    public List<List<String>> partition1(String s) {
        List<List<String>> ans  = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            backtracking1(new ArrayList<>(), s, 0, i, ans);
        }
        return ans;
    }

    private void backtracking1(List<String> curr, String s, int low, int high, List<List<String>> ans){
        if(isPalindrome(s, low, high)){
            curr.add(s.substring(low, high+1));
            if(high==s.length()-1){
                ans.add(new ArrayList<>(curr));
            } else {
                for(int i=high+1; i<s.length(); i++){
                    backtracking1(curr, s, high+1, i, ans);
                }
            }
            curr.remove(curr.size()-1);
        }
    }

    /*
    更标准的bt写法
     */
    public List<List<String>> partition2(String s) {
        List<List<String>> ans  = new LinkedList<>();
        backtracking2(new ArrayList<>(), s, 0, ans);
        return ans;
    }

    private void backtracking2(List<String> curr, String s, int start, List<List<String>> ans){
        if(start==s.length()){
            ans.add(new ArrayList<String>(curr));
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                curr.add(s.substring(start, i+1));
                backtracking2(curr, s, i+1, ans);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high){
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)) {
                return false;
            } else {
                low++;
                high--;
            }
        }
        return true;
    }
}
