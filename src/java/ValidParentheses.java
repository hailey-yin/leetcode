package java;

import java.util.Stack;

/**
 * Created by haileyyin on 11/13/17.
 */
public class ValidParentheses {
       /*
        time complexity: O(n)
        space complexity: O(n)
        */
    public boolean isValid(String s) {
        char[] sc = s.toCharArray();
        char[] c = {'(',')','{','}','[',']'};
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<sc.length; i++){
            if(sc[i] == c[0] || sc[i] == c[2] || sc[i] == c[4]){
                stack.push(sc[i]);
            } else if(sc[i] == c[1] && !stack.isEmpty() && stack.peek() == c[0]){
                stack.pop();
            } else if(sc[i] == c[3] && !stack.isEmpty() && stack.peek() == c[2]){
                stack.pop();
            } else if(sc[i] == c[5] && !stack.isEmpty() && stack.peek() == c[4]){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
