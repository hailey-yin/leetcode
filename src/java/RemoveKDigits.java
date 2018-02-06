package java;

import java.util.Stack;

/**
 * Created by haileyyin on 2/6/18.
 */
public class RemoveKDigits {
    /*
    iterater through the string from left to right, k keeps track of how many character we can remove
    if the previous character in stk is larger than the current one
    then removing it will get a smaller number
    but we can only do so when k is larger than 0
    */
    public String removeKdigits(String num, int k) {
        int digit = num.length()-k;
        char[] cc = new char[num.length()];
        int curIdx = 0; //current index of the new array
        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            while(curIdx>0&&cc[curIdx-1]>c&&k>0){ //overwrite the number(remove it)
                curIdx--;
                k--;
            }
            cc[curIdx++] = c;
        }
        //find the first non-zero char
        int idx = 0;
        while(idx<digit&&cc[idx]=='0')
            idx++;
        return idx==digit?"0":new String(cc, idx, digit-idx);
    }
    /*
    using stack
    */
    public String removeKdigits2(String num, int k) {
        if(k==num.length())
            return "0";
        int digit = num.length()-k;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(!stack.isEmpty()&&stack.peek()>c&&k>0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while(k>0){
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }

}
