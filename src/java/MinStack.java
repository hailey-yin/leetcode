package java;

import java.util.Stack;

/**
 * Created by haileyyin on 4/18/18.
 */

    /*
    双堆栈
    */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(!minStack.isEmpty()){
            if(minStack.peek()>=x)
                minStack.push(x);
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        int temp1 = stack.pop();
        if(!minStack.isEmpty()&&temp1==minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/*
一个堆栈
tip：在每个min前面push上一个min
 */
class MinStack2 {
    int min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int temp = stack.pop();
        if(temp==min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}