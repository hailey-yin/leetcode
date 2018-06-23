package java;

import java.util.Stack;

/**
 * Created by haileyyin on 5/12/18.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num1+num2);
            } else if (tokens[i].equals("-")) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2-num1);
            } else if (tokens[i].equals("*")) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2*num1);
            } else if (tokens[i].equals("/")) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2/num1);
            } else {
                nums.push(Integer.valueOf(tokens[i]));
            }
        }
        return nums.pop();
    }
}
