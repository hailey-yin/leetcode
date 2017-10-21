package java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by haileyyin on 10/21/17.
 */
public class LetterCombinationsofaPhoneNumber {

    /*
    方法一：递归，dfs

    全局变量           map

    需要传递的变量：
    题目所给的string    digits
    当前string 的状态   curr
    处理哪一位数字      index
    返回结果           ans

    递归函数的终止条件：
    index==digits.length

    时间复杂度O(3^n)，空间复杂度O(n)
     */
    final HashMap<Character, char[]> hmap = new HashMap<Character, char[]>();

    public List<String> letterCombinations1(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits.length() == 0)
            return ans;
        hmap.put('1', new char[]{});
        hmap.put('2', new char[]{'a', 'b', 'c'});
        hmap.put('3', new char[]{'d', 'e', 'f'});
        hmap.put('4', new char[]{'g', 'h', 'i'});
        hmap.put('5', new char[]{'j', 'k', 'l'});
        hmap.put('6', new char[]{'m', 'n', 'o'});
        hmap.put('7', new char[]{'p', 'q', 'r', 's'});
        hmap.put('8', new char[]{'t', 'u', 'v'});
        hmap.put('9', new char[]{'w', 'x', 'y', 'z'});
        hmap.put('0', new char[]{' '});

        helper(digits, "", 0, ans);
        return ans;
    }

    public void helper(String digits, String curr, int index, List<String> ans) {
        if (index == digits.length()) {
            ans.add(curr);
        } else {
            char[] characters = hmap.get(digits.charAt(index));
            for (char ch : characters) {
                helper(digits, curr + ch, index + 1, ans);
            }
        }
    }

    /*
    方法二：queue，bfs
     */
    public List<String> letterCombinations2(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits.length() == 0)
            return ans;
        hmap.put('1', new char[]{});
        hmap.put('2', new char[]{'a', 'b', 'c'});
        hmap.put('3', new char[]{'d', 'e', 'f'});
        hmap.put('4', new char[]{'g', 'h', 'i'});
        hmap.put('5', new char[]{'j', 'k', 'l'});
        hmap.put('6', new char[]{'m', 'n', 'o'});
        hmap.put('7', new char[]{'p', 'q', 'r', 's'});
        hmap.put('8', new char[]{'t', 'u', 'v'});
        hmap.put('9', new char[]{'w', 'x', 'y', 'z'});
        hmap.put('0', new char[]{' '});

        Queue<String> queue = new LinkedList<>();
        char[] digit = digits.toCharArray();
        for(char d:digit){
            if(queue.isEmpty()){
                for(char ch:hmap.get(d)){
                    queue.add(ch+"");
                }
            } else {
                int size = queue.size();
                for(int i=0; i<size; i++){
                    String curr = queue.poll();
                    for(char ch:hmap.get(d)){
                        queue.add(curr+ch);
                    }
                }
            }

        }
        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }
        return ans;
    }

    /*
    方法三：queue update->linkedlist
     */
    public List<String> letterCombinations3(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.length() == 0)
            return ans;
        String[] map = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ans.add("");
        for(int i=0; i<digits.length(); i++){
            int digit = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String s = ans.remove();
                for(char ch:map[digit].toCharArray()){
                    ans.add(s+ch);
                }
            }
        }
        return ans;
    }

}
