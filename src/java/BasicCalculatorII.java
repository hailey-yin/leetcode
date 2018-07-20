package java;

import java.util.Stack;

/**
 * Created by haileyyin on 7/18/18.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int total = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    total = total*10 + Character.getNumericValue(s.charAt(i++));
                }
                stack1.push(sign*total);
                if (!stack2.isEmpty() && (stack2.peek() == '/' || stack2.peek() == '*')) {
                    int op1 = stack1.pop();
                    int op2 = stack1.pop();
                    int res = stack2.pop() == '/' ? op2/op1 : op1*op2;
                    stack1.push(res);
                }
                i--;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '/' || s.charAt(i) == '*') {
                sign = 1;
                stack2.push(s.charAt(i));
            }
        }
        int res = 0;
        while (!stack1.isEmpty()) {
            res += stack1.pop();
        }
        return res;
    }
}
